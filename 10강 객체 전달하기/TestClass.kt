package kr.co.softcampus.sendobject

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by softcampus on 2018-01-15.
 */
class TestClass : Parcelable{

    var data10 : Int = 0
    var data20:String? = null

    companion object {
        @JvmField

        val CREATOR : Parcelable.Creator<TestClass> = object : Parcelable.Creator<TestClass>{
            override fun createFromParcel(p0: Parcel?): TestClass {
                val test = TestClass()
                test.data10 = p0?.readInt()!!
                test.data20 = p0?.readString()

                return test
            }

            override fun newArray(p0: Int): Array<TestClass?> {
                return arrayOfNulls<TestClass>(p0)
            }
        }
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeInt(data10)
        p0?.writeString(data20)
    }

    override fun describeContents(): Int {
        return 0
    }
}