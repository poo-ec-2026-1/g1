# AutoTech Care - APP de Gestão Automotiva Inteligente

Aplicação robusta desenvolvida 100% em Java que utiliza os pilares de POO (Herança, Polimorfismo e Interfaces) para transformar a manutenção veicular corretiva em preventiva.

---

## Documentação do Projeto

<details>
<summary><b>Seção 1: Introdução e Justificativa (Clique para expandir)</b></summary>

### 1.1 Contextualização e Problema
O setor automotivo sofre com a falta de histórico unificado de manutenção em oficinas, gerando perda de dados técnicos e atrasos. A ausência de uma cultura preventiva faz com que motoristas sofram panes graves que afetam a segurança e o orçamento.

### 1.2 Motivação e Justificativa
O **AutoTech Care** centraliza dados cadastrais e de serviços, aplicando uma IA simulada para processar sintomas relatados. Isso transforma o atendimento reativo em preventivo, garantindo eficiência para a oficina e previsibilidade financeira para o condutor.

### 1.3 Objetivos
* **Geral:** Desenvolver um ecossistema Java de gestão mecânica com diagnósticos preditivos via IA simulada.
* **Específicos:** Cadastrar clientes e veículos; manter histórico cronológico; integrar mecanismo de análise inteligente; automatizar alertas de retorno.

### 1.4 Resultado Esperado
Mudança na cultura do serviço situacional para o preditivo, gerando relatórios rápidos e redução de falhas de acompanhamento.
</details>

<details>
<summary><b>Seção 2: Plano do Projeto e Escopo (Clique para expandir)</b></summary>

### 2.1 Análise de Similares
* **Drivvo:** Focado em custos e abastecimento, sem análise profunda de sintomas mecânicos.
* **Carrorama:** Alertas de calendário padrão, sem personalização por modelo.
* **Engie:** Diagnóstico direto via hardware OBD, exigindo componente físico extra.

### 2.2 Referências Técnicas e Legais
1.  **LGPD:** Tratamento seguro dos dados cadastrais (Nome, CPF, Telefone).
2.  **Normas ABNT:** Padronização de relatórios técnicos gerados.
3.  **Algoritmo de Priorização:** Ordenação de urgência de revisão baseada na quilometragem.
</details>

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
* **Henrique Brito (Líder Técnico):** Configuração de ambiente, code review de Pull Requests e gerência da `main`.
