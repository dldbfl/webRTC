// ajax 통신 : XMLHttpRequest 요구됨.
function createXMLHttpRequest(){
	var xmlHttp;
	if(window.ActiveXObject){
		// IE 10 이하버전.
		xmlHttp = new ActiveXObject('Microsoft.XMLHTTP');
	}else{
		// IE 11, IE 외 브라우저.
		xmlHttp = new XMLHttpRequest();
	}
	return xmlHttp;
}

function alertPrt(title, message){
	BootstrapDialog.show({
	    title: title,
	    message: message
	});
	return false;
}