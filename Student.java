package studnet2;

public class Student {
	private int id;
	private String name;
	private int age;
	private String sex;
	private double grade;
	private static int count = 1;
	
	{
		id = count;
		count++;
	}

	Student(String name, String sex, Double grade, int age) {
		setName(name);
		setSex(sex);
		setGrade(grade);
		setAge(age);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		 if (name == null) {
			 System.out.println("你输入的名字不能为空");
			 this.name = "二狗子";
		 }
			this.name = name;
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age <= 0) {
			System.out.println("你的年龄输入不合法");
			this.age = 18;
		} else {
			this.age = age;
		}
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		if (sex.equals("男") || sex.equals("女")) {
			this.sex = sex;
		} else {
			System.out.println("你确定你是人妖？");
			this.sex = "男";
		}
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		if (this.grade < 0 || this.grade > 100) {
			System.out.println("你输入的成绩有误");
			this.grade = 0;
		} else {
		this.grade = grade; 
		}
	}
	/*@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "学生Id " + this.getId() + " 学生姓名： " + this.getName() + " 年龄： "
				+ this.getAge() + " 性别： " + this.getSex() + " 成绩： "
				+ this.getGrade() + "\n\r";
	}*/

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", grade=" + grade + "]" + "\n\r";
	}

}
