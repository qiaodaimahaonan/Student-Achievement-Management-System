package myproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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

//	定义容器
	public static JFrame jframe_1 = new JFrame("学生成绩管理系统");
//	定义面板
	public static JPanel jpanel_1 = new JPanel(new ModifiedFlowLayout());// 布局
	public static JPanel jpanel_2 = new JPanel(null);// 空布局
//	设置文本区用于显示信息
	public static JTextArea j_1 = new JTextArea();

	public static void main(String[] args) {

//		实例化
		StudentUI ui = new StudentUI();

//自动保存		
		Timer timer = new Timer();
		// 间隔周期(/毫秒数)
		long intevalPeriod = 600 * 1000;
		// 每十分钟执行一次
		TimerTask task = new TimerTask() {
			public void run() {
				init_9();
			}
		};
		timer.scheduleAtFixedRate(task, intevalPeriod, intevalPeriod);

//		调用方法
		ui.init_1();
	}

//	主界面
	public void init_1() {

//		窗口大小
		jframe_1.setSize(850, 500);
//		空布局
		jframe_1.setLayout(null);
//		窗口不可调整
		jframe_1.setResizable(false);
//		关闭窗口则退出程序
		jframe_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		菜单栏
		JMenuBar bar = new JMenuBar();
//		一级菜单
		JMenu men_1 = new JMenu("基本操作");
		JMenu men_2 = new JMenu("排序");
//		子菜单
		JMenuItem item_1 = new JMenuItem("添加学生");
		JMenuItem item_2 = new JMenuItem("导入成绩");
		JMenuItem item_3 = new JMenuItem("修改信息");
		JMenuItem item_4 = new JMenuItem("删除学生");
		JMenuItem item_5 = new JMenuItem("查询成绩");
		JMenuItem item_6 = new JMenuItem("学习情况报表");
		JMenuItem item_7 = new JMenuItem("保存");

		JMenuItem item_8 = new JMenuItem("按学号升序");
		JMenuItem item_9 = new JMenuItem("按总分降序");
		JMenuItem item_10 = new JMenuItem("按某科目降序");
//		定义字体
		Font font = new Font("黑体", Font.PLAIN, 15);

//		设置菜单字体
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
//		加入
		men_1.add(item_1);
		men_1.add(item_2);
		men_1.add(item_3);
		men_1.add(item_4);
		men_1.add(item_5);
		men_1.add(item_6);
		men_1.add(item_7);

		men_2.add(item_8);
		men_2.add(item_9);
		men_2.add(item_10);

		bar.add(men_1);
		bar.add(men_2);
		jframe_1.setJMenuBar(bar);

//		设置面板位置、大小、颜色
		jpanel_1.setBounds(0, 0, 200, 500);
		jpanel_2.setBounds(210, 0, 640, 500);
		jpanel_1.setBackground(Color.LIGHT_GRAY);
		jpanel_2.setBackground(Color.LIGHT_GRAY);
		jframe_1.add(jpanel_1);
		jframe_1.add(jpanel_2);

		// 设置文本区不能编辑
		j_1.setEditable(false);
		// 将j1作为可滚动面板sp的显示区域
		JScrollPane sp = new JScrollPane(j_1);
		sp.setSize(625, 440);
		StudentUI.jpanel_2.add(sp);

		JScrollPane scrollPane = new JScrollPane(jpanel_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setSize(200, 440);
		jframe_1.add(scrollPane);

//		窗口居中
		jframe_1.setLocationRelativeTo(null);
//		窗口显示
		jframe_1.setVisible(true);

//		注册 添加学生 按钮的监听
		item_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				调用方法
				StudentUI.init_2();
			}
		});
		// 导入成绩 按钮监听
		item_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				init_10();
				String[] options = { "离散数学", "Java", "体育", "英语" };
				String s = (String) JOptionPane.showInputDialog(null, "请输入你的选项：", "提示", JOptionPane.QUESTION_MESSAGE,
						null, options, null);
				if (s != null) {
					int i = 0;
					if (s.equals("Java")) {
						i = 4;
					} else if (s.equals("体育")) {
						i = 5;
					} else if (s.equals("离散数学")) {
						i = 6;
					} else if (s.equals("英语")) {
						i = 7;
					}
					StudentUI.init_3(i);
				}
			}
		});
//		注册 修改学生 按钮的监听
		item_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentUI.init_4();
			}
		});
//		注册 删除学生 按钮的监听
		item_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentUI.init_5();
			}
		});
