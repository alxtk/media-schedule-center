<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" id="top" ng-app="playlistEditor">
<head>
    <title>Calendar test</title>
    <link rel="icon" href="favicon.ico"/>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="/css/fullcalendar.css">
</head>
<body>
<div role="main">
    <div class="container-fluid">
        <h2>
            Playlist editor for Playlist #<c:out value="${PlaylistID}"/>
        </h2>
        <div class="col-lg-4">
            <content-file-manager <%--root-folder="'/testSubFolder'"--%>></content-file-manager>
        </div>
        <div class="col-lg-4" ng-controller="playlistFileController">
            Playlist files
            <ul>
                <li ng-repeat="file in files">
                    {{file.title}}
                </li>
            </ul>
        </div>
    </div>
</div>

<script src="/js/jquery.min.js"></script>
<script src="/js/jquery-ui-1.10.4.min.js"></script>
<script src="/js/angular.debug.js"></script>

<script src="/js/ui-bootstrap-tpls-0.10.0.min.js"></script>
<script src="/js/directives/dxTree.js"></script>
<script src="/js/directives/content-file-manager.js"></script>
<script src="/js/playlist/playlist-editor.js"></script>
</body>
</html>
