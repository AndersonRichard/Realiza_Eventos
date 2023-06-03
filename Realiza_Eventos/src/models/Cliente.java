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
                        Id: %s
                        Nome: %s
                        Telefone: %s
                        Email: %s
                        """,
                this.id,
                this.nome,
                this.telefone,
                this.email);
    }
    public Cliente clone(){
        Cliente clone = new Cliente(this.nome, this.telefone, this.email);
        clone.id = this.id;
        return clone;
    }
}
