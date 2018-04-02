package bugmakers.club.dp.behavioral.seq09.strategy.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/4/2 11:15
 */
public class StrategyPracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        AbstractAircraft aircraft = (AbstractAircraft) StrategyXMLUtil.getBean();

        AircraftSimulator simulator = new AircraftSimulator();
        simulator.setAircraft(aircraft);

        simulator.startTestEngine();
    }
}
