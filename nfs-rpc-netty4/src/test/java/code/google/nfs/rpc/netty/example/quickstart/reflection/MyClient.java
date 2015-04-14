package code.google.nfs.rpc.netty.example.quickstart.reflection;

import code.google.nfs.rpc.Codecs;
import code.google.nfs.rpc.client.RPCContext;
import code.google.nfs.rpc.netty.client.NettyClientInvocationHandler;
import code.google.nfs.rpc.protocol.RPCProtocol;

import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by qianxuecheng on 15/3/15.
 */
public class MyClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Map<String,Integer> methodTimeouts=new HashMap<String,Integer>();
        methodTimeouts.put("*",200);
        List<InetSocketAddress> servers=new ArrayList<InetSocketAddress>();
        servers.add(new InetSocketAddress(18888));
        int codectype= Codecs.HESSIAN_CODEC;
        HelloWorldService service=(HelloWorldService) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{HelloWorldService.class},
                new NettyClientInvocationHandler(servers,1,300,"helloServiceImpl1",methodTimeouts,codectype, RPCProtocol.TYPE)
        );
        System.out.println(service.sayHello("qian"));
        Future<?> future = RPCContext.getRPCContext().getFuture();
        System.out.println(future.get());

    }
}
