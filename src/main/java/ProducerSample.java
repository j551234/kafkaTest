import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerSample {
    public static void main(String[] args) {

        final String TOPIC = "testTopic";
        final String BOOTSTRAP_SERVERS = "10.3.0.65:9092";
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaExampleProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());

        final Producer<Long, String> producer = new KafkaProducer<>(props);

        try {
            while (true) {
                long time = System.currentTimeMillis();
                final ProducerRecord<Long, String> record =
                        new ProducerRecord<>(TOPIC, time,
                                "Hello world " + time);

                RecordMetadata metadata = producer.send(record).get();

                long elapsedTime = System.currentTimeMillis() - time;
                System.out.printf("sent record(key=%s value=%s) " +
                                "meta(partition=%d, offset=%d) time=%d\n",
                        record.key(), record.value(), metadata.partition(),
                        metadata.offset(), elapsedTime);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.flush();
            producer.close();
        }
    }


}
