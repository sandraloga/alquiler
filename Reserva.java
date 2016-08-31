/**
 *
 * @author Usuario 1
 */
public class Reserva {
    private String dni;
    private int fechaInicio;
    private int fechaFin;
    /**
     * 
     * @param dni
     * @param fechaInicio
     * @param fechaFin 
     */
    public Reserva(String dni, int fechaInicio, int fechaFin){
        this.dni=dni;
        this.fechaInicio= fechaInicio;
        this.fechaFin = fechaFin;
    }
    /**
     * 
     * @return 
     */
    public int[] nochesOcupado(){
        int noche = fechaInicio;
        int[] nochesOcupado  = new int[fechaFin-fechaInicio];
        for (int i=0; i< nochesOcupado.length;i++){
            nochesOcupado[i]=noche;
            noche++;
        }
        return nochesOcupado;
    }
    /**
     * 
     * @param fecha
     * @return 
     */
    
    public boolean siLibre(int fecha){
        boolean libre = true;
        for( Integer noche : nochesOcupado()){
            if(noche == fecha){
                libre = false;
            }
        }
       return libre;
        
    }
    public int numeroDias(){
        return this.fechaFin-this.fechaInicio;
    }
}
