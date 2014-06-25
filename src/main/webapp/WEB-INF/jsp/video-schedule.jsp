<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" ng-app="scheduler" id="top">
<head>
    <title>Calendar test</title>
    <link rel="icon" href="favicon.ico"/>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <%--<link rel="stylesheet" href="/css/bootstrap-theme.min.css"/>--%>
    <link rel="stylesheet" href="/css/fullcalendar.css">

</head>
<body>
<div role="main">
    <div class="container-fluid">
        <section ng-controller="CalendarCtrl">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3">
                        <button type="button" class="btn btn-primary" ng-click="addEvent()">
                            Add Event
                        </button>

                        <ul class="list-group">
                            <li ng-repeat="e in events" class="list-group-item">
                                <a class="close" ng-click="remove($index)"><i class="icon-remove"></i>Remove</a>
                                <b> <input ng-model="e.title"></b>
                                {{e.start | date:"MMM dd"}} - {{e.end | date:"MMM dd"}}
                            </li>
                        </ul>

                    </div>
                    <div class="col-lg-9">
                        <tabset>
                            <tab select="renderCalender(myCalendar1);">

                                <tab-heading>
                                    <i class="glyphicon glyphicon-bell"></i> Calendar One
                                </tab-heading>

                                <div class="alert-success calAlert" ng-show="alertMessage != undefined && alertMessage != ''">
                                    <h4>{{alertMessage}}</h4>
                                </div>

                                <div class="btn-toolbar">
                                    <div class="btn-group pull-right">
                                        <button class="btn btn-success" ng-click="changeView('agendaDay', myCalendar1)">AgendaDay</button>
                                        <button class="btn btn-success" ng-click="changeView('agendaWeek', myCalendar1)">AgendaWeek</button>
                                        <button class="btn btn-success" ng-click="changeView('month', myCalendar1)">Month</button>
                                    </div>
                                </div>
                                <div class="calendar" ng-model="eventSources" calendar="myCalendar1"
                                     config="uiConfig.calendar" ui-calendar="uiConfig.calendar"></div>
                            </tab>
                        </tabset>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>

<script src="/js/jquery.min.js"></script>
<script src="/js/jquery-ui-1.10.4.min.js"></script>

<%--<script src="/js/bower_components/angular/angular.js"></script>--%>
<script src="/js/angular.min.js"></script>
<%--<script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.9.0.js"></script>--%>
<script src="/js/ui-bootstrap-tpls-0.10.0.min.js"></script>

<script src="/js/fullcalendar.min.js"></script>
<script src="/js/gcal.js"></script>
<script src="/js/calendar.js"></script>
<script src="/js/video-schedule.js"></script>

</body>
</html>
