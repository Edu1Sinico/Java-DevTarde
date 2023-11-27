package View;

import javax.swing.*;

public class JanelaPrincipal extends JFrame {
    private JTabbedPane jTPane;

    public JanelaPrincipal() {
        super("Controle de Vendas de Carros");
        jTPane = new JTabbedPane();
        add(jTPane);
        // criandos as tabs
        // tab1 carros
        JanelaCarrosView tab1 = new JanelaCarrosView();
        jTPane.add("Carros", tab1);
        // tab2 clientes
        JanelaClienteView tab2 = new JanelaClienteView();
        jTPane.add("Clientes", tab2);
        // tab3 vendas
        JanelaRegistarVenda tab3 = new JanelaRegistarVenda();
        jTPane.add("Vendas", tab3);

        setBounds(100, 100, 700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }
}
