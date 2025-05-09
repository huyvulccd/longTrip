package vunh.xekhach.ContactService.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vunh.xekhach.ContactService.component.configurations.RabbitMQConfig;
import vunh.xekhach.ContactService.component.dto.NotificationMessage;

@Service
public class consumerService {
    @Autowired
//    private JavaMailSender mailSender;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_EMAIL)
    public void processEmail(NotificationMessage message) {
        System.out.println("Processing email: " + message);
        sendEmail(message.getRecipient(), message.getContent());
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_SMS)
    public void processSMS(NotificationMessage message) {
        System.out.println("Processing SMS: " + message);
        sendSms(message.getRecipient(), message.getContent());
    }

    private void sendEmail(String recipient, String content) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(recipient);
//        message.setSubject("Notification");
//        message.setText(content);
//
//        mailSender.send(message);
        System.out.println("Email sent to " + recipient);
    }

    private void sendSms(String phoneNumber, String content) {
        // TODO: Integrate with Viettel, Mobifone, or 3rd-party API
        System.out.println("Sending SMS to " + phoneNumber + ": " + content);
    }
}
