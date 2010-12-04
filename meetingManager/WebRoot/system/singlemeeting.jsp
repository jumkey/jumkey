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
	//日期
	$(".date").datepicker({
		//changeMonth: true, changeYear: true,
		dateFormat:'yy-mm-dd',minDate: 0, maxDate: '+2y'
	}).datepicker($.datepicker.regional["zh-CN"]);
	var selectedItems;//批量删除用
	//初始化dialog
	$("#dialog").dialog({
		autoOpen: false,modal: true,overlay: { opacity: 0.5, background: "black" },
		title:"编辑",position:"center",width:360,height:400,
		close: function(event, ui){
			$("#alert").hide();
			//清空form数据
			$("#noticefrm")[0].reset();
			$("#fetefrm")[0].reset();
			$("#awardfrm")[0].reset();
			$("#activitiesfrm")[0].reset();
			
			$("#noticefrm").hide();
			$("#fetefrm").hide();
			$("#awardfrm").hide();
			$("#activitiesfrm").hide();
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
		$("#meetingfeeitemid").val($this_.parent().find("input").val());
		$("#meetinginfoid").val($(this).parent()[0].cells[1].innerHTML);
		$("#feeitem").val($(this).parent()[0].cells[2].innerHTML);
		$("#money").val($(this).parent()[0].cells[3].innerHTML);

		$("#dialog").dialog({
			buttons:{
				"修改":function(){
					$.post('main/jmeetingfeeitem_modify.action', {
						"meetingfeeitem.id":$("#meetingfeeitemid").val(),
						"meetingfeeitem.feeItem.id":$("#feeitemid").val(),
						"meetingfeeitem.money":$("#money").val()
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
				url: "main/jmeetingfeeitem_delete.action",
				data: {
					"meetingfeeitem.id": $this_.parent().find("input").val()
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
					url: "main/jmeetingfeeitem_delselect.action",
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
	//拟定通知计划
	$("#ndtz").bind("click",function(){
		$("#noticefrm").show();
		$("#dialog").dialog({
			buttons:{
				"拟定通知计划":function(){
					$.post('main/jnotice_add.action', {
						"notice.meetingInfo.id":${meetinginfo.id },
						"notice.number":$("#number").val(),
						"notice.date":$("#date").val()
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
	//添加宴请
	$("#tjyq").bind("click",function(){
		$("#fetefrm").show();
		$("#dialog").dialog({
			buttons:{
				"添加宴请":function(){
					$.post('main/dofete_add.action', {
						"fete.meetingInfo.id":${meetinginfo.id },
						"fete.address":$("#faddress").val(),
						"fete.date":$("#fdate").val(),
						"fete.scale":$("#fscale").val()
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
	//添加抽奖
	$("#tjcj").bind("click",function(){
		$("#awardfrm").show();
		$("#dialog").dialog({
			buttons:{
				"添加抽奖":function(){
					$.post('main/doawards_add.action', {
						"awards.meetingInfo.id":${meetinginfo.id },
						"awards.name":$("#awname").val(),
						"awards.host":$("#awhost").val(),
						"awards.guest":$("#awguest").val()
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
	//添加活动
	$("#tjhd").bind("click",function(){
		$("#activitiesfrm").show();
		$("#dialog").dialog({
			buttons:{
				"添加活动":function(){
					$.post('main/doactivities_add.action', {
						"activities.meetingInfo.id":${meetinginfo.id },
						"activities.name":$("#acname").val(),
						"activities.date":$("#acdate").val(),
						"activities.person":$("#acperson").val(),
						"activities.desc1":$("#acdesc1").val()
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
<style type="text/css">
#singleinfo {
	margin: 20px auto;
	width: auto;
}
.red {
	background-color: #AACB6B;
}
#singleinfo table {
	width: 100%;
	border-spacing: 1px;
	border-collapse: collapse;
}
#singleinfo table td {
	border: 1px solid #CECECE;
}
</style>
</head>

<body>
<div id="tabwrap"><a class="ui-state-default" href="javascript:history.back();">返回</a>
<div id="singleinfo">
	<table>
		<tr><td width="25%">会议标题</td>
		<td width="75%">${meetinginfo.title }</td></tr>
		<tr><td>举办地址</td>
		<td>${meetinginfo.address }</td></tr>
		<tr><td>会议简介</td>
		<td>${meetinginfo.desc1 }</td></tr>
		<!--  
		<tr><td>通知计划</td>
		<td><a id="ndtz" class="red" href="javascript:void(0);">拟定通知</a></td></tr>
		<s:iterator value="meetinginfo.notices" id="notice">
		<tr><td>计划日期</td>
		<td><s:date name="#notice.date" format="yyyy-MM-dd" /></td></tr>
		<tr><td>计划人数</td>
		<td>${notice.number }</td></tr>
		</s:iterator>
		-->
	</table>
</div>
<div><strong>管理</strong><br/>
<center>
<a href="main/meetingroom_list.action?meetingId=${meetinginfo.id }">会议室管理</a>&nbsp;|&nbsp;
<a href="main/lecture_list.action?meetingId=${meetinginfo.id }">讲座管理</a>&nbsp;|&nbsp;
<a href="main/meetingarrangements_list.action?meetingId=${meetinginfo.id }">会议安排</a>&nbsp;|&nbsp;
<a href="main/notice_send.action?meetinginfo.id=${meetinginfo.id }">通知/回执管理</a>&nbsp;|&nbsp;
<a href="main/reach_list.action?meetinginfo.id=${meetinginfo.id }">报到管理</a>&nbsp;|&nbsp;
<a href="main/meal_list.action?meetingInfoId=${meetinginfo.id }">用餐管理</a>&nbsp;|&nbsp;
<a href="main/payment_list.action?meetinginfo.id=${meetinginfo.id }">费用管理</a>&nbsp;|&nbsp;
<a href="main/fete_list.action?meetinginfo.id=${meetinginfo.id }">宴请管理</a>&nbsp;|&nbsp;
<a href="main/awards_list.action?meetinginfo.id=${meetinginfo.id }">抽奖管理</a>&nbsp;|&nbsp;
<a href="main/activities_list.action?meetinginfo.id=${meetinginfo.id }">活动管理</a>
</center>
</div>
<div>
    <div id="tabhead"><table>
      <tr>
        <td style="background: url('images/tab_03.gif') no-repeat; width: 15px"></td>
        <td><span style="background: url('images/311.gif') no-repeat; padding-left: 17px; font-size:14px;" class="STYLE4">参加人员列表</span></td>
        <td style="background: url('images/tab_07.gif') no-repeat; width: 14px"></td>
      </tr>
    </table></div>
    <div id="tabbody" style="width: 100%;height: 100%;"><table>
      <tr>
        <td style="background: url('images/tab_12.gif'); width: 9px;">&nbsp;</td>
        <td bgcolor="e5f1d6"><table id="list" style="width: 100%;border-spacing: 1px;border-collapse: separate; background-color: #CECECE;">
          <tr class="tabTitle">
            <td width="16%">属性</td>
            <td width="16%">姓名</td>
            <td width="18%">单位</td>
            <td width="16%">性别</td>
            <td width="17%">奖券</td>
            <td width="17%">餐券</td>
          </tr>
          <s:iterator status="index" value="rlist" id="reg">
          <s:if test="#reg.user.usertype=='家属'">
          <tr class="tabItem child">
            <td>${reg.user.user.name }的家属</td>
            <td>${reg.user.name }</td>
            <td>${reg.user.units.name }</td>
            <td>${reg.user.sex==1?"男":"女" }</td>
            <td>${reg.award }</td>
            <td>${reg.meal }</td>
          </tr>
          </s:if>
          <s:else>
          <tr class="tabItem">
            <td>${reg.user.usertype }</td>
            <td>${reg.user.name }</td>
            <td>${reg.user.units.name }</td>
            <td>${reg.user.sex==1?"男":"女" }</td>
            <td>${reg.award }</td>
            <td>${reg.meal }</td>
          </tr>
          </s:else>
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
	<!-- <span id="delselect"><a href="javascript:void(0);">删除选中</a></span> |  --><a href="javascript:location.reload();">刷新</a>
</div>
<div id="dialog" class="flora">
<form id="noticefrm" action="/" method="post" style="display: none;">
	<label for="number">计划通知人数</label>
	<input type="text" name="notice.number" id="number" /><br />
	<label for="date">计划通知日期</label>
	<input type="text" name="notice.date" id="date" class="date" /><br />
</form>
<form id="fetefrm" method="post" action="" style="display: none;">
	<label for="address">宴请地点</label>
	<input type="text" name="fete.address" id="faddress" /><br />
	<label for="date">宴请时间</label>
	<input type="text" name="fete.date" class="time" id="fdate" /><br />
	<label for="scale">宴请规格</label>
	<input type="text" name="fete.scale" id="fscale" /><br />
</form>
<form id="awardfrm" method="post" action="" style="display: none;">
	<label for="awname">奖品名</label>
	<input type="text" name="awards.name" id="awname" /><br />
	<label for="awhost">主持人</label>
	<input type="text" name="awards.host" id="awhost" /><br />
	<label for="awguest">嘉宾：</label>
	<input type="text" name="awards.guest" id="awguest" /><br />
</form>
<form id="activitiesfrm" method="post" action="" style="display: none;">
	<label for="acname">活动名称</label>
	<input type="text" name="activities.name" id="acname" /><br />
	<label for="acdate">活动时间</label>
	<input type="text" name="activities.date" class="date" id="acdate" /><br />
	<label for="acperson">负责人：</label>
	<input type="text" name="activities.person" id="acperson" /><br />
	<label for="acdesc1">活动简介</label><br />
	<textarea name="activities.desc1" id="acdesc1" cols="50" rows="8"></textarea><br />
</form>
<div id="alert"></div>
</div>

</div><!--end tabwrap-->
</body>
</html>
