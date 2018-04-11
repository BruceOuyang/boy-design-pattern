package bugmakers.club.dp.behavioral.seq11.visitor.practice;

import java.text.MessageFormat;

/**
 * @Description: 优秀奖
 * @Author: Bruce
 * @Datetime: 2018/4/11 10:55
 */
public class ExcellentAward extends AbstractAward {

    @Override
    public void visit(TeacherCandidate candidate) {
        if(GRADE_TEACHER <= candidate.getGrade()){
            System.out.println(MessageFormat.format("{0}老师发表论文的反馈分为{1}，可以评选优秀奖。", candidate.getName(), candidate.getGrade()));
        }
    }

    @Override
    public void visit(StudentCandidate candidate) {
        if(GRADE_STUDENT <= candidate.getAverageGrade()){
            System.out.println(MessageFormat.format("{0}同学的平均分为{1}，可以评选优秀奖。", candidate.getName(), candidate.getAverageGrade()));
        }
    }
}
