package RevisaoFPOO;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import RevisaoFPOO.Agenda.Agendamento;
import RevisaoFPOO.Cadastro.Animais;
import RevisaoFPOO.Cadastro.Cachorro;
import RevisaoFPOO.Cadastro.Gato;
import RevisaoFPOO.Cadastro.OutrosAnimais;

class App {
    public static void main(String[] args) {
        //armazenar os meus objetos
        Gato gatos[] = new Gato[10];
        Cachorro cachorros[] = new Cachorro[10];
        //ArrayList<OutrosAnimais> outros = new ArrayList<OutrosAnimais>();
        OutrosAnimais outroAnimais[] = new OutrosAnimais[10];
        // contador
        int contGatos = 0, contCachorros = 0, contOutros = 0, contDia = 0, contMes = 0, contAno = 0, contHora = 0;
        //criar agendamento
        Agendamento agendamento[] = new Agendamento[10];
        //criar o cadastro
        JOptionPane.showMessageDialog(null, "Bem-Vindo ao Consultario do Dr. Frankstein");
        boolean aberto = true;
        // if(java.time.LocalDateTime.now()>8 && LocalDateTime.now(null)<18){
        //     aberto=true;
        // }else{
        //     aberto = false;
        // }
        while (aberto) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastrar PET\n 2-Agendar Consulta\n 3-Sair"));
            if(acao == 1){
                int acao2 = Integer.parseInt(JOptionPane.showInputDialog("1-Gato\n 2-Cachorro\n 3-Outro"));
                if(acao2 ==1){
                    //Cadastro do Gato
                    gatos[contGatos] = new Gato();
                    gatos[contGatos].setProprietario(JOptionPane.showInputDialog("Digite o nome do proprietário do gato:"));
                    contGatos++;
                }else if( acao2 ==2){
                    //cadastro do Cachorro
                    cachorros[contCachorros] = new Cachorro();
                    cachorros[contCachorros].setProprietario(JOptionPane.showInputDialog("Digite o nome do proprietário do cachorro:"));
                    contCachorros++;
                }else if(acao2 ==3){
                    //cadastro do outro Pet(peixe)
                }else{
                    //mensagem de erro
                    JOptionPane.showMessageDialog(null, "Selecione uma dessas opções!");
                }
            }else if(acao==2){
                //agendamento
                int acao3 = Integer.parseInt(JOptionPane.showInputDialog("1-Agendar Gato\n 2-Agendar Cachorro\n 3-Agendar outro"));
                if (acao3 == 1){
                    String proprietario = JOptionPane.showInputDialog("Digite o nome do proprietário do gato:");
                    //Agendamento de gato
                    for (int i = 0; i < gatos.length; i++) {
                        if(gatos[i].getProprietario().equals(proprietario)){
                            String data = JOptionPane.showInputDialog(null,"Informe a data do agendamento (Seguindo o padrão dd/mm/yyyy):");
                            String hora = JOptionPane.showInputDialog(null,"Informe a hora do agendamento:");
                            for (int j = 0; j < agendamento.length; j++) {
                                if(agendamento[j].getDataHora().equals(data + hora)){
                                    JOptionPane.showMessageDialog(null,"Agendamento realizado com sucesso!");
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Já existe agendamento nessa data e hora!");
                                }
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Proprietário não cadastrado!");
                        }
                    }
                }
                else if(acao3 == 2){
                    //Agendamento de cachorro
                }
                else if (acao3 == 3){
                    //Agendamento de outro pet
                }
                else{
                    JOptionPane.showMessageDialog(null,"Selecione uma dessas op\u00E7\u00F5es!");
                }
            }
        }
    }
}