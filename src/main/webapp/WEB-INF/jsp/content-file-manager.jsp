<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" id="top" ng-app="demoContentFileManager">
<head>
    <title>Calendar test</title>
    <link rel="icon" href="favicon.ico"/>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <%--<link rel="stylesheet" href="/css/bootstrap-theme.min.css"/>--%>
    <link rel="stylesheet" href="/css/fullcalendar.css">

</head>
<body>
<div role="main">
    <div class="container-fluid" ng-controller="Controller">
        Sucks = {{sucks}}
        <content-file-manager></content-file-manager>
    </div>
</div>

<script src="/js/jquery.min.js"></script>
<script src="/js/jquery-ui-1.10.4.min.js"></script>
<script src="/js/angular.debug.js"></script>

<script src="/js/ui-bootstrap-tpls-0.10.0.min.js"></script>
<script src="/js/content-file-manager.js"></script>
<script src="/js/demo-content-file-manager.js"></script>
</body>
</html>
