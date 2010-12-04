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
function page(num, typeId){
	var name=$("#seach_name").val();
	if(name==undefined) {
		name="";
	}
	if(!isNaN(num)){
		location.href="<%=basePath%>main/units_list.action?page.currentPage="+num+"&unitName="+name+"&typeId="+typeId;
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
		}
	});
	//修改
	$(".edit").live("click",function(){
		var $this_=$(this);//保存当前this对象
		//设置form数据
		$("#unitsid").val($(this).parent().find("input").val());
		$("#name").val($(this).parent()[0].cells[2].innerHTML);
		$("#address").val($(this).parent()[0].cells[3].innerHTML);
		$("#zip").val($(this).parent()[0].cells[4].innerHTML);
		$("#site").val($(this).parent()[0].cells[5].innerHTML);
		$("#typeid").val($(this).parent()[0].cells[7].innerHTML);
		$("#tradetypeid").val($(this).parent()[0].cells[9].innerHTML);
		var text="";
		var count=$("#typeid option").length;
		for(var i=0;i<count;i++){
			if($("#typeid").get(0).options[i].text == text){
				$("#typeid").get(0).options[i].selected = true;
				break;
			}
		}

		$("#dialog").dialog({
			buttons:{
				"修改":function(){
					$.post('main/junits_modify.action', {
						"units.id":$("#unitsid").val(),
						"units.name":$("#name").val(),
						"units.address":$("#address").val(),
						"units.zip":$("#zip").val(),
						"units.site":$("#site").val(),
						"units.unitsType.id":$("#typeid").val(),
						"units.tradetype.id":$("#tradetypeid").val()
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
				url: "main/junits_delete.action",
				data: {
					"sysaccount.id": $this_.parent().find("input").val()
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
					url: "main/junits_delselect.action",
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
					$.post('main/junits_add.action', {
						"units.name":$("#name").val(),
						"units.address":$("#address").val(),
						"units.zip":$("#zip").val(),
						"units.site":$("#site").val(),
						"units.unitsType.id":$("#typeid").val(),
						"units.tradetype.id":$("#tradetypeid").val()
					}, function(data) {
						//alert(data);
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
});
</script>
</head>

<body onload="changeWidth();"> 
<div id="tabwrap">
<div>
    <div class="tabhead"><table>
      <tr>
        <td style="background: url('images/tab_03.gif') no-repeat; width: 15px"></td>
        <td><span style="background: url('images/311.gif') no-repeat; padding-left: 17px; font-size:14px;" class="STYLE4">单位列表</span></td>
        <td style="background: url('images/tab_07.gif') no-repeat; width: 14px"></td>
      </tr>
    </table>
    </div>
    <div id="seach" class="seach" style="border-left:1px solid #B3D08F;border-right:1px solid #B3D08F;padding-left:20px;position:relative;left:4px;width:936px;height:24px;"> 
    <form action="main/units_list.action" method="post">
	    选择类型:
	    <select name="typeId" id="select_type">
	    	<option value="0">--请选择--</option>
			<s:iterator status="index" value="tlist" id="unitsType">
			<option value="${unitsType.id}" <s:if test="id==typeId">selected="selected"</s:if>>${unitsType.typeName}</option>
			</s:iterator>
		</select>
	    单位名称:
	   <input type="text" name="unitName" id="select_name" value="${unitName}" size="7" id="seach_name"/>
	   <input type="submit" value="查询"/>
	</form>
    </div>
    <div class="tabbody" style="width: 100%;height: 100%;"><table>
      <tr>
        <td style="background: url('images/tab_12.gif'); width: 9px;">&nbsp;</td>
        <td bgcolor="e5f1d6"><table id="list" style="width: 100%;border-spacing: 1px;border-collapse: separate; background-color: #CECECE;">
          <tr class="tabTitle">
            <td width="10%">选择</td>
            <td width="10%">单位名称</td>
            <td width="10%">通讯地址</td>
            <td width="10%">邮编</td>
            <td width="10%">主页</td>
            <td width="10%">类型</td>
            <td width="10%">所属行业</td>
            <td width="10%">编辑</td>
            <!-- <td width="10%">删除</td> -->
          </tr>
          <s:iterator status="index" value="list" id="company">
          <tr class="tabItem">
            <td><input name="checkbox" type="checkbox" value="${company.id }" /></td>
            <td><a href="main/units_listuser.action?units.id=${company.id }">${company.name }</a></td>
            <td style="display:none">${company.name }</td>
            <td>${company.address }</td>
            <td>${company.zip }</td>
            <td>${company.site }</td>
            <td>${company.unitsType.typeName }</td>
            <td style="display:none">${company.unitsType.id }</td>
            <td>${company.tradetype.name }</td>
            <td style="display:none">${company.tradetype.id }</td>
            <td class="edit">[<a href="javascript:void(0);" >编辑</a>]</td>
            <!-- <td class="delete">[<a href="javascript:void(0);">删除</a>]</td> -->
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
                  <a href="javascript:page(1,${typeId});" >首页</a>
                  <a href="javascript:page(${page.currentPage-1 },${typeId});" >上一页</a>
                  <a href="javascript:page(${page.currentPage+1 },${typeId});" >下一页</a>
                  <a href="javascript:page(${page.totalPage },${typeId});" >尾页</a>
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
	<span id="add"><a href="javascript:void(0);">新增</a></span> | <a href="javascript:location.reload();">刷新</a>
</div>
<div id="dialog" class="flora">
<form id="form1" action="/" method="post">
	<input type="hidden" name="units.id" value="" id="unitsid"/><br/>
	单位名称：<input type="text" name="units.name" value="" id="name"/><br/>
	通讯地址：<input type="text" name="units.address" value="" id="address"/><br/>
	邮编：<input type="text" name="units.zip" value="" id="zip"/><br/>
	网站：<input type="text" name="units.site" value="" id="site"/><br/>
	类型：<select name="units.unitsType.id" id="typeid">
	<option value="0">--请选择--</option>
	<s:iterator status="index" value="tlist" id="unitsType">
		<option value="${unitsType.id }">${unitsType.typeName }</option>
	</s:iterator>
	</select><br />
	所属行业：<select name="units.tradetype.id" id="tradetypeid">
	<option value="0">--请选择--</option>
	<s:iterator status="index" value="ttlist" id="tradeType">
		<option value="${tradeType.id }">${tradeType.name }</option>
	</s:iterator>
	</select><br />
</form>
<div id="alert"></div>
</div>

</div><!--end tabwrap-->
</body>
</html>
