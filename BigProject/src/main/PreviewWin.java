package main;

import java.awt.*;
import javax.swing.*;

public class PreviewWin extends JPanel
{
	public void paintComponent(Graphics page)
	{
		JSplitPane jsp = MyList.getViewPane();
		while(jsp.getRightComponent() instanceof JSplitPane)
			jsp = (JSplitPane)jsp.getRightComponent();
		JScrollPane jscop = (JScrollPane) jsp.getRightComponent();
		
	}
}
