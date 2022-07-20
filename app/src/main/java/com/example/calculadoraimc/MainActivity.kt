package com.example.calculadoraimc

import android.content.Context
import android.graphics.Color
import android.graphics.Color.green
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.calculadoraimc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var height = 150
    private var weight = 75
    private var doubleheight = 2.25
    private var IMC = 33.33
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        calcularImc()

        binding.seekBarHeight.setOnSeekBarChangeListener(object:
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar,
                                           progress: Int,
                                           fromUser: Boolean) {
                binding.tvNumbersHeight.text = seekBar.progress.toString().plus("/200")
                height = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                calcularImc()
            }
        }
        )

        binding.seekBarWeight.setOnSeekBarChangeListener(object:
            SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar,
                                           progress: Int,
                                           fromUser: Boolean) {
            binding.tvNumberWeight.text = seekBar.progress.toString().plus("/150")
                weight = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                calcularImc()

            }
        }
        )
    }
    fun calcularImc(){
        doubleheight = height.times(height)/10000.0
        IMC = Math.round((weight/doubleheight)
            .times(100))
            .div(100.0)
        binding.tvResultado.text = IMC.toString()
        calcObesidad()
    }

    fun calcObesidad(){
        var msj = when(IMC){
            in 0.0..15.99 ->  Snackbar.make(binding.root, "DELGADEZ SEVERA", Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this,R.color.purple))
                .setAction("Ver tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout = inflater.inflate(R.layout.cardview, null)
                    AlertDialog.Builder(this!!).setView(customLayout)
                        .setPositiveButton("Aceptar"){dialog, id ->}.show()
                }.show()

            in 16.00..16.99 -> Snackbar.make(binding.root, "DELGADEZ MODERADA", Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this, R.color.deepblue))
                .setAction("Ver tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout = inflater.inflate(R.layout.cardview, null)
                    AlertDialog.Builder(this!!).setView(customLayout)
                        .setPositiveButton("Aceptar"){dialog, id ->}.show()
                }.show()

            in 17.00..18.49 -> Snackbar.make(binding.root, "DELGADEZ LEVE", Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this, R.color.lightblue))
                .setAction("Ver tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout = inflater.inflate(R.layout.cardview, null)
                    AlertDialog.Builder(this!!).setView(customLayout)
                        .setPositiveButton("Aceptar"){dialog, id ->}.show()
                }.show()

            in 18.50..24.99 -> Snackbar.make(binding.root, "PESO NORMAL", Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this, R.color.green))
                .setAction("Ver tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout = inflater.inflate(R.layout.cardview, null)
                    AlertDialog.Builder(this!!).setView(customLayout)
                        .setPositiveButton("Aceptar"){dialog, id ->}.show()
                }.show()

            in 25.00..29.99 -> Snackbar.make(binding.root, "PREOBESIDAD", Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this, R.color.yellow))
                .setAction("Ver tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout = inflater.inflate(R.layout.cardview, null)
                    AlertDialog.Builder(this!!).setView(customLayout)
                        .setPositiveButton("Aceptar"){dialog, id ->}.show()
                }.show()

            in 30.00..34.99 -> Snackbar.make(binding.root, "OBESIDAD LEVE", Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this, R.color.darkyellow))
                .setAction("Ver tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout = inflater.inflate(R.layout.cardview, null)
                    AlertDialog.Builder(this!!).setView(customLayout)
                        .setPositiveButton("Aceptar"){dialog, id ->}.show()
                }.show()

            in 35.00..40.00 -> Snackbar.make(binding.root, "OBESIDAD MEDIA", Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this, R.color.orange))
                .setAction("Ver tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout = inflater.inflate(R.layout.cardview, null)
                    AlertDialog.Builder(this!!).setView(customLayout)
                        .setPositiveButton("Aceptar"){dialog, id ->}.show()
                }.show()

            else -> Snackbar.make(binding.root, "OBESIDAD MORBIDA", Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this, R.color.red))
                .setAction("Ver tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout = inflater.inflate(R.layout.cardview, null)
                    AlertDialog.Builder(this!!).setView(customLayout)
                        .setPositiveButton("Aceptar"){dialog, id ->}.show()
                }.show()
        }
        //Snackbar.make(binding.root, msj, Snackbar.LENGTH_SHORT).setBackgroundTint(Color.BLUE).show()

    }
}