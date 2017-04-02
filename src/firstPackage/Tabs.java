package firstPackage;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

public class Tabs {
	JDialog jd;
	Tabs()
	{
		jd=new JDialog();
		jd.setTitle("Tabbed Panes");
		JTabbedPane jtp= new JTabbedPane();
		Car c=new Car();
		ButtonEx b=new ButtonEx();
		jtp.addTab("Car",c);
		jtp.addTab("Button",b);
		jd.add(jtp);
		jd.setModal(true);
		jd.setSize(400,300);
	jd.setVisible(true);
	}

}
