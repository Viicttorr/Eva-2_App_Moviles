package com.example.eva_2_app_moviles

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.ImageButton
import android.widget.Toast
import android.view.View
import android.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<ImageButton>(R.id.btnForgot).setOnClickListener {
            val intent = Intent(this, RecuperaClave::class.java)
            startActivity(intent)
        }
        findViewById<ImageButton>(R.id.btnSingup).setOnClickListener {
            val intent = Intent(this, RegistraCuenta::class.java)
            startActivity(intent)
        }
        val boton = findViewById<ImageButton>(R.id.btnLogin)
        boton.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("Usuario Conectado Exitosamente")
                .show()
        }
        var btoothActivo = false
        val toggleBtn = findViewById<ImageButton>(R.id.btn_Bth)

        toggleBtn.setOnClickListener {
            btoothActivo = !btoothActivo

            if (btoothActivo) {
                toggleBtn.setImageResource(R.drawable.btoo_on)
                Toast.makeText(this, "Bluetooth activado", Toast.LENGTH_SHORT).show()
            } else {
                toggleBtn.setImageResource(R.drawable.btoo_off)
                Toast.makeText(this, "Bluetooth desactivado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}