# 📦 ShopSphere – Pedido-Receiver

Serviço responsável pelo recebimento de eventos de criação de pedidos e envio das informações ao sistema via RabbitMQ.

---

## 📝 Visão Geral

Ele expõe uma API RESTful para criação de pedidos e publica os dados recebidos em uma fila do RabbitMQ, permitindo que outros serviços consumam e processem os pedidos de forma assíncrona.

---

## 🛠 Funcionalidades

- Recebimento de pedidos via API REST
- Publicação de mensagens no RabbitMQ
- Validação de dados de entrada  
- Testes unitários
