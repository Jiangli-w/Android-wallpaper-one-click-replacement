package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    Button btn;
    WallpaperManager wallpaperManager;
    int mycolor = 0xff333333;

    int[] wallpapers = new int[]{
            R.drawable.bg1, R.drawable.bg2
    };
    static int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCtrl();

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                BitmapDrawable bitmap = null;
                i++;
                if (i % 2 == 0) {
                    i = 0;
                    bitmap = (BitmapDrawable) getResources().getDrawable(wallpapers[i]);
                    Toast toast = Toast.makeText(MainActivity.this,"已设置墙纸为太阳壁纸",Toast.LENGTH_SHORT);
                        LinearLayout layout = (LinearLayout) toast.getView();
                        TextView tv = (TextView)layout.getChildAt(0);
                        tv.setTextColor(Color.WHITE);
                        layout.setBackgroundColor(mycolor);
                        toast.show();
                } else {
                    bitmap = (BitmapDrawable)getResources().getDrawable(wallpapers[i]);
                    Toast toast2 = Toast.makeText(MainActivity.this,"已设置墙纸为星光夜景壁纸",Toast.LENGTH_SHORT);
                    LinearLayout layout = (LinearLayout) toast2.getView();
                    TextView tv = (TextView)layout.getChildAt(0);
                    tv.setTextColor(Color.WHITE);
                    layout.setBackgroundColor(mycolor);
                    toast2.show();
                }

                try {
                    wallpaperManager.setBitmap(bitmap.getBitmap());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }



    private void initCtrl() {

        btn = findViewById(R.id.button);
        wallpaperManager = WallpaperManager.getInstance(MainActivity.this);
    }

}