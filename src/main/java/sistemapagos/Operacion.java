package sistemapagos;

import sistemapagos.tarjeta.Tarjeta;

public class Operacion {
    float valor;
    Tarjeta tarjeta;


    public Operacion(float valor, Tarjeta tarjeta) {
        this.valor = valor;
        this.tarjeta = tarjeta;
    }
    
    public boolean esValida(){
        if(this.valor < 1000 && this.valor > 0 && this.tarjeta.esValida()){
            return true;
        }else{
            return false;
        }
    }

    public String tasa(){
        return (tarjeta.marca + " " + tarjeta.tasa.valor(valor));
    }

}
