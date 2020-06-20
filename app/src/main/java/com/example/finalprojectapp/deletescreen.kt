package com.example.finalprojectapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_deletescreen.view.*

/**
 * Fragment Subclass for the Delete Screen Fragment
 * It is an extension of the fragment class and it holds the view object of the class and coincides
 * with the xml layout of one linear layout object, one textView Object, and one Edit Text Object
 * it also utilizes the interface Communicator instantiated in the Main Activity and its PassStringsBetweenFragments
 * method for sharing data in fragment transactions
 */
class deletescreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_deletescreen, container, false)


        /**
         * When the button is clicked it grabs any available text from the editText widget
         * @param nothing
         * returns nothing
         */
        view.DeleteButton.setOnClickListener() { //an onclick listener for the delete button
            val text = view.findViewById<EditText>(R.id.deletetext)
        }

        return view
    }

}
