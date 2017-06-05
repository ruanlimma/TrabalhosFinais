package com.atlas.rl.PrimeiroBimestre;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;

public class Service1 extends IntentService {

    public  static  final String EXTRA_MESSAGE = "mensagem";
    public  static final int NOTIFICATION_ID = 5453;

    public Service1() {
        super("Service1");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this){
            try{
                wait(100);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            String text = intent.getStringExtra(EXTRA_MESSAGE);
            showText(text);
        }
    }

    private void showText(String text) {

        text = "Aproveite nosso App. Por Ruan";
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_trabalho)
                .setContentTitle("Conhecimentos em Android")
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentText(text)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);

    }

}

