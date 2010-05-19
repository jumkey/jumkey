var FileManager={
	// 通过Ajax将File对象发送到服务器端
	uploadFiles:function(files) {
		document.getElementById("message").innerHTML += "上传" + files.length + "个文件...<br />";
		
		for(var i=0; i < files.length; ++i) {
				var xhr = new XMLHttpRequest;
				xhr.open('post', 'servlet/Upload?test=11111111111', true);
				xhr.onreadystatechange = function () {
					if (this.readyState != 4)
						return;
					document.getElementById("message").innerHTML += '<div class="data_content">成功上传文件,文件内容：<hr /><pre>' + this.responseText + '</pre></div>';
				}
				xhr.setRequestHeader('Content-Type', 'multipart/form-data');
				xhr.setRequestHeader('X-File-Name', encodeURI(files[i].fileName)); // 将文件名传递给服务器端
				xhr.setRequestHeader('X-File-Size', files[i].fileSize);
				xhr.send(files[i]); // 将file对象发送到服务器端 
				console.log(files[i]);
		}
	},
	// 用户选择文件时处理文件上传
	handleFile:function(e) {
		this.uploadFiles(e.files);
	}
};
