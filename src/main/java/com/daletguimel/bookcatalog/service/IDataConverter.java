package com.daletguimel.bookcatalog.service;

public interface IDataConverter {
    <T> T fromJson(String json, Class<T> type);
}
