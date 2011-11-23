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
function doresp(id){
	if(id!=null){
		$("#username").html(0);
		$("#unitsname").html(3);
		$("#sex").html(1);
		$("#phone").html(7);
		$("#dialog").dialog({
			buttons:{
				"回执":function(){
					$.ajax({
						type: "POST",
						url: "main/jnotice_doresp.action",
						data: {
							"snp.id":id,//回执编号
							"snp.issingle":$("#issingle").val(),
							"snp.roomtype.id":$("input[name='roomtype']:checked").val(),
							"snp.reachflights":$("#reachflights").val(),
							"snp.reachTrain":$("#reachTrain").val(),
							"snp.reachtime":$("#reachtime").val(),
							"snp.reachman":$("#reachman").val(),
							"snp.reachphone":$("#reachphone").val()
						},
						dataType: "json",
						success: function (data) {
							var result=$.parseJSON(data.result);
							if(result.success!="true"){
								alert(result.msg);
							}else{
								alert(result.msg);
							}
						}
					});
				}
			}
		}).dialog("open");
	}
}
//入口
$(document).ready(function(){
	//日期时间
	$(".time").datetimepicker({
		dateFormat:'yyyy-mm-dd HH:MM:ss',minDate: 0, maxDate: '+2y'
	});
	//日期
	$("#date").datepicker({
		//changeMonth: true, changeYear: true,
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
		}
	});
	$("#editdialog").dialog({
		autoOpen: false,modal: true,overlay: { opacity: 0.5, background: "black" },
		title:"编辑",position:"center",width:500,height:400,
		close: function(event, ui){
			$("#editalert").hide();
		}
	});
	//拟定通知计划
	$("#ndtz").bind("click",function(){
		$("#form1").show();
		$("#dialog").dialog({
			buttons:{
				"拟定通知计划":function(){
					$.post('main/jnotice_add.action', {
						"notice.meetingInfo.id":${meetinginfo.id},
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
							$("#dialog").dialog("close");
							location.reload();
						}
					});
				}
			}
		}).dialog("open");
	});
	<s:if test="notice!=null">
	$("#edit").click(function(){
		$("#editdialog").dialog({
			buttons:{
				"修改通知计划":function(){
					$.post('main/jnotice_modify.action', {
						"notice.id":${notice.id},
						"notice.number":$("#number").val(),
						"notice.date":$("#date").val()
					}, function(data) {
						//alert(data);
						var result=$.parseJSON(data.result);
						
						if(result.success!="true"){
							$("#editalert").html(result.msg).show()
							.addClass("ui-state-error ui-corner-all");
						}else{
							$("#editalert").html(result.msg).show()
							.addClass("ui-state-highlight ui-corner-all");
							location.reload();
						}
					});
				}
			}
		}).dialog("open");
	});
	</s:if>
	$(".resp").live("click",function(){
		var $this_=$(this);//保存当前this对象
		//设置form数据
		$("#username").html($(this).parent().parent()[0].cells[0].innerText);
		$("#unitsname").html($(this).parent().parent()[0].cells[3].innerText);
		$("#sex").html($(this).parent().parent()[0].cells[1].innerText);
		$("#phone").html($(this).parent().parent()[0].cells[7].innerText);
alert($this_.parent().parent().find("input").val());
		$("#dialog").dialog({
			buttons:{
				"回执":function(){
					$.ajax({
						type: "POST",
						url: "main/jnotice_doresp.action",
						data: {
							"snp.id":$this_.parent().parent().find("input").val(),//回执编号
							"snp.issingle":$("#issingle").val(),
							"snp.roomtype.id":$("input[name='roomtype']:checked").val(),
							"snp.reachflights":$("#reachflights").val(),
							"snp.reachTrain":$("#reachTrain").val(),
							"snp.reachtime":$("#reachtime").val(),
							"snp.reachman":$("#reachman").val(),
							"snp.reachphone":$("#reachphone").val()
						},
						dataType: "json",
						success: function (data) {
							var result=$.parseJSON(data.result);
							if(result.success!="true"){
								alert(result.msg);
							}else{
								alert(result.msg);
							}
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
<div id="tabwrap"><a class="ui-state-default" href="javascript:history.back();">返回</a><br/>
<s:if test="notice!=null">
	会议标题：${notice.meetingInfo.title }<br />
	计划通知日期：<s:date name="notice.date" format="yyyy-MM-dd" /><br />
	计划通知人数：${notice.number }<br />
	<a href="javascript:void(0);" id="edit">修改</a>
	<div id="editdialog" class="flora">
	<form id="form2" action="/" method="post">
		<label for="number">计划通知人数</label>
		<input type="text" name="notice.number" id="number" value="${notice.number }" /><br />
		<label for="date">计划通知日期</label>
		<input type="text" name="notice.date" id="date" class="date" value="<s:date name="notice.date" format="yyyy-MM-dd" />" /><br />
	</form>
	<div id="editalert"></div>
	</div>
<p></p>
<div>
    <div class="tabhead"><table>
      <tr>
        <td style="background: url('images/tab_03.gif') no-repeat; width: 15px"></td>
        <td><span style="background: url('images/311.gif') no-repeat; padding-left: 17px; font-size:14px;" class="STYLE4">已通知人员列表</span></td>
        <td style="background: url('images/tab_07.gif') no-repeat; width: 14px"></td>
      </tr>
    </table></div>
    <div class="tabbody" style="width: 100%;height: 100%;"><table>
      <tr>
        <td style="background: url('images/tab_12.gif'); width: 9px;">&nbsp;</td>
        <td bgcolor="e5f1d6"><table id="slist" style="width: 100%;border-spacing: 1px;border-collapse: separate; background-color: #CECECE;">
          <tr class="tabTitle">
            <td width="9%">姓名</td>
            <td width="9%">性别</td>
            <td width="9%">职务职称</td>
            <td width="9%">单位</td>
            <td width="9%">邮编</td>
            <td width="9%">座机</td>
            <td width="9%">手机</td>
            <td width="9%">电话</td>
            <td width="9%">通讯地址</td>
            <td width="9%">电子邮件</td>
            <td width="11%">操作</td>
          </tr>
          <s:iterator status="index" value="notice.sendNotificationPlans" id="snp">
          <tr class="tabItem">
            <td>${snp.user.name }</td>
            <td>${snp.user.sex==0?"女":"男" }</td>
            <td>${snp.user.zwu }</td>
            <td>${snp.user.units.name }</td>
            <td>${snp.user.units.zip }</td>
            <td>${snp.user.phone }</td>
            <td>${snp.user.cellphone }</td>
            <td>${snp.user.phone }</td>
            <td>${snp.user.units.address }</td>
            <td>${snp.user.mail }</td>
            <td><input type="hidden" value="${snp.id }" />
            <a href="javascript:void(0);" class="resp">回执</a>|<a href="javascript:doresp(${snp.id });">删除</a>
            </td>
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
<div id="dialog" class="flora">
<form id="form1" name="form1" method="post" action="">
	个人姓名：<span id="username"></span><br />
	所属单位：<span id="unitsname"></span><br/>
	性别：<span id="sex"></span><br/>
	电话：<span id="phone"></span><br/>
	<label for="issingle">是否单间住宿：</label>
	<input type="text" name="issingle" id="issingle" value="" /><br/>
	<label for="roomtype">要求房间类型：</label>
	<s:iterator status="index" value="rlist" id="roomtype">
	<label><input type="radio" name="roomtype" value="${roomtype.id }" />${roomtype.type }</label>
	</s:iterator><br />
	<label for="reachflights">接站航班：</label>
	<input type="text" name="reachflights" id="reachflights" value="" /><br />
	<label for="reachTrain">接站班次：</label>
	<input type="text" name="reachTrain" id="reachTrain" value="" /><br />
	<label for="reachtime">接站时间：</label>
	<input type="text" name="reachtime" id="reachtime" value="" class="time" /><br />
	<label for="reachman">接站负责人：</label>
	<input type="text" name="reachman" id="reachman" value="" /><br />
	<label for="reachphone">接站联系电话：</label>
	<input type="text" name="reachphone" id="reachphone" value="" /><br />
</form>
<div id="alert"></div>
</div>
</s:if>
<s:else>
还没有通知单<br/>
<a id="ndtz" class="red" href="javascript:void(0);">拟定通知</a>
<div id="dialog" class="flora">
<form id="form1" action="/" method="post" style="display: none;">
	<label for="number">计划通知人数</label>
	<input type="text" name="notice.number" id="number" value="" /><br />
	<label for="date">计划通知日期</label>
	<input type="text" name="notice.date" id="date" class="date" value="" /><br />
</form>
<div id="alert"></div>
</div>
</s:else>
</div><!--end tabwrap-->
</body>
</html>
