package com.example.finalprojectapp

import android.os.Bundle
import android.os.Messenger
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_add_screen.view.*

/**
 * Fragment Subclass for the Add Screen Fragment
 * It is an extension of the fragment class and it holds the view object of the class and coincides
 * with the xml layout of one linear layout object, one textView Object, and one Edit Text Object
 * it also utilizes the interface Communicator instantiated in the Main Activity and its PassStringsBetweenFragments
 * method for sharing data in fragment transactions
 */
open class AddScreen : Fragment() {

    lateinit var  messenger: Communicator //intialize the communicator for the transaction
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add_screen, container, false)
        //we are storing the actual view for this project so we can access it and use the interface methods

        messenger = activity as Communicator //link the activity with the communicator type for the object


        view.AddItemSubmitButton.setOnClickListener { //once this button is clicked we can then
            val text = view.findViewById<EditText>(R.id.NameForAdd).text.toString()
           //Log.d("btnSetup", text )
            messenger.PassStringsBetweenFragments(text) //utilize the method  within the communicator class to pass the string form one fragment to another

        }

        return view

    }




}
