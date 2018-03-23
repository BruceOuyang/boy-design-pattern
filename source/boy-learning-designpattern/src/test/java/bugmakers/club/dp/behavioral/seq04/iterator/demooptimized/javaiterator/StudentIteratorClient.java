package bugmakers.club.dp.behavioral.seq04.iterator.demooptimized.javaiterator;

import java.util.*;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/23 16:29
 */
public class StudentIteratorClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        List students = new ArrayList();
        students.add(new Student("allen", 28));
        students.add(new Student("bruce", 25));
        students.add(new Student("angela", 23));
        students.add(new Student("cc", 26));
        students.add(new Student("singe", 24));

        StudentList studentList = new StudentList(students);

        Iterator iterator = studentList.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

        // 集合排序
        Collections.sort(students, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                Student s1 = (Student) o1;
                Student s2 = (Student) o2;

                // 按照年龄降序
//                return s2.getAge() - s1.getAge();

                // 按照年龄升序
//                return s2.getAge() - s1.getAge();

                // 按照名字字母排序
                return s2.getName().compareTo(s1.getName());
            }
        });
        System.out.println(students);
    }
}
