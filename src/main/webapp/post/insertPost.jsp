<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- header --%>
<%@ include file="/common/header.jsp"%>
<%-- left --%>
<%@ include file="/common/left.jsp"%>
<style>
 .btnBlock{
	width: 786px;
 }
 .btn{
 	margin: 5px;	
 }
 .title{
  width: 700px;
  display: inline-block;
  position: relative;
  margin: 0;
  padding: 0;
  border-color: white white #ccc white;
  border-radius: 0;
  margin-bottom: 20px;
 }
 .conlabel {
 	padding-right: 10px;
 }
 .smarteditor{
 	width: 766px; 
 	height:412px;
 }
</style>

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
	})
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
				<h2 class="sub-header">새 글 작성</h2>
				<br/>
				
				<form action="/insertPost" method="post" id="frm" >
				<div>
					<label class="conlabel">제목 </label><input type="text" class="form-control title" name="post_title"/>
				</div>
				<!-- 작성 SmartEditor -->
				<div>
					<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" ></textarea> 
				</div>
				<div>
					<div class="pull-left">
						<label class="conlabel">첨부파일 </label>
					</div>
					<div class="pull-left">
						<c:forEach begin="0" end="4" var="i" step="1"> 
						<input type="file" name="files"/>
						</c:forEach>
					</div>
				</div>
				<div class="btnBlock col-sm-8">
					<a href="/postPageList?page=1&pageSize=10&board_id=${board_id }" class="btn btn-default pull-right" id="cancelbutton" >취소</a>
					<input type="button" class="btn btn-default pull-right" id="savebutton" value="저장" />
				</div>
				<input type="hidden" id="userId" name="userId" value="${userVo.userId }"/>
				<input type="hidden" id="board_id" name="board_id" value="${board_id }"/>
				</form>

				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>










