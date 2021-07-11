package com.example.pictsmanager

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pictsmanager.models.Album
import kotlinx.android.synthetic.main.edit_picture.*


class EditPicture : AppCompatActivity() {
    private val albums : ArrayList<Album> =getListData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.edit_picture)
        val codedPicture = intent.getByteArrayExtra("picture")
        val namePicture = intent.getStringExtra("namePicture")
        val id = intent.getIntExtra("id",0)
        val adapter = SpinAdapter(this,android.R.layout.simple_spinner_item,albums)
        selectAlbum.adapter = adapter
        selectAlbum.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?, view: View?,
                position: Int, id: Long
            ) {
                val album: Album = adapter.getItem(position)
                Toast.makeText(this@EditPicture,  ""+album.id+"", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(adapter: AdapterView<*>?) {}
        })
        if(namePicture != null){
            editTextPictureName.setText(namePicture)
        }
        if (codedPicture != null) {
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(codedPicture,0,codedPicture.size))
        }else{
            Toast.makeText(this,"Erreur : la photo n'a pas pu être transféré à l'application !", Toast.LENGTH_SHORT).show()
        }

        buttonAnnuler.setOnClickListener { this.finish() }
        buttonValider.setOnClickListener { Toast.makeText(this,"Validé !", Toast.LENGTH_SHORT).show() }
    }

    private fun getListData(): ArrayList<Album> {
        val list: ArrayList<Album> = ArrayList<Album>()
        return list
    }

    }
