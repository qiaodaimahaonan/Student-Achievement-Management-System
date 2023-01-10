public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (jtextfield.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "请输入地址", "提示", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		String str = new String(jtextfield.getText());
		//System.out.print(str);
	
		
		try {
			FileInputStream in = new FileInputStream(str);
			InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
			BufferedReader bufReader = new BufferedReader(inReader);
			String line = null;
			int i = 0;
			while((line = bufReader.readLine()) != null){
		
				i++;
				StudentInformation student = new StudentInformation();
				student.set_Id(i);
				///student.set_Name(line);
				String[] str1=line.split("\\s+");
				for(int j=0;j<str1.length;j++) {
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
			bufReader.close();
			inReader.close();
			in.close();
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("读取" + str + "出错！");
		}
		}

	     //D:\text.txt

		
		}
