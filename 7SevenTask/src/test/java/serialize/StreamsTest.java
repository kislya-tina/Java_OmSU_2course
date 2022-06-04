package serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.Test;
import stream.Streams;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static serialize.SerializeService.HouseFromJson;
import static serialize.SerializeService.HouseToJson;
import static stream.Streams.arrToOutStream;
import static stream.Streams.readFileFromIndex;


public class StreamsTest {

    @Test
    public void testByteStreamOutput() throws IOException {
        int[] arr = {1, 2, 300};
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        arrToOutStream(arr, baos);
        byte[] expected = {0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 1, 44};
        assertEquals(baos.toByteArray(), expected);

    }

    @Test
    public void testByteStreamInput() throws IOException {
        int[] arr = new int[3];
        byte[] buf = {0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 1, 44};
        int[] expected = {1,2,300};
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        Streams.arrFromStream(arr, bais);
        assertEquals(arr, expected);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void intStreamNUllTest() {
        int[] arr = {1, 2, 300};
        try (OutputStream outputStream = new FileOutputStream("src\\files\\a.bin")) {
            arrToOutStream(null, outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int[] ints = new int[arr.length];
        try (InputStream inputStream = new FileInputStream("src\\files\\a.bin")) {
            Streams.arrFromStream(ints, inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(arr, ints);
    }

    @Test(expectedExceptions = {NullPointerException.class})
    public void intStreamNUllTest2() {
        int[] arr = {1, 2, 300};
        try (OutputStream outputStream = new FileOutputStream("src\\files\\b.bin")) {
            arrToOutStream(arr, (OutputStream) null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int[] ints = new int[arr.length];
        try (InputStream inputStream = new FileInputStream("src\\files\\b.bin")) {
            Streams.arrFromStream(ints, inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(arr, ints);
    }

    @Test
    public void readerWriterTest1() {
        int[] arr = {1, 2, 300};
        try (Writer writer = new OutputStreamWriter(
                new FileOutputStream("src\\files\\b.txt"),
                StandardCharsets.UTF_8)) {
            Streams.arrToStream(arr, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int[] ints = new int[arr.length];
        try (InputStreamReader reader = new InputStreamReader(
                new FileInputStream("src\\files\\b.txt"),
                StandardCharsets.UTF_8)) {
            Streams.streamToArr(ints, reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(arr, ints);
    }


    @Test
    public void readerWriterTest2() {
        int[] arr = {-1, 2, 500, 1240, -124, 124121, 125125, 12512, 2222};
        try (Writer writer = new OutputStreamWriter(
                new FileOutputStream("src\\files\\b.txt"),
                StandardCharsets.UTF_8)) {
            Streams.arrToStream(arr, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int[] ints = new int[6];
        try (InputStreamReader reader = new InputStreamReader(
                new FileInputStream("src\\files\\b.txt"),
                StandardCharsets.UTF_8)) {
            Streams.streamToArr(ints, reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(ints, new int[]{-1, 2, 500, 1240, -124, 124121});
    }
    @Test
    public void randomAccessTest() throws IOException {
        String str = "input.bin";
        OutputStream out = new FileOutputStream("input.bin");
        int[] myArray = {1, 5, 4, 3, 7, 8, 9};
        int [] arr = new int[4];
        arrToOutStream(myArray, out);
        int[] resArray= {3, 7, 8, 9};
        assertEquals(resArray, readFileFromIndex(arr, str, 3));
    }

    @Test
    public void getFilesTest() {
        List<String> expected = new ArrayList<>();
        Collections.addAll(expected,
                "D:\\Programming\\java\\InWork\\SevenTask\\src\\files\\a.bin",
                "D:\\Programming\\java\\InWork\\SevenTask\\src\\files\\a.txt",
                "D:\\Programming\\java\\InWork\\SevenTask\\src\\files\\aaaa.bin",
                "D:\\Programming\\java\\InWork\\SevenTask\\src\\files\\b.bin",
                "D:\\Programming\\java\\InWork\\SevenTask\\src\\files\\b.txt",
                "D:\\Programming\\java\\InWork\\SevenTask\\src\\files\\dir1\\bbbdir",
                "D:\\Programming\\java\\InWork\\SevenTask\\src\\files\\dir1\\bbbdir\\dir3\\bba.txt");
        assertEquals(Streams.getFilesWithSpecificExtension("src\\files\\", "[a-b]+([0-9]|[a-zA-Z]|.)*"), expected);
    }

    @Test
    public void JSONTest() throws IOException {
        Person person1 = new Person("Abc", "Abc", "Abc", "10.10.2010");
        Person person2 = new Person("Bcd", "Bcd", "Bcd", "10.10.2010");
        Person person3 = new Person("Cde", "Cde", "Cde", "10.10.2010");

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);

        Flat flat1 = new Flat(1, 31.5, personList);
        List<Person> personList1 = new ArrayList<>();
        personList1.add(person3);

        Flat flat2 = new Flat(2, 30.5, personList1);
        List<Flat> flatList = new ArrayList<Flat>();
        Collections.addAll(flatList, flat1, flat2);

        House house = new House("55", "22 Апреля", person1, flatList);
        String strJson = HouseToJson(house);

        assertEquals(house, HouseFromJson(strJson));
    }
}
