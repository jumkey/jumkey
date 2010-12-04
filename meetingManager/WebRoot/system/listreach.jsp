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
		location.href="<%=basePath%>main/pinfo_list.action?page.currentPage="+num;
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
		$("#userid").val($(this).parent().find("input").val());
		$("#name").val($(this).parent()[0].cells[1].innerHTML);
		$("#usertype").val($(this).parent()[0].cells[2].innerHTML);
		$("#unitsname").html($(this).parent()[0].cells[3].innerHTML);
		$("#username").html($(this).parent()[0].cells[4].innerHTML);
		var sex=$(this).parent()[0].cells[5].innerText;
		if(sex=="男"){
			$("#sex").get(0).selectedIndex=0;
		}else{
			$("#sex").get(0).selectedIndex=1;
		}
		$("#phone").val($(this).parent()[0].cells[6].innerHTML);
		$("#mail").val($(this).parent()[0].cells[7].innerHTML);
		$("#cellphone").val($(this).parent()[0].cells[8].innerHTML);
		$("#address").val($(this).parent()[0].cells[9].innerHTML);
		$("#zip").val($(this).parent()[0].cells[10].innerHTML);
		$("#zwu").val($(this).parent()[0].cells[12].innerHTML);

		$("#dialog").dialog({
			buttons:{
				"修改":function(){
					$.post('main/juser_modify.action', {
						"user.id":$("#userid").val(),
						"user.name":$("#name").val(),
						"user.usertype":$("#usertype").val(),
						"user.sex":$("#sex").val(),
						"user.phone":$("#phone").val(),
						"user.mail":$("#mail").val(),
						"user.cellphone":$("#cellphone").val(),
						"user.address":$("#address").val(),
						"user.zip":$("#zip").val(),
						"user.zwu":$("#zwu").val()
					}, function(data) {
						
						var result=$.parseJSON(data.result);
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
				url: "main/juser_delete.action",
				data: {
					"user.id": $this_.parent().find("input").val()
				},
				type: "post",
				dataType: "json",
				success: function(data){
					var result=$.parseJSON(data.result);
					
					if (result.success=="true") {
						alert(result.msg);
						//删除table列
						$this_.parent("tr").remove();
					}else {
						alert("删除失败！有部门关联或者数据不存在 刷新后操作");
					}
				}
            });
		});
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
					url: "main/juser_delselect.action",
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
	//增加
	$("#add").bind("click",function(){
		$("#dialog").dialog({
			buttons:{
				"新增":function(){
					$.post('main/juser_add.action', {
						"user.name":$("#name").val(),
						"user.usertype":$("#usertype").val(),
						"user.units.name":$("#unitsname").val(),
						"user.user.name":$("#username").val(),
						"user.sex":$("#sex").val(),
						"user.phone":$("#phone").val(),
						"user.mail":$("#mail").val(),
						"user.cellphone":$("#cellphone").val(),
						"user.address":$("#address").val(),
						"user.zip":$("#zip").val(),
						"user.zwu":$("#zwu").val()
					}, function(data) {
						//alert(data);
						var result=$.parseJSON(data.result);
						
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
});
</script>
</head>

<body> 
<div id="tabwrap"><a class="ui-state-default" href="javascript:history.back();">返回</a><br />
<a href="main/reach_shoufei.action?meetinginfo.id=${meetinginfo.id }">收费处</a>|
<a href="main/reach_zhusu.action?meetinginfo.id=${meetinginfo.id }">住宿处</a>|
<a href="main/reach_baodao.action?meetinginfo.id=${meetinginfo.id }">报到处</a><br />
<div>
    <div class="tabhead"><table>
      <tr>
        <td style="background: url('images/tab_03.gif') no-repeat; width: 15px"></td>
        <td><span style="background: url('images/311.gif') no-repeat; padding-left: 17px; font-size:14px;" class="STYLE4">已报到人员列表</span></td>
        <td style="background: url('images/tab_07.gif') no-repeat; width: 14px"></td>
      </tr>
    </table></div>
    <div class="tabbody" style="width: 100%;height: 100%;"><table>
      <tr>
        <td style="background: url('images/tab_12.gif'); width: 9px;">&nbsp;</td>
        <td bgcolor="e5f1d6"><table id="slist" style="width: 100%;border-spacing: 1px;border-collapse: separate; background-color: #CECECE;">
          <tr class="tabTitle">
          	<td width="4%">编号</td>
          	<td width="4%">选项</td>
            <td width="4%">姓名</td>
            <td width="4%">谁的亲属</td>
            <td width="4%">所属单位</td>
            <td width="4%">是否缴费</td>
            <td width="4%">是否已开收据</td>
            <td width="4%">房间号</td>
            <td width="4%">房间类型</td>
            <td width="4%">是否回执</td>
            <td width="4%">是否有讲座</td>
          </tr>
          <s:iterator status="index" value="reachs" id="reach">
          <tr class="tabItem">
          	<td>${reach.register.user.id }</td>
            <td>${reach.register.user.name }</td>
            <td>${reach.register.user.name }</td>
            <td>${reach.register.user.name }</td>
            <td>${reach.register.user.units.name }</td>
            <td>${reach.register.user.units.name }</td>
            <td>${reach.register.user.units.name }</td>
            <td>${reach.snp.housenumber }</td>
            <td>roomtype</td>
            <td>huizhi</td>
            <td>${reach.register.id }</td>
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
            <td width="21%">&nbsp;</td>
            <td width="79%">&nbsp;</td>
          </tr>
        </table></td>
        <td style="background: url('images/tab_22.gif') no-repeat; width: 14px;"></td>
      </tr>
    </table></div>
</div>
<div id="op" style="padding-left: 20px;">
	<a href="javascript:location.reload();">刷新</a>
</div>
<div id="dialog" class="flora">
<form id="form1" action="/" method="post">
	<input type="hidden" name="user.id" value="" id="userid"/><br/>
	姓名：<input type="text" name="user.name" value="" id="name"/><br/>
	类型：<input type="text" name="user.usertype" value="" id="usertype"/><br/>
	单位：<span id="unitsname"></span><br/>
	谁的家属：<span id="username"></span><br/>
	性别：<select name="user.sex" id="sex">
		<option value="1">男</option>
		<option value="0">女</option>
	</select><br />
	电话：<input type="text" name="user.phone" value="" id="phone"/><br/>
	邮件：<input type="text" name="user.mail" value="" id="mail"/><br/>
	手机：<input type="text" name="user.cellphone" value="" id="cellphone"/><br/>
	住址：<input type="text" name="user.address" value="" id="address"/><br/>
	邮编：<input type="text" name="user.zip" value="" id="zip"/><br/>
	职务：<input type="text" name="user.zwu" value="" id="zwu"/><br/>
</form>
<div id="alert"></div>
</div>

</div><!--end tabwrap-->
</body>
</html>
