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
	$(function(){
		$("#form2").hide();
		$("#form3").hide();
		$("#form4").hide();
		$("#form5").hide();
		$("#shoufei").click(function(){
			$.post('main/jreach_add.action', {
				"register.meetingid.id":$("#meetingid").val(),
				"register.user.id":$("#userid").val(),
				"register.personalOptions":$("input[name='personalOptions']:checked").val(),
				"register.userName":$("#username").val(),
				"register.isReceipt":$("#isReceipt").val(),
				
				"income1.meetingFeeItem.meetingInfo.id":$("#meetingid").val(),
				"income1.meetingFeeItem.feeItem.id":11,
				"income1.user.id":$("#userid").val(),
				"income1.money":$("#personalFee").val(),
				
				"income2.meetingFeeItem.meetingInfo.id":$("#meetingid").val(),
				"income2.meetingFeeItem.feeItem.id":12,
				"income2.units.id":$("#unitsid").val(),
				"income2.money":$("#groupsFee").val()
			}, function(data) {
				var result=$.parseJSON(data.result);
				if(result.success=="true"){
					alert(result.msg);
					$("#award").val(result.award);
					$("#form1").hide();
					$("#form2").show();
				}else{
					alert(result.msg);
				}
			});
		});
		/*$("#fajiang").click(function(){
			$.post('main/jreach_fajiang.action', {
				"register.meetingid.id":$("#meetingid").val(),
				"register.user.id":$("#userid").val()
			}, function(data) {
				var result=$.parseJSON(data.result);
				if(result.success=="true"){
					alert(result.msg);
				}else{
					alert(result.msg);
				}
			});
		});*/
		$("#yajin").click(function(){
			$.post('main/jreach_yajin.action', {
				"register.meetingid.id":$("#meetingid").val(),
				"register.user.id":$("#userid").val(),
				"register.deposit":$("#deposit").val()
			}, function(data) {
				var result=$.parseJSON(data.result);
				if(result.success=="true"){
					alert(result.msg);
					$("#form1").hide();
					$("#form2").show();
				}else{
					alert(result.msg);
				}
			});
		});
		$("#yaoshi").click(function(){
			$.post('main/jreach_yaoshi.action', {
				"register.meetingid.id":$("#meetingid").val(),
				"register.user.id":$("#userid").val(),
				"register.roomNo":$("#roomno").val()
			}, function(data) {
				var result=$.parseJSON(data.result);
				if(result.success=="true"){
					alert(result.msg);
				}else{
					alert(result.msg);
				}
			});
		});
		$("#qiandao").click(function(){
			$.post('main/jreach_qiandao.action', {
				"register.meetingid.id":$("#meetingid").val(),
				"register.user.id":$("#userid").val(),
				"register.sign":$("#sign").val()
			}, function(data) {
				var result=$.parseJSON(data.result);
				if(result.success=="true"){
					alert(result.msg);
					$("#form1").hide();
					$("#form2").show();
				}else{
					alert(result.msg);
				}
			});
		});
		$("#ziliao").click(function(){
			$.post('main/jreach_ziliao.action', {
				"register.meetingid.id":$("#meetingid").val(),
				"register.user.id":$("#userid").val(),
				"register.receive":$("#receive").val()
			}, function(data) {
				var result=$.parseJSON(data.result);
				if(result.success=="true"){
					alert(result.msg);
				}else{
					alert(result.msg);
				}
			});
		});
		$("#paizhao").click(function(){
			$.post('main/jreach_findRegister.action', {
				"register.meetingid.id":$("#meetingid").val(),
				"register.user.id":$("#userid").val()
			}, function(data) {
				var result=$.parseJSON(data.result);
				if(result.success){
					$("#dialog").html("<img src='Photos/"+$("#userid").val()+".jpg?temp="+Math.random()+"'/>");
				}else{
					alert(result.msg);
				}
			});
			//$("#dialog").html("<img src='Photos/"+$("#userid").val()+".jpg?temp="+Math.random()+"'/><p>姓名："+$("#username").val()+"</p><p>卡号：0000</p>");
		});
		$("#submit").click(function(){
			$.post('main/jreach_add.action', {
				"register.meetingid.id":$("#meetingid").val(),
				"register.user.id":$("#userid").val(),
				"register.payment":$("#payment").val(),
				"register.stayday":$("#stayday").val(),
				"register.stayroomnumber":$("#stayroomnumber").val(),
				"register.sign":$("#sign").val(),
				"register.photo":$("#photo").val(),
				"register.code":$("#code").val(),
				"register.receive":$("#receive").val(),
				//"register.award":$("#award").val(),
				"register.meal":$("#meal").val(),
				"income.meetingFeeItem.meetingInfo.id":$("#meetingid").val(),
				"income.meetingFeeItem.feeItem.id":0,
				"income.user.id":$("#userid").val(),
				"income.money":$("#money").val()
			}, function(data) {
				var result=$.parseJSON(data.result);
				if(result.success!="true"){
					alert(result.msg);
				}else{
					alert(result.msg);
				}
			});
		});
	});
