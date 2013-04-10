package com.conwet.samson;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class QueryFactoryTest {
	
	@Test
	public void shouldReturnNewInstance() {
		
		QueryBroker first = QueryFactory.newQuerier("localhost", 4444);
		QueryBroker other = QueryFactory.newQuerier("localhost", 4444);
		
		assertThat(first).isNotNull().isNotSameAs(other);
		assertThat(other).isNotNull();
	}
}
