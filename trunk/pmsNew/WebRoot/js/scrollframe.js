//项目台帐ScrollFrame表现控制
var currentpos = 0;
var endpos = 0;
var startpos = 0;
var midpoint = 0;
var delta = 0;
var delay = 0;
var speed = 3;
var direction = 0;
var steps = 0;
var s = new Array(0);
var t = 0;
var currentstep = 0;
var imagedisplayed = 0;
var animating = 0;

var fading = 0;
var slidethrough = 1;

var e = new Image();
var p = new Array(0);

var newpage="";

function doScroll(newx) {
	startpos = currentpos;
	endpos = (newx-1)*680;
	midpoint = startpos + (endpos-startpos) / 2;
	s.length = 0;
	delta = 0;
	(currentpos<endpos) ? direction = 1 : direction = 0;	
	t = startpos;
	while (((t<midpoint) & (direction==1)) | ((t>midpoint) & (direction==0))) {
		s[s.length]=t;
		delta += speed;		
		(direction==1) ? t += delta : t -= delta;
	}	
	steps = s.length;	
	for (t=1; t<=steps; t++) {
		s[s.length] = midpoint + (midpoint - s[steps-t]);
	}
	
	steps = s.length;	
	currentstep = 0;		
	loopScroll();
}

function loopScroll() {
	if (currentstep<steps) {
		currentpos = s[currentstep];
		scrollTo(currentpos,0);
		currentstep += 1;
		setTimeout("loopScroll();",delay);
	} else {
		if (newpage != "") { window.location=newpage; }
	}
}

function goto(pagename) {
	newpage = pagename;
	doScroll(0);
}