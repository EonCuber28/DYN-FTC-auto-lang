public class simpleSubsystem {
    public void start(String[] args){
        System.out.println("Subsystem ran with args set to: ");
        for (int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
    }
}
