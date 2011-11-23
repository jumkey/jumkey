function isIE() { // 是不是IE?
	if (window.navigator.userAgent.toLowerCase().indexOf("msie") >= 1)
		return true;
	else
		return false;
}
if (!isIE()) { //定义 firefox innerText
	HTMLElement.prototype.__defineGetter__("innerText", function() {
			var anyString = "";
			var childS = this.childNodes;
			for (var i = 0; i < childS.length; i++) {
				if (childS[i].nodeType == 1)
					// anyString += childS[i].tagName=="BR" ? "\n" :
					// childS[i].innerText;
					anyString += childS[i].innerText;
				else if (childS[i].nodeType == 3)
					anyString += childS[i].nodeValue;
			}
			return anyString;
		});
	HTMLElement.prototype.__defineSetter__("innerText", function(sText) {
			this.textContent = sText;
		});
}
function confirm(message, callback) {
	this.callback1=callback;//只有这样才能更换callback
	if ($("#dialogconfirm").length == 0) {
		$("body").append('<div id="dialogconfirm"></div>');
		$("#dialogconfirm").dialog({
					autoOpen : false,
					title : '确认框',
					modal : true,
					resizable : false,
					overlay : {
						opacity : 0.5,
						background : "black"
					},
					buttons : {
						"确定" : function() {
							callback1();
							$(this).dialog("close");
						},
						"取消" : function() {
							$(this).dialog("close");
						}
					}
				});
	}
	$("#dialogconfirm").html(message);
	$("#dialogconfirm").dialog("open");
}
function alert(message) {
	if ($("#dialogalert").length == 0) {
		$("body").append('<div id="dialogalert"></div>');
		$("#dialogalert").dialog({
					autoOpen : false,
					title : '消息框',
					height : 220,
					width :350,
					modal : true,
					resizable : false,
					overlay : {
						opacity : 0.5,
						background : "black"
					},
					buttons : {
						"确定" : function() {
							$(this).dialog("close");
						}
					}
				});
	}
	$("#dialogalert").html(message);
	$("#dialogalert").dialog("open");
}