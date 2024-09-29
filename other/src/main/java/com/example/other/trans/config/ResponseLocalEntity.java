package com.example.other.trans.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;

import java.net.URI;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-08-01
 */
public class ResponseLocalEntity<T> extends HttpLocalEntity<T> {
    private final HttpStatusCode status;

    public ResponseLocalEntity(HttpStatusCode status) {
        this( null, (MultiValueMap) null, status);
    }

    public ResponseLocalEntity(@Nullable T body, HttpStatusCode status) {
        this(body, (MultiValueMap) null, status);
    }

    public ResponseLocalEntity(MultiValueMap<String, String> headers, HttpStatusCode status) {
        this( null, headers, status);
    }

    public ResponseLocalEntity(@Nullable T body, @Nullable MultiValueMap<String, String> headers, int rawStatus) {
        this(body, headers, HttpStatusCode.valueOf(rawStatus));
    }

    public ResponseLocalEntity(@Nullable T body, @Nullable MultiValueMap<String, String> headers, HttpStatusCode statusCode) {
        super(body, headers);
        Assert.notNull(statusCode, "HttpStatusCode must not be null");
        this.status = statusCode;
    }

    public HttpStatusCode getStatusCode() {
        return this.status;
    }

    /**
     * @deprecated
     */
    @Deprecated(
            since = "6.0"
    )
    public int getStatusCodeValue() {
        return this.getStatusCode().value();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        } else if (!super.equals(other)) {
            return false;
        } else {
            ResponseLocalEntity<?> otherEntity = (ResponseLocalEntity) other;
            return ObjectUtils.nullSafeEquals(this.status, otherEntity.status);
        }
    }

    public int hashCode() {
        return 29 * super.hashCode() + ObjectUtils.nullSafeHashCode(this.status);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("<");
        builder.append(this.status);
        HttpStatusCode var3 = this.status;
        if (var3 instanceof HttpStatus httpStatus) {
            builder.append(' ');
            builder.append(httpStatus.getReasonPhrase());
        }

        builder.append(',');
        T body = this.getBody();
        HttpHeaders headers = this.getHeaders();
        if (body != null) {
            builder.append(body);
            builder.append(',');
        }

        builder.append(headers);
        builder.append('>');
        return builder.toString();
    }

    public static ResponseLocalEntity.BodyBuilder status(HttpStatusCode status) {
        Assert.notNull(status, "HttpStatusCode must not be null");
        return new ResponseLocalEntity.DefaultBuilder(status);
    }

    public static ResponseLocalEntity.BodyBuilder status(int status) {
        return new ResponseLocalEntity.DefaultBuilder(status);
    }

    public static ResponseLocalEntity.BodyBuilder ok() {
        return status(HttpStatus.OK);
    }

    public static <T> ResponseLocalEntity<T> ok(@Nullable T body) {
        return ok().body(body);
    }

    public static <T> ResponseLocalEntity<T> of(Optional<T> body) {
        Assert.notNull(body, "Body must not be null");
        return (ResponseLocalEntity) body.map(ResponseLocalEntity::ok).orElseGet(() -> {
            return notFound().build();
        });
    }

    public static ResponseLocalEntity.HeadersBuilder<?> of(final ProblemDetail body) {
        return new ResponseLocalEntity.DefaultBuilder(body.getStatus()) {
            public <T> ResponseLocalEntity<T> build() {
                return this.body((T)body);
            }
        };
    }

    public static <T> ResponseLocalEntity<T> ofNullable(@Nullable T body) {
        return body == null ? notFound().build() : ok(body);
    }

    public static ResponseLocalEntity.BodyBuilder created(URI location) {
        return (ResponseLocalEntity.BodyBuilder) status(HttpStatus.CREATED).location(location);
    }

    public static ResponseLocalEntity.BodyBuilder accepted() {
        return status(HttpStatus.ACCEPTED);
    }

    public static ResponseLocalEntity.HeadersBuilder<?> noContent() {
        return status(HttpStatus.NO_CONTENT);
    }

    public static ResponseLocalEntity.BodyBuilder badRequest() {
        return status(HttpStatus.BAD_REQUEST);
    }

    public static ResponseLocalEntity.HeadersBuilder<?> notFound() {
        return status(HttpStatus.NOT_FOUND);
    }

    public static ResponseLocalEntity.BodyBuilder unprocessableEntity() {
        return status(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public static ResponseLocalEntity.BodyBuilder internalServerError() {
        return status(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static class DefaultBuilder implements ResponseLocalEntity.BodyBuilder {
        private final HttpStatusCode statusCode;
        private final HttpHeaders headers;

        public DefaultBuilder(int statusCode) {
            this(HttpStatusCode.valueOf(statusCode));
        }

        public DefaultBuilder(HttpStatusCode statusCode) {
            this.headers = new HttpHeaders();
            this.statusCode = statusCode;
        }

        public ResponseLocalEntity.BodyBuilder header(String headerName, String... headerValues) {
            String[] var3 = headerValues;
            int var4 = headerValues.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                String headerValue = var3[var5];
                this.headers.add(headerName, headerValue);
            }

            return this;
        }

        public ResponseLocalEntity.BodyBuilder headers(@Nullable HttpHeaders headers) {
            if (headers != null) {
                this.headers.putAll(headers);
            }

            return this;
        }

        public ResponseLocalEntity.BodyBuilder headers(Consumer<HttpHeaders> headersConsumer) {
            headersConsumer.accept(this.headers);
            return this;
        }

        public ResponseLocalEntity.BodyBuilder allow(HttpMethod... allowedMethods) {
            this.headers.setAllow(new LinkedHashSet(Arrays.asList(allowedMethods)));
            return this;
        }

        public ResponseLocalEntity.BodyBuilder contentLength(long contentLength) {
            this.headers.setContentLength(contentLength);
            return this;
        }

        public ResponseLocalEntity.BodyBuilder contentType(MediaType contentType) {
            this.headers.setContentType(contentType);
            return this;
        }

        public ResponseLocalEntity.BodyBuilder eTag(@Nullable String etag) {
            if (etag != null) {
                if (!etag.startsWith("\"") && !etag.startsWith("W/\"")) {
                    etag = "\"" + etag;
                }

                if (!etag.endsWith("\"")) {
                    etag = etag + "\"";
                }
            }

            this.headers.setETag(etag);
            return this;
        }

        public ResponseLocalEntity.BodyBuilder lastModified(ZonedDateTime date) {
            this.headers.setLastModified(date);
            return this;
        }

        public ResponseLocalEntity.BodyBuilder lastModified(Instant date) {
            this.headers.setLastModified(date);
            return this;
        }

        public ResponseLocalEntity.BodyBuilder lastModified(long date) {
            this.headers.setLastModified(date);
            return this;
        }

        public ResponseLocalEntity.BodyBuilder location(URI location) {
            this.headers.setLocation(location);
            return this;
        }

        public ResponseLocalEntity.BodyBuilder cacheControl(CacheControl cacheControl) {
            this.headers.setCacheControl(cacheControl);
            return this;
        }

        public ResponseLocalEntity.BodyBuilder varyBy(String... requestHeaders) {
            this.headers.setVary(Arrays.asList(requestHeaders));
            return this;
        }

        public <T> ResponseLocalEntity<T> build() {
            return this.body( null);
        }

        public <T> ResponseLocalEntity<T> body(@Nullable T body) {
            return new ResponseLocalEntity(body, this.headers, this.statusCode);
        }
    }

    public interface BodyBuilder extends ResponseLocalEntity.HeadersBuilder<ResponseLocalEntity.BodyBuilder> {
        ResponseLocalEntity.BodyBuilder contentLength(long contentLength);

        ResponseLocalEntity.BodyBuilder contentType(MediaType contentType);

        <T> ResponseLocalEntity<T> body(@Nullable T body);
    }

    public interface HeadersBuilder<B extends ResponseLocalEntity.HeadersBuilder<B>> {
        B header(String headerName, String... headerValues);

        B headers(@Nullable HttpHeaders headers);

        B headers(Consumer<HttpHeaders> headersConsumer);

        B allow(HttpMethod... allowedMethods);

        B eTag(@Nullable String etag);

        B lastModified(ZonedDateTime lastModified);

        B lastModified(Instant lastModified);

        B lastModified(long lastModified);

        B location(URI location);

        B cacheControl(CacheControl cacheControl);

        B varyBy(String... requestHeaders);

        <T> ResponseLocalEntity<T> build();
    }
}
