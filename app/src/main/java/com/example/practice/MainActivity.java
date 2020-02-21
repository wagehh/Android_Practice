package com.example.practice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTitleStrip;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText mEditText;
    private Button mButton;
    private Button mButton_Switch;
    private Button bt;
    private Button mButton_show;
    private Button mButton_Loading;
    private Button mButton_warn;
    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private int flag=0;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//关闭系统标签栏
        setContentView(R.layout.activitiy_main);


        bt = (Button) findViewById(R.id.button_change);
        mButton = (Button) findViewById(R.id.button_mEditText);
        mButton_Switch = (Button) findViewById(R.id.button_switch);
        mButton_show = (Button) findViewById(R.id.button_show);
        mButton_Loading=(Button)findViewById(R.id.button_loading);
        mButton_warn = (Button)findViewById(R.id.button_warn);
        mEditText = (EditText) findViewById(R.id.mEditText);
        mImageView = (ImageView) findViewById(R.id.imageView);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        mButton_Loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress = mProgressBar.getProgress();
                progress = progress + 10;
                mProgressBar.setProgress(progress);
            }
        });
        mButton_warn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is a Dialog");
                dialog.setMessage("Something Important.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = mEditText.getText().toString();
                Toast.makeText(MainActivity.this,inputText, Toast.LENGTH_SHORT).show();
            }
        });
        mButton_Switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0){
                    mImageView.setImageResource(R.drawable.img_1);
                    flag=1;
                }
                else{
                    mImageView.setImageResource(R.drawable.astronaut);
                    flag=0;
                }
            }
        });
        mButton_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mImageView.getVisibility() == View.GONE){
                    mImageView.setVisibility(View.VISIBLE);
                }
                else{
                    mImageView.setVisibility((View.GONE));
                }
            }
        });
    }

/*
    private void onClick(View v){
        switch (v.getId()){
            case R.id.button_show:
                if(mImageView.getVisibility() == View.GONE){
                    mImageView.setVisibility(View.VISIBLE);
                }
                else{
                    mImageView.setVisibility((View.GONE));
                }
                break;
            default:
                break;
        }


    }


    /****************构造方法****************/
    /*
    public void oneOnClick(View view){
        Log.d(TAG,"one on click...");
        if (View instanceof TextView) {
            String oneText = ((TextView) view).getText().toString();
            Log.d(TAG,"one btn content =="+ oneText);
        }
    }
    public void onOrangeClick(View view){
        Log.d(TAG,"orange click...");
        if (View instanceof TextView) {
            String text = ((TextView) view).getText().toString();
            Log.d(TAG,"text ==" + text);
        }
    }
    */



}
