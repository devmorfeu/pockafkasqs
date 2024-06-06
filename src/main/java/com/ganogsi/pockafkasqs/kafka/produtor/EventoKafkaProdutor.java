package com.ganogsi.pockafkasqs.kafka.produtor;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventoKafkaProdutor {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void enviarEvento(final ProducerRecord<String, String> mensagem) {
        try {
            kafkaTemplate.send(mensagem).get();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar evento para o Kafka", e);
        }
    }
}
