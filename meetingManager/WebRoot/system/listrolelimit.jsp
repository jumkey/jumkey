<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>无标题文档</title>
		<link rel="stylesheet" type="text/css" href="style/styles.css" />
		<link type="text/css"
			href="css/south-street/jquery-ui-1.8.5.custom.css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.8.5.custom.min.js"></script>
		<script type="text/javascript" src="script/util.js"></script>
		<script type="text/javascript">
function doSubmit() {
	if($("#select_role").val()==0) {
		alert("请先选择角色!");
		return false;
	}
	var roleId=$("#select_role").val();
	var checkboxs=document.getElementsByTagName('input');
	var str="";
	var uncheckedstr="";
	for(var i=0, ret = [];i < checkboxs.length; i++) {
		if(checkboxs[i].type=='checkbox' && checkboxs[i].checked) {
			ret.push(checkboxs[i]);
			str+=checkboxs[i].value+",";
		} 	
	}
	var uncheckedstr="";
	for(var i=0, ret1 = [];i < checkboxs.length; i++) {
		if(checkboxs[i].type=='checkbox' && !checkboxs[i].checked) {
			ret.push(checkboxs[i]);
			uncheckedstr+=checkboxs[i].value+",";
		} 	
	}
	if(ret.length==0) {
		return false;
	}
	location.href="<%=basePath%>admin/rolelimit_list.action?roleId="+roleId+"&limitIdStr="+str+"&uncheckedstr="+uncheckedstr;
}

function roleChange(){
	var roleId=$("#select_role").val();
	location.href="<%=basePath%>admin/rolelimit_list.action?roleId="+roleId;
}

function changeWidth(){
	if(document.all) {
		$("#seach").css("width","932px");
	}	
	return false;
}

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
		$("#dialog").dialog({
			buttons:{
				"修改":function(){
					$.post('admin/jlimit_modify.action', {
						"limit.id":$("#limitid").val(),
						"limit.name":$("#name").val()
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
		$("#url").val("");
		$("#dialog").dialog({
			buttons:{
				"新增":function(){
					$.post('admin/jlimit_add.action', {
						"limit.name":$("#name").val(),
						"limit.url":$("#url").val()
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
					url: "main/jlimit_delselect.action",
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
				<div id="tabhead">
					<table>
						<tr>
							<td
								style="background: url('images/tab_03.gif') no-repeat; width: 15px"></td>
							<td>
								<span
									style="background: url('images/311.gif') no-repeat; padding-left: 17px; font-size: 14px;"
									class="STYLE4">角色权限</span>
							</td>
							<td
								style="background: url('images/tab_07.gif') no-repeat; width: 14px"></td>
						</tr>
					</table>
				</div>
				<div id="tabbody" style="width: 100%; height: 100%;">
					<div id="seach"
						style="border-left: 1px solid #B3D08F;border-right: 1px solid #B3D08F; padding-left: 20px; position: relative; left: 4px; width: 98%;">
						<div class="tabItem">
							角色:
							<select name="type" id="select_role" onchange="roleChange();" disabled="disabled">
								<option value="0">
									--请选择--
								</option>
								<s:iterator value="rlist">
									<option value="<s:property value="id" />" <s:if test="id==roleId">selected="selected"</s:if>>
										<s:property value="name" />
									</option>
								</s:iterator>
							</select>
						</div>
						<br />
						拥有权限:
						<div style="width:600px;padding-left:30px;">
							<s:iterator status="index" value="llist" id="limit">
								<div style="width:200px;float:left;">
								<s:set name="parentId" value="#limit.id"></s:set>
								<input name="checkbox" type="checkbox"
								value="${limit.id }" 
								<s:iterator value="roleLimitlist" id="rolelimit" status="index">
									${rolelimit.id}
									<s:if test="%{#parentId==limitid}">
									 checked="checked"
									</s:if>	
								</s:iterator>
								/>${limit.name}
								</div>		
							</s:iterator>
						</div>
						<div class="save" style="clear:both;padding-top:20px;">
							<input type="submit" value="保存" onclick="doSubmit();" />
							<input type="submit" value="返回" onclick="javascript:location.href='admin/role_list.action'" />
						</div>
					</div>
					<div style="width: 100%; height: 30px;">
						<table>
							<tr>
								<td
									style="background: url('images/tab_20.gif') no-repeat; width: 15px"></td>
								<td style="background: url('images/tab_21.gif');">
									<table>
										<tr>
											<td width="21%">
												<a href="javascript:selectAll();">全选</a>
												<a href="javascript:unselectAll();">全不选</a>
												<a href="javascript:fselectAll();">反选</a>
												<a href="javascript:location.reload();">刷新</a>
											</td>
										</tr>
									</table>
								</td>
								<td
									style="background: url('images/tab_22.gif') no-repeat; width: 14px;"></td>
							</tr>
						</table>
					</div>
				</div>
				<div id="dialog" class="flora">
					<form id="form1" action="/" method="post">
						<input type="hidden" name="limit.id" value="" id="limitid" />
						<br />
						名称：
						<input type="text" name="limit.name" value="" id="name" />
						<br />
						<br />
						&nbsp;Url：
						<input type="text" name="limit.url" value="" id="url" />
						<br />
					</form>
					<div id="alert"></div>
				</div>

			</div>
			<!--end tabwrap-->
	</body>
</html>
