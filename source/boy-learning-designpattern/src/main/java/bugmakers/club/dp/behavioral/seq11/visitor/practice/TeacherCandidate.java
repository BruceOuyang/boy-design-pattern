package bugmakers.club.dp.behavioral.seq11.visitor.practice;

/**
 * @Description: 老师作为候选人
 * @Author: Bruce
 * @Datetime: 2018/4/11 10:11
 */
public class TeacherCandidate implements Candidate {

    /**
     * 老师姓名
     */
    private String name;

    /**
     * 论文数
     */
    private int countDissertation;

    /**
     * 反馈分
     */
    private int grade;

    public TeacherCandidate(String name, int countDissertation, int grade) {
        this.name = name;
        this.countDissertation = countDissertation;
        this.grade = grade;
    }

    public void accept(AbstractAward award) {
        award.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountDissertation() {
        return countDissertation;
    }

    public void setCountDissertation(int countDissertation) {
        this.countDissertation = countDissertation;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
