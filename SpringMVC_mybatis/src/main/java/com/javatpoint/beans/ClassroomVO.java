package com.javatpoint.beans;

public class ClassroomVO {
	private int classID;
	private String classTITLE;
	private String classCONTENT;
	
	public ClassroomVO() {
		
	}
	
	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String getClassTITLE() {
		return classTITLE;
	}

	public void setClassTITLE(String classTITLE) {
		this.classTITLE = classTITLE;
	}

	public String getClassCONTENT() {
		return classCONTENT;
	}

	public void setClassCONTENT(String classCONTENT) {
		this.classCONTENT = classCONTENT;
	}

	public ClassroomVO(int classID, String classTITLE, String classCONTENT) {
		super();
		this.classID = classID;
		this.classTITLE = classTITLE;
		this.classCONTENT = classCONTENT;
	}

}
