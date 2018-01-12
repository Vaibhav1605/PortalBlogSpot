package com.portal.portalbackend;

import java.sql.Date;

import javax.persistence.Entity;

public class Job {
	

	private String job_Title;
	private String job_Desc;
	private int salary;
	private String experience;
	private String company_Name;
	private String skills_Requirement;
	private Date posted_On;

	public String getJob_Title() {
		return job_Title;
	}

	public void setJob_Title(String job_Title) {
		this.job_Title = job_Title;
	}

	public String getJob_Desc() {
		return job_Desc;
	}

	public void setJob_Desc(String job_Desc) {
		this.job_Desc = job_Desc;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getCompany_Name() {
		return company_Name;
	}

	public void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}

	public String getSkills_Requirement() {
		return skills_Requirement;
	}

	public void setSkills_Requirement(String skills_Requirement) {
		this.skills_Requirement = skills_Requirement;
	}

	public Date getPosted_On() {
		return posted_On;
	}

	public void setPosted_On(Date posted_On) {
		this.posted_On = posted_On;
	}

}
