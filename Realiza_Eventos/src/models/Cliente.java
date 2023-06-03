package models;

public class Cliente extends ModeloBase{
    private String nome;
    private String telefone;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    public String toString() {
        return String.format("""
                        %s
                        Nome: %s
                        Telefone: %s
                        Email: %s
                        """,
                super.toString(),
                this.getNome(),
                this.getTelefone(),
                this.getEmail());
    }

}
