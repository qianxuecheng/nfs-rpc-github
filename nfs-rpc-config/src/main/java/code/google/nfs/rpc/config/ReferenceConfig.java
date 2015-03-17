package code.google.nfs.rpc.config;

import java.net.InetSocketAddress;
import java.util.*;

import code.google.nfs.rpc.Codecs;
import code.google.nfs.rpc.protocol.RPCProtocol;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;


/**
 * Created by qianxuecheng on 15/3/16.
 * 
 *
 */
public class ReferenceConfig {

    public static final int DEFAULT_METHOD_TIMEOUT = 200;
    public static final int DEFAULT_CLIENT_NUMS = 1;
    public static final int DEFAULT_CONNECTION_TIMEOUT = 200;

    private Object serversMonitor = new Object();
    private String interfaceName;
    private String address;

    private volatile List<InetSocketAddress> servers;

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


    // concurrency problem
    // in which thread
    public List<InetSocketAddress> getServers() {
        if (Strings.isNullOrEmpty(address)) {
            return Collections.EMPTY_LIST;
        }
        if (servers == null || servers.size() == 0) {
            synchronized (serversMonitor) {
                Iterable<String> split = Splitter.on(",").omitEmptyStrings().split(address);
                Iterator<String> it = split.iterator();
                List<InetSocketAddress> servers = Lists.newArrayList();
                while (it.hasNext()) {
                    String[] ipAndPort = it.next().split(":");
                    String ip = ipAndPort[0];
                    String port = ipAndPort[1];
                    InetSocketAddress socketAddress = new InetSocketAddress(ip, Integer.parseInt(port));
                    servers.add(socketAddress);
                }
                this.servers = servers;
            }
        }
        return servers;

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
