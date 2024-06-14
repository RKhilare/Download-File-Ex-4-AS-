package com.downloadapplicationex_11;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button;
    String url="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBJ2iSgvhZtCqMWXIsAH_HnQn2jC7S-V1GdUA-jbpCdrK3tDWBuqXZHAyRTZjkqrXvNag&usqp=CAU";
    String fileName="Mountain image .jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.downloadbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download(url,fileName);
            }
        });

    }

    public  void download(String url,String name){

        DownloadManager.Request request=new DownloadManager.Request(Uri.parse(url));
        request.setTitle(name);
        request.setDescription("Downloading "+ name);
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(100);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,name);
        request.setVisibleInDownloadsUi(true);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        DownloadManager manager= (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);

    }
}
