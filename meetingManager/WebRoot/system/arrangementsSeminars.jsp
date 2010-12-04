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
<script type="text/javascript" src="script/jquery.timePicker.js"></script>
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
function selectThisTr(obj){
       if($(obj).find("td").attr("class")=="td-selected"){
       	 $("#list tr").addClass("tabItem");
       	 $("#list td").removeClass("td-selected");
       	 $(obj).removeClass("tr-selected");
       }else{
       	  $("#list tr").removeClass("tr-selected");
       	  $("#list tr").addClass("tabItem");
	      $("#list td").removeClass("td-selected");
	      $(obj).removeClass("tabItem");
	      $(obj).addClass("tr-selected");
	      $(obj).find("td").addClass("td-selected");
       }
}
function lineMove(type){
	if($(".tr-selected").length>0){
		var number = $(".tr-selected td:eq(1)").html();
		var id = $(".tr-selected td:eq(0) input").val();
		var lectureId = $(".tr-selected td:eq(6)").html();
		var timelength = $(".tr-selected td:eq(3)").html();
		var recorddate = $(".tr-selected td:eq(4)").html();
		var arrangementsId = $("#arrangementsId").val();
		var recorder = $(".tr-selected td:eq(5)").html();
		if(type=="top")
			number=1;
		else if(type=="up")
			number=(Number(number) - 1);
		else if(type=="down")
			number=(Number(number) + 1);
		else if(type=="foot")
			number= 999;
		else
			return;
		if(number<=0||number>999)
			return;
		$.post('main/doarrangementsSeminars_modify.action', {
			"arrangementsSeminars.id":id,
			"arrangementsSeminars.number":number,
			"arrangementsSeminars.lecture.id":lectureId,
			"arrangementsSeminars.timelength":timelength,
			"arrangementsSeminars.recorddate":recorddate,
			"arrangementsSeminars.meetingArrangements.id":arrangementsId,
			"arrangementsSeminars.recorder":recorder 
		}, function(data) {
			var result=$.parseJSON(data.result);
			if(result.success!="true"){
				$("#alert").html(result.msg).show()
				.addClass("ui-state-error ui-corner-all");
			}else{
				$("#alert").html(result.msg).show()
				.addClass("ui-state-highlight ui-corner-all");
				 location.reload();

			}
		});
	}
	else{
		alert("请选择您要移动的行");
	}
}

