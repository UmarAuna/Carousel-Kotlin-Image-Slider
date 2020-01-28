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
        imageList.add(SlideModel("https://i0.wp.com/images-prod.healthline.com/hlcmsresource/images/AN_images/foods-that-lower-cholesterol-1296x728-feature.jpg?w=1155&h=1528","Buy One get two for free",true))
        imageList.add(SlideModel("https://cdn-image.foodandwine.com/sites/default/files/styles/4_3_horizontal_-_1200x900/public/201309-xl-filipino-grilled-chicken.jpg?itok=KvdiUetU","Eat at 5% price reduction on Fridays",true))
        imageList.add(SlideModel("https://s3.amazonaws.com/finecooking.s3.tauntonclud.com/app/uploads/2019/06/27132437/BBQ-Chicken-Adobo_wide.jpg","Come and enjoy with your family",true))

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
