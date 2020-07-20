<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IE 외 브라우저 웹캠 데모</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<div class="wrapper">
		<div>
			<!-- 웹캠 영상 브라우저 video 태그 대상 스트리밍 -->
			<h1>Video from webCam</h1>
			<video></video>
		</div>
		<div>
			<!-- 웹캠 영상 브라우저 canvas 태그 대상 스트리밍 -->
			<h1>Video on Canvas</h1>
			<canvas></canvas>
		</div>
		<div>
			<h1>Video from Server</h1>
			<img alt="" src="">
		</div>
	</div>
	<input type="button" value="서버 스트리밍 종료" onclick="streamClose();">
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/webcamIEetc.js"></script>
<script type="text/javascript">
window.onbeforeunload = function(){
	isClose = true;
	socket.close();
};
function streamClose(){
	socket.close();
}
</script>
</html>