//		注册 查询学生 按钮的监听
		item_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] options = { "通过学号查询", "通过姓名查询" };
				String s = (String) JOptionPane.showInputDialog(null, "请输入你的选项：", "提示", JOptionPane.QUESTION_MESSAGE,
						null, options, null);
				if (s != null) {
					if (s.equals("通过学号查询")) {
						StudentUI.init_6();
					} else if (s.equals("通过姓名查询")) {
						StudentUI.init_7();
					}
				}
			}
		});
		// 学习情况报表 按钮监听
		item_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				StudentUI.init_11();
				StudentUI.init_8(StudentInformation.all_student);

			}
		});
//		保存 按钮的监听
		item_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentUI.init_9();
			}
		});
		// 按学号排序 按钮监听
		item_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				StudentUI.init_10();

			}
		});
//		按 总分降序按钮 的监听
		item_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentUI.init_11();
			}
		});
//		按 某科降序按钮 的监听
		item_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] options = { "java", "体育", "离散数学", "英语" };
				String s = (String) JOptionPane.showInputDialog(null, "请输入你的选项：", "提示", JOptionPane.QUESTION_MESSAGE,
						null, options, null);
				if (s != null) {
					StudentUI.init_12(s);
				}
			}
		});
	}

//	添加学生界面
	public static void init_2() {
//		清空组件
		StudentUI.jpanel_1.removeAll();
//		刷新面板
		StudentUI.jpanel_1.updateUI();

//		学科名
		String s[] = new String[4];
		s[0] = "学       号：";
		s[1] = "姓       名：";
		s[2] = "性       别：";
		s[3] = "出生日期：（yyyy/mm/dd）";

//		标签
		JLabel jlabel[] = new JLabel[4];
//		文本框
		JTextField jtextfield[] = new JTextField[4];
		JPanel jp1 = new JPanel();

		JLabel jlabel1 = new JLabel("添加学生                                        ");
		StudentUI.jpanel_1.add(jlabel1);

//		实例化
		for (int i = 0; i < 4; i++) {
			jlabel[i] = new JLabel(s[i]);
			StudentUI.jpanel_1.add(jlabel[i]);
			if (i == 2) {
				JRadioButton radioButton1 = new JRadioButton("男");
				JRadioButton radioButton2 = new JRadioButton("女");
				ButtonGroup bg = new ButtonGroup();
				bg.add(radioButton1);
				bg.add(radioButton2);
				jp1 = new JPanel(new GridLayout(1, 2));// 一行两列
				jp1.add(radioButton1);
				jp1.add(radioButton2);
				StudentUI.jpanel_1.add(jp1);
			} else {
				jtextfield[i] = new JTextField(12);
				StudentUI.jpanel_1.add(jtextfield[i]);
			}
		}

		// 学号自动生成
		jtextfield[0].setText(String.valueOf(StudentInformation.ID));
		jtextfield[0].setEditable(false);

//		按钮
		JButton jbutton_1 = new JButton("提交");
		JButton jbutton_2 = new JButton("清除");
//		加入按钮
		StudentUI.jpanel_1.add(jbutton_1);
		StudentUI.jpanel_1.add(jbutton_2);
//		注册监听
		StudentListen e_1 = new StudentListen(jp1, jbutton_1, jbutton_2, jtextfield);
		jbutton_1.addActionListener(e_1);
		jbutton_2.addActionListener(e_1);
	}

	// 导入成绩界面
	public static void init_3(int i) {

//		清空组件
		StudentUI.jpanel_1.removeAll();
//		刷新面板
		StudentUI.jpanel_1.updateUI();

		int num = StudentInformation.all_student.size();
//		文本框
		JTextField jtextfield[] = new JTextField[num];

		if (i == 4) {
			JLabel jlabel1 = new JLabel("导入java成绩                                ");
			StudentUI.jpanel_1.add(jlabel1);
		} else if (i == 5) {
			JLabel jlabel1 = new JLabel("导入体育成绩                                ");
			StudentUI.jpanel_1.add(jlabel1);
		} else if (i == 6) {
			JLabel jlabel1 = new JLabel("导入离散成绩                                ");
			StudentUI.jpanel_1.add(jlabel1);
		} else if (i == 7) {
			JLabel jlabel1 = new JLabel("导入英语成绩                                ");
			StudentUI.jpanel_1.add(jlabel1);
		}
//		实例化
		for (int j = 0; j < num; j++) {
			jtextfield[j] = new JTextField(12);
			jpanel_1.add(jtextfield[j]);
		}

//		按钮
		JButton jbutton_11 = new JButton("提交");
		JButton jbutton_12 = new JButton("清除");
//		加入按钮
		jpanel_1.add(jbutton_11);
		jpanel_1.add(jbutton_12);

//		注册监听
		StudentListen_2 e_2 = new StudentListen_2(jbutton_11, jbutton_12, jtextfield, i);
		jbutton_11.addActionListener(e_2);
		jbutton_12.addActionListener(e_2);

	}

