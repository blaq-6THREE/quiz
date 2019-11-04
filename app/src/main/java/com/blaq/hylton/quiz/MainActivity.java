package com.blaq.hylton.quiz;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private TextView questionTextView;
    private ProgressBar mProgressBar;

    private RadioGroup answerRadioGroup;
    private RadioButton radioAnswer1;
    private RadioButton radioAnswer2;
    private RadioButton radioAnswer3;
    private RadioButton radioAnswer4;

    private Button submitButton;

    private ArrayList<Questions> mQuestionsArrayList;

    private int questionCounter;
    private int progressCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionCounter = 0;
        progressCounter = 0;

        questionTextView = findViewById(R.id.question_textview);
        answerRadioGroup = findViewById(R.id.radioGroup);
        mProgressBar = findViewById(R.id.progressBar);

        radioAnswer1 = findViewById(R.id.answer_1);
        radioAnswer2 = findViewById(R.id.answer_2);
        radioAnswer3 = findViewById(R.id.answer_3);
        radioAnswer4 = findViewById(R.id.answer_4);

        submitButton = findViewById(R.id.submit);

        mQuestionsArrayList = new ArrayList<>();
        mQuestionsArrayList.add(0, new Questions("Who was the first President of Ghana?", "Kwame Nkrumah"));
        mQuestionsArrayList.get(0).setPossibleAnswer1("Alele");
        mQuestionsArrayList.get(0).setPossibleAnswer2("Kwame Nkrumah");
        mQuestionsArrayList.get(0).setPossibleAnswer3("Robert Mugabe");
        mQuestionsArrayList.get(0).setPossibleAnswer4("Shikamaru");

        mQuestionsArrayList.add(1, new Questions("What is 1 + 1?", "2"));
        mQuestionsArrayList.get(1).setPossibleAnswer1("18");
        mQuestionsArrayList.get(1).setPossibleAnswer2("3");
        mQuestionsArrayList.get(1).setPossibleAnswer3("2");
        mQuestionsArrayList.get(1).setPossibleAnswer4("7");

        mQuestionsArrayList.add(2, new Questions("What color is the sky?", "Blue"));
        mQuestionsArrayList.get(2).setPossibleAnswer1("Red");
        mQuestionsArrayList.get(2).setPossibleAnswer2("Blue");
        mQuestionsArrayList.get(2).setPossibleAnswer3("Orange");
        mQuestionsArrayList.get(2).setPossibleAnswer4("Black");

        mQuestionsArrayList.add(3,new Questions("Who invented C Plus Plus?", "Bjarne Stroustrup"));
        mQuestionsArrayList.get(3).setPossibleAnswer1("Bjarne Stroustrup");
        mQuestionsArrayList.get(3).setPossibleAnswer2("Guido van Rossum");
        mQuestionsArrayList.get(3).setPossibleAnswer3("Brendan Eich");
        mQuestionsArrayList.get(3).setPossibleAnswer4("Larry Wall");

        mQuestionsArrayList.add(4, new Questions("Who was the 16th president of the USA?","Abraham Lincoln"));
        mQuestionsArrayList.get(4).setPossibleAnswer1("Jimmy Carter");
        mQuestionsArrayList.get(4).setPossibleAnswer2("John McCarthy");
        mQuestionsArrayList.get(4).setPossibleAnswer3("Barack Obama");
        mQuestionsArrayList.get(4).setPossibleAnswer4("Abraham Lincoln");

        mQuestionsArrayList.add(5, new Questions("Who has the most Championships in Professional Championships?", "Yankees"));
        mQuestionsArrayList.get(5).setPossibleAnswer1("Lakers");
        mQuestionsArrayList.get(5).setPossibleAnswer2("NY Jets");
        mQuestionsArrayList.get(5).setPossibleAnswer3("Cowboys");
        mQuestionsArrayList.get(5).setPossibleAnswer4("Yankees");

        mQuestionsArrayList.add(6, new Questions("Who has the most Champions League trophies?", "Real Madrid"));
        mQuestionsArrayList.get(6).setPossibleAnswer1("Liverpool");
        mQuestionsArrayList.get(6).setPossibleAnswer2("Real Madrid");
        mQuestionsArrayList.get(6).setPossibleAnswer3("Barcelona");
        mQuestionsArrayList.get(6).setPossibleAnswer4("Atletico Madrid");

        mQuestionsArrayList.add(7,new Questions("Who has the best Jollof?", "Ghana"));
        mQuestionsArrayList.get(7).setPossibleAnswer1("Niaja");
        mQuestionsArrayList.get(7).setPossibleAnswer2("Senegal");
        mQuestionsArrayList.get(7).setPossibleAnswer3("Ghana");
        mQuestionsArrayList.get(7).setPossibleAnswer4("Village Hidden in The Leaf");

        mQuestionsArrayList.add(8,new Questions("Who is the best football player in the world?", "Lionel Messi"));
        mQuestionsArrayList.get(8).setPossibleAnswer1("Ronaldo");
        mQuestionsArrayList.get(8).setPossibleAnswer2("Pogba");
        mQuestionsArrayList.get(8).setPossibleAnswer3("Lionel Messi");
        mQuestionsArrayList.get(8).setPossibleAnswer4("Hylton");

        mQuestionsArrayList.add(9,new Questions("Do I get a 100 on this assignment?", "Hell Yes"));
        mQuestionsArrayList.get(9).setPossibleAnswer1("Yeah");
        mQuestionsArrayList.get(9).setPossibleAnswer2("Maybe");
        mQuestionsArrayList.get(9).setPossibleAnswer3("No");
        mQuestionsArrayList.get(9).setPossibleAnswer4("Hell Yes");

        questionSetter(questionCounter);

        submitButton.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int selectedId = answerRadioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedId);

                String realAnswer = mQuestionsArrayList.get(questionCounter).getAnswer().trim();
                String userAnswer = String.valueOf(radioButton.getText()).trim();

                if (realAnswer.equalsIgnoreCase(userAnswer))
                {
                    Toast.makeText(MainActivity.this, "Good Job", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run()
                        {
                            questionCounter = questionCounter + 1;
                            progressCounter = progressCounter + 1;

                            questionSetter(questionCounter);
                            mProgressBar.setProgress(progressCounter);
                            answerRadioGroup.clearCheck();
                        }
                    }, 2000);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Right answer is " + mQuestionsArrayList.get(questionCounter).getAnswer(), Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run()
                        {
                            questionCounter = questionCounter + 1;
                            questionSetter(questionCounter);
                            answerRadioGroup.clearCheck();
                        }
                    }, 2000);

                }
            }
        });
    }

    public void questionSetter(int questionCounter)
    {
        if (questionCounter < mQuestionsArrayList.size())
        {
            questionTextView.setText(mQuestionsArrayList.get(questionCounter).getQuestion());
            radioAnswer1.setText(mQuestionsArrayList.get(questionCounter).getPossibleAnswer1());
            radioAnswer2.setText(mQuestionsArrayList.get(questionCounter).getPossibleAnswer2());
            radioAnswer3.setText(mQuestionsArrayList.get(questionCounter).getPossibleAnswer3());
            radioAnswer4.setText(mQuestionsArrayList.get(questionCounter).getPossibleAnswer4());
        }

        else if ((questionCounter == mQuestionsArrayList.size()) )
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder
            .setTitle("Congratulations.")
            .setMessage("Your score is " + (progressCounter * 100) + "The game is now over. Do " +
                    "you wish to restart or quit?")
            .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    questionSetter(0);
                    mProgressBar.setProgress(0);
                    answerRadioGroup.clearCheck();
                }
            })
            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });


            builder.create();
        }
    }
}
