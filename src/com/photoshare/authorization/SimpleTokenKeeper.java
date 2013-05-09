package com.photoshare.authorization;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author Aron
 * 
 *         The Standard implementation of the Token Keeper
 * 
 */
public class SimpleTokenKeeper implements TokenKeepper {

	private String userName;

	private Collection<Token> tokens = Collections
			.synchronizedSet(new HashSet<Token>());

	public SimpleTokenKeeper(String userName) {
		super();
		this.userName = userName;
	}

	@Override
	public boolean checkToken(Token token) {
		for (Token to : tokens) {
			if (token.equals(to)) {
				System.out.println(to);
				return true;
			}
		}
		return false;
	}

	@Override
	public Token putToken(Token token) {
		Token preToken = null;
		for (Token to : tokens) {
			if (token.equals(token)) {
				preToken = to;
				break;
			}
		}
		if (preToken != null) {
			tokens.remove(preToken);
		}
		tokens.add(token);
		return preToken;
	}

	@Override
	public Token removeToken(Token token) {
		tokens.remove(token);
		return token;
	}

	@Override
	public void clear() {
		tokens.clear();
	}

	@Override
	public String getTokenId() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public Collection<Token> removeAll(Collection<Token> tokens) {
		this.tokens.removeAll(tokens);
		return tokens;
	}

}
