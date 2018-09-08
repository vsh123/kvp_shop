<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 우편번호 찾기 api -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script charset="UTF-8" type="text/javascript" src="http://t1.daumcdn.net/cssjs/postcode/1522037570977/180326.js"></script>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="회원가입" name="pageTitle"/>
</jsp:include>	

<style>
div#userId-container{
	position:relative; 
	padding:0px;
}
div#userId-container span.guide{
   display:none;
   font-size:12px;
   position:absolute;
   top:12px;
   right:10px;
}
</style>
	<div>
	<h2>회원가입</h2>
		<form action="memberEnrollEnd.do" method="post" onsubmit="return validate();">
			<table class="table" id="tblEnroll">
			<tr>
				<th><label for="memberId">아이디 <span class="red">*</span></label></th>
				<td>
					<div id="userId-container">
						<input type="text" name="memberId" id=memberId class="input form-control" required />
						<span class="guide green">이 아이디는 사용가능합니다.</span>
				      	<span class="guide red">이 아이디는 사용할 수 없습니다.</span>
				      	<input type="hidden" id="idDuplicateCheck" value="0" />
			      	</div>
				</td>
			</tr>
			<tr>
				<th><label for="memberPassword">비밀번호 <span class="red">*</span></label></th>
				<td><input type="password" name="memberPassword" id="memberPassword" class="input form-control" required/></td>
			</tr>
			<tr>
				<th><label for="memberPasswordChk">비밀번호 확인 <span class="red">*</span></label></th>
				<td><input type="password" id="memberPasswordChk" class="form-control" required /></td>
			</tr>
			<tr>
				<th><label for="memberName">이름 <span class="red">*</span></label></th>
				<td><input type="text" name="memberName" id="memberName" class="form-control" required autocomplete="off" /></td>
			</tr>
			<tr>
				<th><label for="memberEmail">이메일</label></th>
				<td><input type="email" name="memberEmail" id="memberEmail" class="form-control" autocomplete="off"/></td>
			</tr>
			<tr>
				<th><label for="memberPhone">전화번호 <span class="red">*</span></label></th>
				<td><input type="text" name="memberPhone" id="memberPhone" class="form-control" required autocomplete="off"/></td>
			</tr>
			<tr>
				<th><label for="memberBirthday">생일</label></th>
				<td><input type="date" name="memberBirthday" id="memberBirthday" class="form-control"/></td>
			</tr>
			<tr>
				<th><label for="memberGender">성별</label></th>
				<td>
					<select name="memberGender" id="memberGender" class="form-control">
						<option value="M" selected>남자</option>
						<option value="F">여자</option>
					</select>
				</td>
			</tr>
			<tr>
				<th><label for="sample4_postcode">주소<span class="red">*</span></label></th>
				<td>
					<input type="text" name="sample4_postcode" class="form-control inline width150 verticalTop" id="sample4_postcode" placeholder="우편번호" required> 
	                <input type="button" class="btn btn-light width150" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
	                <input type="text" class="form-control" name="sample4_roadAddress" id="sample4_roadAddress" placeholder="도로명 주소" required> 
	                <input type="text" class="form-control" name="sample4_jibunAddress" id="sample4_jibunAddress" placeholder="지번 주소">
	                <input type="text" class="form-control" name="sample4_detailAddress" id="sample4_detailAddress" placeholder="상세 주소" required>
	                <span id="guide" style="color: #999"></span>
                </td>
			</tr>
			</table>	
			<hr />
			
			<div class="textAlignCenter">
				<input type="submit" value="가입" class="btn btn-outline-primary"/> &nbsp;
				<input type="reset" value="취소" onclick="location.href='${pageContext.request.contextPath}'" class="btn btn-outline-primary"/>
			</div>
		<br><br> 
		</form>
	</div>
	
<script>
$(function(){
	// 아이디 중복 검사
	$("#memberId").on("keyup",function(){
		var memberId = $(this).val().trim();
	    if(memberId.length < 4){
	    	$(".guide").hide();
	        $("#idDuplicateCheck").val(0);
	        return;
	    }
	      
	    $.ajax({
			url : "${pageContext.request.contextPath}/member/checkIdDuplicate.do",
	        data : {memberId:memberId},
	       	dataType : "json",
	        success : function(data){
	        	console.log(data);

	        	if(data.isUsable==true){
	               $(".guide.red").hide();
	               $(".guide.green").show();
	               $("#idDuplicateCheck").val(1);
	            } else{
	               $(".guide.red").show();
	               $(".guide.green").hide();
	               $("#idDuplicateCheck").val(0);
	            }
	         },
	         error : function(jqxhr,textStatus,errorThrown){
	            console.log("ajax실패");
	            console.log(jqxhr);
	            console.log(textStatus);
	            console.log(errorThrown);
	         }
	    });
	});
	
	// 비밀번호 일치 확인
	$("#memberPasswordChk").blur(function(){
		var p1 = $("#memberPassword").val();
	    var p2 = $(this).val();
	    
	    if(p1!=p2){
	    	alert("비밀번호가 일치하지 않습니다.");
	        $("#memberPassword").focus();         
	   	}
	});
});

//유효성 검사
function validate() {
	// 아이디 중복 검사
	var idDuplicateCheck = $("#idDuplicateCheck").val();
	if(idDuplicateCheck == 1)
		return true;
	else {
		alert("사용하실 수 없는 아이디입니다.");
		return false;
	} 
	
}

//우편번호 찾기 api
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete : function(data) {
	        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	        // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
	        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	        var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
	        var extraRoadAddr = ''; // 도로명 조합형 주소 변수
	
	        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	        if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
	        	extraRoadAddr += data.bname;
	        }
	        // 건물명이 있고, 공동주택일 경우 추가한다.
	        if (data.buildingName !== '' && data.apartment === 'Y') {
	        	extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	        }
	        // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	        if (extraRoadAddr !== '') {
	        	extraRoadAddr = ' (' + extraRoadAddr + ')';
	        }
	        // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
	        if (fullRoadAddr !== '') {
	        	fullRoadAddr += extraRoadAddr;
	        }
	
	        // 우편번호와 주소 정보를 해당 필드에 넣는다.
	        document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
	        document.getElementById('sample4_roadAddress').value = fullRoadAddr;
	        document.getElementById('sample4_jibunAddress').value = data.jibunAddress;
	
	        // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
	        if (data.autoRoadAddress) {
	        	//예상되는 도로명 주소에 조합형 주소를 추가한다.
	            var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
	            document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
			} else if (data.autoJibunAddress) {
	        	var expJibunAddr = data.autoJibunAddress;
	            document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
			} else {
	        	document.getElementById('guide').innerHTML = '';
	        }
        }
    }).open();
}

</script>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>