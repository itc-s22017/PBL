package jp.ac.it_college.std.s22017.pbl

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults

class RecyclerAdapter(realmResult:RealmResults<MyModel>):RecyclerView.Adapter<ViewHolderItem>() {
    private val rResults:RealmResults<MyModel> = realmResult
    // 1行だけのレイアウト
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        val oneLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.one_layout,parent,false)
        return ViewHolderItem(oneLayout)
    }

    // position番目のデータを表示
    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {
        val myModel = rResults[position]
        holder.oneTvName.text = myModel?.name.toString()
        holder.oneTvQuantity.text = myModel?.quantity.toString()

        // クリックされたら
        // itemViewプロパティでViewにアクセスできる
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,ZaikoEditActivity::class.java) // it = recyclerViewで定義されたレイアウトView
            // idを渡す
            intent.putExtra("ID",myModel?.id)
            it.context.startActivity(intent)
        }
    }

    //リストの件数
    override fun getItemCount(): Int {
        return rResults.size
    }


}