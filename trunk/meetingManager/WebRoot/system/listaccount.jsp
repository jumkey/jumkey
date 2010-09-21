<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="style/styles.css" />
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.4.custom.css" rel="stylesheet" />	
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.4.custom.min.js"></script>
<script type="text/javascript" src="script/util.js"></script>
<script type="text/javascript">
//更新表格
//rowid表格的列 html元素
//data数据
function updateTab(rowid,data){
	rowid.cells[2].innerHTML=data.sysaccount.username;
	rowid.cells[3].innerHTML=data.sysaccount.sex;
	rowid.cells[4].innerHTML=data.sysaccount.phone;
	rowid.cells[5].innerHTML=data.sysaccount.zip;
	rowid.cells[6].innerHTML=data.sysaccount.address;
}
//更新表格
//tabid表格id jquery元素
//data数据
function addRow(tabid,data){
	tabid.append('<tr class="tabItem">'
		+ '<td><input name="checkbox" type="checkbox" value="'+data.sysaccount.id+'" /></td>'
		+ '<td>'+data.sysaccount.account+'</td>'
		+ '<td>'+data.sysaccount.username+'</td>'
		+ '<td>'+data.sysaccount.sex+'</td>'
		+ '<td>'+data.sysaccount.phone+'</td>'
		+ '<td>'+data.sysaccount.zip+'</td>'
		+ '<td>'+data.sysaccount.address+'</td>'
		+ '<td>'+data.sysaccount.department+'</td>'
		+ '<td class="edit">[<a href="javascript:void(0);" >编辑</a>]</td>'
		+ '<td class="delete">[<a href="javascript:void(0);">删除</a>]</td>'
		+ '</tr>'
	);
}
//入口
$(document).ready(function(){
	//初始化dialog
	$("#dialog").dialog({
		autoOpen: false,modal: true,overlay: { opacity: 0.5, background: "black" },
		title:"编辑",position:"center",width:360,height:400,
		close: function(event, ui){
			$("#alert").hide();
			//清空form数据
			$("#form1")[0].reset();
			//$("#accountid").val("");
			//$("#username").val("");
			//$("#sex").val("");
			//$("#phone").val("");
			//$("#zip").val("");
			//$("#address").val("");
		}
	});
	//修改
	$(".edit").live("click",function(){
		var $this_=$(this);//保存当前this对象
		//设置form数据
		$("#accountid").val($(this).parent().find("input").val());
		$("#username").val($(this).parent()[0].cells[2].innerHTML);
		$("#sex").val($(this).parent()[0].cells[3].innerHTML);
		$("#phone").val($(this).parent()[0].cells[4].innerHTML);
		$("#zip").val($(this).parent()[0].cells[5].innerHTML);
		$("#address").val($(this).parent()[0].cells[6].innerHTML);

		$("#dialog").dialog({
			buttons:{
				"修改":function(){
					$.post('main/perinfo_modify.action', {
						"sysaccount.id":$("#accountid").val(),
						"sysaccount.username":$("#username").val(),
						"sysaccount.sex":$("#sex").val(),
						"sysaccount.phone":$("#phone").val(),
						"sysaccount.zip":$("#zip").val(),
						"sysaccount.address":$("#address").val()
					}, function(data) {
						//alert(data);
						var result=$.parseJSON(data.result);
						//console.dir(result);
						if(result.success!="true"){
							$("#alert").html(result.msg).show()
							.addClass("ui-state-error ui-corner-all");
						}else{
							$("#alert").html(result.msg).show()
							.addClass("ui-state-highlight ui-corner-all");
							//更新table
							updateTab($this_.parent()[0],data);
							//$("#dialog").dialog("close");
						}
					});
				}
			}
		}).dialog("open");
	});
	//删除
	$(".delete").live("click",function(){
		var $this_=$(this);//保存父this
		confirm("确认删除",function(){
			$.ajax({
				url: "main/perinfo_delete.action",
				data: {
					"sysaccount.id": $this_.parent().find("input").val()
				},
				type: "post",
				dataType: "json",
				success: function(data){
					var result=$.parseJSON(data.result);
					//console.dir(result);
					if (result.success=="true") {
						alert("删除成功！");
						//删除table列
						$this_.parent("tr").remove();
					}else {
						alert("删除失败！有部门关联或者数据不存在 刷新后操作");
					}
				}
            });
		});
	});
	//增加
	$("#add").bind("click",function(){
		$("#dialog").dialog({
			buttons:{
				"新增":function(){
					$.post('main/perinfo_add.action', {
						"sysaccount.account":$("#account").val(),
						"sysaccount.password":$("#password").val(),
						"sysaccount.username":$("#username").val(),
						"sysaccount.sex":$("#sex").val(),
						"sysaccount.phone":$("#phone").val(),
						"sysaccount.zip":$("#zip").val(),
						"sysaccount.address":$("#address").val()
					}, function(data) {
						//alert(data);
						var result=$.parseJSON(data.result);
						//console.dir(result);
						if(result.success!="true"){
							$("#alert").html(result.msg).show()
							.addClass("ui-state-error ui-corner-all");
						}else{
							$("#alert").html(result.msg).show()
							.addClass("ui-state-highlight ui-corner-all");
							//更新table 添加记录
							addRow($("#list"),data);
							//$("#dialog").dialog("close");
						}
					});
				}
			}
		}).dialog("open");
	});
	$("#delselect").click(function(){
		var selectedItems = new Array();
		$("input[@name='checkbox']:checked").each(function(){selectedItems.push($(this).val());});
		if (selectedItems.length == 0){
			alert("Please select item(s) to delete.");
		}else{
			console.dir("selected=" + selectedItems.join('&selected='));
			
			$.ajax({
				type: "POST",
				url: "main/perinfo_delselect.action",
				data: "selected=" + selectedItems.join('&selected='),
				dataType: "json",
				success: function (request) {
					//document.location.reload();
				},
				error: function(request,error){
					alert('Error deleting item(s), try again later.');
				}
			});
		}
	});
});
</script>
</head>

