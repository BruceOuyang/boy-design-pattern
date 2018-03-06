package bugmakers.club.dp.creational.seq4.singleton.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/6 17:43
 */
public class BaseLoadBalancer {

    /**
     * 服务器集合
     */
    private List serverList = null;

    public BaseLoadBalancer() {
        serverList = new ArrayList();
    }

    /**
     * 增加服务器
     * @param server
     */
    public void addServer(String server) {
        serverList.add(server);
    }

    /**
     * 删除服务器
     * @param server
     */
    public void removeServer(String server) {
        serverList.remove(server);
    }

    /**
     * 使用Random类随机获取服务器
     * @return
     */
    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return (String)serverList.get(i);
    }
}
