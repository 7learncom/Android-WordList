package ir.mhd.words.words

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ir.mhd.words.R
import ir.mhd.words.databinding.FragmentWordsBinding

class WordsFragment : Fragment(R.layout.fragment_words) {

    companion object {
        const val KEY_LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    private var _binding: FragmentWordsBinding? = null
    private val binding: FragmentWordsBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentWordsBinding.bind(view)
        setupViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViews(){
//        val prefixLetter = intent.getStringExtra(WordsActivity.KEY_LETTER)!!
//        binding.tvTitle.text = "Words that starts with $prefixLetter"
//
//        val filteredWords = resources.getStringArray(R.array.words)
//            .filter { it.startsWith(prefixLetter, ignoreCase = true) }
//        val adapter = WordAdapter(filteredWords) {
//            val uri = Uri.parse("${WordsActivity.SEARCH_PREFIX}$it")
//            val intent = Intent(Intent.ACTION_VIEW, uri)
//            startActivity(Intent.createChooser(intent, "Chose a program"))
//        }
//        binding.rvWords.adapter = adapter
//        binding.rvWords.addItemDecoration(
//            DividerItemDecoration(
//                this,
//                DividerItemDecoration.VERTICAL
//            )
//        )
    }
}