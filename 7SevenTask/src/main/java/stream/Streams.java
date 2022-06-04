package stream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Streams {
    public static void arrToOutStream(int[] arr, OutputStream out) throws IOException {
        if (arr == null) {
            throw new IllegalArgumentException("Array is null");
        }
        try (DataOutputStream stream = new DataOutputStream(out)) {
            for (int elem : arr) {
                stream.writeInt(elem);
            }

        }
    }

    public static int[] arrFromStream(int[] arr, InputStream in) throws IOException {
        if (arr == null) {
            throw new IllegalArgumentException("Array is null");
        }
        try (DataInputStream stream = new DataInputStream(in)) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = stream.readInt();
            }
            return arr;
        }
    }

    public static void arrToStream(int[] arr, Writer writer) throws IOException {
        if (arr == null) {
            throw new IllegalArgumentException("Array is null");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (int elem : arr) {
                bufferedWriter.write(Integer.toString(elem));
                bufferedWriter.write(' ');
            }
        }
    }

    public static int[] streamToArr(int[] arr, Reader reader) throws IOException {
        if (arr == null) {
            throw new IllegalArgumentException("Array is null");
        }
        try (BufferedReader stream = new BufferedReader(reader)) {
            String[] numbers = stream.readLine().split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(numbers[i]);
            }
            return arr;
        }
    }

    public static int[] readFileFromIndex(int[] arr, String file, int index) throws IOException {
        if (arr == null || file == null) {
            throw new IllegalArgumentException("Wrong input");
        }
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(index * 4L);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = raf.readInt();
            }
            return arr;
        }
    }

    /**
     * 5+extension
     * @param dir
     * @param pattern
     * @return
     */
    public static List<String> getFilesWithSpecificExtension(String dir, String pattern) {
        if (dir == null || dir.isBlank() || pattern == null) {
            throw new IllegalArgumentException("Wrong input");
        }
        File directory = new File(dir);
        List<String> result = new ArrayList<>();
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (Pattern.matches(pattern, file.getName())) {
                result.add(file.getAbsolutePath());
            }
            if (file.isDirectory()) {
                result.addAll(getFilesWithSpecificExtension(file.getPath(), pattern));
            }
        }
        return result;
    }


}
