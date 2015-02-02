/**
 *
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.che.ext.esb.client.wizard;

import com.codenvy.ide.api.mvp.View;
import com.google.inject.ImplementedBy;


@ImplementedBy(ESBConfigurationViewImpl.class)
public interface ESBConfigurationView extends View<ESBConfigurationView.ActionDelegate> {

    String getGroupId();

    void setGroupId(String groupId);

    String getArtifactId();

    void setArtifactId(String artifactId);

    String getVersion();

    void setVersion(String version);

    interface ActionDelegate {

        void onGroupIdChanged();

        void onArtifactIdChanged();

        void onVersionChanged();
    }

}
