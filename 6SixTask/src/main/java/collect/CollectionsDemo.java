package collect;

import humans.Human;
import humans.IHumanoid;

import java.util.*;

public class CollectionsDemo {

    /**
     * 1
     * среди входного листа строк найти те, у которых первый символ - входной
     *
     * @param stringList
     * @param symbol
     * @return count
     */
    public static int countStrings(List<String> stringList, char symbol) {
        if (stringList == null) {
            throw new IllegalArgumentException("List is null");
        }
        int count = 0;
        for (String str : stringList) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("String in string list is null");
            }
            if (str.charAt(0) == symbol) {
                count++;
            }
        }
        return count;
    }

    /**
     * 3
     *
     * @param humanList
     * @param human
     * @return result
     */
    public static List<Human> withoutHuman(List<Human> humanList, Human human) {//3::done + test
        if (humanList == null || human == null) {
            throw new IllegalArgumentException("List of human or human is null");
        }
        List<Human> result = new ArrayList<>();
        for (Human human1 : humanList) {
            if (human1 == null) {
                continue;
            }
            if (!human.equals(human1)) {
                Human human2 = new Human(human1);
                result.add(human2);
            }
        }
        return result;
    }

    /**
     * 4
     *
     * @param list
     * @param item
     * @return resultList
     */
    public static List<Set<Integer>> getNonIntersection(List<Set<Integer>> list, Set<Integer> item) {//4 done - test
        if (item == null) {
            throw new IllegalArgumentException("Set is null");
        }
        List<Set<Integer>> helpList = new ArrayList<>();
        for (Set<Integer> set : list) {
            helpList.add(new HashSet<>(set));
        }
        List<Set<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            helpList.get(i).retainAll(item);
            if (helpList.get(i).size() == 0) {
                resultList.add(list.get(i));
            }
        }
        return resultList;
    }

    /**
     * 7
     *
     * @param map
     * @param set
     * @return result
     */
    public static Set<Human> findByID(Map<Integer, Human> map, Set<Integer> set) {
        if (set == null) {
            throw new IllegalArgumentException("Set is null");
        }
        Set<Human> result = new HashSet<>();

        for (Map.Entry<Integer, Human> hum : map.entrySet()) {
            if (hum.getValue() == null) {
                throw new IllegalArgumentException("Human in map is null");
            }
            if (set.contains(hum.getKey())) {
                result.add(hum.getValue());
            }
        }
        return result;
    }

    /**
     * 8
     * @param map
     * @return result
     */
    public static List<Integer> findByAge(Map<Integer, Human> map) {
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Human> hum : map.entrySet()) {
            if (hum.getValue() == null) {
                throw new IllegalArgumentException("Human in map is null");
            }
            if (hum.getValue().getAge() >= 18) {
                result.add(hum.getKey());
            }
        }
        return result;
    }

    /**
     * 9
     * @param map
     * @return result
     */
    public static Map<Integer, Integer> idToAge(Map<Integer, IHumanoid> map) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, IHumanoid> hum : map.entrySet()) {
            if (hum.getValue() == null) {
                throw new IllegalArgumentException("Human in map is null");
            }
            result.put(hum.getKey(), hum.getValue().getAge());
        }
        return result;
    }

    /**
     * 10
     *
     * @param set
     * @return result
     */
    public static Map<Integer, List<Human>> sortByAge(Set<Human> set) {
        if (set == null) {
            throw new IllegalArgumentException("Set is null");
        }
        Map<Integer, List<Human>> result = new HashMap<>();
        for (Human human : set) {
            List<Human> list = new ArrayList<>();
            result.putIfAbsent(human.getAge(), list);
            result.get(human.getAge()).add(human);
        }
        return result;
    }

    /**
     * 11
     *
     * @param set
     * @return result
     */
    public static Map<Integer, Map<Character, List<Human>>> sortByAgeAndLetters(Set<Human> set) {
        Map<Integer, Map<Character, List<Human>>> result = new HashMap<>();
        Map<Integer, List<Human>> helpMap = sortByAge(set);
        for(Map.Entry<Integer, List<Human>> map : helpMap.entrySet()){
            for(Human human : map.getValue()){
                result.putIfAbsent(human.getAge(), new HashMap<Character, List<Human>>());
                result.get(human.getAge()).putIfAbsent(human.getSurname().charAt(0), new ArrayList<Human>());
                result.get(human.getAge()).get(human.getSurname().charAt(0)).add(human);
            }

        }
        return result;
    }
}