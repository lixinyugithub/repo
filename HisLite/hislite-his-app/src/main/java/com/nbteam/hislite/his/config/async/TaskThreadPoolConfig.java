package com.nbteam.hislite.his.config.async;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/****
 * 
 * <pre>类名: TaskThreadPoolConfig</pre>
 * <pre>描述: 线程配置参数控制</pre>
 */
@Component
@ConfigurationProperties(prefix = "spring.task.pool")
public class TaskThreadPoolConfig {
	
	private int corePoolSize;  //corePoolSize：线程池维护线程的最少数量
	  
    private int maxPoolSize;  //maxPoolSize：线程池维护线程的最大数量
  
    private int keepAliveSeconds;  //keepAliveSeconds：允许的空闲时间
  
    private int queueCapacity; //queueCapacity：缓存队列

	public int getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public int getKeepAliveSeconds() {
		return keepAliveSeconds;
	}

	public void setKeepAliveSeconds(int keepAliveSeconds) {
		this.keepAliveSeconds = keepAliveSeconds;
	}

	public int getQueueCapacity() {
		return queueCapacity;
	}

	public void setQueueCapacity(int queueCapacity) {
		this.queueCapacity = queueCapacity;
	} 
    
}
