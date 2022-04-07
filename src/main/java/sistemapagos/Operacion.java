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
            throw new ArithmeticException("El monto debe ser menor a 1000");
        }
    }

    // A QUE SE REFIERE CON IMPORTE tasa+valor?
    public String tasa(){
        return (tarjeta.marca + " Importe total: " + tarjeta.tasa.importe(valor));
    }

}
