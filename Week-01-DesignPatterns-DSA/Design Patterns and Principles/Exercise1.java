class Logger{

    private static Logger logger;
    private Logger(){

    }
    public static Logger getInstance(){
        if(logger==null){
            logger=new Logger();
        }
        return logger;
    }
    public void log(String msg){
        System.out.println(msg);
    }

}
class Solution{

    public static void main(String[] args){
        Logger logger1=Logger.getInstance();
        Logger logger2=Logger.getInstance();
        logger1.log("Hello");
        logger2.log("World");
        System.out.println(logger1==logger2);
    }

}