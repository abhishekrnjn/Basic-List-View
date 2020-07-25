package com.example.simplelistview

import Data
import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var arrayList: ArrayList<Data> = ArrayList()

        arrayList.add(Data("Zero","zeroaudio"))
        arrayList.add(Data("One","oneaudio"))
        arrayList.add(Data("Two","twoaudio"))
        arrayList.add(Data("Three","threeaudio"))
        arrayList.add(Data("Four","fouraudio"))
        arrayList.add(Data("Five","fiveaudio"))
        arrayList.add(Data("Six","sixaudio"))
        arrayList.add(Data("Seven","sevenaudio"))
        arrayList.add(Data("Eight","eightaudio"))
        arrayList.add(Data("Nine","nineaudio"))
        arrayList.add(Data("Ten","tenaudio"))


        var adapter: NumberAdapter = NumberAdapter(this, arrayList)
        list_view.adapter = adapter


    }


}

class NumberAdapter: BaseAdapter {

    var arrayList: ArrayList<Data> = ArrayList()
    var context: Context? = null

    constructor(context: Context, arrayList: ArrayList<Data> ){
        this.arrayList=arrayList
        this.context=context
    }




    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        val inflater: LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val holder : ViewHolder
        if(convertView == null){
            view = inflater.inflate(R.layout.list_item,parent,false)
            holder =ViewHolder()

            holder.text = view.findViewById(R.id.text_view)
            holder.image = view.findViewById(R.id.image_view)
            view.tag = holder

        }
        else{
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val textValue = holder.text
        textValue?.text = arrayList[position].textNumber
        val imageValue = holder.image
        var mediaplayer: MediaPlayer?

        imageValue?.setOnClickListener{
            mediaplayer = MediaPlayer.create(
                context,context?.resources!!.getIdentifier(
                    arrayList[position].audioNumber, "raw",context?.packageName))
            mediaplayer?.start()
        }
        return view


    }


    private class ViewHolder{
        var text: TextView? = null
        var image: ImageView? = null
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }

}
