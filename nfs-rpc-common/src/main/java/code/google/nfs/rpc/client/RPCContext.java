package code.google.nfs.rpc.client;

import java.util.concurrent.Future;


/**
 * Created by qianxuecheng on 15/3/31.
 */
public class RPCContext {
    private static final ThreadLocal<RPCContext> LOCAL = new ThreadLocal<RPCContext>() {
        @Override
        protected RPCContext initialValue() {
            return new RPCContext();
        }
    };


    public static RPCContext getRPCContext() {
        return LOCAL.get();
    }

    private Future<?> future;


    public <T> Future<T> getFuture() {
        return (Future<T>) future;
    }


    public void setFuture(Future<?> future) {
        this.future = future;
    }
}
