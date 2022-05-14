package com.nbd.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database=Firebase.database
        val myRef=database.reference

        //ejemplos de clase
//        myRef.child("ejemplo").child("1").setValue(Card("1","rojo","corazones"))
//
//        myRef.child("ejemplo").child("2").setValue(Card("2","negro","corazones"))

        //mis ejemplos propios
//        myRef.child("students").child("1").setValue(Students("001","José Nicolás","Martínez","Rincón","4432451982"))
//        myRef.child("students").child("2").setValue(Students("002","Mariana","González","Bustamante","4431005549"))
//        myRef.child("students").child("3").setValue(Students("003","José Rubén","Montañez","Vazquez","4432569855"))

        myRef.child("students").child("1").get().addOnSuccessListener { response ->
            Log.d("studentsResponse",response.value.toString())
        }.addOnFailureListener{
            Log.e("studentsResponse","error getting data",it)
        }

    }
}