package code.google.nfs.rpc.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import code.google.nfs.rpc.netty.server.NettyServer;
import code.google.nfs.rpc.protocol.RPCProtocol;


/**
 * Created by qianxuecheng on 15/3/16.
 */
public class ServiceConfig implements ApplicationContextAware, ApplicationListener {
    private ApplicationContext applicationContext;
    private String interfaceName;

    private String targetInstanceName;
    private String ref;


    public String getInterfaceName() {
        return interfaceName;
    }


    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }


    public String getTargetInstanceName() {
        return targetInstanceName;
    }


    public void setTargetInstanceName(String targetInstanceName) {
        this.targetInstanceName = targetInstanceName;
    }


    public String getRef() {
        return ref;
    }


    public void setRef(String ref) {
        this.ref = ref;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        NettyServer.getInstance().registerProcessor(RPCProtocol.TYPE, targetInstanceName,
            applicationContext.getBean(ref));

    }
}
