package code.google.nfs.rpc.config.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import code.google.nfs.rpc.config.RegistryConfig;


/**
 * Created by qianxuecheng on 15/3/16.
 */
public class NfsRegistryBeanDefinitionParser implements BeanDefinitionParser {

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        String id = element.getAttribute("id");
        int port = Integer.parseInt(element.getAttribute("port"));
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(RegistryConfig.class);
        beanDefinition.setLazyInit(false);
        beanDefinition.getPropertyValues().add("port", port);
        parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);
        return beanDefinition;

    }
}
