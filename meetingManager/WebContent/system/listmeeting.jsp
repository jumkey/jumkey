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
	//日期时间
	$(".time").datetimepicker({
		dateFormat:'yyyy-mm-dd HH:MM:ss',minDate: 0, maxDate: '+2y'
	});
	//日期
	$(".date").datepicker({
		dateFormat:'yy-mm-dd',minDate: 0, maxDate: '+2y'
	}).datepicker($.datepicker.regional["zh-CN"]);
	var selectedItems;//批量删除用
	//初始化dialog
	$("#dialog").dialog({
		autoOpen: false,modal: true,overlay: { opacity: 0.5, background: "black" },
		title:"编辑",position:"center",width:500,height:400,
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
		$("#id").val($(this).parent().find("input").val());
		$("#title").val($(this).parent()[0].cells[1].innerText);
		$("#date").val($(this).parent()[0].cells[2].innerHTML);
		$("#registTime").val($(this).parent()[0].cells[3].innerHTML);
		$("#address").val($(this).parent()[0].cells[4].innerHTML);
		$("#meetingDays").val($(this).parent()[0].cells[5].innerHTML);

		$("#dialog").dialog({
			buttons:{
				"修改":function(){
					$.post('main/domeeting_modify.action', {
						"meetinginfo.id":$("#id").val(),
						"meetinginfo.title":$("#title").val(),
						"meetinginfo.price.date":$("#date").val(),
						"meetinginfo.price.registTime":$("#registTime").val(),
						"meetinginfo.price.meetingDays":$("#meetingDays").val(),
						"meetinginfo.address":$("#address").val()
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
				url: "main/domeeting_delete.action",
				data: {
					"meetinginfo.id": $this_.parent().find("input").val()
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
					url: "main/domeeting_delselect.action",
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
        <td><span style="background: url('images/311.gif') no-repeat; padding-left: 17px; font-size:14px;" class="STYLE4">会议列表</span></td>
        <td style="background: url('images/tab_07.gif') no-repeat; width: 14px"></td>
      </tr>
    </table></div>
    <div id="tabbody" style="width: 100%;height: 100%;"><table>
      <tr>
        <td style="background: url('images/tab_12.gif'); width: 9px;">&nbsp;</td>
        <td bgcolor="e5f1d6"><table id="list" style="width: 100%;border-spacing: 1px;border-collapse: separate; background-color: #CECECE;">
          <tr class="tabTitle">
            <td style="display:none" width="0%"></td>
            <td width="16%">会议标题</td>
            <td width="16%">会议时间</td>
            <td width="16%">报到时间</td>
            <td width="16%">地点</td>
            <td width="16%">会议天数</td>
            <td width="10%">管理</td>
            <td width="10%">编辑</td>
            <!-- <td width="10%">删除</td> -->
          </tr>
          <s:iterator status="index" value="list" id="meet">
          <tr class="tabItem">
            <td style="display:none"><input name="checkbox" type="hidden" value="${meet.id }" /></td>
            <td  title="${meet.desc1 }">${meet.title }</td>
            <td><s:date name="#meet.price.date" format="yyyy-MM-dd" /></td>
            <td><s:date name="#meet.price.registTime" format="yyyy-MM-dd" /></td>
            <td>${meet.address }</td>
            <td>${meet.price.meetingDays }</td>
            <td class="manage">[<a href="main/meeting_single.action?meetinginfo.id=${meet.id }">管理</a>]</td>
            <td class="edit">[<a href="javascript:void(0);" >编辑</a>]</td>
            <!--<td class="delete">[<a href="javascript:void(0);">删除</a>]</td> -->
          </tr>
          </s:iterator>
        </table></td>
        <td style="background: url('images/tab_16.gif'); width: 9px;">&nbsp;</td>
      </tr>
    </table></div>
    <div style="width: 100%;height: 30px;"><table>
      <tr>
        <td style="background: url('images/tab_20.gif') no-repeat; width: 15px"></td>
        <td style="background: url('images/tab_21.gif');"><!-- <table>
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
        </table> -->&nbsp;</td>
        <td style="background: url('images/tab_22.gif') no-repeat; width: 14px;"></td>
      </tr>
    </table></div>
</div>
<div id="op" style="padding-left: 20px;">
	 <!--<span id="delselect"><a href="javascript:void(0);">删除选中</a></span> |  --><a href="javascript:location.reload();">刷新</a> 
</div>
<script type="text/javascript">

</script>
<div id="dialog" class="flora">
<form id="form1" name="form1" method="post" action="">
	<input type="hidden" name="meetinginfo.id" value="" id="id"/><br/>
	<label for="title">会议主题</label>
	<input type="text" name="meetinginfo.title" id="title" /><br />
	<!-- <label for="author">会议主持人</label>
	<input type="text" name="meetinginfo.author" id="author" /><br /> -->
	<label for="date">会议时间</label>
	<input type="text" name="meetinginfo.price.date" id="date" class="date" /><br />
	<label for="registTime">报到时间</label>
	<input type="text" name="meetinginfo.price.registTime" id="registTime" class="date" /><br />
	<label for="address">会议地点</label>
	<input type="text" name="meetinginfo.address" id="address" /><br />
	<label for="meetingDays">会议天数</label>
	<input type="text" name="meetinginfo.price.meetingDays" id="meetingDays" /><br />
</form>
<div id="alert"></div>
</div>

</div><!--end tabwrap-->
</body>
</html>
