package bugmakers.club.dp.behavioral.seq11.visitor.practice;

/**
 * @Description: 抽象访问者
 * @Author: Bruce
 * @Datetime: 2018/4/10 10:26
 */
public abstract class AbstractAward {

    /**
     * 老师发表文章超过数量
     */
    public static final int COUNT_DISSERTATION_TEACHER = 10;
    /**
     * 学生发表文章超过数量
     */
    public static final int COUNT_DISSERTATION_STUDENT = 2;
    /**
     * 老师获得反馈分大于分数
     */
    public static final int GRADE_TEACHER = 90;
    /**
     * 学生评价成绩大于分数
     */
    public static final int GRADE_STUDENT = 90;

    /**
     * 访问老师
     * @param candidate
     */
    public abstract void visit(TeacherCandidate candidate);

    /**
     * 访问学生
     * @param candidate
     */
    public abstract void visit(StudentCandidate candidate);

}
