package com.example.firebasesuffi

import android.app.ProgressDialog
import android.graphics.Picture
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.suffifirebase2.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class retrievedatafirebase : AppCompatActivity() {
    private lateinit var Images: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_retrievedatafirebase)
        Images = findViewById(R.id.imageView7)
        retrive_image()
val ref:StorageReference=FirebaseStorage.getInstance().getReference()
    .child("images")
        }
    fun retrive_image(){
        val storageReference:StorageReference = FirebaseStorage.getInstance().reference
        val image_refrance:StorageReference=storageReference.child("images")
        val progressDialog= ProgressDialog(this)
        progressDialog.setTitle("retrive image")
        progressDialog.setMessage("progressing...")
        progressDialog.show()


        image_refrance.downloadUrl.addOnSuccessListener {uri: Uri ->
            progressDialog.dismiss()
            Glide.with( this@retrievedatafirebase)
                .load(uri)
                .into(Images)

            Toast.makeText(this, "image retrived successfully", Toast.LENGTH_SHORT).show()
        }
            .addOnFailureListener {exception->
                progressDialog.dismiss()
                Toast.makeText(this, "image retrived failed", Toast.LENGTH_SHORT).show()


            }
    }
}



