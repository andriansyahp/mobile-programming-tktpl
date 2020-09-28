package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button convert_btn;
    RadioButton celsius, fahrenheit, reamur;
    TextView celcius_conv_val, fahrenheit_conv_val, reamur_conv_val;
    EditText temperature;
    String temp_val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convert_btn = findViewById(R.id.convert_btn);
        celsius = findViewById(R.id.celcius);
        fahrenheit = findViewById(R.id.fahrenheit);
        reamur = findViewById(R.id.reamur);
        celcius_conv_val = findViewById(R.id.celcius_conv_val);
        fahrenheit_conv_val = findViewById(R.id.fahrenheit_conv_val);
        reamur_conv_val = findViewById(R.id.reamur_conv_val);
        temperature = findViewById(R.id.temperature);
        convert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_val = temperature.getText().toString();
                if (temp_val.equals("")) {
                    String noValue = "No Value";
                    celcius_conv_val.setText(noValue);
                    fahrenheit_conv_val.setText(noValue);
                    reamur_conv_val.setText(noValue);
                } else {
                    if (celsius.isChecked()) {
                        celcius_conv_val.setText(String.valueOf(temp_val));
                        fahrenheit_conv_val.setText(ConverterUtils.convertCelsiusToFahrenheit(Double.parseDouble(temp_val)));
                        reamur_conv_val.setText(ConverterUtils.convertCelsiusToReamur(Double.parseDouble(temp_val)));
                    } else if (fahrenheit.isChecked()) {
                        celcius_conv_val.setText(ConverterUtils.convertFahrenheitToCelsius(Double.parseDouble(temp_val)));
                        fahrenheit_conv_val.setText(String.valueOf(temp_val));
                        reamur_conv_val.setText(ConverterUtils.convertFahrenheitToReamur(Double.parseDouble(temp_val)));
                    } else if (reamur.isChecked()) {
                        celcius_conv_val.setText(ConverterUtils.convertReamurToCelcius(Double.parseDouble(temp_val)));
                        fahrenheit_conv_val.setText(ConverterUtils.convertReamurToFahrenheit(Double.parseDouble(temp_val)));
                        reamur_conv_val.setText(String.valueOf(temp_val));
                    }
                }
            }
        });
    }
}