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
<style type="text/css">
.hideborder {display:none;} 
.td-selected{background-color:#FDD283;height: 18px;text-align: center;}
</style>
<link rel="stylesheet" type="text/css" href="style/styles.css" />
<link type="text/css" href="css/south-street/jquery-ui-1.8.5.custom.css" rel="stylesheet" />	
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.5.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="script/util.js"></script>
<script type="text/javascript">
//全选
function selectAll(){
	$("input[@class='mycheck']:checkbox").each(function(){
		$(this).attr("checked",true);
	});
}
//全不选
function unselectAll(){
	$("input[@class='mycheck']:checkbox").each(function(){
		$(this).removeAttr("checked");
	});
}
//反选
function fselectAll(){
	$("input[@class='mycheck']:checkbox").each(function(){
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
document.onkeypress=function(e) {
     var code;  
     if  (!e)  
     {  
         var e=window.event;  
     }  
     if(e.keyCode)  
     {    
         code=e.keyCode;  
     }  
     else if(e.which)  
     {  
         code   =   e.which;  
     }
     if(code==13)
     {
		setSuspended();
     }
}
var imageurl = "images/choujiang.gif";
var choujiangnum = 0;
var alluser = null;
var alluseri = 1;
function startDrawing(){	 
		choujiangnum++;
		var Nos=new Array();
		for(var i=0;i<4;i++) {
			Nos[i] = Math.round(Math.random() * (9) + 1);
		}
		var zantingstr = '<div id="zjuser" style="position: absolute; top: 64px; left: 10px;"><a onclick="setSuspended()" href="#" style="color: blue; position: absolute; width: 100px; left: 105px;">按回车键停下</a></div>';
		alert('<div id="cjqian" style="background: url('+imageurl+') repeat scroll 0pt '+(Nos[0]*(10-1)*49)+'px transparent; height: 49px; position: absolute; width: 36px; left: 80px;"></div><div id="cjqbai" style="background: url('+imageurl+') repeat scroll 0pt '+(Nos[1]*(10-1)*49)+'px transparent; height: 49px; position: absolute; width: 36px; left: 120px;"></div><div id="cjshi" style="background: url('+imageurl+') repeat scroll 0pt '+(Nos[2]*(10-1)*49)+'px transparent; height: 49px; position: absolute; width: 36px; left: 160px;"></div><div id="cjge" style="background: url('+imageurl+') repeat scroll 0pt '+(Nos[3]*(10-1)*49)+'px transparent; height: 49px; position: absolute; width: 36px; left: 200px;"></div>'+zantingstr);
		
}
function allChoujiang(){
		if(alluser.length<=alluseri){clearTimeout("allChoujiang()");alert("已经抽奖完毕!");setTimeout("location.reload()",1000);return;}
    	var user = alluser[alluseri].split("●");
    	var userid = user[1];
    	var username = user[2];
    	var awards = user[0];
    	choujiangnum = 0;
    	sleepOneTime(awards,username,userid);
}
function nextChoujiang() {
	alluseri = alluseri+1;
	setTimeout("allChoujiang()",200);
}
function setSuspended() {
	choujiangnum = 9999;
}
function sleepOneTime(awards,username,userid){
	if(choujiangnum>1000){
		clearTimeout("sleepOneTime('"+awards+"','"+username+"','"+userid+"')");
		var Nos=new Array(); 
		if(userid>=1000){
			Nos[0]=Math.floor(userid/1000);
		}else{
			Nos[0]=0;
		}
		if(userid<1000&&userid>=100){
			Nos[1]=Math.floor(userid/100);
		}else {
			Nos[1]=0;
		} 
		if(userid<100&&userid>=10){
			Nos[2]= Math.floor(userid/10);
		}else {
			Nos[2]=0;
		}
		if(userid<10&&userid>=0){
			Nos[3]= userid;
		}else {
			Nos[3]=0;
		}
		var strzjuser = '<div style="position: absolute; top: 64px; left: 10px;" id="zjuser">'+awards+'得主:'+username+'['+userid+']<a style="color: blue; position: absolute; width: 60px; left: 235px;" href="javascript:nextChoujiang()">下一个</a></div>';
		alert('<div id="cjqian" style="background: url('+imageurl+') repeat scroll 0pt '+(Nos[0]*(10-1)*49)+'px transparent; height: 49px; position: absolute; width: 36px; left: 80px;"></div><div id="cjqbai" style="background: url('+imageurl+') repeat scroll 0pt '+(Nos[1]*(10-1)*49)+'px transparent; height: 49px; position: absolute; width: 36px; left: 120px;"></div><div id="cjshi" style="background: url('+imageurl+') repeat scroll 0pt '+(Nos[2]*(10-1)*49)+'px transparent; height: 49px; position: absolute; width: 36px; left: 160px;"></div><div id="cjge" style="background: url('+imageurl+') repeat scroll 0pt '+(Nos[3]*(10-1)*49)+'px transparent; height: 49px; position: absolute; width: 36px; left: 200px;"></div>'+strzjuser);
		return;
	}
	startDrawing();
	setTimeout("sleepOneTime('"+awards+"','"+username+"','"+userid+"')",20);
}
 	 
//入口
$(document).ready(function(){
	 
	
	//日期
	$("#date").datepicker({
		//changeMonth: true, changeYear: true,
		dateFormat:'yy-mm-dd',minDate: 0, maxDate: '+2y'
	}).datepicker($.datepicker.regional["zh-CN"]);
	var selectedItems;//批量删除用
	//初始化dialog
	$("#dialog").dialog({
		autoOpen: false,modal: true,overlay: { opacity: 0.5, background: "black" },
		title:"编辑",position:"center",width:400,height:500,
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
			$("#divdata").hide();//隐藏列表
		}
	});
	//修改
	$(".edit").live("click",function(){
		var $this_=$(this);//保存当前this对象
		//设置form数据		
		
		$("#awardsid").val($(this).parent().find("input").val());
		$("#name").val($(this).parent()[0].cells[3].innerText);
		$("#host").val($(this).parent()[0].cells[4].innerHTML);
		$("#guest").val($(this).parent()[0].cells[5].innerHTML);
		$("#name").val($(this).parent()[0].cells[1].innerText);
		$("#host").val($(this).parent()[0].cells[2].innerText);
		$("#guest").val($(this).parent()[0].cells[3].innerHTML);
		$("#unitstype").val($(this).parent()[0].cells[4].innerHTML);
		$("#usertype").val($(this).parent()[0].cells[5].innerHTML);
		$("#shieldunits").val($(this).parent()[0].cells[6].innerHTML);
		$("#shielduser").val($(this).parent()[0].cells[7].innerHTML);
		$("#meetingArrangementsId").val($(this).parent()[0].cells[10].innerHTML);
		$("#unitsId").val($(this).parent()[0].cells[9].innerHTML);
		$("#value").val($(this).parent()[0].cells[13].innerHTML);
		$("#remarks").val($(this).parent()[0].cells[11].innerHTML);
		$("#expenses").val($(this).parent()[0].cells[12].innerHTML);

		$("#dialog").dialog({
			buttons:{
				"修改":function(){
					$.post('main/doawards_modify.action', {
						"awards.id":$("#awardsid").val(),
						"awards.name":$("#name").val(),
						"awards.host":$("#host").val(),
						"awards.guest":$("#guest").val(),
						"awards.unitstype":$("#unitstype").val(),
						"awards.usertype":$("#usertype").val(),
						"awards.shieldunits":$("#shieldunits").val(),
						"awards.shielduser":$("#shielduser").val(),
						"awards.meetingArrangements.id":$("#meetingArrangementsId").val(),
						"awards.units.id":$("#unitsId").val(),
						"awards.value":$("#value").val(),
						"awards.remarks":$("#remarks").val(),
						"awards.expenses":$("#expenses").val()
					}, function(data) {
						var result=$.parseJSON(data.result);
						if(result.success!="true"){
							$("#alert").html(result.msg).show()
							.addClass("ui-state-error ui-corner-all");
						}else{
							$("#alert").html(result.msg).show()
							.addClass("ui-state-highlight ui-corner-all");
							//更新table
							setTimeout("location.reload()",1000);
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
				url: "main/doawards_delete.action",
				data: {
					"awards.id": $this_.parent().find("input").val()
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
					$.post('main/doawards_add.action', {
						"awards.meetingInfo.id":${meetinginfo.id },
						"awards.name":$("#name").val(),
						"awards.host":$("#host").val(),
						"awards.guest":$("#guest").val(),
						"awards.unitstype":$("#unitstype").val(),
						"awards.usertype":$("#usertype").val(),
						"awards.shieldunits":$("#shieldunits").val(),
						"awards.shielduser":$("#shielduser").val(),
						"awards.meetingArrangements.id":$("#meetingArrangementsId").val(),
						"awards.units.id":$("#unitsId").val(),
						"awards.value":$("#value").val(),
						"awards.remarks":$("#remarks").val(),
						"awards.expenses":$("#expenses").val()
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
							setTimeout("location.reload()",1000);
							//$("#dialog").dialog("close");
						}
					});
				}
			}
		}).dialog("open");
	});
	$("#delselect").click(function(){
		selectedItems = new Array();//只能定义全局变量，否则进入confirm后值会变为第一次设置的值（不知道原因）
		$(".mycheck:checked").each(function(){selectedItems.push($(this).val());});
		if (selectedItems.length == 0){
			alert("请选择要删除的行");
		}else{
			confirm("确认删除",function(){
				
				$.ajax({
					type: "POST",
					url: "main/doawards_delselect.action",
					data: "selected=" + selectedItems.join('&selected='),
					dataType: "json",
					success: function (data) {
						var result=$.parseJSON(data.result);
						
						if(result.success!="true"){
							alert(result.msg);
							
						}else{
							//更新table 删除记录
							alert(result.msg);
							setTimeout("location.reload()",1000);
						}
					}
				});
			});
		}
	});
	//抽奖
	$("#choujiang").click(function(){
		var $this_=$(this);//保存父this
		selectedItems = new Array();//只能定义全局变量，否则进入confirm后值会变为第一次设置的值（不知道原因）
		$(".mycheck:checked").each(function(){selectedItems.push($(this).val());});
		if (selectedItems.length == 0){
			alert("请选择要抽奖的对象");
			return ;		
		}
		$.ajax({
			type: "POST",
			url: "main/doawards_choujiang.action?meetingId="+$('#meetingId').val(),
			data: "selected=" + selectedItems.join('&selected='),
			dataType: "json",
			success: function (data) {
				var result=$.parseJSON(data.result);
				if(result.success=="true"){
				    alluser = result.zhongjiang.split("○");
				    allChoujiang();
				}else{
					alert(result.msg);
				}
			}
		});
	});
	
	

		var $onFocusID = null;
		$("#unitstype").focus(function(){
			$("#divdata").css("left",$(this).position().left);
			$("#divdata").css("top",$(this).position().top + $(this).outerHeight());
			$("#divdata #datas").html($("#unitstp").html());
			$("#divdata").show();
			$onFocusID = $(this);
		});
		$("#usertype").focus(function(){
			$("#divdata").css("left",$(this).position().left);
			$("#divdata").css("top",$(this).position().top + $(this).outerHeight());
			$("#divdata #datas").html($("#usertp").html());
			$("#divdata").show();
			$onFocusID = $(this);
		});
		$("#shieldunits").focus(function(){
			$("#divdata").css("left",$(this).position().left);
			$("#divdata").css("top",$(this).position().top + $(this).outerHeight());
			$("#divdata #datas").html($("#sunits").html());
			$("#divdata").show();
			$onFocusID = $(this);
		});
		$("#shielduser").focus(function(){
			$("#divdata").css("left",$(this).position().left);
			$("#divdata").css("top",$(this).position().top + $(this).outerHeight());
			$("#divdata #datas").html($("#suser").html());
			$("#divdata").show();
			$onFocusID = $(this);
		});
		$("#cancel").click(function(){
			$("#divdata").hide();
		});
		$("#confirm").click(function(){
			var ss=""
			$("#divdata input:checked").each(function(){
				ss+=","+$(this).val();
			});
			$onFocusID.val(ss.substr(1));
			$("#divdata").hide();
		});
		/*$("#divdata #datas input").change(function (){
			if(!$(this).parent().parent().hasClass("checked")){
				$(this).parent().parent().addClass("checked");
				$(this).attr("checked",true);
				return;
			}
			$(this).parent().removeClass("checked");
			$(this).attr("checked",false);
		});*/
});
</script>
<style type="text/css">
#checkbox{
	filter:alpha(opacity=0); /*IE*/
	-moz-opacity:0; /*MOZ , FF*/
	opacity:0;/*CSS3, FF1.5*/
}
#alldata{
	display:none;
}
#divdata{
	display:none;
	position:absolute;
	width:100px;
	border:1px solid #BEC0BF;
	padding:5px;
	font-size:12px;
	background-color: #AACB6B;
}
#divdata #datas label{
	display:inline-block;
	cursor:pointer;
	/*background:url(images/bg_check.gif) no-repeat left top;*/
}
#divdata #datas label.checked{
	/*background-position:left bottom;*/
}
</style>
</head>

<body> 
<div id="tabwrap"><a class="ui-state-default" href="javascript:history.back();">返回</a>
<div>
    <div id="tabhead"><table>
      <tr>
        <td style="background: url('images/tab_03.gif') no-repeat; width: 15px"></td>
        <td><span style="background: url('images/311.gif') no-repeat; padding-left: 17px; font-size:14px;" class="STYLE4">奖项列表</span></td>
        <td style="background: url('images/tab_07.gif') no-repeat; width: 14px"></td>
      </tr>
    </table></div>
    <div id="tabbody" style="width: 100%;height: 100%;"><table>
      <tr>
        <td style="background: url('images/tab_12.gif'); width: 9px;">&nbsp;</td>
        <td bgcolor="e5f1d6"><table id="list" style="width: 100%;border-spacing: 1px;border-collapse: separate; background-color: #CECECE;">
          <tr class="tabTitle">
            <td width="4%">选择</td>
            <td width="8%">奖品名称</td>
            <td width="8%">主持人</td>
            <td width="8%">嘉宾</td>
            <td width="10%">可抽奖单位类型</td>
            <td width="10%">可抽奖个人类型</td>
            <td width="10%">屏蔽单位列表</td>
            <td width="10%">屏蔽个人列表</td>
            <td width="8%">提供单位</td>
            <td width="7%">管理</td>
            <td width="7%">编辑</td>
            <td width="7%">删除</td>
          </tr>
          <s:iterator status="index" value="list" id="awards">
          <tr class="tabItem">
            <td><input name="checkbox2" class="mycheck" type="checkbox" value="${awards.id }" /><input type="hidden" name="awards.id" value="${awards.meetingInfo.id }" id="meetingId"/></td>
            <td>${awards.name }</td>
            <td>${awards.host }</td>
            <td>${awards.guest }</td>
            <td>${awards.unitstype }</td>
            <td>${awards.usertype }</td>
            <td>${awards.shieldunits }</td>
            <td>${awards.shielduser }</td>
            <td>${awards.units.name }</td>
            <td class="hideborder">${awards.units.id }</td>
            <td class="hideborder">${awards.meetingArrangements.id }</td>
            <td class="hideborder">${awards.remarks}</td>
            <td class="hideborder">${awards.expenses}</td>
            <td class="hideborder">${awards.value}</td>
            <td class="manage">[<a href="main/awards_lotterylist.action?awards.id=${awards.id }">管理</a>]</td>
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
                  <a href="javascript:page(1);" >首页</a>
                  <a href="javascript:page(${page.currentPage-1 });" >上一页</a>
                  <a href="javascript:page(${page.currentPage+1 });" >下一页</a>
                  <a href="javascript:page(${page.totalPage });" >尾页</a>
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
	<span id="add"><a href="javascript:void(0);">新增</a></span> | 
	<span id="delselect"><a href="javascript:void(0);">删除选中</a></span> | 
	<span id="choujiang"><a href="javascript:void(0);">开始抽奖</a></span> | 
	<a href="javascript:location.reload();">刷新</a><br/>
</div>
<div id="dialog" class="flora">
<form id="form1" name="form1" method="post" action="">
	<input type="hidden" name="awards.id" value="" id="awardsid"/><br/>
	<label for="name">奖品名称</label>
	<input type="text" name="awards.name" id="name" /><br />
	<label for="host">主持人</label>
	<input type="text" name="awards.host" id="host" /><br />
	<label for="guest">嘉	宾</label>
	<input type="text" name="awards.guest" id="guest" /><br />
	<label for="meetingArrangementsid">会议安排编号</label>
	<select name="awards.meetingArrangements.id" id="meetingArrangementsId" >
		<s:iterator status="index" value="meetingArrangementslist" id="ma">
		<option value="${ma.id }">${ma.title}</option>
		</s:iterator>
	</select><br />
	<label for="unitsid">提供单位</label>
	<select  name="awards.units.id" id="unitsId"  >
		<s:iterator status="index" value="units" id="un">
		<option value="${un.id }">${un.name}</option>
		</s:iterator>
	</select><br />
	<label for="value">价    值</label>
	<input type="text" name="awards.value" id="value" /><br />
	<label for="remarks">备    注</label>
	<input type="text" name="awards.remarks" id="remarks" /><br />
	<label for="expenses">支出费用</label>
	<input type="text" name="awards.expenses" id="expenses" /><br />
	<label>可抽奖的单位类型<input type="text" name="awards.unitstype" id="unitstype" /></label><br />
	<label>可抽奖的个人类型<input type="text" name="awards.usertype" id="usertype" /></label><br />
	<label>屏蔽抽奖单位列表<input type="text" name="awards.shieldunits" id="shieldunits" /></label><br />
	<label>屏蔽抽奖个人列表<input type="text" name="awards.shielduser" id="shielduser" /></label><br />
	<div id="divdata">
		<p id="datas"></p>
		<span style="cursor:pointer;color:red;" id="confirm">确认</span>
		<span style="cursor:pointer;color:red;" id="cancel">关闭</span> 
	</div>
	<div id="alldata">
		<p id="unitstp">
		<label><input name="Radio1" type="checkbox" value="1" />厂商</label><br/>
		<label><input name="Radio1"  type="checkbox" value="2" />设计院</label><br/>
		</p>
		<p id="usertp">
		<label><input name="Radio1"  type="checkbox" value="专家" />专家</label><br/>
		<label><input name="Radio1" type="checkbox" value="家属" />家属</label><br/>
		<label><input name="Radio1"  type="checkbox" value="一般" />一般</label><br/>
		</p>
		<p id="suser">
		<s:iterator status="index" value="meetinginfo.registers" id="register">
		<label><input name="Radio1"  type="checkbox" value="${register.user.id }" />${register.user.name }</label><br/>
		</s:iterator>
		</p>
		<p id="sunits">
		<s:iterator status="index" value="units" id="un">
		<label><input name="Radio1" type="checkbox" value="${un.id }" />${un.name }</label><br/>
		</s:iterator>
		</p>
	</div>
</form>
<div id="alert"></div>
</div>

</div><!--end tabwrap-->
</body>
</html>
