package org.sitenv.service.ccda.extendedvalidator.view;

import java.util.List;

public class CodeValidationResultJsonView {
	
	private CodeValidationRequestJsonView request;
	private Boolean codeExists;
	private Boolean displayNameExists;
	private Boolean displayNameMatchForCode;
	private List<String> displayNamesForCode;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codeExists == null) ? 0 : codeExists.hashCode());
		result = prime
				* result
				+ ((displayNameExists == null) ? 0 : displayNameExists
						.hashCode());
		result = prime
				* result
				+ ((displayNameMatchForCode == null) ? 0
						: displayNameMatchForCode.hashCode());
		result = prime * result + ((request == null) ? 0 : request.hashCode());
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
		CodeValidationResultJsonView other = (CodeValidationResultJsonView) obj;
		if (codeExists == null) {
			if (other.codeExists != null)
				return false;
		} else if (!codeExists.equals(other.codeExists))
			return false;
		if (displayNameExists == null) {
			if (other.displayNameExists != null)
				return false;
		} else if (!displayNameExists.equals(other.displayNameExists))
			return false;
		if (displayNameMatchForCode == null) {
			if (other.displayNameMatchForCode != null)
				return false;
		} else if (!displayNameMatchForCode
				.equals(other.displayNameMatchForCode))
			return false;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		return true;
	}
	public CodeValidationRequestJsonView getRequest() {
		return request;
	}
	public void setRequest(CodeValidationRequestJsonView request) {
		this.request = request;
	}
	public Boolean getCodeExists() {
		return codeExists;
	}
	public void setCodeExists(Boolean codeExists) {
		this.codeExists = codeExists;
	}
	public Boolean getDisplayNameExists() {
		return displayNameExists;
	}
	public void setDisplayNameExists(Boolean displayNameExists) {
		this.displayNameExists = displayNameExists;
	}
	public Boolean getDisplayNameMatchForCode() {
		return displayNameMatchForCode;
	}
	public void setDisplayNameMatchForCode(Boolean displayNameMatchForCode) {
		this.displayNameMatchForCode = displayNameMatchForCode;
	}
	public List<String> getDisplayNamesForCode() {
		return displayNamesForCode;
	}
	public void setDisplayNamesForCode(List<String> displayNamesForCode) {
		this.displayNamesForCode = displayNamesForCode;
	}	
	
}
