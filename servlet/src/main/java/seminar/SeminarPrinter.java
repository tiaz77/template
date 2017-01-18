package seminar;

public abstract class SeminarPrinter {
	public String render(Seminar seminar) {
		String result = "";
		
		result += printHeader();
		result += print(seminar);
		
		for (Student student : seminar.getStudents()) {
			result += print(student);
		}
		result += printFooter();
		
		return result;
	}
	
	public abstract String printHeader();
	public abstract String print(Seminar seminar);
	public abstract String print(Student student);
	public abstract String printFooter();
}