function confirm(message, callback) {
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
							callback();
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