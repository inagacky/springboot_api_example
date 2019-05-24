package com.inagacky.api_sample_app.presentation.http.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.inagacky.api_sample_app.presentation.http.response.error.ErrorResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Data
@NoArgsConstructor
public class ApiResponse {

    @JsonProperty("results")
    private IApiResponseResult result;

    @JsonProperty("error")
    private ErrorResponse errorResponse;

    @JsonProperty("status")
    private StatusCode statusCode;

    public enum StatusCode implements JsonSerializable {
        VALID(200),
        INVALID(500)
        ;
        private final int statusCode;

        StatusCode(final int statusCode) {
            this.statusCode = statusCode;
        }

        public int getInt() {
            return this.statusCode;
        }

        @Override
        public void serialize(JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
            jsonGenerator.writeNumber(getInt());
        }

        @Override
        public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider provider, TypeSerializer typeSer)  throws IOException {
            jsonGenerator.writeNumber(getInt());
        }
    }
}
