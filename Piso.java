import java.util.Random;

/**
 *
 * @author Usuario 1
 */
class Piso extends Inmueble{
    private boolean terraza;
    private boolean ascensor;
    private static final int MAX_NOCHES=7;
    /**
     * 
     * @param id
     * @param distancia
     * @param maxPersonas
     * @param terraza
     * @param ascensor 
     */
    public Piso(int id,int distancia, int maxPersonas,boolean terraza,boolean ascensor){
        super(id,distancia,maxPersonas);
        this.terraza=terraza;
        this.ascensor =ascensor;
                
    }
    public Piso(){
        
        super();
        Random aleatorio = new Random();
       
            this.terraza =aleatorio.nextBoolean(); //true o false
            this.ascensor = aleatorio.nextBoolean(); //true o false
            
        
        
//        for(int i=0; i<5; i++){
//            int id = aleatorio.nextInt(100000);//numero de 0 a 99999
//            int distancia= aleatorio.nextInt(100); //numero de 0 a 99
//            int maxPersonas=1 +aleatorio.nextInt(6); //numero entre 1 y 6
//            int diaEntrada= 1+aleatorio.nextInt(31);//entre 1 y 31
//            int diaSalida= 1+aleatorio.nextInt(31);//entre 1 y 31
//            boolean terraza = aleatorio.nextBoolean(); //true o false
//            boolean ascensor = aleatorio.nextBoolean(); //true o false
//            super(id,distancia,maxPersonas,diaEntrada,diaSalida);
//            this.terraza =aleatorio.nextBoolean(); //true o false
//            this.ascensor = aleatorio.nextBoolean(); //true o false
//        }
    }
    /**
     * 
     * @return  estado de si el piso tiene o no terraza true= tiene terraza
     */
    public boolean getTerraza(){
        return this.terraza;
    }
    /**
     * 
     * @return estado de si el piso tiene o no ascensoe; true=tiene ascensor 
     */
    public boolean getAscensor(){
        return this.ascensor;
    }
   public String toString(){
       String resultado = super.toString();
       if(terraza){
           resultado += " . Tiene terraza";
       }else{
           resultado+= " . No tiene terraza";
       }
       if(ascensor){
           resultado += " . Tiene ascensor";
       }else {
           resultado += " . No tiene ascensor";
       }
       return resultado;
   }
   public double precio(){
       double precio = super.precio();
       if (terraza || ascensor){
           precio-=2;
       }
       return precio;
   }
   public boolean alquilable(int fechaInicio, int fechaFin){
       boolean alquilable = true;
       if (fechaFin-fechaInicio>MAX_NOCHES){
           alquilable= false;
       }
       return alquilable;
   }
           
    
    
    
}
