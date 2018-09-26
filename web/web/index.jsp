<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="cn">
    <meta charset="UTF-8">
    <title>学子商城首页</title>
    <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/slide.css" rel="stylesheet"/>
</head>
<%-- 包含头部片段 --%>
<jsp:include page="header.jsp"></jsp:include>
<body>
<!-- banner部分-->
<div class="ck-slide">
    <ul class="ck-slide-wrapper">
        <li>
            <a href="${pageContext.request.contextPath}/goods/showProductDetails.do?id=10000010"><img src="${pageContext.request.contextPath}/images/itemCat/itemCat_banner1.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="${pageContext.request.contextPath}/goods/showProductDetails.do?id=10000010"><img src="${pageContext.request.contextPath}/images/itemCat/itemCat_banner2.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="${pageContext.request.contextPath}/goods/showProductDetails.do?id=10000010"><img src="${pageContext.request.contextPath}/images/itemCat/itemCat_banner3.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="${pageContext.request.contextPath}/goods/showProductDetails.do?id=10000010"><img src="${pageContext.request.contextPath}/images/itemCat/itemCat_banner4.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="${pageContext.request.contextPath}/goods/showProductDetails.do?id=10000010"><img src="${pageContext.request.contextPath}/images/itemCat/itemCat_banner1.png" alt=""></a>
        </li>
    </ul>
    <a href="javascript:;" class="ctrl-slide ck-prev">上一张</a> <a href="javascript:;" class="ctrl-slide ck-next">下一张</a>
    <div class="ck-slidebox">
        <div class="slideWrap">
            <ul class="dot-wrap">
                <li class="current"><em>1</em></li>
                <li><em>2</em></li>
                <li><em>3</em></li>
                <li><em>4</em></li>
                <li><em>5</em></li>
            </ul>
        </div>
    </div>
</div>

<!--/*楼梯1f*/-->
<h2 id="computer" class="stair"><span><img src="${pageContext.request.contextPath}/images/itemCat/computer_icon.png" alt=".stair"/></span>办公电脑 /1F</h2>

<div class="lf1">
    <div class="lf1_top">
        <!-- 上面部分左侧区域-->
        <div class="left lf">
            <div class="left_pro lf">
                <p class="top_ys1">灵越 燃7000系列</p>

                <p class="top_ys2">
                    酷睿双核i5处理器|256GB SSD| 8GB内存
                    </br>
                    英特尔HD显卡620含共享显卡内存
                </p>

                <p class="top_ys3">￥4999.00</p>

                <p class="top_ys4 color_2"><a href="${pageContext.request.contextPath}/goods/showProductDetails.do?id=10000010">查看详情</a></p>
            </div>
            <span><img src="${pageContext.request.contextPath}/images/itemCat/study_computer_img1.png" alt=""/></span>
        </div>
        <!-- 上面部分右侧区域-->
        <div class="right lf">
            <div class="right_pro lf">
                <p class="top_ys1">颜值 框不住</p>

                <p class="top_ys2">
                    酷睿双核i5处理器|256GB SSD| 8GB内存
                    </br>
                    英特尔HD显卡620含共享显卡内存
                </p>

                <p class="top_ys3">￥6888.00</p>

                <p class="top_ys4 color_2"><a href="${pageContext.request.contextPath}/goods/showProductDetails.do?id=10000010">查看详情</a></p>
            </div>
            <span><img src="${pageContext.request.contextPath}/images/itemCat/study_computer_img2.png" alt=""/></span>
        </div>
    </div>
    <div class="lf1_bottom">
        <div class="item_cat lf">
            <div class="cat_header color_2">
                <span>
                    <img src="${pageContext.request.contextPath}/images/itemCat/computer_icon1.png" alt=""/>
                    电脑,办公/1F
                </span>
            </div>
            <div class="item_cat_all">
                <c:forEach items="${list2}" varStatus="status">
                    <p>${list2[status.index].name}</p>
                    <ul>
                        <c:forEach items="${list3[status.index]}" var="cc">
                            <li><a href="${pageContext.request.contextPath}/goods/showSearch.do?categoryId=${cc.id}">${cc.name}</a></li>
                        </c:forEach>
                    </ul>
                </c:forEach>
            </div>
        </div>
        <%--双引号内千万不能有空格，大括号内可以有空格！--%>
        <c:forEach items="${goodsList}" var="goods">
            <div class="item_msg lf">
                <img src="..${goods.image}" style="width:198px; height:136px" alt=""/>
                <p class="bottom_ys2" style="width:198px; height:28px">${goods.title}</p>
                <p class="bottom_ys3">￥${goods.price}</p>
                <p class="bottom_ys4 color_2"><a href="${pageContext.request.contextPath}/goods/showProductDetails.do?id=10000010">查看详情</a></p>
            </div>
        </c:forEach>
    </div>
</div>
<!--楼梯2f-->
<h2 id="stationery" class="stair"><span><img src="${pageContext.request.contextPath}/images/itemCat/stationery_icon.png" alt=".stair"/></span>办公文具 /2F</h2>

