package org.sergei.hibernate.caching.dto;

/**
 * @author Sergei Visotsky
 * @since 1.0
 */
public class HttpResponse<E> {

    private Status status;
    private E body;

    public HttpResponse() {
    }

    public HttpResponse(Status status, E body) {
        this.status = status;
        this.body = body;
    }

    public Status getStatus() {
        return status;
    }

    public E getBody() {
        return body;
    }
}
