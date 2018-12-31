package kr.co.softcampus.brapp1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class TestReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        var data1 = intent.getIntExtra("data1", 0)
        var data2 = intent.getDoubleExtra("data2", 0.0)
        var str = "data1 : ${data1}\ndata2 : ${data2}"
        var t1 = Toast.makeText(context, str, Toast.LENGTH_SHORT)
        t1.show()
    }
}
