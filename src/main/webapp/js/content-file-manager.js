(function () {
    var cfm = angular.module('contentFileManager', []);

    cfm.directive('contentFileManager', function () {
        return {
            restrict: 'E',
            templateUrl: '/template/content-file-manager.html',
            controller: function ($scope, $element) {
                console.log("Content-file-manager controller start");
                $scope.files = [
                    {},
                    {}
                ];
            },
            link: function (scope, el, attr) {

            }
        }
    });
})();