package m2;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class VoiceMailSystemUi extends JFrame {
    private final int FIELD_WIDTH = 10;
    private final int FIELD_WIDTH2 = 30;
    private JFrame frame;
    private JButton adminButton;
    private JButton enterButton;
    private JButton callerButton;
    private JButton userButton;
    private JButton setPassEnter;
    private JButton create, setPass, play, delete, next, greeting, setGreeting, changeGreeting;
    private JButton greeting1, greeting2, greeting3, leaveMess;
    private JTextField passcodeTextField, mailboxPassword, changePasswordTextfield;
    private JTextField mailboxTextField, greetingTextfield, greetingTextfield2, greetingTextfield3;
    private JTextField leaveAMessageTextField, playMessageTextfield, findExtTextField, extForCallerTextfield;
    private MailBoxSystem mailboxSystem;
    private JButton home;
    private JLabel changePassword, greetingDisplay , enterPassword;
    private JLabel findExtLabel, enterExtCaller, leaveAMessageLabel, messageHasbeenSetLabel, passHasBeenSet;
    private JLabel welcomeMessage, greetings, Ext, password;


    // Handle state of messages
    private Iterator < String > currentMessages;

    public VoiceMailSystemUi() {
        super("Voice Mail System");
        // Initialize our back end
        mailboxSystem = new MailBoxSystem();

        // Initialize the frame
        init();
        createMainMenu();
        initComponents();
    }

    private void createMainMenu() {
        frame.add(welcomeMessage);

        adminButton = new JButton("Admin");
        userButton = new JButton("User");
        callerButton = new JButton("Caller");
        home = new JButton("Return to Home");

        frame.add(adminButton);
        frame.add(userButton);
        frame.add(callerButton);
        frame.add(home);
        adminButton.addActionListener(adminListener);
        userButton.addActionListener(userListener);
        callerButton.addActionListener(callerListener);
        home.addActionListener(homeListener);


    }

    private void init() {
        frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setBounds(300, 200, 400, 300);
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MailBox System");
        welcomeMessage = new JLabel("Welcome");
    }

    private void initComponents() {
         
        //all the labels
        Ext = new JLabel("Please enter Password");
        password = new JLabel("Please enter Ext ");
        greetings = new JLabel("Greeting");
        enterExtCaller = new JLabel("Ext #");
        enterPassword = new JLabel("Please enter password");
        passHasBeenSet = new JLabel("Password Has been set");
        messageHasbeenSetLabel = new JLabel("Your message has been sent");
        leaveAMessageLabel = new JLabel("Please enter your message");
       
        // all the buttons
        next = new JButton("Next message");
        play = new JButton("Play or delete Message");
        delete = new JButton("Delete Message");
        next = new JButton("Next message");
        enterButton = new JButton("Enter");
        
        //caller buttons
        leaveMess = new JButton("Leave a message");
        
        //admin buttons
        create = new JButton("Create Mailbox");
        setPassEnter = new JButton("Enter");
        setPass = new JButton("Set Password");
        
        //all the textfields
        findExtTextField = new JTextField(FIELD_WIDTH);
        passcodeTextField = new JTextField(FIELD_WIDTH);
        mailboxPassword = new JTextField(FIELD_WIDTH);
        mailboxTextField = new JTextField(FIELD_WIDTH);
        extForCallerTextfield = new JTextField(FIELD_WIDTH);
        leaveAMessageTextField = new JTextField(FIELD_WIDTH);
        playMessageTextfield = new JTextField(FIELD_WIDTH);
        changePasswordTextfield = new JTextField(FIELD_WIDTH);
        
        
        //all the greeting buttons and textfields
        greeting = new JButton("Alter greeting");
        setGreeting = new JButton("Set Greeting");
        changeGreeting = new JButton("Change greeting");
        greeting1 = new JButton("Greeting 1");
        greeting2 = new JButton("Greeting 2");
        greeting3 = new JButton("Greeting 3");
        greetingDisplay = new JLabel(" ");
        greetingTextfield = new JTextField(FIELD_WIDTH2);
        greetingTextfield2 = new JTextField(FIELD_WIDTH2);
        greetingTextfield3 = new JTextField(FIELD_WIDTH2);
        changePassword = new JLabel("Please enter new passcode");
        findExtLabel = new JLabel("Please enter the ext#");
        frame.setVisible(true);

    }
   
    // All of the action listeners in order starting with all the admin functions
    //followed by user and then caller and the home button
    public ActionListener adminListener = new
    ActionListener() {
        public void actionPerformed(ActionEvent event) {

            frame.add(passcodeTextField);
            frame.add(enterPassword);
            //frame.add(password);

            frame.add(enterButton);


            callerButton.setVisible(false);
            userButton.setVisible(false);
            frame.revalidate();
            frame.pack();
            frame.repaint();

            enterButton.addActionListener(enterListenerAdmin);
            home.addActionListener(homeListener);


        }
    };

    public ActionListener enterListenerAdmin = new
    ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (mailboxSystem.isPasswordCorrect(passcodeTextField.getText())) {
                frame.add(create);
                frame.add(setPass);

                enterButton.setVisible(false);
                passcodeTextField.setVisible(false);
                //password.setVisible(false);
                Ext.setVisible(false);
                mailboxTextField.setVisible(false);
                enterPassword.setVisible(false);

                enterButton.setVisible(false);
                frame.revalidate();
                frame.pack();
                frame.repaint();
                create.addActionListener(createMailboxListener);
                setPass.addActionListener(setPassListener);
                home.addActionListener(homeListener);

            }

        }

    };
    public ActionListener createMailboxListener = new
    ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            mailboxSystem.createMailbox();
            home.addActionListener(homeListener);
        }
    };
    public ActionListener setPassListener = new
    ActionListener() {

        public void actionPerformed(ActionEvent e) {
            frame.add(findExtLabel);
            frame.add(findExtTextField);
            frame.add(changePassword);
            frame.add(changePasswordTextfield);
            frame.add(setPassEnter);
            create.setVisible(false);;
            setPass.setVisible(false);
            home.addActionListener(homeListener);
            setPassEnter.addActionListener(setPassEnterListener);


            frame.revalidate();
            frame.pack();
            frame.repaint();



        }
    };
    public ActionListener setPassEnterListener = new
    ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            int ext = Integer.parseInt(findExtTextField.getText());

            mailboxSystem.setPassword(ext, changePasswordTextfield.getText());
            frame.add(passHasBeenSet);
            home.addActionListener(homeListener);

        }

    };



    public ActionListener userListener = new
    ActionListener() {
        public void actionPerformed(ActionEvent event) {



            frame.add(Ext);
            frame.add(mailboxPassword);
            frame.add(password);
            frame.add(mailboxTextField);
            frame.add(enterButton);

            adminButton.setVisible(false);
            frame.revalidate();
            frame.pack();
            frame.repaint();
            callerButton.setVisible(false);
            enterButton.addActionListener(enterListenerUser);
            home.addActionListener(homeListener);

        }
    };
    public ActionListener enterListenerUser = new
    ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            int ext = Integer.parseInt(mailboxTextField.getText());

            Mailbox currentMailBox = mailboxSystem.getMailBox(ext);

            greetingDisplay.setText(currentMailBox.getMap().get("greeting1"));

            System.out.println(currentMailBox != null);
            System.out.println(ext);
            System.out.println(mailboxSystem.getExtCounter());

            if (currentMailBox != null && currentMailBox.isPasswordCorrect(mailboxPassword.getText())) {
                frame.add(play);
                frame.add(greeting);
                frame.add(greetingDisplay);

                enterButton.setVisible(false);
                mailboxPassword.setVisible(false);
                password.setVisible(false);
                Ext.setVisible(false);
                mailboxTextField.setVisible(false);


                frame.revalidate();
                frame.pack();
                frame.repaint();
                play.addActionListener(playMailboxListener);
                greeting.addActionListener(greetingMailListener);
                home.addActionListener(homeListener);

            }

        }

    };
    public ActionListener playMailboxListener = new
    ActionListener() {


        public void actionPerformed(ActionEvent e) {


            int ext = Integer.parseInt(mailboxTextField.getText());

            Mailbox currentMailBox = mailboxSystem.getMailBox(ext);

            currentMessages = currentMailBox.getQueue().iterator();


            frame.add(playMessageTextfield);
            frame.add(delete);
            frame.add(next);
            if (currentMessages.hasNext()) {
                playMessageTextfield.setText(currentMessages.next());
            } else {
                playMessageTextfield.setText("No Messages");
            }
            home.addActionListener(homeListener);


            play.setVisible(false);

            greeting.setVisible(false);
            next.addActionListener(nextMessageListener);
            delete.addActionListener(deleteMessageListener);

        }

    };
    public ActionListener nextMessageListener = new
    ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (currentMessages.hasNext()) {
                playMessageTextfield.setText(currentMessages.next());
            }
        }
    };

    public ActionListener deleteMessageListener = new
    ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            currentMessages.remove();
        }
    };
    public ActionListener greetingMailListener = new
    ActionListener() {

        //display greetings  
        public void actionPerformed(ActionEvent e) {
            frame.add(setGreeting);
            frame.add(changeGreeting);
            play.setVisible(false);
            delete.setVisible(false);
            greeting.setVisible(false);
            setGreeting.addActionListener(setGreetingListener);
            changeGreeting.addActionListener(changeGreetingListener);
            home.addActionListener(homeListener);


        }
    };
    public ActionListener setGreetingListener = new
    ActionListener() {
        //display greeting and select which one to select
        @Override
        public void actionPerformed(ActionEvent e) {
            setGreeting.setVisible(false);
            changeGreeting.setVisible(false);
            home.addActionListener(homeListener);


        }
    };
    public ActionListener changeGreetingListener = new
    ActionListener() {
        //pick a greeting and change it
        @Override
        public void actionPerformed(ActionEvent e) {

            int ext = Integer.parseInt(mailboxTextField.getText());

            Mailbox currentMailBox = mailboxSystem.getMailBox(ext);

            frame.add(greetingTextfield);
            frame.add(greeting1);
            frame.add(greetingTextfield2);
            frame.add(greeting2);
            frame.add(greetingTextfield3);
            frame.add(greeting3);

            greetingTextfield.setText(currentMailBox.getMap().get("greeting1"));
            greetingTextfield2.setText(currentMailBox.getMap().get("greeting2"));
            greetingTextfield3.setText(currentMailBox.getMap().get("greeting3"));


            setGreeting.setVisible(false);
            changeGreeting.setVisible(false);
            home.addActionListener(homeListener);
            greeting1.addActionListener(greetingListener);
            greeting2.addActionListener(greetingListener2);
            greeting3.addActionListener(greetingListener3);



        }
    };
    public ActionListener greetingListener = new
    ActionListener() {


        @Override
        public void actionPerformed(ActionEvent e) {
            int ext = Integer.parseInt(mailboxTextField.getText());

            Mailbox currentMailBox = mailboxSystem.getMailBox(ext);

            currentMailBox.updateGreeting("greeting1", greetingTextfield.getText());

        }

    };

    public ActionListener greetingListener2 = new
    ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {


            int ext = Integer.parseInt(mailboxTextField.getText());

            Mailbox currentMailBox = mailboxSystem.getMailBox(ext);

            currentMailBox.updateGreeting("greeting2", greetingTextfield.getText());

        }

    };
    public ActionListener greetingListener3 = new
    ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            int ext = Integer.parseInt(mailboxTextField.getText());

            Mailbox currentMailBox = mailboxSystem.getMailBox(ext);

            currentMailBox.updateGreeting("greeting2", greetingTextfield.getText());
        }

    };


    public ActionListener callerListener = new
    ActionListener() {

        public void actionPerformed(ActionEvent e) {
            frame.add(leaveMess);
            leaveMess.addActionListener(leaveMessListenerCaller);
            adminButton.setVisible(false);
            userButton.setVisible(false);
            frame.revalidate();
            frame.pack();
            frame.repaint();
            home.addActionListener(homeListener);


        }
    };

    public ActionListener leaveMessListenerCaller = new
    ActionListener() {


        public void actionPerformed(ActionEvent e) {


            frame.add(enterExtCaller);
            frame.add(extForCallerTextfield);
            frame.add(leaveAMessageLabel);
            frame.add(leaveAMessageTextField);
            frame.add(enterButton);
            leaveMess.setVisible(false);
            frame.revalidate();
            frame.pack();
            frame.repaint();
            enterButton.addActionListener(leaveMsgListener);
            home.addActionListener(homeListener);



        }
    };
    public ActionListener leaveMsgListener = new
    ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            int ext = Integer.parseInt(extForCallerTextfield.getText());

            mailboxSystem.leaveAMessage(ext, leaveAMessageTextField.getText());
            frame.add(messageHasbeenSetLabel);
            home.addActionListener(homeListener);


        }

    };

    public ActionListener homeListener = new
    ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            init();
            createMainMenu();
            initComponents();
        }

    };
    public static void main(String[] argu) {
        new VoiceMailSystemUi();
    }

}