package com.example.tuto_bar_bottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tuto_bar_bottom.databinding.FragmentInicioBinding

class InicioFragment : Fragment(R.layout.fragment_inicio) {

    private lateinit var binding : FragmentInicioBinding


    override fun onCreate(savedInstanceState : Bundle?) {
        binding = FragmentInicioBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? , savedInstanceState : Bundle?
    ) : View? {

        binding.tvInicio.text = "Fragment inicio"

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio , container , false)
    }


}