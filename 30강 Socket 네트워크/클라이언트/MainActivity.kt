package kr.co.softcampus.socketclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var thread = NetworkThread()
            thread.start()
        }
    }

    inner class NetworkThread : Thread(){
        override fun run() {
            try{
                var socket = Socket("192.168.0.20", 55555)

                var input = socket.getInputStream();
                var dis = DataInputStream(input);

                var output = socket.getOutputStream()
                var dos = DataOutputStream(output)

                var data1 = dis.readInt()
                var data2 = dis.readDouble()
                var data3 = dis.readUTF()

                dos.writeInt(200)
                dos.writeDouble(22.22)
                dos.writeUTF("클라이언트가 보낸 문자열")

                socket.close()

                runOnUiThread {
                    textView.text = "data1 : ${data1}\n"
                    textView.append("data2 : ${data2}\n")
                    textView.append("data3 : ${data3}")
                }

            }catch(e:Exception){
                e.printStackTrace()
            }
        }
    }
}













