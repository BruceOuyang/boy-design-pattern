package bugmakers.club.dp.structural.seq7.proxy.practice.servicelogging;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/15 18:13
 */
public class ServiceProxy implements Service {

    private ServiceImpl impl = new ServiceImpl();
    private ServiceLogger logger;

    public void biz() {
        impl.biz();
        this.log();
    }

    private void log(){
        logger = new ServiceLogger();
        logger.log("ServiceImpl.biz()");
    }
}
