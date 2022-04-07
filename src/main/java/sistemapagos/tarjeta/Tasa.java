package sistemapagos.tarjeta;

import java.time.LocalDate;

public class Tasa {
    String marca;
    float porcentaje;

    public Tasa(String marca) {
        this.marca = marca;
        // tasa dependiendo de la tarjeta
        // Podria hacer una clase para marca que heredara de tarjeta
        // Tendria que instanciar una clase distinta para cada marca 
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int dayofMonth = now.getDayOfMonth();
        
        if (marca.equals("VISA")){
            // month > 0
            porcentaje = year / month;
        } else if(marca.equals("NARA")){
            porcentaje = (float) (dayofMonth * 0.5);
        } else if (marca.equals("AMEX")){
            porcentaje = (float) (month*0.1);
        }
    }

    public float valor(float valorOperacion){
        
        float result = (porcentaje * valorOperacion) / 100;
        

        return result;
    }
    
}
