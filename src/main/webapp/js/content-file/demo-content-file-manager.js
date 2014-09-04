(function() {
    var app = angular.module("demoContentFileManager", ['contentFileManager']);
    app.controller('Controller', ['$scope', function($scope) {
        $scope.sucks = 'NO';
    }]);
})();