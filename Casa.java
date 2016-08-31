
import java.util.Random;

/**
 *
 * @author Usuario 1
 */
public class Casa extends Inmueble{
    private boolean jardin;
    private boolean zonaTranquila;
    
    public Casa(int id, int distancia , int maxPersonas,boolean jardin,boolean zonaTranquila){
        super(id,distancia,maxPersonas);
        this.zonaTranquila=zonaTranquila;
        this.jardin= jardin;
        
    }
    public Casa(){
        super();
        Random aleatorio = new Random();
        
       
          this.jardin=aleatorio.nextBoolean();
          this.zonaTranquila=aleatorio.nextBoolean();
        
    }
    /**
     * 
     * @return nos dice el estado de si la casa tiene jardin; true=tiene jardin
     */
    public boolean getJardin(){
        return this.jardin;
    }
    /**
     * 
     * @return  nos dice si la zona es tranquila(true) o no (false)
     */
    public boolean getZonaTranquila(){
        return this.zonaTranquila;
    }
    public double precio(){
        double precio = super.precio();
        if (jardin || zonaTranquila){
            precio*=2;
        }
        return precio;
    }
    
    public String toString(){
        String resultado = super.toString();
        if(zonaTranquila){
            resultado+= " . Esta en zona tranquila";
        }else{
            resultado += " . No esta en zona tranquila";
        }
        
        if(jardin){
            resultado += " . Tiene Jardin";
        }else{
            resultado += " . No tiene jardin";
        }
        return resultado;
    }
    
}
