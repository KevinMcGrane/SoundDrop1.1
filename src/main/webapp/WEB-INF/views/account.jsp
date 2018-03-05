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

	<div class="row profile">
		<div class="col-md-3">
			<div class="profile-sidebar">
				<!-- SIDEBAR USERPIC -->
				<div class="profile-userpic">
					<c:choose>
				<c:when test="${empty user.profilePic}"><img src="${contextPath}/resources/images/noprofile.png" class="img-responsive" style="width:140px;height:120px;"></c:when>
				<c:otherwise>	<img src="https://s3.eu-west-1.amazonaws.com/sounddrop-profilepic-bucket/${user.profilePic.fileName}"
						class="img-responsive" alt=""></c:otherwise>
						</c:choose>
				</div>
				<!-- END SIDEBAR USERPIC -->
				<!-- SIDEBAR USER TITLE -->
				<div class="profile-usertitle">
					<div class="profile-usertitle-name">
						<a href=${contextPath}/account>${user.fname} ${user.lname}</a>
					</div>
				</div>
				<div class="profile-usertitle">
					<div class="profile-usertitle-name">${user.bio}</div>
				</div>


				<!-- END MENU -->
			</div>
		</div>
		<div class="col-md-6">
			<div id="logbox">
				<div class="panel-group">
					<c:forEach items="${user.postTexts}" var="postText">
						<div class="panel panel-default">
							<div class="panel-heading">
								<b><a href=${contextPath}/user/${postText.user.username}>${postText.user.fname}
										${postText.user.lname}</a></b> posted:
							</div>
							<div class="panel-body">${postText.content}</div>
							<div class="panel-footer">${postText.publishTime}<form:form
									action="${contextPath}/deletepost/${postText.postTextId}"
									method="post">
									<button name="${_csrf.parameterName}" value="${_csrf.token}"
										type="submit" class="btn btn-failure btn-sm">Delete</button>
								</form:form>
							</div>
						</div>
					</c:forEach>
				</div>

				<div class="panel-group">

					<!--<c:forEach items="${user.outgoingFriendRequests}" var="outgoingFriendRequests">
							<div class="panel panel-default">
								<div class="panel-body">${outgoingFriendRequests.id}</div>
								
							</div>
						</c:forEach>
						<c:forEach items="${user.incomingFriendRequests}" var="incomingFriendRequests">
							<div class="panel panel-default">
								<div class="panel-body">${incomingFriendRequests.id}</div> 
								
							</div>
						</c:forEach>-->

					<c:forEach items="${user.tracks}" var="track">
						<div class="panel panel-default">
							<div class="panel-heading">
								<b><a href=${contextPath}/user/${track.user.username}>${track.user.fname}
										${track.user.lname}</a></b> posted:
							</div>
							<div class="panel-body">${track.trackName}<div id="mainwrap">
									<div id="nowPlay">
										<span class="center" id="npTitle"></span>
									</div>
									<div id="audiowrap">
										<div id="audio0">
											<audio preload="auto" id="audio1" controls="controls"><source src="https://s3.eu-west-1.amazonaws.com/sounddrop-track-bucket/${track.fileName}">
											</audio>
										</div>
									</div>
								</div>
							</div>
							<div class="panel-footer">
								<form:form action="${contextPath}/deletepost/${track.id}"
									method="post">
									<button name="${_csrf.parameterName}" value="${_csrf.token}"
										type="submit" class="btn btn-failure btn-sm">Delete</button>
								</form:form>
							</div>
						</div>
					</c:forEach>

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
