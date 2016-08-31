
import java.util.ArrayList;

/**
 *
 * @author Usuario 1
 */
public class Alquiler {

    private ArrayList<Inmueble> inmuebles;
    //private ArrayList<Reserva> alquileres;
    
    
    
    /**
     * 
     */
    public Alquiler(){
        inmuebles = new ArrayList<>();
       //alquileres = new ArrayList<>();
        for (int i=0; i<5; i++){
            addPiso();
            addCasa();
            addCasaSuperlujo();
        }
    }
    /**
     * 
     * @param inmueble 
     */
    public void addInmueble(Inmueble inmueble){
       inmuebles.add(inmueble);
    }
    /**
     * 
     */
    public void addCasa(){
        Inmueble inmueble = new Casa();
        inmuebles.add(inmueble);
    }
    /**
     * 
     */
    public void addCasaSuperlujo(){
        Inmueble inmueble = new CasaSuperlujo();
        inmuebles.add(inmueble);
    }
    /**
     * 
     */
    public void addPiso(){
        Inmueble inmueble = new Piso();
        inmuebles.add(inmueble);
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Inmueble getInmueble(int id){
       return inmuebles.get(id -1001);
    }
    /**
     * 
     * @param dni
     * @param fechaInicio
     * @param fechaFin
     * @param id 
     */
    public void reservar (String dni, int fechaInicio, int fechaFin, int id){
        Reserva reserva = new Reserva(dni, fechaInicio,fechaFin);
        
        if (alquilable(id, fechaInicio, fechaFin)){
            if(disponible(id, fechaInicio,fechaFin)){
                inmuebles.get(id-1001).addReserva(reserva);
                System.out.println("Reserva satisfactoria");
            }else
                System.out.println("No disponible!!!");
        }else{
            System.out.println("No alquilable en esas fechas por restricciones!!!");
        }
    }
    /**
     * 
     */
    public void mostrarInmuebles(){
        for (int i=0; i< inmuebles.size();i++){
            System.out.println(inmuebles.get(i).toString());
        }
    }
    /**
     * 
     * @param id
     * @param fecha
     * @return 
     */
    private boolean disponible(int id , int fecha){
        boolean disponible = true;
        Inmueble inmueble=inmuebles.get(id -1001);
        for (int i=0; i< inmueble.reservas.size(); i++){
            if(inmueble.reservas.get(i).siLibre(fecha)==false){
                
                    disponible=false;
                
            }
        }
        
        return disponible;
    }
    /**
     * 
     * @param id
     * @param fInicio
     * @param fFin
     * @return 
     */
    public boolean disponible(int id, int fInicio , int fFin){
        boolean disponible = true;
        for (int i=fInicio; i< fFin; i++){
            if(disponible(id, i)==false){
                disponible=false;
            }
        }
        return disponible;
                
    }
    /**
     * 
     * @param fInicio
     * @param fFin
     * @param numOcupantes 
     */
    public void mostrarInmueblesDisponibles(int fInicio, int fFin ,int numOcupantes ){
        for(int i=0; i< inmuebles.size();i++){
            if(inmuebles.get(i).getMaximoPersonas()>=numOcupantes){
                if(disponible(inmuebles.get(i).getId(), fInicio, fFin)){
                    System.out.println(inmuebles.get(i).toString());
                }
            }
        }
    }
    /**
     * 
     */
    public void listadoPorNUmeroDeReserva(){
        Inmueble[] arrayInmuebles = new Inmueble[inmuebles.size()];
        for (int i=0; i< inmuebles.size(); i++){
            arrayInmuebles[i]= inmuebles.get(i);
        }
        for (int i = 1; i < arrayInmuebles.length; i++) {
			for (int j = arrayInmuebles.length - 1; j >= i; j--) {

				if (arrayInmuebles[j - 1].getCuantasReservas() > arrayInmuebles[j].getCuantasReservas()) {
					Inmueble aux = arrayInmuebles[j - 1];
					arrayInmuebles[j - 1] = arrayInmuebles[j];
					arrayInmuebles[j] = aux;
				}
			}

		}
        
         for (int i = 1; i < arrayInmuebles.length; i++) {
            arrayInmuebles[i].visuDatos();
         }
    }
    
    public void mostrarPreciosNoche(){
        for(int i=0; i< inmuebles.size();i++){
           inmuebles.get(i).visuPrecios();
        }
    }
    
    public boolean alquilable(int id, int fechaInicio , int fechaFin){
        boolean alquilable=true;
        Inmueble inmueble =null;
        inmueble=getInmueble(id);
        if(inmueble != null){
            alquilable= inmueble.alquilable(fechaInicio, fechaFin);
        }
        return alquilable;
    }
    
    
}
