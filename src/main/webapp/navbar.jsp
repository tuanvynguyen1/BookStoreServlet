<%@page import="bean.khachHangbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">NhaSach</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="HTsach">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="giohangController">Giỏ hàng <span></span></a>
			</li>
			<%if(session.getAttribute("dn")!=null) {%>
			<li class="nav-item"><a class="nav-link" href="thanhtoanController">Thanh toán <span></span></a>
			</li>
			<li class="nav-item"><a class="nav-link" href="lichsuController">Lịch Sử <span></span></a>
			</li>
			<%} %>
		</ul>
		<%if(session.getAttribute("dn")==null) {%>
		<div class="form-inline my-2 my-lg-0">
			<button class="btn btn-link" data-toggle="modal"
				data-target="#registerModal"
				style="text-decoration: none; color: white; padding-right: 20px;">
				<i class="fas fa-user"></i> Sign Up
			</button>
			<button class="btn btn-link" data-toggle="modal"
				data-target="#loginModal"
				style="text-decoration: none; color: white; padding-right: 20px;">
				<i class="fas fa-key"></i> Sign In
			</button>
		</div>
		<%}else{%>
		<div class="form-inline my-2 my-lg-0">
			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        	</a>
	     	<div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="#">Action</a>
	          <a class="dropdown-item" href="#">Another action</a>
	          <div class="dropdown-divider"></div>
	          <a class="dropdown-item" href="#">Something else here</a>
        	</div>
		</div>
		<%}%>
	</div>
</nav>
<div class="modal fade" id="loginModal" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Đăng nhập</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
						<label for="userName">Tên đăng nhập</label> <input type="text"
							name="userName" id="userName" placeholder="Tên đăng nhập" class="form-control">
					</div>
					<div class="form-group">
						<label for="password">Mật khẩu</label> <input type="password"
							name="password" id="password" placeholder="Mật khẩu" class="form-control">
					</div>
					<button class="btn btn-success" onclick="dangnhap();">Đăng nhập</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="registerModal" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Đăng Ký</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
					<div class="form-group has-validation">
						<label for="name">Tên Hiển Thị</label> <input type="text"
							name="name" id="name" placeholder="Tên Hiển Thị" class="form-control" required>
						<div class="invalid-feedback">
						    Không được bỏ trống.
						 </div>
					</div>
					<div class="form-group">
						<label for="userNamer">Tên đăng nhập</label> <input type="text"
							name="userName" id="userNamer" placeholder="Tên đăng nhập" class="form-control" required>
						<div class="invalid-feedback">
						    Không được bỏ trống.
						 </div>
					</div>
					<div class="form-group has-validation">
						<label for="address">Địa chỉ</label> <input type="text"
							name="address" id="address" placeholder="Địa chỉ liên hệ" class="form-control" required>
						<div class="invalid-feedback">
						    Không được bỏ trống.
						 </div>
					</div>
					<div class="form-group has-validation">
						<label for="email">Email</label> <input type="text"
							name="email" id="email" placeholder="Email" class="form-control" required>
						<div class="invalid-feedback">
						    Cú pháp abc@xyz.com, không được bỏ trống.
						 </div>
					</div>
					<div class="form-group has-validation">
						<label for="sdt">Số điện thoại</label> <input type="text"
							name="sdt" id="sdt" placeholder="Số điện thoại" class="form-control" required>
						<div class="invalid-feedback">
						    Không được bỏ trống.
						 </div>
					</div>
					<div class="form-group has-validation">
						<label for="passwordr">Mật khẩu</label> <input type="password"
							name="passwordr" id="passwordr" placeholder="Mật khẩu" class="form-control">
						<div class="invalid-feedback">
						    Không được bỏ trống.
						 </div>
					</div>
					<div class="form-group has-validation">
						<label for="re-password">Nhập lại mật khẩu</label> <input type="password"
							name="re-password" id="re-password" placeholder="Nhập lại mật khẩu" class="form-control">
						<div class="invalid-feedback">
						    Không được bỏ trống.
						 </div>
					</div>
					<button class="btn btn-success" onclick="dangky();">Đăng Ký</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	function dangnhap(){
		var uname = $("#userName").val();
		var password = $("#password").val();
		
		$.ajax({
			type: 'POST',
			url: "authenticationController",
			data: {
				g: 'login',
				uname: uname,
				password: password,
			},
			success:function(response) {
				var string = JSON.stringify(response);
				var obj = jQuery.parseJSON(string);
				if(obj["status"] == "wrong")
				$.toast({
					  title: 'Sai mật khẩu',
					  type: 'error',
					  content: 'Tên nhập hoặc mật khẩu bị sai!!!',
					  delay: 2500
				});
				else{
					$.toast({
						  title: 'Đăng nhập thành công',
						  type: 'success',
						  content: 'Chờ tí là zô!!!',
						  delay: 2500
					});
					setTimeout(() => {
						location.reload();
					}, 1000);
					
				}
	        }
		})	
	}
	function dangky(){
		var uname = $("#userNamer").val();
		var password = $("#passwordr").val();
		alert(password);
		var name = $("#name").val();
		var email = $("#email").val();
		var address= $("#address").val();
		var sdt = $("#sdt").val();
		$.ajax({
			type: 'POST',
			url: "authenticationController",
			data: {
				g: 'register',
				uname: uname,
				password: password,
				name: name,
				email: email,
				address: address,
				sdt: sdt
			},
			success:function(response) {
				var string = JSON.stringify(response);
				var obj = jQuery.parseJSON(string);
				if(obj["status"] == "wrong")
					$.toast({
						  title: 'Somethings went wrong',
						  type: 'error',
						  content: 'Có lỗi hệ thống!!!',
						  delay: 2500
					});
					else{
						$.toast({
							  title: 'Đăng Ký thành công!!!',
							  type: 'success',
							  content: 'Chờ tí là zô!!!',
							  delay: 2500
						});
						setTimeout(() => {
							location.reload();
						}, 1000);
						
					}
				
	        }
		})	
	}
	</script>