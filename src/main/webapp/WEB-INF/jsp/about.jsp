<% String rootContext = request.getRequestURL().toString().replace("/About", ""); %>

<html>
<head>
	<title>Vocabulary Validation Services API</title>
	
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
	<style>
	
		.row {
			margin-left: 30px;
			margin-right:30px;
		}
			
		.page
		{
			margin-left: 20px;
		}
		
	
	</style>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	
</head>

<body>
<div class="jumbotron">
  <h1>C-CDA Extended Validator Web Services API</h1>
  <p>A major issue in clinical document validation is the lack of validation of vocabulary value set validations.  In healthcare, there are multiple standard vocabulary value sets, such as SNOMED CT, RxNorm, LOINC, and ICD-10-CM, which are used to define clinical concepts used in clinical quality measures.  To solve this issue, an extensible system was developed to support validation of C-CDA files against common vocabulary value sets.   
The primary use cases of this system include validating that a code exists in a specific vocabulary and validating that a display name exists in a specific vocabulary.

</p>
</div>

<div class="row">
	<div class="col-lg-9 col-md-9 col-sm-9">
		<div id="validateCode" class="page-header">
  			<h1>Validate C-CDA</h1>
		</div>
		
		<div id="validateCodePage" class="page">
  			<p>Validate C-CDA performs validation of vocabulary codes in C-CDA files</p>
  			
  			<h2>URL</h2>
  			<p><%= rootContext %>/validateCode/&lt;vocabulary&gt;/&lt;code&gt;  			  			
  			<h2>Data Sets</h2>
  			<p>
  				TBD
   			</p>
  			<h2>Validation Response</h2>
  			<p>
  				TBD
  			</p>
  			
  			<h2>Example Usage</h2>
  			<p>
  				TBD
  			</p>
  			<p>	
  				<a href="<%= rootContext %>/validateCode/2.16.840.1.113883.6.96/C-D2223"><%= rootContext %>/validateCode/2.16.840.1.113883.6.96/C-D2223</a>
  			</p>		
		</div>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-3 hidden-xs">
		<ul class="nav nav-pills nav-stacked">
			<li class="page-header"><h1>Service API</h1></li>
  			<li><a href="#validateCode">Validate Code</a></li>
  			<li><a href="#validateCodeByCodeSystemName">Validate Code By Code System Name</a></li>
  			<li><a href="#validateName">Validate Display Name</a></li>
  			<li><a href="#validateNameByCodeSystemName">Validate Display Name By Code System Name</a></li>
		</ul>
		<ul class="nav nav-pills nav-stacked">
			<li class="page-header"><h1>Project Links</h1></li>
  			<li><a href="https://github.com/">Project Repository</a></li>
		</ul>
	</div>
</div>



</body>

</html>