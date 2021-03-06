/*
* Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.wso2.developerstudio.codenvy.ext.registry.server.project;

import com.codenvy.api.project.server.ProjectTypeDescriptionRegistry;
import com.codenvy.api.project.server.ProjectTypeExtension;
import com.codenvy.api.project.shared.Attribute;
import com.codenvy.api.project.shared.ProjectTemplateDescription;
import com.codenvy.api.project.shared.ProjectType;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Arrays;
import java.util.List;

import org.wso2.developerstudio.codenvy.ext.registry.shared.RegistryExtConstants;

import javax.inject.Named;

@Singleton
public class RegistryProjectTypeExtension implements ProjectTypeExtension {

	private final String baseUrl;

	@Inject
	public RegistryProjectTypeExtension(@Named("extension-url") String baseUrl,
	                                    ProjectTypeDescriptionRegistry registry) {
		this.baseUrl = baseUrl;
		registry.registerProjectType(this);
	}

	@Override
	public ProjectType getProjectType() {
		return new ProjectType(RegistryExtConstants.WSO2_REGISTRY_PROJECT_ID,
		                       RegistryExtConstants.WSO2_REGISTRY_PROJECT,
		                       RegistryExtConstants.WSO2_PROJECT_ID);
	}

	@Override
	public List<Attribute> getPredefinedAttributes() {
		return Arrays.asList(
				new Attribute(RegistryExtConstants.LANGUAGE, RegistryExtConstants.WSO2_PROJECT_ID),
				new Attribute(RegistryExtConstants.FRAMEWORK, RegistryExtConstants.WSO2_PROJECT_ID),
				new Attribute(RegistryExtConstants.BUILDER_NAME, "maven")
		);
	}

	@Override
	public List<ProjectTemplateDescription> getTemplates() {
		return Arrays.asList(new ProjectTemplateDescription("zip",
		                                                    RegistryExtConstants.WSO2_REGISTRY_PROJECT,
		                                                    "This is a simple Registry resources project.",
		                                                    baseUrl +
		                                                    "templates/appserver-project.zip"));
	}
}
