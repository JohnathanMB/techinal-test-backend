package org.example.model;

public record ResponseDto<T>(int statusCode, T body) {
}
