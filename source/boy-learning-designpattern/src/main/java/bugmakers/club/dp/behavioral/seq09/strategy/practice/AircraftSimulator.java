package bugmakers.club.dp.behavioral.seq09.strategy.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/4/2 10:21
 */
public class AircraftSimulator {

    private AbstractAircraft aircraft;

    public void setAircraft(AbstractAircraft aircraft) {
        this.aircraft = aircraft;
    }

    /**
     * 启动测试引擎
     */
    public void startTestEngine(){

        System.out.println("启动测试引擎");
        System.out.println("");
        if(this.aircraft != null) {
            System.out.println("开始模拟[" + this.aircraft.name + "]的测试");
            System.out.println("--------------------------");
            this.aircraft.launch();
            this.aircraft.flying();
        }else{
            System.out.println("模拟飞行器为空，请先配置模拟飞行器");
        }
    }
}
