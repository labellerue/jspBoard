<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- header --%>
<%@ include file="/common/header.jsp"%>
<%-- left --%>
<%@ include file="/common/left.jsp"%>
 
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
				<div class="col-sm-8 blog-main">
				<h2 class="sub-header"> </h2>
				<br/>
				<div class="thinDiv">
				<a class="btn btn-default pull-right" href="/insertPost?
					post_id=${detailPost.post_id}&post_groupid=${detailPost.post_groupid}"> 
				답글</a>
				</div>
				<div class="thinDiv">
					<label class="conlabel">제목 </label><label class="form-control title detailTitle" id="" >${detailPost.post_title }</label>
				</div>
				<div class="thinDiv">
					<label class="conlabel">작성자 </label><label class="form-control title detailTitle" id="" >${detailPost.post_userid }</label>
				</div>
				<!-- 작성 SmartEditor -->
				<div id="article">
					<p>
						${detailPost.post_article }
					</p>
				</div>
				<div class="fileBox">
					<div class="pull-left">
						<label class="conlabel filelabel">첨부파일 </label>
					</div>
					<div class="pull-left">
						<c:forEach items="${filesList }" var="file"> 
							<div class="fileDiv">
							<img src="${file.file_path }" width="200" class="fileA"/>
							<a href="${file.file_path }" class="fileA">${file.file_path }</a>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="btnBlock col-sm-8 thinDiv">
					<c:if test="${userVo.userId == detailPost.post_userid }">
					<form method="post" action="/deletePost" id="form">
						<button id="deletePost" class="btn btn-default pull-right" >삭제</button>
						<input type="hidden" name="post_id" value="${detailPost.post_id }"/>
						<input type="hidden" name="board_id" value="${detailPost.board_id }"/>
					</form>
					<a href="/updatePost?post_id=${detailPost.post_id }" class="btn btn-default pull-right" >수정</a>
					</c:if>
				</div>
				<div class="commDiv">
				<hr/>
					<label class="conlabel">댓글 </label>
					<c:forEach items="${commList }" var="comm">
						<div class="commDiv">
						<c:choose>
							<c:when test="${comm.comm_del == 0 }"> 
								<label class="commL">${comm.comm_note }</label>
								<label class="commL2">${comm.comm_userid }</label>
								<label class="commL3"><fmt:formatDate value="${comm.comm_date }" pattern="yyyy/MM/dd" /></label>
							</c:when>
							<c:otherwise>
								<label class="deleted">삭제된 댓글입니다.</label>
							</c:otherwise>
						</c:choose>
						<!-- 댓글 삭제 -->
						<c:if test="${userVo.userId == comm.comm_userid }">
						<form action="/deleteComm" method="post" class="pull-right" >
							<input type="submit" class="btn btn-default pull-right noTopMarg" value="삭제" />
							<input type="hidden" name="comm_id" value="${comm.comm_id }"/>
							<input type="hidden" name="post_id" value="${comm.post_id }"/>
						</form>
						</c:if>
						</div>
					</c:forEach>
				</div>
				<!-- 댓글 등록 -->
				<form action="/insertComm" method="post" >
				<div class="commDiv commInDiv thinDiv ">
					<input type="hidden" name="post_id" value="${detailPost.post_id }" />
					<input type="hidden" name="comm_userid" value="${userVo.userId }" />
					<input type="text" name="comm_note" id="comm_note" class="form-control commIn" maxlength="500" />
					<input type="submit" class="btn btn-default pull-right noTopMarg" id="commbutton" value="댓글등록" />
				</div>
				</form>

				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>









