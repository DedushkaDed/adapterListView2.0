package glebkalinin.listview.first

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)
        listView.adapter = MyCustomAdapter(this) // this needs to be my custom adapter telling my list what to render
    }

    private class MyCustomAdapter(context: Context): BaseAdapter() {

        private val mContext: Context

        private val names = arrayListOf<String>(
            "Donald Trump", "Steve Jobs", "Gleb Kalinin", "Barak Obama", "Sergey Lipin", "Timur Nuraev"
        )

        init {
            mContext = context
        }

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
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val row_main = layoutInflater.inflate(R.layout.row_main, parent, false)

            val nameTextView = row_main.findViewById<TextView>(R.id.name_textview)
            nameTextView.text = names.get(position)

            val position_TextView = row_main.findViewById<TextView>(R.id.position_textview)
            position_TextView.text = "Row nubmer: $position"

            return row_main
        }
    }
}
