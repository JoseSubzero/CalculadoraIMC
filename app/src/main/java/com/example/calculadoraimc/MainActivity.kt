package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.calculadoraimc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var height = 0
    private var weight = 0
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
        if (IMC < 16.00){
            Snackbar.make(binding.root, "Delgadez severa", Snackbar.LENGTH_SHORT).show()
        }

    }
}