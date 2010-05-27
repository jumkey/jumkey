$(document).ready(function(){
	$("#header").click(function(){
		$.getJSON("ZoomImage",{},function(json){
			var ulist=$("#ulist");
			for(var p in json){
				ulist.append("<li class=\"list\"><a href=\"show?folder=1&name=${name }\"><img src=\"img/Moth_by_vhm_alex.jpg\" />"+json[p]+"</a></li>");
				//console.log(json[p]+p);
			}
			var x,y;
			$(".list img").mouseover(function(e){
				//$("#single img").attr("src",$(this).attr("src"));
				$("#single").html("<img src=\""+$(this).attr("src")+"\" />");
				$("#single").show();
			}).mousemove(function(e){
				if(e.pageX+330>$(document).width()){
					x=e.pageX-330;
				}else{
					x=e.pageX+10;
				}
				if(e.pageY+250>$(document).height()){
					y=e.pageY-250;
				}else{
					y=e.pageY+10;
				}
				$("#single").css({left:x,top:y});
			}).mouseout(function(e){
				$("#single").hide();
			});
		});
	});
	$("#top").click(function(){
		$(document.body).animate({scrollTop: $("#header").offset().top}, 1000);
		return false;
	});
	$("#bottom").click(function(){
		$(document.body).animate({scrollTop: $("#footer").offset().top}, 1000);
		return false;
	});
});