<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Homepage</title>

<!-- Bootstrap core CSS -->
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<link href="${contextPath}/resources/css/custom.css" rel="stylesheet">




<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<form id="logoutForm" method="POST" action="${contextPath}/logout">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>



</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="row">

		<div class="col-lg-3">
			<div id="logbox"></div>

		</div>

		<div class="col-md-6">
			<div id="logbox">
				<div class="panel-group">
					<div class="panel panel-default">
							<div class="panel-heading">
								<b><a href=${contextPath}/user/${track.user.username}>${track.user.fname}
										${track.user.lname}</a></b> posted:
							</div>
							<div class="panel-body"><b>Artist:</b>${track.artist}<br><b>Name:</b>${track.trackName}<br><b>Genre:</b>${track.genre.name}<br><div
									id="mainwrap">
									<div id="nowPlay">
										<span class="center" id="npTitle"></span>
									</div>
									<div id="audiowrap">
										<div id="audio0">
											<audio preload="auto" id="audio1" controls="controls">
												<source
													src="https://s3.eu-west-1.amazonaws.com/sounddrop-track-bucket/${track.fileName}">
											</audio>
										</div>
									</div>
								</div>
							</div>
							<div class="panel-footer">${track.publishTime}
							<c:if test="${track.user.equals(currentUser)}">
								</c:if>
							</div>
						</div>
				</div>
				<div class="col-md-7">
					<form:form commandName="commentForm" action="${contextPath}/track/comment/${track.id}"
										method="POST">
						<form:input path="content" placeholder="Write a comment" cssClass="form-control" />
						<input type="submit" class="btn btn-failure btn-sm" value="Post"/>
					</form:form>
					
					&nbsp;
					<c:forEach items="${comments}" var="comment"><div class="panel panel-default">
							<div class="panel-body">
								<b><a href=${contextPath}/user/${comment.user.username}>${comment.user.fname}
										${comment.user.lname}</a> commented:</b>
							${comment.content}</div>
							<div class="panel-footer">${comment.publishTime}
									
</div>
						</div></c:forEach>
				</div>
			</div>
		</div>
		<div class="col-md-3">
				<jsp:include page="sidebar.jsp"></jsp:include>
			</div>
	</div>

	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
