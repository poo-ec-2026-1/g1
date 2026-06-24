# AutoTech Care - APP de Gestão Automotiva Inteligente

Aplicação robusta desenvolvida 100% em Java que utiliza os pilares de POO (Herança, Polimorfismo e Interfaces) para transformar a manutenção veicular corretiva em preventiva.

---

## 1. Introdução e Justificativa

### 1.1 Contextualização e Descrição do Problema
O setor automotivo depende cada vez mais de organização, agilidade e histórico confiável dos veículos atendidos. Em oficinas mecânicas, é comum que as informações do cliente e do automóvel fiquem distribuídas em anotações manuais, planilhas ou mensagens informais. Isso dificulta o acompanhamento de manutenções, revisões e falhas recorrentes, além de reforçar a cultura de um serviço estritamente situacional, onde o proprietário apenas procura o mecânico em casos de pane.

Atualmente, muitos gestores enfrentam sérias dificuldades para registrar e recuperar dados críticos (como histórico de danos anteriores e especificações de cada modelo). A ausência de um controle unificado causa perda de informações, atrasos no atendimento e impede a identificação de padrões de defeito. Quando a análise preventiva é negligenciada, o cliente continua rodando até que ocorra uma quebra grave, afetando diretamente dois pontos sensíveis: a segurança da vida e o bolso do proprietário.

### 1.2 Motivação e Justificativa
Este projeto é motivado pela oportunidade de transformar a postura reativa do mercado em uma abordagem preventiva e estratégica. A criação de uma aplicação Java justifica-se pelo seu impacto prático imediato na rotina de colaboradores e clientes de oficinas mecânicas. 

Ao unificar o cadastro de usuários e frotas a uma estrutura que analisa sintomas, o sistema ajuda a prever falhas lógicas e estruturais antes que elas aconteçam. Para a oficina, isso representa controle operacional e fidelização; para o cliente, resulta em economia, previsibilidade e preservação do patrimônio.

### 1.3 Objetivos do Sistema
* **Objetivo Geral:** Desenvolver um aplicativo em Java voltado para a gestão de oficinas mecânicas, permitindo o cadastro e o acompanhamento do histórico de veículos e clientes através de uma inteligência artificial simulada para identificar possíveis falhas futuras com base nas características e no comportamento de cada automóvel.
* **Objetivos Específicos:**
  * Cadastrar de forma estruturada os dados do cliente (nome, telefone, CPF) e do veículo (placa, modelo, motorização, quilometragem e estilo de uso).
  * Manter a rastreabilidade histórica de ocorrências e serviços executados em tempo real.
  * Integrar um mecanismo analítico inteligente para processar sintomas e indicar falhas recorrentes.
  * Automatizar o aviso proativo e recomendações de retorno ao cliente antes que os problemas se agravem.

### 1.4 Resultado Esperado
Espera-se que o software mude a cultura do serviço situacional para o preditivo. O sistema deve entregar registros organizados, diagnósticos rápidos de componentes críticos (como motor e bateria) e um acompanhamento transparente que minimize falhas humanas e otimize custos.

---

## 2. Plano do Projeto e Escopo do Sistema

### 2.1 Análise de Produtos Similares do Mercado
Para balizar o desenvolvimento técnico e os diferenciais do ecossistema, mapeamos três concorrentes diretos:
* **Drivvo:** Excelente para gestão financeira de custos e abastecimento, mas carece de uma análise lógica estruturada sobre os sintomas mecânicos do veículo.
* **Carrorama:** Aplicativo focado em alertas de calendário e lembretes de revisão padrão, sem personalização analítica por modelo ou tipo de componente.
* **Engie:** Realiza o diagnóstico direto do motor via hardware OBD, exigindo um componente físico extra plugado fisicamente ao automóvel.

### 2.2 Referências Técnicas e Legais
O projeto está estruturado em conformidade com as seguintes diretrizes de engenharia:
1. **Conformidade com a LGPD:** Tratamento seguro e privacidade dos dados cadastrais (nome, telefone e CPF) presentes na classe de identificação.
2. **Normas da ABNT:** Padronização rigorosa da documentação técnica e relatórios gerados.
3. **Algoritmos de Priorização:** Lógica polimórfica para ordenar de forma automatizada a urgência de manutenção com base na quilometragem e severidade de uso do carro.

---

## 3. Modelagem e Arquitetura do Sistema

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

---

## 4. Planejamento de Atividades e Equipe

* **Matheus Brandão (Arquiteto):** Documentação, Markdown e modelagem UML (`docs/` e `diagramas/`).
* **Derick Catissi (Backend):** Estrutura das entidades do domínio, herança e contratos de interface (`src/`).
* **Pedro Victor (Frontend):** Interface de Linha de Comando (CLI), captura de inputs via `Scanner` e fluxo de menus.
* **Breno Cordeiro (QA/Testes):** Elaboração da suíte de testes automatizados e validação de polimorfismo.
* **Henrique Brito (Líder Técnico):** Configuração de ambiente, code review de Pull Requests e gerência da brach`main`.
