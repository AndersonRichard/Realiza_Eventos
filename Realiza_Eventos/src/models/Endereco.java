package models;

public class Endereco extends ModeloBase {
    private String rua;
    private int numero;
    private String bairro;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco(String rua, int numero, String bairro, String complemento, String cep, String cidade, String estado, String pais) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                Rua: %s
                Numero: %s
                Bairro: %s
                Complemento: %s
                CEP: %s
                Cidade: %s
                Estado: %s
                País: %s
                """,
                super.toString(),
                this.getRua(),
                this.numero,
                this.getBairro(),
                this.getComplemento(),
                this.getCep(),
                this.getCidade(),
                this.getCidade(),
                this.getEstado(),
                this.getPais());
    }

}
