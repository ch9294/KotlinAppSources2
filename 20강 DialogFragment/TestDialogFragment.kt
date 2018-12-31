package kr.co.softcampus.dialogfragment


import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*


/**
 * A simple [Fragment] subclass.
 */
class TestDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(activity)
        builder.setTitle("타이틀 입니다")
        builder.setMessage("메시지 입니다")

        var listener = DialogListener()

        builder.setPositiveButton("positive", listener)
        builder.setNeutralButton("neutral", listener)
        builder.setNegativeButton("negative", listener)

        var alert = builder.create()

        return alert

    }

    inner class DialogListener : DialogInterface.OnClickListener{
        override fun onClick(p0: DialogInterface?, p1: Int) {
            var main_activity = activity as MainActivity

            when(p1){
                DialogInterface.BUTTON_POSITIVE -> {
                    main_activity.textView.text = "positive"
                }
                DialogInterface.BUTTON_NEUTRAL -> {
                    main_activity.textView.text = "neutral"
                }
                DialogInterface.BUTTON_NEGATIVE -> {
                    main_activity.textView.text = "negative"
                }
            }
        }
    }

}// Required empty public constructor
