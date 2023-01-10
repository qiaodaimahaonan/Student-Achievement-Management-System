package myproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class StudentUI {

//	��������
	public static JFrame jframe_1 = new JFrame("ѧ���ɼ�����ϵͳ");
//	�������
	public static JPanel jpanel_1 = new JPanel(new ModifiedFlowLayout());// ����
	public static JPanel jpanel_2 = new JPanel(null);// �ղ���
//	�����ı���������ʾ��Ϣ
	public static JTextArea j_1 = new JTextArea();

	public static void main(String[] args) {

	}

//	��ʦ������
	public void init_1() {

//		���ڴ�С
		jframe_1.setSize(850, 500);
//		�ղ���
		jframe_1.setLayout(null);
//		���ڲ��ɵ���
		jframe_1.setResizable(false);
//		�رմ������˳�����
		jframe_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		�˵���
		JMenuBar bar = new JMenuBar();
//		һ���˵�
		JMenu men_1 = new JMenu("��������");
		JMenu men_2 = new JMenu("����");
//		�Ӳ˵�
		JMenuItem item_1 = new JMenuItem("���ѧ��");
		JMenuItem item_2 = new JMenuItem("����ɼ�");
		JMenuItem item_3 = new JMenuItem("�޸���Ϣ");
		JMenuItem item_4 = new JMenuItem("ɾ��ѧ��");
		JMenuItem item_5 = new JMenuItem("��ѯ�ɼ�");
		JMenuItem item_6 = new JMenuItem("ѧϰ�������");
		JMenuItem item_7 = new JMenuItem("����");

		JMenuItem item_8 = new JMenuItem("��ѧ������");
		JMenuItem item_9 = new JMenuItem("���ֽܷ���");
		JMenuItem item_10 = new JMenuItem("��ĳ��Ŀ����");
		JMenuItem item_11 = new JMenuItem("�����ļ�");
//		��������
		Font font = new Font("����", Font.PLAIN, 15);

//		���ò˵�����
		men_1.setFont(font);
		men_2.setFont(font);
		item_1.setFont(font);
		item_2.setFont(font);
		item_3.setFont(font);
		item_4.setFont(font);
		item_5.setFont(font);
		item_6.setFont(font);
		item_7.setFont(font);
		item_8.setFont(font);
		item_9.setFont(font);
		item_10.setFont(font);
		item_11.setFont(font);
//		����
		men_1.add(item_1);
		men_1.add(item_2);
		men_1.add(item_3);
		men_1.add(item_4);
		men_1.add(item_5);
		men_1.add(item_6);
		men_1.add(item_7);
		men_1.add(item_11);

		men_2.add(item_8);
		men_2.add(item_9);
		men_2.add(item_10);

		bar.add(men_1);
		bar.add(men_2);
		jframe_1.setJMenuBar(bar);

//		�������λ�á���С����ɫ
		jpanel_1.setBounds(0, 0, 200, 500);
		jpanel_2.setBounds(210, 0, 640, 500);
		jpanel_1.setBackground(Color.LIGHT_GRAY);
		jpanel_2.setBackground(Color.LIGHT_GRAY);
		jframe_1.add(jpanel_1);
		jframe_1.add(jpanel_2);

		// �����ı������ܱ༭
		j_1.setEditable(false);
		// ��j1��Ϊ�ɹ������sp����ʾ����
		JScrollPane sp = new JScrollPane(j_1);
		sp.setSize(625, 440);
		StudentUI.jpanel_2.add(sp);

		JScrollPane scrollPane = new JScrollPane(jpanel_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setSize(200, 440);
		jframe_1.add(scrollPane);

//		���ھ���
		jframe_1.setLocationRelativeTo(null);
//		������ʾ
		jframe_1.setVisible(true);

//		ע�� ���ѧ�� ��ť�ļ���
		item_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				���÷���
				StudentUI.init_2();
			}
		});
		// ����ɼ� ��ť����
		item_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				init_10();
				String[] options = { "��ɢ��ѧ", "Java", "����", "Ӣ��" };
				String s = (String) JOptionPane.showInputDialog(null, "���������ѡ�", "��ʾ", JOptionPane.QUESTION_MESSAGE,
						null, options, null);
				if (s != null) {
					int i = 0;
					if (s.equals("Java")) {
						i = 4;
					} else if (s.equals("����")) {
						i = 5;
					} else if (s.equals("��ɢ��ѧ")) {
						i = 6;
					} else if (s.equals("Ӣ��")) {
						i = 7;
					}
					StudentUI.init_3(i);
				}
			}
		});
//		ע�� �޸�ѧ�� ��ť�ļ���
		item_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentUI.init_4();
			}
		});
//		ע�� ɾ��ѧ�� ��ť�ļ���
		item_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentUI.init_5();
			}
		});
//		ע�� ��ѯѧ�� ��ť�ļ���
		item_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] options = { "ͨ��ѧ�Ų�ѯ", "ͨ��������ѯ" };
				String s = (String) JOptionPane.showInputDialog(null, "���������ѡ�", "��ʾ", JOptionPane.QUESTION_MESSAGE,
						null, options, null);
				if (s != null) {
					if (s.equals("ͨ��ѧ�Ų�ѯ")) {
						StudentUI.init_6();
					} else if (s.equals("ͨ��������ѯ")) {
						StudentUI.init_7();
					}
				}
			}
		});
		// ѧϰ������� ��ť����
		item_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				StudentUI.init_11();
				StudentUI.init_8(StudentInformation.all_student);

			}
		});
