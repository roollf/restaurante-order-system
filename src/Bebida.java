public class Bebida extends ItemMenu {
    private String tipoBebida;

    public Bebida() {
    }

    public Bebida(String nome, String descricao, double preco, String tipoBebida) {
        super(nome, descricao, preco);
        this.tipoBebida = tipoBebida;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println(this.tipoBebida);
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }
}
