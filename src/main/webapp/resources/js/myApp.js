var myApp = angular.module('myApp', []);

myApp.controller('MyCtrl', function($scope) {

    $scope.setFile = function(element) {

        $scope.$apply(function($scope) {

            $scope.theFile = element.files[0];
            console.log($scope.theFile);

            $scope.FileMessage = '';



            var filename = $scope.theFile.name;
            var index = filename.lastIndexOf(".");
            var strsubstring = filename.substring(index, filename.length);
            var sizeFile = $scope.theFile.size;

            const MAXSIZE = 200;

            console.log('size:', sizeFile);

            if (strsubstring == '.css' && sizeFile <= MAXSIZE)
            {
                console.log('File Uploaded sucessfully');
            }
            else {

                $scope.theFile = '';
                $scope.FileMessage = 'please upload correct File Name, File extension should be .css or to big size file';

            }

        });
    };

});

myApp.controller('MainCtrl', ['$scope', 'fileUpload', function ($scope, fileUpload) {

    $scope.uploadFile = function () {
        var file = $scope.myFile;

        console.log('file is', file);

        var uploadUrl = "/fileUpload";
        fileUpload.uploadFileToUrl(file, uploadUrl);
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
                console.log('data', data);
                console.log('it work');
            })

            .error(function () {
                console.log('error')
            });
    }
}]);

