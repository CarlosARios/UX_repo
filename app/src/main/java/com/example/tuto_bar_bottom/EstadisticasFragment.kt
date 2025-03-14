package com.example.tuto_bar_bottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tuto_bar_bottom.databinding.FragmentEstadisticasBinding
import androidx.navigation.fragment.findNavController


class EstadisticasFragment : Fragment(R.layout.fragment_estadisticas) {

    private lateinit var binding : FragmentEstadisticasBinding

    override fun onCreate(savedInstanceState : Bundle?) {
        binding = FragmentEstadisticasBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEstadisticasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)






    }


}