package com.example.retroadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retroadapter.databinding.ItemBinding

class Adapter:RecyclerView.Adapter<Adapter.ViewHolder>(){
    private var arrayList: ArrayList<DataX?>? = ArrayList()

    class ViewHolder(binding: ItemBinding):RecyclerView.ViewHolder(binding.root){
            val code = binding.code
            val status=binding.status
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return arrayList?.size!!
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.code.text = arrayList?.get(position)?.description
        holder.status.text = arrayList?.get(position)?.name
    }

    @SuppressLint("NotifyDataSetChanged")
    internal fun setArraylist(list:ArrayList<DataX?>?){

        if(arrayList?.size!!>0){
            arrayList?.clear()
        }
        if (list != null) {
            arrayList?.addAll(list)
        }
        notifyDataSetChanged()
    }

}