package RevisaoFPOO.Agenda;


public class Agendamento {

    //Atributos
    String tipoDeConsulta; 
    int dia;
    int mes;
    int ano;
    int hora;

    
    //métodos
    public String getTipoDeConsulta() {
        return tipoDeConsulta;
    }
    public void setTipoDeConsulta(String tipoDeConsulta) {
        this.tipoDeConsulta = tipoDeConsulta;
    }
    public int getHora() {
        return hora;
    }
    public void setHora(int hora) {
        this.hora = hora;
    }
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

}
