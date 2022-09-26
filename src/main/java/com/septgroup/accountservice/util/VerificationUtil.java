package com.septgroup.accountservice.util;

import com.septgroup.accountservice.exception.InvalidIdException;

import java.util.UUID;

public class VerificationUtil {
    public static UUID ifValidGetUUID(String uuid) throws InvalidIdException {
        UUID id;
        try {
            id = UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            throw new InvalidIdException(e.getMessage());
        }

        return id;
    }

    // TODO need to use regex here, as apprently fromString is limited.
    //  https://stackoverflow.com/questions/20041051/how-to-judge-a-string-is-uuid-type
    public static void throwIfNotValid(String uuid) throws InvalidIdException {
        try {
            UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            throw new InvalidIdException(e.getMessage());
        }
    }
}