//		���� ��ť�ļ���
		item_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentUI.init_10();
				StudentUI.init_9();
			}
		});
		// ��ѧ������ ��ť����
		item_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				StudentUI.init_10();

			}
		});
//		�� �ֽܷ���ť �ļ���
		item_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentUI.init_11();
			}
		});
//		�� ĳ�ƽ���ť �ļ���
		item_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] options = { "java", "����", "��ɢ��ѧ", "Ӣ��" };
				String s = (String) JOptionPane.showInputDialog(null, "���������ѡ�", "��ʾ", JOptionPane.QUESTION_MESSAGE,
						null, options, null);
				if (s != null) {
					StudentUI.init_12(s);
				}
			}
		});
		// �����ļ���ť����
		item_11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				���÷���
				StudentUI.init_14();
			}
		});
	}

//	���ѧ������
	public static void init_2() {
//		������
		StudentUI.jpanel_1.removeAll();
//		ˢ�����
		StudentUI.jpanel_1.updateUI();

//		ѧ����
		String s[] = new String[4];
		s[0] = "ѧ       �ţ�";
		s[1] = "��       ����";
		s[2] = "��       ��";
		s[3] = "�������ڣ���yyyy/mm/dd��";

//		��ǩ
		JLabel jlabel[] = new JLabel[4];
//		�ı���
		JTextField jtextfield[] = new JTextField[4];
		JPanel jp1 = new JPanel();

		JLabel jlabel1 = new JLabel("���ѧ��                                        ");
		StudentUI.jpanel_1.add(jlabel1);

//		ʵ����
		for (int i = 0; i < 4; i++) {
			jlabel[i] = new JLabel(s[i]);
			StudentUI.jpanel_1.add(jlabel[i]);
			if (i == 2) {
				JRadioButton radioButton1 = new JRadioButton("��");
				JRadioButton radioButton2 = new JRadioButton("Ů");
				ButtonGroup bg = new ButtonGroup();
				bg.add(radioButton1);
				bg.add(radioButton2);
				jp1 = new JPanel(new GridLayout(1, 2));// һ������
				jp1.add(radioButton1);
				jp1.add(radioButton2);
				StudentUI.jpanel_1.add(jp1);
			} else {
				jtextfield[i] = new JTextField(12);
				StudentUI.jpanel_1.add(jtextfield[i]);
			}
		}

		// ѧ���Զ�����
		jtextfield[0].setText(String.valueOf(StudentInformation.ID));
		jtextfield[0].setEditable(false);

//		��ť
		JButton jbutton_1 = new JButton("�ύ");
		JButton jbutton_2 = new JButton("���");
//		���밴ť
		StudentUI.jpanel_1.add(jbutton_1);
		StudentUI.jpanel_1.add(jbutton_2);
//		ע�����
		StudentListen e_1 = new StudentListen(jp1, jbutton_1, jbutton_2, jtextfield);
		jbutton_1.addActionListener(e_1);
		jbutton_2.addActionListener(e_1);
	}

	// ����ɼ�����
	public static void init_3(int i) {

//		������
		StudentUI.jpanel_1.removeAll();
//		ˢ�����
		StudentUI.jpanel_1.updateUI();

		int num = StudentInformation.all_student.size();
//		�ı���
		JTextField jtextfield[] = new JTextField[num];

		if (i == 4) {
			JLabel jlabel1 = new JLabel("����java�ɼ�                                ");
			StudentUI.jpanel_1.add(jlabel1);
		} else if (i == 5) {
			JLabel jlabel1 = new JLabel("���������ɼ�                                ");
			StudentUI.jpanel_1.add(jlabel1);
		} else if (i == 6) {
			JLabel jlabel1 = new JLabel("������ɢ�ɼ�                                ");
			StudentUI.jpanel_1.add(jlabel1);
		} else if (i == 7) {
			JLabel jlabel1 = new JLabel("����Ӣ��ɼ�                                ");
			StudentUI.jpanel_1.add(jlabel1);
		}
//		ʵ����
		for (int j = 0; j < num; j++) {
			jtextfield[j] = new JTextField(12);
			jpanel_1.add(jtextfield[j]);
		}

//		��ť
		JButton jbutton_11 = new JButton("�ύ");
		JButton jbutton_12 = new JButton("���");
//		���밴ť
		jpanel_1.add(jbutton_11);
		jpanel_1.add(jbutton_12);

//		ע�����
		StudentListen_2 e_2 = new StudentListen_2(jbutton_11, jbutton_12, jtextfield, i);
		jbutton_11.addActionListener(e_2);
		jbutton_12.addActionListener(e_2);

	}

