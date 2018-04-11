package bugmakers.club.dp.behavioral.seq11.visitor.practice;

/**
 * @Description: 候选人
 * @Author: Bruce
 * @Datetime: 2018/4/10 10:25
 */
public interface Candidate {

    /**
     * 接受一个抽象访问者访问
     * @param award
     */
    void accept(AbstractAward award);
}
