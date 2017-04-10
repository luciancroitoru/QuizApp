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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import static com.example.android.quizapp.R.id.answer_q_4;
import static com.example.android.quizapp.R.id.answer_q_5;

public class Questions extends AppCompatActivity {

    static final String STATE_QUESTION_11 = "stateQuestion11";
    static final String STATE_QUESTION_12 = "stateQuestion12";
    static final String STATE_QUESTION_13 = "stateQuestion13";
    static final String STATE_QUESTION_14 = "stateQuestion14";
    static final String STATE_QUESTION_21 = "stateQuestion21";
    static final String STATE_QUESTION_22 = "stateQuestion22";
    static final String STATE_QUESTION_23 = "stateQuestion23";
    static final String STATE_QUESTION_24 = "stateQuestion24";
    static final String STATE_QUESTION_31 = "stateQuestion31";
    static final String STATE_QUESTION_32 = "stateQuestion32";
    static final String STATE_QUESTION_33 = "stateQuestion33";
    static final String STATE_QUESTION_34 = "stateQuestion34";
    static final String STATE_QUESTION_4 = "stateQuestion4";
    static final String STATE_QUESTION_5 = "stateQuestion5";
    static final String STATE_QUESTION_61 = "stateQuestion61";
    static final String STATE_QUESTION_62 = "stateQuestion62";
    static final String STATE_QUESTION_63 = "stateQuestion63";
    static final String STATE_QUESTION_64 = "stateQuestion64";
    static final String STATE_QUESTION_71 = "stateQuestion71";
    static final String STATE_QUESTION_72 = "stateQuestion72";
    static final String STATE_QUESTION_73 = "stateQuestion73";
    static final String STATE_QUESTION_74 = "stateQuestion74";

    private static final String STATE_FINAL_SCORE = "valueOfFinalScore";
    Boolean IsCheckAnswerQuestion11;
    Boolean IsCheckAnswerQuestion12;
    Boolean IsCheckAnswerQuestion13;
    Boolean IsCheckAnswerQuestion14;
    Boolean IsCheckAnswerQuestion21;
    Boolean IsCheckAnswerQuestion22;
    Boolean IsCheckAnswerQuestion23;
    Boolean IsCheckAnswerQuestion24;
    Boolean IsCheckAnswerQuestion31;
    Boolean IsCheckAnswerQuestion32;
    Boolean IsCheckAnswerQuestion33;
    Boolean IsCheckAnswerQuestion34;
    String answerQuestion4;
    String answerQuestion5;
    Boolean IsCheckAnswerQuestion61;
    Boolean IsCheckAnswerQuestion62;
    Boolean IsCheckAnswerQuestion63;
    Boolean IsCheckAnswerQuestion64;
    Boolean IsCheckAnswerQuestion71;
    Boolean IsCheckAnswerQuestion72;
    Boolean IsCheckAnswerQuestion73;
    Boolean IsCheckAnswerQuestion74;

