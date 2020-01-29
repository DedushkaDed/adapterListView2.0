package glebkalinin.listview.first

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.row_main.view.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)
        listView.adapter = MyCustomAdapter(this) // this needs to be my custom adapter telling my list what to render
    }

    private class MyCustomAdapter(context: Context): BaseAdapter() {

//        private val mContext: Context

        private val names = arrayListOf<String>(
            "Donald Trump", "Steve Jobs", "Gleb Kalinin", "Barak Obama", "Sergey Lipin", "Timur Nuraev",
            "Donald Trump", "Steve Jobs", "Gleb Kalinin", "Barak Obama", "Sergey Lipin", "Timur Nuraev",
            "Donald Trump", "Steve Jobs", "Gleb Kalinin", "Barak Obama", "Sergey Lipin", "Timur Nuraev",
            "Donald Trump", "Steve Jobs", "Gleb Kalinin", "Barak Obama", "Sergey Lipin", "Timur Nuraev"
        )

//        init {
//            mContext = context
//        }

        // responsible how many rows in my list
        override fun getCount(): Int {
            return names.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        override fun getItem(position: Int): Any {
            return "Test STRING"
        }

        // responsible for rendering out each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

            val rowMain: View

            if (convertView == null){
                val layoutInflater = LayoutInflater.from(viewGroup!!.context)
                rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

                Log.d("getFindViewById","Calling expensive method findViewById")
                val position_TextView = rowMain.findViewById<TextView>(R.id.position_textview)
                val nameTextView = rowMain.findViewById<TextView>(R.id.name_textview)
                val viewHolder = ViewHolder(nameTextView,position_TextView)
                rowMain.tag = viewHolder

            } else {
                // У нас уже есть convertView, по этому просто дадим rowMain = быть нашим convertView.
                // Итог: Нам не нужно тратить доп.время на inflate - если мы уже имеем эти данные в convertView.
                rowMain = convertView
            }

            val viewHolder = rowMain.tag as ViewHolder

            viewHolder.nameTextView.text = names.get(position)
            viewHolder.positionTextView.text = "Row nubmer: $position"
            return rowMain
        }
    }

    private class ViewHolder (val nameTextView: TextView, val positionTextView: TextView)
}
