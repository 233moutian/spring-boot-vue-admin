package com.zoctan.api.core.memcache;

import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;

/**
 * xmemcache的实现
 *
 */
public class XMemcacheClientImpl<T> implements MemcacheClient {

	private static Logger logger = LoggerFactory
			.getLogger(XMemcacheClientImpl.class);

	MemcachedClient memcachedClient;

	public void setMemcachedClient(MemcachedClient memcachedClient) {
		this.memcachedClient = memcachedClient;
	}

	@Override
	public boolean add(String key, Object value) {
		try {
			return memcachedClient.add(key, 0, value);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("XMemcacheClientImpl.add error:", e);
			return false;
		}
	}

	@Override
	public boolean add(String key, Object value, int exp) {
		try {
			return memcachedClient.add(key, exp, value);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("XMemcacheClientImpl.add error:", e);
			return false;
		}
	}

	@Override
	public boolean add(String key, Object value, int exp, long timeout) {
		try {
			return memcachedClient.add(key, exp, value, timeout);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("XMemcacheClientImpl.add error:", e);
			return false;
		}
	}

	@Override
	public boolean replace(String key, Object value) {
		try {
			return memcachedClient.replace(key, 0, value);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("XMemcacheClientImpl.replace error:", e);
			return false;
		}
	}

	@Override
	public boolean replace(String key, Object value, int exp) {
		try {
			return memcachedClient.replace(key, exp, value);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("XMemcacheClientImpl.replace error:", e);
			return false;
		}
	}

	@Override
	public boolean replace(String key, Object value, int exp, long timeout) {
		try {
			return memcachedClient.replace(key, exp, value, timeout);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("XMemcacheClientImpl.replace error:", e);
			return false;
		}
	}

	@Override
	public <T> T get(String key) {
		try {
			return memcachedClient.get(key);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("XMemcacheClientImpl.get error:", e);
			return null;
		}
	}
	
	@Override
	public boolean delete(String key) {
		try {
			return memcachedClient.delete(key);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("XMemcacheClientImpl.delete error:", e);
			return false;
		}
	}

	@Override
	public <T> Map<String, T> get(Collection<String> keyCollections) {
		try {
			return memcachedClient.get(keyCollections);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("XMemcacheClientImpl.get error:", e);
			return null;
		}

	}
	
	@Override
	public boolean cas(String key, Object value, long cas){
	    try {
		return memcachedClient.cas(key, 0, value, cas);
	    } catch (Exception e) {
		e.printStackTrace();
		logger.error("XMemcacheClientImpl.cas error:", e);
		return false;
	    }
	}
	
	@Override
	public boolean cas(String key, Object value, int exp, long cas){
	    try {
		return memcachedClient.cas(key, exp, value, cas);
	    } catch (Exception e) {
		e.printStackTrace();
		logger.error("XMemcacheClientImpl.cas error:", e);
		return false;
	    }
	}
	
	@Override
	public boolean cas(String key, Object value, int exp, long timeout,long cas){
	    try {
		return memcachedClient.cas(key, exp, value, timeout, cas);
	    } catch (Exception e) {
		e.printStackTrace();
		logger.error("XMemcacheClientImpl.cas error:", e);
		return false;
	    }
	}

    public <T> GetsResponse<T> gets(String key) {
	try {
	    return memcachedClient.gets(key);
	} catch (Exception e) {
	    e.printStackTrace();
	    logger.error("XMemcacheClientImpl.gets error:", e);
	    return null;
	}
    }
    
    @Override
	public boolean set(String key, Object value) {
		try {
			return memcachedClient.set(key, 0, value);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("XMemcacheClientImpl.set error:", e);
			return false;
		}
	}
    
    @Override
	public boolean set(String key, Object value, int exp) {
		try {
			return memcachedClient.set(key, exp, value);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("XMemcacheClientImpl.set error:", e);
			return false;
		}
	}
    
	@Override
	public long incr(String key, long delta,int exp) {
		try {
			return memcachedClient.incr(key, delta, 0, 15000L, exp);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("XMemcacheClientImpl.incr error:", e);
			return -1;
		}
	}
	
	@Override
	public long incr(String key, long delta) {
		try {
			return memcachedClient.incr(key, delta);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("XMemcacheClientImpl.incr error:", e);
			return -1;
		}
	}
	
	@Override
	public long incr(String key, long delta, long initValue, long timeout, int exp) {
		try {
			return memcachedClient.incr(key, delta, initValue, timeout, exp);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("XMemcacheClientImpl.incr error:", e);
			return -1;
		}
	}
	
}
