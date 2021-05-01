<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation-bar.jspf" %>
	
	<div class="container">
		Add a Term here <br />
		
		<form:form method="POST" modelAttribute="terminologyBean">
			
			<form:input type = "hidden" path = "id" />
			
			<fieldset class = "form-group">
				<form:label class="form-label" path = "description">Description</form:label> 
				<form:input type="text" placeholder="Add a Description" class = "form-control" path = "description" />
				<form:errors path = "description" cssClass = "text-warning"/>
			</fieldset>
			
			<fieldset class = "form-group">
				<form:label path="shortForm">Short Form</form:label>
				<form:input type="text" placeholder="Add a Short Form" class = "form-control" path = "shortForm" required="required" />
				<form:errors path = "shortForm" cssClass = "text-warning"/>
			</fieldset>
			
			<fieldset class = "form-group">
				<form:label path="fullForm">Full Form</form:label>
				<form:input type="text" placeholder="Add a Full Form" class = "form-control" path = "fullForm" required="required" />
				<form:errors path = "fullForm" cssClass = "text-warning"/>
			</fieldset>
			
			<button type="submit" class="btn btn-success" >Add to list</button>
		</form:form>
	</div>
	
<%@ include file = "common/footer.jspf"%>