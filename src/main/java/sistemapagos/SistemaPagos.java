package sistemapagos;

import sistemapagos.tarjeta.Tarjeta;

public class SistemaPagos {

    
    static inputHelper Ihelper = new inputHelper();
    public static void main(String[] args) {
        Tarjeta tarjetaActual = null;
        Tarjeta comparada = null;
        String menuOption = "";
        Operacion operacion;

        while (!menuOption.equals("5")){
            
            menu();
            menuOption = Ihelper.getUserInput(" >");

            if(menuOption.equals("1")){

                tarjetaActual = obtenerTarjeta();

            } else if (menuOption.equals("2")){
                
                try{
                    System.out.println("");
                    String[] data = tarjetaActual.info();
                    for (String s: data){
                        System.out.println(s);
                    }
                    if (tarjetaActual.esValida()){System.out.println("Es valida");}
                    else{System.out.println("No es valida");}
                }catch(Exception e){
                    System.out.println("\033[0;91m" + "La tarjeta no existe" + "\033[0m");
                }

            } else if (menuOption.equals("3")){
                
                try{
                    tarjetaActual.info();
                    comparada = obtenerTarjeta();
                    tarjetaActual.sonDistintas(comparada);
                } catch (Exception e){
                    System.out.println("\033[0;91m" + "La tarjeta no existe" + "\033[0m");
                }

            } else if (menuOption.equals("4")){
                
                try{
                    tarjetaActual.info();
                    int valor = Integer.parseInt(Ihelper.getUserInput("Ingresar monto: "));
                    operacion = new Operacion(valor, tarjetaActual);
                    operacion.esValida();
                    System.out.println( "\033[0;92m" + "Operacion realizada con exito \n"+ "\033[0m" +  operacion.tasa());

                }catch (Exception e){
                    System.out.println( "\033[0;91m" + "Operacion no valida" + "\033[0m");
                }

            }

        }
    }

    public static void menu(){
        System.out.println("");
        System.out.println("1- Insertar tarjeta");
        System.out.println("2- Informacion de la tarjeta"); // indica de es valida y la tasa
        System.out.println("3- Realizar comparacion");
        System.out.println("4- Realizar operacion"); // muestra si es valida, marca, importe
        System.out.println("5- Salir");
        
    }

    public static Tarjeta obtenerTarjeta(){
        try{
            String marca = Ihelper.getUserInput("Marca (VISA, NARA, AMEX): ").toUpperCase();
            String numero = Ihelper.getUserInput("Numero: ");
            String cardHolder = Ihelper.getUserInput("Nombre Completo: ");
            String vencimiento = Ihelper.getUserInput("Vencimiento (MM/yyyy): ");

            return new Tarjeta(numero, vencimiento, cardHolder, marca);
            } catch(Exception e){
                System.out.println( "\033[0;91m" + "Error al ingresar Datos" + "\033[0m");
                return null;
            }
    }


}