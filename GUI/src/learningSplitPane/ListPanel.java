package learningSplitPane;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListPanel extends JPanel {
	private JLabel label;
	private JList list;

	public ListPanel(JLabel imageLabel) {
		label = imageLabel;

		String[] fileNames = { "/Users/xczhw/FileTester/11198905335901E0F4BC9C5C3513357B9CED7CEA63.jpg",
				"/Users/xczhw/FileTester/1508562770053.png" };

		list = new JList(fileNames);
		list.addListSelectionListener(new ListListener());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		add(list);
		setBackground(Color.white);
	}

	private class ListListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event) {
			if (list.isSelectionEmpty())
				label.setIcon(null);
			else {
				String fileName = (String) list.getSelectedValue();
				ImageIcon image = new ImageIcon(fileName);
				label.setIcon(image);
			}
		}
	}
}
