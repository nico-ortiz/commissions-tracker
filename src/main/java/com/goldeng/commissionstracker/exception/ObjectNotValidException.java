package com.goldeng.commissionstracker.exception;

import java.util.Set;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ObjectNotValidException extends RuntimeException {

    private final Set<String> errorMessages;
}