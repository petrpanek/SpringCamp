package hello.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String teacherFirstName;
	private String teacherLastName;
	private int points;
	private int numOfChildren;
	
	@OneToMany(cascade = {CascadeType.PERSIST})
	private List<Child> children;
	
	public Team() {
		
	}
	
	public Team(String name, String teacherFirstName, String teacherLastName, int points) {
		this.name = name;
		this.teacherFirstName = teacherFirstName;
		this.teacherLastName = teacherLastName;
		this.points = points;
		this.children = new ArrayList<>();
		this.numOfChildren = 0;
	}

	public String getTeacherFirstName() {
		return teacherFirstName;
	}

	public void setTeacherFirstName(String teacherFirstName) {
		this.teacherFirstName = teacherFirstName;
	}

	public String getTeacherLastName() {
		return teacherLastName;
	}

	public void setTeacherLastName(String teacherLastName) {
		this.teacherLastName = teacherLastName;
	}

	public void addChild(Child child) {
		numOfChildren++;
		children.add(child);
	}
	
	public void removeChild(Child child) {
		numOfChildren--;
		children.remove(child);
	}
	
	public boolean containsChild(int id) {
		for (Child child : children) {
			if (child.getId() == id) {
				return true;
			}
		}
		
		return false;
	}
	
	public List<Child> getChildren() {
		if (children == null) {
			this.children = new ArrayList<>();
		}
		return children;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getNumOfChildren() {
		return numOfChildren;
	}

	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", teacherFirstName=" + teacherFirstName + ", teacherLastName="
				+ teacherLastName + ", points=" + points + ", numOfChildren=" + numOfChildren + ", children=" + children
				+ "]";
	}
	
	
	
}