//入口
$(document).ready(function(){
	$(".time").timePicker();
	//日期 
	$(".date").datepicker({
		//changeMonth: true, changeYear: true,
		dateFormat:'yy-mm-dd',minDate: 0, maxDate: '+2y'
	}).datepicker($.datepicker.regional["zh-CN"]);
	var selectedItems;//批量删除用
	//初始化dialog
	$("#dialog").dialog({
		autoOpen: false,modal: true,overlay: { opacity: 0.5, background: "black" },
		title:"编辑",position:"center",width:300,height:500,
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
		$("#form1")[0].reset(); 
		var $this_=$(this);//保存当前this对象
		//设置form数据		
		$("#id").val($(this).parent().find("input").val());
		$("#number").val($(this).parent()[0].cells[1].innerHTML);
		$("#lectureId").val($(this).parent()[0].cells[6].innerHTML);
		$("#timelength").val($(this).parent()[0].cells[3].innerHTML);
		$("#recorder").val($(this).parent()[0].cells[5].innerHTML);
		$("#recorddate").val($(this).parent()[0].cells[4].innerHTML);
		
		// $("#meetingroom").get(0).selectedIndex=i;
		$("#dialog").dialog({
			buttons:{
				"修改":function(){
					$.post('main/doarrangementsSeminars_modify.action', {
						"arrangementsSeminars.id":$("#id").val(),
						"arrangementsSeminars.number":$("#number").val(),
						"arrangementsSeminars.lecture.id":$("#lectureId").val(),
						"arrangementsSeminars.timelength":$("#timelength").val(),
						"arrangementsSeminars.recorddate":$("#recorddate").val(),
						"arrangementsSeminars.meetingArrangements.id":$("#arrangementsId").val(),
						"arrangementsSeminars.recorder":$("#recorder").val() 
					}, function(data) {
						var result=$.parseJSON(data.result);
						if(result.success!="true"){
							$("#alert").html(result.msg).show()
							.addClass("ui-state-error ui-corner-all");
						}else{
							$("#alert").html(result.msg).show()
							.addClass("ui-state-highlight ui-corner-all");
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
				url: "main/doarrangementsSeminars_delete.action",
				data: {
					"arrangementsSeminars.id": $this_.parent().find("input").val()
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
		$("#form1")[0].reset();
		$("#dialog").dialog({
			buttons:{
				"新增":function(){
					$.post('main/doarrangementsSeminars_add.action', {
					    "arrangementsSeminars.number":$("#number").val(),
						"arrangementsSeminars.lecture.id":$("#lectureId").val(),
						"arrangementsSeminars.timelength":$("#timelength").val(),
						"arrangementsSeminars.recorddate":$("#recorddate").val(),
						"arrangementsSeminars.meetingArrangements.id":$("#arrangementsId").val(),
						"arrangementsSeminars.recorder":$("#recorder").val()
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
					url: "main/doarrangementsSeminars_delselect.action",
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
        <td><span style="background: url('images/311.gif') no-repeat; padding-left: 17px; font-size:14px;" class="STYLE4">安排讲座</span></td>
        <td style="background: url('images/tab_07.gif') no-repeat; width: 14px"></td>
      </tr>
    </table></div>
    <div id="tabbody" style="width: 100%;height: 100%;"><table id="mytable">
      <tr>
        <td style="background: url('images/tab_12.gif'); width: 9px;">&nbsp;</td>
        <td bgcolor="e5f1d6"><table id="list" style="width: 100%;border-spacing: 1px;border-collapse: separate; background-color: #CECECE;">
          <tr class="tabTitle">
            <td width="12%">选择<input id="arrangementsId" type="hidden" value="${arrangementsId}" /></td>
            <td width="10%">顺序号</td>
            <td width="30%">讲座编号(讲座标题/演讲人)</td>
            <td width="10%">时长</td>
            <td width="10%">记录日期</td>
            <td width="10%">记录人</td>
            <td width="8%">编辑</td>
            <td width="8%">删除</td>
          </tr>
          <s:iterator status="index" value="list" id="arrangementsSeminars">
          <tr class="tabItem" onclick="selectThisTr(this)">
            <td><input name="checkbox" type="checkbox" value="${arrangementsSeminars.id }" /></td>
            <td>${arrangementsSeminars.number }</td>
            <td>${arrangementsSeminars.lecture.id }---(${arrangementsSeminars.lecture.subject }/${arrangementsSeminars.lecture.speakers.name })</td>
            <td>${arrangementsSeminars.timelength }</td>
            <td>${arrangementsSeminars.recorddate }</td>
            <td>${arrangementsSeminars.recorder }</td>
            <td class="hideborder">${arrangementsSeminars.lecture.id }</td>
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
	<span id="add"><a href="javascript:void(0);">新增</a></span> | <span id="delselect"><a href="javascript:void(0);">删除选中</a></span> | <a href="javascript:location.reload();">刷新</a> | 
	<a href="javascript:lineMove('top');">置顶</a>| <a href="javascript:lineMove('up');">上移</a> | <a href="javascript:lineMove('down');">下移</a> | <a href="javascript:lineMove('foot');">置底</a> 
</div>
<script type="text/javascript">

</script>
<div id="dialog" class="flora">
<form id="form1" name="form1" method="post" action="">
  <input type="hidden" name="arrangementsSeminars.id" value="" id="id"/><br/>
  <label for="number">顺序号</label>
  <input type="text" name="arrangementsSeminars.number" id="number" /><br />
  <label for="lectureId">讲座编号</label>
  <select  name="arrangementsSeminars.lecture.id" id="lectureId" >
  	<s:iterator status="index" value="lecturelist" id="lecture">
  	 <option value="${lecture.id }">${lecture.subject }</option>
  	 </s:iterator>
  </select><br />
  <label for="timelength">时长(分钟)</label>
  <input type="text" name="arrangementsSeminars.timelength" id="timelength" /><br />
  <label for="recorddate">记录日期</label>
  <input type="text" name="arrangementsSeminars.recorddate" class="date" id="recorddate" /><br />
  <label for="recorder">记录人</label>
  <input type="text" name="arrangementsSeminars.recorder" id="recorder" /><br />
</form>
<div id="alert"></div>
</div>

</div><!--end tabwrap-->
</body>
</html>
