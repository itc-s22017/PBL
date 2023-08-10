package jp.ac.it_college.std.s22017.pbl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import jp.ac.it_college.std.s22017.pbl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            val intent = Intent(this@MainActivity, ZaikoActivity::class.java)
            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            startActivity(Intent(this@MainActivity, DateListActivity::class.java))
        }


    }
}