</script>
</head>

<body>
<a class="ui-state-default" href="javascript:history.back();">返回</a><br />
会议标题：<span id="meetingtitle">${meetinginfo.title }</span><br/>
<div>
	<input type="hidden" name="register.meetingid.id" value="${meetinginfo.id }" id="meetingid"/>
<!-- ----------------收费处---------------- -->
<s:if test="result=='shoufei'">
<form id="form1" action="/" method="post">
	<label>个人选项</label>
	<label><input type="radio" name="personalOptions" value="0" />代表</label>
	<label><input type="radio" name="personalOptions" value="1" />专家</label>
	<label><input type="radio" name="personalOptions" value="2" />家属</label>
	<label><input type="radio" name="personalOptions" value="3" />特殊免交</label>
	<label><input type="radio" name="personalOptions" value="4" />特殊暂缓</label><br/>
	<label id="jiashu">家属姓名：<input type="text" name="jiashuname" id="jiashuname" value="" size="8" /></label>
	<input type="hidden" name="register.user.id" value="" id="userid" disabled="disabled"/>
	<label>个人姓名：<input type="text" name="username" id="username" value="" size="8" /></label>
	<a href="javascript:void(0);" id="usersearch" class="ui-state-default">[查找用户]</a><br />
	<input type="hidden" name="register.user.units.id" value="" id="unitsid" disabled="disabled"/>
	<label>所属单位：<input type="text" name="unitsname" value="" id="unitsname" disabled="disabled"/></label><br/>
	<span id="uuser"></span>
	<script type="text/javascript">
		//处理单选
		$("input[name='personalOptions']:radio").live("change focus",function(){
			if($(this).val()==2){
				$("#jiashu").show();
			}else{
				$("#jiashu").hide();
			}
		});
		function select1(id,name,unitsid,unitsname){
			$("#userid").val(id);
			$("#username").val(name);
			$("#unitsid").val(unitsid);
			$("#unitsname").val(unitsname);
		}
		$("#usersearch").click(function (){
			$.post('main/jreach_checkusername_x.action', {
				"perid":$("#meetingid").val(),
				"username":$("#username").val(),
				"jiashuname":$("#jiashuname").val(),
				"personalOptions":$("input[name='personalOptions']:checked").val()
			}, function(data) {
				var result=$.parseJSON(data.result);
				if(result.user.length>0){
					$("#uuser").html("");
					$("#userid").val(result.user[0].id);
					$("#username").val(result.user[0].name);
					$("#unitsname").val(result.user[0].unitsname);//默认填入第一项
					for(var i=0;i<result.user.length;i++){
						var ss = $("#uuser").html();
						ss += "<a class=\"green\" href=\"javascript:select1('"+result.user[i].id+"','"+result.user[i].name+"','"+result.user[i].unitsid+"','"+result.user[i].unitsname+"');\">"+result.user[i].name+"-"+result.user[i].unitsname+"</a>"
						if(result.user[i].notice == "1") {
							ss += "&nbsp;<a>有回执</a>";
							if(result.user[i].notice_housenumber) {
								ss += "&nbsp;<a>房间数要求:"+result.user[i].notice_housenumber+"间</a>";
							}
							if(result.user[i].notice_issingle && result.user[i].notice_issingle == "1") {
								ss += "&nbsp;<a>要求单间</a>";
							}
							if(result.user[i].notice_roomtype) {
								ss += "&nbsp;<a>房间类型："+result.user[i].notice_roomtype+"</a>";
							}
						}
						ss += "<br/>";
						$("#uuser").html(ss);
					}
				}else{
					$("#userid").val("");
					$("#uuser").html("没有信息<br/>");
				}
			});
		});
	</script>
	<label>个人会务费：<input type="text" name="register.personalFee" value="" id="personalFee"/></label><br/>
	<label>团体会务费：<input type="text" name="register.groupsFee" value="" id="groupsFee"/></label><br/>
	<label>开收据：<select name="register.isReceipt" id="type">
		<option value="0">是</option>
		<option value="1">否</option>
	</select></label><br/>
	<a href="javascript:void(0);" class="ui-state-default" id="shoufei">完成收费</a>
