<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation-bar.jspf" %>

<div class="container">
	<h1>Hello Chanpreet</h1>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Short Form</th>
				<th>Full Form</th>
				<th>Description</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${terminologies}" var = "terminology">
				<tr>
					<td> ${terminology.shortForm} </td>
					<td> ${terminology.fullForm} </td>
					<td> ${terminology.description} </td>	
					<td> <a href = "/updateTerminology?id=${terminology.id }" class = "btn btn-success">Update</a> </td>
					<td> <a href = "/deleteTerminology?id=${terminology.id }" class = "btn btn-warning">Delete </a> </td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
	<a href ="/createTerminology" class = "btn btn-success" >Add a new Term</a>
</div>

<%@ include file = "common/footer.jspf"%>