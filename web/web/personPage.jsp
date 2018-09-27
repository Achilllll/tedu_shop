<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <name>我的订单 - 商城</name>
    <link href="${pageContext.request.contextPath}/css/orders.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/personage.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon/css/bootstrap.min.css">
	<link href="${pageContext.request.contextPath}/css/icon/css/cropper.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/icon/css/sitelogo.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon/css/font-awesome.min.css">
</head>
<body>
<!-- 页面顶部-->
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
            <span class="rs_header_active"><a href="${pageContext.request.contextPath}/user/showPersonInfo.do">我的信息</a></span>
            <span><a href="${pageContext.request.contextPath}/user/showPassword.do">安全管理</a></span>
        </div>

        <!--个人信息具体内容 -->
        <div class="rs_content">
            <!--头像-->
            <div class="rs_content_headPortrait">
	                <span class="same">我的头像：</span>
                    <c:if test="${user.image==null}">
                        <img src="${pageContext.request.contextPath}/images/personage/touxiang.png" alt="" id="icon" width="50px" height="50px"/>
                    </c:if>
                    <c:if test="${user.image!=null}">
                        <%-- 反斜线已经存入了 --%>
                        <img src="${pageContext.request.contextPath}${user.image}" alt="" id="icon" width="50px" height="50px"/>
                    </c:if>
	                <%--<img src="${pageContext.request.contextPath}/images/personage/touxiang.png" alt="" id="icon" width="50px" height="50px"/>--%>
	                <input type="file" name="file" id="iconPic" onchange="getImage()">
	                <%--<span class="change_headPortrait same_click" data-toggle="modal" data-target="#avatar-modal" >更改头像</span>--%>
	            </div>
            <form action="" id="form_update">
                <!--用户名-->
                <div class="rs_content_username">
                    <span class="same">用户名：</span>
                    <span class="same rs_username">${user.username}</span>
                    <input id="username" class="ed_username" name="username" value="${user.username}" style="display: none;"/>
                    <span class="change_username same_click">更改用户名</span>
                </div>
                <!--性别-->
                <div class="rs_content_sex">
                    <span class="same">性别：</span>
                    <%--
                    <span class="man selected">
                        <img src="${pageContext.request.contextPath}/images/personage/select.png" alt=""/>男
                    </span>
                    <span class="women">
                        <img src="${pageContext.request.contextPath}/images/personage/un_select.png" alt=""/>女
                    </span>
                    --%>
                    &nbsp;&nbsp;
                    <input
                            type="radio"
                            name="gender"
                            id="gender"
                            value="0"
                            <c:if test="${user.gender==0}">
                                checked
                            </c:if>
                            >男
                    &nbsp;&nbsp;
                    <input
                            type="radio"
                            name="gender"
                            id="gender"
                            value="1"
                            <c:if test="${user.gender==1}">
                                checked
                            </c:if>
                            >女
                </div>
                <!--绑定电话-->
                <div class="rs_content_tel">
                    <span class="same">绑定电话：</span>
                    <input type="text" value="${user.phone}" name="phone" id="phone"/>
                </div>
                <!--绑定邮箱-->
                <div class="rs_content_mail">
                    <span class="same">绑定邮箱：</span>
                    <input class="ed_email" name="email" id="email" value="${user.email}" style="display: none;"/>
                    <span class="rs_mail">${user.email}</span>
                    <span class="same_click change_mail">更改邮箱</span>
                </div>
                <!--保存按钮-->
                <div class="save" onclick="saveUpdate()">
                    保存更改
                </div>
            </form>
        </div>
    </div>
