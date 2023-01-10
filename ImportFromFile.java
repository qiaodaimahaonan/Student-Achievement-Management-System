public static void init_14() {

//		清空组件
		StudentUI.jpanel_1.removeAll();
//		刷新面板
		StudentUI.jpanel_1.updateUI();

//		提示
		String s = "请输入您需要导入的文件地址：";
		
//		标签
		JLabel jlabel = new JLabel();
//		文本框
		
		JTextField jtextfield= new JTextField(12);
		JPanel jp1 = new JPanel();

		JLabel jlabel1= new JLabel("文件地址                                        ");
		StudentUI.jpanel_1.add(jlabel1);

//		实例化
	
			
				jlabel= new JLabel(s);
				StudentUI.jpanel_1.add(jlabel);
			
				jtextfield = new JTextField(12);
				StudentUI.jpanel_1.add(jtextfield);
					
				//按钮
				JButton jbutton_1 = new JButton("提交");
				
//				加入按钮
				StudentUI.jpanel_1.add(jbutton_1);
			
//				注册监听
				StudentListen_7 e_1 = new StudentListen_7(jp1, jbutton_1,jtextfield);
				jbutton_1.addActionListener(e_1);
		
				
	}
}
