package com.test.shutterfly.CustomerLifetimeVal.DAO;

import org.joda.time.DateTime;

public class ImageUpload {

	private String type;
	private String verb;
	private String key;
	private DateTime event_time;
	private String customer_id;
	private String camera_make;
	private String camera_model;
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
	public String getCamera_make() {
		return camera_make;
	}
	public void setCamera_make(String camera_make) {
		this.camera_make = camera_make;
	}
	public String getCamera_model() {
		return camera_model;
	}
	public void setCamera_model(String camera_model) {
		this.camera_model = camera_model;
	}
	public ImageUpload(String type, String verb, String key, DateTime event_time, String customer_id,
			String camera_make, String camera_model) {
		super();
		this.type = type;
		this.verb = verb;
		this.key = key;
		this.event_time = event_time;
		this.customer_id = customer_id;
		this.camera_make = camera_make;
		this.camera_model = camera_model;
	}
	public ImageUpload(String type, String verb, String key, DateTime event_time, String customer_id) {
		super();
		this.type = type;
		this.verb = verb;
		this.key = key;
		this.event_time = event_time;
		this.customer_id = customer_id;
	}
	@Override
	public String toString() {
		return "ImageUpload [type=" + type + ", verb=" + verb + ", key=" + key + ", event_time=" + event_time
				+ ", customer_id=" + customer_id + ", camera_make=" + camera_make + ", camera_model=" + camera_model
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((camera_make == null) ? 0 : camera_make.hashCode());
		result = prime * result + ((camera_model == null) ? 0 : camera_model.hashCode());
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((event_time == null) ? 0 : event_time.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		ImageUpload other = (ImageUpload) obj;
		if (camera_make == null) {
			if (other.camera_make != null)
				return false;
		} else if (!camera_make.equals(other.camera_make))
			return false;
		if (camera_model == null) {
			if (other.camera_model != null)
				return false;
		} else if (!camera_model.equals(other.camera_model))
			return false;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
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
	public ImageUpload() {
		super();
	}
	
	
	
}
