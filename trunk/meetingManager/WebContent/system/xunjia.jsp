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
<script type="text/javascript" src="script/jquery.timePicker.js"></script>
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
		+ '<td><input name="checkbox" type="hidden" value="'+data.price.id+'" /></td>'
		+ '<td>'+data.price.units.name+'</td>'
		+ '<td>'+data.price.date+'</td>'
		+ '<td>'+data.price.address+'</td>'
		+ '<td>'+data.price.hotel+'</td>'
		+ '<td>'+data.price.price+'</td>'
		+ '<td><span onclick="addAgreement('+data.price.id+')">[<a href="javascript:;" >拟定合同</a>]</span>| <span class="edit">[<a href="javascript:void(0);" >编辑</a>]</span></td>'
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
function editAgreement(priceid){
	$("#xj").hide();
	$("#baojia").hide();
	$("#ht").show();
	
	$.post('main/jagreement_show.action', {
		"agreement.meetingInfo.price.id":priceid
	}, function(data) {
		//console.dir(data);
		$("#title").val(data.agreement.meetingInfo.title);
		$("#author").val(data.agreement.meetingInfo.author);
		
		$("#travelContact").val(data.agreement.travelContact);
		$("#travelPhone").val(data.agreement.travelPhone);
		$("#hotelContacts").val(data.agreement.hotelContacts);
		$("#hotelPhone").val(data.agreement.hotelPhone);
		$("#hoteldeposit").val(data.agreement.hoteldeposit);
		
		$("#dialog").dialog({
			buttons:{
				"修改合同":function(){
					$.post('main/jagreement_modify.action', {
						"agreement.id":data.agreement.id,
						"agreement.meetingInfo.title":$("#title").val(),
						"agreement.meetingInfo.author":$("#author").val(),
						
						"agreement.travelContact":$("#travelContact").val(),
						"agreement.travelPhone":$("#travelPhone").val(),
						"agreement.hotelContacts":$("#hotelContacts").val(),
						"agreement.hotelPhone":$("#hotelPhone").val(),
						"agreement.hoteldeposit":$("#hoteldeposit").val()
					}, function(data) {
						var result=$.parseJSON(data.result);
						if(result.success!="true"){
							$("#alert").html(result.msg).show()
							.addClass("ui-state-error ui-corner-all");
						}else{
							$("#alert").html(result.msg).show()
							.addClass("ui-state-highlight ui-corner-all");
						}
					});
				}
			}
		}).dialog("open");
	});
}
function addAgreement(priceid){
	$("#xj").hide();
	$("#baojia").hide();
	$("#ht").show();
	
	$("#dialog").dialog({
		buttons:{
			"拟定合同":function(){
				$.post('main/jagreement_add.action', {
					"agreement.meetingInfo.price.id":priceid,
					"agreement.meetingInfo.title":$("#title").val(),
					"agreement.meetingInfo.author":$("#author").val(),
					
					"agreement.travelContact":$("#travelContact").val(),
					"agreement.travelPhone":$("#travelPhone").val(),
					"agreement.hotelContacts":$("#hotelContacts").val(),
					"agreement.hotelPhone":$("#hotelPhone").val(),
					"agreement.hoteldeposit":$("#hoteldeposit").val()
				}, function(data) {
					var result=$.parseJSON(data.result);
					if(result.success!="true"){
						$("#alert").html(result.msg).show()
						.addClass("ui-state-error ui-corner-all");
					}else{
						$("#alert").html(result.msg).show()
						.addClass("ui-state-highlight ui-corner-all");
					}
				});
			}
		}
	}).dialog("open");
}
//入口
$(document).ready(function(){
	//日期时间
	$(".time").datetimepicker({
		dateFormat:'yyyy-mm-dd HH:MM:ss',minDate: 0, maxDate: '+2y'
	});
	//时间
	//$(".time").timePicker();
	//日期
	$(".date").datepicker({
		dateFormat:'yy-mm-dd',minDate: 0, maxDate: '+2y'
	}).datepicker($.datepicker.regional["zh-CN"]);
	var selectedItems;//批量删除用
	//初始化dialog
	$("#dialog").dialog({
		autoOpen: false,modal: true,overlay: { opacity: 0.5, background: "black" },
		title:"编辑",position:"center",width:600,height:600,
		close: function(event, ui){
			$("#alert").hide();
			//清空form数据
			$("#form1")[0].reset();
			$("#xj").show();
			$("#baojia").show();
			$("#ht").hide();
		}
	});
	//修改报价
	$(".askprice").live("click",function(){
		var $this_=$(this);//保存当前this对象
		$("#xj").hide();
		//设置form数据
		$("#priceid").val($(this).parent().parent().find("input").val());
		$("#price").val($(this).parent().parent()[0].cells[5].innerHTML);

		$("#dialog").dialog({
			buttons:{
				"修改":function(){
					$.post('main/jprice_askprice.action', {
						"price.id":$("#priceid").val(),
						"price.price":$("#price").val(),
						//报价
						"price.meetingspaceFee":$("#meetingspaceFee").val(),
						"price.housingFee":$("#housingFee").val(),
						"price.productionFee":$("#productionFee").val(),
						"price.bannersFee":$("#bannersFee").val(),
						"price.projectorFee1":$("#projectorFee1").val(),
						//"price.projectorFee2":$("#projectorFee2").val(),
						"price.teaFee":$("#teaFee").val(),
						"price.fruitFee":$("#fruitFee").val(),
						"price.mealFee":$("#mealFee").val(),
						"price.fareFee1":$("#fareFee1").val(),
						"price.fareFee2":$("#fareFee2").val(),
						"price.fareFee3":$("#fareFee3").val(),
						"price.activities":$("#activities").val(),
						"price.bookingFee":$("#bookingFee").val(),
						"price.travelFee1":$("#travelFee1").val(),
						"price.travelFee2":$("#travelFee2").val(),
						"price.travelFee3":$("#travelFee3").val(),
						"price.taxesFee":$("#taxesFee").val()
					}, function(data) {
						
						var result=$.parseJSON(data.result);
						if(result.success!="true"){
							$("#alert").html(result.msg).show()
							.addClass("ui-state-error ui-corner-all");
						}else{
							$("#alert").html(result.msg).show()
							.addClass("ui-state-highlight ui-corner-all");
							//更新table
							updateTab($this_.parent().parent()[0],data);
							//$("#dialog").dialog("close");
						}
					});
				}
			}
		}).dialog("open");
	});
	//修改
	$(".edit").live("click",function(){
        var $this_=$(this);//保存当前this对象
        $.post('main/jprice_show.action', {
            "price.id":$this_.parent().parent().find("input").val()
        }, function(data) {
            //console.dir(data);
            //设置form数据
            $("#priceid").val($this_.parent().parent().find("input").val());
            $("#price").val(data.price.price);
            $("#unitsname").val(data.price.unitsname);
            $("#pdate").val(data.price.date);
            $("#address").val(data.price.address);
            $("#hotel").val(data.price.hotel);
            //添加
            $("#hotelTraffic").val(data.price.hotelTraffic);
            $("#hotelenvironment").val(data.price.hotelenvironment);
            $("#minnumber").val(data.price.minnumber);
            $("#maxnumber").val(data.price.maxnumber);

            //$("#roomTypeid${st.index}").val(prt[${st.index}].roomType.id);
            //$("#minRoomNumber${st.index}").val(prt[${st.index}].minRoomNumber);
            //$("#maxRoomNumber${st.index}").val(prt[${st.index}].maxRoomNumber);

            $("#registTime").val(data.price.registTime);
            $("#roomMinSize").val(data.price.roomMinSize);
            $("#roomMaxSize").val(data.price.roomMaxSize);
            $("#travel").val(data.price.travel);
            $("#mealMinSize").val(data.price.mealMinSize);
            $("#mealMaxSize").val(data.price.mealMaxSize);
            $("#mealType1").val(data.price.mealType1);
            $("#mealType2").val(data.price.mealType2);
            $("#meal").val(data.price.meal);
            //报价
            $("#meetingspaceFee").val(data.price.meetingspaceFee);
            $("#housingFee").val(data.price.housingFee);
            $("#productionFee").val(data.price.productionFee);
            $("#bannersFee").val(data.price.bannersFee);
            $("#projectorFee1").val(data.price.projectorFee1);
            //$("#projectorFee2").val(data.price.projectorFee2);
            $("#teaFee").val(data.price.teaFee);
            $("#fruitFee").val(data.price.fruitFee);
            $("#mealFee").val(data.price.mealFee);
            $("#fareFee1").val(data.price.fareFee1);
            $("#fareFee2").val(data.price.fareFee2);
            $("#fareFee3").val(data.price.fareFee3);
            $("#activities").val(data.price.activities);
            $("#bookingFee").val(data.price.bookingFee);
            $("#meetingType").val(data.price.meetingType);
            $("#meetingDays").val(data.price.meetingDays);
            $("#travelFee1").val(data.price.travelFee1);
            $("#travelFee2").val(data.price.travelFee2);
            $("#travelFee3").val(data.price.travelFee3);
            $("#taxesFee").val(data.price.taxesFee);
            
    		$("#dialog").dialog({
    			buttons:{
    				"修改":function(){
    					$.post('main/jprice_modify.action', {
    						"price.id":$("#priceid").val(),
    						"price.price":$("#price").val(),
    						//"price.units.id":$("#units").val(),
    						"price.unitsname":$("#unitsname").val(),
    						"price.date":$("#pdate").val(),
    						"price.address":$("#address").val(),
    						"price.hotel":$("#hotel").val(),
    						//添加
    						"price.hotelTraffic":$("#hotelTraffic").val(),
    						"price.hotelenvironment":$("#hotelenvironment").val(),
    						"price.minnumber":$("#minnumber").val(),
    						"price.maxnumber":$("#maxnumber").val(),
    						<s:iterator status="st" value="rt" id="roomtype">
    						"prt[${st.index}].roomType.id":$("#roomTypeid${st.index}").val(),
    						"prt[${st.index}].minRoomNumber":$("#minRoomNumber${st.index}").val(),
    						"prt[${st.index}].maxRoomNumber":$("#maxRoomNumber${st.index}").val(),
    						</s:iterator>
    						"price.registTime":$("#registTime").val(),
    						"price.roomMinSize":$("#roomMinSize").val(),
    						"price.roomMaxSize":$("#roomMaxSize").val(),
    						"price.travel":$("#travel").val(),
    						"price.mealMinSize":$("#mealMinSize").val(),
    						"price.mealMaxSize":$("#mealMaxSize").val(),
    						"price.mealType1":$("#mealType1").val(),
    						"price.mealType2":$("#mealType2").val(),
    						"price.meal":$("#meal").val(),
    						//报价
    						"price.meetingspaceFee":$("#meetingspaceFee").val(),
    						"price.housingFee":$("#housingFee").val(),
    						"price.productionFee":$("#productionFee").val(),
    						"price.bannersFee":$("#bannersFee").val(),
    						"price.projectorFee1":$("#projectorFee1").val(),
    						//"price.projectorFee2":$("#projectorFee2").val(),
    						"price.teaFee":$("#teaFee").val(),
    						"price.fruitFee":$("#fruitFee").val(),
    						"price.mealFee":$("#mealFee").val(),
    						"price.fareFee1":$("#fareFee1").val(),
    						"price.fareFee2":$("#fareFee2").val(),
    						"price.fareFee3":$("#fareFee3").val(),
    						"price.activities":$("#activities").val(),
    						"price.bookingFee":$("#bookingFee").val(),
    						"price.meetingType":$("#meetingType").val(),
    						"price.meetingDays":$("#meetingDays").val(),
    						"price.travelFee1":$("#travelFee1").val(),
    						"price.travelFee2":$("#travelFee2").val(),
    						"price.travelFee3":$("#travelFee3").val(),
    						"price.taxesFee":$("#taxesFee").val()
    					}, function(data) {
    						var result=$.parseJSON(data.result);
    						if(result.success!="true"){
    							$("#alert").html(result.msg).show()
    							.addClass("ui-state-error ui-corner-all");
    						}else{
    							$("#alert").html(result.msg).show()
    							.addClass("ui-state-highlight ui-corner-all");
    							//更新table
    							updateTab($this_.parent().parent()[0],data);
    							//$("#dialog").dialog("close");
    						}
    					});
    				}
    			}
    		}).dialog("open");
        });
	});
	//删除
	$(".delete").live("click",function(){
		var $this_=$(this);//保存父this
		confirm("确认删除",function(){
			$.ajax({
				url: "main/jprice_delete.action",
				data: {
					"price.id": $this_.parent().parent().find("input").val()
				},
				type: "post",
				dataType: "json",
				success: function(data){
					var result=$.parseJSON(data.result);
					
					if (result.success=="true") {
						alert(result.msg);
						//删除table列
						$this_.parent().parent().remove();
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
					$.post('main/jprice_add.action', {
						"price.unitsname":$("#unitsname").val(),
						"price.date":$("#pdate").val(),
						"price.address":$("#address").val(),
						"price.hotel":$("#hotel").val(),
						//添加
						"price.hotelTraffic":$("#hotelTraffic").val(),
						"price.hotelenvironment":$("#hotelenvironment").val(),
						"price.minnumber":$("#minnumber").val(),
						"price.maxnumber":$("#maxnumber").val(),
						<s:iterator status="st" value="rt" id="roomtype">
						"prt[${st.index}].roomType.id":$("#roomTypeid${st.index}").val(),
						"prt[${st.index}].minRoomNumber":$("#minRoomNumber${st.index}").val(),
						"prt[${st.index}].maxRoomNumber":$("#maxRoomNumber${st.index}").val(),
						</s:iterator>
						"price.registTime":$("#registTime").val(),
						"price.roomMinSize":$("#roomMinSize").val(),
						"price.roomMaxSize":$("#roomMaxSize").val(),
						"price.mealMinSize":$("#mealMinSize").val(),
						"price.mealMaxSize":$("#mealMaxSize").val(),
						"price.travel":$("#travel").val(),
						"price.mealType1":$("#mealType1").val(),
						"price.mealType2":$("#mealType2").val(),
						"price.meal":$("#meal").val(),
						"price.activities":$("#activities").val(),
						"price.meetingDays":$("#meetingDays").val(),
						"price.meetingType":$("#meetingType").val(),
						//报价
						"price.price":$("#price").val(),
						"price.meetingspaceFee":$("#meetingspaceFee").val(),
						"price.housingFee":$("#housingFee").val(),
						"price.productionFee":$("#productionFee").val(),
						"price.bannersFee":$("#bannersFee").val(),
						"price.projectorFee1":$("#projectorFee1").val(),
						//"price.projectorFee2":$("#projectorFee2").val(),
						"price.teaFee":$("#teaFee").val(),
						"price.fruitFee":$("#fruitFee").val(),
						"price.mealFee":$("#mealFee").val(),
						"price.fareFee1":$("#fareFee1").val(),
						"price.fareFee2":$("#fareFee2").val(),
						"price.fareFee3":$("#fareFee3").val(),
						"price.bookingFee":$("#bookingFee").val(),
						"price.travelFee1":$("#travelFee1").val(),
						"price.travelFee2":$("#travelFee2").val(),
						"price.travelFee3":$("#travelFee3").val(),
						"price.taxesFee":$("#taxesFee").val()
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
	$("#delselect").click(function(){
		selectedItems = new Array();//只能定义全局变量，否则进入confirm后值会变为第一次设置的值（不知道原因）
		$("input[@name='checkbox']:checked").each(function(){selectedItems.push($(this).val());});
		if (selectedItems.length == 0){
			alert("请选择要删除的行");
		}else{
			confirm("确认删除",function(){
				
				$.ajax({
					type: "POST",
					url: "main/jprice_delselect.action",
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
        <td><span style="background: url('images/311.gif') no-repeat; padding-left: 17px; font-size:14px;" class="STYLE4">询价列表</span></td>
        <td style="background: url('images/tab_07.gif') no-repeat; width: 14px"></td>
      </tr>
    </table></div>
    <div id="tabbody" style="width: 100%;height: 100%;"><table>
      <tr>
        <td style="background: url('images/tab_12.gif'); width: 9px;">&nbsp;</td>
        <td bgcolor="e5f1d6"><table id="list" style="width: 100%;border-spacing: 1px;border-collapse: separate; background-color: #CECECE;">
          <tr class="tabTitle">
			<td rowspan="2">会议时间</td>
			<td rowspan="2">酒店名称</td>
			<td colspan="3">房价</td>
			<td colspan="3">会议室费用</td>
			<td rowspan="2">投影仪费用</td>
			<td rowspan="2">背板制作费</td>
			<td rowspan="2">条幅费</td>
			<td rowspan="2">餐费</td>
			<td rowspan="2">旅游费</td>
			<td rowspan="2">茶水费</td>
			<td rowspan="2">操作</td>
          </tr>
          <tr class="tabTitle">
			<td>标准单人间</td>
			<td>双间</td>
			<td>类型</td>
			<td>大</td>
			<td>中</td>
			<td>小</td>
          </tr>
          <s:iterator status="index" value="list" id="price1">
          <s:if test="#price1.meetingInfo==null"></s:if>
          <tr class="tabItem">
            <td><s:date name="#price1.date" format="yyyy-MM-dd" /></td>
            <td>${price1.hotel }<input name="checkbox" type="hidden" value="${price1.id }" /></td>
            <td>${price1.id }</td>
            <td>${price1.unitsname }</td>
            <td>${price1.address }</td>
            <td>${price1.price }</td>
            <td>${price1.minnumber }-${price1.maxnumber }</td>
            <td>${price1.roomNumber }</td>
            <td>${price1.projectorFee1 }</td>
            <td>${price1.productionFee }</td>
            <td>${price1.bannersFee }</td>
            <td>${price1.mealType1 }</td>
            <td>${price1.travelFee1 }</td>
            <td>${price1.teaFee }</td>
            <td nowrap="nowrap">
            <span class="edit">[<a href="javascript:void(0);" >编辑</a>]</span>|
            <s:if test="#price1.meetingInfo.agreements!=null">
            <span onclick="editAgreement(${price1.id })">[<a href="javascript:;" >修改合同</a>]</span>|
            <del>[删除]</del>
            </s:if>
            <s:else><span onclick="addAgreement(${price1.id })">[<a href="javascript:;" >签订合同</a>]</span>|
            <span class="delete">[<a href="javascript:void(0);">删除</a>]</span>
            </s:else>
            </td>
          </tr></s:iterator>
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
	<span id="add"><a href="javascript:void(0);">新增询价</a></span> | <!-- <span id="delselect"><a href="javascript:void(0);">删除选中</a></span> | --><a href="javascript:location.reload();">刷新</a>
</div>
<script type="text/javascript">

</script>
<div id="dialog" class="flora">
<form id="form1" name="form1" method="post" action="">
<span id="xj">
	<input type="hidden" name="price.id" value="" id="priceid"/><br/>
	<input type="hidden" name="price.units.id" id="units" value=""/><br />
	<label for="unitsname">单位名称</label>
	<input type="text" name="price.units.name" id="unitsname" value=""/><br />
	<!-- <span id="uu"></span>
	<a href="javascript:checkunitsid();" class="ui-state-default">获取单位信息</a><br />
	<script type="text/javascript">
		function select(id,name){
			$("#units").val(id);
			$("#unitsname").val(name);
		}
		function checkunitsid(){
			$.post('main/jprice_checkunitsname.action', {
				"unitsname":$("#unitsname").val()
			}, function(data) {
				var result=$.parseJSON(data.result);
				if(result.units.length>0){
					$("#uu").html("");
					$("#units").val(result.units[0].id);
					$("#unitsname").val(result.units[0].name);//默认填入第一项
					for(var i=0;i<result.units.length;i++){
						$("#uu").html($("#uu").html()+"<a class=\"green\" href=\"javascript:select('"+result.units[i].id+"','"+result.units[i].name+"');\">"+result.units[i].name+"</a><br/>");
					}
				}else{
					$("#units").val("");
					$("#uu").html("没有信息<br/>");
				}
			});
		}
	</script> -->
	<label for="pdate">会议时间</label>
	<input type="text" name="price.date" class="date" id="pdate" /><br />
	<label for="address">地点</label>
	<input type="text" name="price.address" id="address" /><br />
	<label for="hotel">酒店名称</label>
	<input type="text" name="price.hotel" id="hotel" /><br />

	<label for="hotelTraffic">酒店交通</label>
	<input type="text" name="price.hotelTraffic" id="hotelTraffic" /><br/>
	<label for="hotelenvironment">周边环境</label>
	<input type="text" name="price.hotelenvironment" id="hotelenvironment" /><br/>
	<label for="number">会议人数</label>
	<input type="text" name="price.minnumber" id="minnumber" size="8" />至
	<input type="text" name="price.maxnumber" id="maxnumber" size="8" /><br/>
	<label for="roomNumber">客房数</label><br/>
	<s:iterator status="st" value="rt" id="roomtype">
	<s:hidden name="prt[%{#st.index}].roomType.id" id="roomTypeid%{#st.index}" value="%{#roomtype.id }" />
	${roomtype.type }<s:textfield theme="simple" name="prt[%{#st.index}].minRoomNumber" id="minRoomNumber%{#st.index}" size="8" />至
	<s:textfield theme="simple" name="prt[%{#st.index}].maxRoomNumber" id="maxRoomNumber%{#st.index}" size="8" /><br/>
	</s:iterator>
	<label for="registTime">报到时间</label>
	<input type="text" name="price.registTime" class="date" id="registTime" /><br/>
	<label for="roomSize">会议室规模</label>
	<input type="text" name="price.roomMinSize" id="roomMinSize" size="8" />至
	<input type="text" name="price.roomMaxSize" id="roomMaxSize" size="8" /><br/>
	<label for="mealSize">餐厅规模</label>
	<input type="text" name="price.mealMinSize" id="mealMinSize" size="8" />至
	<input type="text" name="price.mealMaxSize" id="mealMaxSize" size="8" /><br/>
	<label for="travel">会议行程</label><br />
	<textarea name="price.travel" id="travel" rows="8" cols="50"></textarea><br/>
	<label for="mealType">用餐形式</label><br />
	<label><input type="checkbox" name="price.mealType1" id="mealType1" value="1" />自助餐</label>
	<label><input type="checkbox" name="price.mealType2" id="mealType2" value="1" />桌餐</label><br/>
	<label for="meal">餐谱</label>
	<input type="file" name="price.meal" id="meal" /><br/>
	<label for="activities">活动</label>
	<input type="file" name="price.activities" id="activities" /><br/>
	<label for="meetingDays">会议天数</label>
	<input type="text" name="price.meetingDays" id="meetingDays" size="8" /><br/>
	<label for="meetingType">会议类型</label>
	<input type="text" name="price.meetingType" id="meetingType" /><br/>
</span>
<span id="baojia">
	<label for="price">报价</label>
	<input type="text" name="price.price" id="price" size="8" />元<br />
	<label for="meetingspaceFee">会议室场地费</label>
	<input type="text" name="price.meetingspaceFee" id="meetingspaceFee" /><br/>
	<label for="housingFee">住房费</label>
	<input type="text" name="price.housingFee" id="housingFee" /><br/>
	<label for="productionFee">背板制作费</label>
	<input type="text" name="price.productionFee" id="productionFee" size="8" /><br/>
	<label for="bannersFee">条幅费</label>
	<input type="text" name="price.bannersFee" id="bannersFee" size="8" /><br/>
	<label for="projectorFee">投影仪费</label><br/>
	<input type="text" name="price.projectorFee1" id="projectorFee1" />元<br/>
	<label for="teaFee">茶水费</label>
	<input type="text" name="price.teaFee" id="teaFee" size="8" /><br/>
	<label for="fruitFee">水果费</label>
	<input type="text" name="price.fruitFee" id="fruitFee" size="8" /><br/>
	<label for="mealFee">餐费标准</label>
	<input type="text" name="price.mealFee" id="mealFee" /><br/>
	<label for="fareFee1">车费一</label>
	<input type="text" name="price.fareFee1" id="fareFee1" />元<br/>
	<label for="fareFee2">车费二</label>
	<input type="text" name="price.fareFee2" id="fareFee2" />元<br/>
	<label for="fareFee3">车费三</label>
	<input type="text" name="price.fareFee3" id="fareFee3" />元<br/>
	<label for="bookingFee">订票</label>
	<input type="text" name="price.bookingFee" id="bookingFee" /><br/>
	<label for="taxesFee">税金</label>
	<input type="text" name="price.taxesFee" id="taxesFee" size="8" />元<br/>
	<label for="travelFee1">旅游费一</label>
	<input type="text" name="price.travelFee1" id="travelFee1" size="8" />元<br/>
	<label for="travelFee2">旅游费二</label>
	<input type="text" name="price.travelFee2" id="travelFee2" size="8" />元<br/>
	<label for="travelFee3">旅游费三</label>
	<input type="text" name="price.travelFee3" id="travelFee3" size="8" />元<br/>
</span>
<span id="ht" style="display: none;">
	<span class="red">以下为会议信息</span><br />
	<label for="title">会议题目</label>
	<input type="text" name="agreement.meetingInfo.title" id="title" /><br />
	<!-- <label for="author">会议主讲</label>
	<input type="text" name="agreement.meetingInfo.author" id="author" /><br />
	<label for="amdate">会议时间</label>
	<input type="text" name="agreement.meetingInfo.date" disabled="disabled" id="amdate" /><br />
	<label for="amaddress">会议地点</label>
	<input type="text" name="agreement.meetingInfo.address" id="amaddress" disabled="disabled" /><br />
	<label for="desc1">会议简介</label><br />
	<textarea name="agreement.meetingInfo.desc1" id="desc1" rows="8" cols="50" disabled="disabled"></textarea><br /> -->
	<span class="red">以下为合同信息</span><br />
	<!-- <label for="adate">报到时间</label>
	<input type="text" name="agreement.date" value="" disabled="disabled" id="adate"/><br/>
	<label for="mdate">会议日期</label>
	<input type="text" name="agreement.mdate" value="" disabled="disabled" id="mdate"/><br/> -->
	<label for="travelContact">旅行社联系人</label>
	<input type="text" name="agreement.travelContact" id="travelContact"/><br/>
	<label for="travelPhone">旅行社电话</label>
	<input type="text" name="agreement.travelPhone" id="travelPhone"/><br/>
	<label for="hotelContacts">酒店联系人</label>
	<input type="text" name="agreement.hotelContacts" id="hotelContacts"/><br/>
	<label for="hotelPhone">酒店电话</label>
	<input type="text" name="agreement.hotelPhone" id="hotelPhone"/><br/>
	<label for="hoteldeposit">酒店押金</label>
	<input type="text" name="agreement.hoteldeposit" id="hoteldeposit"/><br/>
</span>
</form>
<div id="alert"></div>
</div>

</div><!--end tabwrap-->
</body>
</html>
