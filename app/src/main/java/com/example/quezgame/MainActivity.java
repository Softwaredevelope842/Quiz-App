package com.example.quezgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    quezData obj=new quezData();
    TextView txtQheading,txtQ,txtAns;
    RadioGroup radG;
    RadioButton radB1,radB2,radB3,radB4,radTemp;
    Button btn;
    int question=1,questionLimit=50,marks=0,totalMarks=questionLimit,firstClick=1,index=0;
    String Question="Question ",Ans="Ans: ";
    Random random=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtQheading=findViewById(R.id.txtQheading);
        txtQ=findViewById(R.id.txtQ);
        txtAns=findViewById(R.id.txtAns);
        radG=findViewById(R.id.radioG);
        radB1=findViewById(R.id.radB1);
        radB2=findViewById(R.id.radB2);
        radB3=findViewById(R.id.radB3);
        radB4=findViewById(R.id.radB4);
        btn=findViewById(R.id.btn);


        txtQheading.setText(Question+(question));
        txtQ.setText(obj.questions[index]);
        txtAns.setText("");
        radB1.setText(obj.optionA[index]);
        radB2.setText(obj.optionB[index]);
        radB3.setText(obj.optionC[index]);
        radB4.setText(obj.optionD[index]);
        


        radG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radTemp=findViewById(checkedId);
                if(radTemp.getText().toString().equals(obj.correctAnswers[index])){
                  //  radTemp.setTextColor(getColor(R.color.green));
                    if(firstClick==1){
                        marks++;
                    }
                }
                else{
                    radTemp.setTextColor(getColor(R.color.red));
                }
                //txtAns.setText(Ans+obj.correctAnswers[index]);
                firstClick++;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question==questionLimit){
                    Intent i=new Intent(MainActivity.this,resultActivity.class);
                    i.putExtra("marks",marks);
                    i.putExtra("totalMarks",totalMarks);
                    startActivity(i);
                    finish();

                }
                else{
                    if(questionLimit==question+1){
                        btn.setText("Result");
                    }
                    radTemp.setChecked(false);
                    //radG.clearCheck();
                    question++;
                    index++;
                    txtQheading.setText(Question+question);
                    txtQ.setText(obj.questions[index]);
                    radB1.setText(obj.optionA[index]);
                    radB2.setText(obj.optionB[index]);
                    radB3.setText(obj.optionC[index]);
                    radB4.setText(obj.optionD[index]);

                    radB1.setTextColor(getColor(R.color.black));
                    radB2.setTextColor(getColor(R.color.black));
                    radB3.setTextColor(getColor(R.color.black));
                    radB4.setTextColor(getColor(R.color.black));

                    txtAns.setText("");

                   firstClick=1;

                }
            }
        });

    }

}