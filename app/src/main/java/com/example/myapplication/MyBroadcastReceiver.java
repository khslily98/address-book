package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.support.annotation.RequiresApi;

public class MyBroadcastReceiver extends BroadcastReceiver
{
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent)
    {
        System.out.println("reaching onReceive");
        Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);

        Notification noti = new Notification.Builder(context)
                .setContentTitle("Alarm ON")
                .setContentText("Please set up the alarm")
                .setSmallIcon(R.mipmap.ic_launcher).build();

        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        String id = "my_channel_01";
        int importance = NotificationManager.IMPORTANCE_LOW;
        NotificationChannel mChannel = new NotificationChannel(id, "NOTIFICATION_CHANNEL_NAME", importance);
        mChannel.enableLights(true);
        manager.createNotificationChannel(mChannel);


        noti.flags|=Notification.FLAG_AUTO_CANCEL;
        manager.notify(0,noti);

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        Ringtone r = RingtoneManager.getRingtone(context,notification);
        r.play();
    }
}