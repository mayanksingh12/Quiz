package com.example.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
TextView questionLabel,questionCountLabel,scoreLabel;
EditText answerEdit;
Button submitButton;
ProgressBar progressBar;
ArrayList<QuestionBundle> questionBundleArrayList;
int currentPosition=0;
int numberOfCorrectAnswer ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionLabel=findViewById(R.id.question);
        questionCountLabel=findViewById(R.id.noQuestion);
        scoreLabel=findViewById(R.id.score);
        answerEdit=findViewById(R.id.answer);
        submitButton=findViewById(R.id.submit);
        progressBar=findViewById(R.id.progress);


     questionBundleArrayList=new ArrayList<>();
     setUPQuestion();
     setData();

     submitButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             checkAnswer();

         }
     });



    }

    public void checkAnswer()
    {
        String answerString = answerEdit.getText().toString().trim();

        if(answerString.equalsIgnoreCase(questionBundleArrayList.get(currentPosition).getAnswer()))
        {
            numberOfCorrectAnswer ++;
            Log.e("answer" , "right");
            currentPosition ++;
            setData();
            answerEdit.setText("");

        }
        else
        {
            Log.e("answer" , "wrong");
            currentPosition ++;
            setData();
            answerEdit.setText("");
        }

        int x=((currentPosition+1) * 100) / questionBundleArrayList.size();

        progressBar.setProgress(x);



    }


public void setUPQuestion()
{
    questionBundleArrayList.add(new QuestionBundle( "What is 1+2 ?" , "3"));
    questionBundleArrayList.add(new QuestionBundle( "What is 5*9 ?" , "45"));
    questionBundleArrayList.add(new QuestionBundle( "What is 30/8 ?" , "3.75"));
    questionBundleArrayList.add(new QuestionBundle( "What is 5+57 ?" , "62"));
    questionBundleArrayList.add(new QuestionBundle( "What is 2*3 ?" , "6"));
}

public void setData()
{
    questionLabel.setText(questionBundleArrayList.get(currentPosition).getQuestionString());
    questionCountLabel.setText("Question no :"+(currentPosition+1));
    scoreLabel.setText("Score :"+numberOfCorrectAnswer+"/"+ questionBundleArrayList.size());
}


}
