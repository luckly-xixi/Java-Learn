function getLoginStatus() {
    $.ajax({
        type:'get',
        url:'login',
        success:function(body) {
            //响应200，执行success回调
            console.log("用户已经登陆");
        },
        error:function(body) {
            //不响应200都会执行error,跳转到login.html主页
            location.assign("login.html");
        }
    })
}
getLoginStatus();