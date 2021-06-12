package com.example.demo.models;


import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="user3")
@Table(name="Massages")
@JsonIgnoreProperties(ignoreUnknown = true)
public class massage implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Lob @Basic(fetch = FetchType.LAZY) @Column
	private String email;
	@Lob @Basic(fetch = FetchType.LAZY) @Column
	private String name;
	@Lob @Basic(fetch = FetchType.LAZY) @Column
	private String date;
	@Lob @Basic(fetch = FetchType.LAZY) @Column
	private String subject;
	@Lob @Basic(fetch = FetchType.LAZY) @Column(columnDefinition = "text")
	private String msg;
	
	public massage(){}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "massage [ID=" + ID + ", email=" + email + ", name=" + name + ", date=" + date + ", subject=" + subject
				+ ", msg=" + msg + "]";
	}

	public massage(String email, String name, String date, String subject, String msg) {
		super();
		this.email = email;
		this.name = name;
		this.date = date;
		this.subject = subject;
		this.msg = msg;
	}
	
	
	
	
}
	

	