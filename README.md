# BoxFlow

Sistema de gestão de assinaturas de caixas femininas, desenvolvido para controlar clientes, planos, estoque de produtos e envios mensais.

## Sobre o projeto

Minha esposa tem um negócio onde envia caixas de produtos femininos por assinatura todo mês. Cada cliente tem um plano com data de vencimento, e ela precisava de uma forma de controlar tudo isso sem depender de planilha. Decidi construir esse sistema do zero como projeto prático, aproveitando para aplicar arquitetura de microsserviços de forma real.

## Arquitetura

O sistema é dividido em microsserviços independentes, cada um com sua própria responsabilidade:

- **eureka-server** — servidor de registro e descoberta de serviços
- **gateway** — porta de entrada única da aplicação, roteia as requisições para o serviço correto
- **ms-clientes** — gestão de clientes e assinaturas (em desenvolvimento)
- **ms-produtos** — controle de estoque de produtos (em desenvolvimento)
- **ms-caixas** — montagem e histórico de envios (em desenvolvimento)
- **ms-notificacoes** — alertas automáticos por e-mail via AWS SES (em desenvolvimento)

## Stack

- Java 17
- Spring Boot 3.5
- Spring Cloud Gateway
- Netflix Eureka
- Spring Data JPA
- PostgreSQL
- RabbitMQ
- AWS SES
- Docker

## Como rodar localmente

Em breve.

## Status

Projeto em desenvolvimento ativo.
