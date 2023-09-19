public class PratoPrincipal extends ItemMenu {
    private String tipoCulinaria;

    public PratoPrincipal() {
    }

    public PratoPrincipal(String nome, String descricao, double preco, String tipoCulinaria) {
        super(nome, descricao, preco);
        this.tipoCulinaria = tipoCulinaria;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println(this.tipoCulinaria);
    }

    public String getTipoCulinaria() {
        return tipoCulinaria;
    }

    public void setTipoCulinaria(String tipoCulinaria) {
        this.tipoCulinaria = tipoCulinaria;
    }
}
