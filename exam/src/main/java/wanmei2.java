import java.util.*;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/8 19:58
 * @Description:
 */
public class wanmei2 {

    public static class Item{
        public final String name;
        public int num;

        public Item(String name,int num) {
            this.name = name;
            this.num = num;
        }

        @Override
        public String toString(){
            return "[" + name + "," + num + "]";
        }
    }

    public List<Item> tryAddAndPack(List<Item> itemList, List<Item> itemAddList, Map<String, Integer> confMap, int capacity) {
        List<Item> tidy = tidy(itemList, confMap);
        List<Item> res = tidy(tidy, confMap, itemAddList);
        if (res.size()>capacity){
            return tidy;
        }
        else {
            return res;
        }
    }
    
    
    class MyComparator implements Comparator<Item>{

        @Override
        public int compare(Item o1, Item o2) {
            if (!o1.name.equals(o2.name)){
                return o1.name.compareTo(o2.name);
            }
            else {
                if (o1.num>10){
                    return 0;
                }
                else {
                    return -1;
                }
            }
        }
    }
    public List<Item> tidy(List<Item> itemList,Map<String, Integer> confMap){
        List<Item> res = new LinkedList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for (Item item : itemList) {
            String name = item.name;
            int num = item.num;
            if (map.containsKey(name)){
                map.put(name,num+map.get(name));
            }
            else {
                map.put(name,num);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String name = entry.getKey();
            int num = entry.getValue();
            while (num>confMap.get(name)){
                Item item  = new Item(name,confMap.get(name));
                res.add(item);
                num-=confMap.get(name);
            }
            if (num!=0){
                Item item  = new Item(name,num);
                res.add(item); 
            }
        }
        Collections.sort(res,new MyComparator());
        return  res;
    }

    public List<Item> tidy(List<Item> itemList,Map<String, Integer> confMap, List<Item> itemAddList){
        List<Item> res = new LinkedList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for (Item item : itemList) {
            String name = item.name;
            int num = item.num;
            if (map.containsKey(name)){
                map.put(name,num+map.get(name));
            }
            else {
                map.put(name,num);
            }
        }
        for (Item item : itemAddList) {
            String name = item.name;
            int num = item.num;
            if (map.containsKey(name)){
                map.put(name,num+map.get(name));
            }
            else {
                map.put(name,num);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String name = entry.getKey();
            int num = entry.getValue();
            while (num>confMap.get(name)){
                Item item  = new Item(name,confMap.get(name));
                res.add(item);
                num-=confMap.get(name);
            }
            if (num!=0){
                Item item  = new Item(name,num);
                res.add(item);
            }
        }
        Collections.sort(res,new MyComparator());
        return  res;
    }
    
}
