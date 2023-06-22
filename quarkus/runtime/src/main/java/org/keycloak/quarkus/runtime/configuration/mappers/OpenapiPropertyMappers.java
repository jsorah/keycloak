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

package org.keycloak.quarkus.runtime.configuration.mappers;

import io.smallrye.config.ConfigSourceInterceptorContext;
import io.smallrye.config.ConfigValue;
import org.keycloak.config.OpenapiOptions;
import org.keycloak.quarkus.runtime.configuration.MicroProfileConfigProvider;

import java.util.Optional;

import static org.keycloak.quarkus.runtime.configuration.mappers.PropertyMapper.fromOption;

public class OpenapiPropertyMappers {

    private OpenapiPropertyMappers() { }

    public static PropertyMapper[] getOpenapiPropertyMappers() {

        return new PropertyMapper[] {
                fromOption(OpenapiOptions.SWAGGER_UI_ENABLED)
                        .to("quarkus.swagger-ui.enable")
                        .paramLabel(Boolean.TRUE + "|" + Boolean.FALSE)
                        .build(),
                fromOption(OpenapiOptions.OPENAPI_ENABLED)
                        .to("quarkus.smallrye-openapi.enable")
                        .transformer(OpenapiPropertyMappers::getOpenapiEnabledTransformer)
                        .paramLabel(Boolean.TRUE + "|" + Boolean.FALSE)
                        .build()
        };
    }

    private static Optional<String> getOpenapiEnabledTransformer(Optional<String> value, ConfigSourceInterceptorContext context) {

        // if they want swaggerui we must enable openapi as well
        ConfigValue swaggeruiEnabled =
                context.proceed(MicroProfileConfigProvider.NS_KEYCLOAK_PREFIX + OpenapiOptions.KEY_SWAGGER_UI_ENABLED);

        if (swaggeruiEnabled != null && "true".equalsIgnoreCase(swaggeruiEnabled.getValue())){
            return Optional.of("true");
        }

        return value;
    }


}
