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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<title>Document</title>
<style>
</style>
</head>
<body>
	<!--navbar-->
	<nav class="navbar navbar-expand-lg bg-dark ">
		<div class="container-fluid">
			<a class="navbar-brand text-white" href="ql_bocauhoi"><svg
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

	<div class="container-fluid py-3" id="wrapper">
		<div class="row">
			<div class="col-3 justify-content-between" id="sidebar-wrapper">
				<div class="spae">
					<span class="form-control text-center bg-body-secondary">${tenBCH}
					</span>
					<div class="list-group">
						<c:forEach items="${ListQuestions}" var="ques">


							<a
								class="list-group-item list-group-item-action   second-text text-truncate"
								data-toggle="tab" href="#tab-pane-${ques.getId()}"><i
								class=" text-truncate" data-toggle="tab"></i>Câu ${ques.getId()}
								:${ques.getCauhoi() }</a>
						</c:forEach>

						<a href="#tab-pane-themcauhoi"
							class="list-group-item list-group-item-action" data-toggle="tab">Thêm
							câu hỏi</a>
					</div>

				</div>

				<!-- <div class="themcauhoi form-control" style="margin-top: 50px;">
					<input type="file" value="">
				</div> -->

			</div>
			<div class="col-9  text-center ">
				<div class="tab-content">

					<c:forEach items="${ListQuestions}" var="ques">
						<div class="tab-pane" id="tab-pane-${ques.getId()}">
							<!--quest-->
							<div class="form-control text-center bg-body-tertiary shadow ">
								<div class="d-flex justify-content-between py-2 ">
									<div class></div>
									<div class=" form-control shadow "
										style="width: 600px; height: 300px;">
										<div class>
											<div class="card-body justify-content-between" id="img">
												<p></p>
												<img src="img/${ques.getImg_ques()}" style="width: 15rem;"
													class="" alt="...">
												<p></p>
											</div>
										</div>
									</div>
									<div></div>
								</div>
								<!--cau hoi-->
								<div class="form-control text-start shadow"
									style="height: 100px;">
									<span>Câu ${ques.getId()}: ${ques.getCauhoi()}</span>

								</div>
								<!--dap an start-->
								<div class="container text-center ">
									<div class="row py-4 text-start">
										<div class="col-7 col-sm-4 form-control shadow"
											style="width: 500px;">
											<div class="dapan">A. ${ques.getQuesA() }</div>
											<div class="dung">

												<c:if test="${bchDAO.cv(ques.getStatus().trim())==1}">
													<input type="radio" name id="1" value="1" checked="checked">
												</c:if>
												<c:if test="${bchDAO.cv(ques.getStatus().trim())!=1}">
													<input type="radio" name id="1" value="1">
												</c:if>
											</div>

										</div>
										<div class="col-7 col-sm-4 form-control shadow"
											style="width: 500px; margin-left: 200px;">
											<div class="dapan">B. ${ques.getQuesB()}</div>
											<div class="dung">
												<c:if test="${bchDAO.cv(ques.getStatus().trim())==2}">
													<input type="radio" name id="2" value="2" checked="checked">
												</c:if>
												<c:if test="${bchDAO.cv(ques.getStatus().trim())!=2}">
													<input type="radio" name id="2" value="2">
												</c:if>
											</div>

										</div>

										<!-- Force next columns to break to new line at md breakpoint and up -->
										<div class="w-100 d-none d-md-block p-3 px-2"></div>

										<div class="col-7 col-sm-4 form-control shadow"
											style="width: 500px;">
											<div class="dapan">C. ${ques.getQuesC()}</div>
											<div class="dung">
												<c:if test="${bchDAO.cv(ques.getStatus().trim())==3}">
													<input type="radio" name="" id="3" value="3"
														checked="checked">
												</c:if>
												<c:if test="${bchDAO.cv(ques.getStatus().trim())!=3}">
													<input type="radio" name id="3" value="3">
												</c:if>
											</div>

										</div>
										<div class="col-7 col-sm-4 form-control shadow"
											style="width: 500px; margin-left: 200px;">
											<div class="dapan">
												<p>D. ${ques.getQuesD()}</p>
											</div>
											<div class="dung">
												<c:if test="${bchDAO.cv(ques.getStatus().trim())==4}">
													<input type="radio" name id="4" value="4" checked="checked">
												</c:if>
												<c:if test="${bchDAO.cv(ques.getStatus().trim())!=4}">
													<input type="radio" name id="4" value="4">
												</c:if>
											</div>

										</div>
									</div>
								</div>

								<form action="crud" method="post">
									<div class="container-fluid py-5" style="margin-top: 50px;">
										<input type="hidden" name="tenBCH" value="${tenBCH}">
										<input type="hidden" name="idBCH" value="${idBCH}"> <input
											type="hidden" name="action" value="xoaCH"> <input
											type="hidden" value="${ques.getId()}" name="idQuestion">
										<div class="d-flex align-bottom justify-content-between">
											<p></p>

											<button type="submit" class="btn btn-secondary">DELETE</button>
											<!-- <button type class="btn btn-secondary">CREATE</button> -->
											<p></p>

										</div>
										<!--dap an end-->
									</div>
								</form>


							</div>
							<!--quest-->
						</div>
					</c:forEach>

					<div class="tab-pane fade" id="tab-pane-themcauhoi">
						<div class="">
							<!--quest-->
							<div class="form-control text-center bg-body-tertiary shadow ">
								<form action="crud" method="post" enctype="multipart/form-data">
									<div class="d-flex justify-content-between py-2 ">
										<div class></div>
										<div class="  form-control shadow"
											style="width: 600px; height: 300px;">
											<div class>
												<div class="card-body " id="img">
													<input type="file" placeholder="" name="file">
												</div>
											</div>
										</div>
										<div></div>
									</div>
									<!--cau hoi-->

									<input type="hidden" name="tenBCH" value="${tenBCH}"> <input
										type="hidden" name="idBCH" value="${idBCH}"> <input
										type="hidden" name="action" value="themCH">
									<div class=" text-start" style="height: 100px;">
										<textarea class="form-control" name="cauhoi" id=""
											placeholder="Thêm câu hỏi bất kì"></textarea>
									</div>
									<!--dap an start-->
									<div class="container text-center">
										<div class="row py-4 text-start">
											<div class="col-7 col-sm-4 " style="width: 500px;">
												<div class="dapan">A.</div>
												<textarea class="form-control" name="dapanA" id=""
													placeholder="Thêm một đáp án bất kì"></textarea>

												<div class="dung">
													<input type="radio" name="status" id="1" value="A">
												</div>

											</div>
											<div class="col-7 col-sm-4 "
												style="width: 500px; margin-left: 200px;">
												<div class="dapan">B.</div>
												<textarea class="form-control" name="dapanB" id=""
													placeholder="Thêm một đáp án bất kì"></textarea>

												<div class="dung">
													<input type="radio" name="status" id="2" value="B">
												</div>

											</div>

											<!-- Force next columns to break to new line at md breakpoint and up -->
											<div class="w-100 d-none d-md-block p-3 px-2"></div>

											<div class="col-7 col-sm-4 " style="width: 500px;">
												<div class="dapan">C.</div>
												<textarea class="form-control" name="dapanC" id=""
													placeholder="Thêm một đáp án bất kì"></textarea>

												<div class="dung">
													<input type="radio" name="status" id="3" value="C">
												</div>

											</div>
											<div class="col-7 col-sm-4 "
												style="width: 500px; margin-left: 200px;">
												<div class="dapan">D.</div>
												<textarea class="form-control" name="dapanD" id=""
													placeholder="Thêm một đáp án bất kì"></textarea>

												<div class="dung">
													<input type="radio" name="status" id="4" value="D">
												</div>

											</div>
										</div>
									</div>
									<div class="container-fluid py-5" style="margin-top: 50px;">
										<div class="d-flex align-bottom justify-content-between">
											<p></p>
											<button type="submit" class="btn btn-secondary">CREATE</button>
											<p></p>

										</div>
										<!--dap an end-->
									</div>
								</form>


							</div>
							<!--quest-->

						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		var el = document.getElementById("wrapper");
		var toggleButton = document.getElementById("menu-toggle");

		toggleButton.onclick = function() {
			el.classList.toggle("toggled");
		};
	</script>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>