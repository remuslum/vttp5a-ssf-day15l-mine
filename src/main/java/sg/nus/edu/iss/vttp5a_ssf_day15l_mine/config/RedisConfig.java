package sg.nus.edu.iss.vttp5a_ssf_day15l_mine.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.model.Person;
import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.util.Utility;

@Configuration
public class RedisConfig {
    @Value("${spring.data.redis.host}")
    private String redisHost;

    @Value("${spring.data.redis.port}")
    private Integer redisPort;

    @Value("${spring.data.redis.username}")
    private String redisUsername;

    @Value("${spring.data.redis.password}")
    private String redisPassword;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
        rsc.setHostName(redisHost);
        rsc.setPort(redisPort);
        
        if(redisUsername.trim().length() > 0){
            rsc.setUsername(redisUsername);
            rsc.setPassword(redisPassword);
        }

        JedisClientConfiguration jcc = JedisClientConfiguration.builder().build();
        JedisConnectionFactory jcf = new JedisConnectionFactory(rsc);
        jcf.afterPropertiesSet();

        return jcf;
    }

    @Bean(Utility.TEMPLATE01)
    public RedisTemplate<String, Person> createRedisTemplate01(){
        RedisTemplate<String, Person> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }



    
}
