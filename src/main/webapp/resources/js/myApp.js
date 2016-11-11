var myApp = angular.module('myApp', []);


myApp.controller('MainCtrl', ['$scope', 'fileUpload', function ($scope, fileUpload) {

    $scope.setFile = function (element) {

        $scope.$apply(function ($scope) {

            $scope.theFile = element.files[0];
            console.log($scope.theFile);

            $scope.FileMessage = '';


            var filename = $scope.theFile.name;
            var index = filename.lastIndexOf(".");
            var strsubstring = filename.substring(index, filename.length);
            var sizeFile = $scope.theFile.size;

            const MAXSIZE = 5000;

            console.log('size:', sizeFile);

            if (strsubstring == '.css' && sizeFile <= MAXSIZE) {
                $scope.uploadFile = function () {
                    var file = $scope.myFile;

                    console.log('file is ');
                    console.dir(file);


                    var uploadUrl = "/fileUpload";
                    fileUpload.uploadFileToUrl(file, uploadUrl);
                };

                console.log('File Uploaded sucessfully');
            }
            else {

                $scope.theFile = '';
                $scope.FileMessage = 'please upload correct File Name, File extension should be .css or to big size file';

            }

        });
    };

}]);


myApp.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

myApp.service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function (file, uploadUrl) {
        var fd = new FormData();
        fd.append('file', file);

        $http.post('/parse', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })

            .success(function (data) {
                console.log('it work', data)

            })

            .error(function () {
            });
    }
}]);