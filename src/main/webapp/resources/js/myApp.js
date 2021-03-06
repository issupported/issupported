var myApp = angular.module('myApp', []);



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


myApp.controller('MainCtrl', ['$scope', 'fileUpload', function ($scope, fileUpload) {
    $scope.showContent = function($fileContent){
        $scope.content = $fileContent;
    };

    $scope.setFile = function (element) {

        $scope.theFile = element.files[0];
        console.log($scope.theFile);

        $scope.FileMessage = '';


        var filename = $scope.theFile.name;
        var index = filename.lastIndexOf(".");
        var strsubstring = filename.substring(index, filename.length);
        var sizeFile = $scope.theFile.size;

        const MAXSIZE = 5000;

        console.log('size:', sizeFile);

        $scope.$apply(function ($scope) {

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
                console.log('error');
                // location.reload();
                $scope.FileMessage = 'please upload correct File Name, File extension should be .css or to big size file';

            }

        });
    };

}]);

// myApp.directive('onReadFile', function ($parse) {
//     return {
//         restrict: 'A',
//         scope: false,
//         link: function(scope, element, attrs) {
//             var fn = $parse(attrs.onReadFile);
//
//             element.on('change', function(onChangeEvent) {
//                 var reader = new FileReader();
//
//                 reader.onload = function(onLoadEvent) {
//                     scope.$apply(function() {
//                         fn(scope, {$fileContent:onLoadEvent.target.result});
//                     });
//                 };
//
//                 reader.readAsText((onChangeEvent.srcElement || onChangeEvent.target).files[0]);
//             });
//         }
//     };
// });

myApp.service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function (file, uploadUrl) {
        var fd = new FormData();
        fd.append('file', file);

        $http.post('/parse', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })

            .success(function (data) {
                console.log('it work', data);

            })

            .error(function () {

            });

    }
}]);



