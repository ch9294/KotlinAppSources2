package kr.co.softcampus.testlistfragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var list_fragment = TestListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tran = supportFragmentManager.beginTransaction()
        tran.replace(R.id.container, list_fragment)
        tran.commit()
    }
}
