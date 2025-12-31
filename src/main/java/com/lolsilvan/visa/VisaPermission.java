package com.lolsilvan.visa;

public record VisaPermission (
        boolean unlimitedEntries,
        boolean allowedToWorkInCountry,
        boolean allowedToWorkRemotely
) { }
