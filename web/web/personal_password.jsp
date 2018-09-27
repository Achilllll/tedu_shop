<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <name>我的订单 - 商城</name>
    <link href="${pageContext.request.contextPath}/css/orders.css" rel="Stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/header.css" rel="Stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="Stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/personage.css" rel="stylesheet" />
</head>
<body>
<%-- 包含头部片段 --%>
<jsp:include page="header.jsp"></jsp:include>

<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
    </ul>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
    <jsp:include page="left.jsp"></jsp:include>

    <!-- 右边栏-->
    <!--个人信息头部-->
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span ><a href="${pageContext.request.contextPath}/user/showPersonInfo.do">我的信息</a></span>
            <span class="rs_header_active"><a href="${pageContext.request.contextPath}/user/showPassword.do">安全管理</a></span>
        </div>

        <!--安全管理 -->
        <div class="rs_content">
            <p class="change_password_title">更改密码</p>
            <div class="new_password">
                <span class="word">输入旧密码：</span><input id="oldPwd" type="password" name="oldPwd"/><span id="oldPwdSpan" class="change_hint"></span>
            </div>
            <div class="new_password">
                <span class="word">输入新密码：</span><input id="newPwd" type="password" name="newPwd"/><span id="newPwdSpan" class="change_hint"></span>
            </div>
            <div class="confirm_password">
                <span class="word">确认新密码：</span><input id="confirmPwd" type="password" name="confirmPwd"/><span class="confirm_hint" id="confirmPwdSpan"></span>
            </div>
            <div class="save_password" onclick="updatePassword()">
                保存更改
            </div>
        </div>


    </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.page.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/orders.js"></script>
<script type="text/javascript">
    // 验证密码长度
    function checkPasswordLength(pwd) {
        return pwd.length >=6 && pwd.length <=9;
    }
    // 验证新密码和确认密码是否相同
    function checkEqualsPwd() {
        // 获取新密码框的值
        var newPwdValue = $("#newPwd").val();
        // 获取确认新密码框的值
        var confirmPwdValue = $("#confirmPwd").val();
        return newPwdValue == confirmPwdValue;
    }
    // 旧密码框长度的验证
    $("#oldPwd").blur(function(){
        //获取旧密码
        var oldPwdValue = $("#oldPwd").val();
        if(checkPasswordLength(oldPwdValue)){
            $("#oldPwdSpan").html("密码格式正确");
            $("#oldPwdSpan").css("color","green");
        }else{
            $("#oldPwdSpan").html("密码格式不正确");
            $("#oldPwdSpan").css("color","red");
        }
    });
    //新密码框长度的验证
    $("#newPwd").blur(function(){
        //获取旧密码
        var newPwdValue = $("#newPwd").val();
        if(checkPasswordLength(newPwdValue)){
            $("#newPwdSpan").html("密码格式正确");
            $("#newPwdSpan").css("color","green");
        }else{
            $("#newPwdSpan").html("密码格式不正确");
            $("#newPwdSpan").css("color","red");
        }
    });
    //新密码和确认新密码是否一致
    $("#confirmPwd").blur(function(){
        if(checkEqualsPwd()){
            $("#confirmPwdSpan").html("两次密码输入一致");
            $("#confirmPwdSpan").css("color","green");
        }else{
            $("#confirmPwdSpan").html("两次密码输入不一致");
            $("#confirmPwdSpan").css("color","red");
        }
    });
    //保存修改
    function updatePassword(){
        var oldPwdValue = $("#oldPwd").val();
        var newPwdValue = $("#newPwd").val();
        if(checkPasswordLength(oldPwdValue) &&
            checkPasswordLength(newPwdValue) &&
            checkEqualsPwd()){
            $.ajax({
                url:"${pageContext.request.contextPath}/user/updatePassword.do",
                data:"oldPwd=" + oldPwdValue + "&newPwd=" + newPwdValue,
                type:"POST",
                dataType:"json",
                success:function(obj){
                    if(obj.state==0){
                        alert(obj.message);
                    }else{
                        location="${pageContext.request.contextPath}/user/showLogin.do";
                    }
                }
            });
        }
    }
</script>

<!-- 处理侧边栏 -->
<script type="text/javascript">
    $(function(){
        //把所有的dd隐藏
        $("#leftsidebar_box dd").hide();
        //设置账号管理的列表显示
        $("#leftsidebar_box .count_managment dd").show();
        //设置所有的图片为 myOrder2.png
        $("#leftsidebar_box dt img").attr("src","${pageContext.request.contextPath}/images/myOrder/myOrder2.png");
        //设置账号管理的图片为myOrder1.png
        $("#leftsidebar_box .count_managment").find('img').attr("src","${pageContext.request.contextPath}/images/myOrder/myOrder1.png");

    });
</script>

</html>