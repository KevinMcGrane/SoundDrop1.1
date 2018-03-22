<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1">

<head><link href="${contextPath}/resources/css/mediaplayer.css"
	rel="stylesheet">
	
	</head>
	<body>    
  				
  
    <div class="column add-bottom">
        <div id="mainwrap">
    <div class="container"> <div id="dropdown"><div class="dropdown">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Select Playlist
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
  <c:forEach items="${playlists}" var="playlist"><li><a href="${contextPath}/library/${playlist.name}">${playlist.name}</a></li> </c:forEach>
  </ul>
</div>     </div></div>
            <div id="nowPlay">
            
               
            </div>
            <div id="audiowrap">
                <div id="tracks">
                 <span class="center" id="npTitle"></span>
                    <audio preload="auto" id="audio1" controls="controls"> Your browser does not support HTML5 Audio!</audio>
                </div>
                <div id="tracks">
                    <a id="btnPrev">&larr;</a>
                    <a id="btnNext">&rarr;</a>
                </div>
            </div>
            <div id="plwrap">
                <ul id="plList"></ul>
            </div>
        </div>
    </div>
    </body>
</html>