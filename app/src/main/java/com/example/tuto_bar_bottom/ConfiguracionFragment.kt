package com.example.tuto_bar_bottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tuto_bar_bottom.databinding.FragmentConfiguracionBinding
import com.example.tuto_bar_bottom.databinding.FragmentInicioBinding


class ConfiguracionFragment : Fragment(R.layout.fragment_configuracion) {

    private lateinit var binding : FragmentConfiguracionBinding

    override fun onCreate(savedInstanceState : Bundle?) {
        binding = FragmentConfiguracionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? , savedInstanceState : Bundle?
    ) : View? {

        binding.tvConfiguracion.text = "Fragment configuracion"

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_configuracion , container , false)
    }


}