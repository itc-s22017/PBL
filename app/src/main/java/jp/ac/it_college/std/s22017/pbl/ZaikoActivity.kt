package jp.ac.it_college.std.s22017.pbl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import io.realm.Sort
import jp.ac.it_college.std.s22017.pbl.databinding.ActivityMainBinding
import jp.ac.it_college.std.s22017.pbl.databinding.ActivityZaikoBinding

class ZaikoActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityZaikoBinding
    private lateinit var realm: Realm
    private lateinit var recyclerAdapter:RecyclerAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZaikoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        realm = Realm.getDefaultInstance() // realmインスタンス

        binding.btnHome.setOnClickListener {
            finish()
        }

        binding.addItem.setOnClickListener {
            val intent = Intent(this, ZaikoEditActivity::class.java)
            startActivity(intent)
        }
    }

    // activityが開始される度に呼ばれる
    override fun onStart() {
        super.onStart()
        //モデルクラスの全件を見つけて、ソート（並べ替え）をかける
        val realmResults = realm.where(MyModel::class.java)
            .findAll().sort("id", Sort.DESCENDING)//上の数字が大くてだんだん小さくなる（上に追加する）

        //アダプターに結果を入れますよ
        recyclerView = findViewById(R.id.rv)//ここでまずは中身recyclerViewにを入れる
        recyclerAdapter = RecyclerAdapter(realmResults)
        recyclerView.adapter = recyclerAdapter

        //縦並びに配置しますよ
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}