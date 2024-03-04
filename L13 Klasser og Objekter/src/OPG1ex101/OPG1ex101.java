package OPG1ex101;

public class OPG1ex101 {
    public static void main(String[] args) {
        WeatherStation weatherStation1 = new WeatherStation();
        WeatherStation weatherStation2 = new WeatherStation(35, 0.5);
        WeatherStation ws = WeatherStation.weatherStationFromImperial(68, 21);

        System.out.println(ws.getPressure());

    }
}
