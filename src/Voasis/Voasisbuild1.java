package Voasis;
import java.sql.*;
import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import java.net.URL;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Reshma
 */
public class Voasisbuild1 extends javax.swing.JFrame {
  
Timer t=new Timer();
TimerTask task=null;
TimerTask task2=null;
int initial;
String resultText;
int next;

Microphone microphone=new Microphone();
// stt thread
 Runnable r=new Runnable(){
  
   

    @Override
    public void run() {
        try{
            URL url;
           
             {
                url = Voasisbuild1.class.getResource("helloworld.config.xml");
            }

            System.out.println("Loading...");

            ConfigurationManager cm = new ConfigurationManager(url);

	   	   Recognizer recognizer = (Recognizer) cm.lookup("recognizer");

	 microphone = (Microphone) cm.lookup("microphone");


            /* allocate the resource necessary for the recognizer */
            recognizer.allocate();

            /* the microphone will keep recording until the program exits */
	    if (microphone.startRecording()) {

		while (true) {
                   
		    System.out.println
			("Start speaking.");
                    if(next==1){
                    for(int i=0;i<=60;i++)
                            System.out.println(" ");
                        
                    next=0;}
                      activate.setText("Speak 'Stimulate'");
                    /*
                     * This method will return when the end of speech
                     * is reached. Note that the endpointer will determine
                     * the end of speech.
                     */ 
		    Result result = recognizer.recognize();
		    
		    if (result != null) {
			 resultText = result.getBestFinalResultNoFiller();
                         if(num==1){
                             activate.setText("Wait for some time");
                         writer.setText(resultText);
                         copybutton.doClick(1);}
                       if(resultText.equals("stimulate")){
                                vm=VoiceManager.getInstance();
voice=vm.getVoice("mbrola_us1");
voice.allocate();
voice.speak("Voasis is activated");

voice.deallocate();
 System.out.println("Voasis is Active");
                           num=1;
                                 microphone.clear();
                                 
        b1.setVisible(false);
loading.setVisible(true);
writer.setText("");
snc.setVisible(false);
thread.resume();
                       }
System.out.println("You said: " + resultText + "\n");
		    } else {
			System.out.println("I can't hear what you said.\n");
		    }
		}
	    } else {
		System.out.println("Cannot start microphone.");
                
	    }
        } catch (Exception e) {
            System.err.println("Problem when loading HelloWorld: " + e);
            e.printStackTrace();
        } 
    }
    };
 
      Thread thread=new Thread(r);
 
      

    String address;
static Voice voice;
static VoiceManager vm=VoiceManager.getInstance();
String command;
String word;
String action;
String text;
int num;
   
