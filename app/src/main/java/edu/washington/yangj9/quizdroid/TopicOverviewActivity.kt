package edu.washington.yangj9.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TopicOverviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val bundle : Bundle = intent.extras;
        val topic : String = bundle.getString("topic");
        val descs = arrayOf("numbers! equations! yay!", "things engineers need to know", "no spoilers for infinity war!")
        val num: Int = bundle.getInt("num");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_overview);

        findViewById<TextView>(R.id.topic).text=topic;
        findViewById<TextView>(R.id.desc).text=descs[num];
        findViewById<TextView>(R.id.numQ).text="3 questions";
        val begin = findViewById<Button>(R.id.begin);

        begin.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("num", num)
            intent.putExtra("correct", 0)
            startActivity(intent)
        }
    }
}
