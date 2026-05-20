# Tabela de descrição do Caso de Uso:

| Campo | Detalhes |
| :--- | :--- |
| **Caso de Uso** | UC-01: Realizar Diagnóstico Preliminar via IA |
| **Ator Principal** | Cliente (Motorista) |
| **Objetivo** | Permitir que o Cliente identifique falhas prováveis e registre o histórico de saúde do veículo. |
| **Pré-condição** | O objeto `Cliente` deve estar autenticado e possuir um objeto `Carro` vinculado. |
| **Fluxo Principal** | 1. O Cliente informa o sintoma.<br>2. O sistema instancia `DiagnosticoIA` para processar o texto.<br>3. A IA retorna a causa provável.<br>4. O sistema cria um novo `HistoricoManutencao` associando o `Carro` e a data (`Date`). |
| **Pós-condição** | Um registro de manutenção é persistido no histórico do veículo. |
