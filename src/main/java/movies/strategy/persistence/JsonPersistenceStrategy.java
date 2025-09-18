package movies.strategy.persistence;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

public class JsonPersistenceStrategy<T> implements LocalPersistenceStrategy<T> {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void save(T data, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            String JSONString = gson.toJson(data, data.getClass());
            writer.write(JSONString);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public T load(String filePath, Class<?> classOfT) {
        try (JsonReader reader = new JsonReader(new FileReader(filePath))) {
            T data = gson.fromJson(reader, classOfT);
            return data;
        } catch (IOException | JsonSyntaxException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
