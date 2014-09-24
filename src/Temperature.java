import javax.swing.SwingUtilities;

import temperature.controller.TemperatureController;
import temperature.model.TemperatureModel;
import temperature.view.TemperatureView;

public class Temperature {
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TemperatureModel model = new TemperatureModel();
				TemperatureView view = new TemperatureView();
				TemperatureController control = new TemperatureController(model, view);
			}
		});
	}
}
