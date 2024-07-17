package dev.sudhamsh.runners.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
        int id,
        @NotEmpty
        int distance,
        @Positive
        int duration,
        Location location,
        String data_d
)//immutiable objects
{
    public Run{
        if(duration<0){
            throw new IllegalArgumentException("Error");
        }
    }
}
