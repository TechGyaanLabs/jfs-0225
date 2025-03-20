package com.careerit.cj.abstractcls;

abstract class One{
    void m1(){

    }
    void m2(){

    }
}


abstract class MessageService{
    public abstract void send(String message, String str);
}
class EmailService extends MessageService{

    @Override
    public void send(String message, String email) {
        System.out.println("Email send with message: " + message + " to " + email);
    }
}
class SmsService extends MessageService{

    @Override
    public void send(String message, String mobile) {
        System.out.println("SMS send with message: " + message + " to " + mobile);
    }
}

class Greetings{

    private MessageService messageService;
    private String message;

    public Greetings(MessageService messageService, String message) {
        this.messageService = messageService;
        this.message = message;
    }

    public void sendGreetings(String email) {
        messageService.send(message, email);
    }

}

public class GreetingManager {

    public static void main(String[] args) {

            MessageService messageService = new SmsService();
            Greetings greetings = new Greetings(messageService, "Many many happy returns of the day");
            greetings.sendGreetings("986543140");
    }
}
