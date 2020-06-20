package com.example.finalprojectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        //Here we initializae our nav viewer placed at the bottom in the xml
        val bottomnavbar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        //we intialize the nav contorler that will then utilize the nav host fragment we placed int he xml
        val controller = findNavController(R.id.fragment2) //the nav host fragment

        //we finally link the bottom nav views with the nav controller
        //the nav controller abides by the navigation map resource file
        bottomnavbar.setupWithNavController(controller)



    }


    /**
     * Doesn't return anything, but is the definition for our Interface method for
     * completing transactions between the fragments
     * This method will utilize a bundle object that we will then dump the string into
     * we will then transfer that bundle within an intialized second fragment the Home section
     * from there we will use transaction.replace to switch the fragments and commit the change once
     * the content has been transferred
     * @param ItemNameString
     * return nothing
     */
    override fun PassStringsBetweenFragments(itemName: String) {

        //Basically, this is our fragment transactions function

        val bundle = Bundle()
        bundle.putString("ItemNameString",itemName)
        val transaction = this.supportFragmentManager.beginTransaction()
        val secondFragment = home()
        /**
         * this secondFragment variable is what is intialized
         */

        secondFragment.arguments = bundle
        //transaction.replace(R.id.content_id, secondFragment)
        /**
         * THIS TRANSACTION REPLACE IS WHAT IS MAKING THE UI BUGGING, IT IS NEEDED FOR THE ARGUMENTS
         * HOWEVER, IT IS RUINING THE FUNCTIONALITY OF THE BOTTOM NAV BAR AND THE NAV HOST FUNCTIONALITY
         * COMPLETELY
        */
        transaction.commit()
    }


}

/**
 * This is an interface class that has a property we access then implement in the main kt activity
 * We use this interface class basically to instantiate the method that we use in the fragment
 * transaction for The TODOList item's name
 */
interface Communicator {

    fun PassStringsBetweenFragments(itemName: String)

}
