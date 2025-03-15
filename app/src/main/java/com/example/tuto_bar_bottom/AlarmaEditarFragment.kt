package com.example.tuto_bar_bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tuto_bar_bottom.databinding.FragmentAlarmaEditarBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.DateFormat
import java.util.Date

class AlarmaEditarFragment : Fragment() {

    private var _binding: FragmentAlarmaEditarBinding? = null
    private val binding get() = _binding!!

    // Ejemplo de categorías
    private val categorias = listOf("Farmacia", "Oficina", "Casa", "Otros")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlarmaEditarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Spinner de categorías
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categorias)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spCategoria.adapter = adapter

        // Botón Cancelar
        binding.btnCancelar.setOnClickListener {
            findNavController().popBackStack()
        }

        // Botón Guardar
        binding.btnGuardar.setOnClickListener {
            // TODO: Lógica para guardar la alarma editada
            Toast.makeText(
                requireContext(),
                "Alarma editada exitosamente",
                Toast.LENGTH_SHORT
            ).show()
            findNavController().popBackStack()
        }

        binding.tilFechaLimite.setEndIconOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecciona una fecha")
                .build()
            datePicker.show(childFragmentManager, "DATE_PICKER")
            datePicker.addOnPositiveButtonClickListener { selection ->
                val date = Date(selection)
                val formattedDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(date)
                binding.etFechaLimite.setText(formattedDate)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
