package com.vickes.sirensound

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStop.setOnClickListener {
            mediaPlayer?.pause()
            mediaPlayer?.release()
            mediaPlayer = null

        }



       buttonGendarmerieOut.setOnTouchListener{ _, event ->
           if(mediaPlayer == null) {
               mediaPlayer = MediaPlayer.create(applicationContext, R.raw.gendarmerieout)
           }
           handleTouch(event)
           true
       }
       buttonGendarmerieIn.setOnTouchListener{ _, event ->
           if(mediaPlayer == null) {
               mediaPlayer = MediaPlayer.create(applicationContext, R.raw.gendarmeriein)
           }
           handleTouch(event)
            true
       }
        buttonAmbulance.setOnTouchListener{ _, event ->
            if(mediaPlayer == null){
                mediaPlayer = MediaPlayer.create(applicationContext, R.raw.ambulance)
            }

            handleTouch(event)
            true
        }
        buttonPolice.setOnTouchListener{ _, event ->
            if(mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(applicationContext, R.raw.police)
            }
            handleTouch(event)
            true
        }
        buttonPompier.setOnTouchListener{ _, event ->
            if(mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(applicationContext, R.raw.pompier)
            }
            handleTouch(event)
            true
        }
        buttonSamu.setOnTouchListener{ _, event ->
            if(mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(applicationContext, R.raw.samu)
            }
            handleTouch(event)
            true
        }

    }
    private fun handleTouch(event: MotionEvent){
        when (event.action){
            MotionEvent.ACTION_DOWN -> {
                mediaPlayer?.setLooping(true)
                mediaPlayer?.start()

            }
            MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> {
                if(switch1.isChecked){
                    mediaPlayer?.pause()
                    mediaPlayer?.release()
                    mediaPlayer = null
                }
            }
            else -> {
                println("other")
            }
        }
    }


}

