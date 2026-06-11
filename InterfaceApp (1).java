import java.util.Scanner;
import java.util.Date;

/**
 * ============================================================
 *  InterfaceApp.java — AutoTech Care
 *  Desenvolvedor Frontend (CLI): Pedro Victor Alencar De Aquino
 *  Branch: feat/frontend-cli
 * ============================================================
 *
 * Esta classe é o ponto de entrada da aplicação AutoTech Care
 * no terminal. Responsável por toda a interação com o usuário:
 * captura de dados do cliente, cadastro do veículo e acionamento
 * do módulo de diagnóstico por inteligência artificial.
 *
 * Conceitos de POO aplicados:
 *  - Instanciação de objetos (Cliente, Carro, DiagnosticoIA)
 *  - Polimorfismo via interface IVerificavel
 *  - Encapsulamento: dados do cliente protegidos na classe Cliente
 */
public class InterfaceApp {

    // Scanner compartilhado por todos os métodos da interface
    private static final Scanner scanner = new Scanner(System.in);

    // -------------------------------------------------------
    //  PONTO DE ENTRADA
    // -------------------------------------------------------

    public static void main(String[] args) {
        exibirBoasVindas();

        // 1. Cadastrar cliente
        Cliente cliente = cadastrarCliente();

        // 2. Cadastrar veículo
        Carro carro = cadastrarVeiculo();
        cliente.adicionarVeiculo(carro);

        // 3. Iniciar diagnóstico via IA
        String sintoma = coletarSintoma(cliente, carro);
        DiagnosticoIA diagnostico = new DiagnosticoIA(sintoma);

        // 4. Exibir diagnóstico e salvar no histórico
        exibirDiagnostico(diagnostico, carro, cliente);

        // 5. Menu pós-diagnóstico
        menuPosDiagnostico(cliente, carro, sintoma);

        System.out.println("\n=== Obrigado por usar o AutoTech Care! ===");
        System.out.println("Seu mecânico de confiança estará em contato em breve.");
        scanner.close();
    }

    // -------------------------------------------------------
    //  TELA DE BOAS-VINDAS
    // -------------------------------------------------------

    /**
     * Exibe o cabeçalho da aplicação no terminal.
     */
    private static void exibirBoasVindas() {
        System.out.println("============================================================");
        System.out.println("           --- BEM-VINDO AO AUTOTECH CARE ---              ");
        System.out.println("     Gestão Automotiva Inteligente | Versão 1.0            ");
        System.out.println("============================================================");
        System.out.println("Olá! Seja bem-vindo!");
        System.out.println("Vamos iniciar o cadastro do cliente e do veículo.");
        System.out.println();
    }

    // -------------------------------------------------------
    //  CADASTRO DE CLIENTE
    // -------------------------------------------------------

    /**
     * Solicita ao usuário os dados pessoais e retorna um objeto Cliente.
     *
     * @return Cliente com nome e telefone preenchidos
     */
    private static Cliente cadastrarCliente() {
        System.out.println("--- DADOS DO CLIENTE ---");

        String nome;

    do {
    System.out.print("Digite seu nome: ");
    nome = scanner.nextLine().trim();

       if(nome.isEmpty()) {
        System.out.println("Nome não pode ficar vazio.");
    }

    } while(nome.isEmpty());

        System.out.print("Digite seu telefone (ex: 62 9 9999-9999): ");
        String telefone = scanner.nextLine().trim();

        Cliente cliente = new Cliente(nome, telefone);

        System.out.println("\nCliente cadastrado com sucesso!");
        System.out.println("Bem-vindo(a), " + nome + "!\n");

        return cliente;
    }

    // -------------------------------------------------------
    //  CADASTRO DE VEÍCULO
    // -------------------------------------------------------

    /**
     * Solicita modelo, placa e tipo do veículo.
     * Instancia CarroBateria ou CarroMotor conforme a escolha do usuário,
     * demonstrando polimorfismo via classe abstrata Carro.
     *
     * @return Carro instanciado (CarroBateria ou CarroMotor)
     */
    private static Carro cadastrarVeiculo() {
        System.out.println("--- DADOS DO VEÍCULO ---");

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

        // Polimorfismo: checkup via interface IVerificavel
        if (carro instanceof IVerificavel) {
            IVerificavel verificavel = (IVerificavel) carro;
            System.out.println("\n[Checkup Inicial]");
            System.out.println(verificavel.realizarCheckup());
        }

        System.out.println();
        return carro;
    }

