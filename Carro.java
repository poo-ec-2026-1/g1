/**
 * Classe abstrata que representa um veículo genérico no sistema AutoTech Care.
 * Serve como classe mãe para CarroBateria e CarroMotor.
 */
public abstract class Carro {

    protected String modelo;
    protected String placa;

    public Carro(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    /**
     * Método abstrato que cada subclasse deve implementar
     * para descrever o problema atual do veículo.
     */
    public abstract void apresentarProblema();
}
