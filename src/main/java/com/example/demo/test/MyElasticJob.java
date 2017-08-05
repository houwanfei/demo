package com.example.demo.test;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * Created by houwanfei on 2017/7/25.
 */
public class MyElasticJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("My First ElasticJob Running!"+shardingContext.getShardingItem());
    }
}
