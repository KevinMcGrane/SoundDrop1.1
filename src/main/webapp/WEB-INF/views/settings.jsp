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
					<div class="form-group">
					<form enctype="multipart/form-data" method="post"
					action="${contextPath}/settings/profilepic?${_csrf.parameterName}=${_csrf.token}">
					<input type="file" name="file"><button type="submit" class="btn btn-primary" value="Save">Submit</button>
					</form>
						<form:form action="${contextPath}/settings/bio" method="post"
							modelAttribute="bioSettings">
							Profile Pic:<br>
							
										First Name:<br>
							<input type="text" value="${user.fname}" name="fname">
							<br>
															Last Name:<br>
							<input type="text" value="${user.lname}" name="lname">
							<br>
					
					Bio:<br>
							<input type="text" value="${user.bio}" name="bio">
							<br>

							<button type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-floppy-disk"></span> Save
							</button>
						</form:form>
						</div>
				</div>
				</div>


				<!-- END MENU -->
			</div>
		</div>
		<div class="col-md-6">
			<div id="logbox">
				<h2>Welcome ${pageContext.request.userPrincipal.name}</h2>
							<!-- 			<form:form action="${contextPath}/settings/password" method="post">
				
					 	<div class="form-group ${status.error ? 'has-error' : ''}">
								<input type="password" name="password" class="form-control"
									placeholder="Password">
								<form:errors path="password"></form:errors>
							</div>
						

							<div class="form-group ${status.error ? 'has-error' : ''}">
								<input type="password" name="passwordConfirm"
									class="form-control" placeholder="Confirm your password">
								<form:errors path="passwordConfirm"></form:errors>
							</div>
							<button type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-floppy-disk"></span> Save
							</button>
							</form:form>
							-->




			</div>
		</div>
		<div class="row profile">
			<div class="col-md-3">
				<div class="profile-sidebar">
					<!-- SIDEBAR MENU -->
					<div class="profile-usermenu">
					<ul class="nav">
						<li>
							<a href="${contextPath}/welcome">
							<i class="glyphicon glyphicon-home"></i>
							Overview </a>
						</li>
						<li class="active">
							<a href="${contextPath}/settings">
							<i class="glyphicon glyphicon-user"></i>
							Account Settings </a>
						</li>
						<li>
							<a href="#" target="_blank">
							<i class="glyphicon glyphicon-ok"></i>
							Tasks </a>
						</li>
						<li>
							<a href="#">
							<i class="glyphicon glyphicon-flag"></i>
							Help </a>
						</li>
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
