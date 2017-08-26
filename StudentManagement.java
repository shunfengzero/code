package studnet2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JSpinner.ListEditor;

// ѧ������
class StudentManagement {
	private String name;
	private static StudentManagement s = null;// �����ַ
	

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
	 * ����ѧ��
	 */
	public void addStudent(Student s) throws TheObjectIsNullException {

		if (s == null) {
			throw new TheObjectIsNullException("������Ϊ��");
		}
		list.add(s);

	}

	/*
	 * ͨ��IDɾ��ѧ��
	 */

	public void deleteStudent(int id) throws TheIdIdNullException {

		if (id <= 0 || id > list.size()) {
			throw new TheIdIdNullException("���ɾ����id���Ϸ�");
		}

		int index = findStudent(id);
		
		if (index != -1) {
			list.remove(index);
			
		} else {
			System.out.println("ɾ��ʧ��");

		}
	}

	/*
	 * ͨ��ID����ѧ��
	 */
	public int findStudent(int id) throws TheIdIdNullException {

		if (id <= 0 || id > list.size()) {
			throw new TheIdIdNullException("������ҵ�id���Ϸ�");
		}

		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (this.list.get(i).getId() == id) {
				index = i;
			}

		}
		return index;
	}

	// չʾ����id��ѧ����Ϣ
	public void findStudentInfo(int id) throws TheIdIdNullException {

		if (id <= 0 || id > list.size()) {
			throw new TheIdIdNullException("������ҵ�id���Ϸ�");
		}
		int index = findStudent(id);
		if (index != -1) {
			System.out.println("����ѧ������Ϣ����");
			System.out.println(list.get(index));
		} else {
			System.out.println("û�����ѧ��");
		}
	}

	/*
	 * ͨ��Id�޸�ѧ������Ϣ
	 */
	public void alterStudent(int id) throws TheIdIdNullException {

		if (id <= 0 || id > list.size()) {
			throw new TheIdIdNullException("������ҵ�id���Ϸ�");
		}

		int index = findStudent(id);

		if (index != -1) {
			Scanner sc = new Scanner(System.in);
			int flag = 1;

			while (true) {
				System.out.println("��ѧ������Ϣ����");
				System.out.println("������ " + list.get(index).getName());
				System.out.println("�Ա� " + list.get(index).getSex());
				System.out.println("�ɼ��� " + list.get(index).getGrade());
				System.out.println("���䣺 " + list.get(index).getAge());
				System.out.println("�����������޸ĵ���Ϣ��1.����; 2.�Ա�; 3. �ɼ�; 4.����; 5.�˳�");
				int select = sc.nextInt();
				switch (select) {

				case 1:
					System.out.println("�����������޸ĵ�����");
					String newName = sc.next();
					this.list.get(index).setName(newName);
					break;
				case 2:
					System.out.println("���������޸ĵ��Ա�");
					String newSex = sc.next();
					this.list.get(index).setSex(newSex);
					break;
				case 3:
					System.out.println("�����������ȷ�ĳɼ�");
					double newGrade = sc.nextDouble();
					this.list.get(index).setGrade(newGrade);
					break;
				case 4:
					System.out.println("�����������ȷ������");
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
			System.out.println("û�����ѧ��");
		}
	}

	// ѡ������ ������������
	public void selectSort() {
		// Ϊ�˲�Ӱ��id�İ󶨣�������Ҫ�½�һ���µ����齫�ɵ����鸳ֵ���µ����飬Ȼ��չʾ�µ�����
		ArrayList<Student> list2 = new ArrayList<Student>();
		list2.addAll(list);
		for (int i = 0; i < list2.size() - 1; i++) {
			int index = i;
			for (int j = i + 1; j < list2.size(); j++) {
				if (new AgeComparator().compare(list2.get(index), list2.get(j)) > 0) {
					index = j;// ��¼��Сֵ���±�
				} // if
			} // for
			if (index != i) {
				Student temp = list2.get(index);
				list2.set(index, list2.get(i));
				list2.set(i, temp) ;
			}
		}
		// ����
		for (Student student : list2) {
			System.out.println(student);
		}
	}

	// ð������ ���ճɼ�����
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

		// ����
		/*for (int i = 0; i < count; i++) {
			System.out.println(" ѧ��Id " + stu[i].getId() + " ѧ�������� " + stu[i].getName() + " ���䣺 " + stu[i].getAge()
					+ " �Ա� " + stu[i].getSex() + " �ɼ��� " + stu[i].getGrade());
		}*/
		for (Student student : list2) {
			System.out.println(student);
		}

	}

	/*
	 * չʾѧ�� 1.����IDչʾ 2.ѡ���Ա�չʾ
	 */
	// ����IDչʾ
	public void idShow() {

		// ����
		for (int i = 0; i < list.size(); i++) {
			System.out.println(" ѧ��Id " + list.get(i).getId() + " ѧ�������� " + list.get(i).getName() + " ���䣺 "
					+ this.list.get(i).getAge() + " �Ա� " + this.list.get(i).getSex() + " �ɼ��� "
					+ this.list.get(i).getGrade());
		}

	}

	// 2ѡ���Ա�չʾ
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

//����Ƚ���
class AgeComparator implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		
		return o1.getAge() - o2.getAge();
	};
	
}

//�ɼ��Ƚ���
class GradeCpmparator implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return (int)(o1.getGrade() - o2.getGrade());
	}
	
}


