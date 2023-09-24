package ir.mhd.words

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ir.mhd.words.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var isLinearLayout: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        setupLayoutManagerButton()
    }

    private fun setupRecyclerView() {
        val letters = ('A'..'Z').map { it.toString() }
        val adapter = LetterAdapter(letters) {
            val intent = Intent(this, WordsActivity::class.java).apply {
                putExtra(WordsActivity.KEY_LETTER, it)
            }
            startActivity(intent)
        }
        binding.rvLetter.adapter = adapter
    }

    private fun setupLayoutManagerButton() {
        binding.ivChangeLayout.setOnClickListener {
            if (isLinearLayout) {
                binding.rvLetter.layoutManager = GridLayoutManager(this, 4)
                binding.ivChangeLayout.setImageResource(R.drawable.ic_leanear_layout)
            } else {
                binding.rvLetter.layoutManager = LinearLayoutManager(this)
                binding.ivChangeLayout.setImageResource(R.drawable.ic_grid_layout)
            }
            isLinearLayout = !isLinearLayout
        }

    }
}