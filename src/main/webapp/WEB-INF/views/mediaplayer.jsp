<!DOCTYPE html>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1">

<head><link href="${contextPath}/resources/css/mediaplayer.css"
	rel="stylesheet">
	
		<script src="${contextPath}/resources/js/mediaplayer.js"></script>
	
	</head>
    <div class="column add-bottom">
        <div id="mainwrap">
            <div id="nowPlay">
                <span class="center" id="npTitle"></span>
            </div>
            <div id="audiowrap">
                <div id="audio0">
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
    
</html>