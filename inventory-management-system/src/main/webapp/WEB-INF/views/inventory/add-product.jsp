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
					<h2>Add New Inventory</h2>
					</div>
			</div>
			
			<div class="row second_row">
				<div class="col-lg-12">
				<c:if  test="${requestScope.success ne null}">
				<div class="alert alert-success success">
				  <strong>Success!</strong> ${requestScope.success}.
				</div>
				</c:if>
			<form:form method="POST" commandName="product" class="form-horizontal" enctype="multipart/form-data">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="name">Name</label>
						<div class="col-md-7">
							<form:input type="text" path="name" placeholder="Choose Product Name" id="name" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="name" cssClass="error" class="help-inline"/>
								<div class="has-error">${requestScope.name}</div>
							</div>
						</div>
					</div>
				</div>
		
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="barCode">BarCode</label>
						<div class="col-md-7">
							<form:input type="text" path="barCode" placeholder="Choose Product BarCode" id="barCode" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="barCode" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				 <div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="vendorId">Primary Vendor</label>
						<div class="col-md-7">
							<form:select  class="form-control" path="vendorId" >
							 	<form:option value="${null}" label="Please Select a Vendor"/>
								<form:options itemValue="id" itemLabel="name"  items="${vendorsList}"/>
							</form:select>
						<form:errors path="vendorId" class="help-inline"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="costPrice">Cost Price</label>
						<div class="col-md-7">
							<form:input type="number" path="costPrice" placeholder="Provide Product Cost Price" id="maxNumber" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="costPrice" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="salePrice">Sale Price</label>
						<div class="col-md-7">
							<form:input type="number" path="salePrice" placeholder="Provide Product Sale Price" id="salePrice" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="salePrice" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="quantity">Quantity</label>
						<div class="col-md-7">
							<form:input type="number" path="quantity" placeholder="Provide Product Quantity" id="quantity" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="quantity" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="maxQuantity">Maximum Quantity</label>
						<div class="col-md-7">
							<form:input type="number" path="maxQuantity" placeholder="Provide Maximum Quantity For Product" id="maxQuantity" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="maxQuantity" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="minQunatity">Minimum Quantity</label>
						<div class="col-md-7">
							<form:input type="number" path="minQunatity" placeholder="Provide Minimum Quantity For Product" id="minQunatity" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="minQunatity" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="location">Location</label>
						<div class="col-md-7">
							<form:input type="text" path="location" id="location" placeholder="Please Provide A Location" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="location" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable" for="image">Upload an Image</label>
                            <div class="col-md-7">
                                <input type="file" name="file" id="file" class="form-control input-sm"/>
                                <div class="has-error">
                                    <form:errors path="image" class="help-inline"/>
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
</body>

</html>
