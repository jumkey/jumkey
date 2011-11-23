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
function page(num, unitsId){
	var name=$("#seach_name").val();
	if(name==undefined) {
		name="";
	}
	if(!isNaN(num)){
		location.href="<%=basePath%>main/user_list.action?page.currentPage="+num+"&name="+name+"&unitsId="+unitsId;
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
		title:"编辑",position:"center",width:300,height:380,
		close: function(event, ui){
			$("#alert").hide();
			//清空form数据
			$("#form1")[0].reset();
		}
	});
	//修改
	$(".edit").live("click",function(){
		var $this_=$(this);//保存当前this对象
		//设置form数据
		$("#userid").val($(this).parent().find("input").val());
		$("#name").val($(this).parent()[0].cells[1].innerHTML);
		var sex=$(this).parent()[0].cells[2].innerText;
		if(sex=="男"){
			$("#sex").val("1");
		}else{
			$("#sex").val("0");
		}
		$("#unitsid").val($(this).parent()[0].cells[4].innerHTML);
		$("#zwu").val($(this).parent()[0].cells[3].innerHTML);
		$("#phone").val($(this).parent()[0].cells[7].innerHTML);
		$("#cellphone").val($(this).parent()[0].cells[8].innerHTML);
		$("#fax").val($(this).parent()[0].cells[9].innerHTML);
		$("#mail").val($(this).parent()[0].cells[11].innerHTML);
		$("#dialog").dialog({
			buttons:{
				"修改":function(){
					$.post('main/juser_modify.action', {
						"user.id":$("#userid").val(),
						"user.name":$("#name").val(),
						"user.sex":$("#sex").val(),
						"user.units.id":$("#unitsid").val(),
						"user.zwu":$("#zwu").val(),
						"user.phone":$("#phone").val(),
						"user.cellphone":$("#cellphone").val(),
						"user.fax":$("#fax").val(),
						"user.mail":$("#mail").val()
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
	$("#sendnotice").click(function(){
		selectedItems = new Array();//只能定义全局变量，否则进入confirm后值会变为第一次设置的值（不知道原因）
		$("input[name='checkbox']:checked").each(function(){selectedItems.push($(this).val());});
		
		if (selectedItems.length == 0){
			alert("请选择要发送的人");
		}else{
			confirm("确认发送",function(){
				
				$.ajax({
					type: "POST",
					url: "main/jnotice_dosend.action",
					data: "selected=" + selectedItems.join("&selected=")+"&notice.id=${notice.id }",
					dataType: "json",
					success: function (data) {
						//alert(data);
						var result=$.parseJSON(data.result);
						
						if(result.success!="true"){
							alert(result.msg);
						}else{
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
									class="STYLE4">个人用户列表</span>
							</td>
							<td
								style="background: url('images/tab_07.gif') no-repeat; width: 14px"></td>
						</tr>
					</table>
				</div>
				<div id="seach" class="seach"
					style="border-left: 1px solid #B3D08F; border-right: 1px solid #B3D08F; padding-left: 20px; position: relative; left: 4px; width: 936px; height: 24px;">
					<form method="post" action="main/user_list.action">
						所属单位:
						<select name="unitsId">
							<option value="0">
								--请选择--
							</option>
							<s:iterator value="unitslist">
								<option value="<s:property value="id"/>"
									<s:if test="id==unitsId">selected="selected"</s:if>>
									<s:property value="name" />
								</option>
							</s:iterator>
						</select>
						姓名:
						<input type="text" name="name" size="8" value="${name}"
							id="seach_name" />
						<input type="submit" value="查询" />
					</form>
				</div>
				<div id="tabbody" style="width: 100%; height: 100%;">
					<table>
						<tr>
							<td style="background: url('images/tab_12.gif'); width: 9px;">&nbsp;</td>
							<td bgcolor="e5f1d6"><table id="list" style="width: 100%; border-spacing: 1px; border-collapse: separate; background-color: #CECECE;">
									<tr class="tabTitle">
										<td width="4%">选择</td>
										<td width="7%">姓名</td>
										<td width="7%">性别</td>
										<td width="6%">职务职称</td>
										<td width="7%">单位名称</td>
										<td width="7%">邮编</td>
										<td width="7%">座机</td>
										<td width="7%">手机号</td>
										<td width="7%">传真</td>
										<td width="7%">通讯地址</td>
										<td width="7%">邮箱</td>
										<td width="8%">编辑</td>
									</tr>
									<s:iterator status="index" value="list" id="user1">
										<tr class="tabItem">
											<td><input name="checkbox" type="checkbox" value="${user1.id }" /></td>
											<td>${user1.name }</td>
											<td>${user1.sex==1?"男":"女"}</td>
											<td>${user1.zwu }</td>
											<td style="display:none">${user1.units.id }</td>
											<td>${user1.units.name }</td>
											<td>${user1.units.zip }</td>
											<td>${user1.phone }</td>
											<td>${user1.cellphone }</td>
											<td>${user1.fax }</td>
											<td>${user1.units.address }</td>
											<td>${user1.mail }</td>
											<td class="edit">[<a href="javascript:void(0);">编辑</a>]</td>
										</tr>
									</s:iterator>
								</table>
							</td>
							<td style="background: url('images/tab_16.gif'); width: 9px;">&nbsp;</td>
						</tr>
					</table>
				</div>
				<div style="width: 100%; height: 30px;">
					<table>
						<tr>
							<td style="background: url('images/tab_20.gif') no-repeat; width: 15px"></td>
							<td style="background: url('images/tab_21.gif');">
								<table>
									<tr>
										<td width="21%">
											<a href="javascript:selectAll();">全选</a>
											<a href="javascript:unselectAll();">全不选</a>
											<a href="javascript:fselectAll();">反选</a>
										</td>
										<td width="79%">
											<div align="right">
												<a href="javascript:page(1, ${unitsId});">首页</a>
												<a
													href="javascript:page(${page.currentPage-1 }, ${unitsId});">上一页</a>
												<a
													href="javascript:page(${page.currentPage+1 }, ${unitsId});">下一页</a>
												<a href="javascript:page(${page.totalPage }, ${unitsId});">尾页</a>
												<span> 转到第<input id="gogo" name="textfield"
														type="text" style="height: 12px; width: 25px;" size="5" />页
												</span><a href="javascript:gopage();"><img
														src="images/g_page.gif" width="14" height="14" />
												</a>
											</div>
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
			<div id="op" style="padding-left: 20px;">
				<a href="javascript:location.reload();">刷新</a>
			</div>
			<div id="dialog" class="flora">
				<form id="form1" action="/" method="post">
					<input type="hidden" name="user.id" value="" id="userid" />
					<br />
					姓名：
					<input type="text" name="user.name" value="" id="name" />
					<br />
					性别：
					<select name="user.sex" id="sex">
						<option value="-1">--请选择--</option>
						<option value="1">
							男
						</option>
						<option value="0">
							女
						</option>
					</select>
					<br />
					职务：
					<input type="text" name="user.zwu" value="" id="zwu" />
					<br />
					单位：
					<select name="units.id" id="unitsid">
						<option value="0">--请选择--</option>
						<s:iterator value="unitslist">
							<option value="<s:property value="id"/>"><s:property value="name"/></option>
						</s:iterator>
					</select>
					<br />
					座机：
					<input type="text" name="user.phone" value="" id="phone" /><br />
					手机：
					<input type="text" name="user.cellphone" value="" id="cellphone" /><br />
					传真：
					<input type="text" name="user.fax" value="" id="fax" /><br />
					邮箱：
					<input type="text" name="user.fax" value="" id="mail" /><br />
				</form>
				<div id="alert"></div>
			</div>

		</div>
		<!--end tabwrap-->
	</body>
</html>
