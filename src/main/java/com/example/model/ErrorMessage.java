package com.example.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ErrorMessage implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 866950428322532080L;
	private List<String> errors;

	    public ErrorMessage() {
	    }

	    public ErrorMessage(List<String> errors) {
	        this.errors = errors;
	    }

	    public ErrorMessage(String error) {
	        this(Collections.singletonList(error));
	    }

	    public ErrorMessage(String ... errors) {
	        this(Arrays.asList(errors));
	    }

	    public List<String> getErrors() {
	        return errors;
	    }

	    public void setErrors(List<String> errors) {
	        this.errors = errors;
	    }
}
