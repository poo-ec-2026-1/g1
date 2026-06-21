import java.util.Date;
import java.text.SimpleDateFormat;

public class HistoricoManutencao {

    private Date data;
    private String descricao;
    private Carro carro;

    public HistoricoManutencao(Date data, String descricao, Carro carro) {
        this.data = data;
        this.descricao = descricao;
        this.carro = carro;
    }

    public void gerarRelatorio() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("  Data       : " + sdf.format(data));
        System.out.println("  Veículo    : " + carro.getModelo() + " (" + carro.getPlaca() + ")");
        System.out.println("  Descrição  : " + descricao);
    }

    public Carro getCarro() {
        return carro;
    }
}