//	修改 学生界面
	public static void init_4() {
//		清空组件
		StudentUI.jpanel_1.removeAll();
//		刷新面板
		StudentUI.jpanel_1.updateUI();
//		字体
		Font font = new Font("黑体", Font.PLAIN, 15);
//		学科名
		String s[] = new String[StudentInformation.number];
		s[0] = "学       号：";
		s[1] = "姓       名：";
		s[2] = "性       别：";
		s[3] = "出生日期：";
		s[4] = "j a v a：";
		s[5] = "体       育：";
		s[6] = "离散数学：";
		s[7] = "英       语：";
		s[8] = "总       分：";

//		标签
		JLabel jlabel[] = new JLabel[StudentInformation.number];
//		文本框
		JTextField jtextfield[] = new JTextField[StudentInformation.number];
//		按钮
		JButton jbutton_3 = new JButton("修改");
		JButton jbutton_4 = new JButton("清除");
		jbutton_3.setFont(font);
		jbutton_4.setFont(font);
		JPanel jp2 = new JPanel();

		JLabel jlabel1 = new JLabel("修改信息                                        ");
		StudentUI.jpanel_1.add(jlabel1);

//		实例化
		for (int i = 0, j = 0; i < StudentInformation.number; i++, j++) {
			jlabel[i] = new JLabel(s[i]);
			StudentUI.jpanel_1.add(jlabel[i]);
			if (i == 2) {
				JRadioButton radioButton1 = new JRadioButton("男");
				JRadioButton radioButton2 = new JRadioButton("女");
				ButtonGroup bg = new ButtonGroup();
				bg.add(radioButton1);
				bg.add(radioButton2);
				jp2 = new JPanel(new GridLayout(1, 2));// 一行两列
				jp2.add(radioButton1);
				jp2.add(radioButton2);
				StudentUI.jpanel_1.add(jp2);
			} else {
				jtextfield[i] = new JTextField(12);
				StudentUI.jpanel_1.add(jtextfield[i]);
			}
//			j控制添加次数防止重复添加
			if (j == 0) {
				JLabel L_1 = new JLabel("学号不能被修改!");
				JLabel L_2 = new JLabel("请在下面输入更新的信息：");
				StudentUI.jpanel_1.add(L_1);
				StudentUI.jpanel_1.add(L_2);
			}
		}

//		设置文本框默认值(总分自动计算,不可编辑)
		jtextfield[StudentInformation.number - 1].setText("自动计算，无需输入");
		jtextfield[StudentInformation.number - 1].setEditable(false);

		StudentUI.jpanel_1.add(jbutton_3);
		StudentUI.jpanel_1.add(jbutton_4);
//		注册监听
		StudentListen_3 e_3 = new StudentListen_3(jp2, jbutton_3, jbutton_4, jtextfield);
		jbutton_3.addActionListener(e_3);
		jbutton_4.addActionListener(e_3);
	}

//	删除 学生界面
	public static void init_5() {
//		清空组件
		StudentUI.jpanel_1.removeAll();
//		刷新面板
		StudentUI.jpanel_1.updateUI();
//		字体
		Font font = new Font("黑体", Font.PLAIN, 15);

		JLabel jlabel1 = new JLabel("删除学生                                        ");
		StudentUI.jpanel_1.add(jlabel1);

//		标签
		JLabel jlabel_1 = new JLabel(" 学       号：");
//		文本框
		JTextField jtextfield_1 = new JTextField(10);
//		添加到面板
		StudentUI.jpanel_1.add(jlabel_1);
		StudentUI.jpanel_1.add(jtextfield_1);

//		按钮
		JButton jbutton_5 = new JButton("删除");
		JButton jbutton_6 = new JButton("清除");
		jbutton_5.setFont(font);
		jbutton_6.setFont(font);
		StudentUI.jpanel_1.add(jbutton_5);
		StudentUI.jpanel_1.add(jbutton_6);

//		注册监听
		StudentListen_4 e_4 = new StudentListen_4(jbutton_5, jbutton_6, jtextfield_1);
		jbutton_5.addActionListener(e_4);
		jbutton_6.addActionListener(e_4);
	}

