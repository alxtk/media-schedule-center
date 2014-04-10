<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>SumSU Media Content Control Center</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="/css/app.css"/>
    <script type="text/javascript" src="/js/angular.min.js"></script>
</head>
<body>

<ul class="menu">
    <li><a href="#/view1">view1</a></li>
    <li><a href="#/view2">view2</a></li>
</ul>

<div ng-view=""></div>

<div>Angular seed app: v<span app-version=""></span></div>

</body>
</html>