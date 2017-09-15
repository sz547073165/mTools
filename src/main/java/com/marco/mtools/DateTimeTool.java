package com.marco.mtools;

import java.time.Instant;

public class DateTimeTool {
    public static Long getSecond(){
        return Instant.now().getEpochSecond();
    }
}
