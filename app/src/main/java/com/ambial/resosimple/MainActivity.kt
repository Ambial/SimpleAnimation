package com.ambial.resosimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import com.ambial.resosimple.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val resetButton = binding.resetButton
        val seekBar = binding.seekBar
        val tv = binding.textViewProgress
        val initialTextViewPosition = tv.translationY

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, isUserInput: Boolean) {
                tv.text = progress.toString()
                var translationDistance = (initialTextViewPosition + progress * resources.getDimension(R.dimen.text_anim_step) *-1)
                tv.animate().translationY(translationDistance)

                if (!isUserInput){
                    tv.animate().setDuration(500).rotationBy(360f).translationY(initialTextViewPosition)
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {

            }
            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        resetButton.setOnClickListener {
            seekBar.progress = 0
            tv.translationY = initialTextViewPosition }
    }
}