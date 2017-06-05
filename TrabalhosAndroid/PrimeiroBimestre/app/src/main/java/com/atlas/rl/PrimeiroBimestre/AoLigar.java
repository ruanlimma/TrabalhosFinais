package com.atlas.rl.PrimeiroBimestre;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AoLigar extends BroadcastReceiver {
    public AoLigar() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startServiceIntent = new Intent(context, Service1.class);
        context.startService(startServiceIntent);
    }
}
