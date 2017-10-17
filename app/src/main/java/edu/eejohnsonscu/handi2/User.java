package edu.eejohnsonscu.handi2;

/**
 * Created by Philip on 3/4/2017.
 */

public class User {


    String type;
    String email;
    String password;
    String name;


    String jobDescription;
    String[] skills;
    private static int count = 0;
    int ID;
    int numSkills;
    boolean isMain,isActive;
    int requestedPay;

    public User(String email, String password){
        this.email = email;
        this.password = password;
        skills = new String[10];
        numSkills = 0;
        ID = ++count;
        isMain = false;
        isActive = false;
    }
    public void addSkill(String skill){
        skills[numSkills] = skill;
        numSkills++;
    }
    public boolean hasSkill(String skill){
        for(int i = 0; i < numSkills; i++){
            if(skills[i].equals(skill))
                return true;
        }
        return false;
    }
    public void removeSkill(String skill){
        int j;
        for(int i =0;  i < numSkills; i++){
            if(skills[i].equals(skill)){
                for(j=i; i < numSkills-1; i++){
                    skills[j] = skills[j+1];
                }
                skills[numSkills] = null;
                numSkills--;
                break;
            }
        }
    }
    public boolean sameEmail(String email){
        return this.email.equals(email);
    }
    public boolean correctPassword(String password){
        return this.password.equals(password);
    }
    public void setName(String name){
        this.name = name;
    }
    public int getID(){
        return ID;
    }
    public void setIsMain(boolean isMain){

        this.isMain = isMain;
    }
    public boolean getIsMain(){
        return isMain;
    }
    public void setIsActive(boolean a){
        isActive=a;
    }
    public boolean getIsActive(){
        return isActive;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void setRequestedPay(int pay){
        requestedPay = pay;
    }
    public int getRequestedPay(){
        return requestedPay;
    }
    public int getNumSkills(){
        return numSkills;
    }
    public void setNumSkills(int num){
        numSkills = num;
    }
    public String getName(){
        return name;
    }
    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    public void setSkills(String[] skills){
        this.skills = skills;
    }

}