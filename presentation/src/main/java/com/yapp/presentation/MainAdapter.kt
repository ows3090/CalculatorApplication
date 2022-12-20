package com.yapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yapp.presentation.databinding.ViewCalculatorHistoryBinding

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var items: List<MainViewState> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ViewCalculatorHistoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItem(items: List<MainViewState>){
        this.items = items
        notifyDataSetChanged()
    }

    inner class MainViewHolder(
        private val binding: ViewCalculatorHistoryBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(state: MainViewState){
            binding.tvResult.text = ""

            val result = state.operands.foldIndexed(0){ index, acc, s ->
                when(state.operators[index]){
                    "+" -> acc + s.toInt()
                    "-" -> acc - s.toInt()
                    else -> acc * s.toInt()
                }
            }

            state.operators.drop(1).forEachIndexed { index, s ->
                binding.tvResult.text = binding.tvResult.text.toString() + " ${state.operands.get(index)} $s "
            }
            binding.tvResult.text = binding.tvResult.text.toString() + "${state.operands.last()} = $result"
        }
    }
}