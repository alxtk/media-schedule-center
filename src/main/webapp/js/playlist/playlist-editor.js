(function() {
    var app = angular.module("playlistEditor", ['contentFileManager']);
    app.controller('playlistFileController', ['$scope', function($scope) {
        $scope.files=[
            {
                title: 'test1'
            },
            {
                title: 'test2'
            }
        ]
    }]);
})();