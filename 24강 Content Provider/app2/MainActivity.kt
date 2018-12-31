package kr.co.softcampus.contentprovider

import android.content.ContentValues
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var uri = Uri.parse("content://kr.co.softcampus.dbprovider")

            var c = contentResolver.query(uri, null, null, null, null)

            textView.text = ""

            while(c.moveToNext()){
                var idx_pos = c.getColumnIndex("idx")
                var textData_pos = c.getColumnIndex("textData")
                var intData_pos = c.getColumnIndex("intData")
                var floatData_pos = c.getColumnIndex("floatData")
                var dateData_pos = c.getColumnIndex("dateData")

                var idx = c.getInt(idx_pos)
                var textData = c.getString(textData_pos)
                var intData = c.getInt(intData_pos)
                var floatData = c.getDouble(floatData_pos)
                var dateData = c.getString(dateData_pos)

                textView.append("idx : ${idx}\n")
                textView.append("textData : ${textData}\n")
                textView.append("intData : ${intData}\n")
                textView.append("floatData : ${floatData}\n")
                textView.append("dateData : ${dateData}\n\n")
            }
        }

        button2.setOnClickListener { view ->
            var sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            var date = sdf.format(Date())

            var cv1 = ContentValues();
            cv1.put("textData", "문자열3")
            cv1.put("intData", 300)
            cv1.put("floatData", 33.33)
            cv1.put("dateData", date)

            var cv2 = ContentValues()
            cv2.put("textData", "문자열4")
            cv2.put("intData", 400)
            cv2.put("floatData", 44.44)
            cv2.put("dateData", date)

            var uri = Uri.parse("content://kr.co.softcampus.dbprovider")

            contentResolver.insert(uri, cv1)
            contentResolver.insert(uri, cv2)

            textView.text = "저장완료"
        }

        button3.setOnClickListener { view ->
            var cv = ContentValues()
            cv.put("textData", "문자열100")
            var where = "idx=?"
            var args = arrayOf("3")

            var uri = Uri.parse("content://kr.co.softcampus.dbprovider")

            contentResolver.update(uri, cv, where, args)

            textView.text = "수정완료"
        }

        button4.setOnClickListener { view ->
            var where = "idx=?"
            var args = arrayOf("3")

            var uri = Uri.parse("content://kr.co.softcampus.dbprovider")
            contentResolver.delete(uri, where, args)
            textView.text = "삭제완료"
        }
    }
}








