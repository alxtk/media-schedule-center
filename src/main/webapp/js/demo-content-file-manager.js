(function() {
    var app = angular.module("demoContentFileManager", ['contentFileManager']);
    app.controller('Controller', ['$scope', function($scope) {
        console.log($scope);
        $scope.sucks = 'NO';
    }]);
})();