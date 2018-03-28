/**
 * Created by songchao on 2018/3/28.
 */
$(function(){
    showUser();
    showPage();
    showComment();
});
//获取跳转页面携带过来的参数
function parseUrl(){
    var url=location.href;
    var i=url.indexOf('?');
    if(i==-1)return;
    var querystr=url.substr(i+1);
    var arr1=querystr.split('&');
    var arr2=new Object();
    for  (i in arr1){
        var ta=arr1[i].split('=');
        arr2[ta[0]]=ta[1];
    }
    return arr2;
}
function showPage(){
    var userInfo = sessionStorage.getItem('userInfo');
    userEntity = JSON.parse(userInfo);
    var yourId = userEntity.id;//登录人的id
    var v = parseUrl();//解析所有参数
    var artId = v['artId'];//就是你要的结果
    $("<img/>").attr("src",userEntity.headPic).addClass("img-circle").appendTo("#comment_imput_img");
    $.ajax({
        url: "${APP_PATH}/article/user/"+artId+"/"+yourId,
        type: "GET",
        success: function(result){
            console.log(result);
            showArticle(result);
            showUserInfo(result);
        }
    });
}
function showArticle(result) {
    $(".htmledit_views").empty();
    $(".htmledit_views").html(result.extend.article.content);
    $(".title_h1").empty();
    $(".title_h1").append(result.extend.article.title);
    $("#article_manage_read").empty();
    $("#article_manage_read").append(result.extend.article.readNum+"人阅读");
    $("#article_manage_comment").empty();
    $("#article_manage_comment").append("评论("+result.extend.article.commentNum+")");
    $("#collect").empty();
    $("#collect").append("收藏("+result.extend.article.collectNum+")");
    $("#art_praise").empty();
    $("#art_praise").append("点赞("+result.extend.article.praiseNum+")");
    $(".cate_txt").empty();
    $(".cate_txt").append(result.extend.article.category);
    $(".article_manage_time").empty();
    $(".article_manage_time").append(result.extend.article.lastUpdateDate);
    $("#praise-txt").empty();
    $("#praise-txt").append(result.extend.article.praiseNum);
    if(result.extend.article.isPraise == "空" && result.extend.article.isCollect == "空"){
        $(".praise_collect").empty();
    }else if(result.extend.article.isPraise == "点赞"){
        $("#praise").html("<img src='static/img/zan.png' id='praise-img' class='animation' />");
    }else if(result.extend.article.isPraise == "已点赞"){
        $("#praise").html("<img src='static/img/yizan.png' id='praise-img' class='animation' />");
    }
    console.log("测试收藏:"+result.extend.article.isCollect == "收藏");
    if(result.extend.article.isCollect == "收藏"){
        $(".collect").empty();
        $("<span></span>").addClass("glyphicon glyphicon-star").attr("id","collect_btn_y").attr("onclick","addCollect()").appendTo(".collect");
    }else if(result.extend.article.isCollect == "已收藏"){
        $(".collect").empty();
        $("<span></span>").addClass("glyphicon glyphicon-star").attr("id","collect_btn_n").attr("onclick","deleteCollect()").appendTo(".collect");
    }
}
function showUserInfo(result){
    $("#p_info_nickname").empty();
    $("#p_info_nickname").append(result.extend.user.nickname);
    if(result.extend.user.followed == "空"){
        $(".attention_btn").empty();
    }else if(result.extend.user.followed == "关注"){
        $("<button></button>").addClass("btn btn-default").attr("type","button").append("关注").appendTo(".attention_btn");
    }else if(result.extend.user.followed == "已关注"){
        $("<button></button>").addClass("btn btn-default").attr("type","button").append("关注").appendTo(".attention_btn");
    }
    if(result.extend.user.sex != null){
        $(".info_one_sex").empty();
        $(".info_one_sex").append("性别:  "+result.extend.user.sex);
    }else{
        $(".info_one_sex").empty();
        $(".info_one_sex").append("性别:  暂无");
    }
    if(result.extend.user.age != null){
        $(".info_one_age").empty();
        $(".info_one_age").append("年龄:  "+result.extend.user.age);
    }else{
        $(".info_one_age").empty();
        $(".info_one_age").append("年龄:  暂无");
    }
    if(result.extend.user.constellation != null){
        $(".info_two_constellation").empty();
        $(".info_two_constellation").append("星座:  "+result.extend.user.constellation);
    }else{
        $(".info_two_constellation").empty();
        $(".info_two_constellation").append("星座:  暂无");
    }
    if(result.extend.user.address != null){
        $(".info_two_address").empty();
        $(".info_two_address").append("居住地:  "+result.extend.user.address);
    }else{
        $(".info_two_address").empty();
        $(".info_two_address").append("居住地:  暂无");
    }
    if(result.extend.user.sex != null){
        $(".info_three").empty();
        $(".info_three").append("个性签名:  "+result.extend.user.signature);
    }else{
        $(".info_three").empty();
        $(".info_three").append("个性签名:  暂无");
    }
    $(".s_original").empty();
    $(".s_original").append(result.extend.user.articleNum);
    $(".s_fans").empty();
    $(".s_fans").append(result.extend.user.observedNum);
    $(".s_like").empty();
    $(".s_like").append(result.extend.user.collectNum);
    $(".s_comment").empty();
    $(".s_comment").append(result.extend.user.commentNum);
    $("#p_img_a").empty();
    $("<img/>").attr("src",result.extend.user.headPic).addClass("img-circle").appendTo("#p_img_a");
}

