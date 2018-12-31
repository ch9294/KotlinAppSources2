package kr.co.softcampus.testlistfragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 */
class TestListFragment : ListFragment() {

    var textView:TextView? = null
    var list = arrayOf("항목1", "항목2", "항목3", "항목4", "항목5")

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater!!.inflate(R.layout.fragment_test_list, container, false)

        textView = view.findViewById<TextView>(R.id.textView)

        var adapter = ArrayAdapter<String>(
                activity, android.R.layout.simple_list_item_1, list
        )

        listAdapter = adapter

        return view
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        var str = list[position]

        textView?.text = str
    }

}// Required empty public constructor
