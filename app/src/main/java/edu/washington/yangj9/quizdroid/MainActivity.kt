package edu.washington.yangj9.quizdroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    val topics = arrayOf("Math", "Physics", "Marvel Super Heroes");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = ArrayAdapter<String>(
                this,
                R.layout.topic_list_layout,
                topics
        );
        listView.setOnItemClickListener({parent, v, p, id ->
            val intent = Intent(v.context, TopicOverviewActivity::class.java)
            intent.putExtra("topic",topics[p])
            intent.putExtra("num", p)
            startActivity(intent)
        });
    }
}

