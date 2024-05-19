
/*
package com.fedi.apiaplicatiion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class Mainscreen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen2)
        val ImageProfil = findViewById<ImageView>(R.id.ImageProfil)

        val user = intent.getSerializableExtra("user") as? LoginResult

        val defaultImageUrl = "https://images.pexels.com/photos/16884194/pexels-photo-16884194/free-photo-of-maisons-femme-animal-maison.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"

        if (user?.picture != null && user.picture is String) {
            Picasso.get().load(user.picture).placeholder(R.drawable.logot1).into(ImageProfil)
        } else {
            Picasso.get().load(defaultImageUrl).placeholder(R.drawable.logo).into(ImageProfil)
        }
    }


}*/
package com.fedi.apiaplicatiion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageView
import android.widget.LinearLayout
class Mainscreen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen2)
        val chatLayout: ImageView = findViewById(R.id.permision)
        val Maps: ImageView = findViewById(R.id.maps)
        val planning: ImageView = findViewById(R.id.planning)
        val permis: ImageView = findViewById(R.id.listpermision)
        chatLayout.setOnClickListener {
            val intent = Intent(this@Mainscreen2, PermisionActivity::class.java)
            startActivity(intent)
        }
        Maps.setOnClickListener {
            val intent = Intent(this@Mainscreen2, Mainscreen4::class.java)
            startActivity(intent)
        }
        planning.setOnClickListener {
            val intent = Intent(this@Mainscreen2, Mainscreen5::class.java)
            startActivity(intent)
        }
        permis.setOnClickListener {
            val intent = Intent(this@Mainscreen2, Mainscreen6::class.java)
            startActivity(intent)
        }
    }
}
