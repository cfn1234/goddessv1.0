package com.goddess.config.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * com.goddess.config.shiro.sessionDao
 *
 * @author caofengnian
 * @Date 2019-10-18
 */
@Component
public class ShiroRedisSessionDao extends AbstractSessionDAO {

    private static final Logger logger = LoggerFactory.getLogger(ShiroRedisSessionDao.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        logger.info("创建seesion,id=[{}]", session.getId().toString());
        try {
            redisTemplate.opsForValue().set(session.getId().toString(), session, 30, TimeUnit.MINUTES);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return sessionId;

    }

    @Override
    protected Session doReadSession(Serializable serializable) {
        logger.info("获取seesion,id=[{}]", serializable.toString());
        Session readSession = null;
        try {
            readSession = (Session) redisTemplate.opsForValue().get(serializable.toString());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return readSession;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        logger.info("更新seesion,id=[{}]", session.getId().toString());
        try {
            redisTemplate.opsForValue().set(session.getId().toString(), session, 30, TimeUnit.MINUTES);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public void delete(Session session) {
        logger.info("删除seesion,id=[{}]", session.getId().toString());
        try {
            String key = session.getId().toString();
            redisTemplate.delete(key);
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        logger.info("获取存活的session");
        return Collections.emptySet();
    }
}