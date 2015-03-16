package code.google.nfs.rpc.config.spring;

import code.google.nfs.rpc.server.Server;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Created by qianxuecheng on 15/3/16.
 */
public class NfsReferenceBeanDefinitionParser implements BeanDefinitionParser {
    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        String interfaceName=element.getAttribute("interfaceName");
        String id=element.getAttribute("id");
        String address=element.getAttribute("address");
        int protocolType=Integer.parseInt(element.getAttribute("protocolType"));
        int codecType=Integer.parseInt(element.getAttribute("codecType"));
        String targetInstanceName=element.getAttribute("targetInstanceName");
        RootBeanDefinition beanDefinition=new RootBeanDefinition();
        beanDefinition.setBeanClass(ReferenceBean.class);
        beanDefinition.setLazyInit(false);

        beanDefinition.getPropertyValues().add("interfaceName",interfaceName);
        beanDefinition.getPropertyValues().add("protocolType",protocolType);
        beanDefinition.getPropertyValues().add("codecType",codecType);
        beanDefinition.getPropertyValues().add("targetInstanceName",targetInstanceName);
        beanDefinition.getPropertyValues().add("address",address);

        
        parserContext.getRegistry().registerBeanDefinition(id,beanDefinition);

        return beanDefinition;
    }
}
