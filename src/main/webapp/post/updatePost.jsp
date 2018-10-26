<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- header --%>
<%@ include file="/common/header.jsp"%>
<%-- left --%>
<%@ include file="/common/left.jsp"%>

<!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico" />
<script src="/SE2/js/HuskyEZCreator.js"></script> <!-- 이 라이브러리 필~요! -->

<script type="text/javascript">
var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});

	// 전송버튼 클릭이벤트
	$("#savebutton").click(function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$("#frm").submit();
			}
		}
		
	});
	
	var i = 1 + document.getElementById("filesListDiv").childElementCount;
	//파일 추가하기 이벤트
	$("#moreFiles").click(function(){
		
		if(i < 6){
			$("#fileTagUl").append("<li><input type='file' name='files' /></li>");
			i++;
		}else{
			alert("파일첨부는 최대 5개 까지 가능합니다.");
		}
		
	});
});

// 필수값 Check
function validation(){
	var contents = $.trim(oEditors[0].getContents());
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}
	return true;
}

</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
				<div class="col-sm-8 blog-main">
				<h2 class="sub-header">글 수정하기</h2>
				<br/>
				
				<form action="/updatePost" method="post" id="frm" enctype="multipart/form-data" >
				<input type="text" id="post_id" name="post_id" value="${postVo.post_id }"/>
				<div>
					<label class="conlabel">제목 </label><input type="text" class="form-control title" name="post_title" value="${postVo.post_title }"/>
				</div>
				<!-- 작성 SmartEditor -->
				<div>
					<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" >${postVo.post_article }</textarea> 
				</div>
				<div>
					<div class="pull-left">
						<label class="conlabel filelabel">첨부파일 </label>
					</div>
					<!-- 저장된 첨부파일 출력 -->
					<div class="pull-left" id="filesListDiv">
						<c:forEach items="${filesList }" var="file"> 
							<ul class="fileDiv">
								<li><img src="${file.file_path }" width="200" class="fileA"/></li>
								<li><a href="${file.file_path }" class="fileA">${file.file_path }</a></li>
							</ul>
						</c:forEach>
					</div>
					<!-- 첨부파일 추가 -->
					<div class="pull-left fileDiv" >
					<ul id="fileTagUl">
						<!-- 스크립트로 추가될 파일 input -->
					</ul>
						<a href="#" id="moreFiles" class="btn btn-default pull-right">╋</a>
					</div>
				</div>
				<div class="btnBlock col-sm-8">
					<a href="/postPageList?page=1&pageSize=10&board_id=${postVo.board_id }" class="btn btn-default pull-right" id="cancelbutton" >취소</a>
					<input type="button" class="btn btn-default pull-right" id="savebutton" value="저장" />
				</div>
				</form>

				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>










