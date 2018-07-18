package com.e.recyclerviewkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val names: ArrayList<String> = ArrayList()  //initilize empty arraylist (no new keyword)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addNames()

      // no need to define recyclerview in java use xml id
        rv_names.layoutManager = LinearLayoutManager(this)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
//        rv_names.layoutManager = GridLayoutManager(this, 2)

        // Access the RecyclerView Adapter and load the data into it
        rv_names.adapter = MyAdapter(names, this ,object : MyAdapter.BtnClickListener {
            override fun onBtnClick(position: Int , v : View) {

                if(v.id == R.id.ivImage) {

                    Toast.makeText(this@MainActivity, "Hey $position  Image Clicked  ", Toast.LENGTH_SHORT).show()
                }



                if(v.id == R.id.tv_myname) {

                    Toast.makeText(this@MainActivity, "Hey $position  Text Clicked  ", Toast.LENGTH_SHORT).show()
                }


            }
        })


    }

    fun addNames() {
        names.add("ajay")
        names.add("avi")
        names.add("malika")
        names.add("manisha")
        names.add("rahul")
        names.add("moti")
        names.add("champy")
        names.add("rohuit")
        names.add("james")
        names.add("Fruits")
        names.add("Days")
        names.add("whatever")
        names.add("Fantastic")
        names.add("Bottle")
        names.add("Computer")
        names.add("Pen")

    }





}