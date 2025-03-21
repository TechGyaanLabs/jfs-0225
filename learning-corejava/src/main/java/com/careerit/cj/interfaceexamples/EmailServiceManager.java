package com.careerit.cj.interfaceexamples;

import java.util.List;

class EmailContent{
    private String subject;
    private String message;
    private List<String> to;
    private List<String> cc;
    private List<String> bcc;
}
interface EmailService {
    EmailContent prepareEmail(EmailContent emailContent);
    void send(EmailContent emailContent);
}
abstract class AbstractEmailService implements EmailService{
    @Override
    public EmailContent prepareEmail(EmailContent emailContent) {
        //Logic
        return emailContent;
    }

}
class SendGrid extends  AbstractEmailService implements EmailService{

    @Override
    public void send(EmailContent emailContent) {
        // Logic send email
    }
}
class Smtp extends AbstractEmailService implements EmailService{

    @Override
    public void send(EmailContent emailContent) {
        // Logic send email
    }
}
class Ses extends AbstractEmailService implements EmailService{

    @Override
    public void send(EmailContent emailContent) {
        // Logic send email
    }
}

public class EmailServiceManager {

}
