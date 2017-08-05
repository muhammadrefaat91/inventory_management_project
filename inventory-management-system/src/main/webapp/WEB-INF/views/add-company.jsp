<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Inventory Management</title>

<!-- Bootstrap Core CSS -->
<link href="../static/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="../static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">



<!-- Morris Charts CSS -->
<link href="../static/vendor/morrisjs/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../static/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom CSS -->
<link href="../static/css/custom.css" rel="stylesheet"></link>
<link href="../static/css/sb-admin-2.css" rel="stylesheet">

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">

			<jsp:include page="header/nav_top.jsp" />

			<jsp:include page="header/side_bar.jsp" />

		</nav>

		<div id="page-wrapper">
			<div class="row first_row">
				<div class="col-lg-12">
					<h2>Add New Company</h2>
					</div>
			</div>
			
			<div class="row second_row">
				<div class="col-lg-12">
				<c:if  test="${requestScope.success ne null}">
				<div class="alert alert-success success">
				  <strong>Success!</strong> ${requestScope.success}.
				</div>
				</c:if>
			<form:form method="POST" commandName="company" class="form-horizontal" enctype="multipart/form-data">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="firstName">Company Name</label>
						<div class="col-md-7">
							<form:input type="text" path="name" placeholder="choose your first name" id="name" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="name" cssClass="error" class="help-inline"/>
								<div class="has-error">${requestScope.name}</div>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="email">Email</label>
						<div class="col-md-7">
							<form:input type="email" path="email" id="email" placeholder="provide a email for company" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="email" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="address">Address</label>
						<div class="col-md-7">
							<form:input type="text" path="address" id="address" placeholder="provide an address for company" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="address" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="phoneNumber">Phone Number</label>
						<div class="col-md-7">
							<form:input type="text" placeholder="provide a phone number" path="phoneNumber" id="phoneNumber" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="phoneNumber" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="registration">Registration Number</label>
						<div class="col-md-7">
							<form:input type="text" placeholder="provide a Registration number" path="registrationNumber"    class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="registrationNumber" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="faxNumber">Fax Number</label>
						<div class="col-md-7">
							<form:input type="text" placeholder="provide a Fax number" path="faxNumber"    class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="faxNumber" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable" for="logo">Upload a Logo</label>
                            <div class="col-md-7">
                                <input type="file" name="file" id="file" class="form-control input-sm"/>
                                <div class="has-error">
                                    <form:errors path="logo" class="help-inline"/>
                                </div>
                            </div>
                        </div>
                    </div>
				
				<div class="row">
					<div class="form-actions floatRight">
						<input type="submit" value="Save" class="submit-button-customer btn btn-primary btn-sm">
					</div>
				</div>
				
			</form:form>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="../static/vendor/jquery/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="../static/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!-- Metis Menu Plugin JavaScript -->
	<script src="../static/vendor/metisMenu/metisMenu.min.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="../static/js/sb-admin-2.js"></script>
</body>

</html>
