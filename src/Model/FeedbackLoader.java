/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Dan
 */
public class FeedbackLoader {


    static final String FILENAME = "feedback.txt";
    public ArrayList<Feedback> load(){
        ArrayList<Feedback> feedbackArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row,txtId, txtName;

            

            br.readLine();
            while ((row = br.readLine()) != null) {
                String str[] = row.split("\\|\\|");
                txtId = str[0];
                txtName = str[1];


                
                feedbackArrayList.add(new Feedback(txtId, txtName));


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return feedbackArrayList;
    }
    
    public ArrayList<Feedback> load(String search){//use this for searchign and sorting
        ArrayList<Feedback> feedbackArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row,txtId, txtName;

            

            br.readLine();
            while ((row = br.readLine()) != null) {
                String str[] = row.split("\\|\\|");
                txtId = str[0];
                txtName = str[1];
                
                //Declare new feedback instance
                

                //Search function
                if(!(txtId.matches(search+".*")||txtName.matches(search+".*"))){
                    continue;
                }      
                
                
                feedbackArrayList.add(new Feedback(txtId, txtName));


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return feedbackArrayList;
    }
    
    
    }

