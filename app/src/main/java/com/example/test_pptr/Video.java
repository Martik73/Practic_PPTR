package com.example.test_pptr;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Video extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.videoView);


        // Video desde la carpeta raw (res/raw/video.mp4)
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hola);

        // O desde una URL
        //Uri uri = Uri.parse("https://www.youtube.com/watch?v=5711SvFWjCQ");


        videoView.setVideoURI(uri);
        videoView.start();
    }
}
