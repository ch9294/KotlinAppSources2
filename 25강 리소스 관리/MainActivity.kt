package kr.co.softcampus.resource

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
//            var str1 = resources.getString(R.string.str2)
//            textView.text = str1

            textView.setText(R.string.str2)
        }
        button2.setOnClickListener { view ->
            textView.text = ""
            var str_array = resources.getStringArray(R.array.data_array)
            for(str1 : String in str_array){
                textView.append("${str1}\n")
            }
        }
        button3.setOnClickListener { view ->
            // textView.setTextColor(Color.YELLOW)
            // var color = Color.rgb(26, 106, 129)
            // var color = Color.argb(50, 26, 106, 129)
            var color = ContextCompat.getColor(this, R.color.color1)
            textView.setTextColor(color)
        }
        button4.setOnClickListener { view ->
            var px = resources.getDimension(R.dimen.px)
            var dp = resources.getDimension(R.dimen.dp)
            var sp = resources.getDimension(R.dimen.sp)
            var inch = resources.getDimension(R.dimen.inch)
            var mm = resources.getDimension(R.dimen.mm)
            var pt = resources.getDimension(R.dimen.pt)

            textView.text = "px : ${px}\n"
            textView.append("dp : ${dp}\n")
            textView.append("sp : ${sp}\n")
            textView.append("inch : ${inch}\n")
            textView.append("mm : ${mm}\n")
            textView.append("pt : ${pt}\n")

            textView.setTextSize(20 * dp)
        }
    }
}









