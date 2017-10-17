package edu.eejohnsonscu.handi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

import android.view.View;
import android.widget.TextView;

public class Profiles extends AppCompatActivity {

    int MAX_RESULTS = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);
        displayResults();
    }



    public ArrayList<User> findHirers(){
        User main = Users.getMainUser();
        ArrayList<User> out = new ArrayList<User>();
        boolean canAdd = true;
        for(User u : Users.getUsers()){
            canAdd = true;
            if(u.getType().equals("Hirer") && u.getIsActive()){
                for(int i = 0; i < u.getNumSkills(); i++){
                    if(!main.hasSkill(u.skills[i]))
                        canAdd = false;
                }
                if(u.getRequestedPay() < main.getRequestedPay())
                    canAdd = false;
                if(canAdd)
                    out.add(u);
            }
        }
        return out;
    }
    public void displayResults(){
        ArrayList<User> hirees = findHirers();
        TextView t1 = (TextView)findViewById(R.id.textView5);
        TextView t2 = (TextView)findViewById(R.id.textView15);
        TextView t3 = (TextView)findViewById(R.id.textView16);
        TextView t4 = (TextView)findViewById(R.id.textView17);
        if(hirees.size() >0)
            t1.setText(hirees.get(0).getName() + ": " + hirees.get(0).getJobDescription() + " - $" + Integer.toString(hirees.get(0).getRequestedPay()));
        else
            t1.setText("No offers");
        if(hirees.size() >1)
            t2.setText(hirees.get(1).getName() + ": " + hirees.get(1).getJobDescription() + " - $" + Integer.toString(hirees.get(1).getRequestedPay()));
        else
            t2.setText("");
        if(hirees.size() >2)
            t3.setText(hirees.get(2).getName() + ": " + hirees.get(2).getJobDescription() + " - $" + Integer.toString(hirees.get(2).getRequestedPay()));
        else
            t3.setText("");
        if(hirees.size() >3)
            t4.setText(hirees.get(3).getName() + ": " + hirees.get(3).getJobDescription() + " - $" + Integer.toString(hirees.get(3).getRequestedPay()));
        else
            t4.setText("");
    }

    public void jumpToPageCongrats(View view) {
        Intent intent = new Intent(this, Congrats.class);
        startActivity(intent);
    }
}
