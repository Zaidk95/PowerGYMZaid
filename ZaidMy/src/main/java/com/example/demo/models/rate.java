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

@Entity(name="user1")
@Table(name="Ratings")
@JsonIgnoreProperties(ignoreUnknown = true)
public class rate implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Lob @Basic(fetch = FetchType.LAZY) @Column
	private String username;
	@Basic(fetch = FetchType.LAZY) @Column
	private int rating;
	@Lob @Basic(fetch = FetchType.LAZY) @Column
	private String date;
	@Lob @Basic(fetch = FetchType.LAZY) @Column
	private String title;
	@Lob @Basic(fetch = FetchType.LAZY) @Column(columnDefinition = "text")
	private String descripe;

	public rate(String username, int rating, String date, String title, String descripe) {
		super();
		this.username = username;
		this.rating = rating;
		this.date = date;
		this.title = title;
		this.descripe = descripe;
	}



	@Override
	public String toString() {
		return "rate [ID=" + ID + ", username=" + username + ", rating=" + rating + ", date=" + date + ", title="
				+ title + ", descripe=" + descripe + "]";
	}





	public int getID() {
		return ID;
	}





	public void setID(int iD) {
		ID = iD;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public int getRating() {
		return rating;
	}





	public void setRating(int rating) {
		this.rating = rating;
	}





	public String getDate() {
		return date;
	}





	public void setDate(String date) {
		this.date = date;
	}





	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public String getDescripe() {
		return descripe;
	}





	public void setDescripe(String descripe) {
		this.descripe = descripe;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	public rate() {}
	
	
}
	

	