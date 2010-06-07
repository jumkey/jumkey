    // OPEN CLOSE BIG SLIDER
    $(document).ready(function() {
        $(".close_bs").click(function() {
			$(".big_slide").slideToggle("slow");
			$('.close_bs').css("display","none");
			$('.open_bs').css("display","block");
			$.cookie('big_slide', 'close');
			});
        $(".open_bs").click(function() {
			$(".big_slide").slideToggle("slow");
			$('.open_bs').css("display","none");
			$('.close_bs').css("display","block");
			$.cookie('big_slide', 'open');
			});
	// COOKIES
	// Left column state
	var big_slide = $.cookie('big_slide');
	// Right column state
	// Set the user's selection for the left column
	if (big_slide == 'close') {
		$('.big_slide').css("display","none");
		$('.open_bs').css("display","block");
		$('.close_bs').css("display","none");
	};
	if (big_slide == 'open') {
		$('.big_slide').css("display","block");
		$('.open_bs').css("display","none");
		$('.close_bs').css("display","block");
	};
    });


	 // JFlow Slider
	$(document).ready(function(){
		$("#home_slider").jFlow({
			slides: "#slider_img",
			controller: ".jFlowControl", // must be class, use . sign
			slideWrapper : "#jFlowSlide", // must be id, use # sign
			selectedWrapper: "jFlowSelected",  // just pure text, no sign
			width: "890px",
			height: "250px",
			easing: "easeInQuart",
			duration: 2000,
			prev: ".jFlowPrev", // must be class, use . sign
			next: ".jFlowNext" // must be class, use . sign
		});
	});
	
	// Animate
	$(document).ready(function(){
		$(".social_networks a").hover(function() {
			$(this).find("em").animate({opacity: "show", top: "-50"}, "slow");
		}, function() {
			$(this).find("em").animate({opacity: "hide", top: "-60"}, "fast");
		});
	});
	
	// Switch between list and grid item in Works page
	$(document).ready(function(){
 
		$("a.switch_thumb").toggle(function(){
		  $(this).addClass("swap"); 
		  $("ul.display").fadeOut("fast", function() {
			$(this).fadeIn("fast").addClass("thumb_view"); 
			 });
		  }, function () {
		  $(this).removeClass("swap");
		  $("ul.display").fadeOut("fast", function() {
			$(this).fadeIn("fast").removeClass("thumb_view");
			});
		}); 
	
	});
	
	
	// Fade loading images
	$(document).ready(function(){
		$(".fade").fadeTo(1, 0);
	});
	
	$(window).load(function(){
		$(".fade").fadeTo("slow", 1);
	});
	
	// Big Fader
	$(document).ready(function(){
				$('ul#portfolio').innerfade({
				speed: 2000,
				timeout: 6000,
				type: 'random',
				containerheight: 	'400px',
				slide_timer_on: 	'yes',
				slide_ui_parent: 	'portfolio'
				});
	});
	
	
	// TWITTER DISPLAY // 
    getTwitters('deadTweets', {
		id: 'Devilcantburn',
        prefix: '',  // If you want display your avatar and name <img height="16" width="16" src="%profile_image_url%" /><a href="http://twitter.com/%screen_name%">%name%</a> said:<br/>
        clearContents: false, // leave the original message in place
        count: 1, 
        withFriends: true,
        ignoreReplies: false,
        newwindow: true
    });
	
	// Hover move listing
	$(document).ready(function() {
			$(".listing_col a").hover(function() {	//On hover...
				$(this).find("span").stop().animate({ 
					marginLeft: "10" //Find the span tag and move it up 40 pixels
				}, 250);
			} , function() { //On hover out...
				$(this).find("span").stop().animate({
					marginLeft: "0" //Move the span back to its original state (0px)
				}, 250);
			});
	});