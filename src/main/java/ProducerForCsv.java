import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.CSVModel;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import prototype.KafkaProducerExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ProducerForCsv {
    private static final String sourceFilePath = "/home/james/下載/2008.csv";
    private static Logger logger = LoggerFactory.getLogger(ConsumerSample.class.getName());
    private static final String TOPIC = "testTopic";

    public static void main(String[] args) throws Exception {
        postCSVToTopic(TOPIC);
    }

    private static void postCSVToTopic(String topic) throws IOException {
        final Producer<Long, String> producer = KafkaProducerExample.createProducer();
        try (BufferedReader in = new BufferedReader(new FileReader(sourceFilePath));) {
            in.lines()
                    .skip(1)
                    .map(csvLine -> transferCsvToJson(csvLine))
                    .forEach(s -> {
                        System.out.println(s);
                        final ProducerRecord<Long, String> record =
                                new ProducerRecord<>(topic, s);
                        try {
                            RecordMetadata metadata = producer.send(record).get();
                        } catch (Exception e) {
                            logger.error(e.getMessage(), e);
                        }

                    });
        }


    }


    private static String transferCsvToJson(String csvLine) {
        Pattern pattern = Pattern.compile(",");
        String[] x = pattern.split(csvLine);
        CSVModel csvObject = new CSVModel(x[0], x[1], x[2], x[3], x[4], x[5], x[6], x[7], x[8], x[9], x[10], x[11],
                x[12], x[13], x[14], x[15], x[16], x[17], x[18], x[19], x[20], x[21], x[22], x[23],
                x[24], x[25],
                x[26], x[27], x[28]);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(csvObject);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(), e);
        }
        return jsonString;

    }

}
