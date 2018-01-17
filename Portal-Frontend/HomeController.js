Homemodule.controller('HomeController', function($scope, $rootScope, HomeService, $location, $cookieStore, $cookies) {

  if ($cookieStore.get('Client') != null) {
    $rootScope.clientdetails = $cookieStore.get('Client');
    $rootScope.authenticated = true;
  }

  $scope.SignUp = function() {

    console.log($scope.Client);
    HomeService.SignUp($scope.Client).then(
      function(response) {

        $scope.SignUp = null;
        $scope.message = "Registerd Successfully,Please Login."
        alert($scope.message)
        $location.path("/Login")
      }

      ,
      function(response) {
        $scope.message = "Registration Failed,Try Again." + $scope.status
        alert($scope.message)
      })
  }

  $scope.Login = function() {
    HomeService.Login($scope.clientdata).then(function(response) {
      alert("Logged in Successfully");
      $cookieStore.put('Client', response.data)
      $rootScope.clientdetails = $cookieStore.get('Client')
      console.log($rootScope.clientdetails.Client_role);
      $rootScope.authenticated = true;
      console.log($rootScope.authenticated);
      $location.path("/home")
    }, function(response) {})
  }


  $scope.MyProfile = function() {
    HomeService.MyProfile($rootScope.clientdetails).then(function(response) {
        console.log(response.data)

        $location.path("Home")
      }),
      function(response) {
        console.log(response)
      }

  }
  $scope.logout = function() {
    console.log("called");
    $cookies.remove('authentication')
    $rootScope.authenticated = null;
    $cookieStore.remove("Client");
    $cookieStore.clientdetails = null;
    $rootScope.authenticated = false;
    $location.path("/")
  }
})
