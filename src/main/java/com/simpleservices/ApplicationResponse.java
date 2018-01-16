package com.simpleservices;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicationResponse {
	
	public ApplicationResponse(String appName, String appId, String appDescription) {
		super();
		this.appName = appName;
		this.appId = appId;
		this.appDescription = appDescription;
	}

	@JsonProperty
	private String appName;
	
	@JsonProperty
	private String appId;
	
	@JsonProperty
	private String appDescription;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppDescription() {
		return appDescription;
	}

	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}
	

	public ApplicationResponse() {
		super();
	}

	@Override
	public String toString() {
		return "ApplicationResponse [appName=" + appName + ", appId=" + appId + ", appDescription=" + appDescription
				+ "]";
	}
	
	
	
}
