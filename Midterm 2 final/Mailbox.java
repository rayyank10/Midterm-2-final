package m2;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Rayyan
 * Mailbox 
 * 
 */
public class Mailbox {
	
	List<String> messages = new LinkedList<String>();
	private int ext; 
	private static String password;
	private Map<String, String> greetings = new HashMap<String, String>();
	/**
	 * Creates a mailbox that comes with a password and greetings 
	 * @param integer ext the mailboxes extension
	 */
	
	
	public Mailbox(int ext) {
		this.ext = ext;
		//Set the default password
		setPassword("1234");
		// Create default greetings, greeting one is the main greeting
		this.greetings.put("greeting1","Welcome");
		this.greetings.put("greeting2","Welcome!");
		this.greetings.put("greeting3","Welcome!!");
	}
	
	public Map<String, String> getMap()
	{
		return greetings;
	}
	public List<String> getQueue()
	{
		return messages;
	}
	
	
	public void addMessage(String msg) {
		this.messages.add(msg);
	}
	
	public void deleteMessage(int index) {
		this.messages.remove(index);
	}
	//updates the greeting you would like to update
	public void updateGreeting(String greeting, String msg) {
		// Ensure there are only three greetings
		if (greeting.equals("greeting1") || greeting.equals("greeting2") || greeting.equals("greeting3")) {
			this.greetings.put(greeting,msg);		
		}
	}
	//the default greeting is the first greeting
	public void setDefaultGreeting(String msg) {
		updateGreeting("greeting1",msg);
	}
	
	private String getDefaultGreeting() {
		return this.greetings.get("greeting1");
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 *@return returns the password  
	 * 
	 */
	public String getPassword() {
		return this.password; 
	}
	// checks if the password entered matches the password
	//pre condition the password needs to exist for this method to work
    // only runs if password != null, the password needs to exist
	public boolean isPasswordCorrect(String pass) {
        return pass.equals(password);
	}
	//sorts messages alphabetically
	 public void sortMessages() {
    	 Collections.sort(messages, new Comparator<String>() {
    	     @Override
    	     public int compare(String o1, String o2) {
    	         return Collator.getInstance().compare(o1, o2);
    	     }
    	 });
    }
}
