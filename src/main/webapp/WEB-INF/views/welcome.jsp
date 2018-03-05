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

		<div class="col-lg-4">
			<div id="logbox">
				<jsp:include page="mediaplayer.jsp"></jsp:include>
			</div>

		</div>


		<div class="col-lg-5">
			<div id="logbox">
				<div class="col-lg-6">
					<!-- Button trigger modal -->
					<!-- <button class="btn btn-primary btn-lg" data-toggle="modal"
						data-target="#myModal">New Post</button>-->
					<input type="text" data-target="#myModal" data-toggle="modal"
						class="form-control1" placeholder="New Post" />
				</div>
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

				<div class="col-lg-6">
					<input type="text" data-target="#myModal1" data-toggle="modal"
						class="form-control1" placeholder="New Track" />

				</div>
				<form enctype="multipart/form-data" method="post"
					action="${contextPath}/track?${_csrf.parameterName}=${_csrf.token}">
					<!-- Modal -->
					<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">New track</h4>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label for="title" class="col-sm-2 control-label">Artist:</label>
										<div class="col-sm-10">
											<input name="artist"/>
										</div>
									</div>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label for="title" class="col-sm-2 control-label">Title:</label>
										<div class="col-sm-10">
											<input name="track"/>
										</div>
									</div>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label for="title" class="col-sm-2 control-label">Genre:</label>
										<div class="col-sm-10">
											<input name="genre"/>
										</div>
									</div>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label for="title" class="col-sm-2 control-label">File:</label>
										<div class="col-sm-10">
											<input type="file" name="file"/>
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
				</form>
				<br></br>
				<br></br>

				<div class="panel-group">
					<c:forEach items="${postTextList}" var="postText">
						<div class="panel panel-default">
							<div class="panel-heading">
								<b><a href=${contextPath}/user/${postText.user.username}>${postText.user.fname}
										${postText.user.lname}</a></b> posted:
							</div>
							<div class="panel-body">${postText.content}</div>
							<div class="panel-footer">${postText.publishTime}<c:if
									test="${postText.user.equals(currentUser)}">
									<form:form
										action="${contextPath}/deletepost/${postText.postTextId}"
										method="post">
										<button name="${_csrf.parameterName}" value="${_csrf.token}"
											type="submit" class="btn btn-failure btn-sm">Delete</button>
									</form:form>
								</c:if>
								<form:form
										action="${contextPath}/comment/${postText.postTextId}"
										method="get">
										<c:choose><c:when test="${empty postText.comments}"><button
											type="submit" class="btn btn-failure btn-sm">Comment</button></c:when>
											<c:otherwise><button
											type="submit" class="btn btn-failure btn-sm">View ${count} Comments</button></c:otherwise></c:choose>
										
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
