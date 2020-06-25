package internetweather.jv;

public class InternetWeather {
    public static void main(String[] args) {
        CurrentConditions mCurrentConditions;
        ForecastConditions mForecastConditions;
        WeatherData mWeatherData;

        mCurrentConditions = new CurrentConditions();
        mForecastConditions = new ForecastConditions();
        mWeatherData = new WeatherData();

        mWeatherData.addObserver(mCurrentConditions);
        mWeatherData.addObserver(mForecastConditions);
        mWeatherData.setData(30, 150, 40);

        mWeatherData.deleteObserver(mCurrentConditions);
        mWeatherData.setData(35, 150, 60);

    }
}
