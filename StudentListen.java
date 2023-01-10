package myproject;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

	// ����� ���ѧ�����ύ ��ť
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		������ύ��ť
		if (e.getSource() == jbutton_1) {

			// �ж�ѧ�������Ƿ�Ϊ��
			if (jtextfield[1].getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "������ѧ������", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				return;
			} else if (jtextfield[1].getText().matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "��������ȷ��ѧ������", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				return;
			}

			// �ж��Ƿ�������Ա�ѡ�񲢶�ȡѡ��
			String str = "";
			Component[] jcbs = jp1.getComponents();// ����ѡ�����ݴ�������
			for (Component component : jcbs) {
				JRadioButton jcb = (JRadioButton) component;
				if (jcb.isSelected()) {
					str += jcb.getText() + "";
				}
			}
			if (str.equals("")) {
				JOptionPane.showMessageDialog(null, "��ѡ��ѧ���Ա�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				return;
			}

			// �Գ������ڽ��������ʽ���Ƿ���ڽ������ڣ��Ƿ�Ϸ������ж�
			Date dateofbirth = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			try {
				dateFormat.setLenient(false);
				dateofbirth = dateFormat.parse(jtextfield[3].getText());
				Date today = new Date();
				if (dateofbirth.after(today)) {
					JOptionPane.showMessageDialog(null, "�������ڲ����ڽ���֮����������ȷ�����ڸ�ʽ��yyyy/mm/dd��", "��ʾ",
							JOptionPane.PLAIN_MESSAGE);
					return;
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "��������ȷ�����ڸ�ʽ��yyyy/mm/dd��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				e1.printStackTrace();
				return;
			}

			StudentInformation student = new StudentInformation(Integer.parseInt(jtextfield[0].getText()),
					jtextfield[1].getText(), str, jtextfield[3].getText(), -1, -1, -1, -1, -1);
//				��ѧ����������ܶ�����
			StudentInformation.all_student.add(student);
			JOptionPane.showMessageDialog(null, "���ѧ���ɹ�������", "��ʾ", JOptionPane.PLAIN_MESSAGE);
			StudentUI.init_10();
			StudentInformation.ID++;
		}
		StudentUI.init_2();

	}
}

//����˵���ɼ����ύ��ť
class StudentListen_2 implements ActionListener {

	JButton jbutton_11;
	JButton jbutton_12;
	JTextField jtextfield[];
	int i;// ��ʾѧ��

