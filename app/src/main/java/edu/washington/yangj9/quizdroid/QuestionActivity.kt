package edu.washington.yangj9.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class QuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val bundle : Bundle = intent.extras;
        val num: Int = bundle.getInt("num");
        var count: Int = bundle.getInt("count");
        var correct: Int = bundle.getInt("correct");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        val questions = arrayOf(arrayOf("what's 1+1?", "what's 3 * 4?", "what is calculus"), arrayOf("what is physics", "who is newton?", "is the Earth flat?"), arrayOf("", "", ""));
        val options = arrayOf(arrayOf(arrayOf("2", "1", "11", "70"), arrayOf("7", "22", "12", "900"),arrayOf("terrible", "a study of calculators", "who knows?", "bane of my existence")),
                    arrayOf(arrayOf("study of force", "study of physese", "no clue?", "something high schooler learn"), arrayOf("guy who discovered newts", "a unit of measurement", "apple dude", "the android prof"),arrayOf("yes", "nah", "the earth doesn't exist", "can't tell")),
                    arrayOf(arrayOf("", "", "", ""), arrayOf("", "", "", ""),arrayOf("", "", "", "")));
        val correctA = arrayOf(arrayOf("2", "12", "bane of my existence"), arrayOf("study of force", "apple dude", "nah"), arrayOf("", "", ""));

        findViewById<TextView>(R.id.question).text = questions[num][count];
        val ops = arrayOf(R.id.o1, R.id.o2, R.id.o3, R.id.o4);
        val submit = findViewById<Button>(R.id.submit);
        var select = "";

        submit.setEnabled(false);
        for (i in 0..3) {
            val op = findViewById<RadioButton>(ops[i])
            op.text = options[num][count][i];
            op.setOnClickListener {
                submit.setEnabled(true);
                select = op.text.toString();
            }
        }
        submit.setOnClickListener {
            val intent = Intent(this, AnswerActivity::class.java)
            intent.putExtra("correctA", correctA[num][count])
            intent.putExtra("select", select)
            intent.putExtra("correct", correct)
            intent.putExtra("count", count)
            intent.putExtra("num", num)
            startActivity(intent)
        }
    }
}