</form>
</s:if>
<!-- ----------------住宿处---------------- -->
<s:elseif test="result=='zhusu'">
<form id="form1" action="/" method="post">
住宿处<br/>
收押金:<br/>
输入编号查询出当前用户，以及当前用户的回执信息。
	<label>酒店押金：<input type="text" name="register.deposit" value="" id="deposit" size="8"/></label><br/>
	<label>房间号：<input type="text" name="register.stayday" value="" id="roomno" size="8"/></label><br/>
		房间类型。与系统设置里的房间类型相关联。
		单击完成。则数据库里自动标记字段是否住宿为是。
	<a href="javascript:void(0);" class="ui-state-default" id="yaoshi">完成</a>
</form>
</s:elseif>
<!-- ----------------报到处---------------- -->
<s:elseif test="result=='baodao'">
<form id="form1" action="/" method="post">
输入编号查询出当前用户，以及当前用户的回执信息。
这里提供一个编辑按钮可更新当前用户在库里的信息以及单位信息。（家属除外）
单击完成签到。则数据库里自动标记字段是否签到为是。
完成后即拍照。拍照下面一个按钮制卡。

报到处<br/>
签到:<br/>
	<label>是否签到：<select name="register.sign" id="sign">
		<option value="1">是</option>
		<option value="0">否</option>
	</select></label><br/>
	<a href="javascript:void(0);" class="ui-state-default" id="qiandao">签到</a>
	<a href="javascript:void(0);" onclick="$('#form1').hide();$('#form2').show();">拍照</a>
</form>
<form id="form2" action="/" method="post">
照相:<br/>
<div>
<applet archive="MyApplet.jar" codebase="main/" code="WebCamera" name="WebCamera" width="840" height="485">
</applet>
</div>
<br />
<div id="dialog"></div><br/>
	<a href="javascript:void(0);" class="ui-state-default" id="paizhao">预览</a>
	<a href="javascript:void(0);" onclick="$('#form3').hide();$('#form4').show();">资料</a>
</form>
<form id="form4" action="/" method="post">
发资料:<br/>
	<label>是否领取资料：<select name="register.receive" id="receive">
		<option value="1">是</option>
		<option value="0">否</option>
	</select></label><br/>
	<a href="javascript:void(0);" class="ui-state-default" id="ziliao">发资料</a>
</form>
</s:elseif>
<s:else>
</s:else>
</div>
</body>
</html>
