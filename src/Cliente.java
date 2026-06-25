package src;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String telefone;
    private List<Carro> veiculos;

    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Carro carro) {
        veiculos.add(carro);
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Carro> getVeiculos() {
        return veiculos;
    }
}
