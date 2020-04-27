package com.gmail.nelya;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Comisariat, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Student> students = new ArrayList<Student>(10);
	private String groupName;

	public Group(ArrayList<Student> students, String groupName) {
		super();
		this.students = students;
		this.groupName = groupName;
	}

	public Group() {
		super();
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void addStudent(Student st) throws ExcessException {
		if (st == null) {
			throw new IllegalArgumentException();
		}
		if (students.size() < 10) {
			students.add(st);
			st.setGroupName(this.groupName);
			System.out.println("You have added the student " + st + " in group " + st.getGroupName());
			return;
		}
		throw new ExcessException();
	}

	public boolean removeStudent(int recNumber) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i) != null && students.get(i).getRecNumber() == recNumber) {
				students.remove(i);
				return true;
			}
		}
		return false;
	}

	public Student findStudent(String lastName) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i) != null && students.get(i).getLastName().equals(lastName)) {
				return students.get(i);
			}
		}
		return null;
	}

	public void printGroup() {
		for (Student st : students) {
			System.out.println(st);
		}
	}

	public void sortArray(ArrayList<Student> students) {
		int sortedIndex = students.size();
		int numberOfSwap = 1;
		while (numberOfSwap > 0) {
			numberOfSwap = 0;
			for (int i = 0; i < sortedIndex - 1; i++) {
				if ((students.get(i).getFirstName().compareTo(students.get(i + 1).getFirstName())) > 0) {
					Student temp = students.get(i);
					students.set(i, students.get(i + 1));
					students.set(i + 1, temp);
					numberOfSwap += 1;
				}
			}
			sortedIndex -= 1;
		}
	}

	@Override
	public ArrayList<Student> getRecruter() {
		ArrayList<Student> recruterStudents = new ArrayList<Student>();
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i) != null && students.get(i).getAge() > 17 && students.get(i).getGender() == "male") {
				recruterStudents.add(students.get(i));
			}
		}
		return recruterStudents;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Student student : students) {
			if (student != null) {
				sb.append(student);
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}
}
