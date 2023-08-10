package jp.ac.it_college.std.s22017.pbl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.ac.it_college.std.s22017.pbl.databinding.ActivityDateListBinding
import jp.ac.it_college.std.s22017.pbl.databinding.ActivityMainBinding

class DateListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDateListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDateListBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.home.setOnClickListener {
//            startActivity(Intent(this@DateListActivity, MainActivity::class.java))
//        }
    }
}