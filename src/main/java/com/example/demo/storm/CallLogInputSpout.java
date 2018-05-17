package com.example.demo.storm;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichSpout;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @auther houwanfei
 * @create 2018-05-15 下午1:47
 */
public class CallLogInputSpout implements IRichSpout{
    private SpoutOutputCollector collector;

    private boolean completed = false;

    private Integer idx = 0;

    private TopologyContext context;

    private Random random = new Random();

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.collector = spoutOutputCollector;
        this.context = topologyContext;
    }

    @Override
    public void close() {

    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void nextTuple() {
        if (this.idx <= 1000){
            List<String> mobileNumbers = new ArrayList<>();
            mobileNumbers.add("15757124563");
            mobileNumbers.add("15757124564");
            mobileNumbers.add("15757124565");
            mobileNumbers.add("15757124566");

            Integer localIdx = 0;

            while (localIdx++ < 100 && this.idx++ < 1000){
                String fromMobileNumber = mobileNumbers.get(random.nextInt(4));
                String toMobileNumber = mobileNumbers.get(random.nextInt(4));
                while (fromMobileNumber == toMobileNumber){
                    toMobileNumber = mobileNumbers.get(random.nextInt(4));
                }

                Integer duration = random.nextInt(60);
                this.collector.emit(new Values(fromMobileNumber, toMobileNumber, duration));
            }
        }
    }

    @Override
    public void ack(Object o) {

    }

    @Override
    public void fail(Object o) {

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("from", "to", "duration"));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
