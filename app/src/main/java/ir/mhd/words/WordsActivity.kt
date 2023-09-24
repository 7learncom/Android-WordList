package ir.mhd.words

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import ir.mhd.words.databinding.ActivityWordsBinding

class WordsActivity : AppCompatActivity() {
    companion object {
        const val KEY_LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    private lateinit var binding: ActivityWordsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWordsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val prefixLetter = intent.getStringExtra(KEY_LETTER)!!
        binding.tvTitle.text = "Words that starts with $prefixLetter"

        val filteredWords = resources.getStringArray(R.array.words)
            .filter { it.startsWith(prefixLetter, ignoreCase = true) }
        val adapter = WordAdapter(filteredWords) {
            val uri = Uri.parse("$SEARCH_PREFIX$it")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(Intent.createChooser(intent, "Chose a program"))
        }
        binding.rvWords.adapter = adapter
        binding.rvWords.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
    }
}