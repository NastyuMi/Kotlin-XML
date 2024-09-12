package com.example.applicationwith3activity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AvatarAdapter(
    private val context: Context?,
    private val fragment: UseRecycleViewForAvatarsFragment,
    private val itemList: List<Pair<Int, String>>,
    private var onItemClick : (position : Int) -> Unit
) : RecyclerView.Adapter<AvatarAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(avatarImage: Int, avatarName: String ) {
            itemView.findViewById<TextView>(R.id.text_nameOfAvatars).text = avatarName

            val imageView = itemView.findViewById<ImageView>(R.id.image_avatars)

            Glide.with(fragment)
                .load(avatarImage)
                .into(imageView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycle_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val avatarData = itemList[position]

        holder.bind(avatarData.first, avatarData.second)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }



}