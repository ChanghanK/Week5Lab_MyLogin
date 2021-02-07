/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author 827637
 */
public class Account {
    private User abe = new User("abe", "password");
    private User barb = new User("barb", "password");
    
    public User login(String username, String password){
        switch (username){
            case "abe":
                if (password.equals(abe.getPassword())){
                    User user = new User();
                    user.setUsername(abe.getUsername());
                    return user;
                }
                break;
            case "barb":
                if (password.equals(barb.getPassword())){
                    User user = new User();
                    user.setUsername(barb.getUsername());
                    return user;
                }
                break;
            }
        return null;
    }
}
