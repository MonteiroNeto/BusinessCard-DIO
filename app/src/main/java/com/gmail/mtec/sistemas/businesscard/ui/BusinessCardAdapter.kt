package com.gmail.mtec.sistemas.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gmail.mtec.sistemas.businesscard.R
import com.gmail.mtec.sistemas.businesscard.data.BusinessCardModel
import com.gmail.mtec.sistemas.businesscard.databinding.CardsViewBinding

class BusinessCardAdapter :
    ListAdapter<BusinessCardModel, BusinessCardAdapter.MyViewHolder>(DiffCallBack()) {

    var listenerShare: (View) -> Unit = {}



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
     val inflater = LayoutInflater.from(parent.context)
        val binding = CardsViewBinding.inflate(inflater,parent,false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MyViewHolder(
        private val binding: CardsViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BusinessCardModel) {
            binding.tvName.text = item.nome
            binding.tvTelefone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.tvEmpresa.text = item.empresa

            try {
                binding.cvItem.setBackgroundColor(Color.parseColor(item.card_background))
            }catch (e:Exception){
                binding.cvItem.setBackgroundColor(Color.GRAY)
            }

            binding.cvItem.setOnLongClickListener {
                listenerShare(it)
                true
            }



        }
    }



}

class DiffCallBack : DiffUtil.ItemCallback<BusinessCardModel>() {
    override fun areItemsTheSame(oldItem: BusinessCardModel, newItem: BusinessCardModel) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCardModel, newItem: BusinessCardModel) =
        oldItem.id == newItem.id

}