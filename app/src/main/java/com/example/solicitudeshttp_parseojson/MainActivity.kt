package com.example.solicitudeshttp_parseojson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.Toast
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlin.jvm.Throws

class MainActivity : AppCompatActivity(), CompletadoListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bValidarRed = findViewById<Button>(R.id.bValidarRed)
        val bSolicitudHTTP = findViewById<Button>(R.id.bSolicitudHTTP)


        bValidarRed.setOnClickListener{
            //Código para validar red
            if(Network.hayRed(this)){
                Toast.makeText(this,"Si hay Red", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"No hay una conexión a internet", Toast.LENGTH_LONG).show()
            }

        }

        bSolicitudHTTP.setOnClickListener{
            if(Network.hayRed(this)){
                //Log.d( "bSolicitudOnClick", descargarDatos("http://www.google.com"))
                DescargaURL(this).execute("http://ww.google.com")
            }else{
                Toast.makeText(this,"No hay una conexión a internet", Toast.LENGTH_LONG).show()
            }
        }


    }

    override fun descargaCompleta(resultado: String) {
        Log.d("descargaCompleta", resultado)
    }


}