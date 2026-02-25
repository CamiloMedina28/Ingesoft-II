package Solid.ISP.WrongImplementation;

public class RobotWorker implements Worker{
    @Override
    public void work(){
        /*Método para indicar la abstracción en donde el trabajador
        robot está trabajando*/
        System.out.println("The worker/human is working...");
    }
    
    @Override
    public void eat(){
        /*Método para indicar la abstracción en donde el trabajador
        robot está comiendo*/
        System.out.println("The worker/human is eating...");
    }
}
