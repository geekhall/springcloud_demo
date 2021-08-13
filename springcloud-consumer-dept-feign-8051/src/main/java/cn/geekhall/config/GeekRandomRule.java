package cn.geekhall.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * RandomRule.java
 *
 * @author yiny
 */
public class GeekRandomRule extends AbstractLoadBalancerRule {
    public GeekRandomRule() {
    }

    private int total = 0;
    private int currentIndex = 0;


    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers(); // 获取活着的服务
                List<Server> allList = lb.getAllServers();      // 获取全部服务
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

//                int index = this.chooseRandomInt(serverCount);  // 生成区间随机数
//                server = (Server)upList.get(index);

                if (total < 5){
                    server = upList.get(currentIndex);
                    total++;
                } else {
                    total=0;
                    currentIndex++;
                    if (currentIndex >= upList.size()){
                        currentIndex = 0;
                    }
                    server = upList.get(currentIndex);
                }

                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }
//
//    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
//    public Server choose(ILoadBalancer lb, Object key) {
//        if (lb == null) {
//            return null;
//        } else {
//            Server server = null;
//
//            while(server == null) {
//                if (Thread.interrupted()) {
//                    return null;
//                }
//
//                List<Server> upList = lb.getReachableServers(); // 获取活着的服务
//                List<Server> allList = lb.getAllServers();      // 获取全部服务
//                int serverCount = allList.size();
//                if (serverCount == 0) {
//                    return null;
//                }
//
//                int index = this.chooseRandomInt(serverCount);  // 生成区间随机数
//                server = (Server)upList.get(index);
//                if (server == null) {
//                    Thread.yield();
//                } else {
//                    if (server.isAlive()) {
//                        return server;
//                    }
//
//                    server = null;
//                    Thread.yield();
//                }
//            }
//
//            return server;
//        }
//    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
