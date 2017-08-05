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

			<jsp:include page="../header/nav_top.jsp" />

			<jsp:include page="../header/side_bar.jsp" />

		</nav>

		<div id="page-wrapper">
			<div class="row first_row">
				<div class="col-lg-12">
					<h1>Add New Customer</h1>
					</div>
			</div>
			
			<div class="row second_row">
				<div class="col-lg-12">
				<c:if  test="${requestScope.success ne null}">
				<div class="alert alert-success success">
				  <strong>Success!</strong> ${requestScope.success}.
				</div>
				</c:if>
			<form:form method="POST" commandName="customer" class="form-horizontal">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="firstName">First Name</label>
						<div class="col-md-7">
							<form:input type="text" path="firstName" placeholder="choose your first name" id="firstName" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="firstName" cssClass="error" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
		
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="lastName">Last Name</label>
						<div class="col-md-7">
							<form:input type="text" path="lastName" placeholder="choose your last name" id="lastName" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="lastName" class="help-inline"/>
							</div>
						</div>
					</div>
		
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="mobileNumber">Mobile Number</label>
						<div class="col-md-7">
							<form:input type="text" placeholder="provide your Mobile number" path="mobile" id="mobile" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="mobile" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="address">Address</label>
						<div class="col-md-7">
							<form:input type="text" path="address" id="address" placeholder="provide your address" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="address" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="maxNumber">Max Number</label>
						<div class="col-md-7">
							<form:input type="number" path="maxNumber" placeholder="provide max number" id="maxNumber" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="maxNumber" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="allowedAmount">Allowed Amount</label>
						<div class="col-md-7">
							<form:input type="number" path="allowedAmount" placeholder="provide allowed Amount for Customer" id="allowedAmount" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="allowedAmount" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="status">Status</label>
						<div class="col-md-7">
							<form:select class="form-control" path="status">
								  <form:option value="true">Enabled</form:option>
								  <form:option value="false">Disabled</form:option>
							</form:select>
							<div class="has-error">
								<form:errors path="status" class="help-inline"/>
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
