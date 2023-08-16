package jp.ac.it_college.std.s22017.pbl

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolderItem(v:View):RecyclerView.ViewHolder(v) {
    // view(xml)の方からv経由で指定のidを見つけてくる
    var oneTvName: TextView =v.findViewById(R.id.oneTvName)
    var oneTvQuantity:TextView =v.findViewById(R.id.oneTvQuantity)
}