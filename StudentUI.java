package myproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

//		定义字体
		Font font = new Font("黑体", Font.PLAIN, 15);
		item_2.setFont(font);

//		设置菜单字体
		men_1.setFont(font);
		men_2.setFont(font);
		item_1.setFont(font);

//		加入
		men_1.add(item_1);
		men_1.add(item_2);

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
		JButton jbutton_3 = new JButton("提交");
		JButton jbutton_4 = new JButton("清除");
//		加入按钮
		jpanel_1.add(jbutton_3);
		jpanel_1.add(jbutton_4);

//		注册监听
		StudentListen_4 e_4 = new StudentListen_4(jbutton_3, jbutton_4, jtextfield, i);
		jbutton_3.addActionListener(e_4);
		jbutton_4.addActionListener(e_4);

	}

}