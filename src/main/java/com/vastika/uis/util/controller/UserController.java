package com.vastika.uis.util.controller;

import com.vastika.uis.util.model.User;
import com.vastika.uis.util.service.UserService;
import com.vastika.uis.util.service.UserServiceImpl;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UserController {
    public static void main (String [] args){
        String decision = "N";
        UserService userService = new UserServiceImpl();
        do{
            String operation = JOptionPane.showInputDialog("Enter operation : save|update|delete|get|list");
            switch (operation) {
                case "save":
                    User user = getUser("save");
                    int saved = userService.saveUser(user);
                    if (saved >= 1) {
                        JOptionPane.showMessageDialog(null, "user info is saved in db");
                    } else {
                        JOptionPane.showMessageDialog(null, "error in db");
                    }
                    break;
                case "update":
                    User updatedUser = getUser("update");
                    int updated = userService.saveUser(updatedUser);
                    if (updated >= 1) {
                        JOptionPane.showMessageDialog(null, "user info is updated");
                    } else {
                        JOptionPane.showMessageDialog(null, "error in db");
                    }
                    break;
                case "delete":
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Id: "));
                    User deletedUser = getUser("deleted");
                    int deleted = userService.deleteUser(id);
                    if (deleted >= 1) {
                        JOptionPane.showMessageDialog(null, "user info is deleted");
                    } else {
                        JOptionPane.showMessageDialog(null, "error in db");
                    }
                    break;
                case "get":
                    id = Integer.parseInt(JOptionPane.showInputDialog("Enter Id: "));
                    user = userService.getUserById(id);
                    printUserInfo(user);


                case "List":
                    List<User> users = userService.getAllUser();
                    for (User u : users){
                        printUserInfo(u);

                    }
                    break;
            }

        decision = JOptionPane.showInputDialog("do you want to continue? Enter Y | N");
        }while (decision.equalsIgnoreCase("y"));
        JOptionPane.showMessageDialog(null,"Bye Bye !! See you next time");
    }
    public static User getUser(String type){
        User user = new User();
        if (type.equals("update")) {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Id: "));
            user.setId(id);
        }
        String username = JOptionPane.showInputDialog("Enter username: ");
        String password = JOptionPane.showInputDialog("Enter Password");
        long mobileNo = Long.parseLong(JOptionPane.showInputDialog("Enter mobile number"));
        double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary"));
        LocalDate dob = LocalDate.parse(JOptionPane.showInputDialog("Enter DOB: "));
        boolean active = Boolean.parseBoolean(JOptionPane.showInputDialog("Enter if user is active"));
        user.setUsername(username);
        user.setPassword(password);
        user.setSalary(salary);
        user.setMobileNo(mobileNo);
        user.setDob(dob);
        user.setActive(active);
        return user;

    }
    public static void printUserInfo( User user){
        System.out.println("=========================================");
        System.out.println("User name is: "+ user.getUsername());
        System.out.println("Password is: "+ user.getPassword());
        System.out.println("Mobile No is:" +user.getMobileNo());
        System.out.println("DOB is:" +user.getMobileNo());
        System.out.println("Is user active?" + user.isActive());
        System.out.println("=========================================");

    }
}
//crude application --> crate
//R -> Read ->List
//U -> Update ->  update
//D -> List -> list