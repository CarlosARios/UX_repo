package com.example.tuto_bar_bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tuto_bar_bottom.databinding.FragmentAlarmasBinding

class AlarmasFragment : Fragment() {

    private var _binding: FragmentAlarmasBinding? = null
    private val binding get() = _binding!!
    private lateinit var alarmaAdapter: AlarmaAdapter
    private val listaAlarmas = mutableListOf<Alarma>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlarmasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listaAlarmas.addAll(
            listOf(
                Alarma("Alarma 1", "2025-03-13", "08:00"),
                Alarma("Alarma 2", "2025-03-14", "09:30"),
                Alarma("Alarma 3", "2025-03-15", "07:45"),
                Alarma("Alarma 4", "2025-03-16", "06:00"),
                Alarma("Alarma 5", "2025-03-17", "10:00"),
                Alarma("Alarma 6", "2025-03-18", "11:30"),
                Alarma("Alarma 7", "2025-03-19", "12:45"),
                Alarma("Alarma 8", "2025-03-20", "13:00"),
                Alarma("Alarma 9", "2025-03-21", "14:00"),
            )
        )

        alarmaAdapter = AlarmaAdapter(
            listaAlarmas,
            onCheckClick = { alarma ->
                Toast.makeText(requireContext(), "${alarma.getNombre()}" + " cumplida", Toast.LENGTH_SHORT).show()
                listaAlarmas.remove(alarma)
                alarmaAdapter.notifyDataSetChanged()
            },
            onDeleteClick = { alarma ->
                listaAlarmas.remove(alarma)
                alarmaAdapter.notifyDataSetChanged()
            }
        )

        binding.rvAlarmas.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAlarmas.adapter = alarmaAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
