package com.auna.carousels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.carousel.auna.interfaces.ItemClickListener
import com.carousel.auna.models.SlideModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG: String = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList = ArrayList<SlideModel>()
        // imageList.add(SlideModel("String Url" or R.drawable)
        // imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title
        // imageList.add(SlideModel("String Url" or R.drawable, "title", true) Also you can add centerCrop scaleType for this image
        imageList.add(SlideModel("https://static.food2fork.com/Jalapeno2BPopper2BGrilled2BCheese2BSandwich2B12B500fd186186.jpg","Buy One get two for free",true))
        imageList.add(SlideModel("https://static.food2fork.com/ParmesanRoastedPotatoes11985a.jpg","Eat at 5% price reduction on Fridays",true))
        imageList.add(SlideModel("https://static.food2fork.com/GuacamoleGrilledCheese6019.jpg","Come and enjoy with your family",true))

        image_slider.setImageList(imageList, true) //centerCrop for all images

        image_slider.startSliding(3000) // with new period


        //clicklistener
        image_slider.setItemClickListener(object: ItemClickListener {
            override fun onItemSelected(position: Int){
                if(position ==0){
                    Toast.makeText(applicationContext,"this is toast message 1", Toast.LENGTH_SHORT).show()
                }else if(position == 1){
                    Toast.makeText(applicationContext,"this is toast message 2", Toast.LENGTH_SHORT).show()
                }else if(position == 2){
                    Toast.makeText(applicationContext,"this is toast message 3", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}
