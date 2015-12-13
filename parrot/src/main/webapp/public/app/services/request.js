define(["jquery","app"],function ($,app) {
    app.service('request', function($q, $http){
        this.post = function (url,data) {
            return $http({
                method  : 'POST',
                url     : url,
                data    : $.param(data),  // pass in data as strings
                headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  // set the headers so angular passing info as form data (not request payload)
            });
        }
    });
});
