import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.atguigu.rabbitmq.entity.Student;
import com.sun.deploy.util.StringUtils;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dongjunzi
 * @version 1.0
 * @date 2022/7/29 14:33
 */
public class test {

    @SneakyThrows
    public static void main(String[] args) {

        //1.创建Optional对象，如果参数为空直接抛出异常
        Optional<String> str=Optional.of("a");

        //2.获取Optional中的数据,如果不存在，则抛出异常
        System.out.println(str.get());

        //3.optional中是否存在数据
        System.out.println(str.isPresent());

        //4.获取Optional中的值，如果值不存在，返回参数指定的值
        System.out.println(str.orElse("b"));

        //5.获取Optional中的值，如果值不存在，返回lambda表达式的结果
        System.out.println(str.orElseGet(()->new Date().toString()));

        //6.获取Optional中的值，如果值不存在，抛出指定的异常
        System.out.println(str.orElseThrow(RuntimeException::new));



        Optional<String> str2=Optional.ofNullable(null);

        //7.optional中是否存在数据
        System.out.println(str2.isPresent());

        //8.获取Optional中的值，如果值不存在，返回参数指定的值
        System.out.println(str2.orElse("b"));

        //9.获取Optional中的值，如果值不存在，返回lambda表达式的结果
        System.out.println(str2.orElseGet(()->new Date().toString()));

        //10.获取Optional中的值，如果值不存在，抛出指定的异常
        System.out.println(str2.orElseThrow(RuntimeException::new));


        List<String> list3 =new ArrayList<>();

        HashMap<String, List<Student>> stringStudentHashMap = new HashMap<>();
        //Optional.ofNullable(stringStudentHashMap)
        //stringStudentHashMap.values().stream().map(v->v.stream().map())

        List<String> collect = Optional.ofNullable(stringStudentHashMap).orElse(new HashMap<>()).values().stream().flatMap(student -> student.stream().map(Student::getName)).collect(Collectors.toList());

        List<String> collect1 = stringStudentHashMap.values().stream().flatMap(student -> student.stream().map(Student::getName)).collect(Collectors.toList());
        //Optional.ofNullable(list3).flatMap()

        for (String s : Optional.ofNullable(list3).orElse(new ArrayList<>())) {
            System.out.println(s);
        }

        String szl = "jay@huaxiao";
        String orElse = Optional.ofNullable(szl).orElse("暂无维护");

        System.out.println(orElse);

        //Optional<Object> empty = Optional.empty();

        //Optional<String> szl1 = Optional.ofNullable(szl).or

        //strOptional.ifPresent();

        //strOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Null"));


        List<File> resultFiles = queryResultFile();
        if (CollUtil.isNotEmpty(resultFiles)){
            for (File resultFile : resultFiles) {
                StringBuilder builder = new StringBuilder();
                List<String> list = FileUtil.readLines(resultFile, "GBK");
                builder.append(StrUtil.join("\n", list));
                String data = builder.toString();
                System.out.println(data);
            }
        }

        staticInClass staticInClass = new staticInClass();
        test.staticInClass staticInClass1 = new staticInClass();

        test test = new test();
        InClass inClass = new InClass();

        staticInClass.setBloodType("静态内部类1");
        staticInClass1.setBloodType("静态内部类2");
        inClass.setBloodType("非静态内部类1");

        System.out.println(staticInClass);
        System.out.println(staticInClass1);
        System.out.println(inClass);



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

        TreeMap<Integer, Student> stringStudentTreeMap = new TreeMap<>();
        stringStudentTreeMap.put(2,student1);
        stringStudentTreeMap.put(1,student);
        System.out.println(stringStudentTreeMap);

        HashMap<String, Student> hashMap = new HashMap<>();

        System.out.println(7>>>3);
        //System.out.println(1<<<4);

        int cap=111111;
        int result=tableSizeFor(cap);//8
        System.out.println(result);

        String foldS = ">=23";
        BigDecimal bigDecimal = new BigDecimal(foldS);
        //System.out.println(bigDecimal);

        /*CompletableFuture[] futureArray = dataList.stream().map(data -> CompletableFuture.supplyAsync(() -> query(data), asyncExecutor).whenComplete((result, th) -> {})).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(futureArray).join();*/

    }
    static int tableSizeFor(int cap) {
        int n = cap - 1;
        //  >>>：无符号右移。无论是正数还是负数，高位通通补0。
        n |= n >>> 1;//  00000100 | 00000010 = 00000110  6
        n |= n >>> 2; // 00000110 | 00000011 = 00000111  7
        n |= n >>> 4; // 00000111 | 00000000 = 00000111  7
        n |= n >>> 8; // 00000111 | 00000000 = 00000111  7
        n |= n >>> 16;// 00000111 | 00000000 = 00000111  7
        return n + 1;// 00001000 =8
        //原来是00000100，变成了00000111，最后加1，就变成2的整数次方数00001000
    }
    @Data
    public static class staticInClass{ public String bloodType;}
    @Data
    public static class InClass{ public String bloodType;}

    private static List<File> queryResultFile() {
        String path = "D:\\lis";
        File[] files = new File(path).listFiles();
        if (Objects.isNull(files)) {
            return null;
        }
        String today = DateUtil.today().replaceAll("-", "").substring(0,4);
        List<File> fileList = Arrays.stream(files).filter(f -> f.getName().contains(today)).collect(Collectors.toList());
        if (CollUtil.isEmpty(fileList)) {
            return null;
        }
        return fileList;
    }
}