//	�޸� ѧ������
	public static void init_4() {
//		������
		StudentUI.jpanel_1.removeAll();
//		ˢ�����
		StudentUI.jpanel_1.updateUI();
//		����
		Font font = new Font("����", Font.PLAIN, 15);
//		ѧ����
		String s[] = new String[StudentInformation.number];
		s[0] = "ѧ       �ţ�";
		s[1] = "��       ����";
		s[2] = "��       ��";
		s[3] = "�������ڣ�";
		s[4] = "j a v a��";
		s[5] = "��       ����";
		s[6] = "��ɢ��ѧ��";
		s[7] = "Ӣ       �";
		s[8] = "��       �֣�";

//		��ǩ
		JLabel jlabel[] = new JLabel[StudentInformation.number];
//		�ı���
		JTextField jtextfield[] = new JTextField[StudentInformation.number];
//		��ť
		JButton jbutton_3 = new JButton("�޸�");
		JButton jbutton_4 = new JButton("���");
		jbutton_3.setFont(font);
		jbutton_4.setFont(font);
		JPanel jp2 = new JPanel();

		JLabel jlabel1 = new JLabel("�޸���Ϣ                                        ");
		StudentUI.jpanel_1.add(jlabel1);

//		ʵ����
		for (int i = 0, j = 0; i < StudentInformation.number; i++, j++) {
			jlabel[i] = new JLabel(s[i]);
			StudentUI.jpanel_1.add(jlabel[i]);
			if (i == 2) {
				JRadioButton radioButton1 = new JRadioButton("��");
				JRadioButton radioButton2 = new JRadioButton("Ů");
				ButtonGroup bg = new ButtonGroup();
				bg.add(radioButton1);
				bg.add(radioButton2);
				jp2 = new JPanel(new GridLayout(1, 2));// һ������
				jp2.add(radioButton1);
				jp2.add(radioButton2);
				StudentUI.jpanel_1.add(jp2);
			} else {
				jtextfield[i] = new JTextField(12);
				StudentUI.jpanel_1.add(jtextfield[i]);
			}
//			j������Ӵ�����ֹ�ظ����
			if (j == 0) {
				JLabel L_1 = new JLabel("ѧ�Ų��ܱ��޸�!");
				JLabel L_2 = new JLabel("��������������µ���Ϣ��");
				StudentUI.jpanel_1.add(L_1);
				StudentUI.jpanel_1.add(L_2);
			}
		}

//		�����ı���Ĭ��ֵ(�ܷ��Զ�����,���ɱ༭)
		jtextfield[StudentInformation.number - 1].setText("�Զ����㣬��������");
		jtextfield[StudentInformation.number - 1].setEditable(false);

		StudentUI.jpanel_1.add(jbutton_3);
		StudentUI.jpanel_1.add(jbutton_4);
//		ע�����
		StudentListen_3 e_3 = new StudentListen_3(jp2, jbutton_3, jbutton_4, jtextfield);
		jbutton_3.addActionListener(e_3);
		jbutton_4.addActionListener(e_3);
	}

//	ɾ�� ѧ������
	public static void init_5() {
//		������
		StudentUI.jpanel_1.removeAll();
//		ˢ�����
		StudentUI.jpanel_1.updateUI();
//		����
		Font font = new Font("����", Font.PLAIN, 15);

		JLabel jlabel1 = new JLabel("ɾ��ѧ��                                        ");
		StudentUI.jpanel_1.add(jlabel1);

//		��ǩ
		JLabel jlabel_1 = new JLabel(" ѧ       �ţ�");
//		�ı���
		JTextField jtextfield_1 = new JTextField(10);
//		��ӵ����
		StudentUI.jpanel_1.add(jlabel_1);
		StudentUI.jpanel_1.add(jtextfield_1);

//		��ť
		JButton jbutton_5 = new JButton("ɾ��");
		JButton jbutton_6 = new JButton("���");
		jbutton_5.setFont(font);
		jbutton_6.setFont(font);
		StudentUI.jpanel_1.add(jbutton_5);
		StudentUI.jpanel_1.add(jbutton_6);

//		ע�����
		StudentListen_4 e_4 = new StudentListen_4(jbutton_5, jbutton_6, jtextfield_1);
		jbutton_5.addActionListener(e_4);
		jbutton_6.addActionListener(e_4);
	}

