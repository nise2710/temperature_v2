package temperature.model;

import java.text.DecimalFormat;

public class TemperatureModel {
	private double celsius, fahrenheit, kelvin;
	private int currentUnit;
	private String result;
	
	public void setDefault(double c, double f, double k) {
		this.celsius = c;
		this.fahrenheit = f;
		this.kelvin = k;
	}
	
	public void setCurrentUnit(int currentUnit) {
		this.currentUnit = currentUnit;
	}
	
	public void convertTemperature(double input) {
		switch(currentUnit) {
			case 0:
				setCelsius(input);
				celsiusToFahrenheit();
				celsiusToKelvin();
				break;
			case 1:
				setFahrenheit(input);
				fahrenheitToCelsius();
				fahrenheitToKelvin();
				break;
			case 2:
				setKelvin(input);
				kelvinToCelsius();
				kelvinToFahrenheit();
				break;
		}
	}
	
	// fix this - bug with kelvin
	public String getResult() {
		DecimalFormat df = new DecimalFormat("##.00");
		switch(currentUnit) {
			case 0:
				result = "<html>"+df.format(celsius)+"\u00B0C = "+df.format(fahrenheit)+"\u00B0F<br />"
					+df.format(celsius)+"\u00B0C = "+df.format(kelvin)+"\u00B0K</html";
				break;
			case 1:
				result = "<html>"+df.format(fahrenheit)+"\u00B0F = "+df.format(celsius)+"\u00B0C<br />"
						+df.format(fahrenheit)+"\u00B0F = "+df.format(kelvin)+"\u00B0K</html";
					break;
			case 2:
				result = "<html>"+df.format(kelvin)+"\u00B0K = "+df.format(celsius)+"\u00B0C<br />"
						+df.format(kelvin)+"\u00B0K = "+df.format(fahrenheit)+"\u00B0F</html";
					break;	
		}
		return result;
	}
		
	private void setCelsius(double celsius) {
		this.celsius = celsius;
	}
	
	private void setFahrenheit(double fahrenheit) {
		this.fahrenheit = fahrenheit;
	}

	private void setKelvin(double kelvin) {
		this.kelvin = kelvin;
	}

	private void celsiusToFahrenheit() {
		fahrenheit = ((celsius*9)/5)+32;
	}
	
	private void celsiusToKelvin() {
		kelvin = celsius+273.15;
	}
	
	private void fahrenheitToCelsius() {
		celsius = ((fahrenheit-32)*5)/9;
	}
	
	private void fahrenheitToKelvin() {
		kelvin = ((fahrenheit+459.67)*5)/9;
	}
	
	private void kelvinToCelsius() {
		celsius = kelvin-273.15;
	}
	
	private void kelvinToFahrenheit() {
		fahrenheit = ((kelvin*9)/5)-459.67;
	}
}