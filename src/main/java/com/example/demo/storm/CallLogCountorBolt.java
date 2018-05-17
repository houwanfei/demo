package com.example.demo.storm;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther houwanfei
 * @create 2018-05-15 下午2:06
 */
public class CallLogCountorBolt implements IRichBolt{
    private static final Logger logger = LoggerFactory.getLogger(CallLogCountorBolt.class);
    private Map<String, Integer> countMap;
    private OutputCollector collector;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = outputCollector;
        this.countMap = new HashMap<>();
    }

    @Override
    public void execute(Tuple tuple) {
        String call = tuple.getString(0);
        Integer duration = tuple.getInteger(1);

        if (countMap.containsKey(call)){
            countMap.put(call, 1);
        } else {
            Integer c = countMap.get(call) + 1;
            countMap.put(call, c);
        }

        collector.ack(tuple);
    }

    @Override
    public void cleanup() {
        for (Map.Entry<String, Integer> entry : countMap.entrySet()){
            logger.info("通话count" + entry.getKey() + " : " + entry.getKey());
            System.out.println(entry.getKey() + " : " + entry.getKey());
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("call"));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
