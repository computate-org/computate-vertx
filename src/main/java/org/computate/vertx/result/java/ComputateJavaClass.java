package org.computate.vertx.result.java;

import java.text.Normalizer;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.computate.search.wrap.Wrap;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.request.ComputateSiteRequest;

import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;

/**
 * Api: true
 * Page: true
 * SuperPage.enUS: ComputatePageLayout
 * Indexed: true
 * 
 * ApiTag.enUS: Java Class
 * ApiUri.enUS: /api/java-class
 * 
 * ApiMethod.enUS: Search
 * ApiMethod: GET
 * 
 * ApiMethod.enUS: SearchPage
 * Page.SearchPage.enUS: ComputateJavaClassPage
 * ApiUri.SearchPage.enUS: /java-class
 * 
 * AName.enUS: a java class
 * Color: blue
 * IconGroup: duotone
 * IconName: map-location-dot
 */
public class ComputateJavaClass extends ComputateJavaClassGen<Object> {

	/**
	 * Ignore: true
	 * Description: The current request object
	**/
	protected void _siteRequest_(Wrap<ComputateSiteRequest> w) {
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 * Description: An asynchronous method for searching for a computer related to this message
	 */
	protected void _promiseBefore(Promise<Void> promise) {
		promise.complete();
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * InheritPrimaryKey: true
	 * Persist: true
	 * Description: An optional inherited primary key from a legacy system for this object in the database
	 */
	protected void _inheritPk(Wrap<String> w) {}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * Modify: false
	 * VarCreated: true
	 * HtmlRow: 1
	 * HtmlCell: 2
	 * HtmlColumn: 1
	 * Facet: true
	 * DisplayName.enUS: created
	 * FormatHtm: MMM d, yyyy h:mm:ss a
	 * Description: A created timestamp for this record in the database
	 */
	protected void _created(Wrap<ZonedDateTime> w) {
		w.o(ZonedDateTime.now(ZoneId.of(siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_ZONE))));
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 2
	 * HtmlCell: 1
	 * DisplayName.enUS: archived
	 * Description: For archiving this record
	 */
	protected void _archived(Wrap<Boolean> w) {
		w.o(false);
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 2
	 * HtmlCell: 2
	 * DisplayName.enUS: deleted
	 * Description: For deleting this record
	 */
	protected void _deleted(Wrap<Boolean> w) {
		w.o(false);
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Description: All the inherited canonical names of this Java class
	 */
	protected void _classCanonicalNames(List<String> l) { 
		l.add(getClass().getCanonicalName());
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * Modify: false
	 * Description: The session ID of the user that created this object
	 */
	protected void _sessionId(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: userKey
	 * DocValues: true
	 * Persist: true
	 * Modify: false
	 * Description: The primary key of the user that created this record
	 */
	protected void _userKey(Wrap<Long> c) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Saves: true
	 * Description: A list of fields that are saved for this record in the database
	 */
	protected void _saves(List<String> l) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * VarTitle: true
	 * HtmlColumn: 2
	 * Description: The title of this object
	 */
	protected void _objectTitle(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * VarId: true
	 * HtmlRow: 1
	 * HtmlCell: 4
	 * DisplayName.enUS: ID
	 * Description: A URL friendly unique ID for this object
	 */
	protected void _objectId(Wrap<String> w) {
	}

	/**
	 * Description: A helper method for generating a URL friendly unique ID for this object
	 */
	public String toId(String s) {
		if(s != null) {
			s = Normalizer.normalize(s, Normalizer.Form.NFD);
			s = StringUtils.lowerCase(s);
			s = StringUtils.trim(s);
			s = StringUtils.replacePattern(s, "\\s{1,}", "-");
			s = StringUtils.replacePattern(s, "[^\\w-]", "");
			s = StringUtils.replacePattern(s, "-{2,}", "-");
		}

		return s;
	}

	/**
	 * {@inheritDoc}
	 * Suggested: true
	 * Description: The indexed field in the search engine for this record while using autosuggest
	 * DisplayName: autosuggest
	 */
	protected void _objectSuggest(Wrap<String> w) { 
		StringBuilder b = new StringBuilder();
		if(objectId != null)
			b.append(" ").append(objectId);
		if(objectTitle != null)
			b.append(" ").append(objectTitle);
		w.o(b.toString());
	}

	/**
	 * {@inheritDoc}
	 * Text: true
	 * Description: The full text search field in the search engine for this record while using autosuggest
	 * DisplayName: text
	 */
	protected void _objectText(List<String> l) { 
		if(objectId != null)
			l.add(objectId);
		if(objectTitle != null)
			l.add(objectTitle);
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * VarUrlId: true
	 * Description: The link by name for this object in the UI
	 */
	protected void _pageUrlId(Wrap<String> w) {
		if(objectId != null) {
			try {
				Optional.ofNullable((String)FieldUtils.getField(getClass(), String.format("%s_ApiUriSearchPage_%s", getClass().getSimpleName(), siteRequest_.getLang())).get(this)).ifPresent(classApiUri -> {
					w.o(siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_BASE_URL) + classApiUri + "/" + objectId);
				});
			} catch (Exception e) {
				ExceptionUtils.rethrow(e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * VarUrlPk: true
	 * Description: The link by primary key for this object in the UI
	 */
	protected void _pageUrlPk(Wrap<String> w) {
		w.o(pageUrlId);
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Description: The link to this object in the API
	 */
	protected void _pageUrlApi(Wrap<String> w) {
		try {
			Optional.ofNullable((String)FieldUtils.getField(getClass(), String.format("%s_ApiUri_%s", getClass().getSimpleName(), siteRequest_.getLang())).get(this)).ifPresent(classApiUri -> {
				w.o(siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_BASE_URL) + classApiUri + "/" + id);
			});
		} catch (Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	/**
	 **/
	protected void _doc(Wrap<JsonObject> w) {
	}

	/**
	 * Example: "/home/ctate/.local/src/choice-reports"
	 **/
	protected void _sitePath(Wrap<String> w) {
		w.o(doc.getString("siteChemin_stored_string"));
	}
	/**
	 * Example: "choice-reports"
	 **/
	protected void _siteName(Wrap<String> w) {
		w.o(doc.getString("siteNom_stored_string"));
	}
	/**
	 * Example: [ "BaseModel" ]
	 **/
	protected void _superClassParamsTypeName(Wrap<List<String>> w) {
		w.o(doc.getJsonArray("classeSuperParamsTypeNom_stored_strings").getList());
	}
	/**
	 * Example:
	 * "org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGen<org.choicehumanitarian.reports.enus.base.BaseModel>"
	 **/
	protected void _superClassCompleteName(Wrap<String> w) {
		w.o(doc.getString("classeNomCompletSuper_enUS_stored_string"));
	}
	/**
	 * Example: "org.choicehumanitarian.reports.enus.base.BaseModel"
	 **/
	protected void _superClassGenericCompleteName(Wrap<String> w) {
		w.o(doc.getString("classeNomCompletSuperGenerique_enUS_stored_string"));
	}
	/**
	 * Example: "org.choicehumanitarian.reports.enus.base.BaseModel"
	 **/
	protected void _superClassGenericCanonicalName(Wrap<String> w) {
		w.o(doc.getString("classeNomCanoniqueSuperGenerique_enUS_stored_string"));
	}
	/**
	 * Example: "BaseModel"
	 **/
	protected void _superClassGenericSimpleName(Wrap<String> w) {
		w.o(doc.getString("classeNomSimpleSuperGenerique_enUS_stored_string"));
	}
	/**
	 * Example: false
	 **/
	protected void _classIsBase(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeEstBase_stored_boolean"));
	}
	/**
	 * Example: true
	 **/
	protected void _classExtendsBase(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeEtendBase_stored_boolean"));
	}
	/**
	 * Example: true
	 **/
	protected void _classBaseExtendsGen(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeBaseEtendGen_stored_boolean"));
	}
	/**
	 * Example: true
	 **/
	protected void _classContainsSiteRequest(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeContientRequeteSite_stored_boolean"));
	}
	/**
	 * Example: true
	 **/
	protected void _classTranslate(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeTraduire_stored_boolean"));
	}
	/**
	 * Example: true
	 **/
	protected void _classInitDeep(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeInitLoin_stored_boolean"));
	}
	/**
	 * Example: true
	 **/
	protected void _classExtendsGen(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeEtendGen_stored_boolean"));
	}
	/**
	 * Example: "enUS"
	 **/
	protected void _languageName(Wrap<String> w) {
		w.o(doc.getString("langueNom_stored_string"));
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Modify: false
	 * VarModified: true
	 * HtmlRow: 1
	 * HtmlCell: 3
	 * DisplayName.enUS: modified
	 * Description: A modified timestamp for this record in the database
	 * Facet: true
	 */
	protected void _modified(Wrap<String> w) {
		w.o(doc.getString("modifiee_stored_date"));
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Description: the canonical name of this Java class
	 */
	protected void _classCanonicalName(Wrap<String> w) {
		w.o(doc.getString("classeNomCanonique_enUS_stored_string"));
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Description: The simple name of this Java class
	 * DisplayName.enUS: object type
	 * Facet: true
	 */
	protected void _classSimpleName(Wrap<String> w) {
		w.o(doc.getString("classeNomSimple_enUS_stored_string"));
	}
	/**
	 * Example: "org.choicehumanitarian.reports.enus.model.donor"
	 **/
	protected void _classPackageName(Wrap<String> w) {
		w.o(doc.getString("classeNomEnsemble_enUS_stored_string"));
	}
	/**
	 * Example: "org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGen"
	 **/
	protected void _classCanonicalNameGen(Wrap<String> w) {
		w.o(doc.getString("classeNomCanoniqueGen_enUS_stored_string"));
	}
	/**
	 * Example: "ChoiceDonorGen"
	 **/
	protected void _classSimpleNameGen(Wrap<String> w) {
		w.o(doc.getString("classeNomSimpleGen_enUS_stored_string"));
	}
	/**
	 * Example: "org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGen"
	 **/
	protected void _superClassCanonicalName(Wrap<String> w) {
		w.o(doc.getString("classeNomCanoniqueSuper_enUS_stored_string"));
	}
	/**
	 * Example: "ChoiceDonorGen"
	 **/
	protected void _superClassSimpleName(Wrap<String> w) {
		w.o(doc.getString("classeNomSimpleSuper_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "/home/ctate/.local/src/choice-reports/src/main/java/org/choicehumanitarian/reports/enus/model/donor/ChoiceDonor.java"
	 **/
	protected void _classAbsolutePath(Wrap<String> w) {
		w.o(doc.getString("classeCheminAbsolu_stored_string"));
	}
	/**
	 * Example:
	 * "/home/ctate/.local/src/choice-reports/src/main/java/org/choicehumanitarian/reports/enus/model/donor/ChoiceDonor.java"
	 **/
	protected void _classPath(Wrap<String> w) {
		w.o(doc.getString("classeChemin_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "/home/ctate/.local/src/choice-reports/src/main/java/org/choicehumanitarian/reports/enus/model/donor"
	 **/
	protected void _classDirectoryPath(Wrap<String> w) {
		w.o(doc.getString("classeCheminRepertoire_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "/home/ctate/.local/src/choice-reports/src/gen/java/org/choicehumanitarian/reports/enus/model/donor/ChoiceDonorGen.java"
	 **/
	protected void _classPathGen(Wrap<String> w) {
		w.o(doc.getString("classeCheminGen_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "/home/ctate/.local/src/choice-reports/src/gen/java/org/choicehumanitarian/reports/enus/model/donor"
	 **/
	protected void _classDirectoryPathGen(Wrap<String> w) {
		w.o(doc.getString("classeCheminRepertoireGen_enUS_stored_string"));
	}
	/**
	 * Example: "org.choicehumanitarian.reports"
	 **/
	protected void _domainPackageName(Wrap<String> w) {
		w.o(doc.getString("nomEnsembleDomaine_stored_string"));
	}
	/**
	 * Example: [ "org.choicehumanitarian.reports.enus.model.donor.ChoiceDonor",
	 * "org.choicehumanitarian.reports.enus.base.BaseModel" ]
	 **/
	protected void _entityClassesSuperAndMeWithoutGen(Wrap<List<String>> w) {
		w.o(doc.getJsonArray("classesSuperEtMoiSansGen_stored_strings").getList());
	}
	/**
	 * Example: false
	 **/
	protected void _classIsAbstract(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeEstAbstrait_stored_boolean"));
	}
	/**
	 * Example: true
	 **/
	protected void _classModel(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeModele_stored_boolean"));
	}
	/**
	 * Example: true
	 **/
	protected void _classApi(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeApi_stored_boolean"));
	}
	/**
	 * Example: false
	 **/
	protected void _classSimplePage(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classePageSimple_stored_boolean"));
	}
	/**
	 * Example: true
	 **/
	protected void _classSaved(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeSauvegarde_stored_boolean"));
	}
	/**
	 * Example: "package-info"
	 **/
	protected void _classSimpleNameApiPackageInfo(Wrap<String> w) {
		w.o(doc.getString("classeNomSimpleApiEnsembleInfo_enUS_stored_string"));
	}
	/**
	 * Example: "ChoiceDonorEnUSGenApiServiceImpl"
	 **/
	protected void _classSimpleNameGenApiServiceImpl(Wrap<String> w) {
		w.o(doc.getString("classeNomSimpleGenApiServiceImpl_enUS_stored_string"));
	}
	/**
	 * Example: "ChoiceDonorEnUSApiServiceImpl"
	 **/
	protected void _classSimpleNameApiServiceImpl(Wrap<String> w) {
		w.o(doc.getString("classeNomSimpleApiServiceImpl_enUS_stored_string"));
	}
	/**
	 * Example: "ChoiceDonorEnUSGenApiService"
	 **/
	protected void _classSimpleNameGenApiService(Wrap<String> w) {
		w.o(doc.getString("classeNomSimpleGenApiService_enUS_stored_string"));
	}
	/**
	 * Example: "org.choicehumanitarian.reports.enus.model.donor.package-info"
	 **/
	protected void _classCanonicalNameApiPackageInfo(Wrap<String> w) {
		w.o(doc.getString("classeNomCanoniqueApiEnsembleInfo_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorEnUSGenApiServiceImpl"
	 **/
	protected void _classCanonicalNameGenApiServiceImpl(Wrap<String> w) {
		w.o(doc.getString("classeNomCanoniqueGenApiServiceImpl_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorEnUSApiServiceImpl"
	 **/
	protected void _classCanonicalNameApiServiceImpl(Wrap<String> w) {
		w.o(doc.getString("classeNomCanoniqueApiServiceImpl_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorEnUSGenApiService"
	 **/
	protected void _classCanonicalNameGenApiService(Wrap<String> w) {
		w.o(doc.getString("classeNomCanoniqueGenApiService_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "/home/ctate/.local/src/choice-reports/src/gen/java/org/choicehumanitarian/reports/enus/model/donor/package-info.java"
	 **/
	protected void _classPathApiPackageInfo(Wrap<String> w) {
		w.o(doc.getString("classeCheminApiEnsembleInfo_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "/home/ctate/.local/src/choice-reports/src/main/java/org/choicehumanitarian/reports/enus/model/donor/ChoiceDonorEnUSGenApiServiceImpl.java"
	 **/
	protected void _classPathGenApiServiceImpl(Wrap<String> w) {
		w.o(doc.getString("classeCheminGenApiServiceImpl_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "/home/ctate/.local/src/choice-reports/src/main/java/org/choicehumanitarian/reports/enus/model/donor/ChoiceDonorEnUSApiServiceImpl.java"
	 **/
	protected void _classPathApiServiceImpl(Wrap<String> w) {
		w.o(doc.getString("classeCheminApiServiceImpl_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "/home/ctate/.local/src/choice-reports/src/main/java/org/choicehumanitarian/reports/enus/model/donor/ChoiceDonorEnUSGenApiService.java"
	 **/
	protected void _classPathGenApiService(Wrap<String> w) {
		w.o(doc.getString("classeCheminGenApiService_enUS_stored_string"));
	}
	/**
	 * Example: false
	 **/
	protected void _classPublicRead(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classePublicLire_stored_boolean"));
	}
	/**
	 * Example: false
	 **/
	protected void _classRoleSession(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeRoleSession_stored_boolean"));
	}
	/**
	 * Example: false
	 **/
	protected void _classRoleUser(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeRoleUtilisateur_stored_boolean"));
	}
	/**
	 * Example: false
	 **/
	protected void _classRoleEach(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeRoleChacun_stored_boolean"));
	}
	/**
	 * Example: [ "SiteAdmin" ],
	 **/
	protected void _classRoles(Wrap<List<String>> w) {
		w.o(doc.getJsonArray("classeRoles_stored_strings").getList());
	}
	/**
	 * Example: [ "enUS" ],
	 **/
	protected void _classRolesLanguage(Wrap<List<String>> w) {
		w.o(doc.getJsonArray("classeRolesLangue_stored_strings").getList());
	}
	/**
	 * Example: true
	 **/
	protected void _classRolesFound(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeRolesTrouves_stored_boolean"));
	}
	/**
	 * Example: false
	 **/
	protected void _classRoleReadFound(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeRoleLiresTrouves_stored_boolean"));
	}
	/**
	 * Example: false
	 **/
	protected void _classSessionWrite(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeSessionEcrire_stored_boolean"));
	}
	/**
	 * Example: false
	 **/
	protected void _classUserWrite(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeUtilisateurEcrire_stored_boolean"));
	}
	/**
	 * Example: false
	 **/
	protected void _classPublicWrite(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classePublicEcrire_stored_boolean"));
	}
	/**
	 * Example: false
	 **/
	protected void _classSessionRead(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeSessionLire_stored_boolean"));
	}
	/**
	 * Example: false
	 **/
	protected void _classUserRead(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeUtilisateurLire_stored_boolean"));
	}
	/**
	 * Example: false
	 **/
	protected void _classFiltersFound(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeFiltresTrouves_stored_boolean"));
	}
	/**
	 * Example: 5
	 **/
	protected void _sqlSort(Wrap<Integer> w) {
		w.o(doc.getInteger("sqlSort_stored_int"));
	}

	/**
	 * {@inheritDoc}
	 * UniqueKey: true
	 * Description: The unique key for this record in the search engine
	 * Persist: true
	 */
	protected void _id(Wrap<String> w) {
		w.o(doc.getString("id"));
	}
	/**
	 * Example: true
	 **/
	protected void _partIsClass(Wrap<Boolean> w) {
		w.o(doc.getBoolean("partEstClasse_stored_boolean"));
	}
	/**
	 * Example: 1
	 **/
	protected void _partNumber(Wrap<Integer> w) {
		w.o(doc.getInteger("partNumero_stored_int"));
	}
	/**
	 * Example: [ "java.math.BigDecimal", "java.util.List",
	 * "org.choicehumanitarian.reports.enus.base.BaseModel",
	 * "org.choicehumanitarian.reports.enus.wrap.Wrap" ],
	 **/
	protected void _classImports(Wrap<List<String>> w) {
		w.o(doc.getJsonArray("classeImportations_enUS_stored_strings").getList());
	}
	/**
	 * Example: [ "pageUrlApi", "pageH1" ],
	 **/
	protected void _classEntityVars(Wrap<List<String>> w) {
		w.o(doc.getJsonArray("classeEntiteVars_enUS_stored_strings").getList());
	}
	/**
	 * Example: [ "java.util.Objects", "io.vertx.core.WorkerExecutor" ]
	 **/
	protected void _classImportsGenApi(Wrap<List<String>> w) {
		w.o(doc.getJsonArray("classeImportationsGenApi_enUS_stored_strings").getList());
	}
	/**
	 * Example: [ "ChoiceReportPage" ]
	 **/
	protected void _classAttributeSimpleNamePages(Wrap<List<String>> w) {
		w.o(doc.getJsonArray("classeAttribuerNomSimplePages_enUS_stored_strings").getList());
	}
	/**
	 * Example: [ "_objectTitle", "toId" ]
	 **/
	protected void _classMethodVars(Wrap<List<String>> w) {
		w.o(doc.getJsonArray("classeMethodeVars_enUS_stored_strings").getList());
	}
	/**
	 * Example: "objectSuggest"
	 **/
	protected void _classVarSuggested(Wrap<String> w) {
		w.o(doc.getString("classeVarSuggere_enUS_stored_string"));
	}
	/**
	 * Example: "objectText"
	 **/
	protected void _classVarText(Wrap<String> w) {
		w.o(doc.getString("classeVarTexte_enUS_stored_string"));
	}
	/**
	 * Example: "pk"
	 **/
	protected void _classVarPrimaryKey(Wrap<String> w) {
		w.o(doc.getString("classeVarClePrimaire_enUS_stored_string"));
	}
	/**
	 * Example: "inheritPk"
	 **/
	protected void _classVarInheritPrimaryKey(Wrap<String> w) {
		w.o(doc.getString("classeVarInheritClePrimaire_enUS_stored_string"));
	}
	/**
	 * Example: "saves"
	 **/
	protected void _classVarSaves(Wrap<String> w) {
		w.o(doc.getString("classeVarSauvegardes_enUS_stored_string"));
	}
	/**
	 * Example: "id"
	 **/
	protected void _classvarUniqueKey(Wrap<String> w) {
		w.o(doc.getString("classeVarCleUnique_enUS_stored_string"));
	}
	/**
	 * Example: "modified"
	 **/
	protected void _classVarModified(Wrap<String> w) {
		w.o(doc.getString("classeVarModifie_enUS_stored_string"));
	}
	/**
	 * Example: "created"
	 **/
	protected void _classVarCreated(Wrap<String> w) {
		w.o(doc.getString("classeVarCree_enUS_stored_string"));
	}
	/**
	 * Example: "pageUrlId"
	 **/
	protected void _classVarUrlId(Wrap<String> w) {
		w.o(doc.getString("classeVarUrlId_enUS_stored_string"));
	}
	/**
	 * Example: "pageUrlPk"
	 **/
	protected void _classVarUrlPk(Wrap<String> w) {
		w.o(doc.getString("classeVarUrlPk_enUS_stored_string"));
	}
	/**
	 * Example: "objectId"
	 **/
	protected void _classVarId(Wrap<String> w) {
		w.o(doc.getString("classeVarId_enUS_stored_string"));
	}
	/**
	 * Example: "objectTitle"
	 **/
	protected void _classVarTitle(Wrap<String> w) {
		w.o(doc.getString("classeVarTitre_enUS_stored_string"));
	}
	/**
	 * Example: false
	 **/
	protected void _classKeywordsFound(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeMotsClesTrouves_stored_boolean"));
	}
	/**
	 * Example: "org.choicehumanitarian.reports.enus.model.donor.ChoiceDonor"
	 **/
	protected void _classPageCanonicalName(Wrap<String> w) {
		w.o(doc.getString("classePageNomCanonique_enUS_stored_string"));
	}
	/**
	 * Example: "ChoiceDonorPage"
	 **/
	protected void _classPageSimpleName(Wrap<String> w) {
		w.o(doc.getString("classePageNomSimple_enUS_stored_string"));
	}
	/**
	 * Example: "ChoiceDonorGenPage"
	 **/
	protected void _classGenPageSimpleName(Wrap<String> w) {
		w.o(doc.getString("classeGenPageNomSimple_enUS_stored_string"));
	}
	/**
	 * Example: "org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage"
	 **/
	protected void _classGenPageCanonicalName(Wrap<String> w) {
		w.o(doc.getString("classeGenPageNomCanonique_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "/home/ctate/.local/src/choice-reports/src/main/java/org/choicehumanitarian/reports/enus/model/donor/ChoiceDonorGenPage.java"
	 **/
	protected void _classGenPagePath(Wrap<String> w) {
		w.o(doc.getString("classeGenPageChemin_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "/home/ctate/.local/src/choice-reports/src/main/java/org/choicehumanitarian/reports/enus/model/donor/ChoiceDonorPage.java"
	 **/
	protected void _classPagePath(Wrap<String> w) {
		w.o(doc.getString("classePageChemin_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "/home/ctate/.local/src/choice-reports-static/css/enUS/ChoiceDonorPage.css"
	 **/
	protected void _classPagePathCss(Wrap<String> w) {
		w.o(doc.getString("classePageCheminCss_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "/home/ctate/.local/src/choice-reports-static/js/enUS/ChoiceDonorPage.js"
	 **/
	protected void _classPagePathJs(Wrap<String> w) {
		w.o(doc.getString("classePageCheminJs_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "/home/ctate/.local/src/choice-reports/src/main/resources/templates/enUS/ChoiceDonorPage.hbs"
	 **/
	protected void _classPagePathHbs(Wrap<String> w) {
		w.o(doc.getString("classePageCheminHbs_enUS_stored_string"));
	}
	/**
	 * Example:
	 * "/home/ctate/.local/src/choice-reports/src/main/resources/templates/enUS/ChoiceDonorGenPage.hbs"
	 **/
	protected void _classGenPagePathHbs(Wrap<String> w) {
		w.o(doc.getString("classeGenPageCheminHbs_enUS_stored_string"));
	}
	/**
	 * Example: "enUS"
	 **/
	protected void _classPageLanguageName(Wrap<String> w) {
		w.o(doc.getString("classePageLangueNom_enUS_stored_string"));
	}
	/**
	 * Example: "org.choicehumanitarian.reports.enus.base.BaseModelPage"
	 **/
	protected void _classPageSuperCanonicalName(Wrap<String> w) {
		w.o(doc.getString("classePageSuperNomCanonique_enUS_stored_string"));
	}
	/**
	 * Example: "BaseModelPage"
	 **/
	protected void _classSuperPageSimpleName(Wrap<String> w) {
		w.o(doc.getString("classePageSuperNomSimple_enUS_stored_string"));
	}
	/**
	 * Example: [ "java.lang.String", "java.lang.Long" ]
	 **/
	protected void _classImportsGenPage(Wrap<List<String>> w) {
		w.o(doc.getJsonArray("classeImportationsGenPage_enUS_stored_strings").getList());
	}
	/**
	 * Example: "/api/donor"
	 **/
	protected void _classApiUri(Wrap<String> w) {
		w.o(doc.getString("classeApiUri_enUS_stored_string"));
	}
	/**
	 * Example: "Donor"
	 **/
	protected void _classApiTag(Wrap<String> w) {
		w.o(doc.getString("classeApiTag_enUS_stored_string"));
	}
	/**
	 * Example: [ "PUTImport", "POST", "PATCH", "GET", "Search", "SearchPage" ]
	 **/
	protected void _classApiMethods(Wrap<List<String>> w) {
		w.o(doc.getJsonArray("classeApiMethodes_enUS_stored_strings").getList());
	}
	/**
	 * Example: true
	 **/
	protected void _classContext(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeContexte_stored_boolean"));
	}
	/**
	 * Example: "light-green"
	 **/
	protected void _contextColor(Wrap<String> w) {
		w.o(doc.getString("contexteCouleur_stored_string"));
	}
	/**
	 * Example: "duotone"
	 **/
	protected void _contextIconGroup(Wrap<String> w) {
		w.o(doc.getString("contexteIconeGroupe_stored_string"));
	}
	/**
	 * Example: "hands-heart"
	 **/
	protected void _contextIconName(Wrap<String> w) {
		w.o(doc.getString("contexteIconeNom_stored_string"));
	}
	/**
	 * Example: 100
	 **/
	protected void _contextRows(Wrap<Integer> w) {
		w.o(doc.getInteger("contexteRows_stored_int"));
	}
	/**
	 * Example: "a donor"
	 **/
	protected void _contextAName(Wrap<String> w) {
		w.o(doc.getString("contexteUnNom_enUS_stored_string"));
	}
	/**
	 * Example: "donor"
	 **/
	protected void _contextNameSingular(Wrap<String> w) {
		w.o(doc.getString("contexteNomSingulier_enUS_stored_string"));
	}
	/**
	 * Example: "donors"
	 **/
	protected void _contextNamePlural(Wrap<String> w) {
		w.o(doc.getString("contexteNomPluriel_enUS_stored_string"));
	}
	/**
	 * Example: "donor"
	 **/
	protected void _contextNameVar(Wrap<String> w) {
		w.o(doc.getString("contexteNomVar_enUS_stored_string"));
	}
	/**
	 * Example: "the donors"
	 **/
	protected void _contextTheNames(Wrap<String> w) {
		w.o(doc.getString("contexteLesNoms_enUS_stored_string"));
	}
	/**
	 * Example: "donor"
	 **/
	protected void _contextNameAdjectiveSingular(Wrap<String> w) {
		w.o(doc.getString("contexteNomAdjectifSingulier_enUS_stored_string"));
	}
	/**
	 * Example: "donors"
	 **/
	protected void _contextNameAdjectivePlural(Wrap<String> w) {
		w.o(doc.getString("contexteNomAdjectifPluriel_enUS_stored_string"));
	}
	/**
	 * Example: "this "
	 **/
	protected void _contextThis(Wrap<String> w) {
		w.o(doc.getString("contexteCe_enUS_stored_string"));
	}
	/**
	 * Example: "a "
	 **/
	protected void _contextA(Wrap<String> w) {
		w.o(doc.getString("contexteUn_enUS_stored_string"));
	}
	/**
	 * Example: "created "
	 **/
	protected void _contextCreated(Wrap<String> w) {
		w.o(doc.getString("contexteCree_enUS_stored_string"));
	}
	/**
	 * Example: "modified "
	 **/
	protected void _contextModified(Wrap<String> w) {
		w.o(doc.getString("contexteModifie_enUS_stored_string"));
	}
	/**
	 * Example: "current donor"
	 **/
	protected void _contextActualName(Wrap<String> w) {
		w.o(doc.getString("contexteNomActuel_enUS_stored_string"));
	}
	/**
	 * Example: "all "
	 **/
	protected void _contextAll(Wrap<String> w) {
		w.o(doc.getString("contexteTous_enUS_stored_string"));
	}
	/**
	 * Example: "all the donors"
	 **/
	protected void _contextAllName(Wrap<String> w) {
		w.o(doc.getString("contexteTousNom_enUS_stored_string"));
	}
	/**
	 * Example: "search donors by "
	 **/
	protected void _contextSearchAllNameBy(Wrap<String> w) {
		w.o(doc.getString("contexteRechercherTousNomPar_enUS_stored_string"));
	}
	/**
	 * Example: "search donors"
	 **/
	protected void _contextSearchAllName(Wrap<String> w) {
		w.o(doc.getString("contexteRechercherTousNomr_enUS_stored_string"));
	}
	/**
	 * Example: "no donor found"
	 **/
	protected void _contextNoNameFound(Wrap<String> w) {
		w.o(doc.getString("contexteAucunNomTrouve_enUS_stored_string"));
	}
	/**
	 * Example: "a donor"
	 **/
	protected void _contextANameAdjective(Wrap<String> w) {
		w.o(doc.getString("contexteUnNomAdjectif_enUS_stored_string"));
	}
	/**
	 * Example: "this donor"
	 **/
	protected void _contextThisName(Wrap<String> w) {
		w.o(doc.getString("contexteCeNom_enUS_stored_string"));
	}
	/**
	 * Example: "the donor"
	 **/
	protected void _contextTheName(Wrap<String> w) {
		w.o(doc.getString("contexteLeNom_enUS_stored_string"));
	}
	/**
	 * Example: "of donor"
	 **/
	protected void _contextOfName(Wrap<String> w) {
		w.o(doc.getString("contexteDeNom_enUS_stored_string"));
	}
	/**
	 * Example: "this "
	 **/
	protected void _contextThisLowercase(Wrap<String> w) {
		w.o(doc.getString("contexteCeMinuscule_enUS_stored_string"));
	}
	/**
	 * Example: "donors"
	 **/
	protected void _contextTitle(Wrap<String> w) {
		w.o(doc.getString("contexteTitre_enUS_stored_string"));
	}
	/**
	 * Example: true
	 **/
	protected void _classIndexed(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeIndexe_stored_boolean"));
	}
	/**
	 * Example: false
	 **/
	protected void _classImage(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeImage_stored_boolean"));
	}
	/**
	 * Example: true
	 **/
	protected void _classPromise(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classePromesse_stored_boolean"));
	}
	/**
	 * Example: [ "com.fasterxml.jackson.annotation.JsonProperty",
	 * "java.util.Arrays" ]
	 **/
	protected void _classImportsGen(Wrap<List<String>> w) {
		w.o(doc.getJsonArray("classeImportationsGen_enUS_stored_strings").getList());
	}
	/**
	 * Example: true
	 **/
	protected void _classSortsFound(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classeTrisTrouves_stored_boolean"));
	}
	/**
	 * Example: [ "_string" ]
	 **/
	protected void _classSortsSuffixType(Wrap<List<String>> w) {
		w.o(doc.getJsonArray("classeTrisSuffixeType_stored_strings").getList());
	}
	/**
	 * Example: [ "asc" ]
	 **/
	protected void _classSortsOrder(Wrap<List<String>> w) {
		w.o(doc.getJsonArray("classeTrisOrdre_stored_strings").getList());
	}
	/**
	 * Example: [ "objectId" ]
	 **/
	protected void _classSortsVar(Wrap<List<String>> w) {
		w.o(doc.getJsonArray("classeTrisVar_enUS_stored_strings").getList());
	}
	/**
	 * Example: true
	 **/
	protected void _classPage(Wrap<Boolean> w) {
		w.o(doc.getBoolean("classePage_stored_boolean"));
	}
	/**
	 * Example: 1722544850761416700
	 */
	protected void _version(Wrap<Boolean> w) {
		w.o(doc.getBoolean("_version_"));
	}
}
