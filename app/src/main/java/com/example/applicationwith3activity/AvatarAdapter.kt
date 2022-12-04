package com.example.applicationwith3activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.applicationwith3activity.databinding.RecycleRowBinding

class AvatarAdapter
/*(
    private val itemList : List<Pair<Int?, String?>>,
    private val onItemClick : (position: Int) -> Unit) :
    RecyclerView.Adapter<AvatarAdapter.AvatarHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvatarHolder {
        val itemBinding = RecycleRowBinding.inflate(LayoutInflater.from(parent.context))
        return AvatarHolder(itemBinding, onItemClick)
    }

    override fun onBindViewHolder(holder: AvatarHolder, position: Int) {
        val avatarData = itemList[position]
        holder.bind(avatarData.first, avatarData.second)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class AvatarHolder(
        private val itemList : List<Pair<Int?, String?>>,
        private val onItemClick : (position: Int) -> Unit) :
        RecyclerView.ViewHolder(itemBinding.root) {
        init {
            itemView.setOnClickListener{
                onItemClick(adapterPosition)
            }
        }

        fun bind(avatarFoto : Int?, avatarName : String?){
            Glide.with(itemView)
                .load(avatarFoto)
                .centerCrop()
                .placeholder(itemBinding.iVAvatarPicture.drawble)
                .error(android.R.drawable.stat_notify_sync)
                .fallBack(android.R.drawable.ic_menu_close_clear_cancel)
                .info(itemBinding.iVAvatarPicture)
        }

    }

}*/