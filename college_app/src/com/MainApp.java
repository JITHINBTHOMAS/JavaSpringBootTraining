package com;

import java.util.*;

public class MainApp {
	public static void main(String args[]) {

		Semesters s1 = new Semesters(1, 10, 20, 30, 40, 25, 35);
		Semesters s2 = new Semesters(2, 20, 30, 40, 50, 26, 36);
		Semesters s3 = new Semesters(3, 30, 40, 50, 60, 27, 37);
		Semesters s4 = new Semesters(4, 40, 50, 60, 70, 28, 38);
		Students student1 = new Students();
		student1.setID(101);
		student1.setDep("cs");
		student1.getSemester().put(s1.getSemId(), s1);
		student1.getSemester().put(s2.getSemId(), s2);
		student1.getSemester().put(s3.getSemId(), s3);
		student1.getSemester().put(s4.getSemId(), s4);

		ExamBranch branch = new ExamBranch();
		branch.addStudents(student1);
//System.out.println(branch.getStudents());
//System.out.println(branch.getById(101));
//System.out.println(branch.getByIdBySemester(101, 1));
//System.out.println(branch.getByIdBysemesterPractical(101, 1,2));

//branch.DisplayIDResults(102);
//branch.DisplaySemResult(101,7);
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			System.out.println(
					"choose an option: \n\t1. display all sem marks\n\t2. display selected sem marks\n\t3. display specific mark\n\t4. exit");
			option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.print("Enter ID: ");
				int id = sc.nextInt();
				branch.DisplayIDResults(id);
				break;
			}
			case 2: {
				System.out.print("Enter ID: ");
				int id = sc.nextInt();
				System.out.print("Enter semId: ");
				int semid = sc.nextInt();
				branch.DisplaySemResult(id, semid);
				break;
			}
			case 3: {
				System.out.print("Enter ID: ");
				int id = sc.nextInt();
				System.out.print("Enter semId: ");
				int semid = sc.nextInt();
				System.out.println("Choose from : sub1,sub2,sub3,sub4,prac1,prac2");
				String o = sc.next();
				switch (o) {
				case "sub1": {
					branch.DisplaySpecificResult(id, semid, 1);
					break;
				}
				case "sub2": {
					branch.DisplaySpecificResult(id, semid, 2);
					break;
				}
				case "sub3": {
					branch.DisplaySpecificResult(id, semid, 3);
					break;
				}
				case "sub4": {
					branch.DisplaySpecificResult(id, semid, 4);
					break;
				}
				case "prac1": {
					branch.DisplaySpecificResult(id, semid, 5);
					break;
				}
				case "prac2": {
					branch.DisplaySpecificResult(id, semid, 6);
					break;
				}
				default:
					System.out.println("Invalid option");
				}
				break;
			}
			}
		} while (option != 4);

		sc.close();
	}
}