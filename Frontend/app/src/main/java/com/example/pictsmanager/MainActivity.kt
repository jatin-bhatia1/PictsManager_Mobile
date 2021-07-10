package com.example.pictsmanager

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.text.InputType
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream
import java.lang.Exception


private const val REQUEST_CODE = 42
private const val CAMERA_REQUEST_CODE = 1888

class MainActivity : AppCompatActivity() {
    private val albums : ArrayList<Album> =getListData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        setUpPermissionsCamera()

        val albums: List<Album> = getListData()
        recyclerView_album.setAdapter(CustomRecyclerViewAdapter(this, albums))

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView_album.layoutManager = linearLayoutManager

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
                    albums.add(Album(input.text.toString(), albums.size + 1))
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
            dispatchTakePictureIntent()
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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            CAMERA_REQUEST_CODE -> {
                if(grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "You need the camera permission to use this app", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setUpPermissionsCamera(){
        val permissionCamera = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)

        if(permissionCamera != PackageManager.PERMISSION_GRANTED){
            makeRequest()
        }
    }

    private fun makeRequest(){
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_CODE)
        } catch (e: Exception) {
            Toast.makeText(this,"Unable to open camera",Toast.LENGTH_SHORT).show()
        }
    }

    private fun getListData(): List<Album> {
        val list: MutableList<Album> = ArrayList<Album>()
        val album1 = Album("Vietnam", 1)
        val album2 = Album("Vietnam", 2)
        val album3 = Album("Vietnam", 3)
        val album4 = Album("Vietnam", 4)

        list.add(album1)
        list.add(album2)
        list.add(album3)
        list.add(album4)
        return list
    }
}