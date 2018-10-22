<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- header --%>
<%@ include file="/common/header.jsp"%>
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
 #article{
 	width:766px; 
 	height:412px;
 	border: 1px solid #ccc;
 }
 #commDiv{
 	border: 1px solid black;
 	display: block;
 	width: 100%;
 }
 </style>
<%-- left --%>
<%@ include file="/common/left.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
				<div class="col-sm-8 blog-main">
				<h2 class="sub-header"> </h2>
				<br/>
				<div>
					<label class="conlabel">제목 </label><label class="form-control title" id="" >${detailPost.post_title }</label>
				</div>
				<!-- 작성 SmartEditor -->
				<div>
					<p id="article">
						${detailPost.post_article }
					</p>
				</div>
				<div>
					<div class="pull-left">
						<label class="conlabel">첨부파일 </label>
					</div>
					<div class="pull-left">
					<!--
						<c:forEach items="${files }" var="file"> 
						<a href="#">${file.file_path }</a>
						</c:forEach>
						-->
					</div>
				</div>
				<div class="btnBlock col-sm-8">
					<input type="button" class="btn btn-default pull-right" id="cancelbutton" value="답글" />
					<input type="button" class="btn btn-default pull-right" id="savebutton" value="삭제" />
					<input type="button" class="btn btn-default pull-right" id="savebutton" value="수정" />
				</div>
				<div id="commDiv">
					<label class="conlabel">댓글 </label>
					<!--
					<c:forEach items="" var="">
						<label>댓글 작성자</label>
						<label>댓글 내용</label>
					</c:forEach>
					-->
				</div>

				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>









