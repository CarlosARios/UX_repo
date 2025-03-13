package com.example.tuto_bar_bottom

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.util.*

class AlarmaManualFragment : Fragment() {

    private lateinit var editTextNombre: EditText
    private lateinit var editTextFecha: EditText
    private lateinit var spinnerTipo: Spinner
    private lateinit var buttonCrearAlarma: Button
    private lateinit var buttonCancelar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alarma_manual, container, false)

        editTextNombre = view.findViewById(R.id.editText_manual_nombre)
        editTextFecha = view.findViewById(R.id.editTextDate)
        spinnerTipo = view.findViewById(R.id.spinner_tipo)
        buttonCrearAlarma = view.findViewById(R.id.button_manual_crear)
        buttonCancelar = view.findViewById(R.id.button_manual_cancel)

        // Configurar el Spinner
        val tipos = arrayOf("Universidad", "Gym", "Casa")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, tipos)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTipo.adapter = adapter

        // Resetear los campos
        editTextNombre.setText("")
        editTextFecha.setText("")
        spinnerTipo.setSelection(0)
        buttonCrearAlarma.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validateFields()
            }

            override fun afterTextChanged(s: Editable?) {}
        }

        editTextNombre.addTextChangedListener(textWatcher)
        editTextFecha.addTextChangedListener(textWatcher)

        editTextFecha.setOnClickListener {
            showDatePickerDialog()
        }

        buttonCancelar.setOnClickListener {
            findNavController().popBackStack()
        }

        buttonCrearAlarma.setOnClickListener {
            Toast.makeText(requireContext(), "Alarma creada", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_alarmaManualFragment_to_fragment_inicio)
        }

        return view
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = "$selectedDay-${selectedMonth + 1}-$selectedYear"
            editTextFecha.setText(selectedDate)
            editTextFecha.error = null // Eliminar el error
            validateFields()
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun validateFields() {
        val nombre = editTextNombre.text.toString()
        val fecha = editTextFecha.text.toString()

        val isNombreValid = nombre.isNotEmpty() && !nombre.contains(Regex("[^a-zA-Z0-9 ]"))
        val isFechaValid = fecha.isNotEmpty() && !fecha.contains(Regex("[^0-9-]"))

        if (!isNombreValid) {
            editTextNombre.error = "No se permiten caracteres especiales ni campos vacíos"
        } else {
            editTextNombre.error = null
        }

        if (!isFechaValid) {
            editTextFecha.error = "No se permiten caracteres especiales ni campos vacíos"
        } else {
            editTextFecha.error = null
        }

        buttonCrearAlarma.isEnabled = isNombreValid && isFechaValid
    }
}