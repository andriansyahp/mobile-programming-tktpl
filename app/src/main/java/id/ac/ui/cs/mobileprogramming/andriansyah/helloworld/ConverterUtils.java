package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld;

public class ConverterUtils {
    public static String convertCelsiusToFahrenheit(double temperature){
        return String.valueOf((temperature * 9 / 5) + 32);
    }

    public static String convertCelsiusToReamur(double temperature){
        return String.valueOf(temperature * 4 / 5);
    }

    public static String convertFahrenheitToCelsius(double temperature){
        return String.valueOf((temperature - 32) * 5 / 9);
    }

    public static String convertFahrenheitToReamur(double temperature){
        return String.valueOf((temperature - 32) * 4 / 9);
    }

    public static String convertReamurToCelcius(double temperature){
        return String.valueOf(temperature * 5 / 4);
    }

    public static String convertReamurToFahrenheit(double temperature){
        return String.valueOf((temperature * 9 / 4) + 32);
    }
}
