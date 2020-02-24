<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/head.jsp"%>
</head>
<body style="overflow-y: scroll;">
	<%@ include file="/WEB-INF/views/inc/header.jsp"%>

    <section>
        <div id="wrap">
            <div class="serviceintro">
                <div class="sub-top-background3-3">
                    <div class="navbarbackg">
                        <div class="container">
                            <div class="navbar"> <a href="${pageContext.request.contextPath}/index.do"><i class="fas fa-home"></i></a>
                                <div class="dropdown">
                                    <button class="dropbtn">고객센터 <i class="arrow down"></i> </button>
                                    <div class="dropdown-content"> <a href="${pageContext.request.contextPath}/board/service_info.do">서비스 소개</a> <a href="${pageContext.request.contextPath}/users/user_edit.do">서비스 이용</a> <a href="${pageContext.request.contextPath}/board/notice.do" class="dropbtn-color">고객센터</a> <a href="${pageContext.request.contextPath}/board/estimate_enquiry.do">견적 문의</a></div>
                                </div>
                                <div class="dropdown">
                                    <button class="dropbtn">매뉴얼<i class="arrow down"></i> </button>
                                    <div class="dropdown-content"> <a href="${pageContext.request.contextPath}/board/notice.do">공지 사항</a> <a href="${pageContext.request.contextPath}/board/support.do">문의 하기</a> <a href="${pageContext.request.contextPath}/board/menual.do" class="dropbtn-color">매뉴얼</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <h2 class="text-border">매뉴얼</h2>
            </div>
            <div id="sub-visual-bg-basic">
                <div id="sub-visual">
                    <div class="container">
                        <div class="sub-content"> </div>
                        <div class="menual_container">
                            <div class="mySlides">
                                <img src="${pageContext.request.contextPath}/asset/img/menual0.png" style="width:100%"> </div>
                            <div class="mySlides">
                                <img src="${pageContext.request.contextPath}/asset/img/menual1.png" style="width:100%"> </div>
                            <div class="mySlides">
                                <img src="${pageContext.request.contextPath}/asset/img/menual2.png" style="width:100%"> </div>
                            <div class="mySlides">
                                <img src="${pageContext.request.contextPath}/asset/img/menual3.png" style="width:100%"> </div>
                            <div class="mySlides">
                                <img src="${pageContext.request.contextPath}/asset/img/menual4.png" style="width:100%"> </div>
                            <div class="mySlides">
                                <img src="${pageContext.request.contextPath}/asset/img/menual5.png" style="width:100%"> </div> <a class="prev" onclick="plusSlides(-1)">❮</a> <a class="next" onclick="plusSlides(1)">❯</a>
                            <div class="caption-container">
                                <p id="caption"></p>
                            </div>
                            <div class="menual_row">
                                <div class="column"> <img class="menual_demo cursor" src="${pageContext.request.contextPath}/asset/img/menual0.png" style="width:100%" onclick="currentSlide(1)" alt="<span style='color:#FF717B; font-size:35px; display:block; margin-bottom:10px;'>스마트데일리 일보조회 매뉴얼 입니다. </span> <span style='display:block; margin-bottom:20px;'>농장의 하루일보를 편리하게 조회해보세요!</span>"> </div>
                                <div class="column"> <img class="menual_demo cursor" src="${pageContext.request.contextPath}/asset/img/menual1.png" style="width:100%" onclick="currentSlide(2)" alt="<span style='color:#FF717B; font-size:35px; display:block; margin-bottom:10px;'>STEP01</span> <span style='display:block; margin-bottom:20px;'>일보조회에서 확인하고 싶은 탭을 선택해주세요.</span>"> </div>
                                <div class="column"> <img class="menual_demo cursor" src="${pageContext.request.contextPath}/asset/img/menual2.png" style="width:100%" onclick="currentSlide(3)" alt="<span style='color:#FF717B; font-size:35px; display:block; margin-bottom:10px;'>STEP02</span> <span style='display:block; margin-bottom:20px;'>해당 탭에서 해당 조건(시작월~종료월/해당 월/해당 년/농장 및 돈사)를 선택해주세요.</span>"> </div>
                                <div class="column"> <img class="menual_demo cursor" src="${pageContext.request.contextPath}/asset/img/menual3.png" style="width:100%" onclick="currentSlide(4)" alt="<span style='color:#FF717B; font-size:35px; display:block; margin-bottom:10px;'>STEP03</span> <span style='display:block; margin-bottom:20px;'>해당 월을 선택후 조회버튼을 눌러 조회하세요.</span>"> </div>
                                <div class="column"> <img class="menual_demo cursor" src="${pageContext.request.contextPath}/asset/img/menual4.png" style="width:100%" onclick="currentSlide(5)" alt="<span style='color:#FF717B; font-size:35px; display:block; margin-bottom:10px;'>STEP04</span> <span style='display:block; margin-bottom:20px;'>해당 데이터 조회가 완료되었습니다.</span>"> </div>
                                <div class="column"> <img class="menual_demo cursor" src="${pageContext.request.contextPath}/asset/img/menual5.png" style="width:100%" onclick="currentSlide(6)" alt="<span style='color:#FF717B; font-size:35px; display:block; margin-bottom:10px;'>STEP05</span> <span style='display:block; margin-bottom:20px;'>필요시 엑셀파일로 다운로드 받으실수 있습니다.</span>"> </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script type="text/javascript" src="${pageContext.request.contextPath}/asset/js/menual.js"></script>

	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
</body>
</html>
