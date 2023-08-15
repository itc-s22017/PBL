package jp.ac.it_college.std.s22017.pbl.Dialog

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DateDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //日付ダイアログの生成

        return dialog ?: throw IllegalStateException("Activity is null")
    }

}