import linkedList.*;

/**
 * Represents a college, and college management operations.
 * A college has courses, and students. Students take courses and get grades.
 * (See the Course, Student, and CourseTaken classes for more details).
 */
public class College {
	
	
	private static String nl =  System.getProperty("line.separator");

	private String name; // the name of this college
	private LinkedList<Course> courses;
	private LinkedList<Student> students;
	
	/**
	 * Constructs a new college, with empty student and course lists.
	 */
	public College(String name) {
		this.name = name;
		this.courses = new LinkedList<Course>();
		this.students = new LinkedList<Student>();
	}
	
	/** 
	 * Adds the given course to the course list of this college.
	 * @param cid   course id.
	 * @param title course title.
	 */
	public void addCourse(int cid, String title) {
		// Put your code here
	}
	
	/**
	 * Prints a list of all the courses.
	 */
	public void coursesList() {
		System.out.println(courses);
	}

	/** 
	 * If the given course is in this college, removes it and returns true.
	 * Otherwise returns false.
	 * @param  cid the course to remove.
	 * @return True if the course was removed, false if there is no such course. 
	 */
	public boolean removeCourse(int cid) {
		// Replace the return statement with your code.
		// Note: You can get the course with the given cid by calling
		// the private getCourse method.
		return false;
	}
	
	// Returns the course that has the given id, or null if there is no such course.
	private Course getCourse(int cid) {
		// Replace the return statement with your code.
		return null;
	}
	
	/** 
	 * Adds the given student to the students list of this college.
	 * @param sid   student id
	 * @param name  student name
	 */
	public void addStudent(int sid, String name) {
		// Put your code here
	}
	
	/**
	 * Prints a list of all the students.
	 */
	public void studentsList() {
		System.out.println(students);
	}
	
	/** 
	 * If the given student is in this college, removes it and returns true.
	 * Otherwise returns false.
	 * @param  sid  the student's id.
	 * @return True if the student was removed, false if there is no such student. 
	 */
	public boolean removeStudent(int sid) {
		// Replace the return statement with your code.
		// Note: You can get the student with the given sid by calling
		// the private getStudent method.
		return false;
	}
	
	// Returns the student that has the given id, or null if there is no such student.
	private Student getStudent(int sid) {
		// Replace the return statement with your code.
		return null;
	}
	
	/** 
	 * Adds the given course to the course list of the given student.
	 * @param sid   student id
	 * @param cid   course id
	 * @param grade student's grade in the course 
	 */
	public void addCourseTaken(int sid, int cid, int grade) {
		// Put your code here.
	}
	
	/** 
	 * Prints the student report of the given student.
	 * See the Student class for more details.
	 * @param sid  student id
	 */
	public void studentReport(int sid) {
		// Put your code here
		// Your code should call the student's studentReport method
	}
	
	/**
	 * Prints a list of all the students who took the course with the given cid.
	 * @param cid  the course
	 */
	public void courseReport(int cid) {
		// Put your code here.
	}
	
	/** 
	 * Prints the number of students in the given course
	 * @param cid  course id
	 */
	public void printSize(int cid) {
		// Put your code here.
	}
	
	// Returns a list of all the students who took the given course
	private LinkedList<Student> studentsWhoTook(Course c) {
		// replace the following statement with your code.
		return null;
	}
	
	/** 
	 * Prints the student with the highest grade in the given course.
	 * @param cid  course id
	 */
	public void topPerfomerReport(int cid) {
		// Put your code here
	}

	/** 
	 * Returns the college name
	 * @return the college name 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * A textual representation of this college, along with its courses and students.
	 */
	public String toString() {
		String str = name + nl;
		str += "courses:" + nl;
		str += courses.toString() + nl;
		str += "students:" + nl;
		str += students.toString() + nl;
		return str;
	}
}
