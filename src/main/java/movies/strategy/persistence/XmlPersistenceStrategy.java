package movies.strategy.persistence;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class XmlPersistenceStrategy<T> implements LocalPersistenceStrategy<T> {

    @Override
    public void save(T data, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            JAXBContext context = JAXBContext.newInstance(data.getClass());
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(data, writer);
        } catch (JAXBException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public T load(String filePath, Class<?> classOfT) {
        try {
            JAXBContext context = JAXBContext.newInstance(classOfT);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            T some = (T) unmarshaller.unmarshal(new FileReader(filePath));

            return some;
        } catch (JAXBException | IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
