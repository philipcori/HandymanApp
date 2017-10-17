package edu.eejohnsonscu.handi2;
import java.util.ArrayList;

/**
 * Created by moral_000 on 3/5/2017.
 */

public final class Users {

    private static ArrayList<User> users;

    public Users() {
         users = new ArrayList<User>();
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
    public void setUsers(ArrayList<User> u){
        users = u;
    }
    public static User getMainUser(){
        for(User u : users){
            if(u.getIsMain())
                return u;
        }
        return null;
    }
    public static void resetMain(){
        for(User u : users){
            u.setIsMain(false);
        }
    }
}
