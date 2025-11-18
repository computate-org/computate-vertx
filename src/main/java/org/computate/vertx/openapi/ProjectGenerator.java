/*
 * Copyright Computate Limited Liability Company in Utah, USA. 
 * SPDX-License-Identifier: AGPL-3.0
 * This program and the accompanying materials are made available under the
 * terms of the GNU AFFERO GENERAL PUBLIC LICENSE which is available at
 * 
 * https://www.gnu.org/licenses/agpl-3.0.html
 * 
 * You may not propagate or modify a covered work except as expressly provided 
 * under this License. Any attempt otherwise to propagate or modify it is void, 
 * and will automatically terminate your rights under this License (including 
 * any patent licenses granted under the third paragraph of section 11).
 */
package org.computate.vertx.openapi;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Objects;

import org.computate.search.wrap.Wrap;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.impl.VertxInternal;

/**
 * InitDeepBefore: true
 */
public class ProjectGenerator extends ProjectGeneratorGen<BaseGenerator> {

	protected void _siteStaticPath(Wrap<String> c) {
		c.o(appPath + "-static");
	}

	protected void _siteStaticJsDir(Wrap<File> c) {
		c.o(new File(siteStaticPath, "js").getAbsoluteFile());
	}

	protected void _platformStaticPath(Wrap<String> c) {
		if(platformPomArtifactId != null)
			c.o(appPath + "/../" + platformPomArtifactId + "-static");
	}

	protected void _platformStaticJsDir(Wrap<File> c) {
		if(platformPomArtifactId != null)
			c.o(new File(platformStaticPath, "js").getAbsoluteFile());
	}

	protected void _siteResourcesPath(Wrap<String> c) {
		c.o(appPath + "/src/main/resources");
	}

	protected void _siteTemplatesDir(Wrap<File> c) {
		c.o(new File(siteResourcesPath, "templates").getAbsoluteFile());
	}

	protected void _platformResourcesPath(Wrap<String> c) {
		if(platformPomArtifactId != null)
			c.o(appPath + "/../" + platformPomArtifactId + "/src/main/resources");
	}

	protected void _platformTemplatesDir(Wrap<File> c) {
		if(platformPomArtifactId != null)
			c.o(new File(platformResourcesPath, "templates").getAbsoluteFile());
	}

	/**
	 * Val.Success.enUS: Copy platform static files succeeded. 
	 * Val.Fail.enUS: Copy platform static files failed. 
	 **/
	public Future<Void> writeProject() {
		Promise<Void> promise = Promise.promise();

		copyPlatformStaticFiles().onSuccess(a -> {
			copyPlatformResourceFiles().onSuccess(b -> {
				LOG.info(writeProjectSuccess);
				promise.complete();
			}).onFailure(ex -> {
				LOG.error(writeProjectFail, ex);
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			LOG.error(writeProjectFail, ex);
			promise.fail(ex);
		});

		return promise.future();
	}

	/**
	 * Val.Success.enUS: Copy platform static files from %s to %s succeeded. 
	 * Val.Fail.enUS: Copy platform static files from %s to %s failed. 
	 **/
	public Future<Void> copyPlatformStaticFiles() {
		Promise<Void> promise = Promise.promise();

		try {
			if(platformStaticJsDir == null || siteStaticJsDir == null) {
				promise.complete();
			} else {
				vertx_.fileSystem().mkdirs(siteStaticJsDir.getAbsolutePath()).onComplete(a -> {
					copyRecursive(vertx_, platformStaticJsDir.getAbsolutePath(), siteStaticJsDir.getAbsolutePath()).onComplete(b -> {
						LOG.info(String.format(copyPlatformStaticFilesSuccess, platformStaticJsDir.getAbsolutePath(), siteStaticJsDir.getAbsolutePath()));
						promise.complete();
					}).onFailure(ex -> {
						LOG.error(String.format(copyPlatformStaticFilesFail, platformStaticJsDir.getAbsolutePath(), siteStaticJsDir.getAbsolutePath()), ex);
						promise.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error(String.format(copyPlatformStaticFilesFail, platformStaticJsDir.getAbsolutePath(), siteStaticJsDir.getAbsolutePath()), ex);
					promise.fail(ex);
				});
			}
		} catch (Exception ex) {
			LOG.error(String.format(copyPlatformStaticFilesFail, platformStaticJsDir.getAbsolutePath(), siteStaticJsDir.getAbsolutePath()), ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**
	 * Val.Success.enUS: Copy platform resource files from %s to %s succeeded. 
	 * Val.Fail.enUS: Copy platform resource files from %s to %s failed. 
	 **/
	public Future<Void> copyPlatformResourceFiles() {
		Promise<Void> promise = Promise.promise();

		try {
			if(platformTemplatesDir == null || siteTemplatesDir == null) {
				promise.complete();
			} else {
				vertx_.fileSystem().mkdirs(siteTemplatesDir.getAbsolutePath()).onComplete(a -> {
					copyRecursive(vertx_, platformTemplatesDir.getAbsolutePath(), siteTemplatesDir.getAbsolutePath()).onComplete(b -> {
						LOG.error(String.format(copyPlatformResourceFilesSuccess, platformTemplatesDir.getAbsolutePath(), siteTemplatesDir.getAbsolutePath()));
						promise.complete();
					}).onFailure(ex -> {
						LOG.error(String.format(copyPlatformResourceFilesFail, platformTemplatesDir.getAbsolutePath(), siteTemplatesDir.getAbsolutePath()), ex);
						promise.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error(String.format(copyPlatformResourceFilesFail, platformTemplatesDir.getAbsolutePath(), siteTemplatesDir.getAbsolutePath()), ex);
					promise.fail(ex);
				});
			}
		} catch (Exception ex) {
			LOG.error(String.format(copyPlatformResourceFilesFail, platformTemplatesDir.getAbsolutePath(), siteTemplatesDir.getAbsolutePath()), ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**
	 * Val.Success.enUS: Copy files recursively succeeded. 
	 * Val.Fail.enUS: Copy files recursively failed. 
	 **/
	private Future<Void> copyRecursive(Vertx vertx, String from, String to) {
		Promise<Void> promise = Promise.promise();
		try {
			Objects.requireNonNull(from);
			Objects.requireNonNull(to);
			vertx.executeBlocking(a -> {
				try {
					Path source = ((VertxInternal)vertx).resolveFile(from).toPath();
					Path target = ((VertxInternal)vertx).resolveFile(to).toPath();
					Files.walkFileTree(source, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
							new SimpleFileVisitor<Path>() {
								public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
										throws IOException {
									Path targetDir = target.resolve(source.relativize(dir));
									try {
										Files.copy(dir, targetDir);
									} catch (FileAlreadyExistsException e) {
										if (!Files.isDirectory(targetDir)) {
											throw e;
										}
									}
									return FileVisitResult.CONTINUE;
								}
	
								@Override
								public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
										throws IOException {
									Files.copy(file, target.resolve(source.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
									return FileVisitResult.CONTINUE;
								}
							});
					promise.complete();
				} catch (Exception ex) {
					LOG.error(copyRecursiveFail, ex);
					promise.fail(ex);
				}
			});
		} catch (Exception ex) {
			LOG.error(copyRecursiveFail, ex);
			promise.fail(ex);
		}
		return promise.future();
	}
}
