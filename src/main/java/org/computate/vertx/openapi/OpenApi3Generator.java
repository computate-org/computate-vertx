package org.computate.vertx.openapi;

import org.computate.search.wrap.Wrap;

public class OpenApi3Generator extends OpenApi3GeneratorGen<Swagger2Generator> {

	@Override()
	protected void  _apiVersion(Wrap<String> c) {
		c.o("3.0.0");
	}
}
