The C-CDA Extended Validator Service is a service implementation of the SITE XPath Validator API that has been configured to utilize the SITE C-CDA XPath Validators.

Dependencies for this project:

	SITE XPath Validator API
	SITE C-CDA XPath Validators (Which depends on: SITE Code Validator API)


Deploy the C-CDA Extended Validator Web Service Project to a JEE Web Container, such as Tomcat.  
   You'll need to make sure there is a file on the classpath called "environment.properties".  This file must include the following configuration items:
        
        ccdaextended.configFile=/directory/location/to/ccdaExtendedValidatorConfig.xml
        vocabulary.localRepositoryDir=/directory/location/to/code_repositories/
        vocabulary.orientDbConfigFile=/directory/location/to/orientdb-server-config.xml
        vocabulary.primaryDbName=primary
        vocabulary.secondaryDbName=secondary
        
Orient DB Configuration    
	You'll also need to make sure that you have a configuration file for the internal orientdb database.  The following is a sample orient DB file:
   
      <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
        <orient-server>
          <handlers>
            <handler class="com.orientechnologies.orient.server.handler.OJMXPlugin">
               <parameters>
                   <parameter value="false" name="enabled"/>
                   <parameter value="true" name="profilerManaged"/>
               </parameters>
           </handler>
           <handler class="com.orientechnologies.orient.server.plugin.mail.OMailPlugin">
               <parameters>
                    <parameter value="false" name="enabled"/>
                    <parameter value="localhost" name="profile.default.mail.smtp.host"/>
                   <parameter value="25" name="profile.default.mail.smtp.port"/>
                    <parameter value="true" name="profile.default.mail.smtp.auth"/>
                    <parameter value="true" name="profile.default.mail.smtp.starttls.enable"/>
                    <parameter value="" name="profile.default.mail.smtp.user"/>
                    <parameter value="" name="profile.default.mail.smtp.password"/>
                </parameters>
            </handler>
            <handler class="com.orientechnologies.orient.server.handler.OAutomaticBackup">
                <parameters>
                    <parameter value="false" name="enabled"/>
                    <parameter value="4h" name="delay"/>
                    <parameter value="backup" name="target.directory"/>
                    <parameter value="${DBNAME}-${DATE:yyyyMMddHHmmss}.json" name="target.fileName"/>
                    <parameter value="" name="db.include"/>
                    <parameter value="" name="db.exclude"/>
                </parameters>
            </handler>
            <handler class="com.orientechnologies.orient.server.handler.OServerSideScriptInterpreter">
                <parameters>
                    <parameter value="false" name="enabled"/>
                </parameters>
            </handler>
        </handlers>
        <network>
            <protocols>
                <protocol implementation="com.orientechnologies.orient.server.network.protocol.binary.ONetworkProtocolBinary" name="binary"/>
                <protocol implementation="com.orientechnologies.orient.server.network.protocol.http.ONetworkProtocolHttpDb" name="http"/>
            </protocols>
            <listeners>
                <listener protocol="binary" socket="default" port-range="2424-2430" ip-address="0.0.0.0"/>
                <listener protocol="http" socket="default" port-range="2480-2490" ip-address="0.0.0.0">
                    <commands>
                        <command implementation="com.orientechnologies.orient.server.network.protocol.http.command.get.OServerCommandGetStaticContent" pattern="GET|www GET|studio/ GET| GET|*.htm GET|*.html GET|*.xml GET|*.jpeg GET|*.jpg GET|*.png GET|*.gif GET|*.js GET|*.css GET|*.swf GET|*.ico GET|*.txt GET|*.otf GET|*.pjs GET|*.svg" stateful="false">
                            <parameters>
                                <entry value="Cache-Control: no-cache, no-store, max-age=0, must-revalidate\r\nPragma: no-cache" name="http.cache:*.htm *.html"/>
                                <entry value="Cache-Control: max-age=120" name="http.cache:default"/>
                            </parameters>
                        </command>
                    </commands>
                    <parameters>
                        <parameter value="utf-8" name="network.http.charset"/>
                    </parameters>
                </listener>
            </listeners>
        </network>
        <storages>
            <storage loaded-at-startup="true" userPassword="admin" userName="admin" path="plocal:/Users/chris/Development/tomcat/tomcat-CCDA/databases/primary" name="primary"/>
            <storage loaded-at-startup="true" userPassword="admin" userName="admin" path="plocal:/Users/chris/Development/tomcat/tomcat-CCDA/databases/secondary" name="secondary"/>
        </storages>
        <users>
            <user resources="*" password="1C9E93E16EA272C1B6C95AC591CE56E52153AB30C7F08C958475B2016AECA2F5" name="root"/>
            <user resources="connect,server.listDatabases,server.dblist" password="guest" name="guest"/>
        </users>
        <properties>
            <entry value="info" name="log.console.level"/>
            <entry value="fine" name="log.file.level"/>
        </properties>
       </orient-server>

       
Code Value Set Repository
  The Validation Engine, and corresponding document loaders, require a specific directory hierarchy for the vocabulary code value set files. The hirearchy is as follows:
  
    code_repository
      ICD9CM_DX (files can be obtained from http://www.cms.gov/Medicare/Coding/ICD9ProviderDiagnosticCodes/codes.html)
      ICD9CM_SG (files can be obtained from http://www.cms.gov/Medicare/Coding/ICD9ProviderDiagnosticCodes/codes.html)
      ICD10CM (files can be obtained from http://www.cms.gov/Medicare/Coding/ICD10/2015-ICD-10-CM-and-GEMs.html)
      ICD10PCS (files can be obtained from http://www.cms.gov/Medicare/Coding/ICD10/2015-ICD-10-PCS-and-GEMs.html)
      LOINC (files can be obtained from http://loinc.org/downloads)
      RXNORM (files can be obtained from http://www.nlm.nih.gov/research/umls/rxnorm/docs/rxnormfiles.html)
      SNOMED-CT (files can be obtained from http://www.nlm.nih.gov/research/umls/Snomed/us_edition.html)
      
Xpath Validator API Configuration:
	The SITE XPath Validation API requires configuration in order to properly associate Validators with XPath Expressions.  A sample configuration is included with this project and its location must be configured in the "environment.properties" file.  The sample configuration should be in the following XML format:
		<configuration>
			<expression xpathExpression="//section/templateId[@root='2.16.840.1.113883.10.20.22.2.22.1']/ancestor::section[1]/code">
				<validator className="org.sitenv.xml.validators.ccda.structuredbody.coderequirements.MustBeValidator">
					<param key="codeSystem" value="2.16.840.1.113883.6.1"/>
				</validator>
			</expression>
		</configuration>