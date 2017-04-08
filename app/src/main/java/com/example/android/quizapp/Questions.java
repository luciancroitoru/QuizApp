package com.example.android.quizapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Questions extends AppCompatActivity {

    int finalScore = 0;
    RadioButton rb_3_1, rb_3_2, rb_3_3, rb_3_4;

    //hides keyboard when user enters the Questions activity
    public static void hideKeyboard(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        // RadioGroup no 3 contains nested views (RadioButtons which were clicked could not be deselected unless deselected
        // individually).
        // When any RadioButton from the 3rd RadioGroup is clicked, all other buttons from RadioGroup no 3 are deselected.
        rb_3_1 = (RadioButton) findViewById(R.id.answer_q_3_1);
        rb_3_2 = (RadioButton) findViewById(R.id.answer_q_3_2);
        rb_3_3 = (RadioButton) findViewById(R.id.answer_q_3_3);
        rb_3_4 = (RadioButton) findViewById(R.id.answer_q_3_4);

        rb_3_1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                rb_3_1.setChecked(true);
                rb_3_2.setChecked(false);
                rb_3_3.setChecked(false);
                rb_3_4.setChecked(false);
            }
        });

        rb_3_2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                rb_3_1.setChecked(false);
                rb_3_2.setChecked(true);
                rb_3_3.setChecked(false);
                rb_3_4.setChecked(false);
            }
        });

        rb_3_3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                rb_3_1.setChecked(false);
                rb_3_2.setChecked(false);
                rb_3_3.setChecked(true);
                rb_3_4.setChecked(false);
            }
        });

        rb_3_4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                rb_3_1.setChecked(false);
                rb_3_2.setChecked(false);
                rb_3_3.setChecked(false);
                rb_3_4.setChecked(true);
            }
        });//end of code for deselecting RadioButtons from RadioGroup no 3.
    }//onCreate()

    //displays the number of correct answers in a toast message when the Submit Answers button is pressed
    public void submitAnswers(View view) {
        calculateScore();
        // displays one toast message that reflects the result
        // if 7 answers are correct, also displays a prize
        if (finalScore == 7) {
            String toastText1 = "You answered all " + finalScore + " questions correctly!" +
                    "\nCongratulations! You receive the medal of honor!";
            Toast.makeText(this, toastText1, Toast.LENGTH_LONG).show();

            TextView quizPrizeText = (TextView) findViewById(R.id.quiz_prize_text_view);
            quizPrizeText.setVisibility(View.VISIBLE);
            ImageView quizPrizeImage = (ImageView) findViewById(R.id.quiz_prize_image_view);
            quizPrizeImage.setVisibility(View.VISIBLE);
        } else {
            String toastText2 = "The number of correct answers is: " + finalScore + " out of 7.";
            Toast.makeText(this, toastText2, Toast.LENGTH_LONG).show();

            RadioButton answerQ12RadioButton = (RadioButton) findViewById(R.id.answer_q_1_2);
            boolean hasAnswerQ12 = answerQ12RadioButton.isChecked();

            final TextView textViewTextChange = (TextView) findViewById(R.id.quiz_prize_text_view);
            String correctAnswers = "Not all your answers were correct :(";
            correctAnswers += "\nCorrect answers are:";
            correctAnswers += "\nQ1: '1'" + " Did you answer correctly? " + hasAnswerQ12;
            correctAnswers += "\nQ2: '12'";
            correctAnswers += "\nQ3: 'water'";
            correctAnswers += "\nQ4: 'purple' or 'violet'";
            correctAnswers += "\nQ5: 'cub'";
            correctAnswers += "\nQ6: first image (beluga) and last image (deer)";
            correctAnswers += "\nQ7: '365' and '366'";
            textViewTextChange.setText(
                    correctAnswers);
            textViewTextChange.setVisibility(View.VISIBLE);
        }
        finalScore = 0;
    }

    //retrieves the number of correct answers in the quizz
    public void calculateScore() {
        //Verifies answer for question 1 and adds 1 point to final score if the answer is correct
        RadioButton answerQ12RadioButton = (RadioButton) findViewById(R.id.answer_q_1_2);
        boolean hasAnswerQ12 = answerQ12RadioButton.isChecked();
        if (hasAnswerQ12) {
            finalScore++;
        }
        //Verifies answer for question 2 and adds 1 point to final score if the answer is correct
        RadioButton answerQ23RadioButton = (RadioButton) findViewById(R.id.answer_q_2_3);
        boolean hasAnswerQ23 = answerQ23RadioButton.isChecked();
        if (hasAnswerQ23) {
            finalScore++;
        }
        //Verifies answer for question 3 and adds 1 point to final score if the answer is correct
        RadioButton answerQ31RadioButton = (RadioButton) findViewById(R.id.answer_q_3_1);
        boolean hasAnswerQ31 = answerQ31RadioButton.isChecked();
        if (hasAnswerQ31) {
            finalScore++;
        }
        //Verifies answer for question 4 and adds 1 point to final score if the answer is correct
        EditText answerQ4Field = (EditText) findViewById(R.id.answer_q_4);
        String answerQ4 = answerQ4Field.getText().toString();
        if (answerQ4.toLowerCase().contains("purple") || answerQ4.toLowerCase().contains("violet")) {
            finalScore++;

            //if(answer4.toLowerCase().equals("-correct-answer-here-in-lowercase-")
        }
        //Verifies answer for question 5 and adds 1 point to final score if the answer is correct
        EditText answerQ5Field = (EditText) findViewById(R.id.answer_q_5);
        String answerQ5 = answerQ5Field.getText().toString();
        if (answerQ5.toLowerCase().contains("cub")) {
            finalScore++;
        }
        //Verifies answer for question 6 and adds 1 point to final score if the answer is correct
        CheckBox answerQ61CheckBox = (CheckBox) findViewById(R.id.answer_q_6_1);
        boolean hasAnswerQ61 = answerQ61CheckBox.isChecked();
        CheckBox answerQ62CheckBox = (CheckBox) findViewById(R.id.answer_q_6_2);
        boolean hasAnswerQ62 = answerQ62CheckBox.isChecked();
        CheckBox answerQ63CheckBox = (CheckBox) findViewById(R.id.answer_q_6_3);
        boolean hasAnswerQ63 = answerQ63CheckBox.isChecked();
        CheckBox answerQ64CheckBox = (CheckBox) findViewById(R.id.answer_q_6_4);
        boolean hasAnswerQ64 = answerQ64CheckBox.isChecked();
        if ((hasAnswerQ61) && (!hasAnswerQ62) && (!hasAnswerQ63) && (hasAnswerQ64)) {
            finalScore++;
        }

        //Verifies answer for question 7 and adds 1 point to final score if the answer is correct
        CheckBox answerQ71CheckBox = (CheckBox) findViewById(R.id.answer_q_7_1);
        boolean hasAnswerQ71 = answerQ71CheckBox.isChecked();
        CheckBox answerQ72CheckBox = (CheckBox) findViewById(R.id.answer_q_7_2);
        boolean hasAnswerQ72 = answerQ72CheckBox.isChecked();
        CheckBox answerQ73CheckBox = (CheckBox) findViewById(R.id.answer_q_7_3);
        boolean hasAnswerQ73 = answerQ73CheckBox.isChecked();
        CheckBox answerQ74CheckBox = (CheckBox) findViewById(R.id.answer_q_7_4);
        boolean hasAnswerQ74 = answerQ74CheckBox.isChecked();
        if ((!hasAnswerQ71) && (!hasAnswerQ72) && (hasAnswerQ73) && (hasAnswerQ74)) {
            finalScore++;
        }
    }

    public void resetScreen(View view) {

        // resets RadioButtons for 1st RadioGroup
        RadioGroup question1RadioGroup = (RadioGroup) findViewById(R.id.question_1);
        question1RadioGroup.clearCheck();
        // resets RadioButtons for 2nd RadioGroup
        RadioGroup question2RadioGroup = (RadioGroup) findViewById(R.id.question_2);
        question2RadioGroup.clearCheck();
        // resets all RadioButtons individually for 3rd RadioGroup because nested views were used
        RadioButton answerQ31RadioButton = (RadioButton) findViewById(R.id.answer_q_3_1);
        answerQ31RadioButton.setChecked(false);
        RadioButton answerQ32RadioButton = (RadioButton) findViewById(R.id.answer_q_3_2);
        answerQ32RadioButton.setChecked(false);
        RadioButton answerQ33RadioButton = (RadioButton) findViewById(R.id.answer_q_3_3);
        answerQ33RadioButton.setChecked(false);
        RadioButton answerQ34RadioButton = (RadioButton) findViewById(R.id.answer_q_3_4);
        answerQ34RadioButton.setChecked(false);
        // resets the EditText from question 4
        EditText question4EditText = (EditText) findViewById(R.id.answer_q_4);
        question4EditText.setText("");
        question4EditText.clearFocus();
        // resets the EditText from question 5
        EditText question5EditText = (EditText) findViewById(R.id.answer_q_5);
        question5EditText.setText("");
        question5EditText.clearFocus();
        // resets all CheckBoxes from question 6
        CheckBox answerq61 = (CheckBox) findViewById(R.id.answer_q_6_1);
        answerq61.setChecked(false);
        CheckBox answerq62 = (CheckBox) findViewById(R.id.answer_q_6_2);
        answerq62.setChecked(false);
        CheckBox answerq63 = (CheckBox) findViewById(R.id.answer_q_6_3);
        answerq63.setChecked(false);
        CheckBox answerq64 = (CheckBox) findViewById(R.id.answer_q_6_4);
        answerq64.setChecked(false);
        // resets all CheckBoxes from question 6
        CheckBox answerq71 = (CheckBox) findViewById(R.id.answer_q_7_1);
        answerq71.setChecked(false);
        CheckBox answerq72 = (CheckBox) findViewById(R.id.answer_q_7_2);
        answerq72.setChecked(false);
        CheckBox answerq73 = (CheckBox) findViewById(R.id.answer_q_7_3);
        answerq73.setChecked(false);
        CheckBox answerq74 = (CheckBox) findViewById(R.id.answer_q_7_4);
        answerq74.setChecked(false);
        //takes the user back to the top of the screen
        ScrollView questionsScrollView = (ScrollView) findViewById(R.id.scroll_view_questions);
        questionsScrollView.smoothScrollTo(0, 0);
        //hides quiz_prize_text_view
        TextView quizPrizeText = (TextView) findViewById(R.id.quiz_prize_text_view);
        quizPrizeText.setVisibility(View.GONE);
        //hides quiz_prize_text_image
        ImageView quizPrizeImage = (ImageView) findViewById(R.id.quiz_prize_image_view);
        quizPrizeImage.setVisibility(View.GONE);
    }

    // takes the user back to the main screen/ MainActivity and resets all scores
    public void resetQuiz(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // hides keyboard when user clicks outside of EditText
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText &&
                !v.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + v.getLeft() - scrcoords[0];
            float y = ev.getRawY() + v.getTop() - scrcoords[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom())
                hideKeyboard(this);
        }
        return super.dispatchTouchEvent(ev);
    }
}