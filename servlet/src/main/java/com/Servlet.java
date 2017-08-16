package com;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import process.Context;
import process.SeminarRequestProcess;
import seminar.CsvSeminarPrinter;
import seminar.HtmlSeminarPrinter;
import seminar.RawSeminarPrinter;

public class Servlet extends HttpServlet {

	private final HashMap<String, SeminarRequestProcess> _process;

	public Servlet() {
		_process = new HashMap<String,SeminarRequestProcess>();
		_process.put("/course/html", new SeminarRequestProcess(new HtmlSeminarPrinter(), "text/html"));
		_process.put("/course/csv", new SeminarRequestProcess(new CsvSeminarPrinter(), "text/csv"));
		_process.put("/course/raw", new SeminarRequestProcess(new RawSeminarPrinter(), "text/plain"));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Context context = new Context();
		context.setHttpServletRequest(req);
		context.setHttpServletResponse(resp);
		
		if (_process.containsKey(req.getRequestURI())) {
			_process.get(req.getRequestURI()).execute(context);
		} else {
			resp.getWriter().write("<h1>wrong url</h1>");
		}
		
		
		
	}
}
