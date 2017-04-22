package com.aolei.spider.test;

import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/4/20.
 */
public class RedisTest {
    private static Jedis jedis;
    public static void main(String args[]){
        jedis = RedisUtils.getJedis();
        //jedis.auth("admin");
        jedis.set("test","test");
        System.out.println(jedis.get("test"));
    }
}
