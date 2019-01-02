package com.inagacky.api_sample_app.application.http.response.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.List;

@Data
@NoArgsConstructor
public class ErrorResponse {

    @JsonProperty("error_code")
    private ErrorCode errorCode;
    @JsonProperty("error_message")
    private String errorMessage;
    @JsonProperty("details")
    private List<ErrorDetail> errorDetails;

    public enum ErrorCode implements JsonSerializable {
        UNKNOWN_ERROR(100)
        ;

        private final int errorCode;

        ErrorCode(final int errorCode) {
            this.errorCode = errorCode;
        }

        public int getInt() {
            return this.errorCode;
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
