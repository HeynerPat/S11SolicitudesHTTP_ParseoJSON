package com.example.solicitudeshttp_parseojson

import android.os.AsyncTask
import java.io.IOException
import java.io.InputStream
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import kotlin.jvm.Throws

class DescargaURL(var completadoListener: CompletadoListener?): AsyncTask<String, Void, String>() {
    override fun doInBackground(vararg p0: String): String? {
        try{
            return descargarDatos(p0[0])
        }catch (e:IOException){
            return null
        }

    }

    override fun onPostExecute(result: String) {
        try{
            completadoListener?.descargaCompleta(result)
        }catch (e:Exception){

        }
    }

    @Throws(IOException::class)
    private fun descargarDatos(url:String):String{

        var inputStream: InputStream?=null
        try{
            val url = URL(url)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.connect()

            inputStream = conn.inputStream
            return inputStream.bufferedReader().use {
                it.readText()
            }
        }finally {
            if(inputStream!=null){
                inputStream.close()
            }
        }
    }

}