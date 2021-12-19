<%@page import="bean.giohangbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.thanhtoanbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="assets/css/toast.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="assets/js/main.js"></script>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="row">
		<div class="col-sm-3">
			</table>
		</div>
		<div class="col-sm-6">
			<p>Hoá đơn đã thanh toán</p>
			<hr>
			<%
				
				for(thanhtoanbean b:(ArrayList<thanhtoanbean>)request.getAttribute("lichsu")){
					%>
					<h4>Hóa đơn: <%=b.getMahoadon() %></h4>
					<h4>Ngày đặt mua <%=b.getDatetime() %></h4>
					<% for(giohangbean gh:b.getGh()) {%>
					<div class="row itemCart">
						<div class="col-sm-1">
							<img alt="" src="assets/<%=gh.getAnhSach()%>" style="width: 52px;height: 56px;" class="img">
						</div>
						<div class="col-sm-4">
							<div class="info">
								<p style="padding: 0; margin: 0;"><%=gh.getTensach() %></p>
								<p style="padding: 0; margin: 0;"><%=gh.getSlmua() %></p>
								<p style="padding: 0; margin: 0;"><%=gh.getGia() %></p>
								
							</div>
						</div>
					</div>
					<%} %>
					<hr>
				<% }%>
				
		</div>
	</div>
</body>
</html>