    /**
     * Creates new form VoicR
     */
    public Voasisbuild1() {
     
        initComponents();
       
        next=1;
        frame1.setSize(500,475);
        frame1.setResizable(false);
        System.setProperty("mbrola.base","C:\\VoasisEX\\Mbrola");
        this.setSize(700,550);
        loading.setVisible(false);
        this.setResizable(false);
       //for date and time
        try{
        task=new TimerTask() {
            @Override
            public void run() {
                Calendar cal = Calendar.getInstance();
                cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss a");
                time.setText(sdf.format(cal.getTime()));
                Date date1=new Date();
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                date.setText(df.format(cal.getTime()));
                //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
    catch(Exception ex)
    {
        System.out.println("error in timer task");
    }
t.scheduleAtFixedRate(task,0,1000);
    
    
    vm=VoiceManager.getInstance();
voice=vm.getVoice("mbrola_us1");
voice.allocate();
voice.speak("Lets get started");
voice.deallocate();
    
thread.start();
    }       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        frame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        input = new javax.swing.JTextField();
        output = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        copybutton = new javax.swing.JButton();
        p1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        activate = new javax.swing.JLabel();
        build = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        answer = new javax.swing.JLabel();
        loading = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        writer = new javax.swing.JTextField();
        help = new javax.swing.JButton();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        snc = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Leelawadee", 0, 100)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("   Voasis");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 20, 460, 140);

        input.setBackground(new java.awt.Color(0, 0, 0));
        input.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        input.setForeground(new java.awt.Color(0, 153, 153));
        jPanel1.add(input);
        input.setBounds(20, 200, 460, 50);

        output.setBackground(new java.awt.Color(0, 0, 0));
        output.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        output.setForeground(new java.awt.Color(0, 153, 153));
        jPanel1.add(output);
        output.setBounds(20, 290, 460, 50);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Enter your voice command**");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 160, 350, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Enter what Voasis will speak");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 250, 310, 30);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 153));
        jButton2.setText("Go Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(140, 380, 130, 50);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Build 1.0");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 0, 120, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("<html>**do not give any spaces<br> in your voice command</html>");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(280, 380, 290, 50);

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 153, 153));
        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(20, 380, 110, 50);

        frame1.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        copybutton.setText("jButton4");
        copybutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copybuttonActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p1.setBackground(new java.awt.Color(0, 0, 0));
        p1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Leelawadee", 0, 100)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Voasis");
        p1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 310, 100));

        b1.setBackground(new java.awt.Color(0, 0, 0));
        b1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        b1.setForeground(new java.awt.Color(0, 153, 153));
        b1.setText("Click Here");
        b1.setActionCommand("CLICK HERE");
        b1.setBorder(null);
        b1.setOpaque(false);
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        p1.add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 250, 80));

        activate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        activate.setForeground(new java.awt.Color(0, 153, 153));
        activate.setText("Ready in a few moments");
        p1.add(activate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 270, 40));

        build.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        build.setForeground(new java.awt.Color(0, 153, 153));
        build.setText("Build 1.0");
        p1.add(build, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("         Voice Assisstant");
        p1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 260, 30));

        answer.setBackground(new java.awt.Color(0, 0, 0));
        answer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        answer.setForeground(new java.awt.Color(0, 153, 153));
        answer.setText("How can i assisst you");
        p1.add(answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 370, 40));

        loading.setText("jLabel3");
        p1.add(loading, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 420, 670, 70));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 153));
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        p1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 460, 100, 50));

        writer.setBackground(new java.awt.Color(0, 0, 0));
        writer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        writer.setForeground(new java.awt.Color(0, 153, 153));
        writer.setText("Or write here");
        writer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                writerMouseClicked(evt);
            }
        });
        writer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writerActionPerformed(evt);
            }
        });
        p1.add(writer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 370, 40));

        help.setBackground(new java.awt.Color(0, 0, 0));
        help.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        help.setForeground(new java.awt.Color(0, 153, 153));
        help.setText("Help");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        p1.add(help, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 403, 100, 50));

        time.setBackground(new java.awt.Color(0, 0, 0));
        time.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        time.setForeground(new java.awt.Color(0, 153, 153));
        p1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 160, 30));

        date.setBackground(new java.awt.Color(0, 0, 0));
        date.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        date.setForeground(new java.awt.Color(0, 153, 153));
        p1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 160, 30));

        snc.setBackground(new java.awt.Color(0, 0, 0));
        snc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        snc.setForeground(new java.awt.Color(0, 153, 153));
        snc.setText("<html>set new<br>command</html>");
        snc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sncActionPerformed(evt);
            }
        });
        p1.add(snc, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 100, -1));

        getContentPane().add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
num=1;
microphone.clear();
b1.setVisible(false);
loading.setVisible(true);
writer.setText("");
snc.setVisible(false);
thread.resume();
num=1;
    }//GEN-LAST:event_b1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
       //helpfile;
        try {
            Runtime.getRuntime().exec("notepad "+"C:\\VoasisEX\\help");
        } catch (IOException ex) {
            System.out.println("error while loading helpfile path\nset accurate address");
        }
        
    }//GEN-LAST:event_helpActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        
    }//GEN-LAST:event_formWindowActivated

    private void writerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writerActionPerformed
