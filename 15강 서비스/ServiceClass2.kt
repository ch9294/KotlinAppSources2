package kr.co.softcampus.service

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.SystemClock
import android.util.Log

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 *
 *
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class ServiceClass2 : IntentService("ServiceClass2") {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onHandleIntent(intent: Intent?) {
        var idx = 0
        while(idx < 10){
            SystemClock.sleep(1000)
            var time = System.currentTimeMillis()
            Log.d("test1", "Intent Service Running : ${time}")
            idx++
        }
    }
}