$("#praise").click(function(){
    var v = parseUrl();//解析所有参数
    var artId = v['artId'];//就是你要的结果
    var userInfo = sessionStorage.getItem('userInfo');
    userEntity = JSON.parse(userInfo);
    var userId = userEntity.id;


    var praise_img = $("#praise-img");
    var text_box = $("#add-num");
    var praise_txt = $("#praise-txt");
    var num=parseInt(praise_txt.text());
    //取消点赞
    if(praise_img.attr("src") == ("static/img/yizan.png")){
        var flag = "delete";
        $.ajax({
            url: "${APP_PATH}/article/praise/"+userId+"/"+artId+"/"+flag,
            type: "POST",
            success: function(result){
                if(result.code == 100){
                    $("#praise").html("<img src='static/img/zan.png' id='praise-img' class='animation' />");
                    praise_txt.removeClass("hover");
                    text_box.show().html("<em class='add-animation'>-1</em>");
                    $(".add-animation").removeClass("hover");
                    num -=1;
                    praise_txt.text(num)
                }
            }
        });
    }else{//点赞
        var flag = "add";
        $.ajax({
            url: "${APP_PATH}/article/praise/"+userId+"/"+artId+"/"+flag,
            type: "POST",
            success: function(result){
                if(result.code == 100){
                    $("#praise").html("<img src='static/img/yizan.png' id='praise-img' class='animation' />");
                    praise_txt.addClass("hover");
                    text_box.show().html("<em class='add-animation'>+1</em>");
                    $(".add-animation").addClass("hover");
                    num +=1;
                    praise_txt.text(num)
                }
            }
        });
    }
});
function addCollect(){
    var v = parseUrl();//解析所有参数
    var artId = v['artId'];//就是你要的结果
    var userInfo = sessionStorage.getItem('userInfo');
    userEntity = JSON.parse(userInfo);
    var userId = userEntity.id;
    var flag = "add";
    $.ajax({
        url: "${APP_PATH}/article/collect/"+userId+"/"+artId+"/"+flag,
        type: "POST",
        success: function(result){
            if(result.code == 100){
                $(".collect").empty();
                $("<span></span>").addClass("glyphicon glyphicon-star").attr("id","collect_btn_n").attr("onclick","deleteCollect()").appendTo(".collect");
            }
        }
    });
}
function deleteCollect(){
    var v = parseUrl();//解析所有参数
    var artId = v['artId'];//就是你要的结果
    var userInfo = sessionStorage.getItem('userInfo');
    userEntity = JSON.parse(userInfo);
    var userId = userEntity.id;
    var flag = "delete";
    $.ajax({
        url: "${APP_PATH}/article/collect/"+userId+"/"+artId+"/"+flag,
        type: "POST",
        success: function(result){
            if(result.code == 100){
                $(".collect").empty();
                $("<span></span>").addClass("glyphicon glyphicon-star").attr("id","collect_btn_y").attr("onclick","addCollect()").appendTo(".collect");
            }
        }
    });
}
function showReplyDiv(id){
    $("#reply_textarea_"+id).show();
    $(".reply_close").show();
    $(".reply_a").hide();
}
function hideReply(id){
    $("#reply_textarea_"+id).hide();
    $(".reply_close").hide();
    $(".reply_a").show();
}
function addComment(){
    var userInfo = sessionStorage.getItem('userInfo');
    userEntity = JSON.parse(userInfo);
    var userId = userEntity.id;//登录人的id
    var v = parseUrl();//解析所有参数
    var artId = v['artId'];//就是你要的结果
    var content = $("#comment_content").val();
    alert(content);
    $.ajax({
        url: "${APP_PATH}/comment",
        type: "POST",
        data: {"userId":userId, "artId":artId, "parId":0, "content":content},
        dataType: "json",
        success: function(result){
            alert(result.code);
        }
    });
}

function showComment(){
    var v = parseUrl();//解析所有参数
    var artId = v['artId'];//就是你要的结果
    $.ajax({
        url: "${APP_PATH}/comments/"+artId,
        type: "GET",
        success: function(result){
            console.log(result);
        }
    });
}

function buildComment(result){

}
