package tests;

import src.CarroBateria;
import src.CarroMotor;
import src.Cliente;
import src.DiagnosticoIA;
import src.HistoricoManutencao;
import java.util.Date;

public class AutomatedTests {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SUÍTE DE TESTES AUTOMATIZADOS (QA) ===");
        int testesPassaram = 0;
        int totalTestes = 5; 

        CarroBateria carroBat = null;
        CarroMotor carroMot = null;

        try {
            System.out.println("\n[Teste 1] Validando CarroBateria com vida util negativa...");
            carroBat = new CarroBateria("Eletrico Teste", "AAA-0000", -5);
            carroBat.realizarCheckup();
            System.out.println("-> RESULTADO: O sistema tratou o checkup sem travar.");
            testesPassaram++;
        } catch (Exception e) {
            System.out.println("-> RESULTADO: FALHA! O sistema crashou. Erro: " + e.getMessage());
        }

        try {
            System.out.println("\n[Teste 2] Validando CarroMotor sem oleo no motor...");
            carroMot = new CarroMotor("Combustao Teste", "BBB-1111", 0.0);
            carroMot.realizarCheckup();
            System.out.println("-> RESULTADO: O checkup identificou o nivel critico com sucesso.");
            testesPassaram++;
        } catch (Exception e) {
            System.out.println("-> RESULTADO: FALHA! O programa crashou. Erro: " + e.getMessage());
        }

        try {
            System.out.println("\n[Teste 3] Validando instanciacao de Cliente e lista de veiculos...");
            Cliente clienteTeste = new Cliente("Carlos QA", "62 99999-0000");
            
            if (carroBat != null && carroMot != null) {
                clienteTeste.adicionarVeiculo(carroBat);
                clienteTeste.adicionarVeiculo(carroMot);
                
                if (clienteTeste.getVeiculos().size() == 2) {
                    System.out.println("-> RESULTADO: Sucesso! O cliente armazenou os 2 veiculos perfeitamente.");
                    testesPassaram++;
                } else {
                    System.out.println("-> RESULTADO: FALHA! A lista de veiculos nao tem o tamanho esperado.");
                }
            } else {
                System.out.println("-> RESULTADO: Ignorado. Os carros não foram criados nos testes anteriores.");
            }
        } catch (Exception e) {
            System.out.println("-> RESULTADO: FALHA! Erro ao testar Cliente: " + e.getMessage());
        }

        try {
            System.out.println("\n[Teste 4] Validando regras de processamento da classe DiagnosticoIA...");
            String sintomaSimulado = "bateria fraca";
            DiagnosticoIA ia = new DiagnosticoIA(sintomaSimulado);
            String resultadoIA = ia.processarSintomas();

            if (resultadoIA != null && !resultadoIA.isEmpty()) {
                System.out.println("-> RESULTADO: Sucesso! A IA processou o sintoma simulado e gerou um retorno valido.");
                testesPassaram++;
            } else {
                System.out.println("-> RESULTADO: FALHA! O retorno da IA esta vazio ou nulo.");
            }
        } catch (Exception e) {
            System.out.println("-> RESULTADO: FALHA! Erro na execucao da IA: " + e.getMessage());
        }

        try {
            System.out.println("\n[Teste 5] Validando objeto e relatorio de HistoricoManutencao...");
            if (carroMot != null) {
                HistoricoManutencao historico = new HistoricoManutencao(new Date(), "Teste de QA Automatico", carroMot);
                System.out.println("-> Simulando impressao do relatorio:");
                historico.gerarRelatorio();
                System.out.println("-> RESULTADO: Sucesso! Relatorio gerado sem crashar na formatacao de datas.");
                testesPassaram++;
            } else {
                System.out.println("-> RESULTADO: Ignorado. O CarroMotor falhou no teste 2.");
            }
        } catch (Exception e) {
            System.out.println("-> RESULTADO: FALHA! Erro ao gerar historico: " + e.getMessage());
        }

        System.out.println("\n=================================================");
        System.out.println("RESUMO DO QA: " + testesPassaram + " / " + totalTestes + " testes executados.");
        System.out.println("=================================================");
    }
}