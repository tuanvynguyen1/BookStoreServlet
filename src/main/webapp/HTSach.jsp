<%@page import="bo.giohangbo"%>
<%@page import="bean.khachHangbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.loaibean"%>
<%@page import="bean.sachbean" %>
<%@page import="bo.sachbo"%>
<%@page import="bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="assets/css/toast.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="assets/js/main.js"></script>
</head>
<% 
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
giohangbo gh = (giohangbo)request.getAttribute("gh");
long sl = 0;
if(gh!=null)
	 sl = gh.soluong();
%>
<body>
<%@include file="navbar.jsp" %>
	
	<div class="container-fluid" style="padding-top: 20px;">
		<div class="row">
			<div class="col col-sm-3">
			<table class="table table-hover">
				<% for(loaibean loai:(ArrayList<loaibean>)request.getAttribute("loaisach")){ %>
					<tr>
						<td>
							<p><a id="menu" href="HTsach?ml=<%=loai.getMaLoai()%>">
							<i class="fas fa-book"> <%=loai.getTenLoai() %></i> </a></p>
						</td>
					
					</tr>
					<%
				}
				
				%>
			</table>
			</div>
			<div class="col col-sm-6">
			<div class="row">
			<%
				ArrayList<sachbean> sach = (ArrayList<sachbean>)request.getAttribute("sach");
				for(sachbean s: sach){
					%>
						<div class="col-sm-4">
							<div class="card" style="border: none;">
								<img src="assets/<%=s.getAnh()==null?"img/noimg.png":s.getAnh()%>" width="227px" height="256px" class="card-img-top">
								<div class="card-body" style="margin-top: 10px;">
									<p style="text-align: center;" onclick=addItemtoCart("<%=s.getMaSach()%>");><a href="#" ><img src="assets/img/buynow.jpg"></a></p>
									<p style="text-align: center;"><a href="#"><%=s.getTenSach() %></a></p>
									<p style="text-align: center;">Giá bán: <%=s.getGia() %> đ</p>
								</div>
							</div>
						</div>
						
					<%
				}
			%>
			</div>
			</div>
			<div class="col col-sm-3">
				<form class="form-inline my-2 my-lg-0" action="HTsach" method="post">
					<div class="col col-sm-9"><input type="text" class="form-control" name="q" placeholder="Nhập thông tin"></div>
					<div class="col col-sm-3"><input type="submit" class="btn btn-success" value="Tìm"></div>
				</form>	
			</div>
		</div>
	</div>
</body>
<style>
	a{
		text-decoration: none;
		color: black;
	}
	#menu{
		font-family: sans-serif;
	}
	#menu:hover {
		text-decoration: none;
	}
</style>
<script src="assets/js/toast.min.js"></script>
</html>