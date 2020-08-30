package com.udacoding.mylogin.view.list

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.udacoding.mylogin.Adapter.ListAdapter
import com.udacoding.mylogin.R
import com.udacoding.mylogin.model.Horden
import kotlinx.android.synthetic.main.item_detail.*

class ListActivity : AppCompatActivity() {
    private lateinit var rvHorden: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val listData = ArrayList<Horden>()
        listData.add(
            Horden(
                R.drawable.alvine,
                "ALVINE SPETS",
                "Vitrase, 1 pasang, putih pudar",
                "Rp 149.000"
            )
        )
        listData.add(
            Horden(
                R.drawable.bergskraban,
                "BERGSKRABBA",
                "Gorden, 1 pasang, biru/merah garis-garis",
                "Rp 499.000"
            )
        )
        listData.add(
            Horden(
                R.drawable.lenda,
                "LENDA",
                "Gorden dengan pengikat, 1 pasang, abu-abu",
                "Rp 299.000"
            )
        )
        listData.add(
            Horden(
                R.drawable.strand,
                "STRANDTRIFT",
                "Gorden, 1 pasang, ungu/putih",
                "Rp 399.000"
            )
        )
        listData.add(
            Horden(
                R.drawable.merete,
                "MERETE",
                "Gorden penggelap ruangan, 1 pasang, cokelat muda-merah",
                "Rp 499.000"
            )
        )
        listData.add(Horden(R.drawable.tibast, "TIBAST", "Gorden, 1 pasang, biru", "Rp 999.000"))
        listData.add(
            Horden(
                R.drawable.marjun,
                "MARJUN",
                "Tirai penggelap ruangan, 1 pasang, ungu",
                "Rp 799.000"
            )
        )
        listData.add(
            Horden(
                R.drawable.borghild,
                "BORGHILD",
                "Gorden tipis, 1 pasang, putih",
                "Rp 399.000"
            )
        )
        listData.add(
            Horden(
                R.drawable.hannalena,
                "HANNALENA",
                "Gorden penggelap ruangan, 1 pasang, abu-abu",
                "Rp 699.000"
            )
        )
        listData.add(
            Horden(
                R.drawable.majgull,
                "MAJGULL",
                "Gorden anti tembus cahaya, 1 pasang, hijau",
                "Rp 799.000"
            )
        )
        listData.add(
            Horden(
                R.drawable.sparvort,
                "SPARVORT",
                "Gorden tipis, 1 pasang, putih",
                "Rp 699.000"
            )
        )

        rvHorden = findViewById(R.id.rv_list)
        rvHorden.setHasFixedSize(true)

        rvHorden.layoutManager = LinearLayoutManager(this)
        rvHorden.adapter = ListAdapter(this, listData, object : ListAdapter.OnClickListener {
            @SuppressLint("SetTextI18n")
            override fun onClick(item: Horden?) {

                Dialog(this@ListActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.item_detail)

                    Glide.with(this@ListActivity)
                        .load(item?.image ?: 0)
                        .apply(RequestOptions().override(350, 350)).into(iv_image_detail)

                    tv_nama_detail.text = "Nama : ${item?.nama}"
                    tv_spesifikasi_detail.text = "Spesifikasi : ${item?.spesifikasi}"
                    tv_harga_detail.text = "Harga : ${item?.harga}"

                    btn_close.setOnClickListener { this.dismiss() }
                }.show()
            }
        })
    }
}