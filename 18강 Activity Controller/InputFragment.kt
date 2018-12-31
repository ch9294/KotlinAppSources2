package kr.co.softcampus.activitycontroller


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


/**
 * A simple [Fragment] subclass.
 */
class InputFragment : Fragment() {

    var button: Button? = null
    var edit1:EditText? = null
    var edit2:EditText? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater!!.inflate(R.layout.fragment_input, container, false)

        button = view.findViewById<Button>(R.id.button)
        edit1 = view.findViewById<EditText>(R.id.editText)
        edit2 = view.findViewById<EditText>(R.id.editText2)

        button?.setOnClickListener { view ->
            var main_activity = activity as MainActivity

            main_activity.value1 = edit1?.text.toString()
            main_activity.value2 = edit2?.text.toString()

            main_activity.setFragment("result")
        }

        return view
    }

}// Required empty public constructor
