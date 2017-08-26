/*package studnet2;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentBeganTest {
	static  Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		nowStudentFunction(list);
		
			System.out.println(list);
		
		functionSelect(list);

		
	//	System.out.println(list);
		
		
	}


	private static void nowStudentFunction(ArrayList list) {
		Student p1 =  new Student("何力", "男", 92.0, 22);
		Student p2 =  new Student("马灿", "男", 93.0, 24);
		Student p3 =  new Student("小三", "男", 90.0, 31);
		Student p4 =  new Student("妹子二号", "女", 86.0, 18);
		Student p5 =  new Student("木头", "男", 99.0, 21);
		Student p6 =  new Student("耿青", "男", 95.0, 20);
		Student p7 =  new Student("妹子一号", "女", 82.0, 19);
		Student p8 =  new Student("妹子三号", "女", 97.0, 24);
		
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		list.add(p8);
	}
	
	
	public static void functionSelect(ArrayList list)  {

		System.out.println("---------------------------");
		System.out.println("------有如下几种功能-----------");
		System.out.println("------A.增加学生-------------");
		System.out.println("------B.删除学生-------------");
		System.out.println("------C.修改信息-------------");
		System.out.println("------D.查找学生-------------");
		System.out.println("------E.通过年龄对学生进行排序---");
		System.out.println("------F.通过成绩对学生进行排序---");
		System.out.println("------G.按照id展示学生信息-----");
		System.out.println("------H.按照性别展示学生信息----");
		System.out.println("------I.退出系统-------------");
		System.out.println("---------------------------");
		while (true) {
			String choose = sc.nextLine();
			switch (choose) {
			case "A":
				System.out.println("请输入你要增加学生的信息：");
				System.out.print("请输入你的名字： ");
				String n = sc.next();
				System.out.print("请输入你的性别： ");
				String s = sc.next();
				System.out.print("请输入你的成绩： ");
				double g = sc.nextDouble();
				System.out.print("请输入你的年龄： ");
				int a = sc.nextInt();
				list.add(new Student(n,s,g,a));
				functionSelect(list);
				break;
			case "B":
				System.out.println("请输入你要删除学生的id");
				int id = sc.nextInt();
				
				list.remove(findId(list, id));
				functionSelect(list);

				break;
			case "C":
				System.out.println("请输入你要修改学生的id");
				int id2 = sc.nextInt();
				int id3  = findId(list, id2);
				modiInfo(id3, list);
				functionSelect(list);
				break;
			case "D":
				System.out.println("请输入你要查找学生的id");
				int id4 = sc.nextInt();
				System.out.println(list.get(findId(list, id4)));
				functionSelect(list);
				break;
		
		        case "E":
		        	selectSort(list);
		        	functionSelect(list);
				break;
				
			case "F":
				bubbleSort(list);;
				functionSelect(list);
				break;
				case "G":
				idShow(list);
				functionSelect(list);
				break;
			case "H":
				System.out.println("请输入性别：");
				String sextoo = sc.nextLine();
				sexShow(list, sextoo);
				functionSelect(list);
			case "I":
				System.out.println("你已退出学生管理系统");
				System.exit(0);

			}
		}
	}
	
	
	public static void modiInfo(int  index,ArrayList list) {
		
		int flag = 1;
		while (true) {
			System.out.println("该学生的信息如下");
			System.out.println("姓名： " + ((Student) list.get(index)).getName());
			System.out.println("性别： " + ((Student) list.get(index)).getSex());
			System.out.println("成绩： " + ((Student) list.get(index)).getGrade());
			System.out.println("年龄： " + ((Student) list.get(index)).getAge());
			System.out.println("请输入你想修改的信息：1.姓名; 2.性别; 3. 成绩; 4.年龄; 5.退出");
			int select = sc.nextInt();
			switch (select) {

			case 1:
				System.out.println("请输入你想修改的名字");
				String newName = sc.next();
				 ((Student) list.get(index)).setName(newName);
				break;
			case 2:
				System.out.println("请输入你修改的性别");
				String newSex = sc.next();
				 ((Student) list.get(index)).setSex(newSex);
				break;
			case 3:
				System.out.println("请输入你的正确的成绩");
				double newGrade = sc.nextDouble();
				 ((Student) list.get(index)).setGrade(newGrade);
				break;
			case 4:
				System.out.println("请输入你的正确的年龄");
				int newAge = sc.nextInt();
				((Student) list.get(index)).setAge(newAge);
				break;
			case 5:
				flag = 0;
				break;

			}	 
	}
		
	}
	
	public static int findId(ArrayList list,int id) {
		
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (((Student)list.get(i)).getId() == id ) {
				index = i;
			}
			
		}
		
		return index;
		
	}
	
	// 选择排序 按照年龄排序
		public static void selectSort(ArrayList list) {
			//为了不影响id的绑定，所以需要新建一个新的数组将旧的数组赋值给新的数组，然后展示新的数组
		ArrayList list2 = new ArrayList();
			

			list2.addAll(list);
			for (int i = 0; i < list2.size() - 1; i++) {
				int index = i;
				for (int j = i + 1; j < list2.size(); j++) {
					if (((Student) list2.get(index)).getAge() > ((Student) list2.get(j)).getAge()) {
						index = j;// 记录最小值的下标
					} // if
				} // for
				if (index != i) {
					Student temp = (Student) list2.get(index);
					list2.set(index, list2.get(i));
					list2.set(i, temp);
				}
			}
			// 遍历
			for (int i = 0; i < list2.size(); i++) {
				System.out.println(" 学生Id " + ((Student) list2.get(i)).getId() + " 学生姓名： " + ((Student) list2.get(i)).getName() + " 年龄： " + ((Student) list2.get(i)).getAge()
						+ " 性别： " + ((Student) list2.get(i)).getSex() + " 成绩： " + ((Student) list2.get(i)).getGrade());
			}
			for (Object object : list2) {
				System.out.println(object.toString());
			}

		}
		

		// 冒泡排序 按照成绩排序
		public static  void bubbleSort(ArrayList list) {
			//为了不影响id的绑定，所以需要新建一个新的数组将旧的数组赋值给新的数组，然后展示新的数组
			ArrayList list2 = new ArrayList();
				

				list2.addAll(list);

			int flag = 1;
			for (int i = 0; i < list2.size() - 1; i++) {
				for (int j = 0; j < list2.size() - 1 - i; j++) {
					if (((Student) list2.get(j)).getGrade() < ((Student) list2.get(j + 1)).getGrade()) {
						Student temp = ((Student) list2.get(j));
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
			for (Object object : list2) {
				System.out.println(object.toString());
			}

		}
		
		// 按照ID展示
		public static void idShow(ArrayList list) {

			
			// 遍历
			for (int i = 0; i < list.size(); i++) {
				System.out.println(" 学生Id " + ((Student) list.get(i)).getId() + " 学生姓名： " + ((Student) list.get(i)).getName() + " 年龄： "
						+ ((Student) list.get(i)).getAge() + " 性别： " + ((Student) list.get(i)).getSex() + " 成绩： "
						+ ((Student) list.get(i)).getGrade());
			}

		}

		// 2选择性别展示
		public static void sexShow(ArrayList list, String sex) {
			
			ArrayList list2 = new ArrayList();
			list2.addAll(list);

			for (int i = 0; i < list2.size(); i++) {
				if (sex.equals(((Student) list2.get(i)).getSex())) {
					System.out.println(" 学生Id " + ((Student) list2.get(i)).getId() + " 学生姓名： " + ((Student) list2.get(i)).getName() + " 年龄： "
							+ ((Student) list2.get(i)).getAge() + " 性别： " + ((Student) list2.get(i)).getSex() + " 成绩： "
							+ ((Student) list2.get(i)).getGrade());
				}
			}

		}
	
	
}
*/