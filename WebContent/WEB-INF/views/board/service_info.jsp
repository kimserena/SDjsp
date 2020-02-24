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
				<div class="sub-top-background1">
					<div class="navbarbackg">
						<div class="container">
							<div class="navbar">
								<a href="${pageContext.request.contextPath}/index.do"><i class="fas fa-home"></i></a>
								<div class="dropdown">
									<button class="dropbtn">
										서비스 소개 <i class="arrow down"></i>
									</button>
									<div class="dropdown-content">
										<a href="${pageContext.request.contextPath}/board/service_info.do">서비스 소개</a> 
										<a href="${pageContext.request.contextPath}/users/user_edit.do">서비스 이용</a> 
										<a href="${pageContext.request.contextPath}/board/notice.do">고객센터</a>
										<a href="${pageContext.request.contextPath}/board/estimate_enquiry.do" class="dropbtn-color">견적문의</a>
									</div>
								</div>
								<div class="dropdown">
									<button class="dropbtn">
										서비스 정보<i class="arrow down"></i>
									</button>
									<div class="dropdown-content">
										<a href="${pageContext.request.contextPath}/board/service_info.do" class="dropbtn-color">서비스 정보</a> 
										<a href="${pageContext.request.contextPath}/board/operation_guide.do">이용 안내</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<h2 class="text-border">서비스 정보</h2>
			</div>

			<div class="container">
				<div class="tab">
					<button class="tablinks" onclick="openInfo(event, '01')"
						id="defaultOpen">스마트데일리란?</button>
					<button class="tablinks" onclick="openInfo(event, '02')">구성
						및 기능</button>
					<button class="tablinks" onclick="openInfo(event, '03')">농장일보
						자동 집계 장치</button>
				</div>
			</div>
			<div id="01" class="tabcontent">
				<div id="sub-visual-bg">
					<div id="sub-visual">
						<div class="container">
							<div class="sub-visual-info">
								<div class="sub-title">
									<h3>AI축산 스마트 데일리</h3>
								</div>
								<div class="sub-content">
									<p>축산농가에 최적 사양관리를 위한 『지능형 축사관리 솔루션』 보급 확산, 축산농가 생산비 절감 및
										최적의 사양관리 등으로 경쟁력 강화를 위한 ICT 융복합 장비지원사업입니다.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="idxProgram">
					<div>
						<h2>인공지능 축산 스마트데일리</h2>
						<p>인공지능 축산 스마트데일리는 축산농가의 경영, 생산, 출하관리 솔루션으로서, 수기로 기록하던 방식을
							AI기능을 이용하여 실시간으로 체크 확인 하실 수 있는 모니터링 시스템 입니다.</p>
						<div>
							<dl>
								<dt>
									<b>국내 자체기술</b><span>확보</span>
								</dt>
								<dd>
									축산농가에 최적 사양관리를 위한 <br>『지능형 축사관리 솔루션』 보급 확산
								</dd>
							</dl>
							<dl>
								<dt>
									<b>4차 산업혁명</b><span>기술 적용</span>
								</dt>
								<dd>
									농장의 재고 자산 관리 정확성과 효율성을 극대화 <br>축산업계의 새로운 패러다임을 제시
								</dd>
							</dl>
							<dl>
								<dt>
									<b>스마트데일리</b><span>실현</span>
								</dt>
								<dd>
									축산농가 생산비 절감 및 최적의 사양관리 등으로 <br>경쟁력 강화를 위한 ICT 융복합 장비지원사업
								</dd>
							</dl>
						</div>
					</div>
				</div>
			</div>
			<div id="02" class="tabcontent">
				<div id="sub-visual-bg-basic">
					<div id="sub-visual">
						<div class="container">
							<div class="sub-img-info">
								<div class="sub-title"></div>
								<div class="sub-content">
									<p class="caption">서비스 구성도</p>
									<p>
										<img src="${pageContext.request.contextPath}/asset/img/img_animal_parts.png" alt="서비스구성도">
									</p>
									<p class="caption">서비스 실현</p>
									<p>
										<img src="${pageContext.request.contextPath}/asset/img/img_animal_parts2.png" alt="서비스실현">
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="03" class="tabcontent">
				<div id="sub-visual-bg-basic">
					<div id="sub-visual">
						<div class="container">
							<div class="sub-img-info">
								<div class="sub-title"></div>
								<div class="sub-content">
									<p class="caption">시스템 개요</p>
									<p>
										<img src="${pageContext.request.contextPath}/asset/img/img_animal_summary.png" alt="시스템개요">
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
</body>
</html>
