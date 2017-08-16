package process;

import java.io.IOException;

import seminar.Seminar;
import seminar.SeminarPrinter;
import seminar.Student;

public class SeminarRequestProcess  {

	private SeminarPrinter _printer;
	private String _contentType;

	public SeminarRequestProcess(SeminarPrinter printer, String contentType) {
		_printer = printer;
		_contentType = contentType;
	}

	public void execute(Context context) {
		try {
			Seminar seminar = new Seminar("Math", "2", "Math Level 1", "Mendrisio", "25.12.2015", 20);
			seminar.addEnrollment(new Student("Mattia", "Cattaneo"));
			seminar.addEnrollment(new Student("Enrico", "Mazzi"));
			
			context.getHttpServletResponse().setContentType(_contentType);
			context.getHttpServletResponse().getWriter().write(_printer.render(seminar));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
