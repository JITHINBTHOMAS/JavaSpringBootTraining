package com;

public class Semesters{

private int semId;
private int sub1;
private int sub2;
private int sub3;
private int sub4;
private int prac1;
private int prac2;

public Semesters(){}

public Semesters(int semId,int sub1,int sub2,int sub3,int sub4,int prac1,int prac2){
this.semId = semId;
this.sub1 = sub1;
this.sub2 = sub2;
this.sub3 = sub3;
this.sub4 = sub4;
this.prac1 = prac1;
this.prac2 = prac2;
}
public void setSemId(int semId){
this.semId = semId;
}
public void setSub1(int sub1){
this.sub1 = sub1;
}
public void setSub2(int sub2){
this.sub1 = sub2;
}
public void setSub3(int sub3){
this.sub1 = sub3;
}
public void setSub4(int sub4){
this.sub1 = sub4;
}
public void setPrac1(int prac1){
this.prac1= prac1;
}
public void setPrac2(int prac2){
this.prac2= prac2;
}

public int getSemId(){
return semId;
}
public int getSub1(){
return sub1;
}
public int getSub2(){
return sub2;
}
public int getSub3(){
return sub3;
}
public int getSub4(){
return sub4;
}
public int getPrac1(){
return prac1;
}
public int getPrac2(){
return prac2;
}

@Override
public String toString() {
	return "Semesters [semId=" + semId + ", sub1=" + sub1 + ", sub2=" + sub2 + ", sub3=" + sub3 + ", sub4=" + sub4
			+ ", prac1=" + prac1 + ", prac2=" + prac2 + "]";
}

}
