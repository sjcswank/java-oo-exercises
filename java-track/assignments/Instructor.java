import java.util.*;

public class Instructor {
	private List<Course> courseList = new ArrayList<Course>();
	private String firstName;
	private String lastName;
	private String degree;
	
	public Instructor(String firstName, String lastName, String degree){
		this.firstName = firstName;
		this.lastName = lastName;
		this.degree = degree;
	}
	
	public List<Course> getCourse(){
		return this.courseList;
	}
	
	public String getName(){
		return this.firstName + this.lastName;
	}
	
	public String getDegree(){
		return this.degree;
	}
	
	public void createCourse(String name, int credits, int seats){
		//create course
		Course newCourse = new Course(name, credits, seats);
		newCourse.setInstructor(this);
		//append courseList
		this.courseList.add(newCourse);
		
	}
	
	public void removeCourse(Course course){
		Iterator<Course> it = this.courseList.iterator();
		while (it.hasNext()){
			Course c = it.next();
			if (c.equals(course)){
				it.remove();
			}
		}
	}
	
	public void addCourse(Course course){
		this.courseList.add(course);
		course.setInstructor(this);
	}
	
	public void setName(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void setDegree(String degree){
		this.degree = degree;
	}
	
	public String makeCourseList(){
		String response = "";
		Iterator<Course> it = this.courseList.iterator();
		while (it.hasNext()){
			Course c = it.next();
			response += c.toString() + "\n";
		}
		return response;
	}
	
	public String toString(){
		return this.lastName + ", " + this.firstName + " " + this.degree;
	}
}
