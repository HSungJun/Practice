package º¹½À;

import java.sql.Timestamp;

public class TeamDTO {
	
	private int id;
	private String name;
	private int age;
	private String contact;
	private Timestamp update_date;
	
	
	public TeamDTO(int id, String name, int age, String contact, Timestamp update_date) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.update_date = update_date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public Timestamp getUpdate_date() {
		return update_date;
	}


	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	} 
	
	
	
	
}
