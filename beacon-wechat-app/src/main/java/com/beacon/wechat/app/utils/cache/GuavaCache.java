package com.beacon.wechat.app.utils.cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class GuavaCache{
	private Cache<String, Object> cache;
	private long maxinumSize = 10000;
	private int expiretime = 10;
	private int concurrencyLevel = 4;
	private int initialCapacity = 16;
	public GuavaCache() {
		this.setCache(CacheBuilder.newBuilder()
				//设置并发级别为4，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(concurrencyLevel)
                //设置写缓存后expiretime分钟过期
                .expireAfterWrite(expiretime, TimeUnit.MINUTES)
                //设置缓存容器的初始容量为16
                .initialCapacity(initialCapacity)
				.maximumSize(maxinumSize)
				.build());
	}
	public long getMaxinumSize() {
		return maxinumSize;
	}
	public void setMaxinumSize(long maxinumSize) {
		this.maxinumSize = maxinumSize;
	}
	public int getExpiretime() {
		return expiretime;
	}
	public void setExpiretime(int expiretime) {
		this.expiretime = expiretime;
	}
	public int getConcurrencyLevel() {
		return concurrencyLevel;
	}
	public void setConcurrencyLevel(int concurrencyLevel) {
		this.concurrencyLevel = concurrencyLevel;
	}
	public int getInitialCapacity() {
		return initialCapacity;
	}
	public void setInitialCapacity(int initialCapacity) {
		this.initialCapacity = initialCapacity;
	}
	public void clear() {
		this.cache.cleanUp();
	}
	public void remove(String key) {
		this.cache.invalidate(key);
	}

	public Object get(String arg0) {
		return null;
	}

	public <T> T get(String arg0, Class<T> arg1) {
		return null;
	}
	public void put(String arg0, Object arg1) {
		this.cache.put(arg0, arg1);
		this.cache.put(arg0, arg1);
	}

	public Cache<String, Object> getCache() {
		return cache;
	}
	public void setCache(Cache<String, Object> cache) {
		this.cache = cache;
	}

}
