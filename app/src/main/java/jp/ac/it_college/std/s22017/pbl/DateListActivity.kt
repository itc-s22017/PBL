package jp.ac.it_college.std.s22017.pbl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import jp.ac.it_college.std.s22017.pbl.Dialog.DateDialog
import jp.ac.it_college.std.s22017.pbl.databinding.ActivityDateListBinding
import jp.ac.it_college.std.s22017.pbl.databinding.ActivityMainBinding

class DateListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDateListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDateListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.home.setOnClickListener {
            startActivity(Intent(this@DateListActivity, MainActivity::class.java))
        }

        // listの設定
        val data = mutableListOf(
            "2022/1", "2022/2", "2022/3"
        )

        val list = findViewById<ListView>(R.id.datalist)

        list.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, data
        )

        // dialog の設定
        binding.date.setOnClickListener {
            val dialog = DateDialog()
            dialog.show(supportFragmentManager, "dialog_basic")
        }

        list.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DetailActivity::class.java)
            val date = data[position]
            intent.putExtra("Date", date)
            startActivity(intent)
        }
    }
}