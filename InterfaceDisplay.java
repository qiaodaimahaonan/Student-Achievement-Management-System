public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (jtextfield.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "请输入地址", "提示", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		String str = new String(jtextfield.getText());
		//System.out.print(str);
}
