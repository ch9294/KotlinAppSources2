package kr.co.softcampus.activitycontroller


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 */
class ResultFragment : Fragment() {

    var button2: Button? = null
    var textView1: TextView? = null
    var textView2: TextView? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater!!.inflate(R.layout.fragment_result, container, false)

        button2 = view.findViewById<Button>(R.id.button2)
        textView1 = view.findViewById<TextView>(R.id.textView)
        textView2 = view.findViewById<TextView>(R.id.textView2)

        var main_activity = activity as MainActivity

        textView1?.text = main_activity.value1
        textView2?.text = main_activity.value2

        button2?.setOnClickListener { view ->
            main_activity.supportFragmentManager.popBackStack()
        }
        return view
    }

}// Required empty public constructor
