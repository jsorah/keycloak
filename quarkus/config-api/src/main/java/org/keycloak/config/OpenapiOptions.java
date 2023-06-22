/*
 * Copyright 2023 Red Hat, Inc. and/or its affiliates
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
 */

package org.keycloak.config;

public class OpenapiOptions {

    private OpenapiOptions() { }

    public static final String KEY_SWAGGER_UI_ENABLED = "swaggerui-enabled";
    public static final Option<Boolean> SWAGGER_UI_ENABLED = new OptionBuilder<>(KEY_SWAGGER_UI_ENABLED, Boolean.class)
            .category(OptionCategory.OPENAPI)
            .description("If the server should expose a Swagger UI. If enabled, the Swagger UI is available at '/swagger-ui'. This also enables the openapi specification.")
            .buildTime(true)
            .defaultValue(Boolean.FALSE)
            .build();

    public static final String KEY_OPENAPI_ENABLED = "openapi-enabled";
    public static final Option<Boolean> OPENAPI_ENABLED = new OptionBuilder<>(KEY_OPENAPI_ENABLED, Boolean.class)
            .category(OptionCategory.OPENAPI)
            .description("If the server should expose an OpenAPI specification. If enabled, the OpenAPI specification is available at '/openapi'")
            .buildTime(true)
            .defaultValue(Boolean.FALSE)
            .build();
}
