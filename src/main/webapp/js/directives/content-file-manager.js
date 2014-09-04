(function () {
    var cfm = angular.module('contentFileManager', ['dotjem.angular.tree']);

    cfm.directive('contentFileManager', ['$http', function () {
        return {
            restrict: 'E',
            templateUrl: '/template/content-file-manager.html',
            scope: {
                rootFolder: '=rootFolder'
            },
            controller: function ($scope, $http) {

                $scope.files = [];

                var buildFileTree = function (files) {
                    var used = [];

                    function process(folder, files) {
                        for (var i = 0; i < files.length; ++i) {
                            if (used[i]) {
                                continue;
                            }
                            var file = files[i],
                                p1 = file.path.indexOf(folder.path),
                                p2 = file.path.indexOf('/', p1 + folder.path.length);
                            if (p1 < 0) {
                                /* ignore */
                            } else if (p1 == 0 && p2 < 0) {
                                folder.files.push(file);
                                used[i] = true;
                            } else {
                                var newFolder = {path: file.path.substr(0, p2 + 1), files: [], folders: []};
                                folder.folders.push(newFolder);
                                process(newFolder, files);
                            }
                        }
                        return folder;
                    }

                    return [process({path: '/', files: [], folders: []}, files.slice(0))];
                };

                var params = {};
                if (!!$scope.rootFolder) {
                    params.path = $scope.rootFolder;
                }
                $http.get((!$scope.rootFolder) ? '/files' : '/files/find/', {params: params})
                    .success(function (sFiles) {
                        console.log('Received files: ', sFiles);
                        $scope.root = buildFileTree(sFiles);
                        console.log($scope.root);
                    })
                    .error(function (res) {

                    });
            },
            link: function (scope, el, attr) {

            }
        }
    }]);
})();