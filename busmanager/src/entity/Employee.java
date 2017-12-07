package entity;


/**
 * 
 * @author WangShirong
 *
 */
public class Employee {
	private String id;
	private String name;
	private int age;
	private String sex;
	private String other;

	public String getId() {
		return id;
	}
	public void setId(String id) {
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Employee(String id,String name, int age, String sex, String other) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.other = other;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "name:" + name + "\nage:" + age + "\nsex:" + sex + "\nother:"
				+ other + "\n";
	}
}
