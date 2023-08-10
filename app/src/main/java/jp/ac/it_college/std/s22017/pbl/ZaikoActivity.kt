package jp.ac.it_college.std.s22017.pbl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import jp.ac.it_college.std.s22017.pbl.databinding.ActivityMainBinding
import jp.ac.it_college.std.s22017.pbl.databinding.ActivityZaikoBinding

class ZaikoActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityZaikoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZaikoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHome.setOnClickListener {
            finish()
        }


    }
}