package com.tarun.demoapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tarun.demoapplication.R
import com.tarun.demoapplication.databinding.CarItemLayoutBinding
import com.tarun.demoapplication.databinding.CelebItemLayoutBinding
import com.tarun.demoapplication.databinding.HeaderItemLayoutBinding
import com.tarun.demoapplication.model.ResultDto
import kotlinx.android.synthetic.main.car_item_layout.view.*
import kotlinx.android.synthetic.main.celeb_item_layout.view.*

class DataRecyclerViewAdapter(
    private val mContext: Context,
    var itemList: List<ResultDto>
) :
    RecyclerView.Adapter<DataRecyclerViewAdapter.ItemViewHolder<*>>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_CELEB = 1
        private const val TYPE_CAR = 2
    }

    abstract class ItemViewHolder<ResultDto>(binding : ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        abstract fun bind(item: ResultDto)

    }

    inner class HeaderViewHolder(var binding: HeaderItemLayoutBinding) : ItemViewHolder<ResultDto>(binding) {
        override fun bind(item: ResultDto) {
//            itemView.header_txt.setText(item.name)
            binding.dataItem = item
        }

    }

    inner class CelebViewHolder(var binding: CelebItemLayoutBinding) : ItemViewHolder<ResultDto>(binding) {
        override fun bind(item: ResultDto) {
            binding.dataItem = item

            var url: String? = item.photo
            if (url != null) {
                Glide.with(binding.celebImg)
                    .load(url)
                    .placeholder(R.drawable.place_holder)
                    .error(R.drawable.broken_image)
                    .into(itemView.celeb_img)
            }
        }

    }

    inner class CarViewHolder(var binding: CarItemLayoutBinding) : ItemViewHolder<ResultDto>(binding) {
        override fun bind(item: ResultDto) {
            binding.dataItem = item

            var url: String? = item.photo
            if (url != null) {
                Glide.with(binding.carImg)
                    .load(url)
                    .placeholder(R.drawable.place_holder)
                    .error(R.drawable.broken_image)
                    .into(itemView.car_img)
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        var value: Int
        var item: ResultDto = itemList.get(position)
        if (item.photo == null) {
            value = TYPE_HEADER
        } else if (item.height == null) {
            value = TYPE_CAR
        } else {
            value = TYPE_CELEB
        }

        return value
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder<ResultDto> {
        return when (viewType) {
            TYPE_HEADER -> {
                val binding : HeaderItemLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.header_item_layout, parent, false)
                HeaderViewHolder(binding)
            }
            TYPE_CELEB -> {
                val binding : CelebItemLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.celeb_item_layout, parent, false)
                CelebViewHolder(binding)
            }
            TYPE_CAR -> {
                val binding : CarItemLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.car_item_layout, parent, false)
                CarViewHolder(binding)
            }
            else -> throw IllegalArgumentException()
        }
    }


    override fun getItemCount(): Int {
        return itemList.size
    }


    override fun onBindViewHolder(holder: ItemViewHolder<*>, position: Int) {
        val item = itemList.get(position)
        when (holder) {
            is HeaderViewHolder -> holder.bind(item)
            is CelebViewHolder -> holder.bind(item)
            is CarViewHolder -> holder.bind(item)
            else -> throw IllegalArgumentException()
        }
    }

}