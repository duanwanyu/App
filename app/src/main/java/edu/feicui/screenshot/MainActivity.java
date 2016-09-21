package edu.feicui.screenshot;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
        img=(ImageView)findViewById(R.id.imageView1);
    }

    @Override
    public void onClick(View view) {
        String filePath= Environment.getExternalStorageDirectory()+"/DCIM/"+"javaapk.png";
        ScreenShot.shoot(this,new File(filePath));
    }
    public static Bitmap getLocalBitmap(String url){
        try {
            FileInputStream fis=new FileInputStream(url);
            return BitmapFactory.decodeStream(fis);
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
}
