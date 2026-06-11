# Tabela de descrição do Caso de Uso:

| Campo | Detalhes |
| :--- | :--- |
| **Caso de Uso** | UC-01: Realizar Diagnóstico Preliminar via IA |
| **Ator Principal** | Cliente (Motorista) |
| **Objetivo** | Permitir que o Cliente identifique falhas prováveis e registre o histórico de saúde do veículo. |
| **Pré-condição** | O objeto `Cliente` deve estar autenticado e possuir um objeto `Carro` vinculado. |
| **Fluxo Principal** | 1. O Cliente informa o sintoma.<br>2. O sistema instancia `DiagnosticoIA` para processar o texto.<br>3. A IA retorna a causa provável.<br>4. O sistema cria um novo `HistoricoManutencao` associando o `Carro` e a data (`Date`). |
| **Pós-condição** | Um registro de manutenção é persistido no histórico do veículo. |

---

## Fluxo Principal (Sucesso)

1. Cliente acessa o sistema AutoTech Care
2. Cliente seleciona a opção "Realizar Diagnóstico (IA)"
3. Sistema exibe lista de veículos cadastrados do cliente
4. Cliente seleciona um veículo
5. Sistema solicita confirmação para iniciar diagnóstico
6. Cliente confirma a operação
7. Sistema coleta dados do veículo:
    * Se for **CarroBateria**: coleta `vidaUtilMeses`
    * Se for **CarroMotor**: coleta `nivelOleo`
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

* No passo 3 do fluxo principal, se não houver veículos:
    i. Sistema exibe mensagem: "Nenhum veículo cadastrado. Cadastre um veículo primeiro"
    ii. Sistema redireciona para o caso de uso "Cadastrar Veículo"
    iii. Caso de uso é encerrado

### Fluxo A2: Cliente não salva diagnóstico

* No passo 11 do fluxo principal:
    i. Cliente seleciona "Não salvar"
    ii. Sistema exibe diagnóstico mas não chama `realizarCheckup()`
    iii. Diagnóstico não é registrado no histórico
    iv. Caso de uso é encerrado

### Fluxo A3: Veículo do tipo CarroBateria

* Durante o passo 7:
    i. Sistema identifica que o veículo é um CarroBateria
    ii. Coleta o atributo `vidaUtilMeses`
    iii. Se `vidaUtilMeses < 6` : IA sugere substituição da bateria
    iv. Se `vidaUtilMeses >= 6` : IA sugere monitoramento preventivo

### Fluxo A4: Veículo do tipo CarroMotor

* Durante o passo 7:
    i. Sistema identifica que o veículo é um CarroMotor
    ii. Coleta o atributo `nivelOleo`
    iii. Se `nivelOleo < 1.0` : IA alerta nível baixo de óleo
    iv. Se `nivelOleo >= 1.0` e `< 2.5` : IA sugere troca em breve
    v. Se `nivelOleo >= 2.5` : IA indica nível adequado

---

## Fluxos de Exceção

### Exceção E1: Falha na comunicação com IA

* Durante o passo 8 ou 9:
    i. Sistema detecta timeout ou erro na IA
    ii. Sistema exibe mensagem: "Serviço de diagnóstico indisponível no momento. Tente novamente mais tarde"
    iii. Nenhum método `realizarCheckup()` é chamado
    iv. Caso de uso é encerrado sem salvar nada

### Exceção E2: Dados do veículo incompletos

* Durante o passo 7:
    i. Sistema identifica falta de dados essenciais
    ii. Se for CarroBateria sem `vidaUtilMeses` : solicita cadastro da data de fabricação
    iii. Se for CarroMotor sem `nivelOleo` : solicita medição do óleo
    iv. Cliente informa os dados faltantes
    v. Volta ao passo 7

### Exceção E3: Veículo não implementa IVerificavel

* Durante o passo 13:
    i. Sistema tenta chamar `realizarCheckup()`
    ii. Descobre que o veículo não implementa a interface `IVerificavel`
    iii. Sistema exibe erro: "Este veículo não suporta diagnóstico automático"
    iv. Caso de uso é encerrado

---

## Requisitos Especiais

* O diagnóstico deve ser exibido em até 5 segundos
* A IA deve considerar no mínimo os últimos 12 meses de histórico
* Resultados devem incluir: nível de criticidade (Baixo/Médio/Alto), descrição do problema e sugestão de ação
* Veículos das classes `CarroBateria` e `CarroMotor` devem implementar obrigatoriamente o método `realizarCheckup()` da interface `IVerificavel`

---

## Regras de Negócio

* **RN01:** Todo veículo deve ser uma subclasse de `Carro`
* **RN02:** Todo veículo que permite diagnóstico deve implementar `IVerificavel`
* **RN03:** O diagnóstico só pode ser realizado em veículos cadastrados
* **RN04:** O histórico de diagnóstico deve persistir para consultas futuras (caso de uso "Consultar Histórico")
