package com.tj.library_sys.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
  static void arraysStream(){
    System.out.println("hello world");
    //数组使用stream
    int[] arraysNum={47,48,23,55,35,44,48,32,47,59};
    int a1= Arrays.stream(arraysNum).sum();
    Stream<Integer> stream1=Stream.of(4,56,40,23,5);
    int a2=0;
    for (int n:arraysNum) {
      a2+=n;
    }
    System.out.println(a1+"--"+a2);
    //打印
    Arrays.stream(arraysNum).forEach(System.out::print);
    stream1.forEach(System.out::print);
  }
  public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
    Map<Object, Boolean> seen = new ConcurrentHashMap<>();
    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
  }
  static void listStream(){
    List<Car> listCar=new ArrayList<>();
    listCar.add(new Car(1,"apple",78,"red"));
    listCar.add(new Car(2,"apple2",74,"red"));
    listCar.add(new Car(3,"apple3",89,"red"));
    listCar.add(new Car(2,"apple4",74,"red"));
    listCar.add(new Car(5,"orange",85,"yellow"));
    listCar.add(new Car(6,"orange2",89,"yellow"));
    listCar.add(new Car(7,"sky",99,"blue"));
    List<Map<String,Object>> listbox = new ArrayList<>();
    List<Map<String,Object>> listbox2 = new ArrayList<>();
    Map<String,Object> map1 = new HashMap<>();
    Map<String,Object> map2 = new HashMap<>();
    Map<String,Object> map3 = new HashMap<>();
    Map<String,Object> map4 = new HashMap<>();
    map1.put("name","dog");
    map1.put("score",99);
    listbox.add(map1);
    map2.put("name","cat");
    map2.put("score",88);
    listbox.add(map2);
    map3.put("name","dog");
    map3.put("price",99);
    map3.put("sex","male");
    map4.put("name","person");
    map4.put("price",99);
    map4.put("sex","female");
    listbox2.add(map3);
    listbox2.add(map4);
    //把list中的对象的某个属性转换为map
    Map<String,Integer> nameToScore = listCar.stream().collect(Collectors.toMap(Car::getName,Car::getScore));
    //吧list中的对象转换为map
    Map<String,Object> nameToObject = listCar.stream().collect(Collectors.toMap(Car::getName,Car->Car));
    System.out.println(nameToScore);
    System.out.println(nameToObject);
    Map<String,Integer> ace = new HashMap<>();
    //给map排序
    nameToScore.entrySet().stream().sorted(Map.Entry.<String,Integer> comparingByValue().reversed())
            .forEachOrdered(e->ace.put(e.getKey(),e.getValue()));
    ace.entrySet().stream().forEach(System.out::print);
    //将map转化为Set
    Set<String> name = nameToScore.entrySet().stream().map(e->e.getKey()).collect(Collectors.toSet());
    name.stream().forEach(k->System.out.print(k));
//    //根据分数倒排
//    List<Car> rankColor = listCar.stream().sorted(Comparator.comparing(Car::getScore).reversed()).collect(Collectors.toList());
//    //根据id正排
//    List<Car> rankId = listCar.stream().sorted(Comparator.comparing(Car::getId)).collect(Collectors.toList());
//    rankColor.forEach(r->System.out.print(r.toString()));
//    System.out.println();
//    rankId.forEach(r->System.out.print(r.toString()));
//    System.out.println();
//    //筛选颜色为红色的,取前两个
//    listCar.stream().filter(t->t.getColor().equals("red")).limit(2).forEach(System.out::println);
//    System.out.println();
//    //去掉id重复的，在帅选颜色为红色的
//    listCar.stream().filter(distinctByKey(Car::getId)).filter(t->t.getColor().equals("red")).forEach(System.out::println);
//    //筛选分数大于75的实体，再抽取属性中的name作为新的列表。
//    List<String> changeString = listCar.stream().filter(t -> t.getScore() > 75).map(Car::getName).collect(Collectors.toList());
//    changeString.stream().forEach(System.out::println);
//    //用流的方式初始化list
//    List<String> ace= Stream.of("fly","fish","sky").collect(Collectors.toList());
//    //求两个集合的交集
//    List<String> intersect= ace.stream().filter(item->changeString.contains(item)).collect(Collectors.toList());
//    System.out.println(CollectionUtils.isEmpty(intersect));


  }
  static void reviewStream(){
    Stream<String> stringStream= Stream.of("ace","jack","made","ACE","dog");
    stringStream.filter(n->!n.equalsIgnoreCase("ace")).forEach(System.out::println);
    List<Car> carList = Arrays.asList(new Car(12,"a",75,"red"),
              new Car(14,"b",89,"red"),
              new Car(5,"c",82,"blue"),
             new Car(15,"a",85,"blue"),
            new Car(3,"d",89,"yellow"),
            new Car(15,"c",85,"blue")
            );
    carList.stream().forEach(System.out::println);
    System.out.println("下面是关于car的list的各种操作复习,1:排序");
    carList.stream().sorted(Comparator.comparing(Car::getId).reversed()).forEach(System.out::println);
    System.out.println("按颜色筛选");
    List<Car> colorList = carList.stream().filter(car->"blue".equals(car.getColor())).collect(Collectors.toList());
    colorList.forEach(n->System.out.print(n+" "));
    System.out.println("\n");
    System.out.println("按分数筛选");
    carList.stream().filter(car->"blue".equals(car.getColor())||"red".equals(car.getColor()))
            .sorted(Comparator.comparing(Car::getScore))
            .forEach(System.out::println);

  }
  public static void main(String[] args){
//    arraysStream();
//   listStream();
    int i;
    i=12;
    System.out.println(i+=i-=i*=i);
//    reviewStream();
  }
}
