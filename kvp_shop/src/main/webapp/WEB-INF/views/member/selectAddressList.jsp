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

<form action="">
	<div>
		<table class="table margin0auto marginTop50 borderBottom width85p">
			<thead class="thead-light">
				<tr>
					<th>번호</th>
					<th>우편번호</th>
					<th>주소</th>
					<th>선택</th>
				</tr>
			</thead>
			<tbody id="addressList">
				<c:if test="${not empty addressList }">
					<c:forEach var="i" items="${addressList }" varStatus="vs">
						<tr>
							<td class="tbl-td">
								${vs.count}
							</td>
							<td class="tbl-td">
								<input type="hidden" id="zipCode" value="${i['zipCode']}"/>
								${i["zipCode"] }
							</td>
							<td class="tbl-td">
								<input type="hidden" id="roadAddress" value="${i['roadAddress']}"/>
								<input type="hidden" id="locAddress" value="${i['locAddress']}"/>
								<input type="hidden" id="detailAddress" value="${i['detailAddress']}"/>
								${i["roadAddress"] } <br />
								${i["locAddress"] } <br />
								${i["detailAddress"] }
							</td>
							<td class="tbl-td">
								<input type="radio" class="addr" name="addr" id="addr${vs.count }" value="${i['addressLevel'] }"/>
							</td>
						</tr>
					</c:forEach>
				</c:if> 
			</tbody>
		</table>
		<div id="popup_btn-hyelin">
			<input class="btn btn-light" id="chooseAddr" type="button" value="선택" onclick="self.close();"/> &nbsp;
			<input class="btn btn-light" type="button" value="닫기" onclick="self.close();"/>
	    </div>	
    </div>
</form>

<script>
$(function() {
	// 첫 번째 주소 체크 해놓기
	$("#addr1").attr('checked', 'checked'); 

	// 선택한 주소 값 폼으로 전달
	$("#chooseAddr").on("click",function(){
        var zipCode = $("[name=addr]:checked").parent().parent().find("#zipCode").val();
        var roadAddress = $("[name=addr]:checked").parent().parent().find("#roadAddress").val();
        var locAddress = $("[name=addr]:checked").parent().parent().find("#locAddress").val();
        var detailAddress = $("[name=addr]:checked").parent().parent().find("#detailAddress").val();
        
        opener.document.getElementById("sample4_postcode").value = zipCode; 
        opener.document.getElementById("sample4_roadAddress").value = roadAddress; 
        opener.document.getElementById("sample4_jibunAddress").value = locAddress;   
        opener.document.getElementById("sample4_detailAddress").value = detailAddress; 
    });
});

</script>