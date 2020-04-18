//登陆
function _login() {

    //用户名，密码不为空提交异步登录请求
    var username = $("#username").val();
    var email = $("#email").val();
    var password = $("#password").val();
    if (username && password || email && password) {
        //提交异步登录请求

        $.post(
            "user/login",//servlet地址
            $("#loginForm").serialize(),//表单所有数据
            function (resultInfo) {
                if (resultInfo.flag) {
                    //登录成功，跳转到首页
                    location.href = "index.html";
                } else {
                    //失败，显示消息
                    $("#errorMsg").text(resultInfo.errorMsg);
                }
            },
            "json"
        );
    } else {
        $("#errorMsg").text("请输入用户名或密码");
    }

}

//管理员登录

//登陆
function _admin_login() {

    //用户名，密码不为空提交异步登录请求
    var username = $("#username").val();
    var email = $("#email").val();
    var password = $("#password").val();
    console.log(email,password,username)
    if (username && password || email && password) {
        //提交异步登录请求

        $.post(
            "/admin/login",//servlet地址
            $("#loginForm").serialize(),//表单所有数据
            function (resultInfo) {
                if (resultInfo.flag) {
                    //登录成功，跳转到首页
                    console.log("yes")
                    location.href = "index.html";
                } else {
                    //失败，显示消息
                    console.log("no")

                    $("#errorMsg").text(resultInfo.errorMsg);
                }
            },
            "json"
        );
    } else {
        $("#errorMsg").text("请输入用户名或密码");
    }

}