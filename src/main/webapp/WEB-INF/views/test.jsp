<!DOCTYPE html>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1">

<head><link href="${contextPath}/resources/css/test.css"
	rel="stylesheet">
	
		<script src="${contextPath}/resources/js/mediaplayer.js"></script>
	
	</head>
	<body>
   <div class="container">
    <div class="column add-bottom">
        <div id="mainwrap">
            <div id="nowPlay">
                <span class="left" id="npAction">Paused...</span>
                <span class="right" id="npTitle"></span>
            </div>
            <div id="audiowrap">
                <div id="audio0">
                    <audio preload id="audio1" controls="controls">Your browser does not support HTML5 Audio!</audio>
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
    <div class="column add-bottom center">
        <p>Music by <a href="http://www.mythium.net/">Mythium</a></p>
        <p>Download: <a href="https://archive.org/download/mythium/mythium_vbr_mp3.zip">zip</a> / <a href="https://archive.org/download/mythium/mythium_archive.torrent">torrent</a></p>
    </div>
</div>
   
    </body>
</html>