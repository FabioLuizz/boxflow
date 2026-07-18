package com.boxflow.msnotificacoes.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

@Service
public class EmailService {

    @Value("${aws.ses.access-key}")
    private String accessKey;

    @Value("${aws.ses.secret-key}")
    private String secretKey;

    @Value("${aws.ses.remetente}")
    private String remetente;

    @Value("${aws.ses.region}")
    private String region;

    public void enviarEmail(String destinatario, String assunto, String corpo) {
        SesClient sesClient = SesClient.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKey, secretKey)))
                .build();

        SendEmailRequest request = SendEmailRequest.builder()
                .destination(Destination.builder()
                        .toAddresses(destinatario)
                        .build())
                .message(Message.builder()
                        .subject(Content.builder().data(assunto).build())
                        .body(Body.builder()
                                .text(Content.builder().data(corpo).build())
                                .build())
                        .build())
                .source(remetente)
                .build();

        sesClient.sendEmail(request);
    }
}