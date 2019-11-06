package com.carousel.auna.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.carousel.auna.R
import com.carousel.auna.interfaces.ItemClickListener
import com.carousel.auna.models.SlideModel
import com.carousel.auna.transformation.RoundedTransformation
import com.squareup.picasso.Picasso

class ViewPagerAdapter(context: Context?, imageList: List<SlideModel>, private var radius: Int, private var errorImage: Int, private var placeholder: Int, private var centerCrop: Boolean?) : PagerAdapter() {

    private var imageList: List<SlideModel>? = imageList
    private var layoutInflater: LayoutInflater? = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?

    private var itemClickListener: ItemClickListener? = null

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun getCount(): Int {
        return imageList!!.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): View {

        val itemView = layoutInflater!!.inflate(R.layout.pager_row, container, false)

        val imageView = itemView.findViewById<ImageView>(R.id.image_view)
        val linearLayout = itemView.findViewById<LinearLayout>(R.id.linear_layout)
        val textView = itemView.findViewById<TextView>(R.id.text_view)

        if (imageList!![position].title != null){
            textView.text = imageList!![position].title
        }else{
            linearLayout.visibility = View.INVISIBLE
        }

        if(imageList!![position].imageUrl == null){
            if(centerCrop!! || imageList!![position].centerCrop){
                Picasso.get()
                    .load(imageList!![position].imagePath!!) // Int
                    .fit()
                    .centerCrop()
                    .transform(RoundedTransformation(radius,0))
                    .placeholder(placeholder)
                    .error(errorImage)
                    .into(imageView)
            }else {
                Picasso.get()
                    .load(imageList!![position].imagePath!!) // Int
                    .fit()
                    .transform(RoundedTransformation(radius, 0))
                    .placeholder(placeholder)
                    .error(errorImage)
                    .into(imageView)
            }
        }else{
            if(centerCrop!! || imageList!![position].centerCrop) {
                Picasso.get()
                    .load(imageList!![position].imageUrl!!) // String
                    .fit()
                    .centerCrop()
                    .transform(RoundedTransformation(radius, 0))
                    .placeholder(placeholder)
                    .error(errorImage)
                    .into(imageView)
            }else {
                Picasso.get()
                    .load(imageList!![position].imageUrl!!) // String
                    .fit()
                    .transform(RoundedTransformation(radius, 0))
                    .placeholder(placeholder)
                    .error(errorImage)
                    .into(imageView)
            }
        }

        container.addView(itemView)

        imageView.setOnClickListener{itemClickListener?.onItemSelected(position)}

        return itemView
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }

}