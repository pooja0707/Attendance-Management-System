package firstPackage;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Car extends JPanel {
	JComboBox car;
	Car()
	{
		car=new JComboBox();
		car.addItem("Alto");
		car.addItem("Nano");
		car.addItem("Swift");
		car.addItem("Audi");
		car.addItem("Suzuki");
		setLayout(null);
		car.setBounds(10,20,80,30);
		add(car);
	}

}
