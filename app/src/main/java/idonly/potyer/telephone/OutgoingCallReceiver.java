package idonly.potyer.telephone;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.Toast;

// WakefulBroadcastReceiver類別介紹：http://ithelp.ithome.com.tw/articles/10157150
// wakelock這個類別就是安卓設計來讓系統暫時不會進入休眠
// 而會使用到wakelock的時間點, 往往都是接收到了某個intent
// 然後藉由intent去開啟service做相對應的任務,
// 並且在service啟動時取得wakelock, 結束時釋放wakelock
// Android SDK針對這個需求提供了一個方便的class: WakefulBroadcastReceiver
// 這個class繼承原本的BroadcastReceiver, 並且可以幫助我們管理wakelock

//public class OutgoingCallReceiver extends WakefulBroadcastReceiver {
public class OutgoingCallReceiver extends WakefulBroadcastReceiver {
    public OutgoingCallReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
//        // 預設電話的狀態為一個空字串,代表電話的狀態可能是任何一種情況
//        String phoneState = "";
//        // Bundle:https://www.moke.tw/wordpress/computer/advanced/231
//        // 在Android的應用程式裡，會有一個Bundle的物件，它就像是用來儲存全域變數的一個地方，
//        // 我們的程式在 onCreate 的時候就會看到裡面含有傳入的參數 Bundle savedInstanceState。
//        // .getExtras方法為取得Bundle的方法
//        // 取得哪裡的Bundle,跟David請教一番
//        Bundle bundle = intent.getExtras();
//        if (bundle != null) {
//            phoneState = bundle.getString(TelephonyManager.EXTRA_STATE);
//        }

        String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);

        Toast.makeText(context, "Outgoing: " + number, Toast.LENGTH_LONG).show();

//        if (phoneState.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
//            Toast.makeText(context, "Get Phone", Toast.LENGTH_SHORT).show();
            intent.setClass(context, MyIntentService.class);
            startWakefulService(context, intent);
//
//        }
    }
}

