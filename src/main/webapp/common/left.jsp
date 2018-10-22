<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/updateBoard">게시판 관리</a></li>
		<c:forEach items="${boardList}" var="board">
		<c:if test="${board.board_avail == 0 }">
			<li class="active"><a href="/postPageList?page=1&pageSize=10&board_id=${board.board_id}" >${board.board_subject}</a></li>
		</c:if>
		</c:forEach>
	</ul>
</div>