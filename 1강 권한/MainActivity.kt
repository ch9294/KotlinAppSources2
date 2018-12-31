package kr.co.softcampus.permission

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 권한 목록을 만든다.
    var permission_list = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.SEND_SMS,
            Manifest.permission.RECEIVE_SMS
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()
    }

    fun checkPermission(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }

        for(permission : String in permission_list){

            // 권한이 활성화 되었는지 여부를 확인한다.
            var chk = checkCallingOrSelfPermission(permission)

            // 만약 활성화가 되지 않았다면..
            if(chk == PackageManager.PERMISSION_DENIED){
                
                // 활성화 할것인지 물어본다.( 전체 배열을 넣었다고 해서 모두 물어보는 것이 아님)
                // 비활성화 된 것만 물어본다.
                requestPermissions(permission_list, 0);
                break;
            }
        }

    }

    // 권한 허용을 활성화하면 호출되는 메소드
    // requestPermissions(...)가 종료되고 바로 호출됨
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        var idx = 0;

        textView.text = ""
        
        // grantResults.indices는 grantResults의 인덱스이다.
        for(idx in grantResults.indices){
            if(grantResults[idx] == PackageManager.PERMISSION_GRANTED){
                textView.append("${permission_list[idx]} : 허용함\n");
            } else {
                textView.append("${permission_list[idx]} : 허용하지 않음\n");
            }
        }
    }
}







