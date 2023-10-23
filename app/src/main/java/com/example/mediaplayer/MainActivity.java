package com.example.mediaplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    Button button;
    SurfaceView sruView;
    SeekBar seekbar;
    MediaPlayer mediaplayer;
    SurfaceHolder surfHold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        button=findViewById(R.id.button);
        sruView=findViewById(R.id.surfaceView);
        seekbar=findViewById(R.id.seekBar);
        //
        mediaplayer=MediaPlayer.create(this,R.raw.vid);
        //
        sruView.setKeepScreenOn(true);
        surfHold=sruView.getHolder();

        surfHold.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                mediaplayer.setDisplay(surfHold);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });
        seekbar.setMax(mediaplayer.getDuration());
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaplayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaplayer.isPlaying()){
                    mediaplayer.pause();
                    button.setText("PLAY");
                }
                else{
                    mediaplayer.start();
                    button.setText("PAUSE");

                }
            }
        });

    }
}