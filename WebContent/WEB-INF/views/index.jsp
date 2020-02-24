<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            <div id="slideObject">
                <div class="container">
                    <div class="main-visual-info">
                        <div class="info-title">
                            <h2 class="text-border">축산농가의 경영·생산·출하관리 솔루션</h2>
                            <h2 class="text-border">스마트데일리</h2>
                        </div>
                        <div class="info-content">
                            <h3 class="text-border">AI기능을 이용하여 실시간으로 체크 확인 하실 수 있는 모니터링 시스템 입니다.</h3>
                        </div>
                        <div class="info-button"><a href="${pageContext.request.contextPath}/board/daily_check.do">시작하기</a></div>
                    </div>
                </div>
            </div>
            <div id="main-article">
                <div class="main-article-left">
                   <div class="main-article-text">
                        <p>스마트 데일리 서비스에 대해 알고 싶으세요?</p>
                        <p>지금 바로 알아보세요.</p>
                    </div>
                    <button class="button"><span><a href="${pageContext.request.contextPath}/board/service_info.do">자세히 알아보기</a></span></button>
                </div>
                <div class="main-article-right">
                    <div class="main-article-text">
                        <p>스마트 데일리 서비스를 고민 중이세요?</p>
                        <p>지금 바로 문의해 보세요.</p>
                    </div>
                    <button class="button"><span><a href="${pageContext.request.contextPath}/board/estimate_enquiry.do">견적 문의하기</a></span></button>
                </div>
            </div>
        </div>
    </section>

<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
</body>
</html>
