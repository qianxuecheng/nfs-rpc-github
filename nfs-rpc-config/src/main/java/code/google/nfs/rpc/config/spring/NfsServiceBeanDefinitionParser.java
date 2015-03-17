package code.google.nfs.rpc.config.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import code.google.nfs.rpc.config.ServiceConfig;


/**
 * Created by qianxuecheng on 15/3/16.
 */
public class NfsServiceBeanDefinitionParser implements BeanDefinitionParser {
    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        String interfaceName = element.getAttribute("interfaceName");
        String targetInstanceName = element.getAttribute("targetInstanceName");
        String ref = element.getAttribute("ref");
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(ServiceConfig.class);
        beanDefinition.setLazyInit(false);

        beanDefinition.getPropertyValues().add("interfaceName", interfaceName);
        beanDefinition.getPropertyValues().add("targetInstanceName", targetInstanceName);
        beanDefinition.getPropertyValues().add("ref", ref);

        parserContext.getRegistry().registerBeanDefinition(targetInstanceName, beanDefinition);

        return null;
    }
}
