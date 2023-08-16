package jp.ac.it_college.std.s22017.pbl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import jp.ac.it_college.std.s22017.pbl.databinding.ActivityZaikoEditBinding

class ZaikoEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityZaikoEditBinding
    private lateinit var realm: Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityZaikoEditBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val etName:TextView = binding.etName
        val etQuantity:TextView = binding.etQuantity
        val btnSave = binding.btnSave
        val btnDelete = binding.btnDelete

        realm = Realm.getDefaultInstance()

        val getId = intent.getLongExtra("ID",0L)
        if (getId > 0) {
            // 値が存在する
            val myModelResult = realm.where<MyModel>().equalTo("id",getId).findFirst()
            //該当するname と quantityを表示
            etName.text = myModelResult?.name.toString()
            etQuantity.text = myModelResult?.quantity.toString()

            btnDelete.visibility = View.VISIBLE
        } else {
            // データが存在しない
            btnDelete.visibility = View.INVISIBLE
        }



        //save btn click listener
        btnSave.setOnClickListener {
            var name: String = ""
            var quantity: Long = 0

            // validation
            if (!etName.text.isNullOrEmpty()) {
                name = etName.text.toString()
            }
            if (!etQuantity.text.isNullOrEmpty()) {
                quantity = etQuantity.text.toString().toLong()
            }

            //DBに書き込む
            //２３）条件分岐（idが0なら新規追加、それ以外は上書き）
            if(getId ==0L){
                //0Lの場合（新規追加）
                realm.executeTransaction {
                    val currentId = realm.where<MyModel>().max("id")//現時点のid(の最高値)を取得
                    val nextId =(currentId?.toLong() ?:0L)+1L //最高値に１を追加（最高値が０なら１に）←行を追加するイメージ
                    //モデルクラス(nextId番目)に値をセット
                    val myModel =realm.createObject<MyModel>(nextId)
                    myModel.name = name
                    myModel.quantity = quantity
                }
            }else{
                //そうじゃない場合（上書き）
                realm.executeTransaction {
                    val myModel = realm.where<MyModel>()
                        .equalTo("id",getId).findFirst()
                    myModel?.name = name
                    myModel?.quantity = quantity
                }
            }

            // toast saved
            Toast.makeText(applicationContext, "保存しました", Toast.LENGTH_SHORT).show()
            finish()
        }

        // 削除ボタンを押したら
        btnDelete.setOnClickListener {
            realm.executeTransaction {
                realm.where<MyModel>().equalTo("id",getId).findFirst()?.deleteFromRealm()
            }
            Toast.makeText(applicationContext, "削除しました", Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}