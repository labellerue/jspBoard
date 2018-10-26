<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Belle Board</title>

<%--javascript and css stylesheet --%>
<%@include file="/common/basicLib.jsp"%>
<style>
.deleted{
	color: #B3B3B3;
	font-style: oblique;
}
.thinDiv{
	width: 100%;
	height: 50px;
}
.btnBlock {
	width: 786px;
 }
 .btn {
 	margin: 5px;	
 }
 .title {
  width: 700px;
  display: inline-block;
  position: relative;
  margin: 0;
  border-radius: 0;
  margin-top: 20px;
 }
 .conlabel {
 	margin-right: 10px;
 	color: #828282;
 	width: 50px;
 }
 .fileBox{
 	margin-top: 10px;
 }
 .filelabel{
 	width: 70px;
 }
 #article {
 	width:766px; 
 	height:412px;
 	border: 1px solid #ccc;
 	display: block;
 	margin-top: 20px;
 }
 .commDiv {
 	display: block;
 	width: 100%;
 	float: left;
 }
 .commL{
 	margin: 4px;
 	width: 60%;
 }
 .commL2{
 	margin: 4px;
 	width: 10%;
 }
 .commL3{
 	margin: 4px;
 	width: 15%;
 }
 .commIn{
 	width: 85%;
 	display: inline-block;
 }
.commInDiv{
 	margin-top: 20px;
 	margin-bottom: 20px;
 }
 .noTopMarg{
 	margin-top: 0;
 }
 .detailTitle{
 	border: 0;
 }
 .fileDiv{
 	margin: 0;
 	padding: 0;
 	width: 200px;
 	float: left;
 }
 .fileDiv li{
 	list-style: none;
 }
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
 	width: 700px; 
 	height:412px;
 }
 #fileTagUl li{
 	list-style: none;
 }
</style>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/main.jsp">Belle Board</a>
			<a class="navbar-brand" href="#">
				<c:if test="${userVo.name != null}">
				 ${userVo.name }님 안녕하세요.
				 </c:if>
			</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Help</a></li>
				<li><a href="/logout">Logout</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>