import java.util.Random;

/**
 *
 * @author Usuario 1
 */
public class CasaSuperlujo extends Casa{
    private int numPiscinas;
    private int numHabitaciones;
     public static final int[] NOALQUILAR={10,20,25};
  
   
    
    public CasaSuperlujo(int id, int distancia, int maxPersonas,boolean jardin,
            boolean zonaTranquila, int numPiscinas, int numHabitaciones){
        super(id,distancia,maxPersonas,jardin,zonaTranquila);
        this.numPiscinas=numPiscinas;
        this.numHabitaciones=numHabitaciones;
        
    }
    public CasaSuperlujo(){
        super();
        Random aleatorio = new Random();
        
       
        this.numPiscinas=aleatorio.nextInt(5);// numero entre 0 y 4
        this.numHabitaciones=1+aleatorio.nextInt(10); //numero entre 1 y 10
        
    }
    public String toString(){
        String resultado = super.toString();
        resultado += ( ". Numero de piscinas: "+this.numPiscinas+" . Numero de habitaciones: "+
                this.numHabitaciones);
        return resultado;
    }
    public double precio(){
        double precio= super.precio();
        int valor = 1;
        if(super.getZonaTranquila()){
            valor=2;
        }
       double factores=this.numPiscinas*this.numHabitaciones*100*valor;
       
        return precio+factores;
    }
    
    public boolean alquilable (int fechaInicio, int fechaFin){
        boolean alquilable= true;
        
        for (int j=0; j<NOALQUILAR.length; j++){
            if( NOALQUILAR[j]>=fechaInicio && NOALQUILAR[j]<=fechaFin){
                alquilable=false;
                //contiene dias que no se puede alquilar
            }
        }
        return alquilable;
        
    }
    
    
}
