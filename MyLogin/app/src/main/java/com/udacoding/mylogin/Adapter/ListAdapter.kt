package com.udacoding.mylogin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.udacoding.mylogin.R
import com.udacoding.mylogin.model.Horden

class ListAdapter(
    private val context: Context,
    private val data: List<Horden>?,
    private val itemClick: OnClickListener
) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)

        Glide.with(holder.itemView.context)
            .load(data?.get(position)?.image)
            .apply(RequestOptions().override(350, 350))
            .into(holder.foto)
        holder.nama.text = item?.nama
        holder.harga.text = item?.harga
        holder.spesifikasi.text = item?.spesifikasi

        holder.view.setOnClickListener {
            itemClick.onClick(item)
        }
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var foto = view.findViewById<ImageView>(R.id.iv_image)
        var nama = view.findViewById<TextView>(R.id.tv_nama)
        var spesifikasi = view.findViewById<TextView>(R.id.tv_spesifikasi)
        var harga = view.findViewById<TextView>(R.id.tv_harga)
    }

    interface OnClickListener {
        fun onClick(item: Horden?)
    }
}