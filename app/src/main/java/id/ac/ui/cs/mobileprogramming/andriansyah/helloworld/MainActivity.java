package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("native-lib");
    }

    Button convert_btn;
    RadioButton celsius, fahrenheit, reamur;
    TextView celcius_conv_val, fahrenheit_conv_val, reamur_conv_val;
    EditText temperature;
    String temp_val;

    public native double JniCelciusToFahrenheit(double celcius);
    public native double JniCelciusToReamur(double celcius);
    public native double JniFahrenheitToCelcius(double fahrenheit);
    public native double JniFahrenheitToReamur(double fahrenheit);
    public native double JniReamurToCelcius(double reamur);
    public native double JniReamurToFahrenheit(double reamur);

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
                        fahrenheit_conv_val.setText(String.valueOf(JniCelciusToFahrenheit(Double.parseDouble(temp_val))));
                        reamur_conv_val.setText(String.valueOf(JniCelciusToReamur(Double.parseDouble(temp_val))));
                    } else if (fahrenheit.isChecked()) {
                        celcius_conv_val.setText(String.valueOf(JniFahrenheitToCelcius(Double.parseDouble(temp_val))));
                        fahrenheit_conv_val.setText(String.valueOf(temp_val));
                        reamur_conv_val.setText(String.valueOf(JniFahrenheitToReamur(Double.parseDouble(temp_val))));
                    } else if (reamur.isChecked()) {
                        celcius_conv_val.setText(String.valueOf(JniReamurToCelcius(Double.parseDouble(temp_val))));
                        fahrenheit_conv_val.setText(String.valueOf(JniReamurToFahrenheit(Double.parseDouble(temp_val))));
                        reamur_conv_val.setText(String.valueOf(temp_val));
                    }
                }
                temperature.onEditorAction(EditorInfo.IME_ACTION_DONE);
                Toast.makeText(getApplicationContext(), "Converted using JNI :)", Toast.LENGTH_LONG).show();
            }
        });
    }
}