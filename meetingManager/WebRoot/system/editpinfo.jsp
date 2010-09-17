<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>编辑账户资料</title>
		<link rel="stylesheet" type="text/css" href="style/styles.css" />
	</head>
	<body>
		<s:if test="hasActionMessages()">
			<b style="color: red;"><s:property value="actionMessages" /></b>
		</s:if>
        <s:form method="post" action="pinfo_doedit" onsubmit="return check();" theme="simple">
        	<s:hidden label="id" name="sysaccount.id" value="%{#attr.account.id}" /><br/>
            密码：<s:textfield id="p1" label="密码" name="sysaccount.password" /><br/>
            确认：<s:textfield id="p2" label="确认" name="try" /><br/>
            昵称：<s:textfield label="昵称" name="sysaccount.username" value="%{#attr.account.username}" /><br/>
            性别：<s:radio label="性别" name="sysaccount.sex" list="%{#{1:'男',0:'女'}}" value="%{#attr.account.sex}" /><br/>
            电话：<s:textfield label="电话" name="sysaccount.phone" value="%{#attr.account.phone}" /><br/>
            邮编：<s:textfield label="邮编" name="sysaccount.zip" value="%{#attr.account.zip}" /><br/>
            地址：<s:textfield label="地址" name="sysaccount.address" value="%{#attr.account.address}" /><br/>
            <s:submit value="修改" /><br/>
        </s:form>
        <script type="text/javascript">
        	function check(){
        		if(document.getElementById("p1").value==""||document.getElementById("p1").value!=document.getElementById("p2").value){
        			alert("确认密码的输入无误！");
        			return false;
        		}else{
        			return true;
        		}
        	}
        </script>
        <s:debug></s:debug>
	</body>
</html>
