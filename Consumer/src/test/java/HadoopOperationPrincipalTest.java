import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.security.UserGroupInformation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class HadoopOperationPrincipalTest {
    private final static String HDFS_PRINCIPAL = "hdfs/master@JAMESTEST.COM";
    private final static String RESOURCE_PATH = "src/main/resources/";
    private final static String KEY_TAB_PATH = RESOURCE_PATH + "hdfs.keytab";
    Configuration configuration = new Configuration();


    @BeforeAll
    static void setEnvironment() throws IOException {
        System.setProperty("java.security.krb5.conf", new Path(RESOURCE_PATH + "krb5.conf").toString());

        Configuration configuration = new Configuration();
        configuration.set("hadoop.security.authentication", "kerberos");
        configuration.setBoolean("hadoop.security.authorization", true);
        configuration.addResource(new Path(RESOURCE_PATH + "hdfs-site.xml"));
        configuration.addResource(new Path(RESOURCE_PATH + "core-site.xml"));

        UserGroupInformation.setConfiguration(configuration);

        UserGroupInformation.loginUserFromKeytab(HDFS_PRINCIPAL, KEY_TAB_PATH);
        FileSystem fileSystem = FileSystem.get(configuration);


    }


    @Test
    void appendTest() throws IOException {
        UserGroupInformation.loginUserFromKeytab(HDFS_PRINCIPAL, KEY_TAB_PATH);
        FileSystem fileSystem = FileSystem.get(configuration);
        //Create a path
        String fileName = "read_write_hdfs_example.txt";
        Path hdfsWritePath = new Path("/james2021/" + fileName);
        FSDataOutputStream fsDataOutputStream = fileSystem.append(hdfsWritePath);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fsDataOutputStream, StandardCharsets.UTF_8));
        bufferedWriter.write("Java API to append data in HDFS file");
        bufferedWriter.newLine();
        bufferedWriter.close();
        fileSystem.close();

    }


}
