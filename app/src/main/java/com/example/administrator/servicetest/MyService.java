package com.example.administrator.servicetest;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
/*public class MyService extends Service {
    private DownloadBinder mBinder=new DownloadBinder();
    class DownloadBinder extends Binder{
        public void startDownload(){
            Log.d("MyService","startDownload executed");
        }
        public int getProgress(){
            Log.d("MyService","getProgress executed");
            return 0;
        }
    }
    @Override
    public IBinder onBind(Intent intent){
        return mBinder;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        Notification notification;
        Notification.Builder builder=new Notification.Builder(this).setSmallIcon(R.mipmap.ic_launcher).setTicker("haha");
        notification=builder.setContentIntent(null).setContentText("hello boy").setContentTitle("super!").build();
        startForeground(1,notification);
        Log.d("MyService","OnCreate executed");
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startid){
        Log.d("MyService","OnStartCommand executed");
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
       return super.onStartCommand(intent,flags,startid);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("MyService","onDestroy executed");
    }
}*/
public class MyService extends Service{
    private DownloadBinder mBinder = new DownloadBinder();
    class DownloadBinder extends Binder{
        public void startDownload(){
            Log.d("Service","start DownLoad in Service");
        }
        public void getProgress(){

        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Notification notification;
        Notification.Builder bulider = new Notification.Builder(this).setTicker("hello").setSmallIcon(R.mipmap.ic_launcher);
        notification = bulider.setContentTitle("Service").setContentText("Hello world").setContentIntent(null).build();
        startForeground(1,notification);
        Log.d("Service","onCreate executed");
    }

    @Override
    public int onStartCommand(Intent intent , int flags,int startId){
        Log.d("Service","onStartCommand executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("Service","onDestroy executed");
    }
}