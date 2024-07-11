package it.cascella.redisBridge.dto;

import lombok.Value;

@Value
public class TaskDto {
    Long id;
    String text;
    String type;

}