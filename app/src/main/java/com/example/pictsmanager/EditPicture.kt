package com.example.pictsmanager

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.edit_picture.*


class EditPicture : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_picture)
        val codedPicture = intent.getByteArrayExtra("picture")
        if (codedPicture != null) {
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(codedPicture,0,codedPicture.size))
        }else{
            Toast.makeText(this,"Erreur : la photo n'a pas pu être transféré à l'application !", Toast.LENGTH_SHORT).show()
        }

        buttonAnnuler.setOnClickListener { this.finish() }
        buttonValider.setOnClickListener { Toast.makeText(this,"Validé !", Toast.LENGTH_SHORT).show() }
    }

    }
