package OPG1ex101;

public class WeatherStation {
    private double temperature = 0;
    private double pressure = 1;

    public WeatherStation() {
    }

    public WeatherStation(double temperature, double pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
    }

    public static WeatherStation weatherStationFromImperial(double temperature, double pressure) {
        WeatherStation weatherStation3 = new WeatherStation(
                (temperature - 32) / 1.8,
                pressure / 14.503773773);
        return weatherStation3;
    }
    
    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public double getTemperatureF() {
        return (temperature * 1.8) + 32;
    }

    public double getPressurePSI() {
        return pressure * 14.503773773;
    }
}