    // calculates the score of the quiz
    int finalScore = 0;
    // radio buttons for question 3 are defined to be manipulated in onCreate method
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
    }//end onCreate()

    // Override the onSaveInstanceState method, this will write the variables values to the Bundle
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        getUserAnswers();
        savedInstanceState.putInt(STATE_FINAL_SCORE, finalScore);
        savedInstanceState.putBoolean(STATE_QUESTION_11, IsCheckAnswerQuestion11);
        savedInstanceState.putBoolean(STATE_QUESTION_12, IsCheckAnswerQuestion12);
        savedInstanceState.putBoolean(STATE_QUESTION_13, IsCheckAnswerQuestion13);
        savedInstanceState.putBoolean(STATE_QUESTION_14, IsCheckAnswerQuestion14);
        savedInstanceState.putBoolean(STATE_QUESTION_21, IsCheckAnswerQuestion21);
        savedInstanceState.putBoolean(STATE_QUESTION_22, IsCheckAnswerQuestion22);
        savedInstanceState.putBoolean(STATE_QUESTION_23, IsCheckAnswerQuestion23);
        savedInstanceState.putBoolean(STATE_QUESTION_24, IsCheckAnswerQuestion24);
        savedInstanceState.putBoolean(STATE_QUESTION_31, IsCheckAnswerQuestion31);
        savedInstanceState.putBoolean(STATE_QUESTION_32, IsCheckAnswerQuestion32);
        savedInstanceState.putBoolean(STATE_QUESTION_33, IsCheckAnswerQuestion33);
        savedInstanceState.putBoolean(STATE_QUESTION_34, IsCheckAnswerQuestion34);
        savedInstanceState.putString(STATE_QUESTION_4, answerQuestion4);
        savedInstanceState.putString(STATE_QUESTION_5, answerQuestion5);
        savedInstanceState.putBoolean(STATE_QUESTION_61, IsCheckAnswerQuestion61);
        savedInstanceState.putBoolean(STATE_QUESTION_62, IsCheckAnswerQuestion62);
        savedInstanceState.putBoolean(STATE_QUESTION_63, IsCheckAnswerQuestion63);
        savedInstanceState.putBoolean(STATE_QUESTION_64, IsCheckAnswerQuestion64);
        savedInstanceState.putBoolean(STATE_QUESTION_71, IsCheckAnswerQuestion71);
        savedInstanceState.putBoolean(STATE_QUESTION_72, IsCheckAnswerQuestion72);
        savedInstanceState.putBoolean(STATE_QUESTION_73, IsCheckAnswerQuestion73);
        savedInstanceState.putBoolean(STATE_QUESTION_74, IsCheckAnswerQuestion74);
    }

    // retrieves all answers of the user, used in onSaveInstanceState method
    public void getUserAnswers() {
        RadioButton answerQ11RadioButton = (RadioButton) findViewById(R.id.answer_q_1_1);
        IsCheckAnswerQuestion11 = answerQ11RadioButton.isChecked();
        RadioButton answerQ12RadioButton = (RadioButton) findViewById(R.id.answer_q_1_2);
        IsCheckAnswerQuestion12 = answerQ12RadioButton.isChecked();
        RadioButton answerQ13RadioButton = (RadioButton) findViewById(R.id.answer_q_1_3);
        IsCheckAnswerQuestion13 = answerQ13RadioButton.isChecked();
        RadioButton answerQ14RadioButton = (RadioButton) findViewById(R.id.answer_q_1_4);
        IsCheckAnswerQuestion14 = answerQ14RadioButton.isChecked();
        RadioButton answerQ21RadioButton = (RadioButton) findViewById(R.id.answer_q_2_1);
        IsCheckAnswerQuestion21 = answerQ21RadioButton.isChecked();
        RadioButton answerQ22RadioButton = (RadioButton) findViewById(R.id.answer_q_2_2);
        IsCheckAnswerQuestion22 = answerQ22RadioButton.isChecked();
        RadioButton answerQ23RadioButton = (RadioButton) findViewById(R.id.answer_q_2_3);
        IsCheckAnswerQuestion23 = answerQ23RadioButton.isChecked();
        RadioButton answerQ24RadioButton = (RadioButton) findViewById(R.id.answer_q_2_4);
        IsCheckAnswerQuestion24 = answerQ24RadioButton.isChecked();
        RadioButton answerQ31RadioButton = (RadioButton) findViewById(R.id.answer_q_3_1);
        IsCheckAnswerQuestion31 = answerQ31RadioButton.isChecked();
        RadioButton answerQ32RadioButton = (RadioButton) findViewById(R.id.answer_q_3_2);
        IsCheckAnswerQuestion32 = answerQ32RadioButton.isChecked();
        RadioButton answerQ33RadioButton = (RadioButton) findViewById(R.id.answer_q_3_3);
        IsCheckAnswerQuestion33 = answerQ33RadioButton.isChecked();
        RadioButton answerQ34RadioButton = (RadioButton) findViewById(R.id.answer_q_3_4);
        IsCheckAnswerQuestion34 = answerQ34RadioButton.isChecked();

        EditText answerQ4Field = (EditText) findViewById(answer_q_4);
        answerQuestion4 = answerQ4Field.getText().toString();
        EditText answerQ5Field = (EditText) findViewById(answer_q_5);
        answerQuestion5 = answerQ5Field.getText().toString();

        CheckBox answerQ61CheckBox = (CheckBox) findViewById(R.id.answer_q_6_1);
        IsCheckAnswerQuestion61 = answerQ61CheckBox.isChecked();
        CheckBox answerQ62CheckBox = (CheckBox) findViewById(R.id.answer_q_6_2);
        IsCheckAnswerQuestion62 = answerQ62CheckBox.isChecked();
        CheckBox answerQ63CheckBox = (CheckBox) findViewById(R.id.answer_q_6_3);
        IsCheckAnswerQuestion63 = answerQ63CheckBox.isChecked();
        CheckBox answerQ64CheckBox = (CheckBox) findViewById(R.id.answer_q_6_4);
        IsCheckAnswerQuestion64 = answerQ64CheckBox.isChecked();

        CheckBox answerQ71CheckBox = (CheckBox) findViewById(R.id.answer_q_7_1);
        IsCheckAnswerQuestion71 = answerQ71CheckBox.isChecked();
        CheckBox answerQ72CheckBox = (CheckBox) findViewById(R.id.answer_q_7_2);
        IsCheckAnswerQuestion72 = answerQ72CheckBox.isChecked();
        CheckBox answerQ73CheckBox = (CheckBox) findViewById(R.id.answer_q_7_3);
        IsCheckAnswerQuestion73 = answerQ73CheckBox.isChecked();
        CheckBox answerQ74CheckBox = (CheckBox) findViewById(R.id.answer_q_7_4);
        IsCheckAnswerQuestion74 = answerQ74CheckBox.isChecked();
    }

    // restores user answers
    public void onRestoreInstanceState(Bundle saveInstanceState) {
        finalScore = saveInstanceState.getInt(STATE_FINAL_SCORE);
        IsCheckAnswerQuestion11 = saveInstanceState.getBoolean(STATE_QUESTION_11);
        IsCheckAnswerQuestion12 = saveInstanceState.getBoolean(STATE_QUESTION_12);
        IsCheckAnswerQuestion13 = saveInstanceState.getBoolean(STATE_QUESTION_13);
        IsCheckAnswerQuestion14 = saveInstanceState.getBoolean(STATE_QUESTION_14);
        IsCheckAnswerQuestion21 = saveInstanceState.getBoolean(STATE_QUESTION_21);
        IsCheckAnswerQuestion22 = saveInstanceState.getBoolean(STATE_QUESTION_22);
        IsCheckAnswerQuestion23 = saveInstanceState.getBoolean(STATE_QUESTION_23);
        IsCheckAnswerQuestion24 = saveInstanceState.getBoolean(STATE_QUESTION_24);
        IsCheckAnswerQuestion31 = saveInstanceState.getBoolean(STATE_QUESTION_31);
        IsCheckAnswerQuestion32 = saveInstanceState.getBoolean(STATE_QUESTION_32);
        IsCheckAnswerQuestion33 = saveInstanceState.getBoolean(STATE_QUESTION_33);
        IsCheckAnswerQuestion34 = saveInstanceState.getBoolean(STATE_QUESTION_34);
        answerQuestion4 = saveInstanceState.getString(STATE_QUESTION_4);
        answerQuestion5 = saveInstanceState.getString(STATE_QUESTION_5);
        IsCheckAnswerQuestion61 = saveInstanceState.getBoolean(STATE_QUESTION_61);
        IsCheckAnswerQuestion62 = saveInstanceState.getBoolean(STATE_QUESTION_62);
        IsCheckAnswerQuestion63 = saveInstanceState.getBoolean(STATE_QUESTION_63);
        IsCheckAnswerQuestion64 = saveInstanceState.getBoolean(STATE_QUESTION_64);
        IsCheckAnswerQuestion71 = saveInstanceState.getBoolean(STATE_QUESTION_71);
        IsCheckAnswerQuestion72 = saveInstanceState.getBoolean(STATE_QUESTION_72);
        IsCheckAnswerQuestion73 = saveInstanceState.getBoolean(STATE_QUESTION_73);
        IsCheckAnswerQuestion74 = saveInstanceState.getBoolean(STATE_QUESTION_74);
        setUserAnswer();
    }

    //recovery of user answers, used in onRestoreInstanceState
    public void setUserAnswer() {

        RadioButton answerRB11 = (RadioButton) findViewById(R.id.answer_q_1_1);
        answerRB11.setChecked(IsCheckAnswerQuestion11);

        RadioButton answerRB12 = (RadioButton) findViewById(R.id.answer_q_1_2);
        answerRB12.setChecked(IsCheckAnswerQuestion12);

        RadioButton answerRB13 = (RadioButton) findViewById(R.id.answer_q_1_3);
        answerRB13.setChecked(IsCheckAnswerQuestion13);

        RadioButton answerRB14 = (RadioButton) findViewById(R.id.answer_q_1_4);
        answerRB14.setChecked(IsCheckAnswerQuestion14);

        RadioButton answerRB21 = (RadioButton) findViewById(R.id.answer_q_2_1);
        answerRB21.setChecked(IsCheckAnswerQuestion21);

        RadioButton answerRB22 = (RadioButton) findViewById(R.id.answer_q_2_2);
        answerRB22.setChecked(IsCheckAnswerQuestion22);

        RadioButton answerRB23 = (RadioButton) findViewById(R.id.answer_q_2_3);
        answerRB23.setChecked(IsCheckAnswerQuestion23);

        RadioButton answerRB24 = (RadioButton) findViewById(R.id.answer_q_2_4);
        answerRB24.setChecked(IsCheckAnswerQuestion24);

        RadioButton answerRB31 = (RadioButton) findViewById(R.id.answer_q_3_1);
        answerRB31.setChecked(IsCheckAnswerQuestion31);

        RadioButton answerRB32 = (RadioButton) findViewById(R.id.answer_q_3_2);
        answerRB32.setChecked(IsCheckAnswerQuestion32);

        RadioButton answerRB33 = (RadioButton) findViewById(R.id.answer_q_3_3);
        answerRB33.setChecked(IsCheckAnswerQuestion33);

        RadioButton answerRB34 = (RadioButton) findViewById(R.id.answer_q_3_4);
        answerRB34.setChecked(IsCheckAnswerQuestion34);

        EditText answerET4 = (EditText) findViewById(answer_q_4);
        answerET4.setText(answerQuestion4);

        EditText answerET3 = (EditText) findViewById(answer_q_5);
        answerET3.setText(answerQuestion5);

        CheckBox answerCB61 = (CheckBox) findViewById(R.id.answer_q_6_1);
        answerCB61.setChecked(IsCheckAnswerQuestion61);

        CheckBox answerCB62 = (CheckBox) findViewById(R.id.answer_q_6_2);
        answerCB62.setChecked(IsCheckAnswerQuestion62);

        CheckBox answerCB63 = (CheckBox) findViewById(R.id.answer_q_6_3);
        answerCB63.setChecked(IsCheckAnswerQuestion63);

        CheckBox answerCB64 = (CheckBox) findViewById(R.id.answer_q_6_4);
        answerCB64.setChecked(IsCheckAnswerQuestion64);

        CheckBox answerCB71 = (CheckBox) findViewById(R.id.answer_q_7_1);
        answerCB71.setChecked(IsCheckAnswerQuestion71);

        CheckBox answerCB72 = (CheckBox) findViewById(R.id.answer_q_7_2);
        answerCB72.setChecked(IsCheckAnswerQuestion72);

        CheckBox answerCB73 = (CheckBox) findViewById(R.id.answer_q_7_3);
        answerCB73.setChecked(IsCheckAnswerQuestion73);

        CheckBox answerCB74 = (CheckBox) findViewById(R.id.answer_q_7_4);
        answerCB74.setChecked(IsCheckAnswerQuestion74);
    }

    //Displays the number of correct answers in a toast message when the Submit Answers button is pressed
    // Then shows a prize message or correct answers + answers status, depending on result
    public void submitAnswers(View view) {
        calculateScore();
        // displays one toast message that shows the result
        if (finalScore == 7) {
            String toastText1 = "You answered all " + finalScore + " questions correctly!" +
                    "\nCongratulations! You receive the medal of honor!";
            Toast.makeText(this, toastText1, Toast.LENGTH_LONG).show();

            // if 7 answers are correct, it shows the result and also displays a prize
            TextView quizPrizeText = (TextView) findViewById(R.id.quiz_prize_text_view);
            quizPrizeText.setVisibility(View.VISIBLE);
            ImageView quizPrizeImage = (ImageView) findViewById(R.id.quiz_prize_image_view);
            quizPrizeImage.setVisibility(View.VISIBLE);
        } else {
            String toastText2 = "The number of correct answers is: " + finalScore + " out of 7.";
            Toast.makeText(this, toastText2, Toast.LENGTH_LONG).show();

            // if less than 7 answers are correct, displays all correct answers and whether user answered them correctly or not
            RadioButton answerQ12RadioButton = (RadioButton) findViewById(R.id.answer_q_1_2);
            boolean hasAnswerQ12 = answerQ12RadioButton.isChecked();
            RadioButton answerQ23RadioButton = (RadioButton) findViewById(R.id.answer_q_2_3);
            boolean hasAnswerQ23 = answerQ23RadioButton.isChecked();
            RadioButton answerQ31RadioButton = (RadioButton) findViewById(R.id.answer_q_3_1);
            boolean hasAnswerQ31 = answerQ31RadioButton.isChecked();
            EditText answerQ4Field = (EditText) findViewById(answer_q_4);
            String answerQ4 = answerQ4Field.getText().toString();
            String answerTrue;
            if (answerQ4.toLowerCase().contains("purple") || answerQ4.toLowerCase().contains("violet")) {
                answerTrue = " Yes";
            } else {
                answerTrue = " No";
            }
            EditText answerQ5Field = (EditText) findViewById(answer_q_5);
            String answerQ5 = answerQ5Field.getText().toString();
            String answerTrue1;
            if (answerQ5.toLowerCase().contains("cub")) {
                answerTrue1 = " Yes";
            } else {
                answerTrue1 = " No";
            }

            CheckBox answerQ61CheckBox = (CheckBox) findViewById(R.id.answer_q_6_1);
            boolean hasAnswerQ61 = answerQ61CheckBox.isChecked();
            CheckBox answerQ62CheckBox = (CheckBox) findViewById(R.id.answer_q_6_2);
            boolean hasAnswerQ62 = answerQ62CheckBox.isChecked();
            CheckBox answerQ63CheckBox = (CheckBox) findViewById(R.id.answer_q_6_3);
            boolean hasAnswerQ63 = answerQ63CheckBox.isChecked();
            CheckBox answerQ64CheckBox = (CheckBox) findViewById(R.id.answer_q_6_4);
            boolean hasAnswerQ64 = answerQ64CheckBox.isChecked();
            String answerTrue2;
            if ((hasAnswerQ61) && (!hasAnswerQ62) && (!hasAnswerQ63) && (hasAnswerQ64)) {
                answerTrue2 = " Yes";
            } else {
                answerTrue2 = " No";
            }

            CheckBox answerQ71CheckBox = (CheckBox) findViewById(R.id.answer_q_7_1);
            boolean hasAnswerQ71 = answerQ71CheckBox.isChecked();
            CheckBox answerQ72CheckBox = (CheckBox) findViewById(R.id.answer_q_7_2);
            boolean hasAnswerQ72 = answerQ72CheckBox.isChecked();
            CheckBox answerQ73CheckBox = (CheckBox) findViewById(R.id.answer_q_7_3);
            boolean hasAnswerQ73 = answerQ73CheckBox.isChecked();
            CheckBox answerQ74CheckBox = (CheckBox) findViewById(R.id.answer_q_7_4);
            boolean hasAnswerQ74 = answerQ74CheckBox.isChecked();
            String answerTrue3;
            if ((!hasAnswerQ71) && (!hasAnswerQ72) && (hasAnswerQ73) && (hasAnswerQ74)) {
                answerTrue3 = " Yes";
            } else {
                answerTrue3 = " No";
            }

            String question = ". Did you answer correctly? ";

            final TextView textViewTextChange = (TextView) findViewById(R.id.quiz_prize_text_view);
            String correctAnswers = getString(R.string.correct_answers_intro);
            correctAnswers += "\n" + getString(R.string.correct_answer_Q1) + question + hasAnswerQ12;
            correctAnswers += "\n" + getString(R.string.correct_answer_Q2) + question + hasAnswerQ23;
            correctAnswers += "\n" + getString(R.string.correct_answer_Q3) + question + hasAnswerQ31;
            correctAnswers += "\n" + getString(R.string.correct_answer_Q4) + question + answerTrue;
            correctAnswers += "\n" + getString(R.string.correct_answer_Q5) + question + answerTrue1;
            correctAnswers += "\n" + getString(R.string.correct_answer_Q6) + question + answerTrue2;
            correctAnswers += "\n" + getString(R.string.correct_answer_Q7) + question + answerTrue3;
            textViewTextChange.setText(
                    correctAnswers);
            textViewTextChange.setVisibility(View.VISIBLE);
        }
        finalScore = 0; //resets score
    }

    //Retrieves the number of correct answers in the quiz
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
        EditText answerQ4Field = (EditText) findViewById(answer_q_4);
        String answerQ4 = answerQ4Field.getText().toString();
        if (answerQ4.toLowerCase().contains("purple") || answerQ4.toLowerCase().contains("violet")) {
            finalScore++;

            //if(answer4.toLowerCase().equals("-correct-answer-here-in-lowercase-")
        }
        //Verifies answer for question 5 and adds 1 point to final score if the answer is correct
        EditText answerQ5Field = (EditText) findViewById(answer_q_5);
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

    //takes the user back to the top of the screen
    public void goToTop(View view) {
        ScrollView questionsScrollView = (ScrollView) findViewById(R.id.scroll_view_questions);
        questionsScrollView.smoothScrollTo(0, 0);
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