package com.jjbond.Java8;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ccelloeurdy on 2017/1/24.
 */
public class LambdaTest {

    @Test
    public void test1(){
        List<String> names = new ArrayList();
        names.add("b");
        names.add("a");
        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
        System.out.println(names.get(0));

    }

    @Test
    public void test2(){
        //----------命令式变成风格
        List<String> names = new ArrayList<>();
        names.add("TaoBao");
        names.add("ZhiFuBao");
        List<String> lowercaseNames = new ArrayList<>();
        for (String name : names) {
            lowercaseNames.add(name.toLowerCase());
        }
//------------------文艺青年写法：声明式的编程风格
        lowercaseNames = FluentIterable.from(names).transform(new Function<String, String>() {
            @Override
            public String apply(String name) {
                return name.toLowerCase();
            }
        }).toList();
        names.add("sb");
        FluentIterable<String> filterName = FluentIterable.from(names).filter(new Predicate<String>() {
            @Override
            public boolean apply(String s) {
                if(s.equals("sb"))
                    return false;
                return true;
            }
        });
        System.out.println(filterName.toList());
//--------------lamdba
        List<String> namess = new ArrayList<>();
        namess.add("TaoBao");
        namess.add("ZhiFuBao");
        List<String> lowercaseNamess = namess.stream().map((String name) -> {return name.toLowerCase();}).collect(Collectors.toList());
        System.out.println(lowercaseNamess);
        //lamdba表达式省略写法
        List<String> lowercaseNames2 = namess.stream().map(name -> name.toLowerCase()).collect(Collectors.toList());
        System.out.println(lowercaseNames2);
    }

    @Test
    public void test3(){
        String[] array = {"a", "b", "c"};
        //引用外部变量 不过外部变量是final类型不能改变（jdk1.8不用显式声明final）
        for(Integer i : Lists.newArrayList(1,2,3)){
            Stream.of(array).map(item -> Strings.padEnd(item, i, '@')).forEach(System.out::println);
        }

    }

}
