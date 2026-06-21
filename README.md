# AutoTech Care - APP de Gestão Automotiva Inteligente

O **AutoTech Care** é uma aplicação desenvolvida 100% em Java voltada para a gestão inteligente de oficinas mecânicas e frotas pessoais, integrando os conceitos fundamentais da Programação Orientada a Objetos (POO) para transformar a manutenção automotiva corretiva em preventiva.

---

## 1. Introdução e Justificativa

### 1.1 Contextualização
O setor automotivo depende cada vez mais de organização, agilidade e histórico confiável dos veículos atendidos. Em oficinas mecânicas, é comum que as informações do cliente e do automóvel fiquem distribuídas em anotações manuais, planilhas ou mensagens informais, o que dificulta o acompanhamento de manutenções, revisões e falhas recorrentes. Além disso, existe a cultura de ser um serviço situacional, no qual o dono do automóvel apenas procura o mecânico quando é estritamente necessário. Diante disso, surge a necessidade de uma solução digital capaz de centralizar esses dados e apoiar a fidelidade entre dono e mecânico.

### 1.2 Descrição do Problema
Atualmente, muitos proprietários de oficinas enfrentam dificuldades para registrar e recuperar informações importantes sobre os veículos atendidos, como dono do veículo, danos anteriores e especificações do carro a ser atendido. A ausência de um controle unificado pode causar perda de dados, atrasos no atendimento, falhas no acompanhamento de serviços e dificuldade para identificar padrões de defeitos em determinados modelos de veículos.

Além disso, diversos problemas mecânicos podem ser previstos com base no histórico do automóvel e em tendências comuns daquele modelo ou versão. Quando essa análise não é feita de forma preventiva, o cliente pode continuar utilizando o veículo até que ocorra uma falha mais grave, elevando os custos de reparo e aumentando os riscos à segurança. Quando a manutenção preventiva é negligenciada, o problema costuma atingir dois pontos sensíveis para qualquer proprietário de veículo: a vida e o bolso.

### 1.3 Motivação
Este projeto é motivado por duas necessidades principais:
* A necessidade de automatizar os processos em oficinas mecânicas, melhorando a relação entre o prestador de serviço e o cliente.
* A necessidade de se mudar a cultura de ser um serviço reativo, para um serviço preventivo.

A proposta de um aplicativo com cadastro de clientes e veículos, associado a uma inteligência artificial simulada para análise de ocorrências prováveis, busca tornar o atendimento mais estratégico e eficiente. Em vez de atuar apenas de forma reativa, a oficina poderá agir preventivamente, orientando o cliente antes que o problema aconteça. Essa abordagem contribui para reduzir gastos futuros, aumentar a confiança do cliente no serviço prestado e melhorar a gestão interna da oficina. Ao automatizar também o envio de mensagens de alerta ao cliente, o sistema pode fortalecer a comunicação e incentivar o retorno para manutenção preventiva no momento adequado, criando uma cultura de fidelidade à oficina.

### 1.4 Justificativa
A criação de uma aplicação em Java para esse contexto se justifica pela relevância prática da proposta e pelo potencial de impacto direto na rotina das oficinas mecânicas, se tornando uma aplicação visível no dia a dia de muitas pessoas que diariamente necessitam ir a uma oficina, sejam colaboradores ou clientes. O sistema permitirá cadastrar e consultar informações essenciais dos veículos, organizar o histórico de atendimento e utilizar análise automatizada para indicar falhas que costumam ocorrer em determinados modelos ou condições de uso. 

Dessa forma, o projeto une organização de dados, inteligência artificial simulada e automação de comunicação em uma única plataforma, oferecendo benefícios tanto para o mecânico quanto para o cliente. Para a oficina, isso representa mais controle e eficiência operacional; já para o cliente, mais prevenção, segurança e economia monetária.

### 1.5 Objetivo Geral
Desenvolver um aplicativo em Java voltado para a gestão de oficinas mecânicas, permitindo o cadastro e o acompanhamento do histórico de veículos e clientes, utilizando inteligência artificial para identificar possíveis falhas futuras com base nas características e no histórico de cada veículo. O sistema deverá auxiliar os proprietários das oficinas na realização de manutenções preventivas, enviando notificações automáticas aos clientes sobre problemas potenciais antes que eles ocorram, contribuindo para a redução de custos com reparos, o aumento da segurança dos veículos e a melhoria do relacionamento entre a oficina e seus clientes.

