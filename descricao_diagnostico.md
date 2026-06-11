# Descrição do Caso de Uso: Realizar Diagnóstico (IA)

| Campo | Descrição |
|-------|-----------|
| **Nome do Caso de Uso** | Realizar Diagnóstico (IA) |
| **Ator Principal** | Cliente ( Usuário do Sistema) |
| **Atores Secundários** | Sistema de IA |
| **Pré-condições** | 1. Cliente está autenticado no sistema<br>2. Cliente possui pelo menos um veículo cadastrado |
| **Pós-condições** | 1. Diagnóstico é registrado no histórico do veículo<br>2. Relatório é gerado para o cliente |

---

## Fluxo Principal (Sucesso)

1. Cliente acessa o sistema AutoTech Care
2. Cliente seleciona a opção "Realizar Diagnóstico (IA)"
3. Sistema exibe lista de veículos cadastrados do cliente
4. Cliente seleciona um veículo
5. Sistema solicita confirmação para iniciar diagnóstico
6. Cliente confirma a operação
7. Sistema coleta dados do veículo:
   - Se for **CarroBateria**: coleta vidaUtilMeses
   - Se for **CarroMotor**: coleta nivelOleo
8. Sistema aciona a IA para analisar os dados
9. IA processa as informações e identifica possíveis problemas
10. Sistema exibe resultado do diagnóstico para o cliente
11. Sistema pergunta se cliente deseja salvar o diagnóstico
12. Cliente confirma salvamento
13. Sistema chama o método `realizarCheckup()` da classe correspondente (CarroBateria ou CarroMotor)
14. Sistema registra diagnóstico no histórico do veículo

---

## Fluxos Alternativos

### Fluxo A1: Nenhum veículo cadastrado
- No passo 3 do fluxo principal, se não houver veículos:
    1. Sistema exibe mensagem: "Nenhum veículo cadastrado. Cadastre um veículo primeiro"
    2. Sistema redireciona para o caso de uso "Cadastrar Veículo"
    3. Caso de uso é encerrado

### Fluxo A2: Cliente não salva diagnóstico
- No passo 11 do fluxo principal:
    1. Cliente seleciona "Não salvar"
    2. Sistema exibe diagnóstico mas não chama `realizarCheckup()`
    3. Diagnóstico não é registrado no histórico
    4. Caso de uso é encerrado

### Fluxo A3: Veículo do tipo CarroBateria
- Durante o passo 7:
    1. Sistema identifica que o veículo é um CarroBateria
    2. Coleta o atributo `vidaUtilMeses`
    3. Se `vidaUtilMeses < 6`: IA sugere substituição da bateria
    4. Se `vidaUtilMeses >= 6`: IA sugere monitoramento preventivo

### Fluxo A4: Veículo do tipo CarroMotor
- Durante o passo 7:
    1. Sistema identifica que o veículo é um CarroMotor
    2. Coleta o atributo `nivelOleo`
    3. Se `nivelOleo < 1.0`: IA alerta nível baixo de óleo
    4. Se `nivelOleo >= 1.0 e < 2.5`: IA sugere troca em breve
    5. Se `nivelOleo >= 2.5`: IA indica nível adequado

---

## Fluxos de Exceção

### Exceção E1: Falha na comunicação com IA
- Durante o passo 8 ou 9:
    1. Sistema detecta timeout ou erro na IA
    2. Sistema exibe mensagem: "Serviço de diagnóstico indisponível no momento. Tente novamente mais tarde"
    3. Nenhum método `realizarCheckup()` é chamado
    4. Caso de uso é encerrado sem salvar nada

### Exceção E2: Dados do veículo incompletos
- Durante o passo 7:
    1. Sistema identifica falta de dados essenciais
    2. Se for CarroBateria sem `vidaUtilMeses`: solicita cadastro da data de fabricação
    3. Se for CarroMotor sem `nivelOleo`: solicita medição do óleo
    4. Cliente informa os dados faltantes
    5. Volta ao passo 7

### Exceção E3: Veículo não implementa IVerificavel
- Durante o passo 13:
    1. Sistema tenta chamar `realizarCheckup()`
    2. Descobre que o veículo não implementa a interface `IVerificavel`
    3. Sistema exibe erro: "Este veículo não suporta diagnóstico automático"
    4. Caso de uso é encerrado

---

## Requisitos Especiais
- O diagnóstico deve ser exibido em até 5 segundos
- A IA deve considerar no mínimo os últimos 12 meses de histórico
- Resultados devem incluir: nível de criticidade (Baixo/Médio/Alto), descrição do problema e sugestão de ação
- Veículos das classes `CarroBateria` e `CarroMotor` devem implementar obrigatoriamente o método `realizarCheckup()` da interface `IVerificavel`

---

## Regras de Negócio
- RN01: Todo veículo deve ser uma subclasse de `Carro`
- RN02: Todo veículo que permite diagnóstico deve implementar `IVerificavel`
- RN03: O diagnóstico só pode ser realizado em veículos cadastrados
- RN04: O histórico de diagnóstico deve persistir para consultas futuras (caso de uso "Consultar Histórico")

---

## Diagrama de Sequência

```plantuml
@startuml
title Diagrama de Sequência - Realizar Diagnóstico (IA)

actor Cliente
participant "Interface" as UI
participant "Controlador\nDiagnóstico" as Controller
participant "Carro" as Carro
participant "IA" as AI
database "Histórico" as DB

Cliente -> UI: 1. Solicitar diagnóstico
UI -> Controller: 2. iniciarDiagnostico(veiculoId)
Controller -> DB: 3. buscarVeiculo(veiculoId)
DB --> Controller: 4. veiculo (CarroBateria/CarroMotor)
Controller -> Carro: 5. coletarDados()
Carro --> Controller: 6. dados (vidaUtilMeses/nivelOleo)
Controller -> AI: 7. analisar(dados)
AI --> Controller: 8. resultadoDiagnostico
Controller -> Carro: 9. realizarCheckup()
Carro --> Controller: 10. statusCheckup
Controller -> DB: 11. salvarDiagnostico(resultado)
Controller --> UI: 12. exibirResultado(resultado)
UI --> Cliente: 13. Mostrar diagnóstico
@enduml
