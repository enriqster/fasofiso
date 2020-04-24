package com.zetinc.rest;

import lombok.Builder;

import java.util.Date;

@Builder
public class Ticket {
    private final long id;
    private final String subject;
    private final String detail;
    private final Date createDate;
}
