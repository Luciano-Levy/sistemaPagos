package sistemapagos.tarjeta;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Tarjeta {
    int numero;
    Tasa tasa;
    String vencimiento; // MM/yyyy
    String marca;
    String cardHolder;


    public Tarjeta(int numero, String vencimiento, String cardHolder) {
        this.numero = numero;
        this.vencimiento = vencimiento;
        this.cardHolder = cardHolder;
        this.tasa = new Tasa(marca);
    }

    // Informa si una tarjeta es valida para operar
    public boolean esValida(){
        YearMonth now = YearMonth.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/yyyy");
        try{
            
            // si llega a estar mal el formato de fecha
            YearMonth ym = YearMonth.parse(vencimiento, format);
            boolean comparacion = now.isBefore(ym);
            
            return comparacion;
            
        }catch (Exception e){
            
            return false;
        
        }

    }

    // Devuelve informacion de la tarjeta
    public String[] info(){

        String[] info = new String[4];
        info[0] = marca;
        info[1] = cardHolder;
        info[2] = Integer.toString(numero);
        info[3] = vencimiento;

        return info;
    }

    // Identifica si es distinta a otra tarjeta
    public boolean sonDistintas(Tarjeta comparada){

    }


}
