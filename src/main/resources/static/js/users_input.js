$(function () {
    $submitBTN = $("#submit_BTN");
    $password = $("#password");
    $pswConfirm = $("#pswConfirm");
    $username = $("#username");
    $form = $("#inputForm");
    $user_msg = $("#user_msg_container");
    $psw_msg = $("#psw_msg_container");
    $username.focus(function () {
        //点击时移除msg
        $user_msg.empty();
    })
    $password.focus(function () {
        //点击时移除msg
        $psw_msg.empty();
    })
    $pswConfirm.focus(function () {
        //点击时移除msg
        $psw_msg.empty();
    })
    $username.blur(function () {
        //用户名是否可用
        var username =$username.val();
        $.post("/checkUsername",{username:username},function (data) {
            if(data === ""){
                //若不存在
                $user_msg.html("用户名可用"+"<br>");
                $user_msg.css("color","green");
            }else{
                $user_msg.html("用户名不可用"+"<br>");
                $user_msg.css("color","red");
            }
        })
    })
    //提交前判定两次密码输入是否一致
    $submitBTN.click(function () {
        var isSame = $password.val() === $pswConfirm.val();
        if(!isSame){
            //若不一致
            $psw_msg.html("两次输入密码必须一致"+"<br>");
            $psw_msg.css("color","red");
        }else {
            //若输入一致，提交
            $form.submit();
        }
        return false;
    })
})