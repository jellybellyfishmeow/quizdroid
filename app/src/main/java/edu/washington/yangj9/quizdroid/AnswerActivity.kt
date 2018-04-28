package edu.washington.yangj9.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val bundle : Bundle = intent.extras;
        val num: Int = bundle.getInt("num");
        var count: Int = bundle.getInt("count");
        var correct: Int = bundle.getInt("correct");
        val correctA : String = bundle.getString("correctA");
        val select : String = bundle.getString("select");

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        if (select == correctA) {
            correct++
        };
        count++;

        findViewById<TextView>(R.id.select).text = select;
        findViewById<TextView>(R.id.correctA).text = correctA;
        findViewById<TextView>(R.id.numCorrect).text = "$correct out of $count correct";
        val next = findViewById<Button>(R.id.next);

        if (count == 3) {
            next.text= "finish";
            next.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        } else {
            next.setOnClickListener {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("correct", correct)
                intent.putExtra("count", count)
                intent.putExtra("num", num)
                startActivity(intent)
            }
        }
    }
}
