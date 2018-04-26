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

</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">

		<div class="row main">
			<div class="col-lg-3 description">
				
			</div>
			<div class="col-lg-3">
				<div id="logbox">

					<div class="panel-group">
						<h3>
							<b>Friends</b>
						</h3>
						<c:if test="${empty friends}">No friends</c:if>
						<c:forEach items="${friends}" var="user">

							<div class="profile-userpic-friends">
								<a href=${contextPath}/user/${user.username}>
									<c:choose>
				<c:when test="${empty user.profilePic}"><img src="${contextPath}/resources/images/noprofile.png" class="img-responsive" style="width: 50px; height: 50px;"></c:when>
				<c:otherwise>	<img src="https://s3.eu-west-1.amazonaws.com/sounddrop-profilepic-bucket/${user.profilePic.fileName}"
						class="img-responsive" style="width: 50px; height: 50px;"></c:otherwise>
						</c:choose></a>
							</div>
							<div class="profile-usertitle-friends">
								<a href=${contextPath}/user/${user.username}> <b>${user.fname}
										${user.lname}</b></a>
							</div>


						</c:forEach>
					</div>

				</div>
			</div>

			<div class="col-lg-3">
				<div id="logbox">

					<div class="panel-group">

						<h3>
							<b>Incoming Requests</b>
						</h3>
						<c:if test="${empty requestList}">No incoming requests</c:if>
						<c:forEach items="${requestList}" var="user">

							<div class="profile-usertitle-friends">
								<a href=${contextPath}/user/${user.username}> <b>${user.fname}
										${user.lname}</b></a>
							</div>
							<div class="profile-userpic-friends">
								<a href=${contextPath}/user/${user.username}> <c:choose>
								<c:when test="${empty user.profilePic}"><img src="${contextPath}/resources/images/noprofile.png" class="img-responsive" style="width: 50px; height: 50px;"></c:when>
				<c:otherwise>	<img src="https://s3.eu-west-1.amazonaws.com/sounddrop-profilepic-bucket/${user.profilePic.fileName}"
						class="img-responsive" style="width: 50px; height: 50px;"></c:otherwise>
						</c:choose></a>
							</div>

							<form:form action="${contextPath}/user/${user.username}/add"
								method="post">
								<button name="${_csrf.parameterName}" value="${_csrf.token}"
									type="submit" class="btn btn-success-friends">Confirm</button>
							</form:form>
							<form:form
								action="${contextPath}/user/${user.username}/friendrequests/${user.id}"
								method="post">
								<button name="${_csrf.parameterName}" value="${_csrf.token}"
									type="submit" class="btn btn-reject-friends">Reject</button>
							</form:form>

						</c:forEach>

					</div>

				</div>
			</div>

			
				<div class="col-md-3">
					<jsp:include page="sidebar.jsp"></jsp:include>
				</div>
			</div>
		</div>

	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
