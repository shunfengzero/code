package studnet2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JSpinner.ListEditor;

// 学生管理
class StudentManagement {
	private String name;
	private static StudentManagement s = null;// 保存地址
	

	ArrayList<Student> list;

	private StudentManagement(String name) {
		this.name = name;
		list = new ArrayList<Student>();
	}

	public String getName() {
		return name;
	}

	public static StudentManagement getInstance(String name) {
		if (s == null) {
			s = new StudentManagement(name);
		}

		return s;
	}

	/*
	 * 增加学生
	 */
	public void addStudent(Student s) throws TheObjectIsNullException {

		if (s == null) {
			throw new TheObjectIsNullException("对象不能为空");
		}
		list.add(s);

	}

	/*
	 * 通过ID删除学生
	 */

	public void deleteStudent(int id) throws TheIdIdNullException {

		if (id <= 0 || id > list.size()) {
			throw new TheIdIdNullException("这个删除的id不合法");
		}

		int index = findStudent(id);
		
		if (index != -1) {
			list.remove(index);
			
		} else {
			System.out.println("删除失败");

		}
	}

	/*
	 * 通过ID查找学生
	 */
	public int findStudent(int id) throws TheIdIdNullException {

		if (id <= 0 || id > list.size()) {
			throw new TheIdIdNullException("这个查找的id不合法");
		}

		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (this.list.get(i).getId() == id) {
				index = i;
			}

		}
		return index;
	}

	// 展示查找id的学生信息
	public void findStudentInfo(int id) throws TheIdIdNullException {

		if (id <= 0 || id > list.size()) {
			throw new TheIdIdNullException("这个查找的id不合法");
		}
		int index = findStudent(id);
		if (index != -1) {
			System.out.println("该名学生的信息如下");
			System.out.println(list.get(index));
		} else {
			System.out.println("没有这个学生");
		}
	}

	/*
	 * 通过Id修改学生的信息
	 */
	public void alterStudent(int id) throws TheIdIdNullException {

		if (id <= 0 || id > list.size()) {
			throw new TheIdIdNullException("这个查找的id不合法");
		}

		int index = findStudent(id);

		if (index != -1) {
			Scanner sc = new Scanner(System.in);
			int flag = 1;

			while (true) {
				System.out.println("该学生的信息如下");
				System.out.println("姓名： " + list.get(index).getName());
				System.out.println("性别： " + list.get(index).getSex());
				System.out.println("成绩： " + list.get(index).getGrade());
				System.out.println("年龄： " + list.get(index).getAge());
				System.out.println("请输入你想修改的信息：1.姓名; 2.性别; 3. 成绩; 4.年龄; 5.退出");
				int select = sc.nextInt();
				switch (select) {

				case 1:
					System.out.println("请输入你想修改的名字");
					String newName = sc.next();
					this.list.get(index).setName(newName);
					break;
				case 2:
					System.out.println("请输入你修改的性别");
					String newSex = sc.next();
					this.list.get(index).setSex(newSex);
					break;
				case 3:
					System.out.println("请输入你的正确的成绩");
					double newGrade = sc.nextDouble();
					this.list.get(index).setGrade(newGrade);
					break;
				case 4:
					System.out.println("请输入你的正确的年龄");
					int newAge = sc.nextInt();
					this.list.get(index).setAge(newAge);
					break;
				case 5:
					flag = 0;
					break;

				}
				if (flag == 0) {
					break;
				}

			}
		} else {
			System.out.println("没有这个学生");
		}
	}

	// 选择排序 按照年龄排序
	public void selectSort() {
		// 为了不影响id的绑定，所以需要新建一个新的数组将旧的数组赋值给新的数组，然后展示新的数组
		ArrayList<Student> list2 = new ArrayList<Student>();
		list2.addAll(list);
		for (int i = 0; i < list2.size() - 1; i++) {
			int index = i;
			for (int j = i + 1; j < list2.size(); j++) {
				if (new AgeComparator().compare(list2.get(index), list2.get(j)) > 0) {
					index = j;// 记录最小值的下标
				} // if
			} // for
			if (index != i) {
				Student temp = list2.get(index);
				list2.set(index, list2.get(i));
				list2.set(i, temp) ;
			}
		}
		// 遍历
		for (Student student : list2) {
			System.out.println(student);
		}
	}

	// 冒泡排序 按照成绩排序
	public void bubbleSort() {

		ArrayList<Student> list2 = new ArrayList<Student>();
		list2.addAll(list);
		int flag = 1;
		for (int i = 0; i < list2.size() - 1; i++) {
			for (int j = 0; j < list2.size() - 1 - i; j++) {
				if ((new GradeCpmparator().compare(list2.get(j), list2.get(j + 1))) > 0) {
					Student temp = list2.get(j);
					list2.set(j, list2.get(j + 1));
					list2.set(j + 1, temp);

					flag = 0;
				}
			} // for
			if (flag == 1) {
				break;
			}
			flag = 1;

		} // for

		// 遍历
		/*for (int i = 0; i < count; i++) {
			System.out.println(" 学生Id " + stu[i].getId() + " 学生姓名： " + stu[i].getName() + " 年龄： " + stu[i].getAge()
					+ " 性别： " + stu[i].getSex() + " 成绩： " + stu[i].getGrade());
		}*/
		for (Student student : list2) {
			System.out.println(student);
		}

	}

	/*
	 * 展示学生 1.按照ID展示 2.选择性别展示
	 */
	// 按照ID展示
	public void idShow() {

		// 遍历
		for (int i = 0; i < list.size(); i++) {
			System.out.println(" 学生Id " + list.get(i).getId() + " 学生姓名： " + list.get(i).getName() + " 年龄： "
					+ this.list.get(i).getAge() + " 性别： " + this.list.get(i).getSex() + " 成绩： "
					+ this.list.get(i).getGrade());
		}

	}

	// 2选择性别展示
	public void sexShow(String sex) {

		ArrayList<Student> list2 = new ArrayList<Student>();
		list2.addAll(list);

		for (int i = 0; i < list2.size(); i++) {
			if (sex.equals(list2.get(i).getSex())) {
				System.out.println(list2.get(i));
		}

	}

}
}

//年龄比较器
class AgeComparator implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		
		return o1.getAge() - o2.getAge();
	};
	
}

//成绩比较器
class GradeCpmparator implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return (int)(o1.getGrade() - o2.getGrade());
	}
	
}


