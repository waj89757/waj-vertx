package com.jjbond.Java8.lambda;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ccelloeurdy on 2017/1/25.
 * function stream()
 */
public class StreamTest {

    @Test
    public void test1(){

        List<String> a = Lists.newArrayList("a","b","a","c","d","a");
        List<String> b = a.stream().filter(name -> !name.equals("a")).collect(Collectors.toList());
        System.out.println(b);
    }

    @Test
    /**
     * 创建Stream
     */
    public void test2(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 5,1,2,3,4,5);
        Stream<String> stringStream1 = Stream.generate(new Supplier<String>() {
            @Override
            public String get() {
                return "a" + Math.random();
            }
        });
        Stream<String> stringStream2 = Stream.generate( () -> "a" + Math.random());
        System.out.println(stringStream1.filter(name -> !name.equals("a")).limit(10).collect(Collectors.toList()));
        Stream<Integer> integerStream1 =  integerStream.distinct();
        Stream<Integer> integerStream2 = integerStream1.filter(name -> name > 3);
        Stream<Integer> integerStream3 = integerStream2.map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 3;
            }
        });
        Stream<Integer> integerStream4 = integerStream3.flatMap(new Function<Integer, Stream<? extends Integer>>() {
            @Override
            public Stream<? extends Integer> apply(Integer integer) {
                return Stream.of(integer + 10);
            }
        });
        Stream<Integer> integerStream5 = integerStream4.peek(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("consumer : " + integer);
            }
        });
        System.out.println("1 : " + integerStream5.collect(Collectors.toList()));
    }

    /**
     * 聚合reduce
     */
    @Test
    public void reduceStream(){

        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,10,0,0,0);
        Optional<Integer> optional = list.stream().reduce((sum, item) -> {return (sum + item);});
        System.out.println(optional.get());
        long count =  list.stream().count();
        System.out.println(count);
        list.stream().collect(Collectors.toList());
    }


}
