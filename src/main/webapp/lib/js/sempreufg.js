$(function () {
    $(document).keydown(function (e) {
        return (e.which || e.keyCode) != 116;
    });
});

angular.module('sempreufg', ['ngAnimate', 'ngRoute', 'angular-growl'])
    .config(['growlProvider', function (growlProvider) {
        growlProvider.globalTimeToLive(5000);
        growlProvider.globalPosition('top-right');
    }]);
