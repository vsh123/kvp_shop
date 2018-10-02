<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>		

<!-- 부트스트랩관련 라이브러리 -->
<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

<!-- 사용자작성 css -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css" />

<!DOCTYPE html>
<html>
<head>
</head>
<meta charset="UTF-8">
<body>
	<header>
		<div class="paddingTop50 paddingBottom50">
			<div class="inline-block width33p">
				<!-- 로고 넣을 div -->
			</div>
			
			<!--  선호 검색 개발 중! -->
			<div class="inline-block width33p textAlignCenter">
				<div class="width300 margin0auto">
				<form class="form-inline mt-2" action="${pageContext.request.contextPath}/book/bookSearch.do">
					  	<input class="form-control mr-sm-2" type="text" placeholder="Search" name="search" aria-label="Search">
					 	<button class="btn btn-transparent border0 focus-none" type="submit">
					 		<img src="${pageContext.request.contextPath }/resources/img/search.png" alt="" />
					 	</button>
				</form>
				</div>
			</div>
			
			
			
			<div class="inline-block width33p">
				<c:if test="${memberLoggedIn == null }">
					<button type="button" class="btn btn-transparent" data-toggle="modal" data-target="#loginModal">
						<img src="${pageContext.request.contextPath }/resources/img/user2.png" alt="" />
					</button>
				</c:if>	
				<c:if test="${memberLoggedIn != null }">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<img src="${pageContext.request.contextPath }/resources/img/user2.png" alt="" />
							</a>
				        	<div class="dropdown-menu" aria-labelledby="navbarDropdown">
				          		<a class="dropdown-item" href="#">My Page</a>
				          		<a class="dropdown-item" href="${pageContext.request.contextPath }/basket/selectBasketList.do?memberId=${memberLoggedIn.memberId }">Basket</a>
				          		<div class="dropdown-divider"></div>
				          		<a class="dropdown-item" href="${pageContext.request.contextPath }/member/memberLogout.do">Log out</a>
		               	  	</div>
				      	</li>
			      	</ul>
				</c:if>
			</div>
		</div>
		
		<div id="main-container">
			<nav class="navbar navbar-expand-md navbar-dark bg-dark nav-master">
				<a class="navbar-brand" href="${pageContext.request.contextPath }">Carousel</a>
			    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
			    	<span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarCollapse">
			    	<ul class="navbar-nav mr-auto">
			       		<li class="nav-item active">
			         		<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
			        	</li>
			        	<li class="nav-item">
			         		<a class="nav-link" href="#">Link</a>
			        	</li>
			        	<li class="nav-item dropdown">
				            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
				            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
				            	<a class="dropdown-item" href="#">Action</a>
				              	<a class="dropdown-item" href="#">Another action</a>
				              	<a class="dropdown-item" href="#">Something else here</a>
				            </div>
			          	</li>
			        	<li class="nav-item">
			          		<a class="nav-link disabled" href="#">Disabled</a>
			        	</li>
			      	
					    <%-- <c:if test="${memberLoggedIn == null }">
					      	<button type="button" class="btn btn-outline-light marginR10 marginL20" data-toggle="modal" data-target="#loginModal">Log In</button>
						</c:if>	 
						<c:if test="${memberLoggedIn != null }">
							<li class="nav-item dropdown">
						        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						          <img src="${pageContext.request.contextPath }/resources/img/mypage.png" alt="" />
						        </a>
					        	<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					          		<a class="dropdown-item" href="#">My Page</a>
					          		<a class="dropdown-item" href="#">Basket</a>
					          		<div class="dropdown-divider"></div>
					          		<a class="dropdown-item" href="#">Log out</a>
	                    	  	</div>
					      	</li>
						</c:if> --%>
			    	</ul>
				</div>
			</nav> 
		</header>
		<!-- Modal -->
		<form action="${pageContext.request.contextPath}/member/memberLogin.do">
			<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
			    	<div class="modal-content">
			      		<div class="modal-header">
			        		<h5 class="modal-title" id="exampleModalLabel">Login</h5>
			        		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          			<span aria-hidden="true">&times;</span>
			        		</button>
			      		</div>
			      		<div class="modal-body">
			        		<div class="borderBottom">
		            			<img src="${pageContext.request.contextPath}/resources/img/user.png" alt=""/>
		            			<input class="form-control boder-transparent inline width95p" type="text" placeholder="id" name="memberId">
	           				</div>
	            			<br />
	            			<div class="borderBottom">
		            			<img src="${pageContext.request.contextPath}/resources/img/lock.png" alt=""/>
		            			<input class="form-control boder-transparent inline width95p" type="password" placeholder="password" name="memberPassword">
	            			</div>
	            
	           				<br><br>
	           				<button type="submit" class="btn btn-primary width100p" id="login_btn">로그인</button>
	           				<hr class="">
	               			<button type="button" class="btn btn-outline-secondary width100p" onclick="location.href='${pageContext.request.contextPath}/member/memberEnroll.do'" id="enroll_btn">회원가입</button>
	               			
			      		</div>
			      		<!-- <div class="modal-footer">
			        		<button type="button" class="btn btn-secondary">Login</button>
			        		<button type="button" class="btn btn-primary">Join</button>
			      		</div> -->
			    	</div>
			  	</div>
			</div>
		</form>
		
		<section>