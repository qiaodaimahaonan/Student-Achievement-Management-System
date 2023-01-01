package myproject;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentListen implements ActionListener {

	JPanel jp1;
	JButton jbutton_1;
	JButton jbutton_2;
	JTextField jtextfield[];

	public StudentListen(JPanel jp1, JButton jbutton_1, JButton jbutton_2, JTextField jtextfield[]) {
		this.jp1 = jp1;
		this.jbutton_1 = jbutton_1;
		this.jbutton_2 = jbutton_2;
		this.jtextfield = jtextfield;
	}

	// 点击了 添加学生的提交 按钮
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		点击了提交按钮
		if (e.getSource() == jbutton_1) {

			// 判断是否进行了性别选择并读取选择
			String str = "";
			Component[] jcbs = jp1.getComponents();// 将勾选的内容存入数组
			for (Component component : jcbs) {
				JRadioButton jcb = (JRadioButton) component;
				if (jcb.isSelected()) {
					str += jcb.getText() + "";
				}
			}

			StudentInformation student = new StudentInformation(Integer.parseInt(jtextfield[0].getText()),
					jtextfield[1].getText(), str, jtextfield[3].getText(), -1, -1, -1, -1, -1);
//				将学生对象加入总对象中
			StudentInformation.all_student.add(student);
			JOptionPane.showMessageDialog(null, "添加学生成功！！！", "提示", JOptionPane.PLAIN_MESSAGE);
			StudentInformation.ID++;
		}
		StudentUI.init_2();

	}
}

//点击了导入成绩的提交按钮
class StudentListen_2 implements ActionListener {

	JButton jbutton_3;
	JButton jbutton_4;
	JTextField jtextfield[];
	int i;// 表示学科

	public StudentListen_2(JButton jbutton_3, JButton jbutton_4, JTextField jtextfield[], int i) {
		this.jbutton_3 = jbutton_3;
		this.jbutton_4 = jbutton_4;
		this.jtextfield = jtextfield;
		this.i = i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		boolean flag = true;
//		点击了 提交 按钮
		if (e.getSource() == jbutton_3) {
			if (i == 4) {
				for (int j = 0; j < StudentInformation.all_student.size(); j++) {
					jtextfield[j].setText(jtextfield[j].getText().replaceAll(" ", ""));// 去除成绩中误输的空格
					// 判断成绩是否在合理范围内（0—100）
					if (Integer.parseInt(jtextfield[j].getText()) > 100
							|| Integer.parseInt(jtextfield[j].getText()) < 0) {
						flag = false;
						break;
					} else
						StudentInformation.all_student.get(j).set_java(Integer.parseInt(jtextfield[j].getText()));
					// 求总分
					int sum = Integer.parseInt(jtextfield[j].getText());
					if (StudentInformation.all_student.get(j).get_Discrete_Mathematics() > 0)
						sum += StudentInformation.all_student.get(j).get_Discrete_Mathematics();
					if (StudentInformation.all_student.get(j).get_English() > 0)
						sum += StudentInformation.all_student.get(j).get_English();
					if (StudentInformation.all_student.get(j).get_physical() > 0)
						sum += StudentInformation.all_student.get(j).get_physical();
					StudentInformation.all_student.get(j).set_Total(sum);
				}
			} else if (i == 5) {
				for (int j = 0; j < StudentInformation.all_student.size(); j++) {
					jtextfield[j].setText(jtextfield[j].getText().replaceAll(" ", ""));
					if (Integer.parseInt(jtextfield[j].getText()) > 100
							|| Integer.parseInt(jtextfield[j].getText()) < 0) {
						flag = false;
						break;
					} else
						StudentInformation.all_student.get(j).set_physical(Integer.parseInt(jtextfield[j].getText()));
					int sum = Integer.parseInt(jtextfield[j].getText());
					if (StudentInformation.all_student.get(j).get_java() > 0)
						sum += StudentInformation.all_student.get(j).get_java();
					if (StudentInformation.all_student.get(j).get_Discrete_Mathematics() > 0)
						sum += StudentInformation.all_student.get(j).get_Discrete_Mathematics();
					if (StudentInformation.all_student.get(j).get_English() > 0)
						sum += StudentInformation.all_student.get(j).get_English();
					StudentInformation.all_student.get(j).set_Total(sum);
				}
			} else if (i == 6) {
				for (int j = 0; j < StudentInformation.all_student.size(); j++) {
					jtextfield[j].setText(jtextfield[j].getText().replaceAll(" ", ""));
					if (Integer.parseInt(jtextfield[j].getText()) > 100
							|| Integer.parseInt(jtextfield[j].getText()) < 0) {
						flag = false;
						break;
					} else
						StudentInformation.all_student.get(j)
								.set_Discrete_Mathematics(Integer.parseInt(jtextfield[j].getText()));
					int sum = Integer.parseInt(jtextfield[j].getText());
					if (StudentInformation.all_student.get(j).get_java() > 0)
						sum += StudentInformation.all_student.get(j).get_java();
					if (StudentInformation.all_student.get(j).get_English() > 0)
						sum += StudentInformation.all_student.get(j).get_English();
					if (StudentInformation.all_student.get(j).get_physical() > 0)
						sum += StudentInformation.all_student.get(j).get_physical();
					StudentInformation.all_student.get(j).set_Total(sum);
				}
			} else if (i == 7) {
				for (int j = 0; j < StudentInformation.all_student.size(); j++) {
					jtextfield[j].setText(jtextfield[j].getText().replaceAll(" ", ""));
					if (Integer.parseInt(jtextfield[j].getText()) > 100
							|| Integer.parseInt(jtextfield[j].getText()) < 0) {
						flag = false;
						break;
					} else
						StudentInformation.all_student.get(j).set_English(Integer.parseInt(jtextfield[j].getText()));
					int sum = Integer.parseInt(jtextfield[j].getText());
					if (StudentInformation.all_student.get(j).get_java() > 0)
						sum += StudentInformation.all_student.get(j).get_java();
					if (StudentInformation.all_student.get(j).get_Discrete_Mathematics() > 0)
						sum += StudentInformation.all_student.get(j).get_Discrete_Mathematics();
					if (StudentInformation.all_student.get(j).get_physical() > 0)
						sum += StudentInformation.all_student.get(j).get_physical();
					StudentInformation.all_student.get(j).set_Total(sum);
				}
			}
			if (flag) {
				JOptionPane.showMessageDialog(null, "成功添加成绩！！！", "提示", JOptionPane.PLAIN_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "请输入正确的学生成绩", "提示", JOptionPane.PLAIN_MESSAGE);
		} else {
//			点击了 清除 按钮
			for (int j = 0; j < StudentInformation.all_student.size(); j++) {
				jtextfield[j].setText("");
			}
		}
	}
}

//点击了修改学生的修改按钮
class StudentListen_3 implements ActionListener {

