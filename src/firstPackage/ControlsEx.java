package firstPackage;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class ControlsEx extends JDialog implements ItemListener {
	private JTextField txtGender;
	private JTextField txtRadio;
	private JTextField txtCheck;
	private JTextField txtCombo;
	private JRadioButton m,in,gr,f,hs;
	private JComboBox city;
	private JCheckBox sl,ea,pl;
	
	
	
	public ControlsEx() {
		// TODO Auto-generated constructor stub
		getContentPane().setLayout(null);
		
		m = new JRadioButton("Male");
		
		m.setOpaque(false);
	
		
		m.setBounds(28, 43, 109, 23);
		getContentPane().add(m);
		
		f = new JRadioButton("Female");
		
		
		f.setOpaque(false);
		
		f.setBounds(28, 68, 109, 23);
		getContentPane().add(f);
		
	    hs = new JRadioButton("Secondary");
	    
	    hs.setOpaque(false);
	    
		hs.setBounds(28, 131, 109, 23);
		getContentPane().add(hs);
		
		in = new JRadioButton("Sr. Secondary");
		in.setBounds(28, 157, 109, 23);
		getContentPane().add(in);
		
		gr = new JRadioButton("Graduate");
		gr.setBounds(28, 183, 109, 23);
		getContentPane().add(gr);
		
		sl = new JCheckBox("Sleeping");
		sl.setBounds(28, 266, 97, 23);
		getContentPane().add(sl);
		
		ea = new JCheckBox("Eating");
		ea.setBounds(28, 292, 97, 23);
		getContentPane().add(ea);
		
		pl = new JCheckBox("Playing");
		pl.setBounds(28, 318, 97, 23);
		getContentPane().add(pl);
		
		city = new JComboBox();
		city.setModel(new DefaultComboBoxModel(new String[] {"lucknow", "gorakhpur", "kanpur"}));
		city.setBounds(28, 407, 76, 20);
		getContentPane().add(city);
		
		txtGender = new JTextField(20);
		txtGender.setBounds(28, 16, 86, 20);
		getContentPane().add(txtGender);
		txtGender.setColumns(10);
		
		txtRadio = new JTextField();
		txtRadio.setBounds(28, 104, 86, 20);
		getContentPane().add(txtRadio);
		txtRadio.setColumns(10);
		
		txtCheck = new JTextField();
		txtCheck.setBounds(28, 239, 86, 20);
		getContentPane().add(txtCheck);
		txtCheck.setColumns(10);
		
		txtCombo = new JTextField();
		txtCombo.setHorizontalAlignment(SwingConstants.LEFT);
		txtCombo.setBounds(28, 376, 86, 20);
		getContentPane().add(txtCombo);
		txtCombo.setColumns(10);
		setSize(600, 500);
		hs.addItemListener(this);
		in.addItemListener(this);
		gr.addItemListener(this);
		sl.addItemListener(this);
		ea.addItemListener(this);
		pl.addItemListener(this);
		city.addItemListener(this);
		
		ButtonGroup bg1=new ButtonGroup();
		ButtonGroup bg2=new ButtonGroup();
		bg1.add(m);
		bg1.add(f);
		bg2.add(hs);
		bg2.add(in);
		bg2.add(gr);
		
		
		ImageIcon ii=new ImageIcon(getClass().getResource("images/img.jpg"));
		JLabel img=new JLabel(ii);
		img.setBounds(0, 0, 600, 500);
		getContentPane().add(img);

		
		setVisible(true);
		

		
	}

	public static void main(String[] args) {
		new ControlsEx();
		

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==hs)
		{
			txtRadio.setText(hs.getText());
			
		}
		else if(ob==in)
		{
			txtRadio.setText(in.getText());
		}
		else if(ob==gr)
		{
			txtRadio.setText("Graduate");
		}
		else if(ob==city)
		{
			String c=city.getSelectedItem().toString();
			
			txtCombo.setText(c);
		}
		else if(ob==sl||ob==ea||ob==pl)
		{
			String ms="";
			if(sl.isSelected())
			{
				ms+=sl.getText();
			}
			if(ea.isSelected())
			{
				ms+="eating";
			}
			if(pl.isSelected())
			{
				ms+="playing";
			}
			txtCheck.setText(ms);
			
		}
		
	}
}

