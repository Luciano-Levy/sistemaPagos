package sistemapagos.tarjeta;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Tarjeta {
    long numero;
    public Tasa tasa;
    String vencimiento; // MM/yyyy
    public String marca;
    public String cardHolder;


    public Tarjeta(long numero2, String vencimiento, String cardHolder, String marca) {
        this.marca = marca;
        this.numero = numero2;
        this.vencimiento = vencimiento;
        this.cardHolder = cardHolder;
        this.tasa = new Tasa(marca);
    }

    // Informa si una tarjeta es valida para operar
    public boolean esValida(){
        YearMonth now = YearMonth.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/yyyy");
        
        try{
                       
            YearMonth ym = YearMonth.parse(vencimiento, format);
            boolean comparacion = now.isBefore(ym);
            
            return comparacion;
          
        // si llega a estar mal el formato de fecha    
        }catch (Exception e){
            
            System.out.println("Formato Erroneo");
            return false;
        
        }

    }

    // Devuelve informacion de la tarjeta
    public String[] info(){

        String[] info = new String[4];
        info[0] = marca;
        info[1] = cardHolder;
        info[2] = Long.toString(numero);
        info[3] = vencimiento;

        return info;
    }

    // Identifica si es distinta a otra tarjeta
    public boolean sonDistintas(Tarjeta comparada){
        String[] comparadaInfo;
        String[] thisInfo;
        
        // Con que se puede acceder a info() se va a poder acceder a los indices del array
        try{
            comparadaInfo = comparada.info();
            thisInfo = this.info();

            for(int i=0;i < thisInfo.length;i++){

                if (thisInfo[i].equals(comparadaInfo[i])) {
                    continue;
                }else{
                    return false;
                }

            }
    
            return true;

        }catch(Exception e){

            System.out.println("La informacion es erronea");
            return false;
        }


    }


}
