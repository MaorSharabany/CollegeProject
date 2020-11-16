package College;

import LinkedList.ListIterator;
import LinkedList.LinkedList;


/**
 * Represents a college, and college management operations.
 * A college has courses, and students. Students take courses and get grades.
 * (See the Course, Student, and CourseTaken classes for more details).
 */

public class College {
	
	private static String nl = System.getProperty("line.separator");
	
	private String name;                     // The name of this college
	private LinkedList<Course> courses;      // List of courses in this college
	private LinkedList<Student> students;    // List of students in this college
	
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
		//List Iterator check whether this course already added to the courseList
		ListIterator<Course> itr = courses.iterator();
		Course currentCourse;
		while(itr.hasNext()) {
			currentCourse = itr.next();
			if(currentCourse.getCid() == cid) {
				return;
			}
		}
		if(!itr.hasNext()) {
			courses.add(new Course(cid, title));
		}
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
		// check whether the course is in this college
		// if so, remove the course from this college
		// and also remove the course from all the student's CourseTaken lists
		Course c = getCourse(cid);
		if(c != null) {
			courses.remove(c);
			ListIterator<Student> itr = students.iterator();
			Student student;
			while(itr.hasNext()) {
				student = itr.next();
				if(student.tookCourse(c)) {
					student.removeCourseFromCL(c);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 *  Returns the course that has the given id, or null if there is no such course.
	 */	
	private Course getCourse(int cid) {
		ListIterator<Course> itr = courses.iterator();
		Course currentCourse;
		while(itr.hasNext()) {
			currentCourse = itr.next();
			if(currentCourse.getCid() == cid) {
				return currentCourse;
			}
		}
		return null;
	}

	/** 
	 * Adds the given student to the students list of this college.
	 * @param sid   student id
	 * @param name  student name
	 */
	public void addStudent(int sid, String name) {
		ListIterator<Student> itr = students.iterator();
		Student currentStudent;
		while(itr.hasNext()) {
			currentStudent = itr.next();
			if(currentStudent.getSid() == sid) {
				return;
			}
		}
		if(!itr.hasNext()) {
			students.add(new Student(sid, name));
		}
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
		if(getStudent(sid) != null) {
			students.remove(getStudent(sid));
			return true;
		}
		return false;
	}

	// Returns the student that has the given id, or null if there is no such student.
	private Student getStudent(int sid) {
		ListIterator<Student> itr = students.iterator();
		Student currentStudent;
		while(itr.hasNext()) {
			currentStudent = itr.next();
			if(currentStudent.getSid() == sid) {
				return currentStudent;
			}
		}
		return null;
	}

	/** 
	 * Adds the given course to the course list of the given student.
	 * @param sid   student id
	 * @param cid   course id
	 * @param grade student's grade in the course 
	 */
	public void addCourseTaken(int sid, int cid, int grade) {
		getStudent(sid).addCourse(getCourse(cid), grade);
	}

	/** 
	 * Prints the student report of the given student.
	 * See the Student class for more details.
	 * @param sid  student id
	 */
	public void studentReport(int sid) {
	    Student student = getStudent(sid);
	    if(student != null) {
		student.studentReport();
	    }
	}

	/**
	 * Prints a list of all the students who took the course with the given cid.
	 * @param cid  the course
	 */
	public void courseReport(int cid) {
		if(getCourse(cid) == null) {
			System.out.println("No such course");
		}
		studentsWhoTook(getCourse(cid));
	}

	/** 
	 * Prints the number of students in the given course
	 * @param cid  course id
	 */
	public void printSize(int cid) {
		int count = 0;
		ListIterator<Student> itr = students.iterator();
		Student currentStudent;
		while(itr.hasNext()) {
			currentStudent = itr.next();
			if(currentStudent.tookCourse(getCourse(cid))) {
				count++;	
			}
		}
		System.out.println(count);
	}

	// Returns a list of all the students who took the given course
	private LinkedList<Student> studentsWhoTook(Course c) {
		String str = "";
		int count = 1;
		ListIterator<Student> itr = students.iterator();
		Student currentStudent;
		while(itr.hasNext()) {
			currentStudent = itr.next();
			if(currentStudent.tookCourse(c)) {
				str += count + ")" + currentStudent.getName() + nl;
				count++;
			}
		}
		if(str != "") {
			System.out.println(str);
		}else {
			System.out.println("No student took this course");
		}
		return null;
	}

	/** 
	 * Prints the student with the highest grade in the given course.
	 * @param cid  course id
	 */
	public void topPerfomerReport(int cid) {
		if(getCourse(cid) == null) {
			System.out.println("No such course");
		}
		int highestGrade = 0;
		Student currentStudent;
		Student bestStudent = null;
		ListIterator<Student> itr = students.iterator();
		while(itr.hasNext()) {
			currentStudent = itr.next();
			if(currentStudent.tookCourse(getCourse(cid))) {
				if(currentStudent.gradeInCourse(getCourse(cid)) > highestGrade) {
					highestGrade = currentStudent.gradeInCourse(getCourse(cid));
					bestStudent = currentStudent;
				}
			}
		}
		if(bestStudent != null) {
			System.out.println("Top performance student is: " + bestStudent.getName());
		}
	}

	/** 
	 * Returns the college name
	 * @return the college name 
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * A textual representation of this college, along with its courses and students.
	 */
	public String toString() {
		String str = this.name  + nl;
		str += "courses:" + nl;
		str += courses.toString() + nl;
		str += "students:" + nl;
		str += students.toString() + nl;
		return str;
	}
}
