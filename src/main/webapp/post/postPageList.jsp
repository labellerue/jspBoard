<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- header --%>
<%@ include file="/common/header.jsp"%>
<%-- left --%>
<%@ include file="/common/left.jsp"%>

<script type="text/javascript">
	$(document).ready(function(){
		
		$(".post_id").hide();
		
		//tr에 select (class="postClick")
		$(".postClick").on("click", function(){
			
			var post_id = $(this).children()[0].textContent.split(' ')[0];

			$("#post_id").val(post_id);
			$("#form").submit();
		});
		
	});
</script>

<!-- hidden으로 form을 넣는 것은 실무에서도 사용합니다! -->
<form action="/detailPost" method="get" id="form">
	<input type="hidden" id="post_id" name="post_id"/>
</form>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">${boardVo.board_subject }</h2>
						<div class="table-responsive">
						
						<a class="btn btn-default pull-right" href="/post/insertPost.jsp?userId=${userVo.userId }">글쓰기</a>
							<table class="table table-striped table-hover">
								<tr>
									<th>no.</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일자</th>
								</tr>

								<c:forEach items="${postPageList }" var="post">
									<tr class="postClick">
										<td><label class="post_id">${post.post_id }</label> ${post.rnum }</td>
										<td>${post.post_title }</td>
										<td>${post.post_userid }</td>
										<td><fmt:formatDate value="${post.post_date }" pattern="yyyy/MM/dd" /></td>
									</tr>
								</c:forEach>
							</table>

						</div>
						
						<div class="text-center">
							<ul class="pagination">
								<li>
									<a href="/postPageList?page=1&pageSize=10" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>
								<li>
									<a href="/postPageList?page=1&pageSize=10" aria-label="Previous">
										<span aria-hidden="true">&lsaquo;</span>
									</a>
								</li>
								<c:forEach begin="1" end="${postPageCnt}" var="pageNum">
								<li>
									<a href="/postPageList?page=${pageNum }&pageSize=10&board_id=${board_id}">${pageNum }</a>
								</li>
								</c:forEach>
								<li>
									<a href="/postPageList?page=${postPageCnt}&pageSize=10" aria-label="Next"> 
										<span aria-hidden="true">&rsaquo;</span>
									</a>
								</li>
								<li>
									<a href="/postPageList?page=${postPageCnt }&pageSize=10" aria-label="Next"> 
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>



















