package com;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

public class ServletTest {
	
	@Test
	public void testWrongUrl() throws ServletException, IOException {
		MyHttpServletReponse response = sendRequest("/wrong");
		assertThat(response.getOutput(), CoreMatchers.is("<h1>wrong url</h1>"));
	}

	@Test
	public void testCsvUrl() throws ServletException, IOException {
		MyHttpServletReponse response = sendRequest("/course/csv");
		assertThat(response.getOutput(), CoreMatchers.containsString("\"Mattia\";\"Cattaneo\""));
		assertThat(response.getContentType(), CoreMatchers.is("text/csv"));
	}
	
	@Test
	public void testRawUrl() throws ServletException, IOException {
		MyHttpServletReponse response = sendRequest("/course/raw");
		assertThat(response.getOutput(), CoreMatchers.containsString("Student: Mattia Cattaneo"));
		assertThat(response.getContentType(), CoreMatchers.is("text/plain"));
	}
	
	@Test
	public void testHtmlUrl() throws ServletException, IOException {
		MyHttpServletReponse response = sendRequest("/course/html");
		assertThat(response.getOutput(), CoreMatchers.containsString("<li>Mattia Cattaneo</li>"));
		assertThat(response.getContentType(), CoreMatchers.is("text/html"));
	}

	public MyHttpServletReponse sendRequest(String uri) throws ServletException, IOException {
		MyHttpServletRequest request = new MyHttpServletRequest(uri);
		MyHttpServletReponse response = new MyHttpServletReponse();
		Servlet servlet = new Servlet();
		servlet.doGet(request, response);
		return response;
	}


	
}
