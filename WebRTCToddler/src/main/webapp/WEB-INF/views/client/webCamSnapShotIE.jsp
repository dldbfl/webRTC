<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html la ng="ko">
<head>
<meta charset="UTF-8">
<title>IE용 웹캠 데모</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mediaTestCode1.css">
</head>
<body>
	<div class="container">
		<header>
			<div class="page-header">
				<h1>IE 웹캠 데모</h1>
			</div>
		</header>
		<section>
			<div class="row">
				<div class="span12">
					<div class="row">
						<div class="span4">
							<h2>웹캠1</h2>
							<!-- 웹캠 출력 -->
							<div id="webcam"></div>
						</div>

						<div class="span4">
							<h2>스냅샷1</h2>
							<canvas id="canvas" height="240" width="320"></canvas>
						</div>
						<div class="span4">
							<h2>스냅샷2</h2>
							<canvas id="output" height="426" width="515"></canvas>
						</div>
					</div>
					<div class="row">
						<p id="errorMessage"></p>
					</div>
					<div class="row">
						<div class="span4">&nbsp;</div>
						<div class="span4">
							<button class="btn btn-primary btn-large" id="takeSnapshot">1.스냅샷</button>
							&nbsp;
							<button class="btn btn-primary btn-large" id="detectFaces">2.스냅샷</button>
						</div>
						<div class="span4">&nbsp;</div>
					</div>
				</div>
			</div>
		</section>
		<footer>푸터</footer>
	</div>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<!-- Flash 베이스 웹캠 활성화 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/getUserMedia.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/webCamSetting.js"></script>
<script type="text/javascript">
$(function() {
	App.init();
});
</script>
</html>