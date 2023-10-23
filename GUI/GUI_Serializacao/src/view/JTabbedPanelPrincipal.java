package view;

import javax.swing.*;

public class JTabbedPanelPrincipal extends JTabbedPane{
    public JTabbedPanelPrincipal() {
        this.add("Cadastrar Usuário", new CadastrosUsuarios());
        this.add("Cadastrar Consulta", new CadastroConsulta());
    }
}
