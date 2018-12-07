package com.monsanto.recipe.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class Converter<T> {
	 
	 private Class<T> type;
	 
	 public Converter() {
		 
	 }
	 public Converter(Class<T> type) {
		 this.type = type;
	 }
	 	 
	 public String getJson(Object model) throws Exception {
		 String json = null;
		 if( null != model) {
			 ObjectMapper objectMapper = new ObjectMapper();
			 JavaTimeModule module = new JavaTimeModule();
			 objectMapper.registerModule(module);
			 
			 try {
				 json = objectMapper.writeValueAsString(model);
				 
			 } catch(JsonProcessingException e) {
				 throw new Exception("Error occurred while converting model to stringl: " + e.getMessage());
			 }
		 }
		 return json;
	 }
}
