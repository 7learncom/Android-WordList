package ir.mhd.words.letters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ir.mhd.words.R
import ir.mhd.words.databinding.FragmentLettersBinding
import ir.mhd.words.words.WordsFragment

class LettersFragment : Fragment() {

    private var _binding: FragmentLettersBinding? = null
    private val binding: FragmentLettersBinding
        get() = _binding!!

    private var isLinearLayout: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLettersBinding.inflate(inflater, container, false)
        setupViews()
        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViews() {
        setupRecyclerView()
        setupLayoutManagerButton()
    }

    private fun setupRecyclerView() {
        val letters = ('A'..'Z').map { it.toString() }
        val adapter = LetterAdapter(letters) {
            val action = LettersFragmentDirections.actionLettersFragmentToWordsFragment(it)
            findNavController().navigate(action)
        }
        binding.rvLetter.adapter = adapter
    }

    private fun setupLayoutManagerButton() {
        binding.ivChangeLayout.setOnClickListener {
            if (isLinearLayout) {
                binding.rvLetter.layoutManager = GridLayoutManager(requireContext(), 4)
                binding.ivChangeLayout.setImageResource(R.drawable.ic_leanear_layout)
            } else {
                binding.rvLetter.layoutManager = LinearLayoutManager(requireContext())
                binding.ivChangeLayout.setImageResource(R.drawable.ic_grid_layout)
            }
            isLinearLayout = !isLinearLayout
        }
    }
}