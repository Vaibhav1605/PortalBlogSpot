Homemodule.controller('BlogController', function($scope, $rootScope, $location, $cookieStore, $filter, BlogService) {
  if ($cookieStore.get('blog') != null) {
    $rootScope.blogContent = $cookieStore.get('blog');
  }
  $scope.blog = {};
  $scope.addblog = function() {
    console.log($rootScope.clientdetails);
    $scope.blog.client = $rootScope.clientdetails
    console.log($scope.blog.client);
    if ($rootScope.clientdetails.client_role == 'admin') {
      $scope.blog.approved = 1;
    } else {
      $scope.blog.approved = 0;
    }
    BlogService.addblog($scope.blog).then(function(response) {

      $scope.blog = null;
      alert("Blog added Successfully")
    }, function(response) {
      console.log(response)
    })
  }

  $scope.blogslist = function() {
    BlogService.blogslist().then(function(response) {
      $scope.blogs = response.data
      $scope.approvedBlogs = [];
     $scope.unapprovedBlogs = [];
     angular.forEach($scope.blogs, function(value,approved){
       if(value.approved == 1)
       {
         $scope.approvedBlogs.push(value);
       }
       else{
       $scope.unapprovedBlogs.push(value);
     }
   })
  }), function(response) {
      console.log(response);
    }
  }

  $scope.blogsinfo = function(id) {

      var blogData = $filter('filter')($scope.blogs, {
        blogId: id
      }, true)[0];
      console.log(blogData);
      $cookieStore.put('blog', blogData)
      $rootScope.blogContent = $cookieStore.get('blog')
      $location.path("/blogsinfo")
    },
    function(response) {
      console.log("123")
      console.log(response)
    }

$scope.approve = function(blogApproval) {
  console.log($rootScope.blogContent.blogId)
  console.log(blogApproval);
  $scope.blogApprove = {};
  $scope.blogApprove.blogId = $rootScope.blogContent.blogId;
  $scope.blogApprove.approved = blogApproval;
  BlogService.approve($scope.blogApprove).then(function(response) {
      console.log(response)
      $location.path("/blogslist")
    }),
    function(response) {
      console.log(response)
    }

}
})
