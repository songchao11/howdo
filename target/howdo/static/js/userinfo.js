/**
 * Created by songchao on 2018/3/16.
 */
function showUser(){
    //清空 .user_menu div里面的东西
    $(".user_menu").empty();
    var userInfo = sessionStorage.getItem('userInfo');
    userEntity = JSON.parse(userInfo);

    if(userEntity != null){
        var a_user = $("<a></a>").addClass("dropdown-toggle").attr("href","#").attr("data-toggle","dropdown")
            .attr("role","button").attr("aria-haspopup","true").attr("aria-expanded","false").append(userEntity.nickname)
            .append($("<span></span>").addClass("caret"));
        var a_ul = $("<ul></ul>").addClass("dropdown-menu").append($("<li></li>").append($("<a></a>").attr("href","personal.jsp").append("个人中心")))
            .append($("<li></li>").addClass("divider").attr("role","separator"))
            .append($("<li></li>").append($("<a></a>").append("退出登录").attr("id","a_logout").attr("href","logout").attr("onclick","removeSession()")));
        $("<span></span>").append(a_user).append(a_ul).appendTo(".user_menu");
    }else if(userEntity ==null){
        var a_login = $("<a></a>").append("登录").attr("href","login.jsp");
        var a_text = $("<span></span>").append("&nbsp;|&nbsp;");
        var a_register = $("<a></a>").append("注册").attr("href","register.jsp");
        $("<span></span>").append(a_login).append(a_text).append(a_register).appendTo(".user_menu");
    }
}

function removeSession(){
    sessionStorage.removeItem("userInfo");
}
