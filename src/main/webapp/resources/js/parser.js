var myapp = angular.module('myapp', []);

myapp.controller('MainCtrl', function ($scope) {
    $scope.showContent = function($fileContent){
        $scope.content = $fileContent;
    };
});

myapp.directive('onReadFile', function ($parse) {
    return {
        restrict: 'A',
        scope: false,
        link: function(scope, element, attrs) {
            var fn = $parse(attrs.onReadFile);

            element.on('change', function(onChangeEvent) {
                var reader = new FileReader();

                reader.onload = function(onLoadEvent) {
                    scope.$apply(function() {
                        fn(scope, {$fileContent:onLoadEvent.target.result});
                    });
                };

                reader.readAsText((onChangeEvent.srcElement || onChangeEvent.target).files[0]);
            });
        }
    };
});


myapp.directive('uiSource', function () {
    return {
        compile: function (elem) {
            var escape = function (content) {
                return content.replace(/\</g, '&lt;')
                    .replace(/\>/g, '&gt;');
            };
            var pre = angular.element('<pre class="prettyprint"></pre');
            var pretty = prettyPrintOne(escape(elem.html()));
            console.log(pretty);
            pre.append(pretty);
            elem.replaceWith(pre);
        }
    };
});

