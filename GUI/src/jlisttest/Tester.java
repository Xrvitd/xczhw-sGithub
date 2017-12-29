package jlisttest;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Tester {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(600, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(200,100));
		//以数组构造方法创建
		String[] str = {"aa","bb","cc","dd","ee","ff","gg"};
		final JList jList = new JList(str);
		
		scrollPane.setViewportView(jList);
		panel.add(scrollPane);
		f.getContentPane().add(panel);
		f.setVisible(true);
	}
}