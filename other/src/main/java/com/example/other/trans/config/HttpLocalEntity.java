package com.example.other.trans.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-08-01
 */
public class HttpLocalEntity<T>{
    public static final HttpLocalEntity<?> EMPTY = new HttpLocalEntity();
    private final HttpHeaders headers;
    @JsonIgnore
    @Nullable
    private final T body;

    protected HttpLocalEntity() {
        this(null, (MultiValueMap)null);
    }

    public HttpLocalEntity(T body) {
        this(body, (MultiValueMap)null);
    }

    public HttpLocalEntity(MultiValueMap<String, String> headers) {
        this(null, headers);
    }

    public HttpLocalEntity(@Nullable T body, @Nullable MultiValueMap<String, String> headers) {
        this.body = body;
        this.headers = HttpHeaders.readOnlyHttpHeaders((MultiValueMap)(headers != null ? headers : new HttpHeaders()));
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }

    @Nullable
    public T getBody() {
        return this.body;
    }

    public boolean hasBody() {
        return this.body != null;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        } else if (other != null && other.getClass() == this.getClass()) {
            HttpLocalEntity<?> otherEntity = (HttpLocalEntity)other;
            return ObjectUtils.nullSafeEquals(this.headers, otherEntity.headers) && ObjectUtils.nullSafeEquals(this.body, otherEntity.body);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return ObjectUtils.nullSafeHash(new Object[]{this.headers, this.body});
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("<");
        if (this.body != null) {
            builder.append(this.body);
            builder.append(',');
        }

        builder.append(this.headers);
        builder.append('>');
        return builder.toString();
    }
}
