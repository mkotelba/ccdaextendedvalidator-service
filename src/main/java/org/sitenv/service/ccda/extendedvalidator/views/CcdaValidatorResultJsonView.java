package org.sitenv.service.ccda.extendedvalidator.views;

public class CcdaValidatorResultJsonView {

	private String message;
	private String code;
	private String xpathExpression;
	private String codeSystem;
	private String codeSystemName;
	private String displayName;
	private Integer nodeIndex;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((codeSystem == null) ? 0 : codeSystem.hashCode());
		result = prime * result
				+ ((codeSystemName == null) ? 0 : codeSystemName.hashCode());
		result = prime * result
				+ ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result
				+ ((nodeIndex == null) ? 0 : nodeIndex.hashCode());
		result = prime * result
				+ ((xpathExpression == null) ? 0 : xpathExpression.hashCode());
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
		CcdaValidatorResultJsonView other = (CcdaValidatorResultJsonView) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (codeSystem == null) {
			if (other.codeSystem != null)
				return false;
		} else if (!codeSystem.equals(other.codeSystem))
			return false;
		if (codeSystemName == null) {
			if (other.codeSystemName != null)
				return false;
		} else if (!codeSystemName.equals(other.codeSystemName))
			return false;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (nodeIndex == null) {
			if (other.nodeIndex != null)
				return false;
		} else if (!nodeIndex.equals(other.nodeIndex))
			return false;
		if (xpathExpression == null) {
			if (other.xpathExpression != null)
				return false;
		} else if (!xpathExpression.equals(other.xpathExpression))
			return false;
		return true;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getXpathExpression() {
		return xpathExpression;
	}
	public void setXpathExpression(String xpathExpression) {
		this.xpathExpression = xpathExpression;
	}
	public String getCodeSystem() {
		return codeSystem;
	}
	public void setCodeSystem(String codeSystem) {
		this.codeSystem = codeSystem;
	}
	public String getCodeSystemName() {
		return codeSystemName;
	}
	public void setCodeSystemName(String codeSystemName) {
		this.codeSystemName = codeSystemName;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public Integer getNodeIndex() {
		return nodeIndex;
	}
	public void setNodeIndex(Integer nodeIndex) {
		this.nodeIndex = nodeIndex;
	}
	
	
	
	
	
}
