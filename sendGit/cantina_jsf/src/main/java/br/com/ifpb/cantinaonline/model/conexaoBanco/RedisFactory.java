package br.com.ifpb.cantinaonline.model.conexaoBanco;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisFactory {

    private static final String redisHost = "localhost";
    private static final Integer redisPort = 6379;

    private static JedisPool pool = null;

    public Jedis RedisFactory() {
        //configure our pool connection
        pool = new JedisPool(redisHost, redisPort);
        return pool.getResource();
    }

}
