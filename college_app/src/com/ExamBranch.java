package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ExamBranch {

	ArrayList<Students> students = new ArrayList<>();

	public ArrayList<Students> getStudents() {
		return students;
	}

	public void setStudent(ArrayList<Students> students) {
		this.students = students;
	}

	void addStudents(Students student) {
		students.add(student);
	}

	Students getById(int ID) {
		Iterator<Students> iter = students.iterator();
		Students curStudent = null;
		while (iter.hasNext()) {
			curStudent = iter.next();
			if (curStudent.getID() == ID)
				break;
		}
		return curStudent;
	}

	Semesters getByIdBySemester(int id, int semkey) {
		Iterator<Students> iter = students.iterator();
		Students curStudent = null;
		Semesters reqSem = null;
		while (iter.hasNext()) {
			curStudent = iter.next();
			if (curStudent.getID() == id) {
				reqSem = curStudent.getSemester().get(semkey);
				break;
			}
		}
		return reqSem;
	}

	int getByIdBysemesterPractical(int id, int semkey, int p) {
		Iterator<Students> iter = students.iterator();
		Students curStudent = null;
		int reqSem = 0;
		while (iter.hasNext()) {
			curStudent = iter.next();
			if (curStudent.getID() == id) {
				if (p == 1)
					reqSem = curStudent.getSemester().get(semkey).getPrac1();
				else
					reqSem = curStudent.getSemester().get(semkey).getPrac2();
				break;
			}
		}
		return reqSem;
	}

	void DisplayIDResults(int id) {
		boolean found = false;
		Iterator<Students> iter = students.iterator();
		Students curStudent = null;
		while (iter.hasNext()) {
			curStudent = iter.next();
			if (curStudent.getID() == id) {
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("no such student");
			return;
		}
		System.out.println("Student ID: " + id + "\tDepartment :" + curStudent.getDep());

		curStudent.getSemester().forEach((key, value) -> {
			System.out.println("Semester Id: " + key);
			System.out.println("\tMarks: ");
			System.out.println("\t\tSubject 1: " + value.getSub1());
			System.out.println("\t\tSubject 2: " + value.getSub1());
			System.out.println("\t\tSubject 3: " + value.getSub1());
			System.out.println("\t\tSubject 4: " + value.getSub1());
			System.out.println("\t\tPractical 1: " + value.getPrac1());
			System.out.println("\t\tPractical 2: " + value.getPrac2());
		});

	}

	void DisplaySemResult(int id, int semkey) {
		Iterator<Students> iter = students.iterator();
		boolean found = false;
		Students curStudent = null;
		Semesters reqSem = null;
		while (iter.hasNext()) {
			curStudent = iter.next();
			if (curStudent.getID() == id) {
				reqSem = curStudent.getSemester().get(semkey);
				if (reqSem == null) {
					System.out.println("no sem info");
					return;
				}
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("no such student/no sem info");
			return;
		}
		System.out.println("Student ID: " + id + "\tDeparment :" + curStudent.getDep());
		System.out.println("Semester Id: " + semkey);
		System.out.println("\tMarks: ");
		System.out.println("\t\tSubject 1: " + reqSem.getSub1());
		System.out.println("\t\tSubject 2: " + reqSem.getSub1());
		System.out.println("\t\tSubject 3: " + reqSem.getSub1());
		System.out.println("\t\tSubject 4: " + reqSem.getSub1());
		System.out.println("\t\tPractical 1: " + reqSem.getPrac1());
		System.out.println("\t\tPractical 2: " + reqSem.getPrac2());
	}

	void DisplaySpecificResult(int id, int semkey, int p) {
		Iterator<Students> iter = students.iterator();
		Students curStudent = null;
		Semesters reqSem = null;
		while (iter.hasNext()) {
			curStudent = iter.next();
			if (curStudent.getID() == id) {
				reqSem = curStudent.getSemester().get(semkey);
				break;
			}
		}
		System.out.println("Student ID: " + id + "\tDeparment :" + curStudent.getDep());
		System.out.println("Semester Id: " + semkey);
		System.out.println("\tMark: ");
		switch (p) {
		case 1: {
			System.out.println("\t\tSubject 1: " + reqSem.getSub1());
			break;
		}
		case 2: {
			System.out.println("\t\tSubject 2: " + reqSem.getSub1());
			break;
		}
		case 3: {
			System.out.println("\t\tSubject 3: " + reqSem.getSub1());
			break;
		}
		case 4: {
			System.out.println("\t\tSubject 4: " + reqSem.getSub1());
			break;
		}
		case 5: {
			System.out.println("\t\tPractical 1: " + reqSem.getPrac1());
			break;
		}
		case 6: {
			System.out.println("\t\tPractical 2: " + reqSem.getPrac2());
			break;
		}
		}
	}
}
