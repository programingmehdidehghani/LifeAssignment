package com.life.assignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.life.assignment.R

class AdaptersMonths : RecyclerView.Adapter<AdaptersMonths.ViewHolderAdapterMonth>() {

    inner class ViewHolderAdapterMonth(itemView : View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }
    private var onItemClickListener : ((String) -> Unit) ?= null

    val differ = AsyncListDiffer(this,differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAdapterMonth {
        return ViewHolderAdapterMonth(
            LayoutInflater.from(parent.context).inflate(
                R.layout.photos_header_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderAdapterMonth, position: Int) {
        val month = differ.currentList[position]
        holder.itemView.apply {
            val tvHello = findViewById<TextView>(R.id.photos_txt)
            tvHello.text = "photos $month"
            setOnClickListener {
                onItemClickListener?.let { it(month) }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun setOnItemClickListener(listener : (String) -> Unit) {
        onItemClickListener = listener
    }
}
