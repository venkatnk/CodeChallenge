package com.test.shutterfly.CustomerLifetimeVal.DAO;

import org.joda.time.DateTime;

public class Customer {
	
	private String type;
	private String verb;
	private String key;
	private DateTime event_time;
	private String last_name;
	private String adr_city;
	private String adr_state;
	
	public Customer(String type, String verb, String key, DateTime event_time, String last_name, String adr_city,
			String adr_state) {
		super();
		this.type = type;
		this.verb = verb;
		this.key = key;
		this.event_time = event_time;
		this.last_name = last_name;
		this.adr_city = adr_city;
		this.adr_state = adr_state;
	}
	public Customer(String type, String verb, String key, DateTime event_time) {
		super();
		this.type = type;
		this.verb = verb;
		this.key = key;
		this.event_time = event_time;
	}
	public Customer() {
		super();
	}
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
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAdr_city() {
		return adr_city;
	}
	public void setAdr_city(String adr_city) {
		this.adr_city = adr_city;
	}
	public String getAdr_state() {
		return adr_state;
	}
	public void setAdr_state(String adr_state) {
		this.adr_state = adr_state;
	}
	@Override
	public String toString() {
		return "Customer [type=" + type + ", verb=" + verb + ", key=" + key + ", event_time=" + event_time
				+ ", last_name=" + last_name + ", adr_city=" + adr_city + ", adr_state=" + adr_state + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adr_city == null) ? 0 : adr_city.hashCode());
		result = prime * result + ((adr_state == null) ? 0 : adr_state.hashCode());
		result = prime * result + ((event_time == null) ? 0 : event_time.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((verb == null) ? 0 : verb.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (adr_city == null) {
			if (other.adr_city != null)
				return false;
		} else if (!adr_city.equals(other.adr_city))
			return false;
		if (adr_state == null) {
			if (other.adr_state != null)
				return false;
		} else if (!adr_state.equals(other.adr_state))
			return false;
		if (event_time == null) {
			if (other.event_time != null)
				return false;
		} else if (!event_time.equals(other.event_time))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (verb == null) {
			if (other.verb != null)
				return false;
		} else if (!verb.equals(other.verb))
			return false;
		return true;
	}
	
	
	

}
