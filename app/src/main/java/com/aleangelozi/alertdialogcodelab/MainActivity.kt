package com.aleangelozi.alertdialogcodelab

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want to add a new contact")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You added a new contact",
                    Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "You didn't add a new contact",
                    Toast.LENGTH_SHORT).show()
            }.create()

        button1.setOnClickListener { addContactDialog.show() }

        val options = arrayOf("First item", "Second item", "Third item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(options, 0) { _, i ->
                Toast.makeText(this, "You clicked on ${options[i]}",
                    Toast.LENGTH_SHORT).show()

            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted one of the choices",
                    Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined all the choices",
                    Toast.LENGTH_SHORT).show()
            }.create()

        button2.setOnClickListener { singleChoiceDialog.show() }

        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { _, i, isCheked ->
                if (isCheked) {
                    Toast.makeText(this, "You checked ${options[i]}",
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You unchecked ${options[i]}",
                        Toast.LENGTH_SHORT).show()
                }


            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted at least one choice",
                    Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined all the choices",
                    Toast.LENGTH_SHORT).show()
            }.create()

        button3.setOnClickListener { multiChoiceDialog.show() }
    }



}