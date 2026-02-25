package Solid.ISP.WrongImplementation;

public class HumanWorker implements Worker {
    @Override
    public void work(){
        /*Método para indicar la abstracción en donde el trabajador
        humano está trabajando*/
        System.out.println("The worker/human is working...");
    }
    
    @Override
    public void eat(){
        /*Método para indicar la abstracción en donde el trabajador
        humano está comiendo*/
        System.out.println("The worker/human is eating...");
    }
}
