package com.mkyong.config;

public class Cluster {
	private String ip;
	private String path;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Cluster{" + "ip='" + ip + '\'' + ", path='" + path + '\'' + '}';
	}
}
