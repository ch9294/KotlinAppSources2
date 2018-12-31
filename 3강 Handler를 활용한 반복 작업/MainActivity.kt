package kr.co.softcampus.handler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Handler 객체 만들기
    /*
    안드로이드는 기본적으로 메인 쓰레드만이 화면 처리를 담당 할 수 있다. 오레오 버전부터 사용자가 정의한 쓰레드에서도
    화면 처리 작업이 가능하게 되었으나, 아직 누가(7.1) 이하를 사용하는 것이 대부분이기 때문에 적절하지 않다.
    
    Handler를 이용하면 기본적인 메인 쓰레드 작업이 쉬는 동안 사용자 정의 쓰레드를 화면 처리에 5초 이하로 사용 할 수 있게 해준다.
    */
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

    /*
    메인 쓰레드가 쉬는 동안 CPU가 자원을 할당할 쓰레드가 한번 발생할 때 5초 이하로 작업할 로직만 작성한다.
    무한 루프 및 대용량 작업은 하면 앱이 작동하지 않는다.
    */
    inner class ThreadClass : Thread(){
        override fun run() {
            var time = System.currentTimeMillis()
            textView2.text = "Handler : ${time}"

            // handler?.post(this)
            handler?.postDelayed(this, 100)
        }
    }
}
