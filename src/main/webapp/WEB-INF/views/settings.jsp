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
			
		</div>
		<div class="col-md-6">
			<div id="logbox">
				<h2 style="text-align: center"><b>Edit your details</b></h2>
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
				<div class="profile-usertitle" style="text-align: center">
					<div class="profile-usertitle-name">
					<div class="form-group">
					Profile Pic:<br>
					<form enctype="multipart/form-data" method="post"
					action="${contextPath}/settings/profilepic?${_csrf.parameterName}=${_csrf.token}">
					<input type="file" name="file"><button type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-floppy-disk"></span> Save
							</button>
					</form>
						<form:form action="${contextPath}/settings/bio" method="post"
							modelAttribute="bioSettings">
							
							
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
