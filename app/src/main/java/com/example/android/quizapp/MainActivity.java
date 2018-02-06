package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startQuizButton = (Button) findViewById(R.id.start_quiz_button);
        startQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.quiz_layout);
            }
        });
    }

    public void checkAnswers(View view) {

        // The number of correct answers
        // This will be the final result shown to the user
        int quizScore = 0;

        // First Question
        RadioButton firstQuestionAnswer = (RadioButton) findViewById(R.id.radioButton3_question_1);
        if (firstQuestionAnswer.isChecked()) {
            quizScore += 1;
        } else {
            Log.e(TAG, "Wrong answer to question one!");
        }

        // Second Question
        EditText secondQuestionAnswer = (EditText) findViewById(R.id.edit_box_question_2);
        String secondQuestionAnswerString = secondQuestionAnswer.getText().toString().trim();
        if (secondQuestionAnswerString.equalsIgnoreCase(getString(R.string.answer_question_2))) {
            quizScore += 1;
        } else {
            Log.e(TAG, "Wrong answer to question two!");
        }

        // Third Question
        CheckBox checkBoxAnswer1 = (CheckBox) findViewById(R.id.check_box_1_question_3);
        CheckBox checkBoxAnswer2 = (CheckBox) findViewById(R.id.check_box_2_question_3);
        CheckBox checkBoxAnswer3 = (CheckBox) findViewById(R.id.check_box_3_question_3);
        CheckBox checkBoxAnswer4 = (CheckBox) findViewById(R.id.check_box_4_question_3);

        boolean isChecked1 = checkBoxAnswer1.isChecked();
        boolean isChecked2 = checkBoxAnswer2.isChecked();
        boolean isChecked3 = checkBoxAnswer3.isChecked();
        boolean isChecked4 = checkBoxAnswer4.isChecked();

        if (!isChecked1 // Not checked
                && isChecked2 // Checked
                && isChecked3 // Checked
                && !isChecked4) { // Not checked
            quizScore += 1;
        } else {
            Log.e(TAG, "Wrong answer to question three!");
        }

        // Fourth Question
        checkBoxAnswer1 = (CheckBox) findViewById(R.id.check_box_1_question_4);
        checkBoxAnswer2 = (CheckBox) findViewById(R.id.check_box_2_question_4);
        checkBoxAnswer3 = (CheckBox) findViewById(R.id.check_box_3_question_4);
        checkBoxAnswer4 = (CheckBox) findViewById(R.id.check_box_4_question_4);

        isChecked1 = checkBoxAnswer1.isChecked();
        isChecked2 = checkBoxAnswer2.isChecked();
        isChecked3 = checkBoxAnswer3.isChecked();
        isChecked4 = checkBoxAnswer4.isChecked();

        if (isChecked1 // Checked
                && isChecked2 // Checked
                && isChecked3 // Checked
                && isChecked4){ // Checked
            quizScore += 1;
        } else {
            Log.e(TAG, "Wrong answer to question three!");
        }

        // Fifth Question
        EditText fifthQuestionAnswer = (EditText) findViewById(R.id.edit_box_question_5);
        String fifthQuestionAnswerString = fifthQuestionAnswer.getText().toString().trim();
        if (fifthQuestionAnswerString.equalsIgnoreCase(getString(R.string.answer_question_5))) {
            quizScore += 1;
        } else {
            Log.e(TAG, "Wrong answer to question two!");
        }


        // Sixth Question
        RadioButton sixthQuestionAnswer = (RadioButton) findViewById(R.id.radioButton3_question_6);
        if (sixthQuestionAnswer.isChecked()) {
            quizScore += 1;
        } else {
            Log.e(TAG, "Wrong answer to question one!");
        }

        // Show score
        Toast.makeText(this, getString(R.string.score, quizScore), Toast.LENGTH_LONG).show();
    }
}