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
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import android.widget.Toast;
import android.util.Log
import com.lilyhill.haliene.RetrofitInstance
import com.lilyhill.haliene.UserInfo
import retrofit2.Retrofit
import android.provider.MediaStore
import android.content.ContentResolver

import android.graphics.Bitmap




class MainFragment : Fragment() {

    private lateinit var uploadImageButton: Button
    private lateinit var imageViewer: ImageView

    private val selectImageFromGalleryResult = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        sets the image as the image view display. But make this function
//        better with bitmaps since imageuri is not the proper way to set images
        uri?.let {
            this.imageViewer.setImageURI(uri)

        val path = uri.getPath()
        val file: File = File(uri.getPath())
        Log.d("FILE", path.toString())
        if (file.exists()){
            Log.d("FILE", "FIle found ")
        }
        else{
            Log.d("FILE", "FIle not found ")
        }
//        val file = LocalStorageProvider.getFile(activity, fileUri)
        val requestFile: RequestBody = RequestBody.create(
            MediaType.parse("image/*"),
            file
        )
        val multipartImage = MultipartBody.Part.createFormData("image", file.name, requestFile);
        val multipartUserID = MultipartBody.Part.createFormData(
            "userId","10"
        )
        val multipartUserName = MultipartBody.Part.createFormData(
            "userName","Alex",
        )
        val multipartUserEmail = MultipartBody.Part.createFormData(
            "userEmail", "alex@gmail.com"
        )
        val multipartUserAge = MultipartBody.Part.createFormData(
            "userAge","32"
        );
//        val fileObj: File = File(uri?.getPath());
//        val reqFile = RequestBody.create(MediaType.parse("multipart/form-data"), fileObj)
//        val filePart = MultipartBody.Part.createFormData("media", fileObj?.name, reqFile)


        var retrofitInstance: RetrofitInstance = RetrofitInstance()
//            val retrofit: Retrofit? = retrofitInstance.getService()
//        val userInfo = UserInfo( userId = null,
//            userName = "Alex",
//            userEmail = "alex@gmail.com",
//            userAge = "32",
//            userUid = "164E92FC-D37A-4946-81CB-29DE7EE4B124" )
//            val part = MultipartBody.Part.createFormData(
//                "image", "my_image", RequestBody.create(
//
//                    Mediatype.parse("image/*")
//                    )
//            )
        val retrofit: Retrofit? = retrofitInstance.putImageService(multipartUserID, multipartUserName, multipartUserEmail, multipartUserAge, multipartImage)

//        uploadImage(filePart)
//        presenter.callUploadImage(userToken, APPLICATION_JSON, APPLICATION_JSON, filePart)
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    }

    private fun selectImageFromGallery() = selectImageFromGalleryResult.launch("image/*")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val inflated_fragment = inflater.inflate(R.layout.main_fragment, container, false)
        val uploadImageButton = inflated_fragment.findViewById<Button>(R.id.upload_image)
        Log.d("TAG", uploadImageButton.toString())
        imageViewer = inflated_fragment.findViewById<ImageView>(R.id.image_viewer)
        uploadImageButton.setOnClickListener {
            selectImageFromGalleryResult.launch("image/*")

            Log.d("TEST", "Seems to work")

        }
        return inflated_fragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}