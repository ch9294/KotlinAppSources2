package kr.co.softcampus.xmlclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Element
import java.net.URL
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

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
            try{
                var site = "http://192.168.130.17:8080/HttpNetwork/xml.jsp"
                var url = URL(site)
                var conn = url.openConnection()
                var input = conn.getInputStream()

                var factory = DocumentBuilderFactory.newInstance()
                var builder = factory.newDocumentBuilder()
                var doc = builder.parse(input)

                var root = doc.documentElement

                var item_node_list = root.getElementsByTagName("item")
                for(i in 0 until item_node_list.length){

                    var item_element = item_node_list.item(i) as Element

                    var data1_node_list = item_element.getElementsByTagName("data1")
                    var data2_node_list = item_element.getElementsByTagName("data2")
                    var data3_node_list = item_element.getElementsByTagName("data3")

                    var data1_node = data1_node_list.item(0) as Element
                    var data2_node = data2_node_list.item(0) as Element
                    var data3_node = data3_node_list.item(0) as Element

                    var data1 = data1_node.textContent
                    var data2 = data2_node.textContent
                    var data3 = data3_node.textContent

                    runOnUiThread {
                        textView.append("data1 : ${data1}\n")
                        textView.append("data2 : ${data2}\n")
                        textView.append("data3 : ${data3}\n\n")
                    }
                }
            }catch(e:Exception){
                e.printStackTrace()
            }
        }
    }
}
