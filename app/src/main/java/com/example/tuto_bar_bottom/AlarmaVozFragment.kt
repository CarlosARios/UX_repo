package com.example.tuto_bar_bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tuto_bar_bottom.databinding.FragmentAlarmaVozBinding

class AlarmaVozFragment : Fragment() {

    private var _binding: FragmentAlarmaVozBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlarmaVozBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGrabar.setOnClickListener {
            binding.clRecordingOverlay.visibility = View.VISIBLE
        }

        // Configura el botón Cancelar
        binding.btnCancelar.setOnClickListener {
            binding.clRecordingOverlay.visibility = View.GONE

        }

        // Configura el botón Guardar
        binding.btnGuardar.setOnClickListener {
            findNavController().navigate(R.id.action_alarmaVozFragment_to_menu_alarmas)
            Toast.makeText(requireContext(), "Alarma grabada correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
