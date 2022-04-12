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

import org.computate.vertx.request.ComputateVertxSiteRequest;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.config.ComputateVertxConfigKeys;
import java.util.Optional;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
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
import java.lang.Object;
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
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter">Find the class AllWriter in Solr. </a>
 * <br><br>Delete the class AllWriter in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>Delete  the package org.computate.vertx.writer in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.writer&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>Delete  the project computate-vertx in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>
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
	protected ComputateVertxSiteRequest siteRequest_;

	/**	<br> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteRequest_(Wrap<ComputateVertxSiteRequest> c);

	public ComputateVertxSiteRequest getSiteRequest_() {
		return siteRequest_;
	}

	public void setSiteRequest_(ComputateVertxSiteRequest siteRequest_) {
		this.siteRequest_ = siteRequest_;
	}
	public static ComputateVertxSiteRequest staticSetSiteRequest_(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected AllWriter siteRequest_Init() {
		Wrap<ComputateVertxSiteRequest> siteRequest_Wrap = new Wrap<ComputateVertxSiteRequest>().var("siteRequest_");
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			setSiteRequest_(siteRequest_Wrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&fq=entiteVar_enUS_indexed_string:tabStr">Find the entity tabStr in Solr</a>
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
	public static String staticSetTabStr(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected AllWriter tabStrInit() {
		Wrap<String> tabStrWrap = new Wrap<String>().var("tabStr");
		if(tabStr == null) {
			_tabStr(tabStrWrap);
			setTabStr(tabStrWrap.o);
		}
		return (AllWriter)this;
	}

	public static String staticSearchTabStr(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrTabStr(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTabStr(ComputateVertxSiteRequest siteRequest_, String o) {
		return AllWriter.staticSearchStrTabStr(siteRequest_, AllWriter.staticSearchTabStr(siteRequest_, AllWriter.staticSetTabStr(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&fq=entiteVar_enUS_indexed_string:file">Find the entity file in Solr</a>
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
	public static File staticSetFile(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected AllWriter fileInit() {
		Wrap<File> fileWrap = new Wrap<File>().var("file");
		if(file == null) {
			_file(fileWrap);
			setFile(fileWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&fq=entiteVar_enUS_indexed_string:stringWriter">Find the entity stringWriter in Solr</a>
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
	public static StringWriter staticSetStringWriter(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected AllWriter stringWriterInit() {
		Wrap<StringWriter> stringWriterWrap = new Wrap<StringWriter>().var("stringWriter");
		if(stringWriter == null) {
			_stringWriter(stringWriterWrap);
			setStringWriter(stringWriterWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&fq=entiteVar_enUS_indexed_string:buffer">Find the entity buffer in Solr</a>
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
	public static Buffer staticSetBuffer(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected AllWriter bufferInit() {
		Wrap<Buffer> bufferWrap = new Wrap<Buffer>().var("buffer");
		if(buffer == null) {
			_buffer(bufferWrap);
			setBuffer(bufferWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&fq=entiteVar_enUS_indexed_string:printWriter">Find the entity printWriter in Solr</a>
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
	public static PrintWriter staticSetPrintWriter(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected AllWriter printWriterInit() {
		Wrap<PrintWriter> printWriterWrap = new Wrap<PrintWriter>().var("printWriter");
		if(printWriter == null) {
			_printWriter(printWriterWrap);
			setPrintWriter(printWriterWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.AllWriter&fq=entiteVar_enUS_indexed_string:empty">Find the entity empty in Solr</a>
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
	public static Boolean staticSetEmpty(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected AllWriter emptyInit() {
		Wrap<Boolean> emptyWrap = new Wrap<Boolean>().var("empty");
		if(empty == null) {
			_empty(emptyWrap);
			setEmpty(emptyWrap.o);
		}
		return (AllWriter)this;
	}

	public static Boolean staticSearchEmpty(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrEmpty(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqEmpty(ComputateVertxSiteRequest siteRequest_, String o) {
		return AllWriter.staticSearchStrEmpty(siteRequest_, AllWriter.staticSearchEmpty(siteRequest_, AllWriter.staticSetEmpty(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public AllWriter initDeepAllWriter(ComputateVertxSiteRequest siteRequest_) {
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

	public void initDeepForClass(ComputateVertxSiteRequest siteRequest_) {
		initDeepAllWriter(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestAllWriter(ComputateVertxSiteRequest siteRequest_) {
	}

	public void siteRequestForClass(ComputateVertxSiteRequest siteRequest_) {
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

	public static Object staticSetForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSetAllWriter(entityVar,  siteRequest_, o);
	}
	public static Object staticSetAllWriter(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
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

	public static Object staticSearchForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSearchAllWriter(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchAllWriter(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
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

	public static String staticSearchStrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSearchStrAllWriter(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrAllWriter(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
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

	public static String staticSearchFqForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSearchFqAllWriter(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqAllWriter(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
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
