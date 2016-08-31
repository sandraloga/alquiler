
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Usuario 1
 */
public abstract class  Inmueble {
    private int id;
    private int distancia;
    private int maxPersonas;
//    private int diaEntrada;
//    private int diaSalida;
    public static int contadorInmuebles=1;
    ArrayList<Reserva> reservas;
    
    
    public Inmueble(int id,int distancia,int maxPersonas){
        this.id=id;
        this.distancia=distancia;
        this.maxPersonas=maxPersonas;
//        this.diaEntrada=diaEntrada;
//        this.diaSalida=diaSalida;
        this.reservas = new ArrayList<>();
        
    }
    public Inmueble(){
        
        Random aleatorio = new Random();
        this.id = contadorInmuebles+1000;
        contadorInmuebles++;
        this.distancia= aleatorio.nextInt(101); //numero de 0 a 101
        this.maxPersonas=1 +aleatorio.nextInt(10); //numero entre 1 y 6
//        this.diaEntrada= 1+aleatorio.nextInt(31);//entre 1 y 31
//        this.diaSalida= 1+aleatorio.nextInt(31);//entre 1 y 31 
        
        
    }
    public int getId(){
        return this.id;
    }
    
    public int getDistancia(){
        return this.distancia;
    }
    
    public int getMaximoPersonas(){
        return this.maxPersonas;
    }
    
    public int getCuantasReservas(){
        return reservas.size();
    }
    
    public void addReserva(Reserva reserva){
        reservas.add(reserva);
    }
    public String toString(){
        return String.format("\n%s Id inmueble : %d Distancia al centro :"
                + " %d Km. Capacidad máxima %d personas ",getClass().getSimpleName(),this.id,this.distancia,this.maxPersonas );
    }
    public void visuDatos(){
        System.out.println("\nid : "+this.id+" nº reservas: "+this.getCuantasReservas());
    }
    /**
     * 
     * @return precio por noche
     */
    public double precio(){
        return this.maxPersonas*100.0/this.distancia;
    }
    public void visuPrecios(){
        System.out.println("\n Id: "+this.id+" Precio : "+precio());
    }
    public boolean alquilable(int fechaInicio, int fechaFin){
        return true;
        
    }
    
   
         
   
    
    
}
