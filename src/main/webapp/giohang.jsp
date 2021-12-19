<%@page import="java.io.Console"%>
<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
<%@page import="bo.loaibo"%>
<%@page import="bean.loaibean"%>
<%@page import="bo.sachbo"%>
<%@page import="bean.sachbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.khachHangbean"%>
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
	long sl = 0;
	giohangbo gh = new giohangbo();
	gh = (giohangbo)request.getAttribute("gh");
	if(gh!=null){
		 sl = gh.soluong();
	}
	if(sl == 0){
	response.sendRedirect("HTsach");
	
	return;

}
%>
<%

sachbo sb = new sachbo();
loaibo lb = new loaibo();
%>
<body>
	<%@include file="navbar.jsp" %>
	<div class="row">
		<div class="col-sm-3">
			<table class="table table-hover">
				<%
				for (loaibean loai : (ArrayList<loaibean>)request.getAttribute("loaisach")) {
				%>
				<tr>
					<td>
						<p>
							<a id="menu" href="HTsach?ml=<%=loai.getMaLoai()%>"> <i
								class="fas fa-book"> <%=loai.getTenLoai()%></i>
							</a>
						</p>
					</td>

				</tr>
				<%
				}
				%>
			</table>
		</div>
		<div class="col-sm-6">
			<p>Giỏ hàng của bạn</p>
			<hr>
			<div class="row">
				<div class="form-check">
					<input type="checkbox" name="checkAll" onclick="checkall();" id="checkAll" class="form-check-input ">
					<label class="form-check-label" for="checkAll">Chọn tất cả</label>
				</div>
			</div>
			<%
			
			
			if(request.getAttribute("gh")!=null){
				
				for(giohangbean b:gh.getDS()){
					%>
					<div class="row itemCart">
						<div class="col-sm-1">
							<input type="checkbox" id="<%=b.getMasach()%>" class="form-check-input item-checkbox">
						</div>
						<div class="col-sm-1">
							<img alt="" src="assets/<%=b.getAnhSach()%>" style="width: 52px;height: 56px;" class="img">
						</div>
						<div class="col-sm-4">
							<div class="info">
								<p class="name"><%=b.getTensach() %></p>
								Số lượng: <input type="number" class="quantity_num" min="0" id="quantity_<%=b.getMasach()%>" value="<%=b.getSlmua()%>" style="width: 40px;">
								<p class="money"><%=b.getGia() %></p>
								
							</div>
						</div>
						<div class="col-sm-3">
							<button class="btn btn-danger" onclick="del('<%=b.getMasach()%>')">Delete</button>
						</div>
					</div>
				<% }
			}%>
			<% if(gh.soluong()==0) out.print("Giỏ hàng đang trống </br>");
				else out.print("<hr>"); %>
			<p class="tongcong">Hóa đơn tổng cộng là: <%=gh.TongTien() %></p>
			<button class="btn btn-danger" onclick="deleteSelect();">Xóa</button>
			<button class="btn btn-success" onclick="xacnhan();">Xác nhận thanh toán</button>
		</div>
	</div>
	<script src="assets/js/toast.min.js"></script>
	<script type="text/javascript">
	function checkall(){
		var check = document.getElementById('checkAll');
		var value = false;
		if(check.checked) value = true;
		var inputs = document.querySelectorAll('.item-checkbox');
		for(var i=0; i < inputs.length; i++){
			inputs[i].checked = value;
		}
	}
	function deleteSelect(){
		var inputs = document.querySelectorAll('.item-checkbox');
		for(var i=0; i < inputs.length; i++){
			if(inputs[i].checked){
				var id = inputs[i].id;
				$.ajax({
					type: 'POST',
					url: 'giohangController',
					data: {
						g: 'deleteItem',
						id: id,
					},
					success:function(response) {
						window.location.replace("http://localhost:8080/minhkhai/giohangController");
			        }
				})
			}
		}
	}
	function del(id){
		$.ajax({
			type: 'POST',
			url: 'giohangController',
			data: {
				g: 'deleteItem',
				id: id,
			},
			success:function(response) {
				window.location.replace("giohangController");
	        }
		})
	}
	</script>
	<script type="text/javascript">
		$(".quantity_num").bind('keyup mouseup', function (event) {
				var sum;
				var inputs = $(".quantity_num");
				var money = $(".money");
				var quantity = document.getElementById(event.target.id);
				var id=event.target.id.split('_');
				
				for(var i=0;i<inputs.length;i++){
					sum+=parseInt(money[0].innerHTML)*inputs[i].value;
				}
				$.ajax({
					type: 'POST',
					url: 'giohangController',
					data: {
						g: 'updateItem',
						id: id[1],
						quantity: quantity.value,
					},
					success:function(response) {
						var string = JSON.stringify(response);
						var obj = jQuery.parseJSON(string);
						$(".tongcong")[0].innerHTML = "Hóa đơn tổng cộng là: " + obj["tongtien"];
			        }
				})
				
		});
		
	</script>
	<script type="text/javascript">
		function xacnhan(){
				$.ajax({
					type: 'GET',
					url: 'thanhtoanController',
					data: {
						xacnhan: '1',
					},
					success:function(response) {
						window.location.replace("thanhtoanController");
			        }
				});
		}
	</script>
</body>
</html>