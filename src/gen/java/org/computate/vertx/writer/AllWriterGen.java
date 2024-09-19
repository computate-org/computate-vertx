/*
 * Copyright (c) 2018-2022 Computate Limited Liability Company in Utah, USA. 
 *
 * This program and the accompanying materials are made available under the
 * terms of the GNU GENERAL PUBLIC LICENSE Version 3 which is available at
 * 
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 * 
 * You may not propagate or modify a covered work except as expressly provided 
 * under this License. Any attempt otherwise to propagate or modify it is void, 
 * and will automatically terminate your rights under this License (including 
 * any patent licenses granted under the third paragraph of section 11).
 */
package org.computate.vertx.writer;

import org.computate.vertx.request.ComputateSiteRequest;
import java.lang.Object;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.config.ComputateConfigKeys;
import java.util.Optional;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.math.MathContext;
import org.apache.commons.lang3.math.NumberUtils;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.RoundingMode;
import java.util.Map;
import java.lang.String;
import java.io.File;
import java.io.StringWriter;
import io.vertx.core.buffer.Buffer;
import java.io.PrintWriter;
import java.lang.Boolean;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these AllWriter objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class AllWriterGen into the class AllWriter. 
 * </li>
 * <h3>About the AllWriter class and it's generated class AllWriterGen&lt;Object&gt;: </h3>extends AllWriterGen
 * <p>
 * This Java class extends a generated Java class AllWriterGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter">Find the class AllWriter in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends AllWriterGen<Object>
 * <p>This <code>class AllWriter extends AllWriterGen&lt;Object&gt;</code>, which means it extends a newly generated AllWriterGen. 
 * The generated <code>class AllWriterGen extends Object</code> which means that AllWriter extends AllWriterGen which extends Object. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the AllWriter class will inherit the helpful inherited class comments from the super class AllWriterGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class AllWriter in Solr: 
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.vertx.writer in Solr: 
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.writer&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project computate-vertx in Solr: 
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class AllWriterGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(AllWriter.class);

	//////////////////
	// siteRequest_ //
	//////////////////


	/**	 The entity siteRequest_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ComputateSiteRequest siteRequest_;

	/**	<br> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteRequest_(Wrap<ComputateSiteRequest> c);

	public ComputateSiteRequest getSiteRequest_() {
		return siteRequest_;
	}

	public void setSiteRequest_(ComputateSiteRequest siteRequest_) {
		this.siteRequest_ = siteRequest_;
	}
	public static ComputateSiteRequest staticSetSiteRequest_(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected AllWriter siteRequest_Init() {
		Wrap<ComputateSiteRequest> siteRequest_Wrap = new Wrap<ComputateSiteRequest>().var("siteRequest_");
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			Optional.ofNullable(siteRequest_Wrap.getO()).ifPresent(o -> {
				setSiteRequest_(o);
			});
		}
		return (AllWriter)this;
	}

	////////////
	// tabStr //
	////////////


	/**	 The entity tabStr
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String tabStr;

	/**	<br> The entity tabStr
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&fq=entiteVar_enUS_indexed_string:tabStr">Find the entity tabStr in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _tabStr(Wrap<String> c);

	public String getTabStr() {
		return tabStr;
	}
	public void setTabStr(String o) {
		this.tabStr = AllWriter.staticSetTabStr(siteRequest_, o);
	}
	public static String staticSetTabStr(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected AllWriter tabStrInit() {
		Wrap<String> tabStrWrap = new Wrap<String>().var("tabStr");
		if(tabStr == null) {
			_tabStr(tabStrWrap);
			Optional.ofNullable(tabStrWrap.getO()).ifPresent(o -> {
				setTabStr(o);
			});
		}
		return (AllWriter)this;
	}

	public static String staticSearchTabStr(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrTabStr(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTabStr(ComputateSiteRequest siteRequest_, String o) {
		return AllWriter.staticSearchTabStr(siteRequest_, AllWriter.staticSetTabStr(siteRequest_, o)).toString();
	}

	//////////
	// file //
	//////////


	/**	 The entity file
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected File file;

	/**	<br> The entity file
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&fq=entiteVar_enUS_indexed_string:file">Find the entity file in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _file(Wrap<File> c);

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	public static File staticSetFile(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected AllWriter fileInit() {
		Wrap<File> fileWrap = new Wrap<File>().var("file");
		if(file == null) {
			_file(fileWrap);
			Optional.ofNullable(fileWrap.getO()).ifPresent(o -> {
				setFile(o);
			});
		}
		return (AllWriter)this;
	}

	//////////////////
	// stringWriter //
	//////////////////


	/**	 The entity stringWriter
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected StringWriter stringWriter;

	/**	<br> The entity stringWriter
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&fq=entiteVar_enUS_indexed_string:stringWriter">Find the entity stringWriter in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _stringWriter(Wrap<StringWriter> c);

	public StringWriter getStringWriter() {
		return stringWriter;
	}

	public void setStringWriter(StringWriter stringWriter) {
		this.stringWriter = stringWriter;
	}
	public static StringWriter staticSetStringWriter(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected AllWriter stringWriterInit() {
		Wrap<StringWriter> stringWriterWrap = new Wrap<StringWriter>().var("stringWriter");
		if(stringWriter == null) {
			_stringWriter(stringWriterWrap);
			Optional.ofNullable(stringWriterWrap.getO()).ifPresent(o -> {
				setStringWriter(o);
			});
		}
		return (AllWriter)this;
	}

	////////////
	// buffer //
	////////////


	/**	 The entity buffer
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Buffer buffer;

	/**	<br> The entity buffer
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&fq=entiteVar_enUS_indexed_string:buffer">Find the entity buffer in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _buffer(Wrap<Buffer> c);

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}
	public static Buffer staticSetBuffer(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected AllWriter bufferInit() {
		Wrap<Buffer> bufferWrap = new Wrap<Buffer>().var("buffer");
		if(buffer == null) {
			_buffer(bufferWrap);
			Optional.ofNullable(bufferWrap.getO()).ifPresent(o -> {
				setBuffer(o);
			});
		}
		return (AllWriter)this;
	}

	/////////////////
	// printWriter //
	/////////////////


	/**	 The entity printWriter
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected PrintWriter printWriter;

	/**	<br> The entity printWriter
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&fq=entiteVar_enUS_indexed_string:printWriter">Find the entity printWriter in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _printWriter(Wrap<PrintWriter> c);

	public PrintWriter getPrintWriter() {
		return printWriter;
	}

	public void setPrintWriter(PrintWriter printWriter) {
		this.printWriter = printWriter;
	}
	public static PrintWriter staticSetPrintWriter(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected AllWriter printWriterInit() {
		Wrap<PrintWriter> printWriterWrap = new Wrap<PrintWriter>().var("printWriter");
		if(printWriter == null) {
			_printWriter(printWriterWrap);
			Optional.ofNullable(printWriterWrap.getO()).ifPresent(o -> {
				setPrintWriter(o);
			});
		}
		return (AllWriter)this;
	}

	///////////
	// empty //
	///////////


	/**	 The entity empty
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean empty;

	/**	<br> The entity empty
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&fq=entiteVar_enUS_indexed_string:empty">Find the entity empty in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _empty(Wrap<Boolean> c);

	public Boolean getEmpty() {
		return empty;
	}

	public void setEmpty(Boolean empty) {
		this.empty = empty;
	}
	@JsonIgnore
	public void setEmpty(String o) {
		this.empty = AllWriter.staticSetEmpty(siteRequest_, o);
	}
	public static Boolean staticSetEmpty(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected AllWriter emptyInit() {
		Wrap<Boolean> emptyWrap = new Wrap<Boolean>().var("empty");
		if(empty == null) {
			_empty(emptyWrap);
			Optional.ofNullable(emptyWrap.getO()).ifPresent(o -> {
				setEmpty(o);
			});
		}
		return (AllWriter)this;
	}

	public static Boolean staticSearchEmpty(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrEmpty(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqEmpty(ComputateSiteRequest siteRequest_, String o) {
		return AllWriter.staticSearchEmpty(siteRequest_, AllWriter.staticSetEmpty(siteRequest_, o)).toString();
	}

	//////////////
	// initDeep //
	//////////////

	public AllWriter initDeepAllWriter(ComputateSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		initDeepAllWriter();
		return (AllWriter)this;
	}

	public void initDeepAllWriter() {
		initAllWriter();
	}

	public void initAllWriter() {
				siteRequest_Init();
				tabStrInit();
				fileInit();
				stringWriterInit();
				bufferInit();
				printWriterInit();
				emptyInit();
	}

	public void initDeepForClass(ComputateSiteRequest siteRequest_) {
		initDeepAllWriter(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestAllWriter(ComputateSiteRequest siteRequest_) {
	}

	public void siteRequestForClass(ComputateSiteRequest siteRequest_) {
		siteRequestAllWriter(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainAllWriter(v);
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainAllWriter(String var) {
		AllWriter oAllWriter = (AllWriter)this;
		switch(var) {
			case "siteRequest_":
				return oAllWriter.siteRequest_;
			case "tabStr":
				return oAllWriter.tabStr;
			case "file":
				return oAllWriter.file;
			case "stringWriter":
				return oAllWriter.stringWriter;
			case "buffer":
				return oAllWriter.buffer;
			case "printWriter":
				return oAllWriter.printWriter;
			case "empty":
				return oAllWriter.empty;
			default:
				return null;
		}
	}

	///////////////
	// relate //
	///////////////

	public boolean relateForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = relateAllWriter(v, val);
		}
		return o != null;
	}
	public Object relateAllWriter(String var, Object val) {
		AllWriter oAllWriter = (AllWriter)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSetAllWriter(entityVar,  siteRequest_, o);
	}
	public static Object staticSetAllWriter(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "tabStr":
			return AllWriter.staticSetTabStr(siteRequest_, o);
		case "empty":
			return AllWriter.staticSetEmpty(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchAllWriter(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchAllWriter(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "tabStr":
			return AllWriter.staticSearchTabStr(siteRequest_, (String)o);
		case "empty":
			return AllWriter.staticSearchEmpty(siteRequest_, (Boolean)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchStrAllWriter(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrAllWriter(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "tabStr":
			return AllWriter.staticSearchStrTabStr(siteRequest_, (String)o);
		case "empty":
			return AllWriter.staticSearchStrEmpty(siteRequest_, (Boolean)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSearchFqAllWriter(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqAllWriter(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "tabStr":
			return AllWriter.staticSearchFqTabStr(siteRequest_, o);
		case "empty":
			return AllWriter.staticSearchFqEmpty(siteRequest_, o);
			default:
				return null;
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "AllWriter";
	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_tabStr = "tabStr";
	public static final String VAR_file = "file";
	public static final String VAR_stringWriter = "stringWriter";
	public static final String VAR_buffer = "buffer";
	public static final String VAR_printWriter = "printWriter";
	public static final String VAR_empty = "empty";

	public static final String DISPLAY_NAME_siteRequest_ = "";
	public static final String DISPLAY_NAME_tabStr = "";
	public static final String DISPLAY_NAME_file = "";
	public static final String DISPLAY_NAME_stringWriter = "";
	public static final String DISPLAY_NAME_buffer = "";
	public static final String DISPLAY_NAME_printWriter = "";
	public static final String DISPLAY_NAME_empty = "";

	public static String displayNameForClass(String var) {
		return AllWriter.displayNameAllWriter(var);
	}
	public static String displayNameAllWriter(String var) {
		switch(var) {
		case VAR_siteRequest_:
			return DISPLAY_NAME_siteRequest_;
		case VAR_tabStr:
			return DISPLAY_NAME_tabStr;
		case VAR_file:
			return DISPLAY_NAME_file;
		case VAR_stringWriter:
			return DISPLAY_NAME_stringWriter;
		case VAR_buffer:
			return DISPLAY_NAME_buffer;
		case VAR_printWriter:
			return DISPLAY_NAME_printWriter;
		case VAR_empty:
			return DISPLAY_NAME_empty;
		default:
			return null;
		}
	}
}
