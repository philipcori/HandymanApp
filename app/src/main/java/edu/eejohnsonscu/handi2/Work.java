package edu.eejohnsonscu.handi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Work extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
    }

    public void setRequestedPay(){
        EditText e = (EditText)findViewById(R.id.editText7);
        Users.getMainUser().setRequestedPay(Integer.parseInt(e.getText().toString()));
    }

    public void setName(){
        EditText e = (EditText)findViewById(R.id.editText2);
        Users.getMainUser().setName(e.getText().toString());
    }

    public void addSkills(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBox9:
                if (checked)
                    Users.getMainUser().addSkill("Computer knowledge");
                else
                    Users.getMainUser().removeSkill("Computer knowledge");
                break;
            case R.id.checkBox10:
                if (checked)
                    Users.getMainUser().addSkill("Heavy lifting");
                else
                    Users.getMainUser().removeSkill("Heavy lifting");
                break;
            case R.id.checkBox11:
                if (checked)
                    Users.getMainUser().addSkill("Plumbing");
                else
                    Users.getMainUser().removeSkill("Plumbing");
                break;
            case R.id.checkBox12:
                if (checked)
                    Users.getMainUser().addSkill("Electrical");
                else
                    Users.getMainUser().removeSkill("Electrical");
                break;
            case R.id.checkBox13:
                if (checked)
                    Users.getMainUser().addSkill("Use basic tools");
                else
                    Users.getMainUser().removeSkill("Use basic tools");
                break;
            case R.id.checkBox14:
                if (checked)
                    Users.getMainUser().addSkill("Use power tools");
                else
                    Users.getMainUser().removeSkill("Use power tools");
                break;
        }
    }

    public void jumpToPageProfiles(View view){

        Users.getMainUser().setIsActive(true);
        setName();
        setRequestedPay();
        Intent intent = new Intent(this, Profiles.class);
        startActivity(intent);

    }
}
