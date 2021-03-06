<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Inventory Management</title>
    <!-- Bootstrap Core CSS -->
    <link href="../static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../static/css/sb-admin-2.css" rel="stylesheet">
	<link href="../static/css/custom.css" rel="stylesheet">
    <!-- Morris Charts CSS -->
    <link href="../static/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">


</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
           
           <jsp:include page="../header/nav_top.jsp" />
	
	       <jsp:include page="../header/side_bar.jsp" />
	
        </nav>

        <div id="page-wrapper">
             <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Search For Vendors</h1>
                </div>
            </div>
            <div class="row second_row">
			<form:form method="POST"    commandName="vendorSearchCriteria" class="form-horizontal">
				<div class="row">
					<div class="form-group col-md-8">
						<label class="col-md-3 control-lable" for="name">Name</label>
						<div class="col-md-7">
							<form:input type="text" path="name" id="name" class="form-control"/>
						</div>
					</div>
				</div>
						 <div class="row">
					<div class="form-group col-md-8">
						<label class="col-md-3 control-lable" for="country">Select Country </label>
						<div class="col-md-7">
							<form:select onchange="print_state('state',this.selectedIndex);" class="form-control" path="country">
							</form:select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-8">
						<label class="col-md-3 control-lable" for="city">Select City </label>
						<div class="col-md-7">
							<form:select class="form-control"  id ="state" path="city">
							</form:select>
						</div>
					</div>
				</div>
				 <div class="row">
					<div class="form-group col-md-8">
						<label class="col-md-3 control-lable" for="companyId">Company Name</label>
						<div class="col-md-7">
							<form:select  class="form-control" path="companyId" >
							 	<form:option value="${0}" label="Please Select Company"/>
								<form:options itemValue="id" itemLabel="name"  items="${companiesList}"/>
							</form:select>
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
				<div class="row" style="margin-right: 184px;">
					<div>
						<input type="submit" value="Search" class="submit-button-customer btn btn-primary btn-sm">
					</div>
				</div>
			</form:form>
		</div>           <div class="row">
                <div class="col-lg-12">            
		            <jsp:include page="../includes/header.jsp"/>
					<jsp:include page="search_vendor_table.jsp"/>
					<jsp:include page="../includes/footer.jsp"/>
				</div>
			</div>
        </div>

    </div>
 
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
