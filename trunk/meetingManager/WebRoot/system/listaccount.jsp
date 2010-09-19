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
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.4.custom.css" rel="stylesheet" />	
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.4.custom.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#show").click(function(){//选中button,并监听click事件
		//点击button，选中div并作为dialog显示，只需要调用dialog()
		$("#dialog").dialog({
			title:"编辑",    //这是dialog的标题，也可以在对应div的title属性中设置
			position:"center", //设置dialog的显示位置，默认是center
			width:400,         //设置dialog的宽度，默认是300px
			height:250,        //这是dialog的高度，默认是200px
			//在dialog添加button，所有的button元素是一个keyvalue键值对
			//key是button的value值；value是对应buttonµ的click事件函数
			buttons:{
				"修改":function(){
					//隐藏登录表单
					$("#content").toggle();
				},
				"关闭":function(){
					$("#dialog").dialog("close");//关闭dialog
				}
			}
		});
	});
});
var highlightcolor = '#d5f4fe';
// 此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var clickcolor = '#51b2f6';
function changeto() {
	source = event.srcElement;
	if (source.tagName == "TR" || source.tagName == "TABLE")
		return;
	while (source.tagName != "TD")
		source = source.parentElement;
	source = source.parentElement;
	cs = source.children;
	// alert(cs.length);
	if (cs[1].style.backgroundColor != highlightcolor && source.id != "nc" && cs[1].style.backgroundColor != clickcolor)
		for (i = 0; i < cs.length; i++) {
			cs[i].style.backgroundColor = highlightcolor;
		}
}
function changeback() {
	if (event.fromElement.contains(event.toElement) || source.contains(event.toElement) || source.id == "nc")
		return;
	if (event.toElement != source && cs[1].style.backgroundColor != clickcolor)
		// source.style.backgroundColor=originalcolor
		for (i = 0; i < cs.length; i++) {
			cs[i].style.backgroundColor = "";
		}
}
function clickto() {
	source = event.srcElement;
	if (source.tagName == "TR" || source.tagName == "TABLE")
		return;
	while (source.tagName != "TD")
		source = source.parentElement;
	source = source.parentElement;
	cs = source.children;
	// alert(cs.length);
	if (cs[1].style.backgroundColor != clickcolor && source.id != "nc")
		for (i = 0; i < cs.length; i++) {
			cs[i].style.backgroundColor = clickcolor;
		}
	else
		for (i = 0; i < cs.length; i++) {
			cs[i].style.backgroundColor = "";
		}
}
</script>
</head>

<body>
<div id="tabwrap">
<div>
    <div id="tabhead"><table>
      <tr>
        <td style="background: url('images/tab_03.gif') no-repeat; width: 15px"></td>
        <td><span style="background: url('images/311.gif') no-repeat; padding-left: 17px; font-size:14px;" class="STYLE4">服务器进程配置列表</span></td>
        <td style="background: url('images/tab_07.gif') no-repeat; width: 14px"></td>
      </tr>
    </table></div>
    <div id="tabbody" style="width: 100%;height: 100%;"><table>
      <tr>
        <td style="background: url('images/tab_12.gif'); width: 9px;">&nbsp;</td>
        <td bgcolor="e5f1d6"><table align="center" style="width: 99%;border-spacing: 1px;border-collapse: separate; background-color: #CECECE;" onmouseover="changeto()" onmouseout="changeback()">
          <tr class="tabTitle">
            <td width="10%">选择</td>
            <td width="10%">账户</td>
            <td width="10%">昵称</td>
            <td width="10%">性别</td>
            <td width="10%">电话</td>
            <td width="10%">邮编</td>
            <td width="10%">地址</td>
            <td width="10%">部门</td>
            <td width="10%">编辑</td>
            <td width="10%">删除</td>
          </tr>
          <s:iterator status="index" value="list" id="sysaccount1">
          <tr class="tabItem">
            <td><input name="checkbox" type="checkbox" value="checkbox" /></td>
            <td>${sysaccount1.account }</td>
            <td>${sysaccount1.username }</td>
            <td>${sysaccount1.sex }</td>
            <td>${sysaccount1.phone }</td>
            <td>${sysaccount1.zip }</td>
            <td>${sysaccount1.address }</td>
            <td>${sysaccount1.department.departmentname }</td>
            <td class="edit">[<a href="#">编辑</a>]</td>
            <td class="delete">[<a href="#">删除</a>]</td>
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
            	<a href="javascript:void(0);" >全选</a>
            	<a href="javascript:void(0);" >全不选</a>
            	<a href="javascript:void(0);" >反选</a>
            </td>
            <td width="79%"><div align="right">
                  <a href="javascript:void(0);" >首页</a>
                  <a href="javascript:void(0);" >上一页</a>
                  <a href="javascript:void(0);" >下一页</a>
                  <a href="javascript:void(0);" >尾页</a>
                  <span>
                  	转到第<input name="textfield" type="text" style="height:12px; width:25px;" size="5" />页
                  </span><img src="images/g_page.gif" width="14" height="14" />
            </div></td>
          </tr>
        </table></td>
        <td style="background: url('images/tab_22.gif') no-repeat; width: 14px;"></td>
      </tr>
    </table></div>
</div>
<div>
<!-- 定义一个button，点击显示dialog -->
<input type="button" value="我要登录" id="show" />
</div>
<!-- 作为dialog的div --> 
<div id="dialog" class="flora"></div>
<!--这边为什么要定义class=”flora”呢？class是指定dialog的css,因为在jqueryUI的css样式都是使用class来作为选择器-->
<s:debug></s:debug>
</div>
</body>
</html>