### 1.6 Objetivos Específicos
* Cadastrar dados do cliente (nome, telefone, cpf) e do veículo (placa, modelo do automóvel - incluindo ano de fabricação, motorização e estilo de uso - quilometragem, problemas anteriores com o veículo).
* Manter o histórico de ocorrências e manutenções realizadas em cada automóvel.
* Integrar um mecanismo de análise inteligente para verificar padrões e indicar falhas recorrentes ou prováveis.
* Gerar recomendações preventivas com base nas informações cadastradas e no comportamento esperado do veículo.
* Automatizar o envio de mensagens ao cliente para solicitar o retorno à oficina antes que o problema se agrave.

### 1.7 Resultado Esperado
Espera-se que o sistema contribua para uma gestão mais eficiente da oficina, com registros organizados, análises mais precisas e comunicação automática com o cliente. Com isso, o projeto pretende reduzir falhas de acompanhamento, evitar gastos desnecessários e apoiar uma manutenção mais preventiva e segura.

---

## 2. Modelagem inicial:

A modelagem do sistema será composta por:

- ### Diagramas de Classes

*Primeira versão do diagrama:

![Diagrama de Classes](https://www.plantuml.com/plantuml/dpng/ZLBDQXj13BxFKmZtKAV50L-NKf8wXUPW2asRQr1cP5jqThHeDARqvtdw17s2l5Xdautj3Gxak9_s-nbzEik6QgMDpjWYmGNZMh5520IBY3bJXey_Eao1Wy0Cpel9L_8RMA2IYxGoC07bzSOWi98tbkISxwbLW2aPmIy709MSfAK6hamvhGV8g6f86iDl0GFxAeHwJUnBbAb7LMbwLvMJ1hR2mVrn3c-pANg3mR0V3tQle9L0KGwLAzX5zBZ3giG1ymCQAUCkxvO3VZEEIygK6-1aGpmbZFmJTR4X_xrqqvDd19TYelldyvRYvqZIG91o6-abQjMKT8MUuFAQb5ViiQfKpHSd-SJPHDdB4bCnIXvb5ocWOGCNQFG8KFPQFUH9JuVx7wpNfAXVA6AlBjEXbRrlVqf9ibNdo_ETO-Paqk8z3uCywRrJyPGpwjN3RtdyeDVGy-x-tlsZ39HDYnL5pkxnqYRp2Sncxs7oPZ8SGmETv5pOFNo--psRZSeUuRlEtE6ow_3qT4mwFXwuxiZ6Qw8XsNoVJ6dDsHI3t7IeU9mtt_F66stk6xXHoYNsgtHdb49futy0)

---

- ### Diagramas de Sequências

*Primeira versão do diagrama:

![Diagrama de Sequências](https://www.plantuml.com/plantuml/dpng/RP71IiD048RlUOeX8AHWmQivI6Chc8CWrZx0T3Cj0vlTCBkfley77w2Fa1Tp4hTeqCiU_ltdd-zdLY6YnBwr6Phe1TQMoKNAEbNPS8SkGbwh8WSqL7LT3XXWLyyD6yQZyq45NrUJewxcZaSE6g__J-ZwICwWdtoZdcLfAoplDBg45x8O4GAxw5k48hz71M24Ww31V97jQhNgZX8wyOP2GDb-cyDVinRZaseZKrt1CYqHKY27aBzg10fSnefdyNlSi-K66uBRcwj5dZNqEoNj7zbBSFG6_xGhDcg-JkcmxOyQtinmfkhZyvDrOcTwYrBvDOhuOf7-4_BQkmDBYyFdyE51uGBQ4xQapPLm5fmOB_SiuU6TzmJJeORpT2aWs8xpuFmqCfn5rMn5hkbR-mK0)

---

- ### Diagramas de Casos de Uso

*Primeira versão do diagrama:

![Diagrama de Caso de Uso](https://www.plantuml.com/plantuml/dpng/JSunIaD140RWVaynl4gB52RMah22MWX2JFfXtoGPcEp2p6oXuc4yW5MEy2xc9kJ9w_w1x_-PfJcgrwC4ePs35r3U7nnwLahE9GTCNXIwA4pP2MvUIxkvrMuxG8COmbbYtWj1jwfUtYaT8A8Ih3_CwTZ1Lm2eHWcjaOWzcYigR6duJLNAPMSJxwPgNOGJUrEFZFiydCmv5NXPNV5yYfz8AITk-8rqnm8zmSRgyACyZY-cVijMKVWJ5PxPV3XfspwNOibMnT6khVlm7KA4sUpXyj-OvlzfCQP6bvJxUfG_)
