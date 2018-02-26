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
					<img src="${contextPath}/resources/images/profile_user.jpg"
						class="img-responsive" alt="">
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
				<!-- Button trigger modal -->
				<!-- <button class="btn btn-primary btn-lg" data-toggle="modal"
						data-target="#myModal">New Post</button>-->
				<input type="text" data-target="#myModal" data-toggle="modal"
					class="form-control1" placeholder="New Post" />

				<form:form commandName="postTextForm">
					<!-- Modal -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">New post</h4>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label for="content" class="col-sm-2 control-label">Content:</label>
										<div class="col-sm-10">
											<form:input path="content" cssClass="form-control" />
											<form:errors path="content" />
										</div>
									</div>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
									<input type="submit" class="btn btn-primary" value="Save" />
								</div>
							</div>
						</div>
					</div>
				</form:form>
				<br></br>

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
		<div class="row profile">
			<div class="col-md-3">
				<div class="profile-sidebar">
					<!-- SIDEBAR MENU -->
					<div class="profile-usermenu">
						<ul class="nav">
							<li class="active"><a href="${contextPath}/welcome"> <i
									class="glyphicon glyphicon-home"></i> Overview
							</a></li>
							<li><a href="${contextPath}/settings"> <i
									class="glyphicon glyphicon-user"></i> Account Settings
							</a></li>
							<li><a href="#" target="_blank"> <i
									class="glyphicon glyphicon-ok"></i> Tasks
							</a></li>
							<li><a href="#"> <i class="glyphicon glyphicon-flag"></i>
									Help
							</a></li>
						</ul>
					</div>
					<!-- END MENU -->
				</div>
			</div>
		</div>
	</div>



	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>


</body>
</html>
