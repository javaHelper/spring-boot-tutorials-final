package com.mkyong.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("server")
public class ServerProperties {

	private String email;
	private List<Cluster> cluster = new ArrayList<>();

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Cluster> getCluster() {
		return cluster;
	}

	public void setCluster(List<Cluster> cluster) {
		this.cluster = cluster;
	}

	@Override
	public String toString() {
		return "ServerProperties{" + "email='" + email + '\'' + ", cluster=" + cluster + '}';
	}
}