answer.setText("You wrote:");
        word="";
        text=writer.getText();
        text=text.toLowerCase();
//for removing spaces
for(int i=0;i<text.length();i++){
    if(text.charAt(i)==' '){
        word=word;}
    else{
        word=word+text.charAt(i);
    }}
action="";
address="";

    if(word.equals("opennotepad") || word.equals("startmakingnotes"))
{
    action="OWKEY HHIYR IHZ NOWTPAED";
    address="C:\\Windows\\System32\\notepad";
}else
            if(word.equals("openmspaint") || word.equals("createdrawing"))
{
    action="OWKEY HHIYR IHZ M S PAINT";
    address="C:\\Windows\\System32\\mspaint";
}else
            if(word.equals("opencalculator"))
{
    action="OWKEY HHIYR IHZ KAELKYAHLEYTER";
    address="C:\\Windows\\System32\\calc";
}
//for time
else
            if(word.equals("telltime"))
{
    action="the time ihz"+time.getText();
    System.out.println("success in telling time");
}
//for date
else
            if(word.equals("telldate"))
               
{
    action="the date ihz"+date.getText();
     System.out.println("success in telling date");
}
//for date and time
else
            if(word.equals("notifyme") || word.equals("telldateandtime"))
{
                  vm=VoiceManager.getInstance();
voice=vm.getVoice("mbrola_us1");
voice.allocate();
voice.speak("The time ihz"+time.getText());
voice.speak("The current date ihz"+date.getText());
voice.deallocate();
 System.out.println("success in telling time and date");
}else
                if(word.equals("showmecommands"))
               
{
    action="Owkey hhiyr ihz help";
    address="notepad "+"C:\\VoasisEX\\help";
     System.out.println("success in opening help document");
}else
                 if(word.equals("exitapplication"))
               
{
    action="Owkey byee";
    System.exit(0);
     
}  else
    if(word.equals("closecurrentwindow"))
               
{
    action="Owkey closed current window";
               try {
                   Robot r=new Robot();
                   r.keyPress(KeyEvent.VK_ALT);
                   r.keyPress(KeyEvent.VK_F4);
                   r.keyRelease(KeyEvent.VK_F4);
                   r.keyRelease(KeyEvent.VK_ALT);
               } catch (AWTException ex) {
                   Logger.getLogger(Voasisbuild1.class.getName()).log(Level.SEVERE, null, ex);
               }
     
}
                 
                 else {
                 try {
            Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","1234");
            Statement stmt=con.createStatement();
            String query="select * from voasis;";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
               if(word.equals((String)rs.getString("input"))){
                   action=(String)rs.getString("output");
               } 
                
            }
            
            con.close();
            stmt.close();
            rs.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(""+e.getMessage());
        }
                 }
//executing the given address
if(address.equals("")==false){
            try {
                
                Runtime.getRuntime().exec(address);
                System.out.println("success in opening applications");
                
            } catch (Exception ex) {
                System.out.println("error in opening application");
            }}

//for voice to text
vm=VoiceManager.getInstance();
voice=vm.getVoice("mbrola_us1");
voice.allocate();
voice.speak(action);
voice.deallocate();
b1.setVisible(true);
activate.setVisible(true);
snc.setVisible(true);
num=0;
answer.setText("How can i assisst you");
    }//GEN-LAST:event_writerActionPerformed

    private void writerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_writerMouseClicked
b1.setVisible(false);
loading.setVisible(true);
writer.setText("");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_writerMouseClicked

    private void sncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sncActionPerformed
this.setVisible(false);
frame1.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_sncActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
frame1.dispose();
this.setVisible(true);

       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void copybuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copybuttonActionPerformed
           answer.setText("You said:");
         word="";
        text=resultText;
        text=text.toLowerCase();
