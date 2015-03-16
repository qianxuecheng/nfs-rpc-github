package code.google.nfs.rpc.netty.example.quickstart.direct;

import code.google.nfs.rpc.Codecs;
import code.google.nfs.rpc.client.Client;
import code.google.nfs.rpc.netty.client.NettyClientFactory;
import code.google.nfs.rpc.protocol.SimpleProcessorProtocol;

/**
 * Created by qianxuecheng on 15/3/15.
 */
public class MyClient {
    public static void main(String[] args) throws Exception {
        Client client= NettyClientFactory.getInstance().get("127.0.0.1",18888,20,1);
        String result= (String) client.invokeSync("hello",200, Codecs.HESSIAN_CODEC, SimpleProcessorProtocol.TYPE);
        System.out.println(result);
    }
}

