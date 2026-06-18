public class CarroMotor extends Carro implements IVerificavel {

    private double nivelOleo;

    public CarroMotor(String modelo, String placa, double nivelOleo) {
        super(modelo, placa);
        this.nivelOleo = nivelOleo;
    }

    @Override
    public String realizarCheckup() {
        return "Checkup Mecânico [" + modelo + "]: Verificando viscosidade do óleo e temperatura.\n"
             + "Nível atual do óleo: " + nivelOleo + "%.";
    }

    @Override
    public void apresentarProblema() {
        System.out.println("Veículo a combustão " + modelo + " - Placa: " + placa
                + " | Nível de óleo: " + nivelOleo + "%.");
    }
}
