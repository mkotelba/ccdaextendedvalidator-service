package org.sitenv.service.ccda.extendedvalidator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
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
public class CcdaExtendedValidatorService {
	
	private static final Logger logger = Logger.getLogger(CcdaExtendedValidatorService.class);
	private static final String DEFAULT_PROPERTIES_FILE = "environment.properties";
	
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
	
	@RequestMapping(value="/validateXML", method= RequestMethod.POST, produces="application/json; charset=utf-8")
	@ResponseBody
	public String validateXML(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
		
		if (props == null)
		{
			this.loadProperties();
		}
		
		XPathValidationEngine engine = new XPathValidationEngine();
		engine.initialize("/Users/chris/Development/git/ccdaextendedvalidator-service/src/main/resources/sampleConfig.xml");
		
		try 
		{
			if (multipartFile != null) {
				List<XPathValidatorResult> results = engine.validate(multipartFile.getInputStream());
				
				for (XPathValidatorResult result : results) 
				{
				
					if (result.isHasError()) {
						return "false";
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
		
		
		return "true";
		
	}
	
}
