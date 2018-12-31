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
                // 안드로이드에서는 Thread.sleep() 대신에 SystemClock.sleep()을 사용한다.
                SystemClock.sleep(100)
                var now = System.currentTimeMillis()
                Log.d("test1", "쓰래드 : ${now}")

                // 오레오(8.0)부터 사용자 정의 쓰레드에서 화면 처리가 가능하게 되었다.
                // 하지만 전 세계 안드로이드 버전의 대부분은 8.0 미만의 경우가 95%가 되기 때문에
                // 이 방법은 거의 사용하지 않는 것이 좋다.
                textView2.text = "쓰래드 : ${now}"
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}








