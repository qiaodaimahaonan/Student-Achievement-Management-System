package myproject;

import java.util.ArrayList;

//����ѧ����
public class StudentInformation {

//	�洢ѧ��������
	public static ArrayList<StudentInformation> all_student = new ArrayList<StudentInformation>();
//	ѧ������,����ѧ�ź�����
	public static int number = 9;

	public static int ID = 1;
	// private String id;// ѧ��
	private int id;
	private String name;// ����
	private String gender;// �Ա�
	private String date;// ��������
	private int discrete_Mathematics;// ��ɢ��ѧ
	private int java;// java
	private int physical;// ����
	private int English;// Ӣ��
	private int Total;// �ܷ�

	// ����ʵ����
	public StudentInformation() {
	}

	@SuppressWarnings("static-access")
	public StudentInformation(int id, String name, String gender, String date, int java, int physical,
			int discrete_mathematics, int English, int Total) {

		this.id = id;
		this.name = name;
		this.gender = gender;
		this.date = date;
		this.java = java;
		this.physical = physical;
		this.discrete_Mathematics = discrete_mathematics;
		this.English = English;
		this.Total = Total;
	}

	// �������
	public int get_Id() {
		return id;
	}

	public String get_Name() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getDate() {
		return date;
	}

	public int get_java() {
		return java;
	}

	public int get_physical() {
		return physical;
	}

	public int get_Discrete_Mathematics() {
		return discrete_Mathematics;
	}

	public int get_English() {
		return English;
	}

	public int get_Total() {
		return Total;
	}

	// �޸�����
	@SuppressWarnings("static-access")
	public void set_Id(int id) {
		this.id = id;
	}

	public void set_Name(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void set_java(int java) {
		this.java = java;
	}

	public void set_physical(int physical) {
		this.physical = physical;
	}

	public void set_Discrete_Mathematics(int discrete_Mathematics) {
		this.discrete_Mathematics = discrete_Mathematics;
	}

	public void set_English(int English) {
		this.English = English;
	}

	public void set_Total(int Total) {
		this.Total = Total;
	}

}