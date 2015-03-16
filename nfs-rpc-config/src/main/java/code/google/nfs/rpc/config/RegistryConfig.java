package code.google.nfs.rpc.config;

import code.google.nfs.rpc.NamedThreadFactory;
import code.google.nfs.rpc.netty.server.NettyServer;
import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qianxuecheng on 15/3/16.
 */
public class RegistryConfig implements InitializingBean{
    public static final int DEFAULT_PORT=18888;
    private int port=DEFAULT_PORT;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }


    ExecutorService executor= Executors.newCachedThreadPool(new NamedThreadFactory("BUSSINESSTHREADPOOL"));

    @Override
    public void afterPropertiesSet() throws Exception {
        NettyServer.getInstance().start(port,executor);
        
    }
}
