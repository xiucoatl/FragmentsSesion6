package com.diplomado.fragmentssesion6

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.*
import kotlin.random.Random

class RandomNumeros(appContext:Context, workerParams:WorkerParameters):Worker (appContext, workerParams) {
    val numeroRandom = Random(30)

    fun generarSecuencia(){
        var i=0
        while(i<5){
            try{
                Thread.sleep(1000)
                val mRandoNumber = numeroRandom.nextInt(100)
                Log.i("Numero Random", "Numero aleatorio: $mRandoNumber")
                i++
            }catch (e:Exception){
                Log.i("Numero Random", "Error")
            }
        }
    }

    override fun doWork(): Result {
        //el codigo que se encuentre aqui es el que se va a ejecutar en el background
        generarSecuencia()
        return Result.success()
    }

    override fun onStopped() {
        super.onStopped()
    }
}