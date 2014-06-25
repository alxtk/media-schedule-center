(function () {
    /**
     * calendarDemoApp - 0.1.3
     */
    var app = angular.module('scheduler', ['ui.calendar', 'ui.bootstrap']);

    app.controller('CalendarCtrl', ['$scope', '$http', function ($scope, $http) {

        var date = new Date();
        var d = date.getDate();
        var m = date.getMonth();
        var y = date.getFullYear();

        /* event source that calls a function on every view switch */
        $scope.eventsF = function (start, end, callback) {
            $http.get('/events')
                .success(function (data) {
                    var events = [];
                    var dateOffset = new Date().getTimezoneOffset() * 60000;
                    angular.forEach(data, function (ev) {
                        var event = {
                            id: ev.id,
                            title: ev.name,
                            start: new Date(ev.startDate + dateOffset),
                            end: new Date(ev.endDate + dateOffset),
                            allDay: false,
                            comment: ev.comment
                        };
                        events.push(event);
                    });
                    console.log("Events loaded: ", events);
                    callback(events);
                })
                .error(function (data) {

                });
            //callback(events);
            //callback($scope.events);
        };

        $scope.updateEvent = function (event) {
            console.log("Update event: ", event);
            var dateOffset = new Date().getTimezoneOffset() * 60000;
            var eventData = {
                id: event.id,
                name: event.title,
                startDate: event.start.getTime() - dateOffset,
                endDate: ((event.end) ? event.end.getTime() : event.start.getTime()) - dateOffset,
                comment: event.comment
            };
            $http.post("/events", eventData).success(function (data) {
                console.log("Event UPDATED! ", event);
            }).error(function (data) {
                console.log("Event NOT UPDATED! ", event, data);
            });
        };

        /* alert on eventClick */
        $scope.alertOnEventClick = function (event, allDay, jsEvent, view) {
            console.log("Event click: ", event);
            $scope.alertMessage = (event.title + ' was clicked ');
        };

        /* alert on Drop */
        $scope.alertOnDrop = function (event, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view) {
            console.log("Event dropped: ", event);
            $scope.alertMessage = ('Event Dropped to make dayDelta ' + dayDelta);
            $scope.updateEvent(event);
        };

        /* alert on Resize */
        $scope.alertOnResize = function (event, dayDelta, minuteDelta, revertFunc, jsEvent, ui, view) {
            console.log("Event resized: ", event);
            $scope.alertMessage = ('Event Resized to make dayDelta ' + minuteDelta);
            $scope.updateEvent(event);
        };

        /* add custom event*/
        $scope.addEvent = function () {
            $scope.events.push({
                title: 'Open Sesame',
                start: new Date(y, m, 28),
                end: new Date(y, m, 29),
                className: ['openSesame']
            });
        };

        /* remove event */
        $scope.remove = function (index) {
            $scope.events.splice(index, 1);
        };

        /* Change View */
        $scope.changeView = function (view, calendar) {
            calendar.fullCalendar('changeView', view);
        };

        /* Change View */
        $scope.renderCalender = function (calendar) {
            if (calendar) {
                calendar.fullCalendar('render');
            }
        };

        /* config object */
        $scope.uiConfig = {
            calendar: {
                height: 450,
                editable: true,
                header: {
                    left: 'title',
                    center: '',
                    right: 'today prev,next'
                },
                eventClick: $scope.alertOnEventClick,
                eventDrop: $scope.alertOnDrop,
                eventResize: $scope.alertOnResize
            }
        };

        $scope.eventSources = [
            {
                events: $scope.eventsF,
                color: 'green',   // an option!
                textColor: 'black' // an option!
            }
        ];

    }]);
})();