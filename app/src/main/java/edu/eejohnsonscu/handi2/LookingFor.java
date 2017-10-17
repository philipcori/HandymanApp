package edu.eejohnsonscu.handi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LookingFor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looking_for);
    }



    public void jumpToPageWork(View view)
    {
        Users.getMainUser().setType("Worker");
        Intent intent = new Intent(this, Work.class);
        startActivity(intent);
    }

    public void jumpToPageWorkers(View view)
    {
        Users.getMainUser().setType("Hirer");
        Intent intent = new Intent(this, Workers.class);
        startActivity(intent);
    }


}