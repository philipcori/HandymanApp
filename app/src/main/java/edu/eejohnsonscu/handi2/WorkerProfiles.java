package edu.eejohnsonscu.handi2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class WorkerProfiles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_profiles);
        displayResults();
    }


    public ArrayList<User> findWorkers(){
        User main = Users.getMainUser();
        ArrayList<User> out = new ArrayList<User>();
        boolean canAdd = true;
        for(User u : Users.getUsers()){
            canAdd = true;
            if(u.getType().equals("Worker") && u.getIsActive()){
                for(int i = 0; i < main.getNumSkills(); i++){
                    if(!u.hasSkill(main.skills[i]))
                        canAdd = false;
                }
                if(u.getRequestedPay() > main.getRequestedPay())
                    canAdd = false;
                if(canAdd)
                    out.add(u);
            }
        }
        return out;
    }

    public void displayResults() {
        ArrayList<User> hirees = findWorkers();
        TextView t1 = (TextView)findViewById(R.id.textView11);
        TextView t2 = (TextView)findViewById(R.id.textView12);
        TextView t3 = (TextView)findViewById(R.id.textView13);
        TextView t4 = (TextView)findViewById(R.id.textView14);
        if(hirees.size() >0)
            t1.setText(hirees.get(0).getName()+ ": " + hirees.get(0).getNumSkills() + "/6 skills, $" + hirees.get(0).getRequestedPay());
        else
            t1.setText("No workers at this time");
        if(hirees.size() >1)
            t2.setText(hirees.get(1).getName() +": " + hirees.get(1).getNumSkills() + "/6 skills, $" + hirees.get(1).getRequestedPay());
        else
            t2.setText("");
        if(hirees.size() >2)
            t3.setText(hirees.get(2).getName() +": " + hirees.get(1).getNumSkills() + "/6 skills, $" + hirees.get(2).getRequestedPay());
        else
            t3.setText("");
        if(hirees.size() >3)
            t4.setText(hirees.get(3).getName() + ": " + hirees.get(1).getNumSkills() + "/6 skills, $" + hirees.get(3).getRequestedPay());
        else
            t4.setText("");
    }

    public void jumpToPageCongrats(View view) {
        Intent intent = new Intent(this, Congrats.class);
        startActivity(intent);
    }
}
