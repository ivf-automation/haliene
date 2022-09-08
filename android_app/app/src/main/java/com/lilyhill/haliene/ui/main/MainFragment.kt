package com.lilyhill.haliene.ui.main

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.lilyhill.haliene.R
import com.lilyhill.haliene.uploadImage
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File




class MainFragment : Fragment() {

    private lateinit var uploadImageButton: Button
    private lateinit var imageViewer: ImageView
    private lateinit var viewModel: MainViewModel

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        sets the image as the image view display. But make this function
//        better with bitmaps since imageuri is not the proper way to set images
        this.imageViewer.setImageURI(uri)
        val fileObj: File = File(uri?.getPath());
        val reqFile = RequestBody.create(MediaType.parse("multipart/form-data"), fileObj)
        val filePart = MultipartBody.Part.createFormData("media", fileObj?.name, reqFile)

//        uploadImage(filePart)
//        presenter.callUploadImage(userToken, APPLICATION_JSON, APPLICATION_JSON, filePart)
    }

    companion object {
        fun newInstance() = MainFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val uploadImageButton = requireView().findViewById<Button>(R.id.upload_image) as Button
        val imageViewer = requireView().findViewById<ImageView>(R.id.image_viewer) as ImageView

        uploadImageButton.setOnClickListener {
            // Pass in the mime type you'd like to allow the user to select
            // as the input
            getContent.launch("image/*")
        }
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}