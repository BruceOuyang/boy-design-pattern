package bugmakers.club.dp.behavioral.seq04.iterator.demooptimized.javaiterator;

import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/23 15:05
 */
public class StudentList extends AbstractObjectList {

    public StudentList(List<Object> students) {
        super(students);
    }

    @Override
    public Iterator createIterator() {
        return new StudentIterator(this);
    }
}
