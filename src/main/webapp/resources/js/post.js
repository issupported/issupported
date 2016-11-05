var myaap = angular.module('myapp', []);
myaap.controller('mainCtrl', function ($http, $scope) {
   $http.post('/parse')
       .success(function (result) {
           console.log(result);
       })
        .error(function (result) {
        console.log('error');

    })
});