//	��ѯ ѧ������
	public static void init_6() {
//		������
		StudentUI.jpanel_1.removeAll();
//		ˢ�����
		StudentUI.jpanel_1.updateUI();
//		����
		Font font = new Font("����", Font.PLAIN, 15);
//		ѧ����
		String s[] = new String[7];
		s[0] = "ѧ       �ţ�";
		s[1] = "��       ����";
		s[2] = "j a v a��";
		s[3] = "��       ����";
		s[4] = "��ɢ��ѧ��";
		s[5] = "Ӣ       �";
		s[6] = "��       �֣�";

//		��ǩ
		JLabel jlabel[] = new JLabel[7];
//		�ı���
		JTextField jtextfield[] = new JTextField[7];
//		��ť
		JButton jbutton_8 = new JButton("��ѯ");
		JButton jbutton_9 = new JButton("���");

		jbutton_8.setFont(font);
		jbutton_9.setFont(font);

		JLabel jlabel1 = new JLabel("ͨ��ѧ�Ų�ѯ                                ");
		StudentUI.jpanel_1.add(jlabel1);
//		ʵ����
		for (int i = 0, j = 0; i < 7; i++, j++) {
			jlabel[i] = new JLabel(s[i]);
			StudentUI.jpanel_1.add(jlabel[i]);
			jtextfield[i] = new JTextField(12);
			StudentUI.jpanel_1.add(jtextfield[i]);
//			j���ư�ť����Ӵ�����ֹ�ظ����
			if (j == 0) {
				StudentUI.jpanel_1.add(jbutton_8);
				StudentUI.jpanel_1.add(jbutton_9);
			}
//			�����ı��򲻿ɱ༭
			else {
				jtextfield[i].setEditable(false);
			}
		}

//		ע�����
		StudentListen_5 e_5 = new StudentListen_5(jbutton_8, jbutton_9, jtextfield);
		jbutton_8.addActionListener(e_5);
		jbutton_9.addActionListener(e_5);
	}

	// �����ֲ�ѯ����
	public static void init_7() {
//		������
		StudentUI.jpanel_1.removeAll();
//		ˢ�����
		StudentUI.jpanel_1.updateUI();
//		����
		Font font = new Font("����", Font.PLAIN, 15);

		JLabel jlabel1 = new JLabel("ͨ��������ѯ                                ");
		StudentUI.jpanel_1.add(jlabel1);

		String s[] = new String[1];
		s[0] = "��       ����";
		JLabel jlabel = new JLabel();
		JTextField jtextfield = new JTextField();
		StudentUI.jpanel_1.add(jlabel);
		jtextfield = new JTextField(12);
		StudentUI.jpanel_1.add(jtextfield);
//		��ť
		JButton jbutton_13 = new JButton("��ѯ");
		JButton jbutton_14 = new JButton("���");
		;
		jbutton_13.setFont(font);
		jbutton_14.setFont(font);

		StudentUI.jpanel_1.add(jbutton_13);
		StudentUI.jpanel_1.add(jbutton_14);

//		ע�����
		StudentListen_6 e_6 = new StudentListen_6(jbutton_13, jbutton_14, jtextfield);
		jbutton_13.addActionListener(e_6);
		jbutton_14.addActionListener(e_6);
	}

	// ѧϰ�ɼ��������
	public static void init_8(ArrayList<StudentInformation> select_student) {

		// ��������
		JFrame j = new JFrame("ѧ����Ϣ");
		j.setSize(615, 335);
		j.setLayout(null);
		// ���ڲ��ܵ���
		j.setResizable(false);

		// �����ı���������ʾ����ѧ����Ϣ
		JTextArea j_2 = new JTextArea("�ı������Ի���������\n�رյ�ǰ���ڣ��ٴε����ѯ����ѧ����ť����ˢ�£�����\n-----------------------------------\n");
		// �����ı������ܱ༭
		j_2.setEditable(false);
		// ��j1��Ϊ�ɹ������sp����ʾ����
		JScrollPane sp = new JScrollPane(j_2);
		sp.setLocation(0, 0);
		sp.setSize(600, 300);
		j.add(sp);

		// ѧ����ǰ������
		j_2.append("ѧ����ǰ������Ϊ��" + select_student.size() + "\n");

		String s[] = new String[StudentInformation.number];
		s[0] = "ѧ�ţ�";
		s[1] = "������";
		s[2] = "�Ա�";
		s[3] = "�������ڣ�";
		s[4] = "java��";
		s[5] = "������";
		s[6] = "��ɢ��ѧ��";
		s[7] = "Ӣ�";
		s[8] = "�ܷ֣�";
//		����Ϣ��ӵ������ı���
		int javaSum = 0;
		int physicalSum = 0;
		int DMSum = 0;
		int EnglishSum = 0;
		int totalSum = 0;
		for (int i = 0; i < select_student.size(); i++) {
			j_2.append(s[0] + select_student.get(i).get_Id() + "    ");
			j_2.append(s[1] + select_student.get(i).get_Name() + "    ");
			j_2.append(s[2] + select_student.get(i).getGender() + "    ");
			j_2.append(s[3] + select_student.get(i).getDate() + "    ");
			if (select_student.get(i).get_java() < 0) {
				j_2.append(s[4] + "\\    ");
			} else {
				j_2.append(s[4] + select_student.get(i).get_java() + "    ");
				javaSum += select_student.get(i).get_java();
			}
			if (select_student.get(i).get_physical() < 0) {
				j_2.append(s[5] + "\\    ");
			} else {
				j_2.append(s[5] + select_student.get(i).get_physical() + "    ");
				physicalSum += select_student.get(i).get_physical();
			}
			if (select_student.get(i).get_Discrete_Mathematics() < 0) {
				j_2.append(s[6] + "\\    ");
			} else {
				j_2.append(s[6] + select_student.get(i).get_Discrete_Mathematics() + "    ");
				DMSum += select_student.get(i).get_Discrete_Mathematics();
			}
			if (select_student.get(i).get_English() < 0) {
				j_2.append(s[7] + "\\    ");
			} else {
				j_2.append(s[7] + select_student.get(i).get_English() + "    ");
				EnglishSum += select_student.get(i).get_English();
			}
			if (select_student.get(i).get_Total() < 0) {
				j_2.append(s[8] + "\\    \n");
			} else {
				j_2.append(s[8] + select_student.get(i).get_Total() + "\n");
				totalSum += select_student.get(i).get_Total();
			}
		}
		j_2.append("-----------------------------------\nƽ����\n");

		if (select_student.size() == 0) {
			j_2.append("java:\\    ����:\\    ��ɢ��ѧ:\\    Ӣ��:\\    �ܳɼ�:\\");
		} else
			j_2.append("java:" + javaSum / select_student.size() + "    ����:" + physicalSum / select_student.size()
					+ "    ��ɢ��ѧ:" + DMSum / select_student.size() + "    Ӣ��:" + EnglishSum / select_student.size()
					+ "    �ܳɼ�:" + totalSum / select_student.size());
//		������ʾ
		j.setLocationRelativeTo(null);
//		��ʾ����
		j.setVisible(true);
	}

