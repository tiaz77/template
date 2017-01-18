package com;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seminar.CsvSeminarPrinter;
import seminar.HtmlSeminarPrinter;
import seminar.RawSeminarPrinter;
import seminar.Seminar;
import seminar.SeminarPrinter;
import seminar.Student;

public class Servlet extends HttpServlet {

	private HashMap<String, SeminarPrinter> _routes;

	public Servlet() {
		_routes = new HashMap<String,SeminarPrinter>();
		_routes.put("/course/html", new HtmlSeminarPrinter());
		_routes.put("/course/csv", new CsvSeminarPrinter());
		_routes.put("/course/raw", new RawSeminarPrinter());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Seminar seminar = new Seminar("Math", "2", "Math Level 1", "Mendrisio", "25.12.2015", 20);
		seminar.addEnrollment(new Student("Mattia", "Cattaneo"));
		seminar.addEnrollment(new Student("Enrico", "Mazzi"));
		
		
		if (_routes.containsKey(req.getRequestURI())) {
			resp.getWriter().write(_routes.get(req.getRequestURI()).render(seminar));
		} else {
			resp.getWriter().write("<h1>wrong url</h1>");
			
		}
		
		
		
	}
}
