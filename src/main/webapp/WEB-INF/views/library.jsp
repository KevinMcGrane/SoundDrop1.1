<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="row">

		<div class="col-lg-4">
			<div id="logbox">
				<jsp:include page="mediaplayer.jsp"></jsp:include>
			</div>

		</div>


		<div class="col-lg-0"></div>
				<div class="col-lg-5"><h3><b>Tracks you may like</b></h3>
				<c:if test="${empty recommendedTracks}">
				<h4><b>Start rating tracks to recieve recommendations</b></h4>
				</c:if>
				<c:forEach items="${recommendedTracks}" var="track">
						<div class="panel panel-default">
							<div class="panel-heading">
								<b><a href=${contextPath}/user/${track.user.username}>${track.user.fname}
										${track.user.lname}</a></b> posted:
										<form action="#" method="get" name="ratingForm">
							Rate this track: <input type="radio" name="rating"
								value="1&id=${track.id}" /> 1 <input type="radio"
								name="rating" value="2&id=${post.track.id}" /> 2 <input
								type="radio" name="rating" value="3&id=${track.id}" /> 3 <input
								type="radio" name="rating" value="4&id=${track.id}" /> 4 <input
								type="radio" name="rating" value="5&id=${track.id}" /> 5


						</form>
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
								<form:form action="${contextPath}/track/deletetrack/${track.id}"
									method="post">
									<button name="${_csrf.parameterName}" value="${_csrf.token}"
										type="submit" class="btn btn-failure btn-sm">Delete</button>
								</form:form></c:if>
								<form:form
									action="${contextPath}/track/comment/${track.id}"
									method="get" id="commentForm">
									<c:choose>
										<c:when test="${empty track.comments}">
											<button class="btn btn-link" type="submit">Comment</button>
										</c:when>
										<c:otherwise>
											<button class="btn btn-link" type="submit">View
												${fn:length(track.comments)} Comments</button>
										</c:otherwise>
									</c:choose>

								</form:form>
							</div>
						</div>
					</c:forEach>
				</div>
		<div class="col-md-3">
			<jsp:include page="sidebar.jsp"></jsp:include>
			<form:form commandName="playlistForm" action="${contextPath}/library" method="post" class="navbar-form navbar-right">
	
										<label for="name" class="col-sm-2 control-label">New Playlist:</label>
										<div class="input-group">
											<form:input path="name" cssClass="form-control" />
											<form:errors path="name" />
											<input type="submit" class="btn btn-primary" value="Create" />
										</div>
									
									

				</form:form>
		</div>
	</div>
	<!-- /container -->
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script>jQuery(function ($) {
    'use strict'
    var supportsAudio = !!document.createElement('audio').canPlayType;
    if (supportsAudio) {
        var index = 0,
            playing = false,
            mediaPath = 'https://s3.eu-west-1.amazonaws.com/sounddrop-track-bucket/',
            extension = '',
            tracks = ${tracks},
            buildPlaylist = $.each(tracks, function(key, value) {
                var trackNumber = value.track,
                    trackName = value.name,
                    trackArtist = value.artist;
                if (trackNumber.toString().length === 1) {
                    trackNumber = '0' + trackNumber;
                } else {
                    trackNumber = '' + trackNumber;
                }
                $('#plList').append('<li><div class="plItem"><div class="plNum">' + trackNumber +  '</div><div class="plTitle">' + trackArtist +'    -    ' + trackName + '</div></div></li>');
            }),
            trackCount = tracks.length,
            npAction = $('#npAction'),
            npTitle = $('#npTitle'),
            audio = $('#audio1').bind('play', function () {
                playing = true;
                npAction.text('Now Playing...');
            }).bind('pause', function () {
                playing = false;
                npAction.text('Paused...');
            }).bind('ended', function () {
                npAction.text('Paused...');
                if ((index + 1) < trackCount) {
                    index++;
                    loadTrack(index);
                    audio.play();
                } else {
                    audio.pause();
                    index = 0;
                    loadTrack(index);
                }
            }).get(0),
            btnPrev = $('#btnPrev').click(function () {
                if ((index - 1) > -1) {
                    index--;
                    loadTrack(index);
                    if (playing) {
                        audio.play();
                    }
                } else {
                    audio.pause();
                    index = 0;
                    loadTrack(index);
                }
            }),
            btnNext = $('#btnNext').click(function () {
                if ((index + 1) < trackCount) {
                    index++;
                    loadTrack(index);
                    if (playing) {
                        audio.play();
                    }
                } else {
                    audio.pause();
                    index = 0;
                    loadTrack(index);
                }
            }),
            li = $('#plList li').click(function () {
                var id = parseInt($(this).index());
                if (id !== index) {
                    playTrack(id);
                }
            }),
            loadTrack = function (id) {
                $('.plSel').removeClass('plSel');
                $('#plList li:eq(' + id + ')').addClass('plSel');
                npTitle.text(tracks[id].name);
                index = id;
                audio.src = mediaPath + tracks[id].file;
            },
            playTrack = function (id) {
                loadTrack(id);
                audio.play();
            };
        extension = audio.canPlayType('audio/mpeg') ? '.mp3' : audio.canPlayType('audio/wav') ? '.wav' : '';
        loadTrack(index);
    }
});

//initialize plyr
plyr.setup($('#audio1'), {});</script>
</body>
</html>