<body> 
<div id="tabwrap">
<div>
    <div id="tabhead"><table>
      <tr>
        <td style="background: url('images/tab_03.gif') no-repeat; width: 15px"></td>
        <td><span style="background: url('images/311.gif') no-repeat; padding-left: 17px; font-size:14px;" class="STYLE4">系统用户列表</span></td>
        <td style="background: url('images/tab_07.gif') no-repeat; width: 14px"></td>
      </tr>
    </table></div>
    <div id="tabbody" style="width: 100%;height: 100%;"><table>
      <tr>
        <td style="background: url('images/tab_12.gif'); width: 9px;">&nbsp;</td>
        <td bgcolor="e5f1d6"><table id="list" style="width: 100%;border-spacing: 1px;border-collapse: separate; background-color: #CECECE;">
          <tr class="tabTitle">
            <td width="10%">选择</td>
            <td width="10%">账户</td>
            <td width="10%">昵称</td>
            <td width="10%">性别</td>
            <td width="10%">电话</td>
            <td width="10%">邮编</td>
            <td width="10%">地址</td>
            <td width="10%">部门</td>
            <td width="10%">编辑</td>
            <td width="10%">删除</td>
          </tr>
          <s:iterator status="index" value="list" id="sysaccount1">
          <tr class="tabItem">
            <td><input name="checkbox" type="checkbox" value="${sysaccount1.id }" /></td>
            <td>${sysaccount1.account }</td>
            <td>${sysaccount1.username }</td>
            <td>${sysaccount1.sex }</td>
            <td>${sysaccount1.phone }</td>
            <td>${sysaccount1.zip }</td>
            <td>${sysaccount1.address }</td>
            <td>${sysaccount1.department.departmentname }</td>
            <td class="edit">[<a href="javascript:void(0);" >编辑</a>]</td>
            <td class="delete">[<a href="javascript:void(0);">删除</a>]</td>
          </tr></s:iterator>
        </table></td>
        <td style="background: url('images/tab_16.gif'); width: 9px;">&nbsp;</td>
      </tr>
    </table></div>
    <div style="width: 100%;height: 30px;"><table>
      <tr>
        <td style="background: url('images/tab_20.gif') no-repeat; width: 15px"></td>
        <td style="background: url('images/tab_21.gif');"><table>
          <tr>
            <td width="21%">
            	<a href="javascript:void(0);" >全选</a>
            	<a href="javascript:void(0);" >全不选</a>
            	<a href="javascript:void(0);" >反选</a>
            </td>
            <td width="79%"><div align="right">
                  <a href="javascript:void(0);" >首页</a>
                  <a href="javascript:void(0);" >上一页</a>
                  <a href="javascript:void(0);" >下一页</a>
                  <a href="javascript:void(0);" >尾页</a>
                  <span>
                  	转到第<input name="textfield" type="text" style="height:12px; width:25px;" size="5" />页
                  </span><img src="images/g_page.gif" width="14" height="14" />
            </div></td>
          </tr>
        </table></td>
        <td style="background: url('images/tab_22.gif') no-repeat; width: 14px;"></td>
      </tr>
    </table></div>
</div>
<div id="add">新增</div><div id="delselect">删除选中</div><a href="javascript:location.reload();">刷新</a>
<div id="dialog" class="flora">
<form id="form1" action="/" method="post">
	<input type="hidden" name="sysaccount.id" value="" id="accountid"/><br/>
	账号：<input type="text" name="sysaccount.account" value="" id="account"/><br/>
	密码：<input type="text" name="sysaccount.password" value="" id="password"/><br/>
	昵称：<input type="text" name="sysaccount.username" value="" id="username"/><br/>
	性别：<select name="sysaccount.sex" id="sex">
		<option value="1">男</option>
		<option value="0">女</option>
	</select><br />
	电话：<input type="text" name="sysaccount.phone" value="" id="phone"/><br/>
	邮编：<input type="text" name="sysaccount.zip" value="" id="zip"/><br/>
	地址：<input type="text" name="sysaccount.address" value="" id="address"/><br/>
	部门：<select name="sysaccount.department" id="department">
		<option value="1">人事</option>
		<option value="2">技术</option>
	</select><br />
</form>
<div id="alert"></div>
</div>
<s:debug></s:debug>
</div><!--end tabwrap-->
</body>
</html>
