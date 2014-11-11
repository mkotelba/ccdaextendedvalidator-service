<% String rootContext = request.getRequestURL().toString().replace("/About", ""); %>

<html>
<head>
	<title>C-CDA Extended Validator API</title>
	
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
The primary use case of this system includes validating codes of a C-CDA file against standard vocabulary values.

</p>
</div>

<div class="row">
	<div class="col-lg-9 col-md-9 col-sm-9">
		<div id="validateXml" class="page-header">
  			<h1>Validate C-CDA File</h1>
		</div>
		
		<div id="validateXmlPage" class="page">
  			<p>Validate C-CDA File performs validation of vocabulary codes in C-CDA files</p>
  			
  			<h2>URL</h2>
  			<p><%= rootContext %>/validateXml/  			  			
  			<h2>Validation Response</h2>
  			<p>
  				The webservice response is a simple JSON object with the following configuration:
  				<pre>{
"errors":		&lt;boolean&gt;		/* denotes if the validated XML file had any errors */
"information":		&lt;boolean&gt;		/* denotes if the validated XML file had any informational messages */
"warnings":		&lt;boolean&gt;		/* denotes if the validated XML file had any warnings */
"errorList":		&lt;array of messages&gt;	/* array of message objects associated with errors */
"informationList":	&lt;array of messages&gt;	/* array of message objects associated with informational messages */
"warningList":		&lt;array of messages&gt;	/* array of message objects associated with warnings */
}</pre>
  				
  				Messages are a simple JSON object with the following configuration:
  				<pre>{
"message":		&lt;string&gt;	/* the text of the message */
"xpathExpression":	&lt;string&gt;	/* the xpath expression that produced the message during validation */
"codeSystem":		&lt;string&gt;	/* the code system of the node that produced the message */
"codeSystemName":	&lt;string&gt;	/* the name of the code system of the node that produced the message */
"code":			&lt;string&gt;	/* the code of the node that produced the message */
"displayName":		&lt;string&gt;	/* the display name of the node that produced the message */
"nodeIndex":		&lt;integer&gt;	/* the index of the node found during validation of of the xpath expression evaluation of the xml document */
}</pre>
  					
  			</p>
  			
  			<h2>Example Usage</h2>
  			<p>
  				curl -D- -X POST -F "file=@CCDA_CCD_b1_InPatient.xml" <%= rootContext %>/validateXML/
  			</p>		
		</div>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-3 hidden-xs">
		<ul class="nav nav-pills nav-stacked">
			<li class="page-header"><h1>Service API</h1></li>
  			<li><a href="#validateXml">Validate C-CDA</a></li>
		</ul>
		<ul class="nav nav-pills nav-stacked">
			<li class="page-header"><h1>Project Links</h1></li>
  			<li><a href="https://github.com/">Project Repository</a></li>
		</ul>
	</div>
</div>



</body>

</html>