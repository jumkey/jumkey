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
<link type="text/css" href="css/south-street/jquery-ui-1.8.5.custom.css" rel="stylesheet" />	
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.5.custom.min.js"></script>
<script type="text/javascript" src="script/util.js"></script>
<script type="text/javascript">
//全选
function selectAll(){
	$("input[@name='checkbox']:checkbox").each(function(){
		$(this).attr("checked",true);
	});
}
//全不选
function unselectAll(){
	$("input[@name='checkbox']:checkbox").each(function(){
		$(this).removeAttr("checked");
	});
}
//反选
function fselectAll(){
	$("input[@name='checkbox']:checkbox").each(function(){
		if($(this).attr("checked")){
			$(this).removeAttr("checked");
		}else{
			$(this).attr("checked",true);
		}
	});
}
//更新表格
//rowid表格的列 html元素
//data数据
function updateTab(rowid,data){
	rowid.cells[2].innerHTML=data.sysaccount.username;
	rowid.cells[3].innerHTML=(data.sysaccount.sex==1?"男":"女");
	rowid.cells[4].innerHTML=data.sysaccount.phone;
	rowid.cells[5].innerHTML=data.sysaccount.zip;
	rowid.cells[6].innerHTML=data.sysaccount.address;
	rowid.cells[7].innerHTML=data.sysaccount.department.departmentname;
}
//更新表格
//tabid表格id jquery元素
//data数据
function addRow(tabid,data){
	tabid.append('<tr class="tabItem">'
		+ '<td><input name="checkbox" type="checkbox" value="'+data.sysaccount.id+'" /></td>'
		+ '<td>'+data.sysaccount.account+'</td>'
		+ '<td>'+data.sysaccount.username+'</td>'
		+ '<td>'+(data.sysaccount.sex==1?"男":"女")+'</td>'
		+ '<td>'+data.sysaccount.phone+'</td>'
		+ '<td>'+data.sysaccount.zip+'</td>'
		+ '<td>'+data.sysaccount.address+'</td>'
		+ '<td>'+data.sysaccount.department.departmentname+'</td>'
		+ '<td class="edit">[<a href="javascript:void(0);" >编辑</a>]</td>'
		+ '<td class="delete">[<a href="javascript:void(0);">删除</a>]</td>'
		+ '</tr>'
	);
}

