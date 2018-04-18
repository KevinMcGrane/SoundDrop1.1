<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>

<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap core CSS -->
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<link href="${contextPath}/resources/css/custom.css" rel="stylesheet">

<form id="logoutForm" method="POST" action="${contextPath}/logout">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>

<script type="text/javascript">
 
function encodeValue(val)
{
 var encodedVal;
 if (!encodeURIComponent)
 {
   encodedVal = escape(val);
   /* fix the omissions */
   encodedVal = encodedVal.replace(/@/g, '%40');
   encodedVal = encodedVal.replace(/\//g, '%2F');
   encodedVal = encodedVal.replace(/\+/g, '%2B');
 }
 else
 {
   encodedVal = encodeURIComponent(val);
   /* fix the omissions */
   encodedVal = encodedVal.replace(/~/g, '%7E');
   encodedVal = encodedVal.replace(/!/g, '%21');
   encodedVal = encodedVal.replace(/\(/g, '%28');
   encodedVal = encodedVal.replace(/\)/g, '%29');
   encodedVal = encodedVal.replace(/'/g, '%27');
 }
 /* clean up the spaces and return */
 return encodedVal.replace(/\%20/g,'+'); 
}
 
function createXHR()
{
   try { return new XMLHttpRequest(); } catch(e) {}
   try { return new ActiveXObject("Msxml2.XMLHTTP.6.0"); } catch (e) {}
   try { return new ActiveXObject("Msxml2.XMLHTTP.3.0"); } catch (e) {}
   try { return new ActiveXObject("Msxml2.XMLHTTP"); } catch (e) {}
   try { return new ActiveXObject("Microsoft.XMLHTTP"); } catch (e) {}
 
   return null;
}
 
function sendRequest(url, payload)
{
    var xhr = createXHR();
 
    if (xhr)
     {
       xhr.open("GET",url + "?" + payload,true);
       xhr.onreadystatechange = function(){handleResponse(xhr);};
       xhr.send(null);
     }
 
}
 

 
 
function rate(rating)
{
    var url = "http://localhost:8080/rate";
    var payload = "rating=" + rating;
    payload += "&response=text";
    sendRequest(url, payload);
}
 
window.onload = function () 
{ 
 var radios = document.getElementsByName('rating');
 for (var i = 0; i < radios.length; i++)
  {
   radios[i].onclick = function (){rate(this.value);}; 
  }
};

</script>
</head>
<body>
	<div class="panel-group">
		<c:forEach items="${userFeed}" var="post">
			<c:if test="${empty post.track}">
				<div class="panel panel-default">
					<div class="panel-heading">

						<b><a href=${contextPath}/user/${post.postText.user.username}>${post.postText.user.fname}
								${post.postText.user.lname}</a></b> posted:
					</div>
					<div class="panel-body">${post.postText.content}</div>
					<div class="panel-footer">${post.postText.publishTime}<c:if
							test="${post.postText.user.equals(currentUser)}">
							<form:form action="${contextPath}/deletepost/${post.id}"
								method="post">
								<button name="${_csrf.parameterName}" value="${_csrf.token}"
									type="submit" class="btn btn-failure btn-sm">Delete</button>
							</form:form>
						</c:if>
						<form:form
							action="${contextPath}/comment/${post.postText.postTextId}"
							method="get" id="commentForm">
							<c:choose>
								<c:when test="${empty post.postText.comments}">
									<button class="btn btn-link" type="submit">Comment</button>
								</c:when>
								<c:otherwise>
									<button class="btn btn-link" type="submit">View
										${fn:length(post.postText.comments)} Comments</button>
								</c:otherwise>
							</c:choose>

						</form:form>
					</div>

				</div>
			</c:if>
			<c:if test="${empty post.postText}">
				<div class="panel panel-default">
					<div class="panel-heading">
						<b><a href=${contextPath}/user/${post.track.user.username}>${post.track.user.fname}
								${post.track.user.lname}</a></b> posted:<br>
						<form action="#" method="get" name="ratingForm">
							Rate this track: <input type="radio" name="rating"
								value="1&id=${post.track.id}" /> 1 <input type="radio"
								name="rating" value="2&id=${post.track.id}" /> 2 <input
								type="radio" name="rating" value="3&id=${post.track.id}" /> 3 <input
								type="radio" name="rating" value="4&id=${post.track.id}" /> 4 <input
								type="radio" name="rating" value="5&id=${post.track.id}" /> 5


						</form>

						<!--<form method="post" action="#" name="playlistForm">
							<button type="submit" name="${_csrf.parameterName}" value="${_csrf.token}">Add</button>
							<select name="playlist">
								<c:forEach items="${playlists}" var="playlist">
									<option value="playlist=${playlist.name}&id=${post.track.id}">${playlist.name}</option>
								</c:forEach>
							</select>
						</form>-->
					</div>
					<div class="panel-body">
						<b>Artist:</b>${post.track.artist}<br>
						<b>Name:</b>${post.track.trackName}<br>
						<b>Genre:</b>${post.track.genre.name}<br>
						<div id="mainwrap">
							<div id="nowPlay">
								<span class="center" id="npTitle"></span>
							</div>
							<div id="audiowrap">
								<div id="audio0">
									<audio preload="auto" id="audio1" controls="controls">
										<source
											src="https://s3.eu-west-1.amazonaws.com/sounddrop-track-bucket/${post.track.fileName}">
									</audio>
								</div>
							</div>
						</div>
					</div>
					<div class="panel-footer">${post.track.publishTime}
						<c:if test="${post.track.user.equals(currentUser)}">
							<form:form action="${contextPath}/deletepost/${post.id}"
								method="post">
								<button name="${_csrf.parameterName}" value="${_csrf.token}"
									type="submit" class="btn btn-failure btn-sm">Delete</button>
							</form:form>
						</c:if>
						<form:form action="${contextPath}/track/comment/${post.track.id}"
							method="get" id="commentForm">
							<c:choose>
								<c:when test="${empty post.track.comments}">
									<button class="btn btn-link" type="submit">Comment</button>
								</c:when>
								<c:otherwise>
									<button class="btn btn-link" type="submit">View
										${fn:length(post.track.comments)} Comments</button>
								</c:otherwise>
							</c:choose>

						</form:form>
						<div id="Response"></div>
					</div>
				</div>
			</c:if>
		</c:forEach>

	</div>

</body>

</html>