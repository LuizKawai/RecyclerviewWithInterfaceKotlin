package com.e.recyclerviewkotlin


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.recyclerview_item.view.*  // the id we directly put here in kotlin from xml

// items we getting here is not just bound to constructor method ..we could use items and context throughout adapter
 class MyAdapter(val items : ArrayList<String>, val context: Context ,val btnlistener: BtnClickListener) : RecyclerView.Adapter<ViewHolder>() {


    companion object {   //static variable
        var mClickListener: BtnClickListener? = null
    }

    open interface BtnClickListener {
        fun onBtnClick(position: Int ,v :View)
    }



    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false))
    }

    // Binds each name in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        mClickListener = btnlistener   // adding our sent buttonListenr from activity to here n putting in onclcik listener

        holder?.tvName?.text = items.get(position)  //setText

        //******** you need to take object:View.OnClickListener to get view below dont have a view ..it is listener it will work ..but if you have to pass view take like imageView listener

 /*       holder.tvName.setOnClickListener {
            // you can do that here or also in acitivty with interface -- see with image m doing
          Toast.makeText(context, "Hey  ${items[position]} "+items.get(position),Toast.LENGTH_SHORT).show()

        }*/



        holder.ivImage.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if (mClickListener != null)
                    mClickListener?.onBtnClick(position ,v)
            }
        })


        holder.tvName.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if (mClickListener != null)
                    mClickListener?.onBtnClick(position ,v)
            }
        })





    }
}

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add name to
    val tvName = view.tv_myname
        val ivImage = view.ivImage
    }