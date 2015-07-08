<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<title>Vocabulary Validation Service Testing UI</title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Vocabulary Validation Tester</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" action="/" id="validationform"
				method="post">
				<div class="form-group">
					<label for="code" class="col-sm-2 control-label">Code</label>
					<div class="col-sm-10">
						<input class="form-control" id="code" placeholder="code">
					</div>
				</div>
				<div class="form-group">
					<label for="vocabulary" class="col-sm-2 control-label">Vocabulary</label>
					<div class="col-sm-10">
						<input class="form-control" id="vocabulary"
							placeholder="Vocabulary">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("button").click(function(event) {
		event.preventDefault();
		alert('so you wanna make an ajax request?');
		var values = $(this).serialize();
		$.post("/CCDAExtendedValidatorService/validateCodeByCodeSystemName", values, function(data, status) {
			alert("Data: " + data + "\nStatus: " + status);
		});
	});
</script>
</html>