	JButton jbutton_5;
	JButton jbutton_6;
	JTextField jtextfield[];
	JPanel jp2;

	public StudentListen_3(JPanel jp2, JButton jbutton_5, JButton jbutton_6, JTextField jtextfield[]) {
		this.jp2 = jp2;
		this.jbutton_5 = jbutton_5;
		this.jbutton_6 = jbutton_6;
		this.jtextfield = jtextfield;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		点击了 修改 按钮
		if (e.getSource() == jbutton_5) {
			for (int i = 0; i < StudentInformation.all_student.size(); i++) {
//				学号相同则修改学生信息
				if (jtextfield[0].getText().equals("" + StudentInformation.all_student.get(i).get_Id())) {
//					修改信息(学号不可修改,总分重新计算)

					// 判断是否进行了性别选择并读取选择
					String str = "";
					Component[] jcbs = jp2.getComponents();// 将勾选的内容存入数组
					for (Component component : jcbs) {
						JRadioButton jcb = (JRadioButton) component;
						if (jcb.isSelected()) {
							str += jcb.getText() + "";
						}
					}
					if (str.equals("")) {
						JOptionPane.showMessageDialog(null, "请选择学生性别", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}

					if (jtextfield[4].getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "请输入java成绩", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					if (jtextfield[5].getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "请输入体育成绩", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					if (jtextfield[6].getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "请输入离散数学成绩", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					if (jtextfield[7].getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "请输入英语成绩", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}

					StudentInformation.all_student.get(i).set_Name(jtextfield[1].getText());
					StudentInformation.all_student.get(i).setGender(str);
					StudentInformation.all_student.get(i).setDate(jtextfield[3].getText());
					StudentInformation.all_student.get(i).set_java(Integer.parseInt(jtextfield[4].getText()));
					StudentInformation.all_student.get(i).set_physical(Integer.parseInt(jtextfield[5].getText()));
					StudentInformation.all_student.get(i)
							.set_Discrete_Mathematics(Integer.parseInt(jtextfield[6].getText()));
					StudentInformation.all_student.get(i).set_English(Integer.parseInt(jtextfield[7].getText()));

//						重新计算总分
					int sum = 0;
					for (int j = 4; j < StudentInformation.number - 1; j++) {
						sum += Integer.parseInt(jtextfield[j].getText());
					}
//						添加总分信息
					StudentInformation.all_student.get(i).set_Total(sum);
//						提示
					JOptionPane.showMessageDialog(null, "修改学生信息成功！！！", "提示", JOptionPane.PLAIN_MESSAGE);
					StudentUI.init_4();
					return;
				}
			}
//			未查询到学生，提示
			JOptionPane.showMessageDialog(null, "未查询到当前学生！！！\n修改失败！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
		} else {
			jtextfield[0].setText("");
		}
	}
}

//点击了删除学生的删除按钮
class StudentListen_4 implements ActionListener {

	JButton jbutton_5;
	JButton jbutton_6;
	JTextField jtextfield_1;

	public StudentListen_4(JButton jbutton_5, JButton jbutton_6, JTextField jtextfield_1) {
		this.jbutton_5 = jbutton_5;
		this.jbutton_6 = jbutton_6;
		this.jtextfield_1 = jtextfield_1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		点击了 删除 按钮
		if (e.getSource() == jbutton_5) {
			for (int i = 0; i < StudentInformation.all_student.size(); i++) {
//				学号相同则删除学生信息
				if (jtextfield_1.getText().equals("" + StudentInformation.all_student.get(i).get_Id())) {
//					删除信息
					StudentInformation.all_student.remove(i);
					JOptionPane.showMessageDialog(null, "删除学生信息成功！！！", "提示", JOptionPane.PLAIN_MESSAGE);
					return;// 结束
				}
			}
//			未查询到学生，提示
			JOptionPane.showMessageDialog(jbutton_5, "未查询到当前学生！！！\n删除失败！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
		} else {
			jtextfield_1.setText("");
		}
	}
}

//查询学生的 查询按钮 的监听
class StudentListen_5 implements ActionListener {

	JButton jbutton_8;
	JButton jbutton_9;
	JTextField jtextfield[];

	public StudentListen_5(JButton jbutton_8, JButton jbutton_9, JTextField jtextfield[]) {
		this.jbutton_8 = jbutton_8;
		this.jbutton_9 = jbutton_9;
		this.jtextfield = jtextfield;
	}

//	点击了 查询学生的查询 按钮
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		点击了 查询 按钮
		if (e.getSource() == jbutton_8) {
			for (int i = 0; i < StudentInformation.all_student.size(); i++) {
//				学号相同则输出学生信息
				if (jtextfield[0].getText().equals("" + StudentInformation.all_student.get(i).get_Id())) {
//					输出信息到文本框
					jtextfield[1].setText(StudentInformation.all_student.get(i).get_Name());
					if (StudentInformation.all_student.get(i).get_java() < 0) {
						jtextfield[2].setText("\\");
					} else
						jtextfield[2].setText("" + StudentInformation.all_student.get(i).get_java());
					if (StudentInformation.all_student.get(i).get_physical() < 0) {
						jtextfield[3].setText("\\");
					} else
						jtextfield[3].setText("" + StudentInformation.all_student.get(i).get_physical());
					if (StudentInformation.all_student.get(i).get_Discrete_Mathematics() < 0) {
						jtextfield[4].setText("\\");
					} else
						jtextfield[4].setText("" + StudentInformation.all_student.get(i).get_Discrete_Mathematics());
					if (StudentInformation.all_student.get(i).get_English() < 0) {
						jtextfield[5].setText("\\");
					} else
						jtextfield[5].setText("" + StudentInformation.all_student.get(i).get_English());
					if (StudentInformation.all_student.get(i).get_Total() < 0) {
						jtextfield[6].setText("\\");
					} else
						jtextfield[6].setText("" + StudentInformation.all_student.get(i).get_Total());
					return;// 结束
				}
			}
//			未查询到学生，提示
			JOptionPane.showMessageDialog(null, "未查询到该学生！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
		} else if (e.getSource() == jbutton_9) {
			jtextfield[0].setText("");
		}
	}

}

//点击了按名字查询的查询按钮
class StudentListen_6 implements ActionListener {
	JButton jbutton_13;
	JButton jbutton_14;
	JTextField jtextfield;

	public StudentListen_6(JButton jbutton_13, JButton jbutton_14, JTextField jtextfield) {
		this.jbutton_13 = jbutton_13;
		this.jbutton_14 = jbutton_14;
		this.jtextfield = jtextfield;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource() == jbutton_13) {
			boolean flag = false;
			ArrayList<StudentInformation> select_student = new ArrayList<StudentInformation>();
			for (int i = 0; i < StudentInformation.all_student.size(); i++) {
//				如果包含学生姓名
				if (StudentInformation.all_student.get(i).get_Name().contains(jtextfield.getText())) {
//					输出信息到文本框
					flag = true;
					select_student.add(StudentInformation.all_student.get(i));
				}
			}
			if (flag) {
				StudentUI.init_13(select_student);
			} else
				JOptionPane.showMessageDialog(null, "未查询到该学生！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
		} else if (e.getSource() == jbutton_14) {
			jtextfield.setText("");
		}
	}
}