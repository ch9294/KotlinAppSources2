package kr.co.softcampus.runactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener { view ->
            finish()
        }
    }
}
