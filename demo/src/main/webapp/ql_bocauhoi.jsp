<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Document</title>
</head>
<body>
	<!--navbar-->
	<nav class="navbar navbar-expand-lg bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand text-white" href="quiz_detail.html"><svg
					xmlns="http://www.w3.org/2000/svg" width="40" height="40"
					fill="currentColor" class="bi bi-caret-left-fill"
					viewBox="0 0 16 16">
                        <path
						d="m3.86 8.753 5.482 4.796c.646.566 1.658.106 1.658-.753V3.204a1 1 0 0 0-1.659-.753l-5.48 4.796a1 1 0 0 0 0 1.506z" />
                    </svg></a>
			<div class="d-flex justify-content-center ">
				<h5 class="text-white text-center ">QUẢN LÝ CÂU HỎI</h5>
			</div>

			<div class="sd"></div>
		</div>
	</nav>
	<!--body-->

	<div class="container px-5">
		<div class="container  py-5 ">
			<div class="bg-body-secondary">
				<span class="px-2">Bộ câu hỏi</span>
			</div>


		</div>
		<div class="container text-center">
			<div class="row">

				<c:forEach items="${ListBoCauHoi}" var="bocauhoi">

					<div class=" col-lg-2 col-md-6 col-sm-6 pb-1"
						style="margin-bottom: 50px;">
						<div class="card " style="width: 10rem; height: 10rem;">
							<img
								style="margin-top: 10px; margin-bottom: 10px; width: 90%; height: 90%; margin-left: 10px;"
								src="img/exam.png">
							<div class=" bg-warning">
								<a href="bocauhoi_detail?name=${bocauhoi.getTenBoCauHoi()}"
									class="card-text text-decoration-none text-dark">
									<div class="text">
										<span>ID: ${bocauhoi.getId()}
											${bocauhoi.getTenBoCauHoi()}</span>
									</div>
								</a>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>

	</div>
	<footer
		class="container-md align-content-lg-end d-flex justify-content-between">
		<div class=""></div>
		<div class="a">
			<form action="crud" method="post">
				<input name="action" value="xoaBCH" type="hidden"> <input
					class="" style="width: 40%;" type="text"
					placeholder="nhap ID muon xia" name="idBCH">
				<button class="btn btn-primary" type="submit">Delete</button>
			</form>

		</div>
		<div class="a">
			</button>
		</div>
		<div class="a">
			<form action="crud" method="post">
				<input name="action" value="themBCH" type="hidden"> <input
					class="" style="width: 40%;" type="text"
					placeholder="Tên bộ câu hỏi" name="tenBCH">
				<button class="btn btn-primary" type="submit">CREATE</button>
			</form>

		</div>
		<div class="a"></div>
	</footer>

	<script data-cfasync="false"
		src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>