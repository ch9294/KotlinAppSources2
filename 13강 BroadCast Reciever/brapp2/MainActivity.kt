package kr.co.softcampus.brapp2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
//            var intent = Intent()
//            intent.setClassName("kr.co.softcampus.brapp1", "kr.co.softcampus.brapp1.TestReceiver")
            var intent = Intent("com.test.brapp1")
            intent.putExtra("data1", 100)
            intent.putExtra("data2", 11.11)
            sendBroadcast(intent)
        }
    }
}
