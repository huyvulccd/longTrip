package nhvu.xekhach.UserSite.logic;

import lombok.RequiredArgsConstructor;
import nhvu.xekhach.UserSite.component.configurations.RabbitMQConfig;
import nhvu.xekhach.UserSite.component.dto.NotificationMessage;
import nhvu.xekhach.UserSite.component.dto.response.OTPInformation;
import nhvu.xekhach.UserSite.component.enums.NotificationType;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendNotification(NotificationMessage message) {
        if (message.getType() == NotificationType.EMAIL) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "email.routing.key", message);
        } else if (message.getType() == NotificationType.SMS) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "sms.routing.key", message);
        }
        System.out.println("Sent to queue: " + message);
    }

    public void storeOtp(OTPInformation information) {
        NotificationMessage notification = new NotificationMessage(NotificationType.SMS, information.getPhoneNumber(),
                information.getOtpCode());
        sendNotification(notification);
    }
}
