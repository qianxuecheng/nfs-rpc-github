package code.google.nfs.rpc.config.reflection;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by qianxuecheng on 15/3/15.
 */
public class MyClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] { "classpath:nfs-reference.xml" });

        /*
         * Map<String,Integer> methodTimeouts=new HashMap<String,Integer>();
         * methodTimeouts.put("*",200); List<InetSocketAddress> servers=new
         * ArrayList<InetSocketAddress>(); servers.add(new
         * InetSocketAddress(18888)); int codectype= Codecs.HESSIAN_CODEC;
         * HelloWorldService service=(HelloWorldService) Proxy.newProxyInstance(
         * Thread.currentThread().getContextClassLoader(), new
         * Class<?>[]{HelloWorldService.class}, new
         * NettyClientInvocationHandler(
         * servers,1,300,"helloServiceImpl1",methodTimeouts,codectype,
         * RPCProtocol.TYPE) );
         */
        HelloWorldService h1 = (HelloWorldService) context.getBean("helloWorld");

        System.out.println(h1.sayHello("qian"));

    }
}
