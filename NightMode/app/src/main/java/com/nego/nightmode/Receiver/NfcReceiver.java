package com.nego.nightmode.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.NfcAdapter;

import com.nego.nightmode.Costants;
import com.nego.nightmode.Functions.NMToggle;

public class NfcReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent.getAction())) {
            int id = intent.getIntExtra(NfcAdapter.EXTRA_ID, -1);
            SharedPreferences SP = context.getSharedPreferences(Costants.PREFERENCES_COSTANT, Context.MODE_PRIVATE);
            if (SP.getString(Costants.PREFERENCES_NFC_ID, "").equals(id)) {
                NMToggle.startAction(context, SP.getBoolean(Costants.PREFERENCES_NIGHT_MODE_ACTIVE, false) ? Costants.ACTION_NIGHT_MODE_OFF : Costants.ACTION_NIGHT_MODE_ON);
            }
        }
    }
}