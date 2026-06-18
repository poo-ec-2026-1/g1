import java.util.Scanner;
import java.util.Date;

public class InterfaceApp {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        exibirBoasVindas();

        Cliente cliente = cadastrarCliente();

        Carro carro = cadastrarVeiculo();
        cliente.adicionarVeiculo(carro);

        String sintoma = coletarSintoma(cliente, carro);
        DiagnosticoIA diagnostico = new DiagnosticoIA(sintoma);

        exibirDiagnostico(diagnostico, carro, cliente);

        menuPosDiagnostico(cliente, carro, sintoma);

        System.out.println("\n=== Obrigado por usar o AutoTech Care! ===");
        System.out.println("Seu mecânico de confiança estará em contato em breve.");
        scanner.close();
    }

    //  TELA DE BOAS-VINDAS

    private static void exibirBoasVindas() {
        System.out.println("============================================================");
        System.out.println("           ---- BEM-VINDO AO AUTOTECH CARE ----              ");
        System.out.println("     Gestão Automotiva Inteligente | Versão 1.0            ");
        System.out.println("============================================================");
        System.out.println("Olá! Vamos começar o seu atendimento.");
        System.out.println();
    }


    //  CADASTRO DE CLIENTE


    private static Cliente cadastrarCliente() {
        System.out.println("---- DADOS DO CLIENTE ----");

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Digite seu telefone (ex: 62 9 9999-9999): ");
        String telefone = scanner.nextLine().trim();

        Cliente cliente = new Cliente(nome, telefone);

        System.out.println("\nCliente cadastrado com sucesso!");
        System.out.println("Bem-vindo(a), " + nome + "!\n");

        return cliente;
    }

    //  CADASTRO DE VEÍCULO


    private static Carro cadastrarVeiculo() {
        System.out.println("---- DADOS DO VEÍCULO ----");

        System.out.print("Modelo do veículo (ex: Fiat Argo 2022): ");
        String modelo = scanner.nextLine().trim();

        System.out.print("Placa do veículo (ex: ABC-1234): ");
        String placa = scanner.nextLine().trim().toUpperCase();

        System.out.println("\nQual o tipo do veículo?");
        System.out.println("  [1] Veículo a Combustão (Motor)");
        System.out.println("  [2] Veículo Elétrico / Híbrido (Bateria)");
        System.out.print("Escolha (1 ou 2): ");

        String opcao = scanner.nextLine().trim();
        Carro carro;

        if (opcao.equals("2")) {
            System.out.print("Vida útil estimada da bateria (em meses): ");
            int vidaUtil = lerInteiroSeguro();
            carro = new CarroBateria(modelo, placa, vidaUtil);
        } else {
            System.out.print("Nível atual do óleo (em %, ex: 85.5): ");
            double nivelOleo = lerDoubleSeguro();
            carro = new CarroMotor(modelo, placa, nivelOleo);
        }

        System.out.println("\nVeículo registrado: " + modelo + " | Placa: " + placa);

        if (carro instanceof IVerificavel) {
            IVerificavel verificavel = (IVerificavel) carro;
            System.out.println("\n[Checkup Inicial]");
            System.out.println(verificavel.realizarCheckup());
        }

        System.out.println();
        return carro;
    }

    //  COLETA DE SINTOMAS

    private static String coletarSintoma(Cliente cliente, Carro carro) {
        System.out.println("---- DIAGNÓSTICO DO VEÍCULO ----");
        System.out.println("Cliente : " + cliente.getNome());
        System.out.println("Veículo : " + carro.getModelo() + " (" + carro.getPlaca() + ")");
        System.out.println();
        System.out.println("Descreva o sintoma que o seu veículo está apresentando:");
        System.out.println("(Ex: \"barulho no freio\", \"bateria fraca\", \"fumaça no motor\")");
        System.out.print("> ");

        String sintoma = scanner.nextLine().trim();

        if (sintoma.isEmpty()) {
            sintoma = "sintoma não especificado";
        }

        System.out.println("\nSintoma registrado. Processando diagnóstico...\n");
        return sintoma;
    }

    //  EXIBIÇÃO DO DIAGNÓSTICO

    private static void exibirDiagnostico(DiagnosticoIA diagnostico, Carro carro, Cliente cliente) {
        System.out.println("============================================================");
        System.out.println("              RESULTADO DO DIAGNÓSTICO                     ");
        System.out.println("============================================================");
        String resultado = diagnostico.processarSintomas();
        System.out.println(resultado);
        System.out.println("------------------------------------------------------------");

        // Registrar no histórico de manutenção
        HistoricoManutencao registro = new HistoricoManutencao(
                new Date(),
        "Diagnóstico inicial via IA - sintoma: " + resultado.split("\n")[0],
        carro
        );

        System.out.println("\n[Histórico] Atendimento salvo:");
        registro.gerarRelatorio();
        System.out.println();
    }

    //  MENU PÓS-DIAGNÓSTICO

    private static void menuPosDiagnostico(Cliente cliente, Carro carro, String sintoma) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("============================================================");
            System.out.println("                      MENU PRINCIPAL                       ");
            System.out.println("============================================================");
            System.out.println("  [1] Ver checkup completo do veículo");
            System.out.println("  [2] Registrar novo sintoma");
            System.out.println("  [3] Ver dados do cliente");
            System.out.println("  [0] Encerrar atendimento");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1":
                    exibirCheckupCompleto(carro);
                    break;
                case "2":
                    String novoSintoma = coletarSintoma(cliente, carro);
                    DiagnosticoIA novoDiagnostico = new DiagnosticoIA(novoSintoma);
                    exibirDiagnostico(novoDiagnostico, carro, cliente);
                    break;
                case "3":
                    exibirDadosCliente(cliente);
                    break;
                case "0":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }
        }
    }

    //  EXIBIÇÃO DE CHECKUP COMPLETO


    private static void exibirCheckupCompleto(Carro carro) {
        System.out.println("\n---- CHECKUP COMPLETO ----");

        // Array polimórfico com o veículo cadastrado (demonstração da AT-05-07)
        IVerificavel[] componentesParaRevisao = new IVerificavel[1];
        componentesParaRevisao[0] = (IVerificavel) carro;

        System.out.println("---- INICIANDO DIAGNÓSTICO DO VEÍCULO ----");
        for (IVerificavel item : componentesParaRevisao) {
            System.out.println(item.realizarCheckup());
            System.out.println("----------------------------------------");
        }
        System.out.println();
    }

    //  EXIBIÇÃO DE DADOS DO CLIENTE

    private static void exibirDadosCliente(Cliente cliente) {
        System.out.println("\n---- PERFIL DO CLIENTE ----");
        System.out.println("Nome     : " + cliente.getNome());
        System.out.println("Telefone : " + cliente.getTelefone());
        System.out.println("Veículos cadastrados: " + cliente.getVeiculos().size());

        for (Carro c : cliente.getVeiculos()) {
            System.out.println("  -> " + c.getModelo() + " | Placa: " + c.getPlaca());
        }
        System.out.println();
    }

    //  UTILITÁRIOS DE LEITURA SEGURA

    private static int lerInteiroSeguro() {
        while (true) {
            try {
                int valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor < 0) {
                    System.out.print("Por favor, informe um valor positivo: ");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número inteiro: ");
            }
        }
    }

    private static double lerDoubleSeguro() {
        while (true) {
            try {
                
                double valor = Double.parseDouble(
                        scanner.nextLine().trim().replace(",", ".")
                );
                if (valor < 0 || valor > 100) {
                    System.out.print("Informe um valor entre 0 e 100: ");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número (ex: 85.5): ");
            }
        }
    }
}
