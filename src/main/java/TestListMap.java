
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;


public class TestListMap {

    public static void main(String[] args) {

        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));
        list.add(new Hosting(6, "mkyong.com", 2));
        list.add(new Hosting(5, null, 11));

        // key = id, value - websites
//        Map<Integer, String> result1 = list.stream().collect(
//                Collectors.toMap(Hosting::getId, Hosting::getName));
//
//        System.out.println("Result 1 : " + result1);
//
//        // key = name, value - websites
//        Map<String, Long> result2 = list.stream().collect(
//                Collectors.toMap(Hosting::getName, Hosting::getWebsites));
//
//        System.out.println("Result 2 : " + result2);

        // Same with result1, just different syntax
        // key = id, value = name
        Map<Integer, String> result3 = list.stream()
        		.filter(d-> null != d.getName())
        		//.max((p1, p2) -> Integer.compare(p1.getId(), p2.getId())
        		.collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));

        System.out.println("Result 3 : " + result3);
        
        
        BinaryOperator<Integer> 
        op = BinaryOperator 
                 .maxBy( 
                     (a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1)); 
        Map<Object, Integer> topEmployees =
        		list.stream()
        	            .collect(Collectors.toMap(
        	                e -> e,
        	                e1 -> e1.get,
        	                op
        	            ));

        
        
        BinaryOperator<Integer> bi = BinaryOperator.maxBy(Comparator.reverseOrder());
        System.out.println(bi.apply(2, 3));
        
        
       

   // System.out.println(op.apply(98, 11)); 
        
    }
}