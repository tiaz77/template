package seminar;

import java.io.File;

public class CsvSeminarPrinter extends SeminarPrinter {
	
	private File _output;
	
	public File result() {
		return _output;
	}

	@Override
	public String printHeader() {
		return "";
	}

	@Override
	public String print(Seminar seminar) {
		String result = "";
		result += "\"";
		result += seminar.getNumber();
		result += "\";\"";
		result += seminar.getCourse();
		result += "\";\"";
		result += seminar.getCourseDescription();
		result += "\";\"";
		result += seminar.getLocation();
		result += "\";\"";
		result += seminar.getSeatsLeft();
		result += "\";\"";
		result += seminar.getStartDate();
		result += "\"\n";
		
		return result;
	}

	@Override
	public String print(Student student) {
		String result = "";
		result += "\"";
		result += student.getFirstname();
		result += "\";\"";
		result += student.getName();
		result += "\"\n";
		
		return result;
	}

	@Override
	public String printFooter() {
		return "";
	}

}
