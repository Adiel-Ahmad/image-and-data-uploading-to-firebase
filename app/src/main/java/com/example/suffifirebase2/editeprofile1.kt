package com.example.suffifirebase2

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.firebasesuffi.DetailModel
import com.example.firebasesuffi.ImageModel
import com.example.firebasesuffi.retrievedatafirebase
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.storage

class editeprofile1 : AppCompatActivity() {
    lateinit var gallery: ImageView
    lateinit var image: ImageView
    lateinit var storageRef: StorageReference
    lateinit var uploadbtn: Button
    lateinit var retrivebtn: Button
    lateinit var image_uri : Uri
    private lateinit var emailEd : EditText
    private lateinit var passwordEd : EditText
    private lateinit var nameEd : EditText
    private lateinit var nicknameEd : EditText
    private lateinit var dateEd : EditText
    lateinit var reference: DatabaseReference
    //    private lateinit var signupButton: Button
    private lateinit var auth: FirebaseAuth
    lateinit var storage: FirebaseStorage
    private val database: DatabaseReference =
        FirebaseDatabase.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_editeprofile1)
        gallery =findViewById(R.id.imageView3)
        image=findViewById(R.id.imageView5)
        uploadbtn = findViewById(R.id.uploadbutton)
        retrivebtn=findViewById(R.id.retrivebutton)
        emailEd = findViewById(R.id.email)
        passwordEd= findViewById(R.id.password)
        nameEd=findViewById(R.id.myname)
        nicknameEd=findViewById(R.id.mynickname)
        dateEd=findViewById(R.id.dateofbirth)
        auth = FirebaseAuth.getInstance()
        storage = FirebaseStorage.getInstance()
        uploadbtn()
        retrivebtn.setOnClickListener {
            val obj= Intent(this, retrievefirebase::class.java)
            startActivity(obj)
        }
        storageRef=Firebase.storage.getReference("MyImage").child("images/")
        imagePickFromGallery()

    }

    fun saveImageUrl(imageUrl: String) {
        val key = database.child("images").push().key

        key?.let {
            database.child("images").child(it).setValue(imageUrl)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        println("Image URL stored successfully.")
                    } else {
                        println("Failed to store image URL: ${task.exception?.message}")
                    }
                }
        }}


    private fun uploadbtn(){
        uploadbtn.setOnClickListener {
            if (image_uri!=null) {
                val progressDialog= ProgressDialog(this)
                progressDialog.setTitle("uploading image")
                progressDialog.setMessage("progressing...")
                progressDialog.show()
                storageRef.putFile(image_uri).addOnSuccessListener {
                    progressDialog.dismiss()

                    storageRef.downloadUrl.addOnSuccessListener { link ->
                        if (link != null) {
                            reference.child("My_Images")

                            val saveImage = ImageModel(link.toString());

                            reference.setValue(saveImage).addOnSuccessListener {
                                Toast.makeText(this@editeprofile1, "Image saved in database", Toast.LENGTH_SHORT).show()
                                Glide.with(this@editeprofile1).load(saveImage.mySavedImage).placeholder(R.drawable.man).into(image)
                            }.addOnFailureListener {error ->
                                Toast.makeText(this@editeprofile1, "Database error: "+error.localizedMessage, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "faild", Toast.LENGTH_SHORT).show()
                }
            }

























            val imageUrl:String=image.imageAlpha.toString().trim()
            val email : String = emailEd.text.toString().trim()
            val name : String = nameEd.text.toString().trim()
            val nickname : String = nicknameEd.text.toString().trim()
            val password : String = passwordEd.text.toString().trim()
            val date : String = dateEd.text.toString().trim()
            if (email.isEmpty() || name.isEmpty()|| nickname.isEmpty()|| password.isEmpty()|| date.isEmpty()) {
                Toast.makeText(this, "something is empty", Toast.LENGTH_SHORT).show()
            } else if(!email.contains("@gmail.com")) {
                Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show()
            } else {
                upload(email,name,nickname,password,date )
                saveRealtimeData(name, email, password,nickname,date)
            }


        }
    }

    private fun saveRealtimeData(name: String, email: String, password: String, nickname: String, date: String) {
        val myData = DetailModel(name, email, password,nickname,date)
        reference = database.ref.child("Details")
        reference.setValue(myData).addOnSuccessListener {
            Toast.makeText(this, "Data Uploaded", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Error : "+it.localizedMessage, Toast.LENGTH_SHORT).show()
        }


    }

    private fun upload(email: String, name: String, nickname: String, password: String, date: String) {
        auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
            auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {
                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }


        }



    }

    private fun imagePickFromGallery(){
        gallery.setOnClickListener {
            val gallery= Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            changeImage.launch(gallery)
        }
    }
    private val changeImage=
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {
                val data = it.data
                image_uri = data?.data!!
                image.setImageURI(image_uri)
            }}
    }
