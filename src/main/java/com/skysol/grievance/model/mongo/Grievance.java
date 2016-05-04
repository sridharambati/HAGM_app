package com.skysol.grievance.model.mongo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Grievance {
	
	@Id
	private int id;
	
	private Integer memberId;
	
	private Long memberSSN;
	
	private String memberName;
	
	private String insuranceType;
	
	private String grievanceType;
	
	private Date requestedDate;
	
	private String status;
	
	private UserRepo user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Long getMemberSSN() {
		return memberSSN;
	}

	public void setMemberSSN(Long memberSSN) {
		this.memberSSN = memberSSN;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getGrievanceType() {
		return grievanceType;
	}

	public void setGrievanceType(String grievanceType) {
		this.grievanceType = grievanceType;
	}

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserRepo getUser() {
		return user;
	}

	public void setUser(UserRepo user) {
		this.user = user;
	}
	
}
