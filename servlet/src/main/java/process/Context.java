package process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Context {

	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;

	public void setHttpServletRequest(HttpServletRequest request) {
		_httpServletRequest = request;
	}

	public void setHttpServletResponse(HttpServletResponse response) {
		_httpServletResponse = response;
	}
	
	public HttpServletRequest getHttpServletRequest() {
		return _httpServletRequest;
	}
	
	public HttpServletResponse getHttpServletResponse() {
		return _httpServletResponse;
	}

}
