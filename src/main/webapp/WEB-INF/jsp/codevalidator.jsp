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

<link rel="stylesheet" href="resources/css/style.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
<script src="resources/js/parsley.js"></script>

<title>Vocabulary Validation Service Testing UI</title>
</head>
<body>
<div class="container">
	<div class="panel panel-default col-lg-8">
		<div class="panel-heading">
			<h3 class="panel-title">Vocabulary Validation Tester</h3>
		</div>
		<div class="panel-body">

			<form class="form-horizontal" action="#" id="validationform"
				method="get" data-parsley-validate>
				<div class="form-group">
					<label for="validationSelection" class="col-sm-2 control-label">Validator</label>
					<div class="col-sm-10">
						<select class="form-control" id="validationSelection">
							<option value="validateCode">Validate Code</option>
							<option value="validateCodeByCodeSystemName">Validate
								Code By Code System Name</option>
							<option value="validateName">Validate Display Name</option>
							<option value="validateName">Validate Display Name By
								Code System Name</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="code" class="col-sm-2 control-label">Code</label>
					<div class="col-sm-10">
						<input class="form-control" id="code" name="code"
							placeholder="code" required>
					</div>
				</div>
				<div class="form-group">
					<label for="vocabulary" class="col-sm-2 control-label">Vocabulary</label>
					<div class="col-sm-10">
						<input class="form-control" id="vocabulary" name="vocabulary"
							placeholder="Vocabulary" required>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button id="validateButton" type="submit" class="btn btn-default">Submit</button>
						<button type="reset" class="btn btn-default">Reset</button>
					</div>
				</div>
			</form>
			<div id="validationResult" name="validationResult" style="font-size: 75px"></div>
		</div>

	</div>
</div>
</body>
<script type="text/javascript">
	$('#validationform').submit(
			function(ev) {
				$('#validationResult').removeClass(),
				$('#validationResult').text('VALIDATING'),
				$('#validationResult').append('<span class="glyphicon glyphicon-refresh spinning"></span>')
				$.ajax({
					type : 'GET',
					contentType : 'application/json; charset=utf-8',
					dataType : 'json',
					url : $("#validationSelection").val() + "/"
							+ $('#vocabulary').val() + "/" + $('#code').val(),
					success : function(data) {
						if(data.result === true){
							$('#validationResult').addClass('alert alert-success text-center');
							$('#validationResult').text('VALID');
						}else{
							$('#validationResult').addClass('alert alert-danger text-center');
							$('#validationResult').text('NOT VALID');
						}	
					},
					error : function(request, status, error) {
						$('#validationResult').addClass('alert alert-warning text-center');
						$('#validationResult').text('ERROR COMMUNICATING WITH THE SERVER');
					}
				});

				ev.preventDefault();
			});
</script>
</html>