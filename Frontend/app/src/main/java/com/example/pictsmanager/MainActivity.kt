package com.example.pictsmanager

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.text.InputType
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pictsmanager.api.ApiClient
import com.example.pictsmanager.api.ApiService
import com.example.pictsmanager.models.Album
import com.example.pictsmanager.models.User
import com.example.pictsmanager.viewmodels.PostLoginUserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.ByteArrayOutputStream
import java.lang.Exception


private const val REQUEST_CODE = 42
private const val CAMERA_REQUEST_CODE = 1888
private const val BASE_URL: String = "http://10.0.2.2:4000/api/"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user_id  = intent.getIntExtra("user_id", 1)
        setContentView(R.layout.activity_main)


        setUpPermissionsCamera()
        var albums: MutableList<Album>? = null
        val loginResponse =
            ApiClient.apiService.getListAlbums(user_id)
        loginResponse.enqueue(object : Callback<MutableList<Album>> {
            override fun onResponse(call: Call<MutableList<Album>>, response: Response<MutableList<Album>>) {
                response.body()
                if (response.isSuccessful && response.body() != null ) {
                    albums = response.body()
                    recyclerView_album.adapter = CustomRecyclerViewAdapter(this@MainActivity, albums)

                    val linearLayoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    recyclerView_album.layoutManager = linearLayoutManager
                }
            }

            override fun onFailure(call: Call<MutableList<Album>>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "Wrong Username or Password !",
                    Toast.LENGTH_LONG
                ).show()
                t.message?.let { Log.e("ERROR:", it) }
            }
        })


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
}