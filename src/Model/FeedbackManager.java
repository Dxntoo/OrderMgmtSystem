/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import CustomException.UserDuplicateException;
import CustomException.UsernameDuplicateException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;



/**
 *
 * @author Dan
 */
public class FeedbackManager {
    private static final String FILENAME = "feedback.txt";
    
    public void addFeedback(Feedback feedback, String desc){
        
        try (BufferedWriter bwFeedback = new BufferedWriter(new FileWriter(FILENAME, true))) {
            bwFeedback.write(feedback.getFeedbackID() + "||" + desc + System.lineSeparator());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
