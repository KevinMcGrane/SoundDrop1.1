<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1">

<head><link href="${contextPath}/resources/css/mediaplayer.css"
	rel="stylesheet">
	
		<script> jQuery(function ($) {
		    'use strict'
		    var supportsAudio = !!document.createElement('audio').canPlayType;
		    if (supportsAudio) {
		        var index = 0,
		            playing = false,
		            mediaPath = 'https://s3.eu-west-1.amazonaws.com/sounddrop-track-bucket/',
		            extension = '',
		            tracks = JSON.parse($(tracks)),
		            buildPlaylist = $.each(tracks, function(key, value) {
		                var trackNumber = value.track,
		                    trackName = value.name,
		                    trackLength = value.length;
		                if (trackNumber.toString().length === 1) {
		                    trackNumber = '0' + trackNumber;
		                } else {
		                    trackNumber = '' + trackNumber;
		                }
		                $('#plList').append('<li><div class="plItem"><div class="plNum">' + trackNumber + '.</div><div class="plTitle">' + trackName + '</div><div class="plLength">' + trackLength + '</div></div></li>');
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
		                audio.src = mediaPath + tracks[id].file + extension;
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
	
	</head>
	<body>
	
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
    </body>
</html>