package entities;

import utils.RestUtils;

import java.util.LinkedHashMap;

public class Header {
	private LinkedHashMap<String, String> header = new LinkedHashMap<>();

	public Header(String authorization) {
		header.put("Authorization", authorization);
	}

	public void remove(String key) {
		header.remove(key);
	}
	
	public void setCnae(String key, String value) {
		header.put(key, value);
	}
	
	
	
	public void setPet(LinkedHashMap<String, String> map) {
		header.putAll(map);
	}
	
	public LinkedHashMap<String, String> get(){
		return header;
	}
}
