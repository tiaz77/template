package seminar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Seminar {

	private String _location;
	private List<Student> _enrollments = new ArrayList<Student>();
	private String _name;
	private String _number;
	private String _description;
	private int _seats;
	private String _startDate;
	
	
	public Seminar(String name, String number, String description, String location, String startDate, int seats) {
		_name = name;
		_number = number;
		_description = description;
		_location = location;
		_startDate = startDate;
		_seats = seats;
	}

	public void addEnrollment(Student student) {
		if (_seats - _enrollments.size() > 0) {
			_enrollments.add(student);
		}
	}
	
	public String render(SeminarPrinter printer) {
		return printer.render(this);

	}

	
	public int getSeatsLeft() {
		return _seats - _enrollments.size();
	}

	

	public Collection<Student> getStudents() {
		return _enrollments;
	}

	public String getCourse() {
		return _name;
	}

	public String getCourseDescription() {
		return _description;
	}

	public String getLocation() {
		return _location;
	}

	public String getNumber() {
		return _number;
	}
	
	public String getStartDate() {
		return _startDate;
	}


}
