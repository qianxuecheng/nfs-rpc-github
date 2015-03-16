package code.google.nfs.rpc.netty.example.quickstart.direct;

import code.google.nfs.rpc.server.ServerProcessor;

/**
 * Created by qianxuecheng on 15/3/15.
 */
public class MyProcessor implements ServerProcessor {
    @Override
    public Object handle(Object request) throws Exception {
        return (String)request+"return by server";
    }
}
