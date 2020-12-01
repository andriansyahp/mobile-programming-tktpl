package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.provider.Settings;
import android.view.View;

import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private WifiManager wifiManager;
    private ListView listViewWifi;
    private final int PERMISSIONS_ACCESS_FINE_LOCATION = 0;
    BroadcastReceiver wifiReceiver;
    List<ScanResult> wifiResults;
    ArrayList<String> listWifiItems = new ArrayList<>();
    ArrayAdapter<String> adapter;
    RequestQueue requestQueue;
    private static final String TAG = MainActivity.class.getSimpleName();
    private final String REQUESTBIN_URL = "https://c18c476697359795956030202ee59636.m.pipedream.net";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewWifi = findViewById(R.id.listWifi);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listWifiItems){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.WHITE);
                return view;
            }
        };
        listViewWifi.setAdapter(adapter);

        Context context = getApplicationContext();
        wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

        wifiReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                System.out.println("wifiReceiver onReceive");
                wifiResults = wifiManager.getScanResults();
                for (ScanResult scanResult : wifiResults) {
                    listWifiItems.add(scanResult.SSID);
                    adapter.notifyDataSetChanged();
                }
            }
        };
        context.registerReceiver(wifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_ACCESS_FINE_LOCATION);
        }

        if (!wifiManager.isWifiEnabled()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Toast.makeText(this, "Turn on your WiFi!", Toast.LENGTH_LONG).show();
                Intent panelIntent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);
                startActivityForResult(panelIntent, 0);
            } else {
                Toast.makeText(this, "Turning on WiFi...", Toast.LENGTH_LONG).show();
                wifiManager.setWifiEnabled(true);
            }
        }

        Button buttonScan = findViewById(R.id.btnScan);
        buttonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanWifi();
            }
        });

        Button buttonPost = findViewById(R.id.btnPost);
        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postData();
            }
        });
    }

    private void scanWifi() {
        listWifiItems.clear();
        wifiManager.startScan();
        System.out.println(wifiManager.startScan());
        Toast.makeText(this, "Scanning...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSIONS_ACCESS_FINE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this, "Permission granted", Toast.LENGTH_SHORT).show();
                wifiManager.startScan();
            } else {
                Toast.makeText(MainActivity.this, "Permission not granted", Toast.LENGTH_SHORT).show();
                return;
            }
            break;
        }
    }

    public void postData() {
        if (listWifiItems != null && listWifiItems.size() > 0) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
            JSONObject object = new JSONObject();
            try {
                object.put("wifiResult", listWifiItems);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, REQUESTBIN_URL, object,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Toast.makeText(MainActivity.this, "WiFi data posted successfully", Toast.LENGTH_LONG).show();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, "Failed to post data", Toast.LENGTH_LONG).show();
                }
            });
            jsonObjectRequest.setTag(TAG);
            requestQueue.add(jsonObjectRequest);
        } else {
            Toast.makeText(MainActivity.this, "No data to be posted", Toast.LENGTH_LONG).show();
        }
    }
}