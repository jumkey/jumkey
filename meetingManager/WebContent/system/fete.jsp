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
<script type="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="script/util.js"></script>
<script type="text/javascript" src="script/jquery.ui.datetimepicker.js"></script>
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
	rowid.cells[1].innerHTML=data.price.price;
	rowid.cells[3].innerHTML=data.price.date;
	rowid.cells[4].innerHTML=data.price.address;
	rowid.cells[5].innerHTML=data.price.hotel;
}
//更新表格
//tabid表格id jquery元素
//data数据
function addRow(tabid,data){
	tabid.append('<tr class="tabItem">'
		+ '<td><input name="checkbox" type="checkbox" value="'+data.price.id+'" /></td>'
		+ '<td>'+data.price.price+'</td>'
		+ '<td>'+data.price.units.name+'</td>'
		+ '<td>'+data.price.date+'</td>'
		+ '<td>'+data.price.address+'</td>'
		+ '<td>'+data.price.hotel+'</td>'
		+ '<td class="edit">[<a href="javascript:void(0);" >编辑</a>]</td>'
		+ '<td class="delete">[<a href="javascript:void(0);">删除</a>]</td>'
		+ '</tr>'
	);
}

//分页
function page(num, meetinginfoid){
	if(!isNaN(num)){
		location.href="<%=basePath%>main/fete_list.action?page.currentPage="+num+"&meetinginfo.id="+meetinginfoid;
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
	//日期时间
	$("#date").datepicker({
		//changeMonth: true, changeYear: true,
		dateFormat:'yy-mm-dd',minDate: 0, maxDate: '+2y'
	}).datepicker($.datepicker.regional["zh-CN"]);
	var selectedItems;//批量删除用
	//初始化dialog
	$("#dialog").dialog({
		autoOpen: false,modal: true,overlay: { opacity: 0.5, background: "black" },
		title:"编辑",position:"center",width:300,height:380,
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
		$("#feteid").val($(this).parent().find("input").val());
		$("#date").val($(this).parent()[0].cells[2].innerHTML);
		$("#address").val($(this).parent()[0].cells[3].innerHTML);
		$("#cost").val($(this).parent()[0].cells[4].innerHTML);
		$("#number").val($(this).parent()[0].cells[5].innerHTML);
		$("#desknumber").val($(this).parent()[0].cells[6].innerHTML);
		$("#unitprice").val($(this).parent()[0].cells[7].innerHTML);
		$("#othercost").val($(this).parent()[0].cells[8].innerHTML);
		$("#outlays").val($(this).parent()[0].cells[9].innerHTML);
		$("#unitsid").val($(this).parent()[0].cells[10].innerHTML);
		$("#dialog").dialog({
			buttons:{
				"修改":function(){
					$.post('main/dofete_modify.action', {
						"fete.id":$("#feteid").val(),
						"fete.date":$("#date").val()+":00",
						"fete.address":$("#address").val(),
						"fete.cost":$("#cost").val(),
						"fete.number":$("#number").val(),
						"fete.desknumber":$("#desknumber").val(),
						"fete.unitprice":$("#unitprice").val(),
						"fete.othercost":$("#othercost").val(),
						"fete.units.id":$("#unitsid").val(),
						"fete.outlays":$("#outlays").val()
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
				url: "main/dofete_delete.action",
				data: {
					"fete.id": $this_.parent().find("input").val()
				},
				type: "post",
				dataType: "json",
				success: function(data){
					var result=$.parseJSON(data.result);
					
					if (result.success=="true") {
						alert(result.msg);
						//删除table列
						location.reload();
						
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
					$.post('main/dofete_add.action', {
						"fete.meetingInfo.id":${meetinginfo.id },
						"fete.address":$("#address").val(),
						"fete.date":$("#date").val()+":00",
						"fete.cost":$("#cost").val(),
						"fete.number":$("#number").val(),
						"fete.desknumber":$("#desknumber").val(),
						"fete.unitprice":$("#unitprice").val(),
						"fete.othercost":$("#othercost").val(),
						"fete.units.id":$("#unitsid").val(),
						"fete.outlays":$("#outlays").val()
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
							location.reload();
							//$("#dialog").dialog("close");
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
					url: "main/dofete_delselect.action",
					data: "selected=" + selectedItems.join('&selected='),
					dataType: "json",
					success: function (data) {
						var result=$.parseJSON(data.result);
						
						if(result.success!="true"){
							alert(result.msg);
							
						}else{
							//更新table 删除记录
							location.reload();
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
<div id="tabwrap"><a class="ui-state-default" href="javascript:history.back();">返回</a>
<div>
    <div id="tabhead"><table>
      <tr>
        <td style="background: url('images/tab_03.gif') no-repeat; width: 15px"></td>
        <td><span style="background: url('images/311.gif') no-repeat; padding-left: 17px; font-size:14px;" class="STYLE4">宴请列表</span></td>
        <td style="background: url('images/tab_07.gif') no-repeat; width: 14px"></td>
      </tr>
    </table></div>
    <div id="tabbody" style="width: 100%;height: 100%;"><table>
      <tr>
        <td style="background: url('images/tab_12.gif'); width: 9px;">&nbsp;</td>
        <td bgcolor="e5f1d6"><table id="list" style="width: 100%;border-spacing: 1px;border-collapse: separate; background-color: #CECECE;">
          <tr class="tabTitle">
            <td width="4%">选择</td>
            <td width="6%">编号</td>
            <!-- <td width="12%">会议标题</td> -->
            <td width="10%">宴请时间</td>
            <td width="20%">宴请地址</td>
            <td width="10%">宴请总费</td>
            <td width="7%">宴请人数</td>
            <td width="10%">主办方</td>
            <td width="10%">管理</td>
            <td width="10%">编辑</td>
            <td width="10%">删除</td>
          </tr>
          <s:iterator status="index" value="list" id="fete">
          <tr class="tabItem">
            <td><input name="checkbox" type="checkbox" value="${fete.id }" /></td>
            <td>${fete.id }</td>
            <!-- <td>${fete.meetingInfo.title }</td> -->
            <td><s:date name="#fete.date" format="yyyy-MM-dd" /></td>
            <td>${fete.address }</td>
            <td>${fete.cost }元</td>
            <td>${fete.number }人</td>
            <td style="display:none">${fete.desknumber }</td>
            <td style="display:none">${fete.unitprice }</td>
            <td style="display:none">${fete.othercost }</td>
            <td style="display:none">${fete.outlays }</td>
            <td style="display:none">${fete.units.id }</td>
            <td>${fete.units.name }</td>
            <td class="manage">[<a href="main/feterecord_list.action?id=${fete.id }">管理</a>]</td>
            <td class="edit">[<a href="javascript:void(0);" >编辑</a>]</td>
            <td class="delete">[<a href="javascript:void(0);">删除</a>]</td>
          </tr>
          </s:iterator>
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
                  <a href="javascript:page(1,${meetinginfo.id });" >首页</a>
                  <a href="javascript:page(${page.currentPage-1 },${meetinginfo.id });" >上一页</a>
                  <a href="javascript:page(${page.currentPage+1 },${meetinginfo.id });" >下一页</a>
                  <a href="javascript:page(${page.totalPage },${meetinginfo.id });" >尾页</a>
                  <span>
                  	转到第<input id="gogo" name="textfield" type="text" style="height:12px; width:25px;" size="5" />页
                  </span><a href="javascript:gopage();" ><img src="images/g_page.gif" width="14" height="14" /></a>
            </div></td>
          </tr>
        </table></td>
        <td style="background: url('images/tab_22.gif') no-repeat; width: 14px;">al</td>
      </tr>
    </table></div>
</div>
<div id="op" style="padding-left: 20px;">
	<span id="add"><a href="javascript:void(0);">新增</a></span> | <!-- <span id="delselect"><a href="javascript:void(0);">删除选中</a></span> |  --><a href="javascript:location.reload();">刷新</a> 
</div>
<script type="text/javascript">

</script>
<div id="dialog" class="flora">
<form id="form1" name="form1" method="post" action="">
	<input type="hidden" name="fete.id" value="" id="feteid"/><br/>
	<label for="address">宴请地点</label>
	<input type="text" name="fete.address" id="address" /><br />
	<label for="date">宴请时间</label>
	<input type="text" name="fete.date" id="date" class="time" /><br />
	<label for="cost">宴请总费</label>
	<input type="text" name="fete.cost" id="cost" />元<br />
	<label for="number">宴请人数</label>
	<input type="text" name="fete.number" id="number" />人<br />
	<label for="desknumber">&nbsp;&nbsp;&nbsp;&nbsp;桌数</label>
	<input type="text" name="fete.desknumber" id="desknumber" /><br />
	<label for="unitprice">每桌单价</label>
	<input type="text" name="fete.unitprice" id="unitprice" />元<br />
	<label for="othercost">酒水费用</label>
	<input type="text" name="fete.othercost" id="othercost" />元<br />
	<label for="unitsid">主办方</label>
	<select name="" id="unitsid">
		<option value="0">--请选择--</option>
		<s:iterator value="ulist">
			<option value="<s:property value="id"/>"><s:property value="name"/></option>
		</s:iterator>
	</select>
	<br />
	<label for="outlays">支出费用</label>
	<input type="text" name="fete.outlays" id="outlays" />元<br />
</form>
<div id="alert"></div>
</div>

</div><!--end tabwrap-->
</body>
</html>
