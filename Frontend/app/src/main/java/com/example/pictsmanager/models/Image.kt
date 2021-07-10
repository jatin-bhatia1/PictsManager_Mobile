package com.example.pictsmanager.models

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import java.util.*

class Image(var Name: String, var Type: String, var Date: Date, var ImageString: ByteArray) {
    var Image: Bitmap?

    init {
        this.Image = BitmapFactory.decodeByteArray(this.ImageString, 0, this.ImageString.size)
    }

    fun getBitmap(): Bitmap? {
        if(this.Image == null){
            this.Image = BitmapFactory.decodeByteArray(this.ImageString, 0, this.ImageString.size)
        }
        return this.Image
    }
}