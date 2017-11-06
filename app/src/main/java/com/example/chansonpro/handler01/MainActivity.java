package com.example.chansonpro.handler01;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
//    private TextView textView;
    private Handler handler = new Handler();
    private ImageView imageView;
    private int Images[] ={R.drawable.one,R.drawable.two,R.drawable.three};
    private int index;
    private MyRunnable myRunnable = new MyRunnable();


    class MyRunnable implements Runnable{

        @Override
        public void run() {
            index++;
            index = index%3;
            imageView.setImageResource(Images[index]);
            handler.postDelayed(myRunnable,1000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        handler.postDelayed(myRunnable,1000);

        /*new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);// 1000毫秒，秒钟
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("update thread");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();*/
    }

}
