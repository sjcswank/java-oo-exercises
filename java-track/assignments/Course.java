
public class Course {
	private String name;
	private int credits;
	private int remainingSeats;
	private Student[] enrolledStudents;
	private Instructor instructor;
	
	//Constructor
	public Course(String name, int credits, int seats) {
		this.name = name;
		this.credits = credits;
		this.enrolledStudents = new Student[seats];
		this.remainingSeats = seats;
	}
	
	//getters
	public String getName(){
		return this.name;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public int getRemainingSeats(){
		return this.remainingSeats;
	}
	
	public Student[] getEnrolledStudents(){
		return this.enrolledStudents;
	}
	
	public Instructor getInstructor(){
		return this.instructor;
	}
	
	public boolean addStudent(Student newStudent) {
		boolean enrolled = false;
		boolean added = false;
		
		if (this.remainingSeats > 0){
			//check if enrolled by name
				for (int i = 0; i < this.enrolledStudents.length; i++) {
					if (this.enrolledStudents[i] != null && this.enrolledStudents[i].getName().equals(newStudent.getName())){
						enrolled = true;
					}
				}
		
			//add to array
			outerloop:
			if (enrolled == false) {
				for (int i = 0; i < this.enrolledStudents.length; i++) {
					if (this.enrolledStudents[i] == null) {
						this.enrolledStudents[i] = newStudent;
						added = true;
						this.remainingSeats -= 1;
						break outerloop;
					}
				}
			}
		
			else {
				added = false;
			}
		}
		return added;
	}
	
	//generate String of students enrolled in course
	public String makeRoster() {
		String response ="";
		for (int i = 0; i < this.enrolledStudents.length; i++)
			if (this.enrolledStudents[i] != null){
				response += this.enrolledStudents[i].getName() + "\n";
			}
		return response;
	}
	
	public double averageGPA() {
		int students = 0;
		double gpa = 0;
		for (int i = 0; i < this.enrolledStudents.length; i++){
			if (this.enrolledStudents[i] != null){
				students += 1;
				gpa += this.enrolledStudents[i].getGPA();
			}
		}
	return gpa/students;
	}
	
	public void setInstructor(Instructor instructor){
		this.instructor = instructor;
	}
	
	public String toString() {
		return "Course: " + this.getName() + " Credits: " + this.getCredits() + " Instructor: " + this.instructor;
	}

}
