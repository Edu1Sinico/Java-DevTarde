package model;

import java.io.Serializable;

public class AgendarConsulta implements Serializable {
    private String data, hora, desc;

    public AgendarConsulta(String hora, String data, String desc) {
        this.hora = hora;
        this.data = data;
        this.desc = desc;
    }

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