//分页
function page(num){
	if(!isNaN(num)){
		location.href="<%=basePath%>admin/limit_list.action?page.currentPage="+num;
	}
}
function gopage(){
	if(isNaN($("#gogo").val())){
		alert("请输入数字");
	}else{
		page($("#gogo").val());
	}
}
//入口
$(document).ready(function(){
	var selectedItems;//批量删除用
	//初始化dialog
	$("#dialog").dialog({
		autoOpen: false,modal: true,overlay: { opacity: 0.5, background: "black" },
		title:"编辑",position:"center",width:300,height:200,
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
		$("#limitid").val($(this).parent()[0].cells[1].innerHTML);
		$("#name").val($(this).parent()[0].cells[2].innerHTML);
		$("#code").val($(this).parent()[0].cells[3].innerHTML);
		$("#dialog").dialog({
			buttons:{
				"修改":function(){
					$.post('admin/jlimit_modify.action', {
						"limit.id":$("#limitid").val(),
						"limit.name":$("#name").val(),
						"limit.code":$("#code").val()
					}, function(data) {
						
						var result=$.parseJSON(data.result);
						if(result.success!="true"){
							$("#alert").html(result.msg).show()
							.addClass("ui-state-error ui-corner-all");
						}else{
							$("#alert").html(result.msg).show()
							.addClass("ui-state-highlight ui-corner-all");
							//更新table
							// updateTab($this_.parent()[0],data);
							$("#dialog").dialog("close");
							location.reload();
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
				url: "admin/jlimit_delete.action",
				data: {
					"limit.id": $this_.parent().find("input").val()
				},
				type: "post",
				dataType: "json",
				success: function(data){
					var result=$.parseJSON(data.result);
					if (result.success=="true") {
						//删除table列
						$this_.parent("tr").remove();
					}else {
						alert("删除失败!");
					}
				}
            });
		});
	});
	//增加
	$("#add").bind("click",function(){
		$("#limitid").val("");
		$("#name").val("");
		$("#code").val("");
		$("#dialog").dialog({
			buttons:{
				"新增":function(){
					$.post('admin/jlimit_add.action', {
						"limit.name":$("#name").val(),
						"limit.code":$("#code").val()
					}, function(data) {
						var result=$.parseJSON(data.result);
						if(result.success!="true"){
							$("#alert").html(result.msg).show()
							.addClass("ui-state-error ui-corner-all");
						}else{
							$("#alert").html(result.msg).show()
							.addClass("ui-state-highlight ui-corner-all");
							$("#dialog").dialog("close");
							location.reload();
						}
					});
				}
			}
		}).dialog("open");
	});
	$("#delselect").click(function(){
		selectedItems = new Array();//只能定义全局变量，否则进入confirm后值会变为第一次设置的值（不知道原因）
		$("input[@name='checkbox']:checked").each(function(){selectedItems.push($(this).val());});
		if (selectedItems.length == 0){
			alert("请选择要删除的行");
		}else{
			confirm("确认删除",function(){
				$.ajax({
					type: "POST",
					url: "admin/jlimit_delselect.action",
					data: "selected=" + selectedItems.join('&selected='),
					dataType: "json",
					success: function (data) {
						//alert(data);
						var result=$.parseJSON(data.result);
						if(result.success!="true"){
							alert(result.msg);
						}else{
							//更新table 删除记录
							$("input[@name='checkbox']:checked").parent().parent("tr").remove();
							alert(result.msg);
						}
					}
				});
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
        <td><span style="background: url('images/311.gif') no-repeat; padding-left: 17px; font-size:14px;" class="STYLE4">权限管理</span></td>
        <td style="background: url('images/tab_07.gif') no-repeat; width: 14px"></td>
      </tr>
    </table></div>
    <div id="tabbody" style="width: 100%;height: 100%;"><table>
      <tr>
        <td style="background: url('images/tab_12.gif'); width: 9px;">&nbsp;</td>
        <td bgcolor="e5f1d6"><table id="list" style="width: 100%;border-spacing: 1px;border-collapse: separate; background-color: #CECECE;">
          <tr class="tabTitle">
            <td width="10%">选择</td>
            <td width="10%">编号</td>
            <td width="10%">名称</td>
            <td width="10%">code</td>
            <td width="10%">创建时间</td>
            <td width="10%">编辑</td>
            <td width="10%">删除</td>
          </tr>
          <s:iterator status="index" value="list" id="limit">
          <tr class="tabItem">
            <td><input name="checkbox" type="checkbox" value="${limit.id }" /></td>
            <td>${limit.id }</td>
            <td>${limit.name }</td>
             <td>${limit.code }</td>
            <td>${limit.createtime }</td>
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
            	<a href="javascript:selectAll();" >全选</a>
            	<a href="javascript:unselectAll();" >全不选</a>
            	<a href="javascript:fselectAll();" >反选</a>
            </td>
            <td width="79%"><div align="right">
                  <a href="javascript:page(1);" >首页</a>
                  <a href="javascript:page(${page.currentPage-1 });" >上一页</a>
                  <a href="javascript:page(${page.currentPage+1 });" >下一页</a>
                  <a href="javascript:page(${page.totalPage });" >尾页</a>
                  <span>
                  	转到第<input id="gogo" name="textfield" type="text" style="height:12px; width:25px;" size="5" />页
                  </span><a href="javascript:gopage();" ><img src="images/g_page.gif" width="14" height="14" /></a>
            </div></td>
          </tr>
        </table></td>
        <td style="background: url('images/tab_22.gif') no-repeat; width: 14px;"></td>
      </tr>
    </table></div>
</div>
<div id="op" style="padding-left: 20px;">
	<span id="add"><a href="javascript:void(0);">新增</a></span> | <span id="delselect"><a href="javascript:void(0);">删除选中</a></span> | <a href="javascript:location.reload();">刷新</a>
</div>
<div id="dialog" class="flora">
<form id="form1" action="/" method="post">
	<input type="hidden" name="limit.id" value="" id="limitid"/><br/>
	名称：<input type="text" name="limit.name" value="" id="name"/><br/>
	<br/>
	&nbsp;code： <input type="text" name="limit.code" value="" id="code"/><br/>
</form>
<div id="alert"></div>
</div>

</div><!--end tabwrap-->
</body>
</html>
