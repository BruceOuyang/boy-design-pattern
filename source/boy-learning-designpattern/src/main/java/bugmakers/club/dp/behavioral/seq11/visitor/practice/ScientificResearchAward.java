package bugmakers.club.dp.behavioral.seq11.visitor.practice;

import java.text.MessageFormat;

/**
 * @Description: 科研奖
 * @Author: Bruce
 * @Datetime: 2018/4/11 10:54
 */
public class ScientificResearchAward extends AbstractAward {

    @Override
    public void visit(TeacherCandidate candidate) {
        if(COUNT_DISSERTATION_TEACHER <= candidate.getCountDissertation()){
            System.out.println(MessageFormat.format("{0}老师发表了{1}篇论文，可以评选科研奖", candidate.getName(), candidate.getCountDissertation()));
        }
    }

    @Override
    public void visit(StudentCandidate candidate) {
        if(COUNT_DISSERTATION_STUDENT <= candidate.getCountDissertation()){
            System.out.println(MessageFormat.format("{0}同学发表了{1}篇论文，可以评选科研奖", candidate.getName(), candidate.getCountDissertation()));
        }
    }
}
