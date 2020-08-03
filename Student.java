package College;

import LinkedList.*;

/** 
 * Represents a student.
 */

public class Student {	
	private int sid;                             //The student's id
	private String name;                         //The student's name
	private LinkedList<CourseTaken> courseList;  //The student's courses
	
	/** 
	 * Constructs a new student with the given sid and name, and an empty course list.
	 * @param sid  the student's sid
	 * @param name the student's name
	 */
	public Student(int sid, String name) {	
		this.sid = sid;
		this.name = name;
		courseList = new LinkedList<CourseTaken>();
	}
	
	/** 
	 * Returns the sid of this student.
	 * @return the sid of this student.
	 */
	public int getSid() {	
		return sid;
	}
	
	/** 
	 * Returns the name of this student.
	 * @return the name of this student.
	 */
	public String getName() {	
		return name;
	}
	
	/** 
	 * Adds the given course and grade to the course list of this student.
	 * @param c     the course to add
	 * @param grade the grade in the added course 
	 */
	public void addCourse(Course c, int grade) {	
		// the method allows to handle double added course with different grades 
		ListIterator<CourseTaken> itr = courseList.iterator();
		CourseTaken course;
		CourseTaken newCourse = new CourseTaken(c, grade);
		while(itr.hasNext()) {
			course = itr.next();
			if(course.getCourse() == c) {
				courseList.remove(course);
				courseList.add(newCourse);
				return;
			}
		}
		if(!itr.hasNext()) {		
			courseList.add(newCourse);
		}
	}
		
	
	/** 
	 * Returns the grade that this student got in the given course, 
	 *  or -1 if the course was not taken by this student.
	 * @param c - the returned grade will be the grade in this course.
	 * @return the grade that this student got in the given course
	 */
	public int gradeInCourse(Course c) {	
		ListIterator<CourseTaken> itr = courseList.iterator();
		CourseTaken currentCourse;
		while(itr.hasNext()) {
			currentCourse = itr.next();
			if(currentCourse.getCourse() == c) {
				return currentCourse.getGrade();
			}
		}	
		return -1;
	}
	
	/** 
	 * Returns true if this student took the given course, false otherwise.
	 * @param c  the course we want to know whether or not the student took.
	 * @return true if this student took the given course, false otherwise.
	 */
	public boolean tookCourse(Course c) {
		ListIterator<CourseTaken> itr = courseList.iterator();
		CourseTaken currentCourse;
		while(itr.hasNext()) {
			currentCourse = itr.next();
			if(currentCourse.getCourse() == c) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Prints this student, all the courses that s/he took, and the grade point average.
	 */
	public void studentReport() {
		int sumGrades = 0, count = 0;
		double GPA = 0;
		System.out.println(this.name + ": ");
		ListIterator<CourseTaken> itr = courseList.iterator();
		CourseTaken currentCourse;
		while(itr.hasNext()) {
			currentCourse = itr.next();
			System.out.println(currentCourse.getCourse().getTitle() + ": " + currentCourse.getGrade());
			sumGrades += currentCourse.getGrade();
			count++;
		}
		
		// try/catch method handle an exception of type: 'ArithmeticException' if the student did'nt take any course yet
		try {
			GPA = sumGrades/count;
			System.out.println("Grade point average: " + GPA);
		}
		catch(ArithmeticException e) {
			System.out.println("The student did'nt take any course yet! ");
		}
	}
	
	/**
	 * remove course from the courselist of this student
	 * @param c - the course to remove
	 */
	public boolean removeCourseFromCL(Course c) {
		ListIterator<CourseTaken> itr = courseList.iterator();
		CourseTaken course;
		while(itr.hasNext()) {
			course = itr.next();
			if(course.getCourse() == c) {
				courseList.remove(course);
				return true;
			}
		}
		return false;
	}
				
	/**
	 * Textual representation of this student.
	 */
	public String toString() {
		return "Student " + sid + ": " + name;
	}
}



