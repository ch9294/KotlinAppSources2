package kr.co.softcampus.service

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var service_intent: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            service_intent = Intent(this, ServiceClass1::class.java)
            startService(service_intent)
            finish()
        }

        button2.setOnClickListener{ view ->
            stopService(service_intent)
        }

        button3.setOnClickListener { view ->
            service_intent = Intent(this, ServiceClass2::class.java)
            startService(service_intent)
            finish()
        }
        button4.setOnClickListener { view ->
            service_intent = Intent(this, ServiceClass3::class.java)
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                startForegroundService(service_intent)
            } else {
                startService(service_intent)
            }
            finish()
        }
    }
}
