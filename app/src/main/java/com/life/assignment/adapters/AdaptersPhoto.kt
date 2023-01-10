package com.life.assignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.life.assignment.R
import com.life.assignment.data.Photos
import com.life.assignment.utils.ImageLoader

class AdaptersPhoto : RecyclerView.Adapter<AdaptersPhoto.ViewHolderAdaptersPhoto>() {

    inner class ViewHolderAdaptersPhoto(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Photos>() {
        override fun areItemsTheSame(oldItem: Photos, newItem: Photos): Boolean {
            return oldItem.imageUrl == newItem.imageUrl
        }

        override fun areContentsTheSame(oldItem: Photos, newItem: Photos): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAdaptersPhoto {
        return ViewHolderAdaptersPhoto(
            LayoutInflater.from(parent.context).inflate(
                R.layout.photos_card_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderAdaptersPhoto, position: Int) {
        val photos = differ.currentList[position]
        holder.itemView.apply {
            val photoImage =
                findViewById<androidx.appcompat.widget.AppCompatImageView>(R.id.photo_image)
            val authors = findViewById<TextView>(R.id.authors)
            val dates = findViewById<TextView>(R.id.dates)
            ImageLoader.loadImage(photoImage, photos.imageUrl)
            authors.text = photos.author.firstName
            dates.text = photos.takenDate.toString()
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}