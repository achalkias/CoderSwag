package com.achalkias.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.achalkias.coderswag.R
import com.achalkias.coderswag.model.Category

/**
 * Created by tolis on 11/5/2017.
 */
class CategoryAdapter(private val context: Context, private val categories: List<Category>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder: ViewHolder

        if (convertView == null) {
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryText)
            categoryView.tag = holder
            println("First time initialize")
        } else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
            println("Recycle Views")
        }

        val category = categories[position]

        val resourseID = context.resources.getIdentifier(category.image, "drawable", context.packageName)

        holder.categoryImage?.setImageResource(resourseID)

        holder.categoryName?.text = category.title

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }

}