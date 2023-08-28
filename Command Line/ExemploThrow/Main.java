package ExemploThrow;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        boolean tenteNovamente = true;
        String senha, login, data;
        while (tenteNovamente) {
            try {
                login = JOptionPane.showInputDialog("Informe o seu login:");
                senha = JOptionPane.showInputDialog("Informe uma senha:");
                data = JOptionPane.showInputDialog("Informe sua data de nascimento seguindo o padrão [dd/mm/aaaa]:");
                data = data.replace("/","");
                if (senha.length() < 8) {
                    throw new Exception("Senha menor que 8 (oito) caracteres.");
                }
                if(senha.equals(login)){
                    throw new Exception("O Login é igual a Senha");
                }
                if(senha.equals(data)){
                    throw new Exception("O Login é igual a Data de Nascimento");
                }
                if(senha.contains()){

                }
                JOptionPane.showMessageDialog(null, "Senha Cadastrada com Sucesso", "senha", 1);
                tenteNovamente = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Senha", 0);
            }
        }
    }
}
