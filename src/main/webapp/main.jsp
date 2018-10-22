<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/header.jsp"%>

<%@ include file="/common/left.jsp"%>
	<div class="container-fluid">
		<div class="row">


			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="blog-header">
					<h1 class="blog-title">Belle Board</h1>
					<p class="lead blog-description">자유 커뮤니티입니다.</p>
				</div>

				<div class="row">

					<div class="col-sm-8 blog-main">
						<div class="blog-post">
							<p class="blog-post-meta">
								<script type="text/javascript">
									var date = new Date();
									document.write(date.getFullYear() + "."
											+ (date.getMonth() + 1) + "."
											+ date.getDate());
								</script>
								, room 203
							</p>
							<hr>

							<h3>Why Giraffes are beautiful : </h3>
							<p class="font-italic">share your ideas</p>
							<ul>
								<li>servlet 동작원리</li>
								<li>jsp와 servlet의 관계</li>
								<li>jsp 스크립틀릿 요소</li>
								<li>jsp action tag (standard)</li>
								<li>jstl</li>
								<li>db pooling</li>
								<li>페이지 모듈화</li>
							</ul>
						</div>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
