package seminar;

public class HtmlSeminarPrinter extends SeminarPrinter {


	@Override
	public String print(Seminar seminar) {
		String result = "";
		result += "<head>\n\t<title>" + seminar.getCourse()  + "</title>\n</head>\n";
		result += "<body>\n";
		result += "\t<div>" + seminar.getCourse() + " " + seminar.getNumber() + ":</div>\n";
		result += "\t<ul>\n";
		result += "\t\t<li>" + seminar.getCourseDescription() + "</li>\n";
		result += "\t\t<li>" + seminar.getLocation() + "</li>";
		result += "\t\t<li>" + seminar.getSeatsLeft() + "</li>";
		result += "\t\t<li>" + seminar.getStartDate() + "</li>";
		result += "\t</ul>\n";
		result += "<div>partecipanti:</div>\n";
		result += "\t<ul>\n";
		return result;
	}

	@Override
	public String print(Student student) {
		return "\t\t<li>" + student.getFirstname() + " " + student.getName() + "</li>\n";
	}

	@Override
	public String printHeader() {
		return "<html>\n";
	}

	@Override
	public String printFooter() {
		String result = "";
		result += "\t</ul>\n";
		result +=  "\t</body>\n";
		result +=  "</html>";
		return result;
	}

}
