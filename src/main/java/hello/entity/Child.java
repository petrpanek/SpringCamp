package hello.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Child {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String surname;
	private String birthNumber;
	private Gender gender;
	
	@ManyToOne
	private Team team;
	
	public Child () {
		
	}
	
	public Child(String name, String surname, String birthNumber, Gender gender) {	
		this.name = name;
		this.surname = surname;
		this.birthNumber = birthNumber;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getBirthNumber() {
		return birthNumber;
	}
	
	public void setBirthNumber(String birthNumber) {
		this.birthNumber = birthNumber;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Child [id=" + id + ", name=" + name + ", surname=" + surname + ", birthNumber=" + birthNumber
				+ ", gender=" + gender + "]";
	}
	
	
}
