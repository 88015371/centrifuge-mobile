package com.example.fz.centrifugoandroid;

import android.os.Handler;
import android.widget.TextView;
import android.content.Context;
import android.app.Activity;
import centrifuge.Client;
import centrifuge.DisconnectHandler;

public class AppDisconnectHandler implements DisconnectHandler {
    protected MainActivity context;

    public AppDisconnectHandler(Context context) {
        this.context = (MainActivity) context;
    }

    @Override
    public void onDisconnect(Client client) throws Exception {
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView tv = (TextView) ((Activity) context).findViewById(R.id.text);
                tv.setText("Disconnected");
            }
        });
    }
}
