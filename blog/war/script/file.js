var FileManager={
	//上传文件数0开始
	fileCount:-1,
	// 通过Ajax将File对象发送到服务器端
	uploadFiles:function(files) {
		$("#message").append("上传" + files.length + "个文件...<br />");
		for(var i=0; i < files.length; i++) {
			$("#message").append(files[i].fileName+"<br/><div class=\"loader\"><div></div></div><br/>");
			var xhr = new XMLHttpRequest;
			xhr.open('post', 'servlet/Upload?test=11111111111', true);
			
			this.fileCount=this.fileCount+1;
			xhr.upload.i1i=this.fileCount;//传递参数用
			
			xhr.upload.onprogress = function(e){
				console.log("showProgress");
				$(".loader div:eq("+this.i1i+")").css({width: Math.round(e.loaded/e.total*100)+"%"});
			};
			xhr.upload.onload = function(){
				console.log("finishLoad");
				$(".loader div:eq("+this.i1i+")").css({"background-color": "green"});
			};
			xhr.onprogress = function(){
				console.log("showAjaxProgress");
			};
			xhr.onload = function(){
				console.log("finishAjaxLoad");
			};
			xhr.onreadystatechange = function(){
				console.log("ready"+this.readyState);
				if (this.readyState != 4){
					return;
				}
				$("#message").append("<div class=\"data_content\">成功上传文件,文件内容：<hr /><pre>" + this.responseText + "</pre></div>");
			};
			
			xhr.setRequestHeader('Content-Type', 'multipart/form-data');
			xhr.setRequestHeader('X-File-Name', encodeURI(files[i].fileName)); // 将文件名传递给服务器端
			xhr.setRequestHeader('X-File-Size', files[i].fileSize);
			xhr.send(files[i]); // 将file对象发送到服务器端 
		}
	},
	// 用户选择文件时处理文件上传
	handleFile:function(e) {
		this.uploadFiles(e.files);
	},
	showProgress:function(e){
		console.log("showProgress");
		$(".loader div:eq("+this.i1i+")").css({width: Math.round(e.loaded/e.total*100)+"%"});
	},
	finishLoad:function(){
		console.log("finishLoad");
		$(".loader div:eq("+this.i1i+")").css({"background-color": "green"});
	},
	showAjaxProgress:function(){
		console.log("showAjaxProgress");
	},
	finishAjaxLoad:function(){
		console.log("finishAjaxLoad");
	},
	ready:function(){
		console.log("ready"+this.readyState);
		if (this.readyState != 4){
			return;
		}
		$("#message").append("<div class=\"data_content\">成功上传文件,文件内容：<hr /><pre>" + this.responseText + "</pre></div>");
	}
};
