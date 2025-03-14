package com.example.tuto_bar_bottom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class AlarmaAdapter(
    private val listaAlarmas: MutableList<Alarma>,
    private val onCheckClick: (Alarma) -> Unit,
    private val onDeleteClick: (Alarma) -> Unit

) : RecyclerView.Adapter<AlarmaAdapter.AlarmaViewHolder>() {

    inner class AlarmaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivIconLeft: ImageView = itemView.findViewById(R.id.ivIconLeft)
        val tvNombreAlarma: TextView = itemView.findViewById(R.id.tvNombreAlarma)
        val btnCheck: Button = itemView.findViewById(R.id.btnCheck)
        val btnDelete: Button = itemView.findViewById(R.id.btnDelete)
        val confirmationPanel: LinearLayout = itemView.findViewById(R.id.confirmationPanel)
        val confirmationPanelDelete: LinearLayout = itemView.findViewById(R.id.confirmationPanelDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alarma, parent, false)
        return AlarmaViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlarmaViewHolder, position: Int) {
        val alarma = listaAlarmas[position]
        holder.tvNombreAlarma.text = alarma.getNombre() // o alarma.nombre, según cómo accedas a la propiedad

        holder.btnCheck.setOnClickListener {
            holder.confirmationPanel.visibility = View.VISIBLE

            holder.itemView.postDelayed({
                // Si el panel sigue visible, se oculta automáticamente
                if (holder.confirmationPanel.visibility == View.VISIBLE) {
                    holder.confirmationPanel.visibility = View.GONE
                }
            }, 2000)
        }

        holder.btnDelete.setOnClickListener {
            holder.confirmationPanelDelete.visibility = View.VISIBLE

            holder.itemView.postDelayed({
                if (holder.confirmationPanelDelete.visibility == View.VISIBLE) {
                    holder.confirmationPanelDelete.visibility = View.GONE
                }
            }, 2000)
        }



        holder.confirmationPanel.setOnClickListener {
            onCheckClick(alarma)
            holder.confirmationPanel.visibility = View.GONE
        }

        holder.confirmationPanelDelete.setOnClickListener {
            onDeleteClick(alarma)
            holder.confirmationPanelDelete.visibility = View.GONE
        }

    }


    override fun getItemCount(): Int = listaAlarmas.size
}
