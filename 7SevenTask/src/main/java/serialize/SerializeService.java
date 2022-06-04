package serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class SerializeService {
    public static String HouseToJson(House house) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(house);
    }

    public static House HouseFromJson(String JSON) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(JSON, House.class);
    }
    public static void serialize(Serializable obj, FileOutputStream outputStream) {
        try (ObjectOutputStream stream = new ObjectOutputStream(outputStream)) {
            stream.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static House deserializeHouse(FileInputStream inputStream) throws IOException {
        try (ObjectInputStream stream = new ObjectInputStream(inputStream)) {
            return (House) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("ERROR");
        }
    }


    public static Person deserializePerson(FileInputStream inputStream) throws IOException {
        try (ObjectInputStream stream = new ObjectInputStream(inputStream)) {
            return (Person) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("ERROR");
        }
    }

    public static Flat deserializeFlat(FileInputStream inputStream) throws IOException {
        try (ObjectInputStream stream = new ObjectInputStream(inputStream)) {
            return (Flat) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("ERROR");
        }
    }
}