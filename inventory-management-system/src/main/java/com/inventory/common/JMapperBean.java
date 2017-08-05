package com.inventory.common;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;

@Component
public class JMapperBean {

	public <D, S> D transformFromDestinationToSoure(Class<D> destination, S sourceObj, Class<S> source) {
		JMapper<D , S> mapper = new JMapper<>(destination, source);
		return mapper.getDestination(sourceObj);
	}


	public <D, S> List<D> transformList(Class<D> destination, List<S> sourceObjList, Class<S> source) {
		JMapper<D , S> mapper = new JMapper<>(destination, source);
		List<D> results = sourceObjList.stream().map((s)-> mapper.getDestination(s)).collect(Collectors.toList());
		return results;
	}
}
