package models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Solicitacao extends ModeloBase {

    private Date dataHoraDaSolicitacao;
    private Evento evento;
    private ArrayList<Servico> servicosSelecionados;
    private Endereco enderecoSelecionado;
    private String inicioEventoDataHora;
    private String terminoEventoDataHora;
    private Cliente cliente;
    private String observacoes;

    public Solicitacao(){}

    public Solicitacao (Date dataHoraDaSolicitacao, Evento evento, Endereco enderecoSelecionado, String inicioEventoDataHora, String terminoEventoDataHora, Cliente cliente, String observacoes) {
        this.dataHoraDaSolicitacao = dataHoraDaSolicitacao;
        this.evento = evento;
        this.enderecoSelecionado = enderecoSelecionado;
        this.inicioEventoDataHora = inicioEventoDataHora;
        this.terminoEventoDataHora = terminoEventoDataHora;
        this.cliente = cliente;
        this.observacoes = observacoes;
        servicosSelecionados = new ArrayList<>();
    }

    public Date getDataHoraDaSolicitacao() {
        return dataHoraDaSolicitacao;
    }
    public String getDataHoraDaSolicitacaoStr() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return formatador.format(this.dataHoraDaSolicitacao);
    }
    public void setDataHoraDaSolicitacao(Date dataHoraDaSolicitacao) {
        this.dataHoraDaSolicitacao = dataHoraDaSolicitacao;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public ArrayList<Servico> getServicosSelecionados() {
        return servicosSelecionados;
    }

    public void setServicosSelecionados(ArrayList<Servico> servicosSelecionados) {
        this.servicosSelecionados = servicosSelecionados;
    }

    public Endereco getEnderecoSelecionado() {
        return enderecoSelecionado;
    }

    public void setEnderecoSelecionado(Endereco enderecoSelecionado) {
        this.enderecoSelecionado = enderecoSelecionado;
    }

    public String getInicioEventoDataHora() {
        return inicioEventoDataHora;
    }

    public void setInicioEventoDataHora(String inicioEventoDataHora) {
        this.inicioEventoDataHora = inicioEventoDataHora;
    }

    public String getTerminoEventoDataHora() {
        return terminoEventoDataHora;
    }

    public void setTerminoEventoDataHora(String terminoEventoDataHora) {
        this.terminoEventoDataHora = terminoEventoDataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String toString() {
        return String.format("""
                Id: %s
                Data/Hora da solicitação: %s
                Evento: %s
                Endereço selecionado: %s
                Início do evento: %s
                Término do evento: %s
                Cliente: %s
                Observações: %s
                """,
                this.id,
                this.getDataHoraDaSolicitacaoStr(),
                this.evento.getNome(),
                this.enderecoSelecionado.getRua() + ", " + this.enderecoSelecionado.getNumero() + ", " +
                        this.enderecoSelecionado.getBairro() + ", " + this.enderecoSelecionado.getCidade() + ", " +
                        this.enderecoSelecionado.getEstado(),
                this.inicioEventoDataHora,
                this.terminoEventoDataHora,
                this.cliente.getNome(),
                this.observacoes);
    }

    public Solicitacao clone() {
        Solicitacao clone = new Solicitacao(this.dataHoraDaSolicitacao, this.evento, this.enderecoSelecionado, this.inicioEventoDataHora, this.terminoEventoDataHora, this.cliente, this.observacoes);
        clone.id = this.id;
        return clone;
    }
}
