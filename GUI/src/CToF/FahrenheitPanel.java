package CToF;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FahrenheitPanel extends JPanel
{
	private JLabel inputLabel, outputLabel, resultLabel;
	private JTextField fahrenheit;
	
	public FahrenheitPanel()
	{
		inputLabel = new JLabel("Enter ...");
		outputLabel = new JLabel("Temper ...");
		resultLabel = new JLabel("---");
		
		fahrenheit = new JTextField(5);
		fahrenheit.addActionListener(new TempListener());
		
		add(inputLabel);
		add(fahrenheit);
		add(outputLabel);
		add(resultLabel);
		
		setPreferredSize(new Dimension(300,75));
		setBackground(Color.YELLOW);
	}
	
	private class TempListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Integer fTemp, cTemp;
			String text;
			try
			{
				text = fahrenheit.getText();
				
				fTemp = Integer.parseInt(text);
				cTemp = (fTemp - 32) * 5/9;
				
				resultLabel.setText(cTemp.toString());
			}catch (NumberFormatException e)
			{
				resultLabel.setText("还没有输入");
			}
		}
	}
}
