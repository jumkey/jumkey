$(document).ready(function(){
	var docW=$(document).width();
	var docH=$(document).height();
	var x,y;
	$(window).resize(function(){
		docW=$(document).width();
		docH=$(document).height();
	});
	$(".list img").mouseover(function(e){
		$("#single img").attr("src",$(this).attr("src"));
		$("#single").show();
	}).mousemove(function(e){
		if(e.pageX+330>docW){
			x=e.pageX-320-10;
		}else{
			x=e.pageX+10;
		}
		if(e.pageY+250>docH){
			y=e.pageY-240-10;
		}else{
			y=e.pageY+10;
		}
		$("#single").css({left:x,top:y});
	}).mouseout(function(e){
		//$("#single").remove();
		$("#single").hide();
	});
});