//for removing spaces
for(int i=0;i<text.length();i++){
    if(text.charAt(i)==' '){
        word=word;}
    else{
        word=word+text.charAt(i);
    }}
action="";
address="";
    if(word.equals("opennotepad") || word.equals("startmakingnotes"))
{
    action="OWKEY HHIYR IHZ NOWTPAED";
    address="C:\\Windows\\System32\\notepad";
}else
            if(word.equals("openpaint") || word.equals("createdrawing"))
{
    action="OWKEY HHIYR IHZ M S PAINT";
    address="C:\\Windows\\System32\\mspaint";
}else
            if(word.equals("opencalculator"))
{
    action="OWKEY HHIYR IHZ KAELKYAHLEYTER";
    address="C:\\Windows\\System32\\calc";
}

//for date and time
else
            if(word.equals("notifyme") || word.equals("telldateandtime"))
{
                  vm=VoiceManager.getInstance();
voice=vm.getVoice("mbrola_us1");
voice.allocate();
voice.speak("The time ihz"+time.getText());
voice.speak("The current date ihz"+date.getText());
voice.deallocate();
 System.out.println("success in telling time and date");
}
    else
  if(word.equals("showmecommands"))
               
{
    action="Owkey hhiyr ihz help";
    address="notepad "+"C:\\VoasisEX\\help";
     System.out.println("success in opening help document");
}
  else
  if(word.equals("exitapplication"))
               
{
    action="Owkey byee";
    System.exit(0);
     
} else
    if(word.equals("closecurrentwindow"))
               
{
    action="Owkey closed current window";
               try {
                   Robot r=new Robot();
                   r.keyPress(KeyEvent.VK_ALT);
                   r.keyPress(KeyEvent.VK_F4);
                   r.keyRelease(KeyEvent.VK_F4);
                   r.keyRelease(KeyEvent.VK_ALT);
               } catch (AWTException ex) {
                   Logger.getLogger(Voasisbuild1.class.getName()).log(Level.SEVERE, null, ex);
               }
     
}
            else{
                
                action="Please speak clearly"; 
                writer.setText("Please speak clearly");
             
            }
//executing given address
if(address.equals("")==false){
            try {
                
                Runtime.getRuntime().exec(address);
                System.out.println("success in opening applications");
                
            } catch (Exception ex) {
                System.out.println("error in opening application");
            }}

//for voice to text
vm=VoiceManager.getInstance();
voice=vm.getVoice("mbrola_us1");
voice.allocate();
voice.speak(action);
voice.deallocate();
b1.setVisible(true);
snc.setVisible(true);
writer.setText("");
num=0;
activate.setText("Speak 'Stimulate'");
answer.setText("How can i assisst you");
    }//GEN-LAST:event_copybuttonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
try {
            Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","1234");
            Statement stmt=con.createStatement();
            String query="insert into voasis values('"+input.getText()+"','"+output.getText()+"');";
            stmt.executeUpdate(query);
            System.out.println("Command inputted successfully");
            con.close();
            stmt.close();
            
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(""+e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param text
     */
     

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Voasisbuild1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Voasisbuild1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Voasisbuild1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Voasisbuild1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Voasisbuild1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activate;
    private javax.swing.JLabel answer;
    private javax.swing.JButton b1;
    private javax.swing.JLabel build;
    private javax.swing.JButton copybutton;
    private javax.swing.JLabel date;
    private javax.swing.JFrame frame1;
    private javax.swing.JButton help;
    private javax.swing.JTextField input;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JLabel loading;
    private javax.swing.JTextField output;
    private javax.swing.JPanel p1;
    private javax.swing.JButton snc;
    private javax.swing.JLabel time;
    private javax.swing.JTextField writer;
    // End of variables declaration//GEN-END:variables

    private TimerTask newTimerTask() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}