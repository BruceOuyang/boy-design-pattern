package bugmakers.club.dp.behavioral.seq04.iterator.demooptimized.javaiterator;

import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/23 13:51
 */
public class StudentIterator implements Iterator {

    private StudentList studentList;
    private List<Student> students;

    /**
     * 游标
     */
    private int cursor;

    public StudentIterator(StudentList studentList) {
        this.studentList = studentList;
        students = studentList.getObjects();
        cursor = 0;
    }

    public boolean hasNext() {
        return cursor < students.size() - 1;
    }

    public Student next() {
        Student student = students.get(cursor);
        cursor ++;
        return student;
    }

    public void remove() {
        students.remove(cursor);
    }
}
