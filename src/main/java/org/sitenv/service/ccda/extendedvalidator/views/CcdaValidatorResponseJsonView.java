package org.sitenv.service.ccda.extendedvalidator.views;

import java.util.ArrayList;
import java.util.List;

public class CcdaValidatorResponseJsonView {

	private boolean errors;
	private boolean information;
	private boolean warnings;
	
	private List<CcdaValidatorResultJsonView> errorList;
	private List<CcdaValidatorResultJsonView> informationList;
	private List<CcdaValidatorResultJsonView> warningList;
	
	
	
	public CcdaValidatorResponseJsonView() {
		super();
		
		errors = false;
		information = false;
		warnings = false;
		
		errorList = new ArrayList<CcdaValidatorResultJsonView>();
		informationList = new ArrayList<CcdaValidatorResultJsonView>();
		warningList = new ArrayList<CcdaValidatorResultJsonView>();
		
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((errorList == null) ? 0 : errorList.hashCode());
		result = prime * result + (errors ? 1231 : 1237);
		result = prime * result + (information ? 1231 : 1237);
		result = prime * result
				+ ((informationList == null) ? 0 : informationList.hashCode());
		result = prime * result
				+ ((warningList == null) ? 0 : warningList.hashCode());
		result = prime * result + (warnings ? 1231 : 1237);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CcdaValidatorResponseJsonView other = (CcdaValidatorResponseJsonView) obj;
		if (errorList == null) {
			if (other.errorList != null)
				return false;
		} else if (!errorList.equals(other.errorList))
			return false;
		if (errors != other.errors)
			return false;
		if (information != other.information)
			return false;
		if (informationList == null) {
			if (other.informationList != null)
				return false;
		} else if (!informationList.equals(other.informationList))
			return false;
		if (warningList == null) {
			if (other.warningList != null)
				return false;
		} else if (!warningList.equals(other.warningList))
			return false;
		if (warnings != other.warnings)
			return false;
		return true;
	}
	
	public boolean isErrors() {
		return errors;
	}
	public void setErrors(boolean errors) {
		this.errors = errors;
	}
	public boolean isInformation() {
		return information;
	}
	public void setInformation(boolean information) {
		this.information = information;
	}
	public boolean isWarnings() {
		return warnings;
	}
	public void setWarnings(boolean warnings) {
		this.warnings = warnings;
	}
	public List<CcdaValidatorResultJsonView> getErrorList() {
		return errorList;
	}
	public void setErrorList(List<CcdaValidatorResultJsonView> errorList) {
		this.errorList = errorList;
	}
	public List<CcdaValidatorResultJsonView> getInformationList() {
		return informationList;
	}
	public void setInformationList(List<CcdaValidatorResultJsonView> informationList) {
		this.informationList = informationList;
	}
	public List<CcdaValidatorResultJsonView> getWarningList() {
		return warningList;
	}
	public void setWarningList(List<CcdaValidatorResultJsonView> warningList) {
		this.warningList = warningList;
	}

	
	
}
