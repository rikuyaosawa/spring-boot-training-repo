package com.ltp.gradesubmission;

import java.util.UUID;

public class Grade {

	private String student;
	private String subject;
	private String score;
	private String id;

	public Grade(String student, String subject, String score) {
		this.student = student;
		this.subject = subject;
		this.score = score;
	}

	public Grade() {
		this.id = UUID.randomUUID().toString();
	}

	public String getStudent() {
		return this.student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "{" +
			" student='" + getStudent() + "'" +
			", subject='" + getSubject() + "'" +
			", score='" + getScore() + "'" +
			"}";
	}
}
