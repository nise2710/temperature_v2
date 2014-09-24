package temperature.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import temperature.model.TemperatureModel;
import temperature.view.TemperatureView;

public class TemperatureController implements ActionListener {
	TemperatureModel model;
	TemperatureView view;
	
	public TemperatureController(TemperatureModel model, TemperatureView view) {
		this.model = model;
		this.view = view;
		
		model.setDefault(0.0, 0.0, 0.0);
		view.setActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.convertButton) {
			model.setCurrentUnit(view.getUnitTemperature());
			model.convertTemperature(view.getValueTextField());
			view.setResultLabel(model.getResult());
		} else if(e.getSource() == view.resetButton) {
			view.reset();
		} else if(e.getSource() == view.infoButton) {
			view.getInfo();
		}
	}
}
