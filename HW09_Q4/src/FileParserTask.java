import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FileParserTask implements Runnable {
    private File file;
    private Map<String, Number> namesCount;
    private Map<String, Number> occupationsCount;

    public FileParserTask(File file, Map<String, Number> namesCount, Map<String, Number> occupationsCount) {
        this.file = file;
        this.namesCount = namesCount;
        this.occupationsCount = occupationsCount;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming the first name is the first value and occupation is the second value in the CSV
                String[] values = line.split(",");
                String name = values[3].trim();
                String occupation = values[1].trim();

                namesCount.merge(name, 1, (currentValue, one) -> (currentValue != null ? currentValue.intValue() : 0) + one.intValue());
                occupationsCount.merge(occupation, 1, (currentValue, one) -> (currentValue != null ? currentValue.intValue() : 0) + one.intValue());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
