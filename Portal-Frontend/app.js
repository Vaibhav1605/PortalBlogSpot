var Homemodule = angular.module('Homemodule',['ngRoute','ClientValidation','ngCookies']);

Homemodule.config(function($routeProvider){
  $routeProvider

  .when("/",{
    templateUrl:'Home.html'

  })

  .when("/signup",{
    templateUrl:'SignUp.html',
    controller:'HomeController'
  })

  .when("/Login",{
    templateUrl:'Login.html',
    controller:'HomeController'
  })
  .when("/home",{
    templateUrl:"Home.html"
  })
  .when("/MyProfile",{
    templateUrl:'MyProfile.html',
    controller:'HomeController'
  })
  .when("/logout", {
    templateUrl: "Login.html",
    controller: "HomeController"
})
})



var ClientValidation=angular.module('ClientValidation', []).directive('validConfirmPassword', function () {
  return {
      require: 'ng-Model',
      link: function (scope, elm, attrs, ctrl) {
          ctrl.$parsers.unshift(function (viewValue, $scope) {
              var noMatch = viewValue != scope.clientForm.password.$viewValue
              ctrl.$setValidity('noMatch', !noMatch)
          })
      }
  }
})
