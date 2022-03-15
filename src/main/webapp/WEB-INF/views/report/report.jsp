<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no, user-scalable=no" />
        <title>Attendance</title>
        <link rel="stylesheet" href="/vendor/bootstrap/css/bootstrap.min.css"/>
        
    </head>
<body>

	<div class="header"><h2>Attendance Report</h2></div>
	
	<div class="input-group search-style">
	  <input type="text" class="form-control search-data" placeholder="Search" aria-label="Search" aria-describedby="basic-addon2">
	  <div class="input-group-append">
	    <span class="input-group-text" id="basic-addon2">Search</span>
	  </div>
	</div>
	
	
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">Month</th>
	      <th scope="col">Date</th>
	      <th scope="col">Day</th>
	      <th scope="col">ID</th>
	      <th scope="col">Employee Name</th>
	      <th scope="col">Department</th>
	      <th scope="col">First-In Time</th>
	      <th scope="col">Last-Out Time</th>
	      <th scope="col">Hours of Work</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="attendance" items="${map.attendanceData}">
	  		<tr>
		      <td>${attendance.getMonth()}</td>
			  <td>${attendance.getDate()}</td>
			  <td>${attendance.getDay()}</td>
			  <td class="search-data">${attendance.getId()}</td>
			  <td>${attendance.getEmployeeName()}</td>
			  <td>${attendance.getDepartment()}</td>
			  <td>${attendance.getFirstInTime()}</td>
			  <td>${attendance.getLastOutTime()}</td>
			  <td>${attendance.getHoursOfWork()}</td>
		    </tr>
	  	</c:forEach>
	  </tbody>
	</table>

</body>

<style>

	.search-style{
	
		margin-top: 20px;
		margin-bottom: 20px;
		padding-left: 20px;
		width: 400px;
	}
	
	.hide{
		display: none;
	}
	
	.header{
		padding-left: 20px;
		padding-top: 40px;
	}

</style>

<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>

<script>

	$(".search-data").on("input", function(){
		var searchData = $(this).val().toUpperCase().toString();
		$(".search-data").each(function(){
			var searchContent = $(this).text().toUpperCase().toString();
			if(searchContent.includes(searchData)){
				$(this).closest("tr").removeClass("hide");
			}
			else{
				$(this).closest("tr").addClass("hide");	
			}
		});
		
		if($(this).val() == ""){
			$(".search-data").closest("tr").removeClass("hide");
		}
	});

</script>
</html>