<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

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
					<h2>Add New Vendor</h2>
					</div>
			</div>
			<div class="row second_row">
				<div class="col-lg-12">
				<c:if  test="${requestScope.success ne null}">
				<div class="alert alert-success success">
				  <strong>Success!</strong> ${requestScope.success}.
				</div>
				</c:if>
			<form:form method="POST" commandName="vendor" class="form-horizontal" enctype="multipart/form-data">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="name">Name</label>
						<div class="col-md-7">
							<form:input type="text" path="name" id="name" placeholder="provide Vendor Name" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="name" class="help-inline"/>
								<div class="has-error">${requestScope.name}</div>
							</div>
						</div>
					</div>
				</div>
				 <div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="companyId">Company Name</label>
						<div class="col-md-7">
							<form:select  class="form-control" path="companyId" >
							 	<form:option value="${null}" label="Please Select Company"/>
								<form:options itemValue="id" itemLabel="name"  items="${companiesList}"/>
							</form:select>
							<div class="has-error">${requestScope.company}</div>
						</div>
					</div>
				</div>

				 <div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="country">Select Country </label>
						<div class="col-md-7">
							<form:select onchange="print_state('state',this.selectedIndex);" class="form-control" path="country">
							</form:select>
							<div class="has-error">
								<form:errors path="country" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="city">Select City </label>
						<div class="col-md-7">
							<form:select class="form-control"  id ="state" path="city">
							</form:select>
							<div class="has-error">
								<form:errors path="city" class="help-inline"/>
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
						<label class="col-md-3 control-lable" for="mobile">Mobile Number</label>
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
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="notes">Notes</label>
						<div class="col-md-7">
							<form:textarea type="text" path="notes" rows="5" id="notes" placeholder="provide your address" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="notes" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
                
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="status">Status</label>
						        <div class="col-md-7">
						    	    <div class="btn-group" id="status" data-toggle="buttons">
						              <label class="btn btn-default btn-on-1 btn-sm active">
						              <form:radiobutton path="status"   value="true"    />Enabled</label>
						              <label class="btn btn-default btn-off-1 btn-sm ">
						              <form:radiobutton path="status"   value="false"  />Disabled</label>
						            </div>
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
	<script type= "text/javascript" src = "../static/js/countries.js"></script>
	<script language="javascript">print_country("country");</script>	
</body>

</html>
