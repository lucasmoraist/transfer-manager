# Transfer Manager Service

Microserviço orquestrador responsável por receber solicitações de transferência, realizar validações iniciais e despachar eventos para processamento assíncrono.

## 🚀 Visão Geral

O **Transfer Manager** é o ponto de entrada (Gateway) para operações de transferência. Ele garante que a requisição seja recebida, validada e enfileirada, desacoplando o recebimento do processamento financeiro.

**Principais Responsabilidades:**
- Receber requisição de transferência (`POST /transfer`).
- Validar existência de usuários (comunicação síncrona via Feign Client com Wallet Core).
- Publicar intenção de transferência no RabbitMQ.
- Atualizar status da transferência baseada no retorno do processamento.

## 🛠 Tecnologias Utilizadas

- **Java 21** & **Spring Boot 3**
- **Spring Cloud OpenFeign** (Comunicação síncrona entre serviços)
- **Spring Cloud Stream** (RabbitMQ Binder)
- **PostgreSQL** (Persistência de histórico de transações)
- **Lombok** & **Validation API**

## 🔌 Endpoints (API REST)

### Realizar Transferência
`POST /api/v1/transfer`

**Body:**
```json
{
  "payerId": "uuid-do-pagador",
  "payeeId": "uuid-do-beneficiario",
  "amount": 100.00
}
```

## 📨 Arquitetura de Eventos

- Producer: Envia mensagem para fila wallet.processing com routing key transfer.created.
- Consumer: Escuta filas de feedback para atualizar o status no banco local:
  - transfer.success -> Atualiza status para COMPLETED.
  - transfer.failed -> Atualiza status para ERROR.

## 🔮 Melhorias Futuras
- [ ] Implementar Circuit Breaker (Resilience4j) na chamada do Feign Client (caso o Wallet Core caia).
- [ ] Adicionar Idempotência (Chave única por transação para evitar duplicação de pagamentos).
- [ ] Implementar Distributed Tracing (Micrometer/Zipkin) para rastrear o traceId entre serviços.
- [ ] Criar endpoint GET /transfer/{id}/status para Polling do Frontend.