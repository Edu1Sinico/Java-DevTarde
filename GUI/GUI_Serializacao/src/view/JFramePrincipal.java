package view;

import javax.swing.*;

public class JFramePrincipal extends JFrame{
    public JFramePrincipal() {
        super("Programa de Consultas para o Usuário");
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        this.add(new JTabbedPanelPrincipal());
    }

        public void run(){
        setVisible(true);
    }
}
