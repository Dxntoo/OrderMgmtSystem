/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Dan
 */
public class Feedback {
    
    private String FeedbackID;
    private String Description;
    private Customer customer;
    
    
    public Feedback(String FeedbackID, String Description){
        this.FeedbackID = FeedbackID;
        this.Description = Description;
    }
    public Feedback(String desc){
        this.FeedbackID = Utility.generateId("feedback.txt", "F");
        this.Description = desc;
    }
    public void setFeedback(String Description){
        this.Description = Description;
    }
    
    public String getFeedback(){
        return Description;
    }
    
    public void setFeedbackID(String FeedbackID){
        this.FeedbackID = FeedbackID;
    }
    
    public String getFeedbackID(){
        return FeedbackID;
    }
    
    public Customer getCustomer(){
        return customer;
    }

    
    
    
    
}
