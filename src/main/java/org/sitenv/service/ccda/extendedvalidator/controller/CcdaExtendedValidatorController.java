package org.sitenv.service.ccda.extendedvalidator.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.sitenv.service.ccda.extendedvalidator.view.CcdaValidatorResponseJsonView;
import org.sitenv.service.ccda.extendedvalidator.view.CcdaValidatorResultJsonView;
import org.sitenv.xml.validators.ccda.CcdaValidatorResult;
import org.sitenv.xml.xpathvalidator.engine.XPathValidationEngine;
import org.sitenv.xml.xpathvalidator.engine.data.XPathValidatorResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

@RestController
public class CcdaExtendedValidatorController {
	
	private static final Logger logger = Logger.getLogger(CcdaExtendedValidatorController.class);
	private static final String DEFAULT_PROPERTIES_FILE = "environment.properties";
	private static XPathValidationEngine engine = null;
	
	protected Properties props;
	
	protected void loadProperties() throws IOException {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(DEFAULT_PROPERTIES_FILE);
		
		if (in == null)
		{
			props = null;
			throw new FileNotFoundException("Environment Properties File not found in class path.");
		}
		else
		{
			props = new Properties();
			props.load(in);
		}
	}
	
	@RequestMapping(value="/validateXML", method= RequestMethod.POST)
	public @ResponseBody CcdaValidatorResponseJsonView validateXML(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
		
		if (props == null)
		{
			this.loadProperties();
		}
		
		CcdaValidatorResponseJsonView responseView = new CcdaValidatorResponseJsonView();
		
		if (engine == null) {
			engine = new XPathValidationEngine();

			engine.initialize(props.getProperty("ccdaextended.configFile"));
			
			logger.info("Ccda Extended Validation Engine loaded for : " + props.getProperty("ccdaextended.configFile"));
		}
		
		try 
		{
			if (multipartFile != null) {
				List<XPathValidatorResult> results = engine.validate(multipartFile.getInputStream());
				
				if (results != null) {
				
					for (XPathValidatorResult result : results) 
					{	
						if (result != null)
						{
							if (result.hasError()) {
								responseView.setErrors(true);
								
								CcdaValidatorResultJsonView toAdd = new CcdaValidatorResultJsonView();
								
								toAdd.setMessage(result.getErrorMessage());
								toAdd.setXpathExpression(result.getXpathExpression());
								toAdd.setNodeIndex(result.getNodeIndex());
								if (result instanceof CcdaValidatorResult)
								{
									CcdaValidatorResult convertedResult = (CcdaValidatorResult)result;
									toAdd.setCode(convertedResult.getCode());
									toAdd.setCodeSystem(convertedResult.getCodeSystem());
									toAdd.setCodeSystemName(convertedResult.getCodeSystemName());
									toAdd.setDisplayName(convertedResult.getDisplayName());
								}
								
								responseView.getErrorList().add(toAdd);
							}
							if (result.hasWarning()) {
								responseView.setWarnings(true);
								
								CcdaValidatorResultJsonView toAdd = new CcdaValidatorResultJsonView();
								
								toAdd.setMessage(result.getWarningMessage());
								toAdd.setXpathExpression(result.getXpathExpression());
								toAdd.setNodeIndex(result.getNodeIndex());
								if (result instanceof CcdaValidatorResult)
								{
									CcdaValidatorResult convertedResult = (CcdaValidatorResult)result;
									toAdd.setCode(convertedResult.getCode());
									toAdd.setCodeSystem(convertedResult.getCodeSystem());
									toAdd.setCodeSystemName(convertedResult.getCodeSystemName());
									toAdd.setDisplayName(convertedResult.getDisplayName());
								}
								
								responseView.getWarningList().add(toAdd);
								
							}
							
							if (result.hasInformation()) {
								responseView.setInformation(true);
								
								CcdaValidatorResultJsonView toAdd = new CcdaValidatorResultJsonView();
								
								toAdd.setMessage(result.getInfoMessage());
								toAdd.setXpathExpression(result.getXpathExpression());
								toAdd.setNodeIndex(result.getNodeIndex());
								if (result instanceof CcdaValidatorResult)
								{
									CcdaValidatorResult convertedResult = (CcdaValidatorResult)result;
									toAdd.setCode(convertedResult.getCode());
									toAdd.setCodeSystem(convertedResult.getCodeSystem());
									toAdd.setCodeSystemName(convertedResult.getCodeSystemName());
									toAdd.setDisplayName(convertedResult.getDisplayName());
								}
								
								responseView.getInformationList().add(toAdd);
							}
						}
					}
				}
			}
		} 
		catch (IOException e) 
		{
			logger.error(e);
		} 
		catch (SAXException e) 
		{
			logger.error(e);
		}
		
		
		return responseView;
		
	}
	
}
