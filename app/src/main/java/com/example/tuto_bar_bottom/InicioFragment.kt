package com.example.tuto_bar_bottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tuto_bar_bottom.databinding.FragmentInicioBinding

class InicioFragment : Fragment(R.layout.fragment_inicio) {

    private var _binding : FragmentInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? , savedInstanceState : Bundle?
    ) : View? {
        _binding = FragmentInicioBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view : View , savedInstanceState : Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        binding.textView.text = "Fragment inicio"

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_inicioFragment_to_alarmaManualFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
