Homemodule.factory("HomeService", function($http) {

  var BASE_URL = "http://localhost:8087/portalmiddle";
  var clientservice = {};
  clientservice.SignUp = function(clientdata) {
    console.log(clientdata.firstName);

    return $http.post(BASE_URL + "/SignUp", clientdata)
  }
  clientservice.Login = function(clientdata) {
    return $http.post(BASE_URL + "/Login", clientdata);
  }
  clientservice.MyProfile = function(clientdata) {
    return $http.post(BASE_URL + "/MyProfile", clientdata);
  }

  return clientservice;
})
