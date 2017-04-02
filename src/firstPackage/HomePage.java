package firstPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class HomePage implements ActionListener {
	JFrame frame;
	private JMenuItem New;
	private JMenuItem pclose;
	//private JMenuItem mntmExampleB;
	private JMenuItem jexample1;
	private JMenuItem delete, all, id;
	private JMenuItem update,add,jexample2;
	
	void openFile()
	{
		JFileChooser jfc=new JFileChooser("E:/");
		int ch=jfc.showOpenDialog(null);
		switch(ch)
		{
		case JFileChooser.APPROVE_OPTION:
			String st=jfc.getSelectedFile().toString();
			JOptionPane.showMessageDialog(null,"file chosen"+st);
			break;
			
		case JFileChooser.CANCEL_OPTION:
			System.out.println("cancelled");
			break;
			
		}
	}
	
	public HomePage() {
		frame=new JFrame();
		frame.getContentPane().setBackground(new Color(204, 102, 255));
		frame.setTitle("HomePage");
		frame.setSize(frame.getMaximumSize());
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnEmployee = new JMenu("Employee");
		menuBar.add(mnEmployee);
		
		New = new JMenuItem("New");
		mnEmployee.add(New);
		
		update= new JMenuItem("Update");
		mnEmployee.add(update);
		
		delete = new JMenuItem("Delete");
		mnEmployee.add(delete);
		mnEmployee.addSeparator();
		
		JMenu mnView = new JMenu("View");
		mnEmployee.add(mnView);
		
		id = new JMenuItem("By Id");
		mnView.add(id);
		
		all = new JMenuItem("All");
		mnView.add(all);
		
		JMenu mnSubmenu = new JMenu("Submenu");
		menuBar.add(mnSubmenu);
		
		JMenu mnMenuItems = new JMenu("Menu Items");
		mnSubmenu.add(mnMenuItems);
		
		jexample1 = new JMenuItem("Example a");
		mnMenuItems.add(jexample1);
		
		jexample2 = new JMenuItem("Example b");
		mnMenuItems.add(jexample2);
		
		JMenu mnCheckboxes = new JMenu("Checkboxes");
		mnSubmenu.add(mnCheckboxes);
		
		JCheckBoxMenuItem chckbxmntmCheck = new JCheckBoxMenuItem("check1");
		mnCheckboxes.add(chckbxmntmCheck);
		
		JCheckBoxMenuItem chckbxmntmCheck_1 = new JCheckBoxMenuItem("check2");
		mnCheckboxes.add(chckbxmntmCheck_1);
		
		JCheckBoxMenuItem chckbxmntmCheck_2 = new JCheckBoxMenuItem("check3");
		mnCheckboxes.add(chckbxmntmCheck_2);
		
		JMenu mnRadioButtons = new JMenu("Radio buttons");
		mnSubmenu.add(mnRadioButtons);
		
		JRadioButtonMenuItem rdbtnmntmRadio = new JRadioButtonMenuItem("radio1");
		mnRadioButtons.add(rdbtnmntmRadio);
		
		JRadioButtonMenuItem rdbtnmntmRadio_1 = new JRadioButtonMenuItem("radio2");
		mnRadioButtons.add(rdbtnmntmRadio_1);
		
		JMenu mnExit = new JMenu("Exit");
		menuBar.add(mnExit);
		
		pclose = new JMenuItem("close program");
		mnExit.add(pclose);
		
		New.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		jexample1.addActionListener(this);
		jexample2.addActionListener(this);
		pclose.addActionListener(this);
		id.addActionListener(this);
		all.addActionListener(this);
		
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		
new HomePage();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object t=e.getSource();
		if(t==pclose)
		{
			int yn=JOptionPane.showConfirmDialog(null,"sure to exit","Swings",JOptionPane.YES_NO_OPTION);
			
		
		if(yn==0)
		{
			System.exit(0);
			
		}
		
		}
	else if(t==New)
	{
		new EmployeeName();
	}
	else if(t==update)
	{
		String st=JOptionPane.showInputDialog(null, "Enter Id","swings",1);
		int i=Integer.parseInt(st);
		new EmployeeUpdate(i);
				
	}
	else if(t==delete)
	{
		
	}
	else if(t==jexample1)
	{
		
	}
	else if(t==id)
	{
		String s=JOptionPane.showInputDialog(null,"Enter Id");
		int n;	
		n=Integer.parseInt(s);
		new ViewId(n);
	
	}
	else if(t==all)
	{
	new ShowAll();
	}
	else if(t==jexample2)
	{
//		new Tabs();
		openFile();
}
	}
}
