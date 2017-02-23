package com.test.shutterfly.CustomerLifetimeVal.DAO;

import java.util.HashMap;

import org.joda.time.DateTime;

public class SiteVisit {

	private String type;
	private String verb;
	private String key;
	private DateTime event_time;
	private String customer_id;
	private HashMap<String, String> tags;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVerb() {
		return verb;
	}
	public void setVerb(String verb) {
		this.verb = verb;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public DateTime getEvent_time() {
		return event_time;
	}
	public void setEvent_time(DateTime event_time) {
		this.event_time = event_time;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public HashMap<String, String> getTags() {
		return tags;
	}
	public void setTags(HashMap<String, String> tags) {
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "SiteVisit [type=" + type + ", verb=" + verb + ", key=" + key + ", event_time=" + event_time
				+ ", customer_id=" + customer_id + ", tags=" + tags + "]";
	}
	public SiteVisit(String type, String verb, String key, DateTime event_time, String customer_id) {
		super();
		this.type = type;
		this.verb = verb;
		this.key = key;
		this.event_time = event_time;
		this.customer_id = customer_id;
	}
	public SiteVisit(String type, String verb, String key, DateTime event_time, String customer_id,
			HashMap<String, String> tags) {
		super();
		this.tags = new HashMap<String, String>();
		this.type = type;
		this.verb = verb;
		this.key = key;
		this.event_time = event_time;
		this.customer_id = customer_id;
		this.tags = tags;
	}
	public SiteVisit() {
		super();
	}
	
	
	
	
	
}