//	����ѧ����Ϣ����
	public static void init_9() {

		// �������
		FileOutputStream out = null;
		try {
			// ����·���ļ���
			out = new FileOutputStream("D:\\studentMessage_1.txt");
			String student;
			String explain = "���α�����Ϣ���£�\n";
			byte buf[] = explain.getBytes();
			out.write(buf);
			for (int i = 0; i < StudentInformation.all_student.size(); i++) {
				// ����������,д������
				student = "ѧ�ţ�" + StudentInformation.all_student.get(i).get_Id() + "   ";
				byte buffer[] = student.getBytes();
				out.write(buffer);

				student = "������" + StudentInformation.all_student.get(i).get_Name() + "   ";
				byte buffer1[] = student.getBytes();
				out.write(buffer1);

				student = "�Ա�" + StudentInformation.all_student.get(i).getGender() + "   ";
				byte buffer2[] = student.getBytes();
				out.write(buffer2);

				student = "�������ڣ�" + StudentInformation.all_student.get(i).getDate() + "   ";
				byte buffer3[] = student.getBytes();
				out.write(buffer3);

				if (StudentInformation.all_student.get(i).get_java() < 0) {
					student = "java��" + "\\   ";
				} else
					student = "java��" + StudentInformation.all_student.get(i).get_java() + "   ";
				byte buffer4[] = student.getBytes();
				out.write(buffer4);

				if (StudentInformation.all_student.get(i).get_physical() < 0) {
					student = "������" + "\\   ";
				} else
					student = "������" + StudentInformation.all_student.get(i).get_physical() + "   ";
				byte buffer5[] = student.getBytes();
				out.write(buffer5);

				if (StudentInformation.all_student.get(i).get_Discrete_Mathematics() < 0) {
					student = "��ɢ��ѧ��" + "\\   ";
				} else
					student = "��ɢ��ѧ��" + StudentInformation.all_student.get(i).get_Discrete_Mathematics() + "   ";
				byte buffer6[] = student.getBytes();
				out.write(buffer6);

				if (StudentInformation.all_student.get(i).get_English() < 0) {
					student = "Ӣ�" + "\\   ";
				} else
					student = "Ӣ�" + StudentInformation.all_student.get(i).get_English() + "   ";
				byte buffer7[] = student.getBytes();
				out.write(buffer7);

				if (StudentInformation.all_student.get(i).get_Total() < 0) {
					student = "�ܷ֣�" + "\\   ";
				} else
					student = "�ܷ֣�" + StudentInformation.all_student.get(i).get_Total() + "   ";
				byte buffer8[] = student.getBytes();
				out.write(buffer8);

				// ����
				out.write('\n');
			}
			// ����
			out.write('\n');
			out.write('\n');
			JOptionPane.showMessageDialog(null, "����ɹ�������\n����·��Ϊ��D:\\\\studentMessage_1.txt", "��ʾ",
					JOptionPane.PLAIN_MESSAGE);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	// ��ѧ���������
	public static void init_10() {
//		����ı���
		StudentUI.j_1.setText("");
//		��ʱ�洢��Ϣ
		StudentInformation student = new StudentInformation();

		String s[] = new String[StudentInformation.number];
		s[0] = "ѧ�ţ�";
		s[1] = "������";
		s[2] = "�Ա�";
		s[3] = "�������ڣ�";
		s[4] = "java��";
		s[5] = "������";
		s[6] = "��ɢ��ѧ��";
		s[7] = "Ӣ�";
		s[8] = "�ܷ֣�";

		for (int i = 0; i < StudentInformation.all_student.size() - 1; i++) {
			for (int j = 0; j < StudentInformation.all_student.size() - 1; j++) {
				if (StudentInformation.all_student.get(j).get_Id() > StudentInformation.all_student.get(j + 1)
						.get_Id()) {
					student = StudentInformation.all_student.get(j);
					StudentInformation.all_student.set(j, StudentInformation.all_student.get(j + 1));
					StudentInformation.all_student.set(j + 1, student);
				}
			}
		}

		j_1.append("��ѧ������\n-----------------------------------\n");
//		�����չ�����ı���
		for (int i = 0; i < StudentInformation.all_student.size(); i++) {
//			�����Ϣ
			j_1.append(s[0] + StudentInformation.all_student.get(i).get_Id() + "    ");
			j_1.append(s[1] + StudentInformation.all_student.get(i).get_Name() + "    ");
			j_1.append(s[2] + StudentInformation.all_student.get(i).getGender() + "    ");
			j_1.append(s[3] + StudentInformation.all_student.get(i).getDate() + "    ");
			if (StudentInformation.all_student.get(i).get_java() < 0) {
				j_1.append(s[4] + "\\" + "    ");
			} else
				j_1.append(s[4] + StudentInformation.all_student.get(i).get_java() + "    ");
			if (StudentInformation.all_student.get(i).get_physical() < 0) {
				j_1.append(s[5] + "\\" + "    ");
			} else
				j_1.append(s[5] + StudentInformation.all_student.get(i).get_physical() + "    ");
			if (StudentInformation.all_student.get(i).get_Discrete_Mathematics() < 0) {
				j_1.append(s[6] + "\\" + "    ");
			} else
				j_1.append(s[6] + StudentInformation.all_student.get(i).get_Discrete_Mathematics() + "    ");
			if (StudentInformation.all_student.get(i).get_English() < 0) {
				j_1.append(s[7] + "\\" + "    ");
			} else
				j_1.append(s[7] + StudentInformation.all_student.get(i).get_English() + "    ");
			if (StudentInformation.all_student.get(i).get_Total() < 0) {
				j_1.append(s[8] + "\\" + "\n");
			} else
				j_1.append(s[8] + StudentInformation.all_student.get(i).get_Total() + "\n");
		}
	}

//	���ֽܷ����������
	public static void init_11() {
//		����ı���
		StudentUI.j_1.setText("");
//		��ʱ�洢��Ϣ
		StudentInformation student = new StudentInformation();
//		ð������
		for (int i = 0; i < StudentInformation.all_student.size() - 1; i++) {
			for (int j = 0; j < StudentInformation.all_student.size() - 1; j++) {
				if (StudentInformation.all_student.get(j).get_Total() < StudentInformation.all_student.get(j + 1)
						.get_Total()) {
					student = StudentInformation.all_student.get(j);
					StudentInformation.all_student.set(j, StudentInformation.all_student.get(j + 1));
					StudentInformation.all_student.set(j + 1, student);
				}
			}
		}

		String s[] = new String[StudentInformation.number];
		s[0] = "ѧ�ţ�";
		s[1] = "������";
		s[2] = "�Ա�";
		s[3] = "�������ڣ�";
		s[4] = "java��";
		s[5] = "������";
		s[6] = "��ɢ��ѧ��";
		s[7] = "Ӣ�";
		s[8] = "�ܷ֣�";

		j_1.append("���ֽܷ�������\n-----------------------------------\n");

//		�����չ�����ı���
		for (int i = 0; i < StudentInformation.all_student.size(); i++) {
//			�����Ϣ
			j_1.append(s[0] + StudentInformation.all_student.get(i).get_Id() + "    ");
			j_1.append(s[1] + StudentInformation.all_student.get(i).get_Name() + "    ");
			j_1.append(s[2] + StudentInformation.all_student.get(i).getGender() + "    ");
			j_1.append(s[3] + StudentInformation.all_student.get(i).getDate() + "    ");
			if (StudentInformation.all_student.get(i).get_java() < 0) {
				j_1.append(s[4] + "\\" + "    ");
			} else
				j_1.append(s[4] + StudentInformation.all_student.get(i).get_java() + "    ");
			if (StudentInformation.all_student.get(i).get_physical() < 0) {
				j_1.append(s[5] + "\\" + "    ");
			} else
				j_1.append(s[5] + StudentInformation.all_student.get(i).get_physical() + "    ");
			if (StudentInformation.all_student.get(i).get_Discrete_Mathematics() < 0) {
				j_1.append(s[6] + "\\" + "    ");
			} else
				j_1.append(s[6] + StudentInformation.all_student.get(i).get_Discrete_Mathematics() + "    ");
			if (StudentInformation.all_student.get(i).get_English() < 0) {
				j_1.append(s[7] + "\\" + "    ");
			} else
				j_1.append(s[7] + StudentInformation.all_student.get(i).get_English() + "    ");
			if (StudentInformation.all_student.get(i).get_Total() < 0) {
				j_1.append(s[8] + "\\" + "\n");
			} else
				j_1.append(s[8] + StudentInformation.all_student.get(i).get_Total() + "\n");
		}
	}

//	��ĳ�ƽ����������
	public static void init_12(String str) {
//		����ı���
		StudentUI.j_1.setText("");
//		��ʱ�洢��Ϣ
		StudentInformation student = new StudentInformation();

		String s[] = new String[StudentInformation.number];
		s[0] = "ѧ�ţ�";
		s[1] = "������";
		s[2] = "�Ա�";
		s[3] = "�������ڣ�";
		s[4] = "java��";
		s[5] = "������";
		s[6] = "��ɢ��ѧ��";
		s[7] = "Ӣ�";
		s[8] = "�ܷ֣�";

		for (int i = 0; i < StudentInformation.all_student.size() - 1; i++) {
			for (int j = 0; j < StudentInformation.all_student.size() - 1; j++) {
				if (str.equals("java")) {
//			ð������

					if (StudentInformation.all_student.get(j).get_java() < StudentInformation.all_student.get(j + 1)
							.get_java()) {
						student = StudentInformation.all_student.get(j);
						StudentInformation.all_student.set(j, StudentInformation.all_student.get(j + 1));
						StudentInformation.all_student.set(j + 1, student);
					}
				} else if (str.equals("����")) {
//			ð������

					if (StudentInformation.all_student.get(j).get_physical() < StudentInformation.all_student.get(j + 1)
							.get_physical()) {
						student = StudentInformation.all_student.get(j);
						StudentInformation.all_student.set(j, StudentInformation.all_student.get(j + 1));
						StudentInformation.all_student.set(j + 1, student);
					}

				} else if (str.equals("��ɢ��ѧ")) {
//			ð������

					if (StudentInformation.all_student.get(j)
							.get_Discrete_Mathematics() < StudentInformation.all_student.get(j + 1)
									.get_Discrete_Mathematics()) {
						student = StudentInformation.all_student.get(j);
						StudentInformation.all_student.set(j, StudentInformation.all_student.get(j + 1));
						StudentInformation.all_student.set(j + 1, student);
					}

				} else if (str.equals("Ӣ��")) {
//			ð������

					if (StudentInformation.all_student.get(j).get_English() < StudentInformation.all_student.get(j + 1)
							.get_English()) {
						student = StudentInformation.all_student.get(j);
						StudentInformation.all_student.set(j, StudentInformation.all_student.get(j + 1));
						StudentInformation.all_student.set(j + 1, student);
					}

				}
			}
		}

		if (str.equals("java")) {
			j_1.append("��java��������\n-----------------------------------\n");
		} else if (str.equals("����")) {
			j_1.append("��������������\n-----------------------------------\n");
		} else if (str.equals("��ɢ��ѧ")) {
			j_1.append("����ɢ��ѧ��������\n-----------------------------------\n");
		} else if (str.equals("Ӣ��")) {
			j_1.append("��Ӣ�ｵ������\n-----------------------------------\n");
		}

		for (int i = 0; i < StudentInformation.all_student.size(); i++) {
			j_1.append(s[0] + StudentInformation.all_student.get(i).get_Id() + "    ");
			j_1.append(s[1] + StudentInformation.all_student.get(i).get_Name() + "    ");
			j_1.append(s[2] + StudentInformation.all_student.get(i).getGender() + "    ");
			j_1.append(s[3] + StudentInformation.all_student.get(i).getDate() + "    ");
			if (StudentInformation.all_student.get(i).get_java() < 0) {
				j_1.append(s[4] + "\\" + "    ");
			} else
				j_1.append(s[4] + StudentInformation.all_student.get(i).get_java() + "    ");
			if (StudentInformation.all_student.get(i).get_physical() < 0) {
				j_1.append(s[5] + "\\" + "    ");
			} else
				j_1.append(s[5] + StudentInformation.all_student.get(i).get_physical() + "    ");
			if (StudentInformation.all_student.get(i).get_Discrete_Mathematics() < 0) {
				j_1.append(s[6] + "\\" + "    ");
			} else
				j_1.append(s[6] + StudentInformation.all_student.get(i).get_Discrete_Mathematics() + "    ");
			if (StudentInformation.all_student.get(i).get_English() < 0) {
				j_1.append(s[7] + "\\" + "    ");
			} else
				j_1.append(s[7] + StudentInformation.all_student.get(i).get_English() + "    ");
			if (StudentInformation.all_student.get(i).get_Total() < 0) {
				j_1.append(s[8] + "\\" + "\n");
			} else
				j_1.append(s[8] + StudentInformation.all_student.get(i).get_Total() + "\n");
		}
	}

//	���ȫ��ѧ������
	public static void init_13(ArrayList<StudentInformation> select_student) {

		// ��������
		JFrame j = new JFrame("ѧ����Ϣ");
		j.setSize(615, 335);
		j.setLayout(null);
		// ���ڲ��ܵ���
		j.setResizable(false);

		// �����ı���������ʾ����ѧ����Ϣ
		JTextArea j_2 = new JTextArea("�ı������Ի���������\n�رյ�ǰ���ڣ��ٴε����ѯ����ѧ����ť����ˢ�£�����\n-----------------------------------\n");
		// �����ı������ܱ༭
		j_2.setEditable(false);
		// ��j1��Ϊ�ɹ������sp����ʾ����
		JScrollPane sp = new JScrollPane(j_2);
		sp.setLocation(0, 0);
		sp.setSize(600, 300);
		j.add(sp);

		// ѧ����ǰ������
		j_2.append("ѧ����ǰ������Ϊ��" + select_student.size() + "\n\n");

		String s[] = new String[StudentInformation.number];
		s[0] = "ѧ�ţ�";
		s[1] = "������";
		s[2] = "�Ա�";
		s[3] = "�������ڣ�";
		s[4] = "java��";
		s[5] = "������";
		s[6] = "��ɢ��ѧ��";
		s[7] = "Ӣ�";
		s[8] = "�ܷ֣�";

//		����Ϣ��ӵ������ı���
		for (int i = 0; i < select_student.size(); i++) {
			j_2.append(s[0] + select_student.get(i).get_Id() + "    ");
			j_2.append(s[1] + select_student.get(i).get_Name() + "    ");
			j_2.append(s[2] + select_student.get(i).getGender() + "    ");
			j_2.append(s[3] + select_student.get(i).getDate() + "    ");
			if (select_student.get(i).get_java() < 0) {
				j_2.append(s[4] + "\\    ");
			} else
				j_2.append(s[4] + select_student.get(i).get_java() + "    ");
			if (select_student.get(i).get_physical() < 0) {
				j_2.append(s[5] + "\\    ");
			} else
				j_2.append(s[5] + select_student.get(i).get_physical() + "    ");
			if (select_student.get(i).get_Discrete_Mathematics() < 0) {
				j_2.append(s[6] + "\\    ");
			} else
				j_2.append(s[6] + select_student.get(i).get_Discrete_Mathematics() + "    ");
			if (select_student.get(i).get_English() < 0) {
				j_2.append(s[7] + "\\    ");
			} else
				j_2.append(s[7] + select_student.get(i).get_English() + "    ");
			if (select_student.get(i).get_Total() < 0) {
				j_2.append(s[8] + "\\    \n");
			} else
				j_2.append(s[8] + select_student.get(i).get_Total() + "\n");
		}
//		������ʾ
		j.setLocationRelativeTo(null);
//		��ʾ����
		j.setVisible(true);
	}

	// �����ļ�
	public static void init_14() {

//		������
		StudentUI.jpanel_1.removeAll();
//		ˢ�����
		StudentUI.jpanel_1.updateUI();

		JLabel jlabel1 = new JLabel("�����ļ�                                        ");
		StudentUI.jpanel_1.add(jlabel1);

		JLabel jlabel = new JLabel("����������Ҫ������ļ���ַ��");
		StudentUI.jpanel_1.add(jlabel);

		JTextField jtextfield = new JTextField(12);
		StudentUI.jpanel_1.add(jtextfield);

		// ��ť
		JButton jbutton_1 = new JButton("�ύ");

//				���밴ť
		StudentUI.jpanel_1.add(jbutton_1);

//				ע�����
		StudentListen_7 e_7 = new StudentListen_7(jbutton_1, jtextfield);
		jbutton_1.addActionListener(e_7);
	}

//	ѧ��������
	public void init_15() {

//		���ڴ�С
		jframe_1.setSize(850, 500);
//		�ղ���
		jframe_1.setLayout(null);
//		���ڲ��ɵ���
		jframe_1.setResizable(false);
//		�رմ������˳�����
		jframe_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		�˵���
		JMenuBar bar = new JMenuBar();
//		һ���˵�
		JMenu men_1 = new JMenu("��������");
		JMenu men_2 = new JMenu("����");
//		�Ӳ˵�

		JMenuItem item_5 = new JMenuItem("��ѯ�ɼ�");
		JMenuItem item_6 = new JMenuItem("ѧϰ�������");

		JMenuItem item_8 = new JMenuItem("��ѧ������");
		JMenuItem item_9 = new JMenuItem("���ֽܷ���");
		JMenuItem item_10 = new JMenuItem("��ĳ��Ŀ����");
		JMenuItem item_11 = new JMenuItem("�����ļ�");
//		��������
		Font font = new Font("����", Font.PLAIN, 15);

//		���ò˵�����
		men_1.setFont(font);
		men_2.setFont(font);
		item_5.setFont(font);
		item_6.setFont(font);
		item_8.setFont(font);
		item_9.setFont(font);
		item_10.setFont(font);
		item_11.setFont(font);
//		����

		men_1.add(item_5);
		men_1.add(item_6);
		men_1.add(item_11);

		men_2.add(item_8);
		men_2.add(item_9);
		men_2.add(item_10);

		bar.add(men_1);
		bar.add(men_2);
		jframe_1.setJMenuBar(bar);

//		�������λ�á���С����ɫ
		jpanel_1.setBounds(0, 0, 200, 500);
		jpanel_2.setBounds(210, 0, 640, 500);
		jpanel_1.setBackground(Color.LIGHT_GRAY);
		jpanel_2.setBackground(Color.LIGHT_GRAY);
		jframe_1.add(jpanel_1);
		jframe_1.add(jpanel_2);

		// �����ı������ܱ༭
		j_1.setEditable(false);
		// ��j1��Ϊ�ɹ������sp����ʾ����
		JScrollPane sp = new JScrollPane(j_1);
		sp.setSize(625, 440);
		StudentUI.jpanel_2.add(sp);

		JScrollPane scrollPane = new JScrollPane(jpanel_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setSize(200, 440);
		jframe_1.add(scrollPane);

//		���ھ���
		jframe_1.setLocationRelativeTo(null);
//		������ʾ
		jframe_1.setVisible(true);

//		ע�� ��ѯѧ�� ��ť�ļ���
		item_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] options = { "ͨ��ѧ�Ų�ѯ", "ͨ��������ѯ" };
				String s = (String) JOptionPane.showInputDialog(null, "���������ѡ�", "��ʾ", JOptionPane.QUESTION_MESSAGE,
						null, options, null);
				if (s != null) {
					if (s.equals("ͨ��ѧ�Ų�ѯ")) {
						StudentUI.init_6();
					} else if (s.equals("ͨ��������ѯ")) {
						StudentUI.init_7();
					}
				}
			}
		});
		// ѧϰ������� ��ť����
		item_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				StudentUI.init_11();
				StudentUI.init_8(StudentInformation.all_student);

			}
		});
		// ��ѧ������ ��ť����
		item_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				StudentUI.init_10();

			}
		});
//		�� �ֽܷ���ť �ļ���
		item_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentUI.init_11();
			}
		});
//		�� ĳ�ƽ���ť �ļ���
		item_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] options = { "java", "����", "��ɢ��ѧ", "Ӣ��" };
				String s = (String) JOptionPane.showInputDialog(null, "���������ѡ�", "��ʾ", JOptionPane.QUESTION_MESSAGE,
						null, options, null);
				if (s != null) {
					StudentUI.init_12(s);
				}
			}
		});
		// �����ļ���ť����
		item_11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				���÷���
				StudentUI.init_14();
			}
		});
	}
}
