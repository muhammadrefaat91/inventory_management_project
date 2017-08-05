<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>

<style type="text/css" >
#example_info{
	        margin-left: -154px;
}
#example_paginate{
    margin-right: -151px;
 }
</style>
<table id="example" class="display" cellspacing="0"  style="overflow-x:auto;width: 144%;
    margin-left: -158px;">
	<thead>
<!-- 		<tr> -->
<!-- 			<th><div class="col-xs-12"><input class="form-control" type="text" id="firstName" /></div></th> -->
<!-- 			<th></th> -->
<!-- 			<th><div class="col-xs-12"><input class="form-control" type="text" id="salary" /></div></th> -->
<!-- 			<th></th> -->
<!-- 		</tr> -->
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Mobile Number</th>
			<th>max Number</th>
			<th>Allowed Amount</th>
			<th>Status</th>
		</tr>
	</thead>
</table>

<script type="text/javascript">
$(document).ready(function(){
	var data =eval('${customerList}');
	var table = $('#example').DataTable( {
        "columnDefs": [
            {
                "render": function ( data, type, row ) {
                    return ((row.status)?'Enabled':'Disabled');
                },
                "targets": 5
            },
            { "visible": true,  "targets": [ 5 ] }
        ],  
		"aaData": data,
		  "aoColumns": [
		    { "mData": "firstName"},
		    { "mData": "lastName"},
		    { "mData": "mobile"},
		    { "mData": "maxNumber"},
		    { "mData": "allowedAmount"},
		    { "mData": "status"}
		  ],
		  "paging":true
		});
	
});

 


</script>