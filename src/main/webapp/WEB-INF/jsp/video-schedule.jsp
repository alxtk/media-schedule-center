<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>SumSU Media Content Control Center</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" type="text/css" href="/css/app.css"/>
</head>
<body>
<div ng-app>

    <h1>Не всё работает! Нужно собрать календарь с помощью bower.</h1>

    <div ng-controller="VideoScheduleController">
        <p>Nothing here {{'yet' + '!'}}</p>

        <p>1 + 2 = {{ 1 + 2 }}</p>
        <br/>
        <ul>
            <li ng-repeat="phone in phones">
                {{phone.name}}
                <p>{{phone.snippet}}</p>
            </li>
        </ul>
    </div>


    <div class="container">
        <section id="directives-calendar" ng-controller="CalendarCtrl">
            <div class="page-header">
                <h1>UI-Calendar</h1>
            </div>
            <div class="well">
                <div class="row-fluid">
                    <div class="span4">
                        <h3>What?</h3>

                        <p>Attach Angular objects to a calendar.</p>

                        <p>Show the data binding between two differnet calendars using the same event sources.</p>

                        <h3>Why?</h3>

                        <p>Why Not?</p>

                        <div class="btn-group calTools">
                            <button class="btn" ng-click="changeLang()">
                                {{changeTo}}
                            </button>
                            <button class="btn" ng-click="addRemoveEventSource(eventSources,eventSource)">
                                Toggle Source
                            </button>
                            <button type="button" class="btn btn-primary" ng-click="addEvent()">
                                Add Event
                            </button>
                        </div>

                        <ul class="unstyled">
                            <li ng-repeat="e in events">
                                <div class="alert alert-info">
                                    <a class="close" ng-click="remove($index)"><i class="icon-remove"></i></a>
                                    <b> <input ng-model="e.title"></b>
                                    {{e.start | date:"MMM dd"}} - {{e.end | date:"MMM dd"}}
                                </div>
                            </li>
                        </ul>

                    </div>

                    <div class="span8">
                        <tabset>
                            <tab select="renderCalender(myCalendar1);">
                                <tab-heading>
                                    <i class="glyphicon glyphicon-bell"></i> Calendar One
                                </tab-heading>
                                <div class="alert-success calAlert"
                                     ng-show="alertMessage != undefined && alertMessage != ''">
                                    <h4>{{alertMessage}}</h4>
                                </div>
                                <div class="btn-toolbar">
                                    <p class="pull-right lead">Calendar One View Options</p>

                                    <div class="btn-group">
                                        <button class="btn btn-success" ng-click="changeView('agendaDay', myCalendar1)">
                                            AgendaDay
                                        </button>
                                        <button class="btn btn-success"
                                                ng-click="changeView('agendaWeek', myCalendar1)">AgendaWeek
                                        </button>
                                        <button class="btn btn-success" ng-click="changeView('month', myCalendar1)">
                                            Month
                                        </button>
                                    </div>
                                </div>

                                <div class="calendar" ng-model="eventSources" calendar="myCalendar1"
                                     config="uiConfig.calendar" ui-calendar="uiConfig.calendar"></div>
                            </tab>

                            <tab select="renderCalender(myCalendar2);">
                                <tab-heading>
                                    <i class="glyphicon glyphicon-bell"></i> Calendar Two
                                </tab-heading>
                                <div class="alert-success calAlert"
                                     ng-show="alertMessage != undefined && alertMessage != ''">
                                    <h4>{{alertMessage}}</h4>
                                </div>
                                <div class="btn-toolbar">
                                    <p class="pull-right lead">Calendar Two View Options</p>

                                    <div class="btn-group">
                                        <button class="btn btn-success" ng-click="changeView('agendaDay', myCalendar2)">
                                            AgendaDay
                                        </button>
                                        <button class="btn btn-success"
                                                ng-click="changeView('agendaWeek', myCalendar2)">AgendaWeek
                                        </button>
                                        <button class="btn btn-success" ng-click="changeView('month', myCalendar2)">
                                            Month
                                        </button>
                                    </div>
                                </div>
                                <div class="calendar" ng-model="eventSources" calendar="myCalendar2"
                                     config="uiConfig.calendar" ui-calendar="uiConfig.calendar"></div>
                            </tab>

                            <tab select="renderCalender(myCalendar3);">
                                <tab-heading>
                                    <i class="glyphicon glyphicon-bell"></i> Calendar Three
                                </tab-heading>
                                <div class="alert-success calAlert">
                                    <h4>This calendar uses the extended form</h4>
                                </div>
                                <div class="btn-toolbar">
                                    <p class="pull-right lead">Calendar Three View Options</p>

                                    <div class="btn-group">
                                        <button class="btn btn-success" ng-click="changeView('agendaDay', myCalendar3)">
                                            AgendaDay
                                        </button>
                                        <button class="btn btn-success"
                                                ng-click="changeView('agendaWeek', myCalendar3)">AgendaWeek
                                        </button>
                                        <button class="btn btn-success" ng-click="changeView('month', myCalendar3)">
                                            Month
                                        </button>
                                    </div>
                                </div>
                                <div class="calendar" ng-model="eventSources2" calendar="myCalendar3"
                                     config="uiConfig.calendar" ui-calendar="uiConfig.calendar"></div>
                            </tab>
                        </tabset>
                    </div>
                </div>
            </div>
        </section>
    </div>


</div>


<script src="/js/components/jquery/dist/jquery.js"></script>
<script src="/js/components/jquery-ui/ui/jquery-ui.js"></script>

<script src="/js/angular.min.js"></script>
<script src="/js/ui-bootstrap-tpls-0.10.0.min.js"></script>

<script src="/js/components/fullcalendar/fullcalendar.js"></script>
<script src="/js/components/fullcalendar/gcal.js"></script>
<script src="/js/calendar.js"></script>

<script src="/js/video-schedule.js"></script>
<script src="/js/calendarDemo.js"></script>
<%--<script src="/js/components/angular-route/angular-route.js"></script>--%>

<%--<script src="js/services.js"></script>
<script src="js/controllers.js"></script>
<script src="js/filters.js"></script>
<script src="js/directives.js"></script>--%>

</body>
</html>
