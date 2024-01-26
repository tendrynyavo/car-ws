package com.example.carws.response;

import java.util.HashMap;

public class Response{
	
	HashMap<String, Object> errors;
	HashMap<String, Object> data;
	HashMap<String, Object> message;

	// Mila miova kely daholo nareo
	// Ahoana no anaovana izany
	// Ataovy mitovy daholo ny retours rehetra

	public Response setErrors(HashMap<String, Object> es){
		this.errors = es;
		return this;
	}
	public HashMap<String, Object> getErrors(){
		return this.errors;
	}

	public Response addError( String error, Object err ){
		if( this.getErrors() == null ) this.setErrors(new HashMap<String, Object>());
		this.getErrors().put(error, err);
		return this;
	}

	public Response setData(HashMap<String, Object> da){
		this.data = da;
		return this;
	}
	public HashMap<String, Object> getData(){
		return this.data;
	}

	public Response addData( String title, Object datas ){
		if( this.getData() == null ) this.setData(new HashMap<String, Object>());
		this.getData().put(title, datas);
		return this;
	}

	public Response setMessage(HashMap<String, Object> da){
		this.message = da;
		return this;
	}
	public HashMap<String, Object> getMessage(){
		return this.message;
	}

	public Response addMessage( String title, Object message ){
		if( this.getMessage() == null ) this.setMessage(new HashMap<String, Object>());
		this.getMessage().put(title, message);
		return this;
	}

}