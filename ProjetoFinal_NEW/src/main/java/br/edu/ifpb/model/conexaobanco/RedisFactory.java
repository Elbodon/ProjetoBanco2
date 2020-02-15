package br.edu.ifpb.model.conexaobanco;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisFactory {

    private static final String redisHost = "localhost";
    private static final Integer redisPort = 6379;

    private static Jedis jedis = null;

    public Jedis conexao() {
        jedis = new Jedis(redisHost, redisPort);
        return jedis;
    }

}
