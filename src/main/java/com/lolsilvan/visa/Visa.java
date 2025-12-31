package com.lolsilvan.visa;

public record Visa (
        String name,
        VisaRequirement requirements,
        VisaPermission permissions,
        VisaStayDuration stayDuration,
        VisaRenewal renewal
) { }
