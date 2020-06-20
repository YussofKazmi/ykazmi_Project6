package com.example.finalprojectapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_add_screen.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * Fragment Subclass for the Home Screen Fragment
 * It is an extension of the fragment class and it holds the view object of the class and coincides
 * with the xml layout of one recycler view object for lists, one textView Object
 * it also utilizes the interface Communicator instantiated in the Main Activity and its PassStringsBetweenFragments
 * method for sharing data in fragment transactions and then outputting that data specifically
 * in the recycler list widget with an arrayList of strings as the adapter for the widget
 */
class home : Fragment() {

    var text: String? = "" //a text string variable for manipulation
    val Items = ArrayList<String?>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //we are using this view object to store the actual view for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        /**
         * this variable is storing the final product of the fragment transaction
         * it will receive the text once the button in the add Item Ui is clicked
         */
        text = arguments?.getString("ItemStringName")

        //view.textbox.text = text
        Log.d("String", text.toString()) //logging to see string input is recieved

        return view
    }

}
