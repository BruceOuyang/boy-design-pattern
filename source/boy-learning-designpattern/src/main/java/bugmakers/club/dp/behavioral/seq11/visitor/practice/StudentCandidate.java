package bugmakers.club.dp.behavioral.seq11.visitor.practice;

/**
 * @Description: 学生作为候选人
 * @Author: Bruce
 * @Datetime: 2018/4/11 10:12
 */
public class StudentCandidate implements Candidate {

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 论文数
     */
    private int countDissertation;

    /**
     * 平均成绩
     */
    private int averageGrade;

    public StudentCandidate(String name, int countDissertation, int averageGrade) {
        this.name = name;
        this.countDissertation = countDissertation;
        this.averageGrade = averageGrade;
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

    public int getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(int averageGrade) {
        this.averageGrade = averageGrade;
    }
}
