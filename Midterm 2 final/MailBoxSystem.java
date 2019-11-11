package m2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MailBoxSystem {
	
    private Map <Integer, Mailbox> m1;
    private int extCounter = 0;
   
    // Hard-coded for now.
    private String adminPassword = "ab$!";
    
    public MailBoxSystem() {
        m1 = new HashMap <Integer, Mailbox > ();
    }
    /**
     * creates Mailbox object 
     * @param mailbox
     * 
     */
    public void createMailbox() {
    	try {
    		Mailbox mailbox = new Mailbox(extCounter);
        	extCounter++;
        	m1.put(extCounter, mailbox);
    	} catch(NullPointerException ex) {
    		// If error occurres do nothing.
    	}
    	
    }
    
    public Mailbox getMailBox(int ext) {
    	if (m1.containsKey(ext)) {
        	return m1.get(ext);
    	}
    	return null;
    }
//sets password for mailbox users
    public void setPassword(int ext, String password) {
    	try {
    	if (m1.containsKey(ext)) {
        	m1.get(ext).setPassword(password);
    	}
    	} catch(NullPointerException ex) {
    		
    	}
    }
  
    public boolean isPasswordCorrect(String Apass) {
        
    	return adminPassword.equals(Apass);

    }
    
    public void leaveAMessage(int ext, String message) {
    	if (m1.containsKey(ext))
    	{
        	m1.get(ext).addMessage(message);

    	}
    }
    /**
     *@param returns size of m1 to find the ext counter  
     * @return the ext counter
     */
    public int getExtCounter() {
    	return m1.size();
    }

}