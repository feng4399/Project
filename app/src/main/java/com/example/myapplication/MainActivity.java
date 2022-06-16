package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private final static String TAG=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //btnMy=findViewById(R.id.btn_my);
        getData();
        Log.d(TAG,"MainActivity");
    }

    public void getData() {
        BaseRequest.getInstance().getApiServise().getList().subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseObserver<Object>(this) {
            @Override
            public void onSuccess(BaseReponse<Object> t) {
                //成功回调方法,可以直接在此更新ui,AndroidSchedulers.mainThread()表示切换到主线程
                Log.e(TAG,t.isSuccess()+"");
            }

            @Override
            public void onCodeError(BaseReponse baseReponse) {
                //失败回调方法,可以直接在此更新ui,AndroidSchedulers.mainThread()表示切换到主线程
            }

            @Override
            public void onFailure(Throwable e, boolean netWork) throws Exception {

            }
        });
    }



}