package com.example.pictsmanager

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.text.InputType
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream


private const val REQUEST_CODE = 42

class MainActivity : AppCompatActivity() {
    private val albums : ArrayList<Album> =getListData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        recyclerView_album.adapter = CustomRecyclerViewAdapter(this, albums)

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView_album.layoutManager = linearLayoutManager

        button_delete.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Supression")
            builder.setMessage("Etes vous sûr de supprimer ces dossiers ?")
            builder.setPositiveButton(
                "OK"
            ) { dialog, which ->
                for(album in albums){
                    if (album.isDelete){
                        albums.remove(album)
                    }
                }
            }
            builder.setNegativeButton(
                "Cancel"
            ) { dialog, which -> dialog.cancel() }
            builder.show()

        }

        buttonAddAlbum.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Title")
            val input = EditText(this)
            input.inputType = InputType.TYPE_CLASS_TEXT
            builder.setView(input)
            builder.setPositiveButton(
                "OK"
            ) { dialog, which ->
                if (!input.text.toString().equals("")) {
                    albums.add(Album(input.text.toString(), albums.size + 1, false))
                } else {
                    Toast.makeText(this, "Sorry, you can't create a new folder with an empty name", Toast.LENGTH_SHORT).show()
                }
            }
            builder.setNegativeButton(
                "Cancel"
            ) { dialog, which -> dialog.cancel() }
            builder.show()
        }


        btnTakePicture.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if(takePictureIntent.resolveActivity(this.packageManager) != null ) {
                startActivityForResult(takePictureIntent, REQUEST_CODE)
            }else{
                Toast.makeText(this,"Unable to open camera",Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val takenImage = data?.extras?.get("data") as Bitmap
            val bs = ByteArrayOutputStream()
            takenImage.compress(Bitmap.CompressFormat.PNG, 50, bs)
            val intent = Intent(this, EditPicture::class.java)
            intent.putExtra("picture", bs.toByteArray())
            startActivity(intent)
        }else{
            super.onActivityResult(requestCode,resultCode,data)
        }
    }

    private fun getListData(): ArrayList<Album> {
        val list: ArrayList<Album> = ArrayList<Album>()
        return list
    }
}