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
<link href="../static/css/bootstrap-datepicker3.min.css" rel="stylesheet">
<style type="text/css">
	.btn-default.btn-on-1.active{
	background-color: #337ab7; 
	    border-color: #2e6da4;
	    color: white;}
.btn-default.btn-off-1.active{
	background-color: #337ab7; 
	border-color: #2e6da4;
	border-width: 1px;
    border-style: solid;color: white;
    }
</style>
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
					<h2>Add New Employee</h2>
					</div>
			</div>
			
			<div class="row second_row">
				<div class="col-lg-12">
				<c:if  test="${requestScope.success ne null}">
				<div class="alert alert-success success">
				  <strong>Success!</strong> ${requestScope.success}.
				</div>
				</c:if>
			<form:form method="POST" commandName="employee" class="form-horizontal">
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
						<label class="col-md-3 control-lable" for="userName">User Name</label>
						<div class="col-md-7">
							<form:input type="text" path="userName" placeholder="choose your User name" id="userName" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="userName" class="help-inline"/>
								<div class="has-error">${requestScope.userName}</div>
							</div>
						</div>
					</div>
		
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="department">Department</label>
						<div class="col-md-7">
							<form:input type="text" path="department" placeholder="choose your Department" id="department" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="department" class="help-inline"/>
							</div>
						</div>
					</div>
		
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="dateOfBirth">Date Of Birth</label>
						<div class="col-md-7">
							<div>
							    <form:input type="date" path="dateOfBirth" class="form-control"/>
							</div>							
							<div class="has-error">
								<form:errors path="dateOfBirth" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="mobileNumber">Mobile Number</label>
						<div class="col-md-7">
							<form:input type="mobile" placeholder="provide your Mobile number" path="mobile" id="mobile" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="mobile" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="gender">Gender</label>
						        <div class="col-md-7">
						    	    <div class="btn-group" id="gender" data-toggle="buttons">
						              <label class="btn btn-default btn-on-1 btn-sm active">
						              <form:radiobutton path="gender"   value="male"    />Male</label>
						              <label class="btn btn-default btn-off-1 btn-sm ">
						              <form:radiobutton path="gender"   value="female"  />Female</label>
						            </div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="password">Password</label>
						<div class="col-md-7">
							<form:password   path="password" id="password" placeholder="provide your Password" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="password" class="help-inline"/>
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
	<!-- Custom Theme JavaScript -->
	<script src="../static/js/sb-admin-2.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="../static/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!-- Metis Menu Plugin JavaScript -->
	<script src="../static/vendor/metisMenu/metisMenu.min.js"></script>
	<script src="../static/js/bootstrap-datepicker.min.js"></script>
 
	
</body>

</html>
