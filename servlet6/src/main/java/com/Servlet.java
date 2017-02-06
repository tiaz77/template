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

	private final HashMap<String, SeminarPrinter> _routes;

	public Servlet() {
		_routes = new HashMap<String,SeminarPrinter>();
		_routes.put("/course/html", new HtmlSeminarPrinter());
		_routes.put("/course/csv", new CsvSeminarPrinter());
		_routes.put("/course/raw", new RawSeminarPrinter());
	}	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
		Seminar seminar = new Seminar("Math", "2", "Math Level 1", "Mendrisio", "25.12.2015", 20);
		seminar.addEnrollment(new Student("Mattia", "Cattaneo"));
		seminar.addEnrollment(new Student("Enrico", "Mazzi"));
		
		
		if (_routes.containsKey(req.getRequestURI())) {
			resp.getWriter().write(_routes.get(req.getRequestURI()).render(seminar));
			return;
		}
		
		if (req.getRequestURI().equals("/try/me")) {
			resp.getWriter().write("<h1>you did it!</h1>");
			return;
		}

		if (req.getRequestURI().equals("/try/bootstrap")) {
			resp.getWriter()
					.write("<!DOCTYPE html>                                                                                                                                 "
							+ "<html lang='en'>                                                                                                                                "
							+ "  <head>                                                                                                                                        "
							+ "    <meta charset='utf-8'>                                                                                                                      "
							+ "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>                                                                                       "
							+ "    <meta name='viewport' content='width=device-width, initial-scale=1'>                                                                        "
							+ "    <title>Seminar</title>                                                                                      								 "
							+ "    <link rel='stylesheet' href='/css/bootstrap.min.css'>                                        												 "
							+ "  </head>                                                                                                                                       "
							+ "  <body>                                                                                                                                        "
							+ "  	<div class='container'>                                                                                                                      "
							+ "  		<div class='row'>                                                                                                                        "
							+ "  			<div class='col-md-6 col-md-offset-3'>                                                                                               "
							+ "  				<h1 class='page-header text-center'>Contact Form Example</h1>                                                                    "
							+ "				<form class='form-horizontal' role='form' method='post' action=''>                                                      		 "
							+ "					<div class='form-group'>                                                                                                     "
							+ "						<label for='name' class='col-sm-2 control-label'>Name</label>                                                            "
							+ "						<div class='col-sm-10'>                                                                                                  "
							+ "							<input type='text' class='form-control' id='name' name='name' placeholder='First & Last Name' value='Name'>          "
							+ "						</div>                                                                                                                   "
							+ "					</div>                                                                                                                       "
							+ "					<div class='form-group'>                                                                                                     "
							+ "						<label for='email' class='col-sm-2 control-label'>Email</label>                                                          "
							+ "						<div class='col-sm-10'>                                                                                                  "
							+ "							<input type='email' class='form-control' id='email' name='email' placeholder='example@domain.com' value='Mail'>      "
							+ "						</div>                                                                                                                   "
							+ "					</div>                                                                                                                       "
							+ "					<div class='form-group'>                                                                                                     "
							+ "						<div class='col-sm-10 col-sm-offset-2'>                                                                                  "
							+ "							<input id='submit' name='submit' type='submit' value='Send' class='btn btn-primary'>                                 "
							+ "						</div>                                                                                                                   "
							+ "					</div>                                                                                                                       "
							+ "				</form>                                                                                                                          "
							+ "			</div>                                                                                                                               "
							+ "		</div>                                                                                                                                   "
							+ "	</div>                                                                                                                                       "
							+ "    <script src='/js/jquery.min.js'></script>                                                   												 "
							+ "    <script src='/js/bootstrap.min.js'></script>                                                 												 "
							+ "</body> ");
			
			return;
		}

	}
}
