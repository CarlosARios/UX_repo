package com.example.tuto_bar_bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tuto_bar_bottom.databinding.FragmentAlarmasBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.navigation.fragment.findNavController

class AlarmasFragment : Fragment() {

    private var _binding: FragmentAlarmasBinding? = null
    private val binding get() = _binding!!
    private lateinit var alarmaAdapter: AlarmaAdapter
    private val listaAlarmas = mutableListOf<Alarma>()
    private lateinit var fabAddAlarm: FloatingActionButton
    private lateinit var btnVoz: MaterialButton
    private lateinit var btnManual: MaterialButton
    private var isFabOpen = false  // Para saber si el menú está abierto o cerrado
    private lateinit var overlayView: View



    // Lista completa de alarmas con nombres que indican si son individuales o grupales.
    private val allAlarms = listOf(
        Alarma("Alarma Individual 1", "2025-03-13", "08:00"),
        Alarma("Alarma Grupal 1", "2025-03-14", "09:30"),
        Alarma("Alarma Individual 2", "2025-03-15", "07:45"),
        Alarma("Alarma Grupal 2", "2025-03-16", "06:00"),
        Alarma("Alarma Individual 3", "2025-03-17", "10:00"),
        Alarma("Alarma Grupal 3", "2025-03-18", "11:30"),
        Alarma("Alarma Individual 4", "2025-03-19", "08:30"),
        Alarma("Alarma Grupal 4", "2025-03-20", "07:00"),
        Alarma("Alarma Individual 5", "2025-03-21", "09:00"),
        Alarma("Alarma Grupal 5", "2025-03-22", "10:30"),
        Alarma("Alarma Individual 6", "2025-03-21", "09:00"),
        Alarma("Alarma Individual 7", "2025-03-21", "09:00"),
        Alarma("Alarma Individual 8", "2025-03-21", "09:00"),
        Alarma("Alarma Individual 9", "2025-03-21", "09:00"),
        )

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

        fabAddAlarm = view.findViewById(R.id.fabAddAlarm)
        btnVoz = view.findViewById(R.id.btnVoz)
        btnManual = view.findViewById(R.id.btnManual)
        overlayView = view.findViewById(R.id.overlayView)

        overlayView.alpha = 0f
        overlayView.setOnClickListener {
            if (isFabOpen) {
                toggleFabMenu()
            }
        }

        fabAddAlarm.setOnClickListener {
            toggleFabMenu()
        }

        btnVoz.setOnClickListener {
            // Navega al fragmento de Alarmas de Voz
            findNavController().navigate(R.id.menu_alarmaVoz)
        }

        btnManual.setOnClickListener {
            // Navega al fragmento de Alarmas Manuales
            findNavController().navigate(R.id.page_alarmaManual)
        }

        // Inicialmente se muestran las alarmas individuales
        listaAlarmas.addAll(getIndividualAlarms())

        alarmaAdapter = AlarmaAdapter(
            listaAlarmas,
            onCheckClick = { alarma ->
                Toast.makeText(requireContext(), "${alarma.getNombre()} cumplida", Toast.LENGTH_SHORT).show()
                listaAlarmas.remove(alarma)
                alarmaAdapter.notifyDataSetChanged()
            },
            onDeleteClick = { alarma ->
                Toast.makeText(requireContext(), "${alarma.getNombre()} eliminada", Toast.LENGTH_SHORT).show()
                listaAlarmas.remove(alarma)
                alarmaAdapter.notifyDataSetChanged()
            }
        )

        binding.rvAlarmas.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAlarmas.adapter = alarmaAdapter

        // Configura el ToggleGroup para cambiar entre alarmas individuales y grupales
        binding.toggleGroupAlarma.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (!isChecked) return@addOnButtonCheckedListener

            when (checkedId) {
                R.id.btnAlarmaIndividual -> {
                    listaAlarmas.clear()
                    listaAlarmas.addAll(getIndividualAlarms())
                    alarmaAdapter.notifyDataSetChanged()
                }
                R.id.btnAlarmaGrupal -> {
                    listaAlarmas.clear()
                    listaAlarmas.addAll(getGroupAlarms())
                    alarmaAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    // Filtra las alarmas que contienen "Individual" en el nombre (ignorando mayúsculas/minúsculas)
    private fun getIndividualAlarms(): List<Alarma> {
        return allAlarms.filter { it.getNombre().contains("Individual", ignoreCase = true) }
    }

    // Filtra las alarmas que contienen "Grupal" en el nombre
    private fun getGroupAlarms(): List<Alarma> {
        return allAlarms.filter { it.getNombre().contains("Grupal", ignoreCase = true) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun toggleFabMenu() {
        if (!isFabOpen) {
            // Muestra overlay y botones
            overlayView.visibility = View.VISIBLE
            overlayView.animate().alpha(0.5f).setDuration(300).start()

            btnVoz.visibility = View.VISIBLE
            btnManual.visibility = View.VISIBLE
            btnVoz.animate().alpha(1f).setDuration(300).start()
            btnManual.animate().alpha(1f).setDuration(300).start()
        } else {
            // Oculta overlay y botones con animación
            overlayView.animate().alpha(0f).setDuration(300).withEndAction {
                overlayView.visibility = View.GONE
            }.start()

            btnVoz.animate().alpha(0f).setDuration(300).withEndAction {
                btnVoz.visibility = View.GONE
            }.start()

            btnManual.animate().alpha(0f).setDuration(300).withEndAction {
                btnManual.visibility = View.GONE
            }.start()
        }
        isFabOpen = !isFabOpen
    }
}
