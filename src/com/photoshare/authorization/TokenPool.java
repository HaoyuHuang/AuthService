package com.photoshare.authorization;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Aron
 * 
 *         The Token Pool Manages All the Tokens Life Cycles.
 * 
 */
public class TokenPool {

	private TokenPool() {

	}

	public static TokenPool Instance() {
		return TokenPoolHolder.tokenPool;
	}

	private static final class TokenPoolHolder {
		public static TokenPool tokenPool = new TokenPool();
	}

	private Map<String, TokenKeepper> pool = new ConcurrentHashMap<String, TokenKeepper>();

	public TokenKeepper retrieveTokenKeeper(String id) {
		return pool.get(id);
	}

	public void put(String id, Token token) {
		TokenKeepper tokenkeeper = pool.get(id);
		if (tokenkeeper == null) {
			System.out.println("put token: " + id + "---" + token);
			tokenkeeper = new SimpleTokenKeeper(id);
			tokenkeeper.putToken(token);
			pool.put(id, tokenkeeper);
		} else {
			tokenkeeper.putToken(token);
		}
	}

	public void remove(String id) {
		pool.remove(id);
	}

}
