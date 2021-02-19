import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.opencsv.CSVReader;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

public class CSVTransformer {
    private static final String sourceFilePath = "/home/james/下載/2008.csv";

    public static void main(String[] args) throws Exception {

        readObjectsFromCsv();

    }

    public static void readObjectsFromCsv() throws IOException {
        Pattern pattern = Pattern.compile(",");
        final Producer<Long, String> producer = KafkaProducerExample.createProducer();
        try (BufferedReader in = new BufferedReader(new FileReader(sourceFilePath));) {
            in
                    .lines()
                    .skip(1)
                    .map(line -> {
                        String[] x = pattern.split(line);
                        return new CSVModel(x[0], x[1], x[2], x[3], x[4], x[5], x[6], x[7], x[8], x[9], x[10], x[11],
                                x[12], x[13], x[14], x[15], x[16], x[17], x[18], x[19], x[20], x[21], x[22], x[23],
                                x[24], x[25],
                                x[26], x[27], x[28]);
                    }).map(csv -> {
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonString = null;
                try {
                    jsonString = objectMapper.writeValueAsString(csv);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                return jsonString;
            })
                    .forEach(s -> {
                        System.out.println(s);
                        final ProducerRecord<Long, String> record =
                                new ProducerRecord<>("testTopic", s);

                        try {
                            RecordMetadata metadata = producer.send(record).get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }

                    });
        }


    }


}
