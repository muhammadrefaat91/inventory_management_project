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
			<th>Company Name</th>
			<th>Country</th>
			<th>City</th>
			<th>Mobile</th>
			<th>Logo</th>
			<th>Notes</th>
			<th>Status</th>
		</tr>
	</thead>
</table>

<script type="text/javascript">
$(document).ready(function(){
	var data =eval('${vendorList}');
	var table = $('#example').DataTable( {
        "columnDefs": [
            {
                "render": function ( data, type, row ) {
                    return ((row.status)?'Enabled':'Disabled');
                },
                "targets": [7]
            },
            { "visible": true,  "targets": [ 7 ] },
            {
	              "render": function ( data, type, row ) {
	                  return "<img src='data:image/png;base64,"+row.logo+"' width='100'/>";
              },
              "targets": [5]
          },
          { "visible": true,  "targets": [ 5 ] }
        ],
		"aaData": data,
		  "aoColumns": [
		    { "mData": "name"},
		    { "mData": "company.name"},
		    { "mData": "country"},
		    { "mData": "city"},
		    { "mData": "mobile"},
		    { "mData": "logo"},
		    { "mData": "notes"},
		    { "mData": "status"}
		  ],
		  "paging":true
		});
	
});
</script>