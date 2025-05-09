package nhvu.xekhach.UserSite.component.configurations;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE = "notificationExchange";

    // Queues for different types of notifications
    public static final String NOTIFICATION_QUEUE = "notificationQueue";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(NOTIFICATION_QUEUE, true);
    }

    @Bean
    public Binding binding(Queue notificationQueue, DirectExchange exchange) {
        return BindingBuilder.bind(notificationQueue).to(exchange).with("notification.routing.key");
    }
}
