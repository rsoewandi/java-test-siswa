package com.insura.response;

import org.springframework.http.HttpMethod;

public class ConnectorResponse {

	private String url;
	private HttpMethod method;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}

}
