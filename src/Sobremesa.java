public class Sobremesa extends ItemMenu {
    private String tipoSobremesa;

    public Sobremesa() {
    }

    public Sobremesa(String nome, String descricao, double preco, String tipoSobremesa) {
        super(nome, descricao, preco);
        this.tipoSobremesa = tipoSobremesa;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println(this.tipoSobremesa);
    }

    public String getTipoSobremesa() {
        return tipoSobremesa;
    }

    public void setTipoSobremesa(String tipoSobremesa) {
        this.tipoSobremesa = tipoSobremesa;
    }
}