    // -------------------------------------------------------
    //  COLETA DE SINTOMAS
    // -------------------------------------------------------

    /**
     * Abre o campo de texto para o cliente descrever o sintoma do veículo.
     * Este input aciona o módulo DiagnosticoIA.
     *
     * @param cliente Cliente cadastrado
     * @param carro   Veículo cadastrado
     * @return String com o sintoma descrito pelo usuário
     */
    private static String coletarSintoma(Cliente cliente, Carro carro) {
        System.out.println("--- DIAGNÓSTICO DO VEÍCULO ---");
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

    // -------------------------------------------------------
    //  EXIBIÇÃO DO DIAGNÓSTICO
    // -------------------------------------------------------

    /**
     * Exibe o resultado do DiagnosticoIA formatado para o terminal
     * e salva o atendimento no histórico de manutenção.
     *
     * @param diagnostico Objeto DiagnosticoIA com o sintoma processado
     * @param carro       Veículo relacionado ao diagnóstico
     * @param cliente     Cliente responsável pelo veículo
     */
    private static void exibirDiagnostico(DiagnosticoIA diagnostico, Carro carro, Cliente cliente) {
        System.out.println("============================================================");
        System.out.println("              RESULTADO DO DIAGNÓSTICO                     ");
        System.out.println("============================================================");
        System.out.println(diagnostico.processarSintomas());
        System.out.println("------------------------------------------------------------");

        // Registrar no histórico de manutenção
        HistoricoManutencao registro = new HistoricoManutencao(
                new Date(),
                "Diagnóstico inicial via IA - sintoma: " + diagnostico.processarSintomas().split("\n")[0],
                carro
        );

        System.out.println("\n[Histórico] Atendimento salvo:");
        registro.gerarRelatorio();
        System.out.println();
    }

    // -------------------------------------------------------
    //  MENU PÓS-DIAGNÓSTICO
    // -------------------------------------------------------

    /**
     * Menu exibido após o diagnóstico, permitindo ao usuário
     * consultar o checkup completo do veículo ou encerrar.
     *
     * @param cliente Cliente da sessão
     * @param carro   Veículo da sessão
     * @param sintoma Sintoma relatado
     */
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

    // -------------------------------------------------------
    //  EXIBIÇÃO DE CHECKUP COMPLETO
    // -------------------------------------------------------

    /**
     * Exibe o checkup detalhado do veículo usando polimorfismo.
     * Itera sobre os componentes verificáveis do carro via IVerificavel.
     *
     * @param carro Veículo a ser inspecionado
     */
    private static void exibirCheckupCompleto(Carro carro) {
        System.out.println("\n--- CHECKUP COMPLETO ---");

        // Array polimórfico com o veículo cadastrado (demonstração da AT-05-07)
        IVerificavel[] componentesParaRevisao = new IVerificavel[1];
        componentesParaRevisao[0] = (IVerificavel) carro;

        System.out.println("--- INICIANDO DIAGNÓSTICO DO VEÍCULO ---");
        for (IVerificavel item : componentesParaRevisao) {
            System.out.println(item.realizarCheckup());
            System.out.println("----------------------------------------");
        }
        System.out.println();
    }

    // -------------------------------------------------------
    //  EXIBIÇÃO DE DADOS DO CLIENTE
    // -------------------------------------------------------

    /**
     * Exibe um resumo dos dados cadastrais do cliente e seus veículos.
     *
     * @param cliente Cliente da sessão atual
     */
    private static void exibirDadosCliente(Cliente cliente) {
        System.out.println("\n--- PERFIL DO CLIENTE ---");
        System.out.println("Nome     : " + cliente.getNome());
        System.out.println("Telefone : " + cliente.getTelefone());
        System.out.println("Veículos cadastrados: " + cliente.getVeiculos().size());

        for (Carro c : cliente.getVeiculos()) {
            System.out.println("  -> " + c.getModelo() + " | Placa: " + c.getPlaca());
        }
        System.out.println();
    }

    // -------------------------------------------------------
    //  UTILITÁRIOS DE LEITURA SEGURA
    // -------------------------------------------------------

    /**
     * Lê um número inteiro com tratamento de entrada inválida.
     *
     * @return inteiro válido digitado pelo usuário
     */
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

    /**
     * Lê um número decimal (double) com tratamento de entrada inválida.
     *
     * @return double válido digitado pelo usuário
     */
    private static double lerDoubleSeguro() {
        while (true) {
            try {
                // Aceita tanto vírgula quanto ponto como separador decimal
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
