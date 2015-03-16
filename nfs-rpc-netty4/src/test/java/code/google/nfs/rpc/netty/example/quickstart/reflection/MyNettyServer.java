package code.google.nfs.rpc.netty.example.quickstart.reflection;

import code.google.nfs.rpc.NamedThreadFactory;
import code.google.nfs.rpc.netty.server.NettyServer;
import code.google.nfs.rpc.protocol.RPCProtocol;
import code.google.nfs.rpc.protocol.SimpleProcessorProtocol;
import code.google.nfs.rpc.server.Server;

import java.util.concurrent.*;

/**
 * Created by qianxuecheng on 15/3/15.
 */
public class MyNettyServer {
    public static void main(String[] args) throws Exception {
        Server server=new NettyServer();
        server.registerProcessor(RPCProtocol.TYPE,"helloServiceImpl1",new HelloWorldComponent());
        ThreadFactory tf=new NamedThreadFactory("BUSSINESSTHREADPOOL");
        ExecutorService threadpool=new ThreadPoolExecutor(20,100,300, TimeUnit.SECONDS,new SynchronousQueue<Runnable>(),tf);
        server.start(18888,threadpool);
        
    }
}
