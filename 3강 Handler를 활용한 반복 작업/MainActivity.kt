package kr.co.softcampus.handler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var handler : Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var time = System.currentTimeMillis()
            textView.text = "버튼 클릭 : ${time}"
        }

        handler = Handler()

//        while(true){
//            SystemClock.sleep(100)
//            var time = System.currentTimeMillis()
//            textView2.text = "while : ${time}"
//        }

        var thread = ThreadClass()
        //handler?.post(thread)
        handler?.postDelayed(thread, 100)
    }

    inner class ThreadClass : Thread(){
        override fun run() {
            var time = System.currentTimeMillis()
            textView2.text = "Handler : ${time}"

            // handler?.post(this)
            handler?.postDelayed(this, 100)
        }
    }
}
