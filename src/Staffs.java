
public class Staffs {
	private String id, name, gender, job;
	private int wage;
	
	public Staffs(String id, String name, String gender, String job, int wage) {
		this.id=id;
		this.name=name;
		this.gender=gender;
		this.job=job;
		this.wage=wage;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getJob() {
		return job;
	}
	
	public int getWage() {
		return wage;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public void setWage(int wage) {
		this.wage = wage;
	}
}
