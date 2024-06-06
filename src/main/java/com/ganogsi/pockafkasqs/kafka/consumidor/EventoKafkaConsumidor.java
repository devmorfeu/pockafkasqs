package com.ganogsi.pockafkasqs.kafka.consumidor;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventoKafkaConsumidor {

    @KafkaListener(topics = "topico-teste", groupId = "grupo-teste")
    @ConditionalOnProperty(value = "kafka.consumer.enabled", havingValue = "true")
    public void consumirEvento(final ConsumerRecord<String, String> evento) {
        System.out.println("Evento recebido: " + evento.value());
    }
}
