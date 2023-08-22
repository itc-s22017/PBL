package jp.ac.it_college.std.s22017.pbl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.ac.it_college.std.s22017.pbl.databinding.ActivityDateListBinding
import jp.ac.it_college.std.s22017.pbl.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val text =  intent.getStringExtra("Date")
        binding.datetext.setText(text)
    }
}