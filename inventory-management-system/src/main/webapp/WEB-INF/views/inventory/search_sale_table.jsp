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
		<tr>
			<th>Name</th>
			<th>Image</th>
			<th>Primary Vendor</th>
			<th>BarCode</th>
			<th>Cost price</th>
			<th>Sale price</th>
			<th>Quantity</th>
			<th>Maximum Quantity</th>
			<th>Minimum Quantity</th>
			<th>Status</th>
		</tr>
	</thead>
</table>

<script type="text/javascript">
$(document).ready(function(){
	var data =eval('${productList}');
	var table = $('#example').DataTable( {
        "columnDefs": [
            {
                "render": function ( data, type, row ) {
                    return ((row.status)?'Enabled':'Disabled');
                },
                "targets": [9]
            },
            { "visible": true,  "targets": [ 9 ] },
            {
	              "render": function ( data, type, row ) {
	                  return "<img src='data:image/png;base64,"+row.image+"' width='100'/>";
              },
              "targets": [1]
          },
          { "visible": true,  "targets": [ 1 ] }
        ], 
		"aaData": data,
		  "aoColumns": [
		    { "mData": "name"},
		    { "mData": "image"},
		    { "mData": "vendor.name"},
		    { "mData": "barCode"},
		    { "mData": "costPrice"},
		    { "mData": "salePrice"},
		    { "mData": "quantity"},
		    { "mData": "maxQuantity"},
		    { "mData": "minQunatity"},
		    { "mData": "status"}
		  ],
		  "paging":true
		});
	
});

 


</script>