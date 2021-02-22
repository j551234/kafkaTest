import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ConsumerForCSV {
    private static final String TOPIC = "testTopic";

    public static void main(String... args) throws Exception {


    }

    public void runConsumer() {
        final Consumer<Long, String> consumer = KafkaConsumerExample.createConsumer(TOPIC);

        final int giveUp = 100;
        int noRecordsCount = 0;

        while (true) {
            final ConsumerRecords<Long, String> consumerRecords =
                    consumer.poll(Duration.of(1000, ChronoUnit.MILLIS));

            if (consumerRecords.count() == 0) {
                noRecordsCount++;
                if (noRecordsCount > giveUp) break;
                else continue;
            }

            consumerRecords.forEach(record -> {
                System.out.println(record.value());
            });

            consumer.commitAsync();
        }
        consumer.close();
        System.out.println("DONE");
    }


    public void writeFileToHdfs(String path){

    }
}
