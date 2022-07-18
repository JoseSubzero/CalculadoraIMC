package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.seekBarHeight.setOnSeekBarChangeListener(object:
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar,
                                           progress: Int,
                                           fromUser: Boolean) {
                binding.tvNumbersHeight.text = seekBar.progress.toString().plus("/200")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        }
        )

        binding.seekBarWeight.setOnSeekBarChangeListener(object:
            SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar,
                                           progress: Int,
                                           fromUser: Boolean) {
            binding.tvNumberWeight.text = seekBar.progress.toString().plus("/150")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        }
        )


    }
}