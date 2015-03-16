package code.google.nfs.rpc.config;

import java.net.InetSocketAddress;
import java.util.*;

import code.google.nfs.rpc.Codecs;
import code.google.nfs.rpc.protocol.RPCProtocol;


/**
 * Created by qianxuecheng on 15/3/16.
 * 
 * ist<InetSocketAddress> servers, int clientNums, int connectTimeout, String
 * targetInstanceName, Map<String, Integer> methodTimeouts,int codectype,
 * Integer protocolType* *
 */
public class ReferenceConfig {
    public static final int DEFAULT_METHOD_TIMEOUT = 200;
    public static final int DEFAULT_CLIENT_NUMS = 1;
    public static final int DEFAULT_CONNECTION_TIMEOUT = 200;
    private String interfaceName;
    private List<InetSocketAddress> servers;

    private String address;
    // per [ip:port]
    int clientNums = DEFAULT_CLIENT_NUMS;
    int connectTimeout = DEFAULT_CONNECTION_TIMEOUT;
    // targetInstanceName
    private String targetInstanceName;

    Map<String, Integer> methodTimeouts;
    int codecType = Codecs.PB_CODEC;

    Integer protocolType = RPCProtocol.TYPE;


    public ReferenceConfig() {
        methodTimeouts = new HashMap<String, Integer>();
        methodTimeouts.put("*", DEFAULT_METHOD_TIMEOUT);

    }


    public String getInterfaceName() {
        return interfaceName;
    }


    public Map<String, Integer> getMethodTimeouts() {
        return methodTimeouts;
    }


    public void setMethodTimeouts(Map<String, Integer> methodTimeouts) {
        this.methodTimeouts = methodTimeouts;
    }

    public int getCodecType() {
        return codecType;
    }

    public void setCodecType(int codecType) {
        this.codecType = codecType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }


    public List<InetSocketAddress> getServers() {
        return new ArrayList<InetSocketAddress>(Arrays.asList(new InetSocketAddress[]{new InetSocketAddress(18888)}));
    }


    public void setServers(List<InetSocketAddress> servers) {
        this.servers = servers;
    }


    public int getConnectTimeout() {
        return connectTimeout;
    }


    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }


    public int getClientNums() {
        return clientNums;
    }


    public void setClientNums(int clientNums) {
        this.clientNums = clientNums;
    }


    public String getTargetInstanceName() {
        return targetInstanceName;
    }


    public void setTargetInstanceName(String targetInstanceName) {
        this.targetInstanceName = targetInstanceName;
    }


    public Integer getProtocolType() {
        return protocolType;
    }


    public void setProtocolType(Integer protocolType) {
        this.protocolType = protocolType;
    }
}