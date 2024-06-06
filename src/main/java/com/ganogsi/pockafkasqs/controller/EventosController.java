package com.ganogsi.pockafkasqs.controller;

import com.ganogsi.pockafkasqs.kafka.produtor.EventoKafkaProdutor;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
@Service
public class EventosController {

    private final EventoKafkaProdutor eventoKafkaProdutor;

    @GetMapping("/enviarEvento")
    public void enviarEvento() {
        final var evento = new ProducerRecord<>("topico-teste", "chave", "valor");
        IntStream.range(0, 2000).parallel().forEach(i -> eventoKafkaProdutor.enviarEvento(evento));
    }
}