	public StudentListen_2(JButton jbutton_11, JButton jbutton_12, JTextField jtextfield[], int i) {
		this.jbutton_11 = jbutton_11;
		this.jbutton_12 = jbutton_12;
		this.jtextfield = jtextfield;
		this.i = i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		boolean flag = true;
//		����� �ύ ��ť
		if (e.getSource() == jbutton_11) {
			if (i == 4) {
				for (int j = 0; j < StudentInformation.all_student.size(); j++) {
					jtextfield[j].setText(jtextfield[j].getText().replaceAll(" ", ""));// ȥ���ɼ�������Ŀո�
					// �жϳɼ��Ƿ��ں���Χ�ڣ�0��100��
					if (Integer.parseInt(jtextfield[j].getText()) > 100
							|| Integer.parseInt(jtextfield[j].getText()) < 0) {
						flag = false;
						break;
					} else
						StudentInformation.all_student.get(j).set_java(Integer.parseInt(jtextfield[j].getText()));
					// ���ܷ�
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
				JOptionPane.showMessageDialog(null, "�ɹ���ӳɼ�������", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				StudentUI.init_10();
			} else
				JOptionPane.showMessageDialog(null, "��������ȷ��ѧ���ɼ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
		} else {
//			����� ��� ��ť
			for (int j = 0; j < StudentInformation.all_student.size(); j++) {
				jtextfield[j].setText("");
			}
		}

	}

}

// ������޸�ѧ�����޸İ�ť
class StudentListen_3 implements ActionListener {

	JButton jbutton_3;
	JButton jbutton_4;
	JTextField jtextfield[];
	JPanel jp2;

	public StudentListen_3(JPanel jp2, JButton jbutton_3, JButton jbutton_4, JTextField jtextfield[]) {
		this.jp2 = jp2;
		this.jbutton_3 = jbutton_3;
		this.jbutton_4 = jbutton_4;
		this.jtextfield = jtextfield;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		����� �޸� ��ť
		if (e.getSource() == jbutton_3) {
			for (int i = 0; i < StudentInformation.all_student.size(); i++) {
//				ѧ����ͬ���޸�ѧ����Ϣ
				if (jtextfield[0].getText().equals("" + StudentInformation.all_student.get(i).get_Id())) {
//					�޸���Ϣ(ѧ�Ų����޸�,�ܷ����¼���)

					// �ж�ѧ�������Ƿ�Ϊ��
					if (jtextfield[1].getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "������ѧ������", "��ʾ", JOptionPane.PLAIN_MESSAGE);
						return;
					} else if (jtextfield[1].getText().matches("\\d+")) {
						JOptionPane.showMessageDialog(null, "��������ȷ��ѧ������", "��ʾ", JOptionPane.PLAIN_MESSAGE);
						return;
					}

					// �ж��Ƿ�������Ա�ѡ�񲢶�ȡѡ��
					String str = "";
					Component[] jcbs = jp2.getComponents();// ����ѡ�����ݴ�������
					for (Component component : jcbs) {
						JRadioButton jcb = (JRadioButton) component;
						if (jcb.isSelected()) {
							str += jcb.getText() + "";
						}
					}
					if (str.equals("")) {
						JOptionPane.showMessageDialog(null, "��ѡ��ѧ���Ա�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
						return;
					}

					// �Գ������ڽ��������ʽ���Ƿ���ڽ������ڣ��Ƿ�Ϸ������ж�
					Date dateofbirth = null;
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					try {
						dateFormat.setLenient(false);
						dateofbirth = dateFormat.parse(jtextfield[3].getText());
						Date today = new Date();
						if (dateofbirth.after(today)) {
							JOptionPane.showMessageDialog(null, "�������ڲ����ڽ���֮����������ȷ�����ڸ�ʽ��yyyy/mm/dd��", "��ʾ",
									JOptionPane.PLAIN_MESSAGE);
							return;
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "��������ȷ�����ڸ�ʽ��yyyy/mm/dd��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
						e1.printStackTrace();
						return;
					}

					if (jtextfield[4].getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "������java�ɼ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					if (jtextfield[5].getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "�����������ɼ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					if (jtextfield[6].getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "��������ɢ��ѧ�ɼ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					if (jtextfield[7].getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "������Ӣ��ɼ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
						return;
					}

					// ȥ������ɼ�ʱ������Ŀո�
					jtextfield[4].setText(jtextfield[4].getText().replaceAll(" ", ""));
					jtextfield[5].setText(jtextfield[5].getText().replaceAll(" ", ""));
					jtextfield[6].setText(jtextfield[6].getText().replaceAll(" ", ""));
					jtextfield[7].setText(jtextfield[7].getText().replaceAll(" ", ""));

					StudentInformation.all_student.get(i).set_Name(jtextfield[1].getText());
					StudentInformation.all_student.get(i).setGender(str);
					StudentInformation.all_student.get(i).setDate(jtextfield[3].getText());
					StudentInformation.all_student.get(i).set_java(Integer.parseInt(jtextfield[4].getText()));
					StudentInformation.all_student.get(i).set_physical(Integer.parseInt(jtextfield[5].getText()));
					StudentInformation.all_student.get(i)
							.set_Discrete_Mathematics(Integer.parseInt(jtextfield[6].getText()));
					StudentInformation.all_student.get(i).set_English(Integer.parseInt(jtextfield[7].getText()));

//						���¼����ܷ�
					int sum = 0;
					for (int j = 4; j < StudentInformation.number - 1; j++) {
						sum += Integer.parseInt(jtextfield[j].getText());
					}
//						����ܷ���Ϣ
					StudentInformation.all_student.get(i).set_Total(sum);
//						��ʾ
					JOptionPane.showMessageDialog(null, "�޸�ѧ����Ϣ�ɹ�������", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					StudentUI.init_10();
					StudentUI.init_4();
					return;
				}
			}
//			δ��ѯ��ѧ������ʾ
			JOptionPane.showMessageDialog(null, "δ��ѯ����ǰѧ��������\n�޸�ʧ�ܣ�����", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
		} else {
			jtextfield[0].setText("");
		}
	}

}

//�����ɾ��ѧ����ɾ����ť
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
//		����� ɾ�� ��ť
		if (e.getSource() == jbutton_5) {
			for (int i = 0; i < StudentInformation.all_student.size(); i++) {
//				ѧ����ͬ��ɾ��ѧ����Ϣ
				if (jtextfield_1.getText().equals("" + StudentInformation.all_student.get(i).get_Id())) {
//					ɾ����Ϣ
					StudentInformation.all_student.remove(i);
					JOptionPane.showMessageDialog(null, "ɾ��ѧ����Ϣ�ɹ�������", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					StudentUI.init_10();
					return;// ����
				}
			}
//			δ��ѯ��ѧ������ʾ
			JOptionPane.showMessageDialog(null, "δ��ѯ����ǰѧ��������\nɾ��ʧ�ܣ�����", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
		} else {
			jtextfield_1.setText("");
		}
	}

}

// ��ѯѧ���� ��ѯ��ť �ļ���
class StudentListen_5 implements ActionListener {

	JButton jbutton_8;
	JButton jbutton_9;
	JTextField jtextfield[];

	public StudentListen_5(JButton jbutton_8, JButton jbutton_9, JTextField jtextfield[]) {
		this.jbutton_8 = jbutton_8;
		this.jbutton_9 = jbutton_9;
		this.jtextfield = jtextfield;
	}

//	����� ��ѯѧ���Ĳ�ѯ ��ť
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		����� ��ѯ ��ť
		if (e.getSource() == jbutton_8) {
			for (int i = 0; i < StudentInformation.all_student.size(); i++) {
//				ѧ����ͬ�����ѧ����Ϣ
				if (jtextfield[0].getText().equals("" + StudentInformation.all_student.get(i).get_Id())) {
//					�����Ϣ���ı���
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
					return;// ����
				}
			}
//			δ��ѯ��ѧ������ʾ
			JOptionPane.showMessageDialog(null, "δ��ѯ����ѧ��������", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
		} else if (e.getSource() == jbutton_9) {
			jtextfield[0].setText("");
		}
	}

}

//����˰����ֲ�ѯ�Ĳ�ѯ��ť
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
		// TODO �Զ����ɵķ������
		if (e.getSource() == jbutton_13) {
			boolean flag = false;
			ArrayList<StudentInformation> select_student = new ArrayList<StudentInformation>();
			for (int i = 0; i < StudentInformation.all_student.size(); i++) {
//				�������ѧ������
				if (StudentInformation.all_student.get(i).get_Name().contains(jtextfield.getText())) {
//					�����Ϣ���ı���
					flag = true;
					select_student.add(StudentInformation.all_student.get(i));
				}
			}
			if (flag) {
				StudentUI.init_13(select_student);
			} else
				JOptionPane.showMessageDialog(null, "δ��ѯ����ѧ��������", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
		} else if (e.getSource() == jbutton_14) {
			jtextfield.setText("");
		}
	}

}

class StudentListen_7 implements ActionListener {
	JButton jbutton_1;
	JTextField jtextfield;

	public StudentListen_7(JButton jbutton_1, JTextField jtextfield) {
		this.jbutton_1 = jbutton_1;
		this.jtextfield = jtextfield;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (jtextfield.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "�������ַ", "��ʾ", JOptionPane.PLAIN_MESSAGE);
			return;
		}

		String str = new String(jtextfield.getText());
		try {
			FileInputStream in = new FileInputStream(str);
			InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
			BufferedReader bufReader = new BufferedReader(inReader);
			String line = null;
			while ((line = bufReader.readLine()) != null) {
				StudentInformation student = new StudentInformation();
				student.set_Id(StudentInformation.ID++);// ѧ��˳�ӣ����ظ�
				String[] str1 = line.split("\\s+");
				for (int j = 0; j < str1.length; j++) {
					student.set_Name(str1[0]);
					student.setDate(str1[1]);
					student.setGender(str1[2]);
					student.set_java(Integer.parseInt(str1[3]));
					student.set_English(Integer.parseInt(str1[4]));
					student.set_physical(Integer.parseInt(str1[5]));
					student.set_Discrete_Mathematics(Integer.parseInt(str1[6]));
					student.set_Total(Integer.parseInt(str1[7]));

				}
				StudentInformation.all_student.add(student);
			}
			JOptionPane.showMessageDialog(null, "����ɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
			StudentUI.init_10();// �ұ���ʾѧ����Ϣ
			bufReader.close();
			inReader.close();
			in.close();
		} catch (Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "��ȡ������������ȷ���ļ���ַ", "��ʾ", JOptionPane.PLAIN_MESSAGE);
		}
	}

	// D:\text.txt

}
