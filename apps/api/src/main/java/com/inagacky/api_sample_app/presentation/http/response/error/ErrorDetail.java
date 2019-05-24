package com.inagacky.api_sample_app.presentation.http.response.error;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Data
@NoArgsConstructor
public class ErrorDetail {

    private String errorField;
    private ErrorDetailCode errorDetailCode;
    private String errorMessage;

    public enum ErrorDetailCode implements JsonSerializable {
        ERROR_1(201),
        ERROR_2(202),
        ;
        private final int errorCode;

        ErrorDetailCode(final int errorCode) {
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
