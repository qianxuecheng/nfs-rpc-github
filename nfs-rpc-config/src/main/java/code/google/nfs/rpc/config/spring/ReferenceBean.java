package code.google.nfs.rpc.config.spring;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.FactoryBean;

import code.google.nfs.rpc.config.ReferenceConfig;
import code.google.nfs.rpc.netty.client.NettyClientInvocationHandler;


/**
 * Created by qianxuecheng on 15/3/16.
 */
public class ReferenceBean extends ReferenceConfig implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
            new Class[] { getObjectType() }, new NettyClientInvocationHandler(getServers(), getClientNums(),
                getConnectTimeout(), getTargetInstanceName(), getMethodTimeouts(), getCodecType(),
                getProtocolType()));
    }


    @Override
    public Class<?> getObjectType() {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(getInterfaceName());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean isSingleton() {
        return false;
    }
}
