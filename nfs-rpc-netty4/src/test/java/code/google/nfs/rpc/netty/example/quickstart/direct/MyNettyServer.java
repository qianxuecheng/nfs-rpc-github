package code.google.nfs.rpc.netty.example.quickstart.direct;

import code.google.nfs.rpc.NamedThreadFactory;
import code.google.nfs.rpc.netty.server.NettyServer;
import code.google.nfs.rpc.protocol.SimpleProcessorProtocol;
import code.google.nfs.rpc.server.Server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by qianxuecheng on 15/3/15.
 */
public class MyNettyServer {
    public static void main(String[] args) throws Exception {
        Server server=new NettyServer();
        server.registerProcessor(SimpleProcessorProtocol.TYPE,String.class.getName(),new MyProcessor());
        NamedThreadFactory tf = new NamedThreadFactory("BUSINESSTHREADPOOL");
        ExecutorService threadpool=new ThreadPoolExecutor(20,100,300, TimeUnit.SECONDS,new SynchronousQueue<Runnable>(),tf);
        server.start(18888,threadpool);
    }
}
