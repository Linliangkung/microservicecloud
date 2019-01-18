package com.jsako.springcloud.customribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Date 2019/1/2
 * @Author LLJ
 * @Description
 */
public class CustomRule extends AbstractLoadBalancerRule {
    //已经访问的次数
    private int total;
    //当前服务器下标
    private int index;

    private static final int MAX_USE = 5;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        BaseLoadBalancer loadBalancer = (BaseLoadBalancer)getLoadBalancer();
        int total = loadBalancer.getReachableServers().size();
        List<Server> reachableServers = loadBalancer.getReachableServers();
        Server server = null;
        if(!CollectionUtils.isEmpty(reachableServers)) {
            while (server == null) {
                synchronized (this) {
                    if (this.total < MAX_USE) {
                        this.total++;
                        server = loadBalancer.getServerByIndex(index, true);
                    } else {
                        this.total = 0;
                        if (index < total - 1) {
                            index++;
                        } else {
                            index = 0;
                        }
                    }
                }
            }
        }

        return server;
    }
}
