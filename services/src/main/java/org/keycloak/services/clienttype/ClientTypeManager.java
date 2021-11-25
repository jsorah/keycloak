/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
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
 *
 */

package org.keycloak.services.clienttype;


import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.provider.Provider;
import org.keycloak.representations.idm.ClientTypesRepresentation;

/**
 * TODO:mposolda javadoc
 *
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public interface ClientTypeManager extends Provider {

    // Constants for global types
    String SERVICE_ACCOUNT = "service-account";

    // TODO:mposolda javadoc
    // TODO:mposolda check if "includeGlobal" is needed
    ClientTypesRepresentation getClientTypes(RealmModel realm, boolean includeGlobal);

    ClientType getClientType(KeycloakSession session, RealmModel realm, String typeName);

    @Override
    default void close() {
    }
}
