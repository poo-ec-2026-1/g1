package src;

public class CarroBateria extends Carro implements IVerificavel {

    private int vidaUtilMeses;

    public CarroBateria(String modelo, String placa, int vidaUtilMeses) {
        super(modelo, placa);
        this.vidaUtilMeses = vidaUtilMeses;
    }

    @Override
    public String realizarCheckup() {
        return "Checkup Elétrico [" + modelo + "]: Verificando voltagem e saúde da bateria.\n"
             + "Vida útil estimada: " + vidaUtilMeses + " meses.";
    }

    @Override
    public void apresentarProblema() {
        System.out.println("Veículo elétrico " + modelo + " - Placa: " + placa
                + " | Vida útil da bateria: " + vidaUtilMeses + " meses.");
    }
}
