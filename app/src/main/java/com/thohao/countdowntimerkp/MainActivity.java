package com.thohao.countdowntimerkp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView mImgBanner;
    int []arrayImage= new int[4];
    int count=1;
    //Animation animation=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mapview();
    }

    private void mapview() {
//        animation =new TranslateAnimation(0, 500, 0, 500);
//        animation.setDuration(2000);


        //countdowntimer là 1 luong rieng(thread), luồng phụ kg dc tuong tac voi main thread, kg xử lý giao dien của MainActivity thread
       //10 000 tong thoi gian 10s
        //1000 thoi gian thực thi 1s
        CountDownTimer countDownTimer=new CountDownTimer(2000,2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //Log.d("BBB",millisUntilFinished+"");
                mImgBanner.setImageResource(arrayImage[count++]);
                if(count>=arrayImage.length) count=0;
                //mImgBanner.startAnimation(animation);
            }

            @Override
            public void onFinish() {
                this.start();
            }

        };
        countDownTimer.start();


    }

    private void init() {
        mImgBanner=findViewById(R.id.imgBanner);
        arrayImage[0]=R.drawable.banner01;
        arrayImage[1]=R.drawable.banner02;
        arrayImage[2]=R.drawable.banner03;
        arrayImage[3]=R.drawable.banner04;
    }
}
//git push -u origin dev_Hao