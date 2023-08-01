package RevisaoFPOO.Agenda;


public class Agendamento {

    //Atributos
    String data;
    String hora;
    String dataHora;

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getDataHora() {
        dataHora = data + hora;
        return dataHora;
    }
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}

    
    //métodos
   