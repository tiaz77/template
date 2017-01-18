package seminar;

public class Student {
	
	private String _lastname;
	private String _firstname;

	public Student(String lastname, String firstname) {
		_firstname = lastname;
		_lastname = firstname;
	}

	public String getName() {
		return _lastname;
	}


	public String getFirstname() {
		return _firstname;
	}

}
