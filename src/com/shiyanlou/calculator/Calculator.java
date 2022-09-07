package com.shiyanlou.calculator;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Calculator {
	String str1 = "0";
	String str2 = "0";
	String signal = "+";
	String result = "0";
	int k1 = 1;int k2 = 1;int k3 = 1;int k4 = 1;
	int k5 = 1;
	JButton store;
	Vector vt = new Vector(20, 10);
	JTextField result_TextField = new JTextField(result, 20);	
class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String ss = ((JButton) e.getSource()).getText();
			store = (JButton) e.getSource();
			vt.add(store);
			if (k1 == 1) {
				if (k3 == 1) {
					str1 = "";
					k5 = 1;
				}
				str1 = str1 + ss;
				k3 = k3 + 1;
				result_TextField.setText(str1);
			} else if (k1 == 2) {
				if (k4 == 1) {
					str2 = "";
					k5 = 1;
				}
				str2 = str2 + ss;
				k4 = k4 + 1;
				result_TextField.setText(str2);
			}

		}
	}
class Listener_xiaos implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			store = (JButton) e.getSource();
			vt.add(store);

			if (k5 == 1) {
				String ss2 = ((JButton) e.getSource()).getText();
				if (k1 == 1) {
					if (k3 == 1) {
						str1 = "";
						k5 = 1;
					}
					str1 = str1 + ss2;
					k3 = k3 + 1;
					result_TextField.setText(str1);
				} else if (k1 == 2) {
					if (k4 == 1) {
						str2 = "";
						k5 = 1;
					}
					str2 = str2 + ss2;
					k4 = k4 + 1;
					result_TextField.setText(str2);
				}
			}
			k5 = k5 + 1;
		}
	}

class Listener_signal implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String ss2 = ((JButton) e.getSource()).getText();
				store = (JButton) e.getSource();
				vt.add(store);
				if (k2 == 1) {
					k1 = 2;
					k5 = 1;
					signal = ss2;
					k2 = k2 + 1;
				} else {
					int a = vt.size();
					JButton c = (JButton) vt.get(a - 2);
					if (!(c.getText().equals("+")) && !(c.getText().equals("-")) && !(c.getText().equals("*"))
							&& !(c.getText().equals("/"))) {
						cal();
						str1 = result;
						k1 = 2;
						k5 = 1;
						k4 = 1;
						signal = ss2;
					}
					k2 = k2 + 1;
				}

			}
}


class Listener_dy implements ActionListener {
public void actionPerformed(ActionEvent e) {
				String ss = ((JButton) e.getSource()).getText();
				store = (JButton) e.getSource();
				vt.add(store);
				cal();
				k1 = 1;
				k2 = 1;
				k3 = 1;
				k4 = 1;
				str1 = result;
			}	
		
}

class Listener_clear implements ActionListener{
public void actionPerformed(ActionEvent e) {
	store=(JButton) e.getSource();
	vt.add(store);
	k1=1;k2=1;k3=1;k4=1;k5=1;
	str1="0";
	str2="0";
	signal="+";
	result="";
	result_TextField.setText(result);
	vt.clear();
}

}
	
public void cal() {
	double q1;
	double q2;
	String c = signal;
	double result2 = 0;
	if (c.equals("")) {
		result_TextField.setText("input a number");
	} else {
		if (str1.equals(".")) {
			str1 = "0.0";
		}
		if (str2.equals(".")) {
			str2 = "0.0";
		}
		q1 = Double.valueOf(str1).doubleValue();
		q2 = Double.valueOf(str2).doubleValue();

		if (c.equals("+")) {
			result2 = q1 + q2;
		}
		if (c.equals("-")) {
			result2 = q1 - q2;
		}
		if (c.equals("*")) {
			BigDecimal m1 = new BigDecimal(Double.toString(q1));
			BigDecimal m2 = new BigDecimal(Double.toString(q2));
			result2 = m1.multiply(m2).doubleValue();
		}
		if (c.equals("/")) {
			if(q2==0) {
				result2=0;
			}else {
				result2 = q1 / q2;
			}
		}

	}
result=((new Double(result2)).toString());
result_TextField.setText(result);
}	



public static void main(String[] args) {
		JFrame frame = new JFrame("Calculator");
		frame.setLocation(300, 200);
		frame.setResizable(false);

		JButton clear_Button = new JButton("Clear");
		JButton button0 = new JButton("0");
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		JButton button_dian = new JButton(".");
		JButton button_jia = new JButton("+");
		JButton button_jian = new JButton("-");
		JButton button_cheng = new JButton("*");
		JButton button_chu = new JButton("/");
		JButton button_dy = new JButton("=");		
		JPanel pan = new JPanel();
		// 格线布局
		pan.setLayout(new GridLayout(4, 4, 5, 5));

		pan.add(button1);
		pan.add(button2);
		pan.add(button3);
		pan.add(button_jia);
		pan.add(button4);
		pan.add(button5);
		pan.add(button6);
		pan.add(button_jian);
		pan.add(button7);
		pan.add(button8);
		pan.add(button9);
		pan.add(button_cheng);
		pan.add(button0);
		pan.add(button_dian);
		pan.add(button_dy);
		pan.add(button_chu);
		pan.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		// 边界布局
		JPanel pan2 = new JPanel();
		pan2.setLayout(new BorderLayout());
		Calculator cc=new Calculator();
		pan2.add(cc.result_TextField, BorderLayout.WEST);
		pan2.add(clear_Button, BorderLayout.EAST);
		// 将大的框架实例化为Panel对象进行操作
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(pan2, BorderLayout.NORTH);
		frame.getContentPane().add(pan, BorderLayout.CENTER);
		// 布局结束
		frame.pack();
		frame.setVisible(true);		
		
		
Listener_dy jt_dy =cc.new Listener_dy();
button_dy.addActionListener(jt_dy);
Listener jt = cc.new Listener();
button0.addActionListener(jt);
button1.addActionListener(jt);
button2.addActionListener(jt);
button3.addActionListener(jt);
button4.addActionListener(jt);
button5.addActionListener(jt);
button6.addActionListener(jt);
button7.addActionListener(jt);
button8.addActionListener(jt);
button9.addActionListener(jt);
Listener_signal jt_signal=cc.new Listener_signal();
button_jia.addActionListener(jt_signal);
button_jian.addActionListener(jt_signal);
button_cheng.addActionListener(jt_signal);
button_chu.addActionListener(jt_signal);

//监听清除键
Listener_clear jt_c =cc.new Listener_clear();
clear_Button.addActionListener(jt_c);
//监听小数点键
Listener_xiaos jt_xs = cc.new Listener_xiaos();
button_dian.addActionListener(jt_xs);

//窗体关闭事件的响应程序
frame.addWindowListener(new WindowAdapter() {
 public void windowClosing(WindowEvent e) {
     System.exit(0);
 }
});



	}

}
