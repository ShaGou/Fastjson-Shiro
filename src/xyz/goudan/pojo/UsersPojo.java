package xyz.goudan.pojo;

public class UsersPojo {
	private int id;
	private String username;
	private String password;
	private String token;
	private String token_hash;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getToken_hash() {
		return token_hash;
	}
	public void setToken_hash(String token_hash) {
		this.token_hash = token_hash;
	}
	@Override
	public String toString() {
		return "UsersPojo [id=" + id + ", username=" + username + ", password=" + password + ", token=" + token
				+ ", token_hash=" + token_hash + "]";
	}
	
}
