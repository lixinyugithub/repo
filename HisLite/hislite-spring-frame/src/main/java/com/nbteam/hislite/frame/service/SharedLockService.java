package com.nbteam.hislite.frame.service;

import com.nbteam.hislite.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SharedLockService{

    private static final Logger logger = LoggerFactory.getLogger(SharedLockService.class);

    @Autowired
    private RedisCacheService redisCacheService;

    private static int TIMEOUT = 10 * 60;

    public Boolean getShareLock(String lockNamespace, Object lockKey) {
        if (lockKey == null) {
            return true;
        }
        try {
            long index = redisCacheService.incr(lockNamespace + String.valueOf(lockKey), TIMEOUT);
            logger.debug("用户{}获取的index={}", lockKey, index);
            return index == 0;
        } catch (Exception e) {
            logger.error("用户获取key失败", e);
            throw new BusinessException(BusinessException.BUSINESS_ERROR_CODE, "用户获取key失败");
        }
    }

    public void realseShareLock(String lockNamespace, Object lockKey) {
        if (lockKey == null) {
            return;
        }
        try {
            redisCacheService.delKey(lockNamespace + lockKey);
            logger.debug("用户{}删除key={}", lockKey, lockNamespace + String.valueOf(lockKey));
        } catch (Exception e) {
            logger.error("用户删除key失败", e);
            throw new BusinessException(BusinessException.BUSINESS_ERROR_CODE, "用户删除key失败");
        }
    }

}
