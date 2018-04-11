package bugmakers.club.dp.behavioral.seq11.visitor.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/4/11 15:07
 */
public class VisitorPracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        CandidateList list = new CandidateList();
        list.addCandidate(new StudentCandidate("小夏弟弟", 5, 89));
        list.addCandidate(new TeacherCandidate("萝卜丝", 2, 95));

        AbstractAward award = new ExcellentAward();
        list.accpet(award);

        award = new ScientificResearchAward();
        list.accpet(award);
    }
}
