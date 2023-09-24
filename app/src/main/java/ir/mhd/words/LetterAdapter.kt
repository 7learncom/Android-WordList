package ir.mhd.words

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.mhd.words.databinding.ItemViewBinding

class LetterAdapter(
    private val letters: List<String>,
    private val onLetterClicked: (String) -> Unit
) : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LetterViewHolder(binding, onLetterClicked)
    }

    override fun getItemCount(): Int = letters.size

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        holder.bind(letters[position])
    }

    inner class LetterViewHolder(
        private val binding: ItemViewBinding,
        private val onLetterClicked: (String) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(letter: String) {
            binding.root.text = letter
            binding.root.setOnClickListener {
                onLetterClicked(letter)
            }
        }
    }

}