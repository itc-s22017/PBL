package jp.ac.it_college.std.s22017.pbl.Dialog

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import jp.ac.it_college.std.s22017.pbl.R
import java.time.DayOfWeek
import java.time.Month
import java.time.Year
import java.util.Calendar

 class DateDialog : DialogFragment(){

//     interface DateCallBack {
//         fun onData(date: String)
//     }
//
//     private var callback: DateDialog.DateCallBack? = null
     override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
         //日付ダイアログの生成
         val cal = Calendar.getInstance()
             val dialog = activity?.let {
                 DatePickerDialog(
                     it,
                     { view, year, monthOfYear, dayOfMonth ->
                         val listDate = it.findViewById<EditText>(R.id.datalist)
                         listDate.setText("${year}/${monthOfYear + 1}/${dayOfMonth}")
                     },
                     cal[Calendar.YEAR],
                     cal[Calendar.MONTH],
                     cal[Calendar.DAY_OF_MONTH]
                 )
             }
        return dialog ?: throw IllegalStateException("Activity is null.")
     }
 }
