package kr.co.softcampus.thread

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var now = System.currentTimeMillis()
            textView.text = "버튼 클릭 : ${now}"
        }

        /*
        while(true){
            var now = System.currentTimeMillis()
            textView2.text = "무한 루프 : ${now}"
        }
        */

        isRunning = true
        var thread = ThreadClass1()
        thread.start()
    }

    inner class ThreadClass1 : Thread(){
        override fun run() {
            while(isRunning){
                SystemClock.sleep(100)
                var now = System.currentTimeMillis()
                Log.d("test1", "쓰래드 : ${now}")

                textView2.text = "쓰래드 : ${now}"
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}








