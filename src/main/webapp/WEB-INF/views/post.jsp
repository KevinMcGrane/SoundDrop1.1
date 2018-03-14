<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<meta name="viewport" content="width=device-width, initial-scale=1">

<html lang="en">
<head>
<!-- Bootstrap core CSS -->
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
	
	<link href="${contextPath}/resources/css/custom.css"
	rel="stylesheet">
	
	<form id="logoutForm" method="POST" action="${contextPath}/logout">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>
</head>
<body>
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
									method="get" id="commentForm">
									<c:choose>
										<c:when test="${empty postText.comments}">
											<button class="btn btn-link" type="submit">Comment</button>
										</c:when>
										<c:otherwise>
											<button class="btn btn-link" type="submit">View
												${fn:length(postText.comments)} Comments</button>
										</c:otherwise>
									</c:choose>

								</form:form>
							</div>

						</div>
					</c:forEach>

					<c:forEach items="${tracklist}" var="track">
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
								<form:form action="${contextPath}/track/deletetrack/${track.id}"
									method="post">
									<button name="${_csrf.parameterName}" value="${_csrf.token}"
										type="submit" class="btn btn-failure btn-sm">Delete</button>
								</form:form>
							</div>
						</div>
					</c:forEach>
				</div>
				</body>