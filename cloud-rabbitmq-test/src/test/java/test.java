import com.atguigu.rabbitmq.entity.Student;
import lombok.SneakyThrows;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
import java.util.TreeSet;

/**
 * @author dongjunzi
 * @version 1.0
 * @date 2022/7/29 14:33
 */
public class test {

    @SneakyThrows
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();


        HashSet<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(1);
        System.out.println(integers.size());

        HashSet<Student> students = new HashSet<>();
        Student student = new Student("张三", 3);
        Student student1 = new Student("张二", 2);
        students.add(student);
        students.add(student1);
        System.out.println(students);

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("cloud-rabbitmq-test/src/main/resources/test.txt"), StandardCharsets.UTF_8);
        Properties properties = new Properties();
        properties.load(inputStreamReader);
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("age"));

        TreeSet<Student> students1 = new TreeSet<>();
        students1.add(student);
        students1.add(student1);
        System.out.println(students1);

    }
}
