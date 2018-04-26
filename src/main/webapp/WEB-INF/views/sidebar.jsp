<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap core CSS -->
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
	
	<link href="${contextPath}/resources/css/custom.css"
	rel="stylesheet">
	
</head>
<body>
<div class="row profile">
				<div class="profile-sidebar">
					<!-- SIDEBAR MENU -->
					<div class="profile-usermenu">
						<ul class="nav">
							<li><a href="${contextPath}/welcome"> <i
									class="glyphicon glyphicon-home"></i> Home
							</a></li>
							<li><a href="${contextPath}/settings"> <i
									class="glyphicon glyphicon-user"></i> Account Settings
							</a></li>
							<li><a href="${contextPath}/library"> <i
									class="glyphicon glyphicon-music"></i> Discover
							</a></li>
						</ul>
					</div>
					<!-- END MENU -->
				</div>
			</div>
		<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	</body>
	</html>