//	查询 学生界面
	public static void init_6() {
//		清空组件
		StudentUI.jpanel_1.removeAll();
//		刷新面板
		StudentUI.jpanel_1.updateUI();
//		字体
		Font font = new Font("黑体", Font.PLAIN, 15);
//		学科名
		String s[] = new String[7];
		s[0] = "学       号：";
		s[1] = "姓       名：";
		s[2] = "j a v a：";
		s[3] = "体       育：";
		s[4] = "离散数学：";
		s[5] = "英       语：";
		s[6] = "总       分：";

//		标签
		JLabel jlabel[] = new JLabel[7];
//		文本框
		JTextField jtextfield[] = new JTextField[7];
//		按钮
		JButton jbutton_8 = new JButton("查询");
		JButton jbutton_9 = new JButton("清除");

		jbutton_8.setFont(font);
		jbutton_9.setFont(font);

		JLabel jlabel1 = new JLabel("通过学号查询                                ");
		StudentUI.jpanel_1.add(jlabel1);
//		实例化
		for (int i = 0, j = 0; i < 7; i++, j++) {
			jlabel[i] = new JLabel(s[i]);
			StudentUI.jpanel_1.add(jlabel[i]);
			jtextfield[i] = new JTextField(12);
			StudentUI.jpanel_1.add(jtextfield[i]);
//			j控制按钮的添加次数防止重复添加
			if (j == 0) {
				StudentUI.jpanel_1.add(jbutton_8);
				StudentUI.jpanel_1.add(jbutton_9);
			}
//			设置文本框不可编辑
			else {
				jtextfield[i].setEditable(false);
			}
		}

//		注册监听
		StudentListen_5 e_5 = new StudentListen_5(jbutton_8, jbutton_9, jtextfield);
		jbutton_8.addActionListener(e_5);
		jbutton_9.addActionListener(e_5);
	}

	// 按名字查询界面
	public static void init_7() {
//		清空组件
		StudentUI.jpanel_1.removeAll();
//		刷新面板
		StudentUI.jpanel_1.updateUI();
//		字体
		Font font = new Font("黑体", Font.PLAIN, 15);

		JLabel jlabel1 = new JLabel("通过姓名查询                                ");
		StudentUI.jpanel_1.add(jlabel1);

		String s[] = new String[1];
		s[0] = "姓       名：";
		JLabel jlabel = new JLabel();
		JTextField jtextfield = new JTextField();
		StudentUI.jpanel_1.add(jlabel);
		jtextfield = new JTextField(12);
		StudentUI.jpanel_1.add(jtextfield);
//		按钮
		JButton jbutton_13 = new JButton("查询");
		JButton jbutton_14 = new JButton("清除");
		;
		jbutton_13.setFont(font);
		jbutton_14.setFont(font);

		StudentUI.jpanel_1.add(jbutton_13);
		StudentUI.jpanel_1.add(jbutton_14);

//		注册监听
		StudentListen_6 e_6 = new StudentListen_6(jbutton_13, jbutton_14, jtextfield);
		jbutton_13.addActionListener(e_6);
		jbutton_14.addActionListener(e_6);
	}

	// 学习成绩报表界面
	public static void init_8(ArrayList<StudentInformation> select_student) {

		// 设置容器
		JFrame j = new JFrame("学生信息");
		j.setSize(615, 335);
		j.setLayout(null);
		// 窗口不能调整
		j.setResizable(false);

		// 设置文本区用于显示所有学生信息
		JTextArea j_2 = new JTextArea("文本区可以滑动！！！\n关闭当前窗口，再次点击查询所有学生按钮可以刷新！！！\n-----------------------------------\n");
		// 设置文本区不能编辑
		j_2.setEditable(false);
		// 将j1作为可滚动面板sp的显示区域
		JScrollPane sp = new JScrollPane(j_2);
		sp.setLocation(0, 0);
		sp.setSize(600, 300);
		j.add(sp);

		// 学生当前总人数
		j_2.append("学生当前总人数为：" + select_student.size() + "\n");

		String s[] = new String[StudentInformation.number];
		s[0] = "学号：";
		s[1] = "姓名：";
		s[2] = "性别：";
		s[3] = "出生日期：";
		s[4] = "java：";
		s[5] = "体育：";
		s[6] = "离散数学：";
		s[7] = "英语：";
		s[8] = "总分：";
//		将信息添加到滚动文本区
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
		j_2.append("-----------------------------------\n平均分\n");

		if (select_student.size() == 0) {
			j_2.append("java:\\    体育:\\    离散数学:\\    英语:\\    总成绩:\\");
		} else
			j_2.append("java:" + javaSum / select_student.size() + "    体育:" + physicalSum / select_student.size()
					+ "    离散数学:" + DMSum / select_student.size() + "    英语:" + EnglishSum / select_student.size()
					+ "    总成绩:" + totalSum / select_student.size());
//		居中显示
		j.setLocationRelativeTo(null);
//		显示窗口
		j.setVisible(true);
	}

