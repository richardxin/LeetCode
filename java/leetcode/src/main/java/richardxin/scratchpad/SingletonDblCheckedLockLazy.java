package richardxin.scratchpad;

public class SingletonDblCheckedLockLazy {
    private static volatile SingletonDblCheckedLockLazy _instance; //volatile: ensure every thread see updated value
    
    public static SingletonDblCheckedLockLazy getInstance(){
        if(_instance == null){ // creating instance lazily on first request
            synchronized(SingletonDblCheckedLockLazy.class){
                if(_instance == null) 
                    _instance = new SingletonDblCheckedLockLazy();
            }
        }
        return _instance;
    }
}
