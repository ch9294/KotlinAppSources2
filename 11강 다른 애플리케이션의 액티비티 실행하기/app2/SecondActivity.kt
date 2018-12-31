package kr.co.softcampus.activityapp2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var data1 = intent.getIntExtra("data1", 0)
        var data2 = intent.getDoubleExtra("data2", 0.0)
        textView.text = "data1 : ${data1}\n"
        textView.append("data2 : ${data2}")

        button.setOnClickListener { view ->
            var intent2 = Intent()
            intent2.putExtra("value1", 200)
            intent2.putExtra("value2", 22.22)
            setResult(RESULT_OK, intent2)
            finish()
        }
    }
}
