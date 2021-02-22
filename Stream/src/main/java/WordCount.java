import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;

public class WordCount {
    public Topology createTopology( ){
        StreamsBuilder builder = new StreamsBuilder();
        // 監聽 Kafka 裡 topic 為 word-count-input 收到的資料
        KStream<String, String> textLines = builder.stream("word-count");
        KTable<String, Long> wordCounts = textLines
                // 查看收到的資料值
                .peek((key, value) -> System.out.println(value))
                // 資料值轉成小寫
                .mapValues(textLine -> textLine.toLowerCase())
                // 把值轉成鍵值
                .selectKey((key, word) -> word)
                // 依據鍵值Group資料
                .groupByKey()
                // 計算每一個Group裡的數量
                .count(Materialized.as("Counts"));

        // 把計算好的資料寫回 Kafka 的 word-count-output topic，並指定key跟value的型態。
        wordCounts.toStream().to("word-count-out", Produced.with(Serdes.String(), Serdes.Long()));

        return builder.build();
    }
}
