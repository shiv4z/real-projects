<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Report</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style type="text/css">
.button-spacing {
    margin-right: 10px; 
}

</style>
</head>
<body>
		<form:form action="/serachRequest" method="post"
			modelAttribute="search">

			<div class="container mt-3">
				<div class="row">
					<!-- Plan Name -->
					<div class="col-md-3 mb-3">
						<form:label path="planName" class="form-label">Select Plan :</form:label>
						<form:select path="planName" class="form-select">
							<form:option value="">Select</form:option>
							<form:options items="${planName}" />
						</form:select>
					</div>

					<!-- Plan Status -->
					<div class="col-md-3 mb-3">
						<form:label path="planStatus" class="form-label">Select Status :</form:label>
						<form:select path="planStatus" class="form-select">
							<form:option value="">Select</form:option>
							<form:options items="${planStatus}" />
						</form:select>
					</div>

					<!-- Gender -->
					<div class="col-md-3 mb-3">
						<form:label path="gender" class="form-label">Select Gender :</form:label>
						<form:select path="gender" class="form-select">
							<form:option value="">Select</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Fe-Male">Fe-Male</form:option>
						</form:select>
					</div>
					
					
				</div>

			<div class="row">
				<div class="col-md-3 mb-3">
					<form:label path="startDate" class="form-label">Select Start Date :</form:label>
					<form:input type="date" path="startDate"
						class="datepicker form-control" data-date-format="YYYY-MM-DD" />
				</div>

				<div class="col-md-3 mb-3">
					<form:label path="endDate" class="form-label">Select End Date :</form:label>
					<form:input type="date" path="endDate"
						class="datepicker form-control" data-date-format="YYYY-MM-DD" />
				</div>

				<div class="col-md-3 d-flex align-items-end"
					style="margin-bottom: 18px;">
					<input type="submit" value="Search" class="btn btn-primary me-2" />
					<input type="button" id="clear-btn" value="Reset"
						class="btn btn-secondary" />
				</div>
			</div>

		</div>


		</form:form>


		<hr/>
	<table class="table table-striped">
		<thead>
		<tr>
			<th>Sr. N.</th>
			<th>Citizen Name</th>
			<th>Gender</th>
			<th>Citizen Plan</th>
			<th>Plan Status</th>
			<th>Benefit Amount</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Denial Reason</th>
      </tr>
		</thead>
			<tbody>
				<c:if test="${not empty report }">
					<c:forEach items="${report}" var="obj" varStatus="index">
						<tr>
							<td>${index.count}</td>
							<td>${obj.citizenName}</td>
							<td>${obj.gender}</td>
							<td>${obj.planName}</td>
							<td>${obj.planStatus}</td>
							<td>${obj.benefitAmount}</td>
							<td>${obj.startDate}</td>
							<td>${obj.endDate}</td>
							<td>${obj.deniedReason}</td>

						</tr>
					</c:forEach>

				</c:if>
				
				<c:if test="${empty report }">
				<tr><td colspan="9" class="text-center">No Record exist</td></tr>
				</c:if>
			</tbody>

		</table>
		<hr/>
		<div>
		<a href="/downloadExcel" class="btn btn-danger button-spacing">EXCEL</a>
		<a href="/downloadPdf" class="btn  btn-danger">PDF</a>
		
		</div>

<script>

	
	const clearButton = document.getElementById('clear-btn');

	function resetFunction() {
		document.getElementById('planName').value = '';
		document.getElementById('planStatus').value = '';
		document.getElementById('gender').value = '';
		window.location.href = "/"
		console.log('Reset action performed!');
	}

	clearButton.addEventListener('click', resetFunction);
</script>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>