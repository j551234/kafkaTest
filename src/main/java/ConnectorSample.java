import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;

import java.util.Properties;

public class ConnectorSample {

    public static void main(String[] args) {

        // Kafka 連線設定
        Properties config = new Properties();
        // 設定 Consumer Group Id
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-group-id");
        // 連線 Kafka 的 host 跟 port
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "10.3.0.65:9092");
        // Consumer 從哪個地方開始讀取資料
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        // 指定資料的 key 跟 value 的型態為字串
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        //  實體化實際要產生 kafka stream 拓墣的類
        WordCount wordCount = new WordCount();
        // 啟動 kafka 連線
        KafkaStreams streams = new KafkaStreams(wordCount.createTopology(), config);
        streams.start();

        // 關閉 kafka 連線
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
        // 打印 Stream 拓墣
        streams.localThreadsMetadata().forEach(data -> System.out.println(data));
    }
}
