package internetweather.jv;

import java.util.Observable;
import java.util.Observer;

public class ForecastConditions implements Observer {

    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    @Override
    public void update(Observable arg0, Object arg1) {
        // TODO Auto-generated method stub
//        this.mTemperature = ((Data) (arg1)).mTemperature;
//        this.mPressure = ((Data) (arg1)).mPressure;
//        this.mHumidity = ((Data) (arg1)).mHumidity;
        //拉模式
        this.mTemperature = ((WeatherData) arg0).getTemperature();
        this.mHumidity = ((WeatherData) arg0).getHumidity();
        this.mPressure = ((WeatherData) arg0).getPressure();
        display();
    }

    public void display() {
        System.out.println("***Tomorrow mTemperature:" + (mTemperature + 1) + "***");
        System.out.println("***Tomorrow mPressure:" + (mPressure + 1) + "***");
        System.out.println("***Tomorrow mHumidity:" + (mHumidity + 1) + "***");
    }

}
