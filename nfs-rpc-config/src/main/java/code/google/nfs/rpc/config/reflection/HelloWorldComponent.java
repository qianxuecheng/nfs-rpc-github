package code.google.nfs.rpc.config.reflection;

/**
 * Created by qianxuecheng on 15/3/15.
 */
public class HelloWorldComponent implements HelloWorldService {
    @Override
    public String sayHello(String world) {
        return world + " return  by server";
    }
}
