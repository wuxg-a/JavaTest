package com.wxg.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by wuxg-a on 2017/9/15.
 */
public class Java8Test {
    public static void main(String[] args) {


        //lambda表达式的使用
        Arrays.asList("a", "b","c").forEach(e -> System.out.println(e));

        //函数式接口
        // 使用lambda表达式，解释器会生成一个单接口的实例：converter
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        System.out.println(converter.convert("1"));

        //方法引用
        Converter<String, Integer> converter1 = Integer::valueOf;
        System.out.println(converter.convert("2"));
        //构造函数引用
        Converter<String, Integer> converter2 = Integer::new;
        System.out.println(converter.convert("3"));

        //stream
        Arrays.asList("b@qq.COM", "a@qq.COM","c@glodon.COM")
                .stream()
                .filter(e -> e.contains("qq"))
                .sorted((e1, e2) -> e1.compareTo(e2))
                .map(e -> e.toLowerCase())
                .forEach(System.out::println);

        //optional
        Optional empty = Optional.ofNullable("sds");
        System.out.println(empty.orElse("This is no value present"));

        try {
            empty.orElseThrow(IllegalArgumentException::new);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        //stream转map(去重)
        //Function.identity() ： 返回stream中的元素
        List<Department> departments = Arrays.asList(new Department("1", "test1"), new Department("2", "test2"), new Department("1", "test3"));
        Map<String, Department> map = departments.stream().collect(Collectors.toMap(
                Department :: getId ,
                department -> department,
                (newKeyValue, existing) -> newKeyValue, //去除重复，如果重复取新值
                HashMap::new));

        List<Department> list = map.values().stream().collect(Collectors.<Department>toList());
        list.forEach(l -> System.out.println(l.getName()));

        //GroupBy
        Map<String, List<Department>> mapGroup = departments.stream()
                .collect(Collectors.groupingBy(Department::getId));
        System.out.println(mapGroup.size());

        Department department0 = new Department("0", "dep0", Boolean.FALSE);
        Department department1 = new Department("1", "dep1", Boolean.TRUE);
        Department department2 = new Department("2", "dep2", Boolean.TRUE);
        List<Department> deps = new ArrayList<>();
        deps.add(department0);
        deps.add(department1);
        deps.add(department2);

        List<String> listArray = Arrays.asList("a", "c" , "b", "d", "b");

        Collections.sort(listArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("Collections.sort: " + listArray);

    }

}
