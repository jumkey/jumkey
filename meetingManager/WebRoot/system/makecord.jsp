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
<style type="text/css">
	tr.over td {
		background: #AACB6B; /*这个将是鼠标高亮行的背景色 这是必须设置的*/
		cursor: pointer;
	}
</style>
<script type="text/javascript">
	$(function(){
		$("#submit").click(function(){
			$.post('main/jreach_findRegister.action', {
				"register.meetingid.id":$("#meetingid").val(),
				"register.user.id":$("#userid").val()
			}, function(data) {
				var result=$.parseJSON(data.result);
				if(result.success){
					$("#dialog").html("<img src='Photos/"+$("#userid").val()+".jpg?temp="+Math.random()+"'/><p>姓名："+$("#username").val()+"</p><p>卡号："+result.code+"</p>");
				}else{
					alert(result.msg);
				}
			});
			//$("#dialog").html("<img src='Photos/"+$("#userid").val()+".jpg?temp="+Math.random()+"'/><p>姓名："+$("#username").val()+"</p><p>卡号：0000</p>");
		});
	});
	function select1(id,name){
		$("#userid").val(id);
		$("#username").val(name);
		document.applets[0].setFname(id);
	}
	function checkusername(){
		$.post('main/jreach_checkreachedusername.action', {
			"perid":$("#meetingid").val(),
			"username":$("#username").val()
		}, function(data) {
			var result=$.parseJSON(data.result);
			if(result.user.length>0){
				$("#uuser").html("");
				select1(result.user[0].id,result.user[0].name);//默认填入第一项
				for(var i=0;i<result.user.length;i++){
					$("#uuser").html($("#uuser").html()+"<a class=\"green\" href=\"javascript:select1('"+result.user[i].id+"','"+result.user[i].name+"');\">"+result.user[i].name+"</a><br/>");
				}
			}else{
				$("#userid").val("");
				$("#uuser").html("没有信息<br/>");
			}
		});
	}
</script>
</head>

<body><a class="ui-state-default" href="javascript:history.back();">返回</a><br />
<div>
<form id="form1" action="/" method="post" style="display: inline;float: left;">
	会议标题：<span id="meetingtitle">${meetinginfo.title }</span><br/>
	<input type="hidden" name="register.meetingid.id" value="${meetinginfo.id }" id="meetingid"/>
	<label>个人编号：<input type="text" name="register.user.id" value="" id="userid" disabled="disabled"/></label><br/>
	<label>用户姓名：<input type="text" name="username" id="username" value="" /></label><br />
	<span id="uuser"></span>
	<a href="javascript:checkusername();" class="ui-state-default">获取用户信息</a><br />
</form>
<applet archive="MyApplet.jar" codebase="main/" code="WebCamera" name="WebCamera" width="840" height="485"></applet>
</div>
<br />
<a href="javascript:void(0);" id="submit" style="padding: .4em 1em;" class="ui-state-default ui-corner-all">预览卡片</a>
<div id="dialog"></div>
</body>
</html>
