package bugmakers.club.dp.behavioral.seq11.visitor.practice;

import java.util.ArrayList;

/**
 * @Description: 候选人集合
 * @Author: Bruce
 * @Datetime: 2018/4/10 10:45
 */
public class CandidateList {

    /**
     * 定义一个集合用于存储候选人
     */
    private ArrayList<Candidate> list = new ArrayList<Candidate>();

    public void addCandidate(Candidate candidate) {
        this.list.add(candidate);
    }

    /**
     * 遍历所有候选人
     * @param handler
     */
    public void accpet(AbstractAward handler) {
        for (Candidate candidate : list) {
            candidate.accept(handler);
        }
    }
}
