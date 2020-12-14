package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter;
    TextView txtCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 0;
        txtCounter = findViewById(R.id.txtCount);
    }

    public void incrementCounter(View v) {
        counter++;
        txtCounter.setText(String.valueOf(counter));
    }

}