<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1">

<head><link href="${contextPath}/resources/css/mediaplayer.css"
	rel="stylesheet">
	
		<script src="${contextPath}/resources/js/mediaplayer.js"></script>
	
	</head>
	<body>
	<form:form commandName="playlistForm">
					<!-- Modal -->
					
									<div class="form-group">
										<label for="name" class="col-sm-2 control-label">Name:</label>
										<div class="col-sm-10">
											<form:input path="name" cssClass="form-control" />
											<form:errors path="name" />
										</div>
									</div>
									<input type="submit" class="btn btn-primary" value="Save" />

				</form:form>
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