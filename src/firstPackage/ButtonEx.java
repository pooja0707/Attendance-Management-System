package firstPackage;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonEx extends JPanel {
	JButton b;
	ButtonEx()
	{
		b=new  JButton("Click");
		setLayout(null);
		b.setBounds(10, 20, 80, 30);
		add(b);
	}

}
