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
		Student p1 =  new Student("����", "��", 92.0, 22);
		Student p2 =  new Student("���", "��", 93.0, 24);
		Student p3 =  new Student("С��", "��", 90.0, 31);
		Student p4 =  new Student("���Ӷ���", "Ů", 86.0, 18);
		Student p5 =  new Student("ľͷ", "��", 99.0, 21);
		Student p6 =  new Student("����", "��", 95.0, 20);
		Student p7 =  new Student("����һ��", "Ů", 82.0, 19);
		Student p8 =  new Student("��������", "Ů", 97.0, 24);
		
		
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
		System.out.println("------�����¼��ֹ���-----------");
		System.out.println("------A.����ѧ��-------------");
		System.out.println("------B.ɾ��ѧ��-------------");
		System.out.println("------C.�޸���Ϣ-------------");
		System.out.println("------D.����ѧ��-------------");
		System.out.println("------E.ͨ�������ѧ����������---");
		System.out.println("------F.ͨ���ɼ���ѧ����������---");
		System.out.println("------G.����idչʾѧ����Ϣ-----");
		System.out.println("------H.�����Ա�չʾѧ����Ϣ----");
		System.out.println("------I.�˳�ϵͳ-------------");
		System.out.println("---------------------------");
		while (true) {
			String choose = sc.nextLine();
			switch (choose) {
			case "A":
				System.out.println("��������Ҫ����ѧ������Ϣ��");
				System.out.print("������������֣� ");
				String n = sc.next();
				System.out.print("����������Ա� ");
				String s = sc.next();
				System.out.print("��������ĳɼ��� ");
				double g = sc.nextDouble();
				System.out.print("������������䣺 ");
				int a = sc.nextInt();
				list.add(new Student(n,s,g,a));
				functionSelect(list);
				break;
			case "B":
				System.out.println("��������Ҫɾ��ѧ����id");
				int id = sc.nextInt();
				
				list.remove(findId(list, id));
				functionSelect(list);

				break;
			case "C":
				System.out.println("��������Ҫ�޸�ѧ����id");
				int id2 = sc.nextInt();
				int id3  = findId(list, id2);
				modiInfo(id3, list);
				functionSelect(list);
				break;
			case "D":
				System.out.println("��������Ҫ����ѧ����id");
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
				System.out.println("�������Ա�");
				String sextoo = sc.nextLine();
				sexShow(list, sextoo);
				functionSelect(list);
			case "I":
				System.out.println("�����˳�ѧ������ϵͳ");
				System.exit(0);

			}
		}
	}
	
	
	public static void modiInfo(int  index,ArrayList list) {
		
		int flag = 1;
		while (true) {
			System.out.println("��ѧ������Ϣ����");
			System.out.println("������ " + ((Student) list.get(index)).getName());
			System.out.println("�Ա� " + ((Student) list.get(index)).getSex());
			System.out.println("�ɼ��� " + ((Student) list.get(index)).getGrade());
			System.out.println("���䣺 " + ((Student) list.get(index)).getAge());
			System.out.println("�����������޸ĵ���Ϣ��1.����; 2.�Ա�; 3. �ɼ�; 4.����; 5.�˳�");
			int select = sc.nextInt();
			switch (select) {

			case 1:
				System.out.println("�����������޸ĵ�����");
				String newName = sc.next();
				 ((Student) list.get(index)).setName(newName);
				break;
			case 2:
				System.out.println("���������޸ĵ��Ա�");
				String newSex = sc.next();
				 ((Student) list.get(index)).setSex(newSex);
				break;
			case 3:
				System.out.println("�����������ȷ�ĳɼ�");
				double newGrade = sc.nextDouble();
				 ((Student) list.get(index)).setGrade(newGrade);
				break;
			case 4:
				System.out.println("�����������ȷ������");
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
	
	// ѡ������ ������������
		public static void selectSort(ArrayList list) {
			//Ϊ�˲�Ӱ��id�İ󶨣�������Ҫ�½�һ���µ����齫�ɵ����鸳ֵ���µ����飬Ȼ��չʾ�µ�����
		ArrayList list2 = new ArrayList();
			

			list2.addAll(list);
			for (int i = 0; i < list2.size() - 1; i++) {
				int index = i;
				for (int j = i + 1; j < list2.size(); j++) {
					if (((Student) list2.get(index)).getAge() > ((Student) list2.get(j)).getAge()) {
						index = j;// ��¼��Сֵ���±�
					} // if
				} // for
				if (index != i) {
					Student temp = (Student) list2.get(index);
					list2.set(index, list2.get(i));
					list2.set(i, temp);
				}
			}
			// ����
			for (int i = 0; i < list2.size(); i++) {
				System.out.println(" ѧ��Id " + ((Student) list2.get(i)).getId() + " ѧ�������� " + ((Student) list2.get(i)).getName() + " ���䣺 " + ((Student) list2.get(i)).getAge()
						+ " �Ա� " + ((Student) list2.get(i)).getSex() + " �ɼ��� " + ((Student) list2.get(i)).getGrade());
			}
			for (Object object : list2) {
				System.out.println(object.toString());
			}

		}
		

		// ð������ ���ճɼ�����
		public static  void bubbleSort(ArrayList list) {
			//Ϊ�˲�Ӱ��id�İ󶨣�������Ҫ�½�һ���µ����齫�ɵ����鸳ֵ���µ����飬Ȼ��չʾ�µ�����
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

			// ����
			for (Object object : list2) {
				System.out.println(object.toString());
			}

		}
		
		// ����IDչʾ
		public static void idShow(ArrayList list) {

			
			// ����
			for (int i = 0; i < list.size(); i++) {
				System.out.println(" ѧ��Id " + ((Student) list.get(i)).getId() + " ѧ�������� " + ((Student) list.get(i)).getName() + " ���䣺 "
						+ ((Student) list.get(i)).getAge() + " �Ա� " + ((Student) list.get(i)).getSex() + " �ɼ��� "
						+ ((Student) list.get(i)).getGrade());
			}

		}

		// 2ѡ���Ա�չʾ
		public static void sexShow(ArrayList list, String sex) {
			
			ArrayList list2 = new ArrayList();
			list2.addAll(list);

			for (int i = 0; i < list2.size(); i++) {
				if (sex.equals(((Student) list2.get(i)).getSex())) {
					System.out.println(" ѧ��Id " + ((Student) list2.get(i)).getId() + " ѧ�������� " + ((Student) list2.get(i)).getName() + " ���䣺 "
							+ ((Student) list2.get(i)).getAge() + " �Ա� " + ((Student) list2.get(i)).getSex() + " �ɼ��� "
							+ ((Student) list2.get(i)).getGrade());
				}
			}

		}
	
	
}
*/