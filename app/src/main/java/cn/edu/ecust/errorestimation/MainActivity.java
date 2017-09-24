package cn.edu.ecust.errorestimation;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText measureTimeText;

    private EditText instrumentErrorText;

    private EditText firstTimeText;

    private EditText secondTimeText;

    private EditText thirdTimeText;

    private EditText fourthTimeText;

    private EditText fifthTimeText;

    private EditText sixthTimeText;

    private EditText seventhTimeText;

    private EditText eighthTimeText;

    private EditText ninthTimeText;

    private EditText tenthTimeText;

    private TextView averageText;

    private TextView standardErrorText;

    private TextView aClassText;

    private TextView bClassText;

    private TextView uncertaintyText;

    private TextView relativeErrorText;

    private FloatingActionButton fab;

    private Toolbar toolbar;

    private double[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {
                    measureTimeText=(EditText) findViewById(R.id.measure_time);
                    instrumentErrorText=(EditText) findViewById(R.id.instrument_error);
                    firstTimeText=(EditText) findViewById(R.id.first_time);
                    secondTimeText=(EditText) findViewById(R.id.second_time);
                    thirdTimeText=(EditText) findViewById(R.id.third_time);
                    fourthTimeText=(EditText) findViewById(R.id.fourth_time);
                    fifthTimeText=(EditText) findViewById(R.id.fifth_time);
                    sixthTimeText=(EditText) findViewById(R.id.sixth_time);
                    seventhTimeText=(EditText) findViewById(R.id.seventh_time);
                    eighthTimeText=(EditText) findViewById(R.id.eighth_time);
                    ninthTimeText=(EditText) findViewById(R.id.ninth_time);
                    tenthTimeText=(EditText) findViewById(R.id.tenth_time);
                    averageText=(TextView)findViewById(R.id.average);
                    standardErrorText=(TextView)findViewById(R.id.standard_error);
                    aClassText=(TextView)findViewById(R.id.a_class);
                    bClassText=(TextView)findViewById(R.id.b_class);
                    uncertaintyText=(TextView)findViewById(R.id.uncertainty);
                    relativeErrorText=(TextView)findViewById(R.id.relative_error);

                    int measureTime=Integer.parseInt(measureTimeText.getText().toString());
                    double instrumentError=Double.parseDouble(instrumentErrorText.getText().toString());
                    double firstTime=Double.parseDouble(firstTimeText.getText().toString());
                    double secondTime=Double.parseDouble(secondTimeText.getText().toString());
                    double thirdTime=Double.parseDouble(thirdTimeText.getText().toString());
                    double fourthTime=Double.parseDouble(fourthTimeText.getText().toString());
                    double fifthTime=Double.parseDouble(fifthTimeText.getText().toString());
                    double sixthTime=Double.parseDouble(sixthTimeText.getText().toString());
                    double seventhTime=Double.parseDouble(seventhTimeText.getText().toString());
                    double eighthTime=Double.parseDouble(eighthTimeText.getText().toString());
                    double ninthTime=Double.parseDouble(ninthTimeText.getText().toString());
                    double tenthTime=Double.parseDouble(tenthTimeText.getText().toString());
                    data=new double[10];
                    data[0]=firstTime;
                    data[1]=secondTime;
                    data[2]=thirdTime;
                    data[3]=fourthTime;
                    data[4]=fifthTime;
                    data[5]=sixthTime;
                    data[6]=seventhTime;
                    data[7]=eighthTime;
                    data[8]=ninthTime;
                    data[9]=tenthTime;
                    double temp=0;
                    double average=0;
                    for (int i=0;i<measureTime;i++){
                        average+=data[i];
                    }
                    average=average/measureTime;
                    for (int i=0;i<measureTime;i++){
                        temp+=Math.pow((data[i]-average),2);
                    }
                    double standardError=Math.pow(temp/(measureTime*(measureTime-1)),0.5);
                    double[] tP={1.84,1.32,1.20,1.14,1.11,1.09,1.08,1.07,1.06};
                    double aClass=tP[measureTime-2]*standardError;
                    double bClass=0.683*instrumentError;
                    double uncertainty=Math.pow(aClass*aClass+bClass*bClass,0.5);
                    double relativeError=uncertainty/average;
                    averageText.setText(String.valueOf(average));
                    standardErrorText.setText(String.valueOf(standardError));
                    aClassText.setText(String.valueOf(aClass));
                    bClassText.setText(String.valueOf(bClass));
                    uncertaintyText.setText(String.valueOf(uncertainty));
                    relativeErrorText.setText(String.valueOf(relativeError));
                }catch (Exception e){
                    Snackbar.make(view,"请检查输入的数据",Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}