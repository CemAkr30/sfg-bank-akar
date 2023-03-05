package ca.springframework.sfgbankakar.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.MessageConverter;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.template.exchange}")
    String exchange;

    @Value("${spring.rabbitmq.template.routing-key}")
    String routingKey;

    @Value("${spring.rabbitmq.template.default-receive-queue}")
    String queueName;

    private static final String secondStepQueue = "secondStepQueue";
    private static final String thirdStepQueue = "thirdStepQueue";

    private static final String secondRoute = "secondRoute";
    private static final String thirdStepRoute= "thirdStepRoute";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Queue firstStepQueue() {
        return new Queue(queueName, false);
    }

    @Bean
    public Queue secondStepQueue() {
        return new Queue(secondStepQueue, true);
    }

    @Bean
    public Queue thirdStepQueue() {
        return new Queue(thirdStepQueue, true);
    }

    @Bean
    public Binding binding(Queue firstStepQueue, DirectExchange exchange) {
        return BindingBuilder.bind(firstStepQueue).to(exchange).with(routingKey);
    }

    @Bean
    public Binding secondBinding(Queue secondStepQueue, DirectExchange exchange) {
        return BindingBuilder.bind(secondStepQueue).to(exchange).with(secondRoute);
    }

    @Bean
    public Binding thirdBinding(Queue thirdStepQueue, DirectExchange exchange) {
        return BindingBuilder.bind(thirdStepQueue).to(exchange).with(thirdStepRoute);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
