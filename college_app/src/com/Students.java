package com;

import java.util.HashMap;
import com.Semesters;

public class Students {

	private int ID;
	private String Dep;
	private HashMap<Integer, Semesters> semester = new HashMap<>();

	public Students() {
	}

	public void setID(int ID) {
		this.ID = ID;

	}

	public void setDep(String Dep) {
		this.Dep = Dep;
	}

	public void setSemester(HashMap<Integer, Semesters> semester) {
		this.semester = semester;
	}

	public int getID() {
		return ID;
	}

	public String getDep() {
		return Dep;
	}

	public HashMap<Integer, Semesters> getSemester() {
		return semester;
	}

	public String toString() {
		return "Students = [ID :" + ID + ",Department :" + Dep + ",Semester :" + semester + "]";
	}
}