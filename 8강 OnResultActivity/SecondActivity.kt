package kr.co.softcampus.onactivityresult

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        button.setOnClickListener { view ->
            setResult(Activity.RESULT_OK)
            finish()
        }

        button5.setOnClickListener { view ->
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        button6.setOnClickListener { view ->
            setResult(Activity.RESULT_FIRST_USER)
            finish()
        }
    }
}
