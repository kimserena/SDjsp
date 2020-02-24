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
				<div class="sub-top-background1-2">
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
										이용 안내<i class="arrow down"></i>
									</button>
									<div class="dropdown-content">
										<a href="${pageContext.request.contextPath}/board/service_info.do">서비스 정보</a> 
										<a href="${pageContext.request.contextPath}/board/operation_guide.do" class="dropbtn-color">이용 안내</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<h2 class="text-border">이용 안내</h2>
			</div>

			<div class="container">
				<div class="tab">
					<button class="tablinks" onclick="openInfo(event, '01')"
						id="defaultOpen">도입필요성</button>
					<button class="tablinks" onclick="openInfo(event, '02')">도입효과</button>
					<button class="tablinks" onclick="openInfo(event, '03')">모바일
						서비스</button>
				</div>
			</div>
			<div id="01" class="tabcontent">
				<div id="sub-visual-bg-basic">
					<div id="sub-visual">
						<div class="container">
							<div class="sub-img-info">
								<div class="sub-title"></div>
								<div class="sub-content">
									<p class="caption">도입 필요성</p>
									<p>
										<img src="${pageContext.request.contextPath}/asset/img/img_animal_need.png" alt="도입필요성">
									</p>
									<p class="caption">향후 계획</p>
									<p>
										<img src="${pageContext.request.contextPath}/asset/img/img_animal_plan.png" alt="향후계획">
									</p>
								</div>
							</div>
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
									<p class="caption">도입 효과</p>
									<p>
										<img src="${pageContext.request.contextPath}/asset/img/img_animal_effect.png" alt="도입효과">
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
							</div>
							<article>
								<div class="og_content mobile"></div>
								<div id="_nowtext" class="_nowtext">
									<span>스마트데일리는 똑똑하게 하루의 정보를 확인 할 수 있는 농장의 작업 환경을 만듭니다.</span>
									<p>지금 바로 스마트데일리를 만나보세요!</p>
									<a href="https://www.apple.com/kr/ios/app-store/"
										target="_blank" rel="noreferrer" aria-label="app-store"><i
										class="fab fa-apple"></i> App Store
										<figure></figure> </a> <a target="_blank" rel="noreferrer"
										aria-label="google-play" href="https://play.google.com/store"><i
										class="fab fa-google-play"></i> Google Play
										<figure></figure> </a>
								</div>
							</article>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
</body>
</html>
