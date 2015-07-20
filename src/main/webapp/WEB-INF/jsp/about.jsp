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
  			<p><%= rootContext %>/validateXml/  </p>			
  			<h2>Validation Response</h2>
  			<p>
  				The webservice response is a simple JSON object with the following configuration:
  			</p>
  				<pre>{
"errors":		&lt;boolean&gt;		/* denotes if the validated XML file had any errors */
"information":		&lt;boolean&gt;		/* denotes if the validated XML file had any informational messages */
"warnings":		&lt;boolean&gt;		/* denotes if the validated XML file had any warnings */
"errorList":		&lt;array of messages&gt;	/* array of message objects associated with errors */
"informationList":	&lt;array of messages&gt;	/* array of message objects associated with informational messages */
"warningList":		&lt;array of messages&gt;	/* array of message objects associated with warnings */
}</pre>
  			<p>	
  				Messages are a simple JSON object with the following configuration:
  			</p>
  				<pre>{
"message":		&lt;string&gt;	/* the text of the message */
"xpathExpression":	&lt;string&gt;	/* the xpath expression that produced the message during validation */
"codeSystem":		&lt;string&gt;	/* the code system of the node that produced the message */
"codeSystemName":	&lt;string&gt;	/* the name of the code system of the node that produced the message */
"code":			&lt;string&gt;	/* the code of the node that produced the message */
"displayName":		&lt;string&gt;	/* the display name of the node that produced the message */
"nodeIndex":		&lt;integer&gt;	/* the index of the node found during validation of of the xpath expression evaluation of the xml document */
}</pre>
  					
  			
  			<h2>Example Usage</h2>
  			<p>
  				curl -D- -X POST -F "file=@CCDA_CCD_b1_InPatient.xml" <%= rootContext %>/validateXML/
  			</p>		
		</div>
		
		<div id="validateCode" class="page-header">
  			<h1>Validate Code</h1>
		</div>
		
		<div id="validateCodePage" class="page">
  			<p>Validate Code verifies the existence of a code in a specified vocabulary.</p>
  			
  			<h2>URL</h2>
  			<p><%= rootContext %>/validateCode/&lt;vocabulary&gt;/&lt;code&gt;  </p>		  			
  			<h2>Data Sets</h2>
  			<p>
  				The following vocabularies are supported:
  			</p>
  				<ul>
  					<li>2.16.840.1.113883.6.96 (SNOMED-CT)</li>
  				</ul>
  			<p>	
  				Datasets are loaded from the following GitHub repository:  TBD
   			</p>
  			<h2>Validation Response</h2>
  			<p>
  				The validation response message returns a simple JSON object.  The simple object only includes a boolean attribute named "result".  If the validation passes, and the code exists in the specified vocabulary, "result" will be true.  If the validation fails and the code could not be found in the specified vocabulary, "result" will be false.
  			</p>
  			<p>
  				Note: Display name validation is case-insensitive.
  			</p>
  			<h2>Example Usage</h2>
  			<p>
  				The following example will validate the code value of "C-D2223", from the "2.16.840.1.113883.6.96" vocabulary value set.
  			</p>
  			<p>	
  				<a href="<%= rootContext %>/validateCode/2.16.840.1.113883.6.96/C-D2223"><%= rootContext %>/validateCode/2.16.840.1.113883.6.96/C-D2223</a>
  			</p>		
		</div>
		
		<div id="validateCodeByCodeSystemName" class="page-header">
  			<h1>Validate Code By Code System Name</h1>
		</div>
		
		<div id="validateCodeByCodeSystemPage" class="page">
  			<p>Validate Code By Code System Name verifies the existence of a code in a specified vocabulary (identified by name).</p>
  			
  			<h2>URL</h2>
  			<p><%= rootContext %>/validateCodeByCodeSystemName/&lt;vocabularyName&gt;/&lt;code&gt;  </p>		  			
  			<h2>Data Sets</h2>
  			<p>
  				The following vocabularies are supported:
  			</p>
  				<ul>
  					<li>SNOMED-CT</li>
  				</ul>
  			<p>	
  				Datasets are loaded from the following GitHub repository:  TBD
   			</p>
  			<h2>Validation Response</h2>
  			<p>
  				The validation response message returns a simple JSON object.  The simple object only includes a boolean attribute named "result".  If the validation passes, and the code exists in the specified vocabulary, "result" will be true.  If the validation fails and the code could not be found in the specified vocabulary, "result" will be false.
  			</p>
  			<p>
  				Note: Display name validation is case-insensitive.
  			</p>
  			<h2>Example Usage</h2>
  			<p>
  				The following example will validate the code value of "C-D2223", from the "SNOMED-CT" vocabulary value set.
  			</p>
  			<p>	
  				<a href="<%= rootContext %>/validateCodeByCodeSystemName/SNOMED-CT/C-D2223"><%= rootContext %>/validateCodeByCodeSystemName/SNOMED-CT/C-D2223</a>
  			</p>		
		</div>

		<div id="validateName" class="page-header">
  			<h1>Validate Display Name</h1>
		</div>
		
		<div id="validateNamePage" class="page">
  			<p>Validate Name verifies the existence of a display name in a specified vocabulary.</p>
  			
  			<h2>URL</h2>
  			<p><%= rootContext %>/validateName/&lt;vocabulary&gt;/&lt;code&gt; </p> 			  			
  			<h2>Data Sets</h2>
  			<p>
  				The following vocabularies are supported:
  			</p>
  				<ul>
  					<li>2.16.840.1.113883.6.96 (SNOMED-CT)</li>
  				</ul>
  			<p>	
  				Datasets are loaded from the following GitHub repository:  TBD
   			</p>
  			<h2>Validation Response</h2>
  			<p>
  				The validation response message returns a simple JSON object.  The simple object only includes a boolean attribute named "result".  If the validation passes, and the display name exists in the specified vocabulary, "result" will be true.  If the validation fails and the display name could not be found in the specified vocabulary, "result" will be false.
  			</p>
  			<p>
  				Note: Display name validation is case-insensitive.
  			</p>
  			<h2>Example Usage</h2>
  			<p>
  				The following example will validate the display name value of "CUTTER PREMISE AND STABLE SPRAY (PRODUCT)", from the "2.16.840.1.113883.6.96" vocabulary value set.
  			</p>
  			<p>
  				<a href="<%= rootContext %>/validateName/2.16.840.1.113883.6.96/CUTTER%20PREMISE%20AND%20STABLE%20SPRAY%20(PRODUCT)"><%= rootContext %>/validateName/2.16.840.1.113883.6.96/CUTTER%20PREMISE%20AND%20STABLE%20SPRAY%20(PRODUCT)</a>
  			</p>
		</div>
		<div id="validateNameByCodeSystemName" class="page-header">
  			<h1>Validate Display Name By Code System Name</h1>
		</div>
		
		<div id="validateNamePageByCodeSystemName" class="page">
  			<p>Validate Name By Code System Name verifies the existence of a display name in a specified vocabulary.</p>
  			
  			<h2>URL</h2>
  			<p><%= rootContext %>/validateName/&lt;vocabularyName&gt;/&lt;code&gt; </p>			  			
  			<h2>Data Sets</h2>
  			<p>
  				The following vocabularies are supported:
  			</p>
  				<ul>
  					<li>SNOMED-CT</li>
  				</ul>
  			<p>	
  				Datasets are loaded from the following GitHub repository:  TBD
   			</p>
  			<h2>Validation Response</h2>
  			<p>
  				The validation response message returns a simple JSON object.  The simple object only includes a boolean attribute named "result".  If the validation passes, and the display name exists in the specified vocabulary, "result" will be true.  If the validation fails and the display name could not be found in the specified vocabulary, "result" will be false.
  			</p>
  			<p>
  				Note: Display name validation is case-insensitive.
  			</p>
  			<h2>Example Usage</h2>
  			<p>
  				The following example will validate the display name value of "CUTTER PREMISE AND STABLE SPRAY (PRODUCT)", from the "SNOMED-CT" vocabulary value set.
  			</p>
  			<p>
  				<a href="<%= rootContext %>/validateNameByCodeSystemName/SNOMED-CT/CUTTER%20PREMISE%20AND%20STABLE%20SPRAY%20(PRODUCT)"><%= rootContext %>/validateNameByCodeSystemName/SNOMED-CT/CUTTER%20PREMISE%20AND%20STABLE%20SPRAY%20(PRODUCT)</a>
  			</p>
		</div>
		<div id="validateValueSetCode" class="page-header">
  			<h1>Validate Value Set Code</h1>
		</div>
		<div id="validateValueSetCodePage" class="page">
  			<p>Validate Value Set Code verifies the existence of a code, independent of the code system, in a specified vocabulary value set.</p>
  			
  			<h2>URL</h2>
  			<p><%= rootContext %>/validateValueSetCode/&lt;valueSet&gt;/&lt;code&gt;</p>		  			
  			<h2>Data Sets</h2>
  			<p>
  				Datasets are loaded from the following GitHub repository:  TBD
   			</p>
  			<h2>Validation Response</h2>
  			<p>
  				The validation response message returns a simple JSON object.  The simple object only includes a boolean attribute named "result".  If the validation passes, and the code exists in the specified value set, "result" will be true.  If the validation fails and the code could not be found in the specified value set, "result" will be false.
  			</p>
  			<p>
  				Note: Value Set Code validation is case-insensitive.
  			</p>
  			<h2>Example Usage</h2>
  			<p>
  				The following example will validate the code value of "M", for Married, exists in the HL7 marital status (2.16.840.1.113883.1.11.12212)  value set.
  			</p>
  			<p>
  				<a href="<%= rootContext %>/validateValueSetCode/2.16.840.1.113883.1.11.12212/M"><%= rootContext %>/validateValueSetCode/2.16.840.1.113883.1.11.12212/M</a>
  			</p>
		</div>
		<div id="validateValueSetCodeForCodeSystem" class="page-header">
  			<h1>Validate Value Set Code for Code System</h1>
		</div>
		<div id="validateValueSetCodeForCodeSystemPage" class="page">
  			<p>Validate Value Set Code for Code System verifies the existence of a code in a specified value set for a specific code system.</p>
  			
  			<h2>URL</h2>
  			<p><%= rootContext %>/validateValueSetCodeForCodeSystem/&lt;valueSet&gt;/&lt;codeSystem&gt;/&lt;code&gt;  </p>			  			
  			<h2>Data Sets</h2>
  			
  			<p>
  				Datasets are loaded from the following GitHub repository:  TBD
   			</p>
  			<h2>Validation Response</h2>
  			<p>
  				The validation response message returns a simple JSON object.  The simple object only includes a boolean attribute named "result".  If the validation passes, and the code exists in the specified value set, "result" will be true.  If the validation fails and the code could not be found in the specified value set, "result" will be false.
  			</p>
  			<p>
  				Note: Vqlidate Name By Code System Name validation is case-insensitive.
  			</p>
  			<h2>Example Usage</h2>
  			<p>
  				The following example will validate the code value of "M", for Married, exists in the HL7 marital status (2.16.840.1.113883.1.11.12212)  value set, for the code system (2.16.840.1.113883.5.2).
  			</p>
  			<p>
  				<a href="<%= rootContext %>/validateValueSetCodeForCodeSystem/2.16.840.1.113883.1.11.12212/2.16.840.1.113883.5.2/M"><%= rootContext %>/validateValueSetCodeForCodeSystem/2.16.840.1.113883.1.11.12212/2.16.840.1.113883.5.2/M</a>
  			</p>
		</div>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-3 hidden-xs">
		<ul class="nav nav-pills nav-stacked">
			<li class="page-header"><h1>Service API</h1></li>
  			<li><a href="#validateXml">Validate C-CDA</a></li>
  			<li><a href="#validateCode">Validate Code</a></li>
  			<li><a href="#validateCodeByCodeSystemName">Validate Code By Code System Name</a></li>
  			<li><a href="#validateName">Validate Display Name</a></li>
  			<li><a href="#validateNameByCodeSystemName">Validate Display Name By Code System Name</a></li>
  			<li><a href="#validateValueSetCode">Validate Value Set Code</a></li>
  			<li><a href="#validateValueSetCodeForCodeSystem">Validate Value Set Code By Code System</a></li>
		</ul>
		<ul class="nav nav-pills nav-stacked">
			<li class="page-header"><h1>Project Links</h1></li>
  			<li><a href="https://github.com/">Project Repository</a></li>
		</ul>
	</div>
</div>



</body>

</html>