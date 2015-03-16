package code.google.nfs.rpc.config.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by qianxuecheng on 15/3/16.
 */
public class NfsNamespaceHandler extends NamespaceHandlerSupport{
    @Override
    public void init() {
        registerBeanDefinitionParser("reference",new NfsReferenceBeanDefinitionParser());
        registerBeanDefinitionParser("service",new NfsServiceBeanDefinitionParser());
        registerBeanDefinitionParser("registry",new NfsRegistryBeanDefinitionParser());
    }
}
