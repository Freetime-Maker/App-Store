package com.freetime.appstore;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.app.Activity;

public class MainActivity extends Activity {
    String[] appNames = {"GeoWeather", "Donation"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, appNames);
        listView.setAdapter(adapter);

        Button installBtn = findViewById(R.id.installBtn);
        installBtn.setOnClickListener(v -> {
            // Example APK url; replace with dynamic url or file
            Uri apkUri = Uri.parse("https://freetimemaker.github.io/");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
    }
}