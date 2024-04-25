package com.example.madfinal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.madfinal.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener



class MainActivity : AppCompatActivity() {

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var database : DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val includeLayout1  = findViewById<View>(R.id.lay1)
        val loginButton = includeLayout1.findViewById<Button>(R.id.LoginButton)
        val signUp = includeLayout1.findViewById<TextView>(R.id.signUp)

        val includeLayout2 = findViewById<View>(R.id.lay2)
        val RegisterButton = includeLayout2.findViewById<Button>(R.id.RegisterButton)
        val signIn = includeLayout2.findViewById<TextView>(R.id.signIn)

        val includeLayout3 = findViewById<View>(R.id.lay3)
        val userUpdate = includeLayout3.findViewById<Button>(R.id.userUpdate)



        loginButton.setOnClickListener {
            val email = includeLayout1.findViewById<EditText>(R.id.editTextEmail)
            val password = includeLayout1.findViewById<EditText>(R.id.editTextPassword)
            val emailText = email.text.toString()
            val passwordText = password.text.toString()

            if(emailText.isNotEmpty() && passwordText.isNotEmpty()){
                auth.signInWithEmailAndPassword(emailText, passwordText).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Error Occur Try again", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else{
                Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
            }
        }

        RegisterButton.setOnClickListener {
            val email = includeLayout2.findViewById<EditText>(R.id.registerEmail)
            val password = includeLayout2.findViewById<EditText>(R.id.registerPassword)
            val confirmPassword = includeLayout2.findViewById<EditText>(R.id.registerConfirmPassword)
            val emailText = email.text.toString().trim()
            val passwordText = password.text.toString().trim()
            val confirmPasswordText = confirmPassword.text.toString().trim()


            if (emailText.isNotEmpty() && passwordText.isNotEmpty() && confirmPasswordText.isNotEmpty()){
                if (passwordText == confirmPasswordText){
                    auth.createUserWithEmailAndPassword(emailText,passwordText).addOnCompleteListener {
                        if(it.isSuccessful){
                            includeLayout1.visibility = View.GONE
                            includeLayout2.visibility = View.GONE
                            includeLayout3.visibility = View.VISIBLE
                        }else{
                            Toast.makeText(this, "Error Occur Try again", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Confirm password doesn't match", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Please fill all this form", Toast.LENGTH_SHORT).show()
                email.text.clear()
                password.text.clear()
                confirmPassword.text.clear()
            }
        }



        userUpdate.setOnClickListener {
            val email = includeLayout3.findViewById<EditText>(R.id.editTextEmail)
            val msg = includeLayout3.findViewById<EditText>(R.id.editTextMsg)
            val name = includeLayout3.findViewById<EditText>(R.id.editTextName)
            val phone = includeLayout3.findViewById<EditText>(R.id.editTextPhone)
            val emailText = email.text.toString()
            val msgText = msg.text.toString()
            val nameText = name.text.toString()
            val phoneText = phone.text.toString()

            firebaseDatabase = FirebaseDatabase.getInstance()
            database = firebaseDatabase.reference.child("users")


            if(emailText.isNotEmpty() && msgText.isNotEmpty() &&
                nameText.isNotEmpty() && phoneText.isNotEmpty()){

                database.orderByChild("email").equalTo(emailText).addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if(!dataSnapshot.exists()){
                            val emailid = database.push().key
                            val User = User(nameText, emailText,msgText,phoneText)
                            database.child(emailid!!).setValue(User)
                            Toast.makeText(this@MainActivity, "Register Successfully", Toast.LENGTH_SHORT).show()
                            includeLayout1.visibility = View.VISIBLE
                            includeLayout2.visibility = View.GONE
                            includeLayout3.visibility = View.GONE

                        }else{
                            Toast.makeText(this@MainActivity, "Register Faild", Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onCancelled(databaseError: DatabaseError) {
                        Toast.makeText(this@MainActivity, "Database Error ${databaseError}", Toast.LENGTH_SHORT).show()
                    }
                })
            }else{
                Toast.makeText(this, "Please fill all these forms", Toast.LENGTH_SHORT).show()
            }
        }
        signUp.setOnClickListener {
            includeLayout1.visibility = View.GONE
            includeLayout2.visibility = View.VISIBLE
            includeLayout3.visibility = View.GONE
        }
        signIn.setOnClickListener {
            includeLayout1.visibility = View.VISIBLE
            includeLayout2.visibility = View.GONE
            includeLayout3.visibility = View.GONE
        }
    }
}