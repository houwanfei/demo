package com.example.demo;

import com.example.demo.storm.CallLogCountorBolt;
import com.example.demo.storm.CallLogCreatorBolt;
import com.example.demo.storm.CallLogInputSpout;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @auther houwanfei
 * @create 2018-05-15 下午2:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StormTests {

    @Test
    public void stormTest() throws InterruptedException {
        Config config = new Config();
        config.setDebug(true);


        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("call-log-reader-spout", new CallLogInputSpout());
        builder.setBolt("call-log-creator-bolt", new CallLogCreatorBolt())
                .shuffleGrouping("call-log-reader-spout");
        builder.setBolt("call-log-countor-bolt", new CallLogCountorBolt())
                .fieldsGrouping("call-log-creator-bolt", new Fields("call"));

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("LogAnalyStorm", config, builder.createTopology());

        Thread.sleep(10000);


        cluster.shutdown();
    }
}
