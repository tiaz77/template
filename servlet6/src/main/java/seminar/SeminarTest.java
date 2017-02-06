package seminar;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class SeminarTest {

	
	private Seminar _seminar;

	@Before
	public void init() {
		_seminar = new Seminar("Math", "2", "Math Level 1", "Mendrisio", "25.12.2015", 20);
		_seminar.addEnrollment(new Student("Mattia", "Cattaneo"));
		_seminar.addEnrollment(new Student("Enrico", "Mazzi"));
	}

	@Test
	public void test() {
		assertEquals("Seminar: Math 2\nDescription: Math Level 1\nLocation: Mendrisio\nSeats left: 18\nStart date: 25.12.2015\nStundent: Mattia Cattaneo\nStundent: Enrico Mazzi\n", 
				_seminar.render(new RawSeminarPrinter()));
	}
	
	@Test
	public void testHtml() {
		assertEquals("<html>\n"
				+ "<head>\n\t<title>Math</title>\n</head>\n"
				+ "<body>\n"
				+ "\t<div>Math 2:</div>\n"
				+ "\t<ul>\n"
				+ "\t\t<li>Math Level 1</li>\n"
				+ "\t\t<li>Mendrisio</li>"
				+ "\t\t<li>18</li>"
				+ "\t\t<li>25.12.2015</li>"
				+ "\t</ul>\n"
				+ "<div>partecipanti:</div>\n"
				+ "\t<ul>\n"
				+ "\t\t<li>Mattia Cattaneo</li>\n"
				+ "\t\t<li>Enrico Mazzi</li>\n"
				+ "\t</ul>\n"
				+ "\t</body>\n"
				+ "</html>", _seminar.render(new HtmlSeminarPrinter()));
	}
	
	@Test
	public void testCsv() throws FileNotFoundException {
		assertEquals("\"2\";\"Math\";\"Math Level 1\";\"Mendrisio\";\"18\";\"25.12.2015\"\n" +
				"\"Mattia\";\"Cattaneo\"\n" +
				"\"Enrico\";\"Mazzi\"\n", _seminar.render(new CsvSeminarPrinter()));
		
	}
	

}