<div class="lf1">
    <div class="lf1_top">
        <!-- 上面部分左侧区域-->
        <div class="left lf">
            <div class="left_ys1 lf"><img src="${pageContext.request.contextPath}/images/itemCat/study_stationery_img1.png" alt=""/></div>
            <div class="left_pro lf">
                <p class="top_ys1">雅致布面年历本</p>

                <p class="top_ys2">
                    有色更有范！变色PU皮，撞色搭配，绚丽色彩，张扬个性，点亮生活新时尚！
                </p>

                <p class="top_ys3 price_ys3">仅售 ￥49.00</p>

                <p class="top_ys4 color_1"><a href="${pageContext.request.contextPath}/goods/showProductDetails.do?id=10000010">查看详情</a></p>
            </div>
        </div>
        <!-- 上面部分右侧区域-->
        <div class="right lf">
            <div class="left_ys2 lf"><img src="${pageContext.request.contextPath}/images/itemCat/study_stationery_img2.png" alt=""/></div>
            <div class="right_ys rt">
                <p class="top_ys1">透视网格拉链袋</p>
                <p class="top_ys2">
                    韩国创意卡通 丛林物语网格文件袋
                </p>
                <p class="top_ys3 price_ys3">仅售 ￥28.00</p>

                <p class="top_ys4 color_1"><a href="${pageContext.request.contextPath}/goods/showProductDetails.do?id=10000010">查看详情</a></p>
            </div>
        </div>
    </div>
    <div class="lf1_bottom">
        <div class="item_cat lf">
            <div class="cat_header color_1">
                <span>
                    <img src="${pageContext.request.contextPath}/images/itemCat/stationery_icon1.png" alt=""/>
                    办公文具/2F
                </span>
            </div>
            <div class="item_cat_all item_color">
                <p>办公设备</p>
                <ul>
                    <li><a href="#">投影机</a></li>
                    <li><a href="#">打印机</a></li>
                    <li><a href="#">点钞机</a></li>
                    <li><a href="#">碎纸机</a></li>
                    <li><a href="#">考勤机</a></li>
                    <li><a href="#">保险柜</a></li>
                </ul>
                <p>文具耗材</p>
                <ul>
                    <li><a href="#">学生文具</a></li>
                    <li><a href="#">办公文具</a></li>
                    <li><a href="#">纸类</a></li>
                    <li><a href="#">打印耗材</a></li>
                    <li><a href="#">服务器</a></li>
                    <li><a href="#">联想</a></li>
                </ul>
                <p>电脑整机</p>
                <ul>
                    <li><a href="#">笔记本</a></li>
                    <li><a href="#">游戏机</a></li>
                    <li><a href="#">台式机</a></li>
                    <li><a href="#">一体机</a></li>
                    <li><a href="#">服务器</a></li>
                    <li><a href="#">联想</a></li>
                </ul>
            </div>
        </div>
        <div class="item_msg lf">
            <img src="${pageContext.request.contextPath}/images/itemCat/study_stationery_img3.png" alt=""/>

            <p class="bottom_ys2">得力（deli）1548A商务办公桌面计算器 太阳能双电源</p>

            <p class="bottom_ys3 price_ys3">￥58.00</p>

            <p class="bottom_ys4 color_1"><a href="${pageContext.request.contextPath}/goods/showProductDetails.do?id=10000010">查看详情</a></p>
        </div>
        <div class="item_msg lf">
            <img src="${pageContext.request.contextPath}/images/itemCat/study_stationery_img4.png" alt=""/>

            <p class="bottom_ys2">施耐德（Schneider） K15 经典款圆珠笔 </p>

            <p class="bottom_ys3 price_ys3">￥12.00</p>

            <p class="bottom_ys4 color_1"><a href="${pageContext.request.contextPath}/goods/showProductDetails.do?id=10000010">查看详情</a></p>
        </div>

        <div class="item_msg lf">
            <a href="${pageContext.request.contextPath}/goods/showProductDetails.do?id=10000010">
            <img src="${pageContext.request.contextPath}/images/itemCat/study_stationery_img5.png" alt=""/>
            <p class="bottom_ys2">齐心皮面日程本子2017.1-2018.6计划记事本效率手册</p>
            <p class="bottom_ys3 price_ys3">￥23.00</p>
            <p class="bottom_ys4 color_1"><a href="${pageContext.request.contextPath}/goods/showProductDetails.do?id=10000010" id="iii">查看详情</a></p>
            </a>
        </div>

    </div>
</div>

<!--页面底部-->
<jsp:include page="footer.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/slide.js"></script>
<script>
    $.ajax({
        url:'http://localhost:8080/goods/listGoodsCategories.do',
        dataType: 'json',
        method: 'GET'
    });
    $.ajax({
        url:'http://localhost:8080/goods/listGoods.do',
        dataType: 'json',
        method: 'GET'
    });
    $('.ck-slide').ckSlide({
        autoPlay: true,//默认为不自动播放，需要时请以此设置
        dir: 'x',//默认效果淡隐淡出，x为水平移动，y 为垂直滚动
        interval:3000//默认间隔2000毫秒
    });
</script>
<script>
    $("#iii").click(function(){
        location.href="${pageContext.request.contextPath}/goods/showProductDetails.do?id=10000010";
    })
</script>
</body>
</html>