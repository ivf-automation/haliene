package com.lilyhill.haliene

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lilyhill.haliene.ui.main.MainFragment
import android.widget.ImageView
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        // Handle the returned Uri
        val imageViewer = findViewById<ImageView>(R.id.image_viewer )
//        sets the image as the image view display. But make this function
//        better with bitmaps since imageuri is not the proper way to set images
        imageViewer.setImageURI(uri)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        val uploadImageButton = findViewById<Button>(R.id.upload_image)

        uploadImageButton.setOnClickListener {
            // Pass in the mime type you'd like to allow the user to select
            // as the input
            getContent.launch("image/*")
        }
    }

//    private fun openGalleryForImage(view: android.widget.ImageView) {
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*"
//        resultLauncher.launch(intent)
////        startActivityForResult(intent, REQUEST_CODE)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
//            imageView.setImageURI(data?.data) // handle chosen image
//        }
//    }

}