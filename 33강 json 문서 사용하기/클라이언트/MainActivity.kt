package kr.co.softcampus.jsonclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = ""

        button.setOnClickListener { view ->
            var thread = NetworkThread()
            thread.start()
        }
    }

    inner class NetworkThread : Thread(){
        override fun run() {
            var site = "http://192.168.130.17:8080/HttpNetwork/json.jsp"
            var url = URL(site)
            var conn = url.openConnection()
            var input = conn.getInputStream()
            var isr = InputStreamReader(input)
            var br = BufferedReader(isr)

            var str:String? = null
            var buf = StringBuffer()

            do{
                str = br.readLine()
                if(str != null){
                    buf.append(str)
                }
            } while(str != null)

            var root = JSONArray(buf.toString())

            for(i in 0 until root.length()){

                var obj = root.getJSONObject(i)

                var data1 = obj.getString("data1")
                var data2 = obj.getInt("data2")
                var data3 = obj.getDouble("data3")

                runOnUiThread {
                    textView.append("data1 : ${data1}\n")
                    textView.append("data2 : ${data2}\n")
                    textView.append("data3 : ${data3}\n\n")
                }
            }

        }
    }
}









