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

    public abstract void apresentarProblema();
}
