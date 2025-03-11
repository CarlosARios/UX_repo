package com.example.tuto_bar_bottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tuto_bar_bottom.databinding.FragmentFavoritoBinding
import com.example.tuto_bar_bottom.databinding.FragmentInicioBinding


class FavoritoFragment : Fragment(R.layout.fragment_favorito) {

    private lateinit var binding : FragmentFavoritoBinding

    override fun onCreate(savedInstanceState : Bundle?) {
        binding = FragmentFavoritoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? , savedInstanceState : Bundle?
    ) : View? {

        binding.tvFavorito.text = "Fragment favorito"

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorito , container , false)
    }


}