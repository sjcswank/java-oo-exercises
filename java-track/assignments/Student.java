
public class Student {
	
	private String _firstName;
	private String _lastName;
	private int _id;
	private int _credits = 0;
	private double _gpa = 0.0;
	
	public Student(String firstName, String lastName, Integer id) {
		this._firstName = firstName;
		this._lastName = lastName;
		this._id = id;
		
	}
	
	//getters
	public String getFirstName() {
		return this._firstName;
	}
	
	public String getLastName() {
		return this._lastName;
	}
	
	public String getName() {
		return this._firstName + " " + this._lastName;
	}
	
	public int getStudentID() {
		return this._id;
	}
	
	public int getCredits() {
		return this._credits;
	}
	
	public double getGPA() {
		return this._gpa;
	}
	
	//basic setters
	public void setName(String newFirstName, String newLastName) {
		this._firstName = newFirstName;
		this._lastName = newLastName;
	}
	
	public void setCredits(int newCredits) {
		this._credits = newCredits;
	}
	
	public void setGpa(double newGpa) {
		this._gpa = newGpa;
	}
	
	//can-dos
	public String getClassStanding() {
		String standing;
		if (this._credits < 30) {
			standing = "Freshman";
		}
		else if (this._credits >= 30 && this._credits < 60) {
			standing = "Sophomore";
		}
		else if (this._credits >= 60 && this._credits < 90) {
			standing = "Junior";
		}
		else {
			standing = "Senior";
		}
		return standing;
	}
	
	public void submitGrade(double grade, int credits) {
		double classQualityScore = grade * credits;
		double totalQualityScore = this._gpa * this._credits;
		totalQualityScore = totalQualityScore + classQualityScore;
		this._credits += credits;
		double totalGPA = Math.round((totalQualityScore / this._credits * 1000))/1000.0;
		this._gpa = totalGPA;
	}
	
	public double computeTuition() {
		double tuition;
		if (this._credits % 15 != 0) {
			tuition = 20000.00 * Math.round(this._credits/15) + (Math.round(((this._credits % 15) * 1333.33)*100) / 100.00); 
		}
		else {
			tuition = 20000 * this._credits / 15;
		}
		return tuition;
	}
	
	public Student createLegacy(Student b) {
		String legacyFirstName = this.getName();
		String legacyLastName = b.getName();
		int legacyStudentID = this.getStudentID() + b.getStudentID();
		
		Student legacy = new Student(legacyFirstName, legacyLastName, legacyStudentID);
		legacy.setGpa((this._gpa + b.getGPA()) / 2.0);
		legacy.setCredits((int) Math.max(this.getCredits(), b.getCredits()));
		
		return legacy;
	}
	
	//to string
	public String toString() {
		return "Name: " + this.getLastName() + ", " + this.getFirstName() + " ID: " + this.getStudentID();
	}
	

}
