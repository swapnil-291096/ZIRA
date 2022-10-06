package com.ZIRA.qa.util;

import javax.mail.*;
import javax.mail.search.SubjectTerm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailVerification

{
    private boolean textIsHtml = false;
    static String URL;
    /**
     * Return the primary text content of the message.
     */
    private String getSourceText(Part p) throws MessagingException, IOException {

        System.out.println("Content Type Is -"+p.getContentType());

        if (p.isMimeType("text/html"))
        {
            //System.out.println("TYPE-text/html");
            String s = (String)p.getContent();
            textIsHtml = p.isMimeType("text/html");
            return s;
        }

        if (p.isMimeType("multipart/alternative"))
        {
            //System.out.println("TYPE-multipart/alternative");
            // prefer html text over plain text
            Multipart mp = (Multipart)p.getContent();
            String text = null;
            for (int i = 0; i < mp.getCount(); i++)
            {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain"))
                {
                    //System.out.println("SUB TYPE-text/plain");
                    if (text == null)
                        text = getSourceText(bp);
                    continue;
                }
                else if (bp.isMimeType("text/html"))
                {
                    //System.out.println("SUB TYPE-text/html");
                    String s = getSourceText(bp);
                    if (s != null)
                        return s;
                }
                else
                {
                    return getSourceText(bp);
                }
            }
            return text;
        }
        else if (p.isMimeType("multipart"))
        {
            //System.out.println("TYPE-multipart");
            Multipart mp = (Multipart)p.getContent();
            for (int i = 0; i < mp.getCount(); i++)
            {
                String s = getSourceText(mp.getBodyPart(i));
                if (s != null)
                    return s;
            }
        }
        return null;
    }



    public String getMailData(String foldername,String subjectName, String username, String password) throws Exception {
        //Multipart_Sample m=new Multipart_Sample();
        Properties props = System.getProperties();

        props.setProperty("mail.store.protocol", "imaps");

        Session session = Session.getDefaultInstance(props, null);
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com", username,password);

        Folder folder = store.getFolder(foldername);
        folder.open(Folder.READ_WRITE);

        System.out.println("Total Message:" + folder.getMessageCount());
        System.out.println("Unread Message:"
                + folder.getUnreadMessageCount());

        Message[] messages = null;
        boolean isMailFound = false;
        Message mailFromGod= null;

        //Search for mail from God
        for (int i = 0;i<5;i++) {
            messages = folder.search(new SubjectTerm(subjectName),folder.getMessages());
            //System.out.println("message -"+messages.toString());
            //Wait for 10 seconds
            if (messages.length == 0) {
                Thread.sleep(2000);
            }
        }

        //Search for unread mail from God
        //This is to avoid using the mail for which Registration is already done
        for (Message mail : messages) {
            if (!mail.isSet(Flags.Flag.SEEN)) {
                mailFromGod = mail;
                System.out.println("Message Count is: "+ mailFromGod.getMessageNumber());
                //System.out.println(""+mailFromGod.isMimeType("text/html"));
                isMailFound = true;
            }
        }

        // System.out.println("from get "+m.getText(mailFromGod));


        //Test fails if no unread mail was found from God
        if (!isMailFound) {
            throw new Exception(
                    "Could not find new mail from Inbox :-(");

            //Read the content of mail and launch registration URL
        } else {

            //System.out.println("Data "+m.getText(mailFromGod));


            String s=getSourceText(mailFromGod);
            int startindex=s.indexOf("Hi");
            int endindex=s.indexOf("Team",startindex);
            URL=s.substring(startindex,endindex);
            System.out.println("");
            System.out.println(URL);




        }
        return URL;

    }

    // Function to extract all the URL
    // from the string
    public String extractURL(String str) {
        String forgotPasswordUrl;

        // Creating an empty ArrayList
        List<String> list = new ArrayList<>();

        // Regular Expression to extract
        // URL from the string
        String regex = "\\b((?:https?|ftp|file):" + "//[-a-zA-Z0-9+&@#/%?=" + "~_|!:, .;]*[-a-zA-Z0-9+" + "&@#/%=~_|])";

        // Compile the Regular Expression
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        // Find the match between string
        // and the regular expression
        Matcher m = p.matcher(str);

        // Find the next subsequence of
        // the input subsequence that
        // find the pattern
        while (m.find()) {

            // Find the substring from the
            // first index of match result
            // to the last index of match
            // result and add in the list
            list.add(str.substring(
                    m.start(0), m.end(0)));
        }

        // IF there no URL present
        if (list.size() == 0) {
            System.out.println("-1");
            return regex;
        }

        // Print all the URLs stored
        for (String url : list) {
            System.out.println(url);
            regex = url;
        }
        return regex;
    }

//    // Driver Code
//    public static void main(String args[]) throws Exception {
//        EmailVerification a = new EmailVerification();
//        a.getMailData("ZIRA", "ZIRA - Reset Password", "swapnil.shinde@mobifilia.com", "Ss@9527810513");
//
//        // Given String str
//        String str = URL;
//
//        // Function Call
//        extractURL(str);
//    }


}


