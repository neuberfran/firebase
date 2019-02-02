package com.example.neuber.firebase

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.neuber.firebase.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        //creating model object
        var user = User()

        //binding the data
        binding.user = user

        //reading data from firebase database
        FirebaseDatabase.getInstance().getReference("user")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        user.setName(dataSnapshot.child("name").getValue(String::class.java))
                        user.setAddress(dataSnapshot.child("address").getValue(String::class.java))
                        user.setEmail(dataSnapshot.child("email").getValue(String::class.java))
                        user.setImage(dataSnapshot.child("image").getValue(String::class.java))
                    }

                    override  fun onCancelled(databaseError: DatabaseError) {

                    }
                })


    }
}