</div>
<!-- 头像插件 -->
<div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1"> 
    <div class="modal-dialog modal-lg"> 
        <div class="modal-content"> 
            <!--<form class="avatar-form" action="upload-logo.php" enctype="multipart/form-data" method="post">--> 
            <form class="avatar-form"> 
                <div class="modal-header"> 
                    <button class="close" data-dismiss="modal" type="button">×</button> 
                    <h4 class="modal-name" id="avatar-modal-label">上传图片</h4>
                </div> 
                <div class="modal-body"> 
                    <div class="avatar-body"> 
                        <div class="avatar-upload"> 
                            <input class="avatar-src" name="avatar_src" type="hidden"> 
                            <input class="avatar-data" name="avatar_data" type="hidden"> 
                            <label for="avatarInput" style="line-height: 35px;">图片上传</label> 
                            <button class="btn btn-info"  type="button" style="height: 35px;" onClick="$('input[id=avatarInput]').click();">请选择图片</button> 
                            <span id="avatar-name"></span> 
                            <input class="avatar-input hide" id="avatarInput" name="avatar_file" type="file"></div> 
                        <div class="row"> 
                            <div class="col-md-9"> 
                                <div class="avatar-wrapper"></div> 
                            </div> 
                            <div class="col-md-3"> 
                                <div class="avatar-preview preview-lg" id="imageHead"></div> 
                                <!--<div class="avatar-preview preview-md"></div> 
                        <div class="avatar-preview preview-sm"></div>--> 
                            </div> 
                        </div> 
                        <div class="row avatar-btns"> 
                            <div class="col-md-4"> 
                                <div class="btn-group"> 
                                    <button class="btn btn-info fa fa-undo" data-method="rotate" data-option="-90" type="button" name="Rotate -90 degrees"> 向左旋转</button>
                                </div> 
                                <div class="btn-group"> 
                                    <button class="btn  btn-info fa fa-repeat" data-method="rotate" data-option="90" type="button" name="Rotate 90 degrees"> 向右旋转</button>
                                </div> 
                            </div> 
                            <div class="col-md-5" style="text-align: right;">                                 
                                <button class="btn btn-info fa fa-arrows" data-method="setDragMode" data-option="move" type="button" name="移动">
                                <span class="docs-tooltip" data-toggle="tooltip" name="" data-original-name="$().cropper("setDragMode", "move")">
                                </span> 
                              </button> 
                              <button type="button" class="btn btn-info fa fa-search-plus" data-method="zoom" data-option="0.1" name="放大图片">
                                <span class="docs-tooltip" data-toggle="tooltip" name="" data-original-name="$().cropper("zoom", 0.1)">
                                  <!--<span class="fa fa-search-plus"></span>--> 
                                </span> 
                              </button> 
                              <button type="button" class="btn btn-info fa fa-search-minus" data-method="zoom" data-option="-0.1" name="缩小图片">
                                <span class="docs-tooltip" data-toggle="tooltip" name="" data-original-name="$().cropper("zoom", -0.1)">
                                  <!--<span class="fa fa-search-minus"></span>--> 
                                </span> 
                              </button> 
                              <button type="button" class="btn btn-info fa fa-refresh" data-method="reset" name="重置图片">
                                    <span class="docs-tooltip" data-toggle="tooltip" name="" data-original-name="$().cropper("reset")" aria-describedby="tooltip866214">
                               </button> 
                            </div> 
                            <div class="col-md-3"> 
                                <button id="button_save" class="btn btn-info btn-block avatar-save fa fa-save" type="button" data-dismiss="modal"> 保存修改</button> 
                            </div> 
                        </div> 
                    </div> 
                </div> 
            </form> 
        </div> 
    </div> 
</div>

<!-- 页面底部-->
<jsp:include page="footer.jsp"></jsp:include>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.page.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/orders.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/personal.js"></script>
<script src="${pageContext.request.contextPath}/js/icon/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/icon/cropper.js"></script>
<script src="${pageContext.request.contextPath}/js/icon/sitelogo.js"></script>
<script src="${pageContext.request.contextPath}/js/icon/html2canvas.min.js" type="text/javascript" charset="utf-8"></script> 
<script type="text/javascript"> 

</script>

<script type="text/javascript">
$("#icon").click(function() {
	window.open($(this).attr("src"));
})
</script> 

<script type="text/javascript">
    // 上传头像图片
    function getImage(){
        // 创建一个设置表单数据的对象
        var formData = new FormData();
        // 获取上传文件的文件对象
        var file = document.getElementById("iconPic").files[0];
        formData.append("file", file);

        $.ajax({
            url:"${pageContext.request.contextPath}/user/upload.do",
            data:formData,
            type:"POST",
            dataType:"json",
            // 不处理数据
            contentType:false,
            processData:false,
            success:function(obj){
                alert(obj.message);
                // 创建url对象
                var url = window.URL.createObjectURL(file);
                icon.src=url;
            }
        });
    }

    //异步请求保存修改
    function saveUpdate(){
        $.ajax({
            url:"${pageContext.request.contextPath}/user/updateUser.do",
            data:$("#form_update").serialize(),
            type:"post",
            dataType:"json",
            success:function(obj){
                if(obj.state == 0){
                    alert(obj.message);
                }else{
                    // alert(obj.message);
                    // 刷新页面
                    location="${pageContext.request.contextPath}/user/showPersonInfo.do"
                }
            }
        });
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