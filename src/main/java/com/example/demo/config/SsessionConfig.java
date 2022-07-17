package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**等同于Spring的application.xml文件
 * */
@Configuration
class SsessionConfig {
    /** <!--Spring session的配置类-->
     *  <bean class="org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration">
     *       <property name="maxInactiveIntervalInseconds" value="3600"/>
     *       <property name="cookieSerializer" ref="defaultCookieSerializer"/>
     *  </bean>
     * */
    @Bean
    public RedisHttpSessionConfiguration redisHttpSessionConfiguration(){
        RedisHttpSessionConfiguration redisHttpSessionConfiguration=new
                RedisHttpSessionConfiguration();
        /**等同于<property name="maxInactiveIntervalInseconds" value="3600"/>
         * 设置session连接超时时间
         * */
        redisHttpSessionConfiguration.setMaxInactiveIntervalInSeconds(3600);
        /**等同于<property name="cookieSerializer" ref="defaultCookieSerializer"/>
         * 设置默认使用的cookie
         * */
        redisHttpSessionConfiguration.setCookieSerializer(defaultCookieSerializer());
        return redisHttpSessionConfiguration;
    }

    /**  <!--设置cookie的存放方式-->
     *   <bean id="defaultCookieSerializer" class="org.springframework.session.web.http.DefaultCookieSerializer">
     *      <property name="cookiePath" value="/"/>
     *      <property name="domainName" value="web.com"/>
     *   </bean>
     * */
    @Bean
    public DefaultCookieSerializer defaultCookieSerializer(){
        DefaultCookieSerializer defaultCookieSerializer=new DefaultCookieSerializer();
        /**等同于<property name="cookiePath" value="/"/>
         * 把cookie写到项目根下
         * */
        defaultCookieSerializer.setCookiePath("/");
        /**等同于<property name="domainName" value="web.com"/>
         * 把cookie写到根域名下
         * */
        defaultCookieSerializer.setDomainName("127.0.0.1");
        return defaultCookieSerializer;
    }
}
