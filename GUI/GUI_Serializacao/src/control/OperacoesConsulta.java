package control;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.AgendarConsulta;

public class OperacoesConsulta {
    private List<AgendarConsulta> agendarConsultaList;
    private DefaultTableModel tableModel;
    private JTable table;

    // construtor
    public OperacoesConsulta(List<AgendarConsulta> agendarConsultaList, DefaultTableModel tableModel, JTable table) {
        this.agendarConsultaList = agendarConsultaList;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Método de cadastro de consulta
    public void agendarConsulta(String hora, String data, String desc) {
        AgendarConsulta consulta = new AgendarConsulta(hora, data, desc);
        agendarConsultaList.add(consulta);
        atualizarTabela();
    }

    // método de atualizar a consulta
    public void atualizarConsulta(int linhaSelecionada, String hora, String data, String desc) {
        if (linhaSelecionada != -1) {
            AgendarConsulta consulta = new AgendarConsulta(hora, data, desc);
            agendarConsultaList.set(linhaSelecionada, consulta);
            atualizarTabela();
        }
    }

    // método de apagar consultas selecionadas
    public void apagarConsulta(int linhaSelecionada) {
        if (linhaSelecionada != -1) {
            agendarConsultaList.remove(linhaSelecionada);
            atualizarTabela();
        }
    }

    // Método de apagar todas as consultas
    public void apagarTodasConsultas() {
        agendarConsultaList.clear();
        atualizarTabela();
    }

    public void salvarConsulta() {
        SerializacaoConsulta.serializar("dadosConsulta.txt", agendarConsultaList);
    }

    // Método de atualizar tabela
    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (AgendarConsulta consulta : agendarConsultaList) {
            tableModel.addRow(new Object[] { consulta.getHora(), consulta.getData(), consulta.getDesc() });
        }
    }
}
