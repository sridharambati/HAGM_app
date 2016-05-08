package com.skysol.grievance.model.mongo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Grievance {
	
//	@Id
//	private int id;
	
	private Integer memberId;
	
	private Long memberSSN;
	
	private String memberName;
	
	private String insuranceType;
	
	private String requestType;
	
	private Date requestedDate;
	
	private String memberEmail;
	
	private String memberPhone;
	
	private String grievanceComments;
	
	private String status;
	
	private UserRepo user;

	/*public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}*/

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

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getGrievanceComments() {
		return grievanceComments;
	}

	public void setGrievanceComments(String grievanceComments) {
		this.grievanceComments = grievanceComments;
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
