package com.udacity.shoestore.models

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailShoeBinding
import com.udacity.shoestore.databinding.ListItemBinding


class ItemShoeLayout : LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val binding: ListItemBinding =
        DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.list_item, this, false)


    fun loadShoe(shoe: Shoe) {

        binding.apply {
            shoeList= shoe
            addView(this.root)
            invalidateAll()
        }
    }
}