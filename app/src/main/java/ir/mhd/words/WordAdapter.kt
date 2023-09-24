package ir.mhd.words

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.mhd.words.databinding.ItemViewBinding

class WordAdapter(
    private val words: List<String>,
    private val onWordClicked: (String) -> Unit
) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(binding, onWordClicked)
    }

    override fun getItemCount(): Int = words.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(words[position])
    }

    inner class WordViewHolder(
        private val binding: ItemViewBinding,
        private val onWordClicked: (String) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(word: String) {
            binding.root.text = word
            binding.root.setOnClickListener {
                onWordClicked(word)
            }
        }
    }
}