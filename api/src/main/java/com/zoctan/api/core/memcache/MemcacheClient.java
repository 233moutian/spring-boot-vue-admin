package com.zoctan.api.core.memcache;

import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.transcoders.Transcoder;

import java.util.Collection;
import java.util.Map;

/**
 * memcache的操作实现类
 *
 */
public interface MemcacheClient {
	/**
	 * @see #add(String, int, Object, Transcoder, long)
	 * @param key
	 * @param exp
	 * @param value
	 */
	public boolean add(final String key, final Object value);

	/**
	 * @see #add(String, int, Object, Transcoder, long)
	 * @param key
	 * @param value
	 * @param exp
	 */
	public boolean add(final String key, final Object value, final int exp);

	/**
	 * @see #add(String, int, Object, Transcoder, long)
	 * @param key
	 * @param exp
	 */
	public boolean add(final String key, final Object value, final int exp, long timeout);

	/**
	 * @see #replace(String, int, Object, Transcoder, long)
	 * @param key
	 * @param exp
	 * @param value
	 * @return
	 */
	public boolean replace(final String key, final Object value);

	/**
	 * @see #add(String, int, Object, Transcoder, long)
	 * @param key
	 * @param exp
	 */
	public boolean replace(final String key, final Object value, final int exp);

	/**
	 * @see #add(String, int, Object, Transcoder, long)
	 * @param key
	 * @param exp
	 */
	public boolean replace(final String key, final Object value, final int exp, long timeout);

	/**
	 * 获取memcache的对像
	 *
	 * @param key
	 * @return
	 */
	public <T> T get(final String key);

	/**
	 * @see #get(Collection, long, Transcoder)
	 * @param <T>
	 * @param keyCollections
	 * @return
	 */
	public <T> Map<String, T> get(final Collection<String> keyCollections);

	/**
	 * 删除memcache中的对像
	 *
	 * @param key
	 * @param opTimeout
	 * @return
	 */
	public boolean delete(final String key);

	/**
	 *  Cas is a check and set operation which means "store this data but only if
	 * no one else has updated since I last fetched it."
	 *
	 * @param key
	 * @param value
	 * @param cas
	 * @return
	 */
	public boolean cas(String key, Object value, long cas);

	/**
	 * cas
	 *
	 * @param key
	 * @param value
	 * @param exp
	 * @param cas
	 * @return
	 */
	public boolean cas(String key, Object value, int exp, long cas);

	/**
	 * cas
	 *
	 * @param key
	 * @param value
	 * @param exp
	 * @param timeout
	 * @param cas
	 * @return
	 */
	public boolean cas(String key, Object value, int exp, long timeout, long cas);

	/**
	 * gets
	 *
	 * @param key
	 * @return
	 */
	public <T> GetsResponse<T> gets(String key);

	/**
	 * @see #set(String, int, Object, Transcoder, long)
	 * @param key
	 * @param exp
	 * @param value
	 */
	public boolean set(final String key, final Object value);

	/**
	 * @see #set(String, int, Object, Transcoder, long)
	 * @param key
	 * @param exp
	 * @param value
	 */
	public boolean set(final String key, final Object value, final int exp);

	/**
	 * 自增
	 */
	public long incr(String key, long delta);

	/**
	 * 自增
	 */
	public long incr(String key, long delta, int exp);

	/**
	 * 自增
	 */
	public long incr(String key, long delta, long initValue, long timeout, int exp);
	
}
