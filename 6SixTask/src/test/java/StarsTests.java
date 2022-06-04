public class StarsTests {
}

//    @Test
//    public void sortByAgeAndLetterTest(){//11
//        Set<Human> set = new HashSet<>();
//        Collections.addAll(set, human, human2, human1);
//
//
//        List<Human> humanJ18 = new ArrayList<>();
//        humanJ18.add(human);
//
//        List<Human> human1j19 = new ArrayList<>();
//        human1j19.add(human1);
//        List<Human> human2J19 = new ArrayList<>();
//        human2J19.add(human2);
//
//        Map<Character, List<Human>> map = new HashMap<>();
//        map.put('J', humanJ18);
//        Map<Character, List<Human>> map1 = new HashMap<>();
//        map1.put('j', human1j19);
//        Map<Character, List<Human>> map2 = new HashMap<>();
//        map1.put('J', human2J19);
//        Map<Integer, Map<Character, List<Human>>> actual = sortByAgeAndLetters(set);
//
//        Map<Integer, Map<Character, List<Human>>> expected = new HashMap<>();
//        expected.put(18, map);
//        expected.put(19, map1);
//
//        assertEquals(actual, expected);
//    }