//	保存学生信息界面
	public static void init_9() {

		// 建立输出
		FileOutputStream out = null;
		try {
			// 设置路径文件名
			out = new FileOutputStream("D:\\studentMessage_1.txt");
			String student;
			String explain = "本次保存信息如下：\n";
			byte buf[] = explain.getBytes();
			out.write(buf);
			for (int i = StudentInformation.all_student.size() - 1; i >= 0; i--) {
				// 创建缓冲区,写入数据
				student = "学号：" + StudentInformation.all_student.get(i).get_Id() + "   ";
				byte buffer[] = student.getBytes();
				out.write(buffer);

				student = "姓名：" + StudentInformation.all_student.get(i).get_Name() + "   ";
				byte buffer1[] = student.getBytes();
				out.write(buffer1);

				student = "性别：" + StudentInformation.all_student.get(i).getGender() + "   ";
				byte buffer2[] = student.getBytes();
				out.write(buffer2);

				student = "出生日期：" + StudentInformation.all_student.get(i).getDate() + "   ";
				byte buffer3[] = student.getBytes();
				out.write(buffer3);

				if (StudentInformation.all_student.get(i).get_java() < 0) {
					student = "java：" + "\\   ";
				} else
					student = "java：" + StudentInformation.all_student.get(i).get_java() + "   ";
				byte buffer4[] = student.getBytes();
				out.write(buffer4);

				if (StudentInformation.all_student.get(i).get_physical() < 0) {
					student = "体育：" + "\\   ";
				} else
					student = "体育：" + StudentInformation.all_student.get(i).get_physical() + "   ";
				byte buffer5[] = student.getBytes();
				out.write(buffer5);

				if (StudentInformation.all_student.get(i).get_Discrete_Mathematics() < 0) {
					student = "离散数学：" + "\\   ";
				} else
					student = "离散数学：" + StudentInformation.all_student.get(i).get_Discrete_Mathematics() + "   ";
				byte buffer6[] = student.getBytes();
				out.write(buffer6);

				if (StudentInformation.all_student.get(i).get_English() < 0) {
					student = "英语：" + "\\   ";
				} else
					student = "英语：" + StudentInformation.all_student.get(i).get_English() + "   ";
				byte buffer7[] = student.getBytes();
				out.write(buffer7);

				if (StudentInformation.all_student.get(i).get_Total() < 0) {
					student = "总分：" + "\\   ";
				} else
					student = "总分：" + StudentInformation.all_student.get(i).get_Total() + "   ";
				byte buffer8[] = student.getBytes();
				out.write(buffer8);

				// 换行
				out.write('\n');
			}
			// 换行
			out.write('\n');
			out.write('\n');
			JOptionPane.showMessageDialog(null, "保存成功！！！\n保存路径为：D:\\\\studentMessage_1.txt", "提示",
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

	// 按学号排序界面
	public static void init_10() {
//		清空文本区
		StudentUI.j_1.setText("");
//		暂时存储信息
		StudentInformation student = new StudentInformation();

		String s[] = new String[StudentInformation.number];
		s[0] = "学号：";
		s[1] = "姓名：";
		s[2] = "性别：";
		s[3] = "出生日期：";
		s[4] = "java：";
		s[5] = "体育：";
		s[6] = "离散数学：";
		s[7] = "英语：";
		s[8] = "总分：";

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

		j_1.append("按学号排序\n-----------------------------------\n");
//		将结果展现在文本区
		for (int i = 0; i < StudentInformation.all_student.size(); i++) {
//			添加信息
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

//	按总分降序排序界面
	public static void init_11() {
//		清空文本区
		StudentUI.j_1.setText("");
//		暂时存储信息
		StudentInformation student = new StudentInformation();
//		冒泡排序法
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
		s[0] = "学号：";
		s[1] = "姓名：";
		s[2] = "性别：";
		s[3] = "出生日期：";
		s[4] = "java：";
		s[5] = "体育：";
		s[6] = "离散数学：";
		s[7] = "英语：";
		s[8] = "总分：";

		j_1.append("按总分降序排序\n-----------------------------------\n");

//		将结果展现在文本区
		for (int i = 0; i < StudentInformation.all_student.size(); i++) {
//			添加信息
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

//	按某科降序排序界面
	public static void init_12(String str) {
//		清空文本区
		StudentUI.j_1.setText("");
//		暂时存储信息
		StudentInformation student = new StudentInformation();

		String s[] = new String[StudentInformation.number];
		s[0] = "学号：";
		s[1] = "姓名：";
		s[2] = "性别：";
		s[3] = "出生日期：";
		s[4] = "java：";
		s[5] = "体育：";
		s[6] = "离散数学：";
		s[7] = "英语：";
		s[8] = "总分：";

		for (int i = 0; i < StudentInformation.all_student.size() - 1; i++) {
			for (int j = 0; j < StudentInformation.all_student.size() - 1; j++) {
				if (str.equals("java")) {
//			冒泡排序法

					if (StudentInformation.all_student.get(j).get_java() < StudentInformation.all_student.get(j + 1)
							.get_java()) {
						student = StudentInformation.all_student.get(j);
						StudentInformation.all_student.set(j, StudentInformation.all_student.get(j + 1));
						StudentInformation.all_student.set(j + 1, student);
					}
				} else if (str.equals("体育")) {
//			冒泡排序法

					if (StudentInformation.all_student.get(j).get_physical() < StudentInformation.all_student.get(j + 1)
							.get_physical()) {
						student = StudentInformation.all_student.get(j);
						StudentInformation.all_student.set(j, StudentInformation.all_student.get(j + 1));
						StudentInformation.all_student.set(j + 1, student);
					}

				} else if (str.equals("离散数学")) {
//			冒泡排序法

					if (StudentInformation.all_student.get(j)
							.get_Discrete_Mathematics() < StudentInformation.all_student.get(j + 1)
									.get_Discrete_Mathematics()) {
						student = StudentInformation.all_student.get(j);
						StudentInformation.all_student.set(j, StudentInformation.all_student.get(j + 1));
						StudentInformation.all_student.set(j + 1, student);
					}

				} else if (str.equals("英语")) {
//			冒泡排序法

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
			j_1.append("按java降序排序\n-----------------------------------\n");
		} else if (str.equals("体育")) {
			j_1.append("按体育降序排序\n-----------------------------------\n");
		} else if (str.equals("离散数学")) {
			j_1.append("按离散数学降序排序\n-----------------------------------\n");
		} else if (str.equals("英语")) {
			j_1.append("按英语降序排序\n-----------------------------------\n");
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

//	输出全部学生界面
	public static void init_13(ArrayList<StudentInformation> select_student) {

		// 设置容器
		JFrame j = new JFrame("学生信息");
		j.setSize(615, 335);
		j.setLayout(null);
		// 窗口不能调整
		j.setResizable(false);

		// 设置文本区用于显示所有学生信息
		JTextArea j_2 = new JTextArea("文本区可以滑动！！！\n关闭当前窗口，再次点击查询所有学生按钮可以刷新！！！\n-----------------------------------\n");
		// 设置文本区不能编辑
		j_2.setEditable(false);
		// 将j1作为可滚动面板sp的显示区域
		JScrollPane sp = new JScrollPane(j_2);
		sp.setLocation(0, 0);
		sp.setSize(600, 300);
		j.add(sp);

		// 学生当前总人数
		j_2.append("学生当前总人数为：" + select_student.size() + "\n\n");

		String s[] = new String[StudentInformation.number];
		s[0] = "学号：";
		s[1] = "姓名：";
		s[2] = "性别：";
		s[3] = "出生日期：";
		s[4] = "java：";
		s[5] = "体育：";
		s[6] = "离散数学：";
		s[7] = "英语：";
		s[8] = "总分：";

//		将信息添加到滚动文本区
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
//		居中显示
		j.setLocationRelativeTo(null);
//		显示窗口
		j.setVisible(true);
	}
}
