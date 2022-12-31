package myproject;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

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

			// 判断学生姓名是否为空
			if (jtextfield[1].getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "请输入学生姓名", "提示", JOptionPane.PLAIN_MESSAGE);
				return;
			} else if (jtextfield[1].getText().matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "请输入正确的学生姓名", "提示", JOptionPane.PLAIN_MESSAGE);
				return;
			}

			// 判断是否进行了性别选择并读取选择
			String str = "";
			Component[] jcbs = jp1.getComponents();// 将勾选的内容存入数组
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

			// 对出生日期进行输入格式，是否大于今天日期，是否合法进行判断
			Date dateofbirth = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			try {
				dateFormat.setLenient(false);
				dateofbirth = dateFormat.parse(jtextfield[3].getText());
				Date today = new Date();
				if (dateofbirth.after(today)) {
					JOptionPane.showMessageDialog(null, "出生日期不能在今天之后，请输入正确的日期格式（yyyy/mm/dd）", "提示",
							JOptionPane.PLAIN_MESSAGE);
					return;
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "请输入正确的日期格式（yyyy/mm/dd）", "提示", JOptionPane.PLAIN_MESSAGE);
				e1.printStackTrace();
				return;
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
