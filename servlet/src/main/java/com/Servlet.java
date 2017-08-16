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
		} else if(req.getRequestURI().equals("/try/bootstrap")){
			resp.getWriter().write(
								    "<!DOCTYPE html>                                                                                                                                 " +
								    "<html lang='en'>                                                                                                                                " +
								    "  <head>                                                                                                                                        " +
								    "    <meta charset='utf-8'>                                                                                                                      " +
								    "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>                                                                                       " +
								    "    <meta name='viewport' content='width=device-width, initial-scale=1'>                                                                        " +
								    "    <title>Seminar</title>                                                                                      								 " +
								    "    <link rel='stylesheet' href='/css/bootstrap.min.css'>                                        												 " +
								    "  </head>                                                                                                                                       " +
								    "  <body>                                                                                                                                        " +
								    "  	<div class='container'>                                                                                                                      " +
								    "  		<div class='row'>                                                                                                                        " +
								    "  			<div class='col-md-6 col-md-offset-3'>                                                                                               " +
								    "  				<h1 class='page-header text-center'>Contact Form Example</h1>                                                                    " +
								    "				<form class='form-horizontal' role='form' method='post' action='index.php'>                                                      " +
								    "					<div class='form-group'>                                                                                                     " +
								    "						<label for='name' class='col-sm-2 control-label'>Name</label>                                                            " +
								    "						<div class='col-sm-10'>                                                                                                  " +
								    "							<input type='text' class='form-control' id='name' name='name' placeholder='First & Last Name' value='Name'>          " +
								    "						</div>                                                                                                                   " +
								    "					</div>                                                                                                                       " +
								    "					<div class='form-group'>                                                                                                     " +
								    "						<label for='email' class='col-sm-2 control-label'>Email</label>                                                          " +
								    "						<div class='col-sm-10'>                                                                                                  " +
							        "							<input type='email' class='form-control' id='email' name='email' placeholder='example@domain.com' value='Lastname'>  " +
								    "						</div>                                                                                                                   " +
								    "					</div>                                                                                                                       " +
								    "					<div class='form-group'>                                                                                                     " +
								    "						<div class='col-sm-10 col-sm-offset-2'>                                                                                  " +
								    "							<input id='submit' name='submit' type='submit' value='Send' class='btn btn-primary'>                                 " +
								    "						</div>                                                                                                                   " +
								    "					</div>                                                                                                                       " +
								    "				</form>                                                                                                                          " +
								    "			</div>                                                                                                                               " +
								    "		</div>                                                                                                                                   " +
								    "	</div>                                                                                                                                       " +
								    "    <script src='/js/jquery.min.js'></script>                                                   												 " +
								    "    <script src='/js/bootstrap.min.js'></script>                                                 												 " +
								    "</body> "
							    );
		} else {
			resp.getWriter().write("<h1>wrong url</h1>");
		}
		
		
		
	}
}
