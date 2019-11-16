# Carousel-Kotlin Image Slider
[![](https://jitpack.io/v/UmarAuna/Carousels-Kotlin.svg)](https://jitpack.io/#UmarAuna/Carousels-Kotlin)


<img src="https://agitated-allen-ab5fcb.netlify.com/images/carousel_small.gif" width="300px" align="middle"/>

This is an android image slider library. Just add the images you want to view. You can use automatic scrolling for the time you set. You can also add the title you want to the images. You can set corner radius images.

## Usage
- Add ImageSlider to your **layout**
```xml
 <com.carousel.auna.ImageSlider
        android:id="@+id/image_slider"
        android:layout_width="wrap_content"
        android:layout_height="250dp"
        app:auto_cycle="true"
        android:gravity="center"
        app:corner_radius="20"
        app:placeholder="@drawable/placeholder"
        app:error_image="@drawable/error"
        app:selected_dot="@drawable/default_selected_dot"
        app:unselected_dot="@drawable/default_unselected_dot"
        app:period="3000"
        app:delay="5"/>
```
- You can change placeholder image.
```xml
 app:placeholder="@drawable/placeholder"
```
- You can change error image.
```xml
 app:error_image="@drawable/error"
```
- You can change indicators.
```xml
app:selected_dot="@drawable/default_selected_dot"
app:unselected_dot="@drawable/default_unselected_dot"
```
- Add ImageSlider to your **Activity**
```kt
 val imageList = ArrayList<SlideModel>()
        // imageList.add(SlideModel("String Url" or R.drawable)
        // imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title
        // imageList.add(SlideModel("String Url" or R.drawable, "title", true) Also you can add centerCrop scaleType for this image
        imageList.add(SlideModel("https://static.food2fork.com/Jalapeno2BPopper2BGrilled2BCheese2BSandwich2B12B500fd186186.jpg","Buy One get two for free",true))
        imageList.add(SlideModel("https://static.food2fork.com/ParmesanRoastedPotatoes11985a.jpg","Eat at 5% price reduction on Fridays",true))
        imageList.add(SlideModel("https://static.food2fork.com/GuacamoleGrilledCheese6019.jpg","Come and enjoy with your family",true))

        image_slider.setImageList(imageList) //centerCrop for all images

        image_slider.startSliding(3000) // with new period
```
- You can add centerCrop scaleType for all images. 
```kt
imageSlider.setImageList(imageList, true) // centerCrop for all images
```
- You can use click listener. 
```kt
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
```
- You can add stop and start auto sliding again. 
```kt
imageSlider.startSliding(3000) // with new period
imageSlider.startSliding()
imageSlider.stopSliding()
```

## Setup
```xml
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
 implementation 'com.github.UmarAuna:Carousels-Kotlin:0.0.2'
 implementation 'com.squareup.picasso:picasso:2.71828'
}
```
## License
```
Copyright 2019 Umar Saidu Auna

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


